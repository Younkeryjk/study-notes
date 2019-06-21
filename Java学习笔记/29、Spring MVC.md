# Spring MVC

> Hello SpringMVC

1. 使用dynamic web project的方式创建项目

2. 导入jar包到 e:/project/springmvc/WebContent/WEB-INF/lib目录下

3. 在WEB-INF目录下创建 web.xml，配置Spring MVC的入口 **DispatcherServlet**，把所有的请求都提交到该Servlet

   ```
   <servlet>
       <servlet-name>springmvc</servlet-name>
       <servlet-class>
       	org.springframework.web.servlet.DispatcherServlet
       </servlet-class>
       <load-on-startup>1</load-on-startup>
   </servlet>
   <servlet-mapping>
       <servlet-name>springmvc</servlet-name>
       <url-pattern>/</url-pattern>
   </servlet-mapping>
   ```

   注意：<servlet-name>**springmvc**</servlet-name>

   **springmvc**这个名字在下一步会用到  

4. 创建springmvc-servlet.xml

   在WEB-INF目录下创建 springmvc-servlet.xml，springmvc-servlet.xml 与上一步中的

   <servlet-name>springmvc</servlet-name> **springmvc**对应

   ```
   <beans>
       <bean id="simpleUrlHandlerMapping"
           class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
           <property name="mappings">
               <props>
                   <prop key="/index">indexController</prop>
               </props>
           </property>
       </bean>
       <bean id="indexController" class="controller.IndexController"></bean>
   </beans>
   ```

   这是Spring MVC的 映射配置文件
   表示访问路径**/index**会交给id=indexController的bean处理
   id=indexController的bean配置为类：**IndexController**

5. 控制类 IndexController

   控制类 IndexController实现接口Controller ，提供方法handleRequest处理请求

   SpringMVC通过 ModelAndView 对象把模型和视图结合在一起  

   ```
   ModelAndView mav = new ModelAndView("index.jsp");
   mav.addObject("message", "Hello Spring MVC");
   ```

   表示视图是index.jsp
   模型数据是 message，内容是 “Hello Spring MVC”

6. 准备index.jsp

   在WebContent目录下创建index.jsp

7. 部署在tomcat中

   启动Tomcat-Run On Server

8. 流程步骤：

   1. 用户访问 /index
   2. 根据web.xml中的配置 所有的访问都会经过DispatcherServlet
   3. 根据 根据配置文件springmvc-servlet.xml ，访问路径/index
      会进入IndexController类
   4. 在IndexController中指定跳转到页面index.jsp，并传递message数据
   5. 在index.jsp中显示message信息

> 视图定位

```
	new ModelAndView("index.jsp"); 
```

​	如果代码写成这样，就表示跳转到页面 index.jsp 

​	所谓的视图定位，指的是代码还是写成这样，但是会跳转到 /WEB-INF/page/index.jsp：

```
new ModelAndView("index");
```

1. 修改springmvc-servlet.xml，增加

   ```
   <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
      <property name="prefix" value="/WEB-INF/page/" />
      <property name="suffix" value=".jsp" />
   </bean>
   ```

   其作用是把视图约定在 **/WEB-INF/page/\*.jsp** 这个位置

2. 修改IndexController

   把IndexController类的这一行代码

   ```
   ModelAndView mav = new ModelAndView("index.jsp");
   ```

   修改为

   ```
   ModelAndView mav = new ModelAndView("index")
   ```

3. 移动index.jsp

   在WEB-INF下新建目录page，把index.jsp移动到 WEB-INF/page 目录下

> 注解方式

1. 修改IndexController

   - 在类前面加上**@Controller** 表示该类是一个控制器

   - 在方法handleRequest 前面加上 **@RequestMapping("/index")** 表示路径/index会映射到该方法上

     **注意**：**不再**让IndexController实现Controller接口

2. 修改springmvc-servlet.xml

   去掉映射相关的配置，因为已经使用**注解方式**了

   增加

   ```
   <context:component-scan base-package="controller" />
   ```

   表示从包controller下扫描有**@Controller**注解的类

   ```
   <context:component-scan base-package="controller" />
       <bean id="irViewResolver"
           class="org.springframework.web.servlet.view.InternalResourceViewResolver">
           <property name="prefix" value="/WEB-INF/page/" />
           <property name="suffix" value=".jsp" />
       </bean>
   <!--     <bean id="simpleUrlHandlerMapping" -->
   <!--         class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping"> -->
   <!--         <property name="mappings"> -->
   <!--             <props> -->
   <!--                 <prop key="/index">indexController</prop> -->
   <!--             </props> -->
   <!--         </property> -->
   <!--     </bean> -->
   <!--     <bean id="indexController" class="controller.IndexController"></bean> -->
   ```

> 接收表单数据

1. 创建实体类

2. 在**web目录下** （不是在WEB-INF下）增加提交数据的页面

3. 根据spring的配置文件(比如springmvc-servlet.xml)扫码controller目录下匹配的@RequestMapping

4. 接收实体参数 如：

   ```
   public ModelAndView add(Product product) {
   ```

   **注：** [addProduct.jsp](http://how2j.cn/k/springmvc/springmvc-form/618.html#step1912) 提交的name和price会自动注入到参数 product里

   **注：** 参数product会默认被当做值加入到ModelAndView 中，相当于：

   ```
   mav.addObject("product",product);
   ```

5. 根据模型数据，渲染视图的数据

> 客户端跳转

```
ModelAndView mav = new ModelAndView("redirect:/index");
```

​	redirect:/index 即表示客户端跳转的意思

> Session

- session.getAttribute 获取Session
- session.setAttribute 设置Session

> 中文问题

```
<filter> 
    <filter-name>CharacterEncodingFilter</filter-name> 
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class> 
    <init-param> 
        <param-name>encoding</param-name> 
        <param-value>utf-8</param-value> 
    </init-param> 
</filter> 
<filter-mapping> 
    <filter-name>CharacterEncodingFilter</filter-name> 
    <url-pattern>/*</url-pattern> 
</filter-mapping>    
```

> 上传文件

- 配置web.xml允许访问*.jpg：

```
<servlet-mapping>
	<servlet-name>default</servlet-name>
	<url-pattern>*.jpg</url-pattern>
</servlet-mapping>
```

​	因为配置springmvc的servlet的时候，使用的路径是**"/"**，导致静态资源在默认情况下不能访问，所以要加上这	一段，允许访问jpg。 **并且必须加在springmvc的servlet之前**。

​	如果你配置spring-mvc使用的路径是/*.do，就不会有这个问题了。

- 配置springmvc-servlet.xml

  ```
  <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
  ```

  新增加一段配置，开放对上传功能的支持

- 上传页面

  需要注意的是form 的两个属性必须提供：

  1. method="post"
  2. enctype="multipart/form-data" 

  ```
  <input type="file" name="image" accept="image/*" /> 
  ```

  属性 **accept="image/\*"** 表示只能选择图片进行上传

- 准备UploadedImageFile

  在UploadedImageFile中封装MultipartFile类型的字段 image ，用于接受页面的注入

  这里的字段 image必须和上传页面upload.jsp中的image
  <input type="file" name="**image**" accept="image/*" />
  保持一致

- UploadController 上传控制器

  - 方法的第二个参数UploadedImageFile 中已经注入好了 image
  - 根据request.getServletContext().getRealPath 获取到web目录下的image目录，用于存放上传后的文件。
  - 调用file.getImage().transferTo(newFile); 复制文件


> 拦截器

- 拦截器类需要继承HandlerInterceptorAdapter

- preHandle 在业务处理器处理请求之前被调用

  ```
   public boolean preHandle(HttpServletRequest request,   
              HttpServletResponse response, Object handler)
  ```

  如果返回false，执行配置文件中上一个拦截器的afterCompletion方法，然后以此往前。自身拦截器的afterCompletion方法不会执行；

  如果返回true，执行下一个拦截器，直到所有的拦截器都执行完毕，再执行被拦截的Controller，然后进入拦截器链，从最后一个拦截器往回执行所有的postHandle(),接着再从最后一个拦截器往回执行所有的afterCompletion() 

- postHandle 在业务处理器处理请求执行完成后,生成视图之前执行的动作

  可在modelAndView中加入数据，比如当前时间

  ```
  public void postHandle(HttpServletRequest request,   
              HttpServletResponse response, Object handler,   
              ModelAndView modelAndView)
  ```

- afterCompletion 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等

  当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()

  ```
  public void afterCompletion(HttpServletRequest request,   
              HttpServletResponse response, Object handler, Exception ex)
  ```

- 配置拦截器

  ```
  <mvc:interceptors>   
  	<mvc:interceptor>   
      	<mvc:mapping path="/index"/> 
          <!-- 定义在mvc:interceptor下面的表示是对特定的请求才进行拦截的 --> 
          <bean class="interceptor.IndexInterceptor"/>     
      </mvc:interceptor> 
      <!-- 当设置多个拦截器时，先按顺序调用preHandle方法，然后逆序调用每个拦截器的postHandle和afterCompletion方法 --> 
  </mvc:interceptors>
  ```

  