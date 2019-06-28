# SSM

> SSM整合

1. 数据库部分

   - 创建数据库
   - 创建表
   - 准备数据

2. 使用dynamic web project的方式创建项目

3. 导入jar包到WebContent/WEB-INF/lib目录下

4. 创建pojo包下的类(相当于数据库里的表)

   ```
   public class Category {
       private int id;
       private String name;
       public int getId() {
           return id;
       }
       public void setId(int id) {
           this.id = id;
       }
       public String getName() {
           return name;
       }
       public void setName(String name) {
           this.name = name;
       }
       @Override
       public String toString() {
           return "Category [id=" + id + ", name=" + name + "]";
       }
   }
   ```

5. 创建mapper包下的接口(相当于Dao)

   ```
   public interface CategoryMapper {
     
       public int add(Category category); 
           
       public void delete(int id); 
           
       public Category get(int id); 
         
       public int update(Category category);  
           
       public List<Category> list();
        
       public int count(); 
        
   }
   ```

6. 创建mapper对应的xml

   - xml需要和mapper放在同一个包下面
   - 并且namespace必须写mapper的完整类名

   ```
   <mapper namespace="com.how2java.mapper.CategoryMapper">
           <insert id="add" parameterType="Category" >
               insert into category_ ( name ) values (#{name})   
           </insert>
            
           <delete id="delete" parameterType="Category" >
               delete from category_ where id= #{id}  
           </delete>
            
           <select id="get" parameterType="_int" resultType="Category">
               select * from   category_  where id= #{id}   
           </select>
    
           <update id="update" parameterType="Category" >
               update category_ set name=#{name} where id=#{id}   
           </update>
           <select id="list" resultType="Category">
               select * from   category_     
           </select>    
       </mapper>
   ```

7. 创建service接口

   ```
   public interface CategoryService {
       List<Category> list();
   }
   ```

8. 创建实现service接口的类

   ```
   @Service
   public class CategoryServiceImpl  implements CategoryService{
       @Autowired
       CategoryMapper categoryMapper;
       public List<Category> list(){
           return categoryMapper.list();
       }
   }
   ```

   - CategoryServiceImpl被注解@Service标示为一个Service
   - 并且装配了categoryMapper

9. 创建Controller

   ```
   // 告诉spring mvc这是一个控制器类
   @Controller
   @RequestMapping("")
   public class CategoryController {
       @Autowired
       CategoryService categoryService;
    
       @RequestMapping("listCategory")
       public ModelAndView listCategory(){
           ModelAndView mav = new ModelAndView();
           List<Category> cs= categoryService.list();
           // 放入转发参数
           mav.addObject("cs", cs);
           // 放入jsp路径
           mav.setViewName("listCategory");
           return mav;
       }
   }
   ```

   - CategoryController被@Controller标示为了控制器
   - 自动装配了categoryService
   - 通过@RequestMapping映射访问路径/listCategory路径到方法listCategory()。
   - 在listCategory()方法中，通过categoryService获取后，然后存放在"cs"这个key上。

10. web.xml

    在WEB-INF目录下新增加web.xml，这个web.xml有两个作用：

    1. 通过ContextLoaderListener在web app启动的时候，获取contextConfigLocation配置文件的文件名applicationContext.xml，并进行Spring相关初始化工作
    2.  有任何访问，都被DispatcherServlet所拦截，这就是Spring MVC那套工作机制了。

    ```
     <!-- spring的配置文件-->
    <context-param>
    	<param-name>contextConfigLocation</param-name>
    	<param-value>classpath:applicationContext.xml</param-value>
    </context-param>
    <listener>
    	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    
    <!-- spring mvc核心：分发servlet -->
    <servlet>
    	<servlet-name>mvc-dispatcher</servlet-name>
    	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    	<!-- spring mvc的配置文件 -->
    	<init-param>
    	    <param-name>contextConfigLocation</param-name>
    	    <param-value>classpath:springMVC.xml</param-value>
    	</init-param>
    	<load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
    	<servlet-name>mvc-dispatcher</servlet-name>
    	<url-pattern>/</url-pattern>
    </servlet-mapping>
    ```

11. applicationContext.xml

    在src目录下新建applicationContext.xml文件，这是Spring的配置文件

    ```
    <context:annotation-config />
        <context:component-scan base-package="com.how2java.service" />
     
        <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource"> 
          <property name="driverClassName"> 
              <value>com.mysql.jdbc.Driver</value> 
          </property> 
          <property name="url"> 
              <value>jdbc:mysql://localhost:3306/how2java?characterEncoding=UTF-8</value> 
         
          </property> 
          <property name="username"> 
              <value>root</value> 
          </property> 
          <property name="password"> 
              <value>admin</value> 
          </property>    
        </bean>
         
        <bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
            <property name="typeAliasesPackage" value="com.how2java.pojo" />
            <property name="dataSource" ref="dataSource"/>
            <property name="mapperLocations" value="classpath:com/how2java/mapper/*.xml"/>
        </bean>
     
        <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
            <property name="basePackage" value="com.how2java.mapper"/>
        </bean>
    ```

    这个文件的作用有：

    1. 通过注解，将Service的生命周期纳入Spring的管理

       ```
       <context:annotation-config />
       <context:component-scan base-package="com.how2java.service" />
       ```

    2. 配置数据源

       ```
       <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
       <property name="driverClassName"> 
                 <value>com.mysql.jdbc.Driver</value> 
             </property> 
             <property name="url"> 
                 <value>jdbc:mysql://localhost:3306/how2java?characterEncoding=UTF-8</value> 
            
             </property> 
             <property name="username"> 
                 <value>root</value> 
             </property> 
             <property name="password"> 
                 <value>admin</value> 
             </property>    
       </bean>
       ```

    3. 扫描存放SQL语句的xml

       ```
       <bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
       	<property name="typeAliasesPackage" value="com.how2java.pojo" />
       	<property name="dataSource" ref="dataSource"/>
       	<property name="mapperLocations" value="classpath:com/how2java/mapper/*.xml"/>
       </bean>
       ```

    4. 扫描Mapper，并将其生命周期纳入Spring的管理

       ```
       <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
       	<property name="basePackage" value="com.how2java.mapper"/>
       </bean>
       ```

12. springMVC.xml

    在src目录下新建springMVC.xml

    ```
    <context:annotation-config/>
     
    <context:component-scan base-package="com.how2java.controller">
    	<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
    
    <mvc:annotation-driven />
    <mvc:default-servlet-handler />
    
    <!-- 视图定位 -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    	<property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
    	<property name="prefix" value="/WEB-INF/jsp/" />
    	<property name="suffix" value=".jsp" />
    </bean>
    ```

    作用有4：

    1. 扫描Controller,并将其生命周期纳入Spring管理

       ```
       <context:annotation-config/>
           <context:component-scan base-package="com.how2java.controller">
                 <context:include-filter type="annotation" 
                 expression="org.springframework.stereotype.Controller"/>
           </context:component-scan>
       ```

    2. 注解驱动，以使得访问路径与方法的匹配可以通过注解配置

       ```
       <mvc:annotation-driven />
       ```

    3.  静态页面，如html,css,js,images可以访问

       ```
       <mvc:default-servlet-handler />
       ```

    4. 视图定位到/WEB/INF/jsp 这个目录下

       ```
       <bean  class="org.springframework.web.servlet.view.InternalResourceViewResolver">
       	<property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
       	<property name="prefix" value="/WEB-INF/jsp/" />
       	<property name="suffix" value=".jsp" />
       </bean>
       ```

13. 模板文件

    在WEB-INF下创建jsp目录，并创建模板文件

14. 部署在tomcat中

15. 流程总结

    1. 首先浏览器上访问路径 /listCategory
    2. tomcat根据web.xml上的配置信息，拦截到了/listCategory，并将其交由DispatcherServlet处理。
    3.  DispatcherServlet 根据springMVC的配置，将这次请求交由CategoryController类进行处理，所以需要进行这个类的实例化。
    4. 在实例化CategoryController的时候，注入CategoryServiceImpl。 (自动装配实现了CategoryService接口的的实例，只有CategoryServiceImpl实现了CategoryService接口，所以就会注入CategoryServiceImpl)
    5. 在实例化CategoryServiceImpl的时候，又注入CategoryMapper
    6. 根据ApplicationContext.xml中的配置信息，将CategoryMapper和Category.xml关联起来了。
    7. 这样拿到了实例化好了的CategoryController,并调用 list 方法
    8. 在list方法中，访问CategoryService,并获取数据，并把数据放在"cs"上，接着服务端跳转到listCategory.jsp去
    9. 最后在listCategory.jsp 中显示数据

> 分页

- 分页类

  ```
  public class Page {
   
      int start=0;
      int count = 5;
      int last = 0;
      public int getStart() {
          return start;
      }
      public void setStart(int start) {
          this.start = start;
      }
      public int getCount() {
          return count;
      }
      public void setCount(int count) {
          this.count = count;
      }
      public int getLast() {
          return last;
      }
      public void setLast(int last) {
          this.last = last;
      }
       
      public void caculateLast(int total) {
          // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
          if (0 == total % count)
              last = total - count;
          // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
          else
              last = total - total % count;      
      }
   
  }
  ```

  start: 开始位置
  count: 每页的个数
  last: 最后一页的位置
  caculateLast()方法: 通过总数total和每页的个数计算出最后一页的位置

- Category.xml

  修改list，根据当有分页信息的时候，进行分页查询
  增加total sql语句

  ```
  <select id="list" resultType="Category">
      select * from   category_     
      <if test="start!=null and count!=null">
  	    limit #{start},#{count}
      </if>
  </select>
  <select id="total" resultType="int">
      select count(*) from   category_     
  </select>
  ```

- CategoryMapper

  增加total方法用于调用[Category.xml](http://how2j.cn/k/ssm/ssm-pagination/1139.html#step4547) 中total对应的sql语句
  增加 list(Page page)，根据分页来查询数据

  ```
  public List<Category> list(Page page);
  public int total();
  ```

- CategoryService

  增加total用于获取所有
  增加 list(Page page)，根据分页来查询数据

  ```
  int total();
  List<Category> list(Page page);
  ```

- CategoryServiceImpl

  实现total()和list(Page page) 方法

  ```
  @Override
  public List<Category> list(Page page) {
  	return categoryMapper.list(page);
  }
  @Override
  public int total() {
  	return categoryMapper.total();
  }  
  ```

- CategoryController

  ```
  @RequestMapping("listCategory")
  public ModelAndView listCategory(Page page){
  	ModelAndView mav = new ModelAndView();
  	List<Category> cs= categoryService.list(page);
  	int total = categoryService.total();
  	page.caculateLast(total);
  	// 放入转发参数
  	mav.addObject("cs", cs);
  	// 放入jsp路径
  	mav.setViewName("listCategory");
  	return mav;
  } 
  ```

  修改listCategory，接受分页信息的注入：

  ```
   listCategory(Page page)
  ```

  根据分页对象，进行查询获取对象集合cs：

  ```
  List<Category> cs= categoryService.list(page);
  ```

  根据总数，计算出最后一页的信息：

  ```
  int total = categoryService.total();
  ```

- listCategory.jsp

  分别提供首页，上一页，下一页，末页等连接

  ```
  <div style="text-align:center">
  	<a href="?start=0">首  页</a>
  	<a href="?start=${page.start-page.count}">上一页</a>
  	<a href="?start=${page.start+page.count}">下一页</a>
  	<a href="?start=${page.last}">末  页</a>
  </div>
  ```

> PageHelper

- jar包

  把pagehelper-5.1.0-beta2.jar，jsqlparser-1.0.jar复制到WEB-INF/lib下，导入到项目

- 修改applicationContext.xml

  ```
  <property name="plugins">
  	<array>
  		<bean class="com.github.pagehelper.PageInterceptor">
  			<property name="properties">
  				  <!--使用下面的方式配置参数，一行配置一个 -->
  				  <value>
  				  </value>
  			</property>
  		</bean>
  	</array>
  </property>
  ```

- CategoryService、CategoryServiceImpl、CategoryMapper去掉total方法和list(Page) 方法

- Category.xml去掉total对应的sql语句，list也去掉limit

- CategoryController

  ```
  @RequestMapping("listCategory")
  public ModelAndView listCategory(Page page){
  	ModelAndView mav = new ModelAndView();
  	PageHelper.offsetPage(page.getStart(),5);
  	List<Category> cs= categoryService.list();
  	int total = (int) new PageInfo<>(cs).getTotal();
  	 
  	page.caculateLast(total);
  	 
  	// 放入转发参数
  	mav.addObject("cs", cs);
  	// 放入jsp路径
  	mav.setViewName("listCategory");
  	return mav;
  } 
  ```

  CategoryController在调用categoryService.list(); 之前，执行：

  ```
  PageHelper.offsetPage(page.getStart(),5);
  ```

  并通过int total = (int) new PageInfo<>(cs).getTotal();获取总数。
  其他都不变

> 连接池

- 修改applicationContext.xml

  ```
  <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">
          <!-- 基本属性 url、user、password -->
          <property name="url" value="jdbc:mysql://localhost:3306/how2java?characterEncoding=UTF-8" />
          <property name="username" value="root" />
          <property name="password" value="admin" />
          <property name="driverClassName" value="com.mysql.jdbc.Driver" />
   
          <!-- 配置初始化大小、最小、最大 -->
          <property name="initialSize" value="3" />
          <property name="minIdle" value="3" />
          <property name="maxActive" value="20" />
   
          <!-- 配置获取连接等待超时的时间 -->
          <property name="maxWait" value="60000" />
   
          <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
          <property name="timeBetweenEvictionRunsMillis" value="60000" />
   
          <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
          <property name="minEvictableIdleTimeMillis" value="300000" />
   
          <property name="validationQuery" value="SELECT 1" />
          <property name="testWhileIdle" value="true" />
          <property name="testOnBorrow" value="false" />
          <property name="testOnReturn" value="false" />
   
          <!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
          <property name="poolPreparedStatements" value="true" />
          <property name="maxPoolPreparedStatementPerConnectionSize" value="20" />
  </bean>
  ```

> CRUD

> 事务管理

- MYSQL 表的类型必须是INNODB才支持事务

  修改表的类型为INNODB的SQL：

  ```
  alter table category_ ENGINE  = innodb;
  ```

  查看表的类型的SQL：

  ```
  show table status from how2java; 
  ```

- 导入JAR包

  导入aspectjweaver.jar

- 进行事务配置

  修改applicationContext.xml，添加事务管理器和事务注解扫描器

  ```
  <tx:annotation-driven transaction-manager="transactionManager"/>
      <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
          <property name="dataSource" ref="dataSource" />
      </bean>
  ```

- 使用注解方式

  ```
  @Override
  @Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
  public void addTwo() {
  	Category c1 = new Category();
  	c1.setName("短的名字");
  	categoryMapper.add(c1);
  
  	Category c2 = new Category();
  	c2.setName("名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,");
  	categoryMapper.add(c2);
  }
  ```

- 使用XML配置方式

  ```
  <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
  	<property name="dataSource" ref="dataSource" />
  </bean>
       
  <tx:advice id="txadvice" transaction-manager="transactionManager"> 
  	<tx:attributes> 
  		<tx:method name="add*" propagation="REQUIRED" rollback-for="Exception" /> 
  		<tx:method name="del*" propagation="REQUIRED" rollback-for="Exception"/>
  		<tx:method name="edit*" propagation="REQUIRED" rollback-for="Exception" />
  		<tx:method name="update*" propagation="REQUIRED" rollback-for="Exception"/> 
  		<tx:method name="list*" propagation="REQUIRED" rollback-for="Exception"/> 
  	</tx:attributes> 
  </tx:advice> 
  
  <aop:config> 
  	<aop:pointcut id="serviceMethod" expression="execution(* com.how2java.service.*.*(..))"/> 
  	<aop:advisor pointcut-ref="serviceMethod" advice-ref="txadvice"/> 
  </aop:config>
  ```

> JSON

- json中文问题

  修改springMVC.xml：

  ```
  <mvc:annotation-driven >
  	   <mvc:message-converters register-defaults="true">
  	      <bean class="org.springframework.http.converter.StringHttpMessageConverter">
  	         <property name="supportedMediaTypes" value="text/plain;charset=UTF-8" />
  	      </bean>
  	   </mvc:message-converters>    
      </mvc:annotation-driven>
  ```

- CategoryController

  控制器里提供3个方法，分别用来处理json 提交，json获取单个对象，json获取多个对象

  ```
  @Controller
  @RequestMapping("")
  public class CategoryController {
      @ResponseBody
      @RequestMapping("/submitCategory")
      public String submitCategory(@RequestBody Category category) {
          System.out.println("SSM接受到浏览器提交的json，并转换为Category对象:"+category);
          return "ok";
      }
       
      @ResponseBody
      @RequestMapping("/getOneCategory")
      public String getOneCategory() {
           Category c = new Category();
           c.setId(100);
           c.setName("第100个分类");
           JSONObject json= new JSONObject();
           json.put("category", JSONObject.toJSON(c));
           return json.toJSONString();
      }
  
      @ResponseBody
      @RequestMapping("/getManyCategory")
      public String getManyCategory() {
          List<Category> cs = new ArrayList<>();
          for (int i = 0; i < 10; i++) {
              Category c = new Category();
              c.setId(i);
              c.setName("分类名称:"+i);
              cs.add(c);
          }
          return JSONObject.toJSON(cs).toString();
      }
  }   
  ```

- submit.html

  ```
  <script> 
      $('#sender').click(function(){ 
          var id=document.getElementById('id').value; 
          var name=document.getElementById('name').value; 
          var category={"name":name,"id":id}; 
          var jsonData = JSON.stringify(category);
          var page="submitCategory"; 
           
          $.ajax({
                 type:"post",
                 url: page,
                 data:jsonData,
                 dataType:"json",
                 contentType : "application/json;charset=UTF-8",
                 success: function(result){
                 }
              });
             alert("提交成功，请在Tomcat控制台查看服务端接收到的数据");
   
      });
  </script> 
  ```

- getOne.html

  ```
  <script> 
      $('#sender').click(function(){ 
          var url="getOneCategory"; 
          $.post(
                  url,
                  function(data) {
                       var json=JSON.parse(data); 
                       var name =json.category.name; 
                       var id = json.category.id;
                       $("#messageDiv").html("分类id："+ id + "<br>分类名称:" +name );
                         
           });  
      }); 
  </script> 
  ```

- getMany.html

  ```
  <script> 
      $('#sender').click(function(){ 
          var url="getManyCategory"; 
          $.post(
                  url,
                  function(data) {
                      console.log(data);
                      var categorys = $.parseJSON(data);
                      console.log(categorys.length);
   
                       for(i in categorys){
                           var old = $("#messageDiv").html();
                           var category = categorys[i];
                           $("#messageDiv").html(old + "<br>"+category.id+"   -----   "+category.name); 
                       }
           });  
      }); 
  </script> 
  ```

> restful风格

- 使用同一个url，但是**约定**不同的method来实施不同的业务

|      | 传统风格                        |        | Restful风格     |        |
| ---- | ------------------------------- | ------ | --------------- | ------ |
|      | url                             | method | url             | method |
| 增加 | /addCategory?name=xxx           | POST   | /categories     | POST   |
| 删除 | /deleteCategory?id=123          | GET    | /categories/123 | DELETE |
| 修改 | /updateCategory?id=123&name=yyy | POST   | /categories/123 | PUT    |
| 获取 | /getCategory?id=123             | GET    | /categories/123 | GET    |
| 查询 | /listCategory                   | GET    | /categories     | GET    |

- web.xml

  SpringMVC 只能处理post和get,为了还原对put和delete的处理，web.xml里面要加如下过滤器

  ```
  <filter>
     <filter-name>HiddenHttpMethodFilter</filter-name>
     <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
  </filter>
  <filter-mapping>
     <filter-name>HiddenHttpMethodFilter</filter-name>
     <url-pattern>/*</url-pattern>
  </filter-mapping>
  ```

- CRUD之_method

  增加分类：

  ```
   <form method="POST" action="categories">
  	分类名称： <input name="name" value="" type="text"> <br><br>
      <input type="submit" value="增加分类">
  </form>
  ```

  删除分类：

  ```
  <td><a class="delete" href="categories/${c.id}">删除</a></td>
  <form id="formdelete" action="" method="POST" >
  	<input type="hidden" name="_method" value="DELETE">
  </form>
  ```

  修改分类：

  ```
  <form method="post" action="../categories/${c.id}">
  	<input type="hidden" name="_method" value="PUT">
  	分类名称： <input name="name" value="${c.name}" type="text"> <br><br>
  	<input type="submit" value="修改分类">
  </form>
  ```

- CategoryController

  Controller的RequestMapping都修改为了/categories,只是method各不相同。

  - 查询分类：

    ```
    @RequestMapping(value="/categories",method=RequestMethod.GET)
        public ModelAndView listCategory(Page page){
    ```

  - 增加分类：

    ```
    @RequestMapping(value="/categories",method=RequestMethod.POST)
        public ModelAndView addCategory(Category category){
    ```

  - 删除分类：

    ```
    @RequestMapping(value="/categories/{id}",method=RequestMethod.DELETE)
        public ModelAndView deleteCategory(Category category){
    ```

  - 编辑分类(获取分类)：

    ```
    @RequestMapping(value="/categories/{id}",method=RequestMethod.GET)
        public ModelAndView editCategory(Category category){
    ```

  - 修改分类：

    ```
    @RequestMapping(value="/categories/{id}",method=RequestMethod.PUT)
        public ModelAndView updateCategory(Category category){
    ```