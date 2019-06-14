# Listener

> hello Listener

Listener 的作用是用于监听 web应用的创建和销毁，以及在其上attribute发生的变化。 

web应用即ServletContext对象(jsp的[隐式对象application](http://how2j.cn/k/jsp/jsp-object/580.html)) 

除了对[web应用](http://how2j.cn/k/listener/listener-context/605.html)的监听外，还能监听[session](http://how2j.cn/k/listener/listener-session/606.html)和[request](http://how2j.cn/k/listener/listener-request/607.html)的生命周期，以及他们的attribute发生的变化。

> Context

- 编写 ContextListener

  ContextListener 实现接口ServletContextListener，有两个方法：

  - public void contextDestroyed(ServletContextEvent arg0)  对应当前web应用的销毁
  - public void contextInitialized(ServletContextEvent arg0) 对应当前web应用的初始化

- 配置 web.xml

  配置监听器：

  ```
  <listener>
      <listener-class>listener.ContextListener</listener-class>
  </listener>
  ```

- 自动重载：

  在启动tomcat以及当前web应用重载的时候才可以观察到

  1. 配置： server.xml中对应的**<context**配置 的属性 @reloadable="true"
  2. 某个servlet 发生了变化，导致这个web应用自动重启

- 编写 ContextAttributeListener

  ContextAttributeListener 实现接口ServletContextAttributeListener，有两个方法：

  - public void attributeAdded(ServletContextAttributeEvent e) 监听属性的增加
  - public void attributeRemoved(ServletContextAttributeEvent e) 监听属性的移除
  - public void attributeReplaced(ServletContextAttributeEvent e) 监听属性的替换

- 配置web.xml

  配置ContextAttributeListener：

  ```
  <listener>
      <listener-class>listener.ContextAttributeListener</listener-class>
  </listener>
  ```

> Session

- 编写 SessionListener

  SessionListener 实现了接口 HttpSessionListener，有两个方法：

  - sessionCreated() 表示session创建的时候执行
  - sessionDestroyed() 表示session销毁的时候执行

- 配置web.xml

  配置SessionListener：

  ```
  <listener>
      <listener-class>listener.SessionListener</listener-class>
  </listener>
  ```

- 测试

  随意访问任意页面，如果是第一次访问，都会触发session创建，后续访问不会触发session的创建

  关闭浏览器，再访问，也会触发session的创建。 但是有的浏览器，即便是关闭了，下一次打开，也会发送以前sessionid到服务器，这样服务器就不会创建新的session。 

  session的销毁不易观察到，一般说来[服务器会设置session存活时间为30分钟](http://how2j.cn/k/jsp/jsp-session/583.html#step1676)。所以需要等待才能观察到销毁

- 编写 SessionAttributeListener

  SessionAttributeListener 实现接口 HttpSessionAttributeListener，有3个方法：

  - attributeAdded() 当在session中增加属性时触发
  - attributeRemoved() 当在session中移除属性时触发
  - attributeReplaced() 当替换session中的属性时触发

- 配置 listener.SessionAttributeListener

  ```
  <listener>
      <listener-class>listener.SessionAttributeListener</listener-class>
  </listener>
  ```

> Request

对Request的监听分生命周期的监听，和Request上Attribute变化的监听两部分。

- 编写 RequestListener

  RequestListener 实现接口 ServletRequestListener和ServletRequestAttributeListener，以下方法：

  - requestInitialized() 当新创建了一个Request的时候触发，只要访问了服务端的资源，就会创建一个Request，无论是jsp,servlet还是html
  - requestDestroyed() 当本次请求结束的时候触发
  - attributeAdded 当有新增属性时触发
  - attributeReplaced 当有替换属性时触发
  - attributeRemoved 当有移除属性时触发

- 配置web.xml

  ```
  <listener>
      <listener-class>listener.RequestListener</listener-class>
  </listener>
  ```

  