# Nginx

#### 入门

nginx发音为“engine X”

- 启动方式

  1. 直接双击

     直接双击nginx.exe，打开http://127.0.0.1可以看到欢迎页面

     此种启动方式关闭方式为任务管理器

     **注：** **nginx启动之后，在任务管理里有两个nginx进程，这个是正常的，一个是1个守护进程 1个工作进程，得手动分别关闭。**

  2. 命令行

     cmd进入nginx目录，运行

     ```
     start nginx
     ```

     关闭方式也是与之对应的

     ```
     nginx -s stop
     ```

- 端口号修改

  打开nginx目录下的conf/nginx.conf文件，然后找到listen 80,修改为9090，关闭nginx再启动，就可以通过如下地址访问了：

  ```
  http://127.0.0.1:9090/
  ```

  **注：** 也可以通如下命令进行重启：

  ```
  nginx -s reload 
  ```

- nginx.conf配置文件

  主要有几个开发人员需要关心的：

  1. 端口号

     ```
     listen       80;
     ```

  2. 页面存放位置：

     ```
     root html;
     ```

  3. 欢迎页面

     ```
     index  index.html index.htm;
     ```

     默认会访问index.html或者index.htm文件

#### 多个Tomcat

- Nginx是一个web服务器，很快速，但是不能作为Servlet 容器独立运行，所以通常的工作方式是Nginx配合Tomcat来协同工作。 
- 那么为什么要提供多个Tomcat呢？因为在后续的负载均衡，session共享需要多个Tomcat配合演示。

#### 反向代理

- 反向代理概念

  先说正向代理，比如要访问youtube,但是不能直接访问，只能先找个翻墙软件，通过翻墙软件才能访问youtube. 翻墙软件就叫做正向代理。
  所谓的反向代理，指的是用户要访问youtube,但是youtube悄悄地把这个请求交给bilibili来做，那么bilibili就是反向代理了。
  在当前教程指的就是访问nginx,但是nginx把请求交给tomcat来做。

- 启动tomcat

  首先启动[多个Tomcat](http://how2j.cn/k/nginx/nginx-tomcats/1566.html) 中端口号是8111的tomcat

- 修改nginx.conf

  ```
  location / {
  	proxy_pass http://127.0.0.1:8111;
  }
  ```

  **location /** 表示处理所有请求
  **proxy_pass http://127.0.0.1:8111;** 表示把请求都交给http://127.0.0.1:8111来处理

- 重启nginx并访问

  ```
  nginx -s reload
  ```

  然后访问地址：

  ```
  http://127.0.0.1/ 
  ```

  就会观察到已经反向代理到tomcat了(得到的是反向代理的Tomcat登录页了，而不是原先的Nginx欢迎页了)

  ![éå¯nginxå¹¶è®¿é®](http://stepimagewm.how2j.cn/6649.png)

- 意义何在

    既然直接通过127.0.0.1:8111/login.jsp 可以访问，那么干嘛要通过127.0.0.1/login.jsp 去反向代理到tomcat呢？ 为什么不直接使用tomcat呢？

  因为nginx在处理静态文件的吞吐量上面比tomcat好很多，通常他们俩配合，不会把所有的请求都如本例所示的交给tomcat, 而是把静态请求交给nginx，动态请求，如jsp, servlet,ssm， struts等请求交给tomcat. 从而达到动静分离的效果。 接下来就会讲解如何进行动静分离。  

#### 动静分离

- 动静分离概念

  所谓的动静分离就是指图片，css, js之类的都交给nginx来处理，nginx处理不了的，比如jsp 就交给tomcat来处理~

  好处是nginx处理静态内容的吞吐量很高，比tomcat高多了，这样无形中提升了性能。

  ![å¨éåç¦»æ¦å¿µ](http://stepimagewm.how2j.cn/6651.png)

- 修改nginx.conf

  在locaction下面添加一个新的location:

  ```
  location ~\.(css|js|png)$ {
  	root D:/tomcat_8111/webapps/ROOT;
  }
  ```

  这表示所有的css js png访问都由nginx来做，访问的地址是：

  ```
  D:/tomcat_8111/webapps/ROOT
  ```

  **这里要注意，填写本地地址的时候，要用正斜杠 / 不要用反斜杠 **\****

- 观察tomcat输入日志

  再到tomcat的输出日志里观察，就会发现，只访问了jsp, 所有的css,js,png都不会经过 tomcat，而是由nginx自己负责处理了。

  ![è§å¯tomcatè¾å¥æ¥å¿](http://stepimagewm.how2j.cn/6654.png)

#### 负载均衡

- 负载均衡的概念

  负载均衡的概念就是当访问量很大的时候，一个 Tomcat 吃不消了，这时候就准备多个 Tomcat，由Nginx按照权重来对请求进行分配，从而缓解单独一个Tomcat受到的压力

  ![è´è½½åè¡¡çæ¦å¿µ](http://stepimagewm.how2j.cn/6655.png)

- 启动两个Tomcat

  启动端口为8111和8222的两个tomcat

- 修改nginx.conf

  首先增加一个upstream ，用来指向这两个tomcat

  ```
  upstream tomcat_8111_8222{
  	server	127.0.0.1:8111 weight=1;
  	server	127.0.0.1:8222 weight=2;
  }
  ```

  然后修改location，反向代理到上述配置。

  ```
  location / {
  	proxy_pass http://tomcat_8111_8222;
  }
  ```

  weight表示权重，值越大，被分配到的几率越大，一般10以内吧。

- 重启nginx并访问

  使用命令 nginx -s reload 重启，然后多次访问

  此时在两个Tomcat控制台就可以观察到对jsp的访问，被分配到了不同的 Tomcat上

  ![éå¯nginxå¹¶è®¿é®](http://stepimagewm.how2j.cn/6657.png)

#### Session共享

- 负载均衡 session问题

  通过负载均衡，我们可以把请求分发到不同的 Tomcat 来缓解服务器的压力，但是这里存在一个问题： 当同一个用户第一次访问tomcat_8111 并且登录成功， 而第二次访问却被分配到了tomcat_8222， 这里并没有记录他的登陆状态，那么就会呈现未登录状态了，严重伤害了用户体验。

- 解决办法一: ip_hash

  通过ip地址标记用户，如果多次请求都是从同一个ip来的，那么就都分配到同一个tomcat.

  这样就不会出现session问题了， 处理手段也很简单，在upstream最后加上ip_hash;就行了。

  不过这种方案并不完美，当如下几种情况发生时就有问题：

  1. 大量请求来之某个局域网，那么相当于就没有负载均衡了
  2. 如果tomcat_8111 挂了，那么此时nginx只能把请求交给tomcat_8222,但是这里却没有记录session,用户体验依然受影响。

  ![è§£å³åæ³ä¸: ip_hash](http://stepimagewm.how2j.cn/6660.png)

- 解决办法二： redis+tomcat-sessoin-manager

  用Redis来存取session，简单说Redis是个独立的Hashmap，用来存放键值对的。

  这样当tomcat1需要保存session值的时候，就可以把它放在Redis上，需要取的时候，也从Redis上取。

  那么考虑这个情景： 
  1. 用户提交账号密码的行为被分配在了tomcat8111上，登陆信息被存放在redis里。 
  2. 当用户第二次访问的时候，被分配到了tomcat8222上
  3. 那么此时tomcat8222就会从redis去获取相关信息，一看有对应信息，那么就会呈现登陆状态。

  这样就规避了解决办法一的两个问题了

  ![è§£å³åæ³äºï¼ redis+tomcat-sessoin-manager](http://stepimagewm.how2j.cn/6661.png)

- 解决办法二具体操作：

  1. 启动redis
  2. 给两个tomcat使用jar包
  3. 配置两个tomcat
  4. 重启两个tomcat
  5. 测试

- 启动redis

  双击redis-server.exe启动redis

- jar包

  Tomcat需要链接 redis，所以需要专门的jar包,一共有3个jar包：

  jedis-2.5.2.jar，
  commons-pool2-2.0.jar，
  tomcat-redis-session-manager1.2.jar。

  下载解压后，放在tomat8111的lib目录下。**注：不要放在webapp里面**

  下载解压后，放在tomat8222的lib目录下。**注：不要放在webapp里面**

- 修改context.xml

  然后修改tomcat/conf/context.xml ，增加

  ```
  <Valve className="com.orangefunction.tomcat.redissessions.RedisSessionHandlerValve" />  
    <Manager className="com.orangefunction.tomcat.redissessions.RedisSessionManager"  
     host="127.0.0.1"  
     port="6379"  
     database="0"  
     maxInactiveInterval="60" /> 
  ```

- 重启tomcat

  **两个tomcat都要重启**

- 测试访问tomcat8111

  Redis session共享机制和nginx其实无关，是发生在nginx之后的事情，所以直接访问login.jsp，然后登陆，并观察到已登陆状态

  ```
  http://127.0.0.1:8111/login.jsp
  ```

- 测试访问tomcat8222

  然后直接访问tomcat8222

  ```
  http://127.0.0.1:8222/login.jsp
  ```

  虽然没有在tomcat8222上登陆，但是可以观察到已经呈现为登陆状态了