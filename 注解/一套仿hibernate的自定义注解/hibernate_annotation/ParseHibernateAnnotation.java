package hibernate_annotation;

import java.lang.reflect.Method;

import hibernate_annotation.MyColumn;
import hibernate_annotation.MyEntity;
import hibernate_annotation.MyGeneratedValue;
import hibernate_annotation.MyId;
import hibernate_annotation.MyTable;
import pojo.Hero;

/**
 * @author Younker
 *
 * 2019年6月5日
 * 
 * 做一套仿hibernate的自定义注解，并解析其信息，来演示hibernate注解方式是如何工作的。
 * 
 * hibernate有两种配置方式，分别是*.hbm.xml 配置方式 和注解方式。 虽然方式不一样，但是都是用于解决如下问题：
 * 1. 当前类是否实体类
 * 2. 对应的表名称
 * 3. 主键对应哪个属性， 自增长策略是什么，对应字段名称是什么
 * 4. 非主键属性对应字段名称是什么
 * 
 * 创建一个解析类ParseHibernateAnnotation ，获取Hero类上配置的注解信息，其运行结果如图所示。
 * 思路如下：
 * 1. 首先获取Hero.class类对象
 * 2. 判断本类是否进行了MyEntity 注解
 * 3. 获取注解 MyTable
 * 4. 遍历所有的方法，如果某个方法有MyId注解，那么就记录为主键方法primaryKeyMethod 
 * 5. 把主键方法的自增长策略注解MyGeneratedValue和对应的字段注解MyColumn 取出来，并打印
 * 6. 遍历所有非主键方法，并且有MyColumn注解的方法，打印属性名称和字段名称的对应关系。
 */
public class ParseHibernateAnnotation {

	public static void main(String[] args) {

		Class<Hero> clazz = Hero.class;
		MyEntity myEntity = (MyEntity) clazz.getAnnotation(MyEntity.class);
		if (null == myEntity) {
			System.out.println("Hero类不是实体类");
		} else {
			System.out.println("Hero类是实体类");
			MyTable myTable= (MyTable) clazz.getAnnotation(MyTable.class);
			String tableName = myTable.name();
			System.out.println("其对应的表名是:" + tableName);
			Method[] methods =clazz.getMethods();
			Method primaryKeyMethod = null;
			for (Method m: methods) {
				MyId myId = m.getAnnotation(MyId.class);
				if(null!=myId){
					primaryKeyMethod = m;
					break;
				}
			}
			
			if(null!=primaryKeyMethod){
				System.out.println("找到主键：" + method2attribute( primaryKeyMethod.getName() ));
				MyGeneratedValue myGeneratedValue =
				primaryKeyMethod.getAnnotation(MyGeneratedValue.class);
				System.out.println("其自增长策略是：" +myGeneratedValue.strategy());
				MyColumn myColumn = primaryKeyMethod.getAnnotation(MyColumn.class);
				System.out.println("对应数据库中的字段是：" +myColumn.value());
			}
			System.out.println("其他非主键属性分别对应的数据库字段如下：");
			for (Method m: methods) {
				if(m==primaryKeyMethod){
					continue;
				}
				MyColumn myColumn = m.getAnnotation(MyColumn.class);
				//那些setter方法上是没有MyColumn注解的
				if(null==myColumn)
					continue;
				System.out.format("属性： %s\t对应的数据库字段是:%s%n",method2attribute(m.getName()),myColumn.value());

			}
			
		}
		
	}

	private static String method2attribute(String methodName) {
		String result = methodName; ;
		result = result.replaceFirst("get", "");
		result = result.replaceFirst("is", "");
		if(result.length()<=1){
			return result.toLowerCase();
		}
		else{
			return result.substring(0,1).toLowerCase() + result.substring(1,result.length());
		}
		
	}
}
