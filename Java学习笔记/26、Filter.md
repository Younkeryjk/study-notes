# Filter

> Hello Filter



- Filter概念

  Filter就像一个一个哨卡，用户的请求需要经过Filter，并且可以有多个过滤器

- 编写 FirstFilter

  doFilter()方法中的req参数的类型是ServletRequest，需要转换为HttpServletRequest类型方便调用某些方法

- 配置web.xml

  <url-pattern>/*</url-pattern> 表示所有的访问都会过滤

  如果配置成<url-pattern>*.jsp</url-pattern>  就表示只过滤jsp

  ```
  <filter>
      <filter-name>FirstFilter</filter-name>
      <filter-class>filter.FirstFilter</filter-class>
  </filter>
  
  <filter-mapping>
      <filter-name>FirstFilter</filter-name>
      <url-pattern>/*</url-pattern>
  </filter-mapping>
  ```

- init() 方法

  与Servlet需要配置[自启动](http://how2j.cn/k/servlet/servlet-startup/553.html)才会随着tomcat的启动而执行init()方法不一样。

  Filter**一定**会随着tomcat的启动自启动。

- Filter启动失败

  Filter是web应用非常重要的一个环节，如果Filter启动失败，或者本身有编译错误，**不仅这个Filter不能使用**，**整个web应用会启动失败**，导致用户无法访问页面

> 中文处理

- 使用Servlet处理的局限性

  可以通过request.setCharacterEncoding("UTF-8");正确获取UTF-8编码的中文，但是如果有很多servlet都需要获取中文，那么就必须**在每个Servlet中增加这段代码。**

  有一个简便的办法，那就是通过Filter过滤器进行中文处理 ，那么所有的Servlet都不需要单独处理了。

- 使用Filter处理

  创建一个 EncodingFilter ，设置如下代码：

  ```
  HttpServletRequest request = (HttpServletRequest) req;
  request.setCharacterEncoding("UTF-8");
  ```

  doFilter方法的第一个参数req,是ServletRequest 类型的，不支持setCharacterEncoding，所以要先强制转换为HttpServletReques

- 配置web.xml

  配置EncodingFilter<url-pattern>/*</url-pattern>表示为所有的访问都使用该Filter