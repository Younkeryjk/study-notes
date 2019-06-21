# Spring

> IOC/DI

Spring是一个基于IOC和AOP的结构J2EE系统的框架

IOC翻转控制 是Spring的基础，Inversion Of Control；简单说就是创建对象以前的程序员自己new构造方法来调用，变成了交由Spring创建对象。就像控制权从本来在自己手里，交给了Spring。 

**传统方式：**相当于你自己去菜市场new 了一只鸡，不过是生鸡，要自己拔毛，去内脏，再上花椒，酱油，烤制，经过各种工序之后，才可以食用。

**用 IOC：**相当于去馆子(Spring)点了一只鸡，交到你手上的时候，已经五味俱全，你就只管吃就行了。

DI依赖注入Dependency Inject；简单说就是拿到的对象的属性，已经被注入好相关值了，直接使用即可。

**注：基于框架的程序要成功运行，对于JAR包的版本，配置文件的正确性有着苛刻的要求，任何一个地方出错了，都会导致框架程序运行失败。**

> 注入对象

```
 <bean name="c" class="com.how2java.pojo.Category">
 	<property name="name" value="category 1" />
 </bean>
 <bean name="p" class="com.how2java.pojo.Product">
 <property name="name" value="product1" />
 	<property name="category" ref="c" />
 </bean>
```

在创建Product的时候注入一个Category对象，注意，这里要使用ref来注入另一个对象

> 注解方式IOC/DI

```
<context:annotation-config/>
    <bean name="c" class="com.how2java.pojo.Category">
        <property name="name" value="category 1" />
    </bean>
    <bean name="p" class="com.how2java.pojo.Product">
        <property name="name" value="product1" />
<!--         <property name="category" ref="c" /> -->
    </bean>
```

在Product.java的category属性前加上@Autowired注解

```
@Autowired
private Category category;
```

除了前面的 [在属性前加上@Autowired](http://how2j.cn/k/spring/spring-annotation-ioc-di/1067.html#step4076) 这种方式外，也可以在setCategory方法前加上@Autowired，这样来达到相同的效果

```
@Autowired
public void setCategory(Category category) 
```

除了@Autowired之外，@Resource也是常用的手段

```
@Resource(name="c")
private Category category;
```

- 对Bean的注解

上面是**注入对象行为**的注解，bean对象本身，比如Category,Product也可以移出applicationContext.xml配置文件，也通过注解进行

修改applicationContext.xml，什么都去掉，只新增：

```
<context:component-scan base-package="com.how2java.pojo"/>
```

为Product类加上@Component注解，即表明此类是bean

```
@Component("p")
public class Product {
```

为Category 类加上@Component注解，即表明此类是bean

```
@Component("c")
public class Category {
```

因为配置从applicationContext.xml中移出来了，所以属性初始化放在属性声明上进行了。

private String name="product 1";

private String name="category 1";

> AOP

AOP即Aspect Oriented Program 面向切面编程 

在面向切面编程的思想里面，把功能分为**核心业务功能**，和**周边功能**。

所谓的核心业务，比如登陆，增加数据，删除数据都叫核心业务

所谓的周边功能，比如性能统计，日志，事务管理等等 

周边功能在Spring的面向切面编程AOP思想里，即被定义为**切面**

在面向切面编程AOP的思想里面，核心业务功能和切面功能分别**独立进行开发**

然后把切面功能和核心业务功能 **"编织"** 在一起，这就叫AOP

Object object = joinPoint.proceed();

就是将来与某个核心功能编织之后，用于执行核心功能的代码

声明业务对象：

```
<bean name="s" class="com.how2java.service.ProductService">
</bean>  
```

声明日志切面：

```
<bean id="loggerAspect" class="com.how2java.aspect.LoggerAspect"/>
```

指定核心业务功能：

```
<aop:pointcut id="loggerCutpoint" 
		expression=
		"execution(* com.how2java.service.ProductService.*(..)) "/>
```

指定辅助功能：

```
<aop:aspect id="logAspect" ref="loggerAspect">
	<aop:around pointcut-ref="loggerCutpoint" method="log"/>
</aop:aspect>
```

然后通过aop:config把业务对象与辅助功能编织在一起

execution(* com.how2java.service.ProductService.*(..)) 

这表示对满足如下条件的方法调用，进行切面操作：
***** 返回任意类型
**com.how2java.service.ProductService.\*** 包名以 com.how2java.service.ProductService 开头的类的任意方法
**(..)** 参数是任意数量和类型

> 注解方式 AOP

- 注解配置业务类：

例：使用@Component("s") 注解ProductService 类

- 注解配置切面：

@Aspect 注解表示这是一个切面

@Component 表示这是一个bean,由Spring进行管理

@Around(value = "execution(* com.how2java.service.ProductService.*(..))") 表示对com.how2java.service.ProductService 这个类中的所有方法进行切面操作

- applicationContext.xml

  扫描包com.how2java.aspect和com.how2java.service，定位业务类和切面类：

```
<context:component-scan base-package="com.how2java.aspect"/>
<context:component-scan base-package="com.how2java.service"/>
```

找到被注解了的切面类，进行切面配置：

```
<aop:aspectj-autoproxy/>  
```

> 注解方式测试

- 所需jar包：junit-4.12.jar和hamcrest-all-1.3.jar

- @RunWith(SpringJUnit4ClassRunner.class) 

  表示这是一个Spring的测试类

- @ContextConfiguration("classpath:applicationContext.xml")

  定位Spring的配置文件

- @Autowired

  给这个测试类装配Category对象

- @Test

  测试逻辑