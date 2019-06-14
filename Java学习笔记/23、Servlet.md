# Servlet 

> ​	开发Servlet步骤：

1. 创建一个java项目j2ee

2. 导入必须的servlet-api.jar包

   - servlet-api.jar 包位于 D:\tomcat\lib\servlet-api.jar
   - 导入办法:右键点击项目 -> properties -> Java Build Path ->Libraries -> Add External JARs

3. 编写一个Servlet类

   - 这个Servlet类继承了 HttpServlet
   - 并且提供了一个doGet方法

4. 配置web.xml

   1. 在项目根目录下创建目录web

   2. 在web目录下创建目录WEB-INF

   3. 在WEB-INF目录下创建web.xml

      - web.xml提供路径与servlet的映射关系

      - <servlet> 标签下的 <servlet-name>
        与 <servlet-mapping> 标签下的 <servlet-name> 必须一样

      - <servlet-name>与<servlet-class>可以不一样

        ```
        <?xml version="1.0" encoding="UTF-8"?>
        <web-app>
            <servlet>
                <servlet-name>HelloServlet</servlet-name>
                <servlet-class>HelloServlet</servlet-class>
            </servlet>
            <servlet-mapping>
                <servlet-name>HelloServlet</servlet-name>
                <url-pattern>/hello</url-pattern>
            </servlet-mapping>
        </web-app>
        ```

5. 指定项目输出到classes目录

   1. 首先在WEB-INF下创建classes目录

   2. 把项目的class文件输出由原来的 j2ee/bin 设置到 j2ee/web/WEB-INF/classes下

      步骤：项目右键->properties->Java Build Path->Source->右下角的 Brower-> 指定位置是 j2ee/web/WEB-INF/classes。

      **为什么要有这一步？** 在ecilpse中默认输出的class是在bin目录下，但是tomcat启动之后，在默认情况下，不会去bin目录找这些class文件，而是到WEB-INF/classes这个目录下去寻找。

6. 配置tomcat的server.xml 中的<context

   1. 打开tomcat/conf/sever.xml

   2. 在 <Host name="localhost" 。。。 下面加一句

      ```
      <Context path="/" docBase="e:\\project\\j2ee\\web" debug="0" reloadable="false" />
      ```

      path="/" 就表示直接通过 http://127.0.0.1/hello 就可以访问网页了。

      如果设置为

      ```
      <Context path="/j2ee" docBase="e:\\project\\j2ee\\web" debug="0" reloadable="false" />
      ```

      那么表示需要通过 http://127.0.0.1/**j2ee**/hello才能访问

7. 删除tomcat webapps下的ROOT目录

   - 在上一步部署web的时候server.xml中的path 配置为 "/" 与 webapps下的ROOT目录冲突了，**删除ROOT目录**

8. 重启tomcat，访问

> 获取参数

- ​	本例通过登录行为，演示servlet如何获取从浏览器提交的账号密码

1. web目录下创建 login.html

2. 创建 LoginServlet

   - [ ] 因为浏览器中的**form的method是post**,所以LoginServlet需要提供一个**doPost**方法
   - [ ] 在doPost方法中，通过**request.getParameter** 根据name取出对应的账号和密码
   - [ ] 用System.out.println() 打印在控制台，**注** 这里是打印在控制台，并没有在网页上输出

3. 映射LoginServlet到路径login

   ```
   <servlet>
   	<servlet-name>LoginServlet</servlet-name>
   	<servlet-class>LoginServlet</servlet-class>
   </servlet>
   <servlet-mapping>
   	<servlet-name>LoginServlet</servlet-name>
   	<url-pattern>/login</url-pattern>
   </servlet-mapping>
   ```

   

4. 在页面提交数据

   **首先重启tomcat**然后访问页面 http://127.0.0.1/login.html

> 返回响应

```
PrintWriter pw = response.getWriter();
pw.println(html);
```

> 调用流程

1. login.html 

   首先访问 http://127.0.0.1/login.html 

   打开一个静态的html页面，在这个页面中可以通过form，以post的形式提交数据

2. /login路径

   在上一步的login.html中，用form，把账号和密码，提交到/login这个路径，并且附带method="post"

3. 找到对应的Servlet

   tomcat接受到一个新的请求：http://127.0.0.1/login

   其路径是/login，接着就到[配置文件web.xml](http://how2j.cn/k/servlet/servlet-paramter/547.html#step1588)进行匹配，发现/login，对应的Servlet类是 LoginServlet。接下来的工作，就会基于这个LoginServlet进行。

4. 实例化Servlet对象

   Tomcat 定位到了LoginServlet后，发现并没有LoginServlet的实例存在，于是就调用LoginServlet的public无参的构造方法LoginServlet()实例化一个LoginServlet对象以备后续使用

5. 调用doGet或者doPost

   Tomcat从上一步拿到了LoginServlet的实例之后，根据页面login.html提交信息的时候带的method="post"，去调用对应的doPost方法。

6. request获取参数

   在这个方法中，通过参数request，把页面上传递来的账号和密码信息取出来

   ```
   String name = request.getParameter("name");
   String password = request.getParameter("password");
   ```

7. response设置响应

   接着，根据账号和密码是否正确(判断是否是admin和123)， 创建不同的html字符串。

   然后把html字符串通过如下方式，设置在了response对象上。  

   ```
   PrintWriter pw = response.getWriter();
   pw.println(html);
   ```

   到这里，Servlet的工作就做完了。

8. tomcat把html传递给浏览器

   在Servlet完成工作之后，tomcat拿到被Servlet修改过的response，根据这个response生成html 字符串，然后再通过[HTTP协议](http://how2j.cn/k/http/http-tutorials/568.html)，这个html字符串，回发给浏览器，浏览器再根据HTTP协议获取这个html字符串，并**渲染**在界面上。

> service()

- Servlet 需要提供对应的doGet() 与 doPost()方法

1. doGet() 当浏览器使用get方式提交数据的时候，servlet需要提供doGet()方法

2. doPost() 当浏览器使用post方式提交数据的时候，servlet需要提供doPost()方法

3. service()

   - LoginServlet继承了HttpServlet,同时也继承了一个方法service。

   - 实际上，在执行doGet()或者doPost()之前，都会先执行service()；  由service()方法进行判断，到底该调用doGet()还是doPost()；可以发现，service(), doGet(), doPost() 三种方式的参数列表都是一样的。  

   - 所以，有时候也会**直接重写service()**方法，在其中提供相应的服务，就不用区分到底是get还是post了。

> 中文问题

1. 获取中文的参数

   为了成功获取中文参数，需要做如下操作：

   1. login.html中加上 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

   2. login.html form的method修改为post

   3. 在servlet进行解码和编码

      byte[] bytes=  name.getBytes("ISO-8859-1");

      name = new String(bytes,"UTF-8");

      先根据ISO-8859-1解码，然后用UTF-8编码，这样就可以得到正确的中文参数了

      - 这样需要对每一个提交的数据都进行编码和解码处理，如果觉得麻烦，也可以使用一句话代替：

        request.setCharacterEncoding("UTF-8"); 

        并且把这句话放在request.getParameter()之前

2. 返回中文的响应

   response.setContentType("text/html;charset=UTF-8");

> 生命周期

1. 生命周期

   一个Servlet的生命周期由实例化，初始化，提供服务，销毁，被回收几个步骤

2. 实例化

   - 当用户通过浏览器输入一个路径，这个路径对应的servlet被调用的时候，该Servlet就会被实例化，隐式提供一个public无参的构造方法

   - 无论访问了多少次LoginServlet，LoginServlet构造方法 **只会执行一次**，所以Servlet是**单实例的**

3. 初始化

   - LoginServlet 继承了HttpServlet，同时也继承了init(ServletConfig) 方法；init 方法是一个实例方法，所以会在构造方法执行后执行。
   - 无论访问了多少次LoginSerlvet，init初始化 **只会执行一次**

4. 提供服务

   接下来就是执行service()方法，然后通过浏览器传递过来的信息进行判断，是调用doGet()还是doPost()方法

5. 销毁

   在如下几种情况下，会调用destroy()

   1.  该Servlet所在的web应用重新启动

      ```
      <Context path="/" docBase="e:\\project\\j2ee\\web" debug="0" reloadable="true" />
      ```

      如果把 reloadable="**false**" 改为reloadable="**true**" 就表示有任何类发生的更新，web应用会**自动重启**，destroy()方法就会被调用

   2. 关闭tomcat的时候 destroy()方法会被调用，但是这个一般都发生的很快，不易被发现。

6. 被回收

   当该Servlet被销毁后，就满足垃圾回收的条件了。 当下一次垃圾回收GC来临的时候，就有可能被回收。这个也是不容易被观察到的现象。

> 跳转

1. 服务端跳转

   ```
   request.getRequestDispatcher("success.html").forward(request, response);
   ```

   服务端跳转可以看到浏览器的地址依然是/login 路径，并不会变成success.html

2. 客户端跳转

   ```
   response.sendRedirect("fail.html");
   ```

   浏览器地址发生了变化

3. 区别

   - 本质区别：转发是服务器行为，重定向是客户端行为。 
   - 转发特点：一次请求，浏览器地址不变，访问的是自己本身的web资源，传输的数据不会丢失。 
   - 重定向特点：两次请求，浏览器地址发生变化，可以访问自己web之外的资源，传输的数据会丢失。

4. 流程：

   - 服务端跳转：浏览器请求服务器，在服务器内部访问web资源，然后把web资源返回给浏览器
   - 客户端跳转：浏览器请求服务器，服务器发送一条特殊消息给浏览器，让浏览器重新访问web资源；浏览器发送第二次请求服务器，服务器把web资源返回给浏览器

> 自启动

有的时候会有这样的业务需求： tomcat一启动，就需要执行一些初始化的代码，比如校验数据库的完整性等。 但是Servlet的生命周期是在用户访问浏览器对应的路径开始的。如果没有用户的第一次访问，就无法执行相关代码。 这个时候，就需要Servlet实现**自启动** 即，伴随着tomcat的启动，自动启动初始化，在初始化方法init()中，就可以进行一些业务代码的工作了。

```
<load-on-startup>10</load-on-startup>
```

取值范围是1-99，同时，为HelloServlet提供一个init(ServletConfig) 方法，验证自启动

在tomcat完全启动之前，就打印了**init of HelloServlet**，<load-on-startup>**10**</load-on-startup> 中的**10**表示启动顺序，如果有多个Servlet都配置了自动启动，数字越小，启动的优先级越高

> request常见方法

1. request的常见方法

   **request.getRequestURL():** 浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有)" 
   **request.getRequestURI():** 浏览器发出请求的资源名部分，去掉了协议和主机名" 
   **request.getQueryString():** 请求行中的参数部分，只能显示以get方式发出的参数，post方式的看不到
   **request.getRemoteAddr():** 浏览器所处于的客户机的IP地址
   **request.getRemoteHost():** 浏览器所处于的客户机的主机名
   **request.getRemotePort():** 浏览器所处于的客户机使用的网络端口
   **request.getLocalAddr():** 服务器的IP地址
   **request.getLocalName():** 服务器的主机名
   **request.getMethod():** 得到客户机请求方式一般是GET或者POST

2. 获取参数

   - 获取单值的参数：**request.getParameter()**
   - 获取具有多值的参数：**request.getParameterValues()**
   - 遍历所有的参数，并返回Map类型：**request.getParameterMap()**

3. 获取头信息

   - **request.getHeaderNames()** 获取浏览器所有的**头信息名称**，再根据头信息名称就能遍历出所有的头信息

   - **request.getHeader()** 根据头信息名称获取头信息

     host: 主机地址
     user-agent: 浏览器基本资料
     accept: 表示浏览器接受的数据类型
     accept-language: 表示浏览器接受的语言
     accept-encoding: 表示浏览器接受的**压缩方式**，是压缩方式，并非编码
     connection: 是否保持连接
     cache-control: 缓存时限

     ```
     Enumeration<String> headerNames= request.getHeaderNames();
     while(headerNames.hasMoreElements()){
         String header = headerNames.nextElement();
         String value = request.getHeader(header);
         System.out.printf("%s\t%s%n",header,value);
     }
     ```

4. 服务端传参

   - setAttribute和getAttribute可以用来在进行服务端跳转的时候，在不同的Servlet之间进行数据共享

> response用法

response是HttpServletResponse的实例，用于提供给浏览器的响应信息

- 设置响应内容

  通过response.getWriter(); 获取一个PrintWriter 对象
  可以使用println(),append(),write(),format()等等方法设置返回给浏览器的html内容。

  ```
  PrintWriter pw= response.getWriter();
  pw.println("<h1>Hello Servlet</h1>");
  ```

- 设置响应格式

  ```
  response.setContentType("text/html");
  ```

  在[request获取头信息](http://how2j.cn/k/servlet/servlet-request/555.html#step1609) 中对应的request.getHeader("accept")，"text/html" 是存在的，表示浏览器可以识别这种格式，如果换一个其他的格式， 比如 "text/lol" ，浏览器不能识别，就会下载文件(常常用于实现下载功能)

- 设置响应编码

  ```
  1. response.setContentType("text/html; charset=UTF-8");
  2. response.setCharacterEncoding("UTF-8");
  ```

  这两种方式都需要在response.getWriter调用之前执行才能生效。

  区别在于：

  response.setContentType("text/html; charset=UTF-8");

  不仅发送到浏览器的内容会使用UTF-8编码，而且还通知浏览器使用UTF-8编码方式进行显示。所以总能正常显示中文。

  response.setCharacterEncoding("UTF-8"); 

  仅仅是发送的浏览器的内容是UTF-8编码的，至于浏览器是用哪种编码方式显示不管。 所以当浏览器的显示编码方式不是UTF-8的时候，就会看到乱码，需要手动再进行一次设置。

- 301或者302客户端跳转

  客户端有两种跳转：302 表示临时跳转 301 表示永久性跳转

  response.sendRedirect("fail.html");就是302跳转

  301要使用另外的手段：

  ```
  response.setStatus(301);
  response.setHeader("Location", "fail.html");
  ```

  用户感受不出这两种跳转的区别，301和302的区别主要在搜索引擎对页面排名的时候有影响，这是属于SEO范畴的概念。

- 设置不使用缓存

  使用缓存可以加快页面的加载，降低服务端的负担。但是也可能看到过时的信息，可以通过如下手段通知浏览器不要使用缓存

  ```
  response.setDateHeader("Expires", 0);
  response.setHeader("Cache-Control", "no-cache");
  response.setHeader("pragma", "no-cache");
  response.getWriter().println("<h1>Hello Servlet!</h1>");
  response.getWriter().println(new Date().toLocaleString());
  ```

> 上传文件

- form 的**method必须是post**的
- 要加上**enctype="multipart/form-data"** 表示提交的数据是二进制文件
- 需要提供**type="file"** 的字段进行上传

```
<form action="uploadPhoto" method="post" enctype="multipart/form-data">
  上传头像 : <input type="file" name="filepath" /> <br>
  <input type="submit" value="上传">
</form>
```

- 需要用到两个第三方的jar包，**commons-io-1.4.jar**和**commons-fileupload-1.2.2.jar**。 
- 前部分代码是固定写法，用来做一些准备工作。 直到遍历出Item,一个Item就是对应一个浏览器提交的数据，通过item.getInputStream可以打开浏览器上传的文件的输入流。

- 因为浏览器指定了以二进制的形式提交数据，那么就不能通过常规的手段获取非File字段：request.getParameter("heroName")；在遍历Item时(Item即对应浏览器提交的字段)，可以通过item.isFormField来判断是否是常规字段还是提交的文件。 当item.isFormField返回true的时候，就表示是常规字段。然后通过item.getFieldName()和item.getString()就知道分别是哪个字段，以及字段的值了。

  ```
  System.out.println(item.getFieldName());
  String value = item.getString();
  value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
  System.out.println(value);
  ```

  

> 动态Web项目

##### 创建Servlet：

- Dynamic Web Project

  File->New->Other->Web->Dynamic Web Project

- 下载servlet-api.jar,并复制到e:/project/j2ee/WebContent/WEB-INF/lib 目录下

- build path->Libraries里的 Web App Libraries 自动加上这个servlet-api.jar包

- 创建 HelloServlet

- 在WEB-INF目录中创建 web.xml

- 通过Eclipse启动Tomcat-Run On Server

- 通过Eclipse启动Tomcat-服务器选择Tomcat v7.0 Server

- 通过Eclipse启动Tomcat-指定Tomcat服务器地址

  指定Tomcat目录所在位置，这里使用的位置是：
  **D:\tomcat7-8080-eclipse**

- 通过Eclipse启动Tomcat-部署

- 测试

- 关闭Eclipse中的Tomcat

  以Eclipse的方式启动Tomcat,其实就是一个普通的Java 进程，只需要在Console 面板关闭即可

- 需要注意的几点：

  1. 类文件会被输出到build里，而不是WEB-INF/classes目录下
  2. 当有类或者配置文件变化时，会自动重启，无需手动重启Tomcat. 但是不稳定，当很许多类改动，新加了jar包，新增加了配置文件等等，都有可能导致自动重启失效，所以最好还是手动重启，确保重启成功。
  3. WebContent会被整个复制到 E:\project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\j2ee 这个位置下面去，Eclipse中启动的tomcat其实是访问的这个位置。所以当WebContent里的内容比较多的时候，就会花较长时间复制。
  4. 因为第3条的原因，第1条在build里生成的类和配置文件，也会被复制到第3条所说的位置

##### 切换Servlet

- 项目转换

  右键项目j2ee->properties->Project Facets->Convert to faceted form

- 设置content directory

  1. 勾选Dynamic Web Module
  2. 勾选之后，会出现 Furthe configuration available ..., 点击
  3. 动态web项目的默认内容目录是WebContent,而 j2ee这个项目的对应目录是 web, 所以这里要输入web
  4. 点击ok

- 点击Ok

- Run As

##### 导入Servlet

1. 下载动态Web项目

2. 导入到Eclipse中1

   菜单->File->Import->General->Existing Projects Into Workspace

3. 导入到Eclipse中2

   在Select root directory中输入[下载动态Web项目](http://how2j.cn/k/servlet/servlet-import/1371.html#step5838)步骤中解压出来的目录。

   **注：**如图所示，会发现无法点击Finish,此时只需要点一下 Brower 就可以点击Finish了。 如果怎么也点不出来，是因为Eclipse里面已经管理着一个同名项目，把那个同名项目从Eclipse删除掉就好了

4. 启动Tomcat： Run As

> JSON

- JSON.stringify函数的作用是将一个javascript对象，转换为JSON格式的字符串。

- 转换为JSON对象：JSONObject json=JSONObject.fromObject(data); 

- 转换为Hero对象：Hero hero = (Hero)JSONObject.toBean(json,Hero.``class``);

- 把Hero对象转换为JSONObject 对象，并放在上一个JSONObject对象上，key是"hero"：

  ```
  JSONObject json= new JSONObject();
  json.put("hero", JSONObject.fromObject(hero));
  ```

-  通过JSONSerializer.toJSON(heros)把集合转换为JSON字符串