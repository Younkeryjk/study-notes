# Tomcat

> Hello Tomcat

- 如何启动Tomcat

  运行批处理文件： D:/tomcat/bin/startup.bat

- 项目根目录

  D:\tomcat\webapps\ROOT

- 改端口

  Tomcat的端口配置相关信息在 server.xml中，默认是8080

  修改完，需要重启Tomcat(关闭startup.bat，再重新打开)

- Tomcat问题排查

  - JAVA_HOME

    现象：点击startup.bat之后，屏幕一闪而过

    检验：通过cmd命令进入控制台，然后切换到对应的目录执行startup命令，得到JRE_HOME environment .... 这么个提示，就表示JAVA_HOME环境变量没有设置。

    分析：Tomcat本身是JAVA程序，必须要有JDK才可以执行，所以必须配置JAVA_HOME。

    解决：配置JAVA_HOME

  - CATALINA_HOME未设置

    现象：点击startup.bat之后，屏幕一闪而过

    检验：通过cmd命令进入控制台，然后切换到对应的目录执行startup命令，得到CATALINA_HOME environment .... 这么个提示，就表示CATALINA_HOME环境变量设置错误。

    分析：Tomcat执行必须依赖CATALINA_HOME或者CATALINA_BASE这两个环境变量。 如果没有在环境变量里配置过，那么会自动采用bin目录的父目录作为CATALINA_HOME和CATALINA_BASE。 如果配置了，而所配置的地方又不是正确的TOMCAT目录，那么就会出现这个错误。

    解决：
    1. 在环境变量中删除CATALINA_HOME,CATALINA_BASE的配置，记得不仅要检查环境变量，还要检查用户变量。
    2. 或者把CATALINA_HOME设置为正确的TOMCAT目录。

  - CATALINA_HOME错误设置

    现象：Tomcat可以成功启动，但是就是不能访问自己配置的web应用，老是提示404错误

    检验：在环境变量里，CATALINA_HOME设置在了另一个合法的tomcat目录上，所以无论运行哪个startup.bat，都会导致这个d:/tomcatxxxx目录下的程序被启动，而不是你期望的那个。

    分析：默认的Tomcat会优先根据环境变量中的CATALINA_HOME来定位目录，并运行。

    解决：
    1. 在环境变量中删除CATALINA_HOME,CATALINA_BASE的配置，记得不仅要检查环境变量，还要检查用户变量。
    2. 或者使用本站的[纯净版 Tomcat](http://how2j.cn/k/tomcat/tomcat-download/1130.html)，已经取消了对环境变量CATALINA_HOME和CATALINA_BASE的依赖。

  - 端口冲突

    现象：屏幕一闪而过，或者不会关闭，但是提示大量错误，其中会看到如图所示的Address already in use: JVM_Bind <null>:80，即表示端口被占用了。

    检验：如果是这个错误，在TOMCAT目录下的logs目录里，会有一个日志文件：catalina.yyyy-mm-dd.log（当天时间），在这个日志文件里会记载一样的错误:Address already in use: JVM_Bind <null>:80。即表明80端口被占用了。

    分析：端口是独占式的，一旦一个程序占用了这个端口，其他程序就不能够再去占用它了。而80端口，有可能是被已经存在的Tomcat占用了，也有可能是被其他软件占用了，比如Apache,IIS,Oracle等等。

  - localhost.yyyy-mm-dd.log

    现象：404错误

    检验：打开tomcat/logs目录里的localhost.yyyy-mm-dd.log文件，发现大量的报错信息。

    分析：当server.xml， web.xml配置错误的时候，当前web应用就会部署失败，并且会将错误信息输出到localhost.yyyy-mm-dd.log文件中。

    解决： 要在localhost.yyyy-mm-dd.log文件中看提示什么错误，有可能是配置的context目录不存在，有可能是多了一个>符号等。

  - Error FilterStart

    现象：404错误，明明有文件，但是就是不能访问。

    检验：这个严格地说，也是配置失败，但是tomcat不会大量报错，只会偷偷地来这么一句： startup failed due to previous errors。

    分析：过滤器启动失败就会报这个错。

    解决：同样的，过滤器启动失败原因也是多种多样，好在它都会把具体错误信息输出到localhost.yyyy-mm-dd.log

  - JDK版本

    现象：404错误，明明有文件，但是就是不能访问。

    检验：在命令行中运行java -version 检查一下当前java的版本

    分析：当部署的web应用中的类是由高版本JDK编译生成，而当前tomcat运行所使用的JDK又是低版本的话，就会报出如图所示的错误：UnsupportedClassVersionError，进而导致web应用启动失败。

    解决：请使用JDK8或者更高版本

- 404问题排查

  - 正确的端口号

    出现404错误证明，TOMCAT是启动成功了的。 但是在一台计算机上，可以启动多个端口号不一样的TOMCAT, 所以请确保自己访问的是正确的那个端口号。

  - 环境变量

    假设有两个Tomcat A和 B，自己分明运行的是B 下的startup.bat, 但是启动的却是A， 这就是环境变量在作祟了。在环境变量中有两个属性：分别是CATALINA_HOME和CATALNIA_BASE，如果这个值指向的是A，那么即便运行的是B下的startup.bat, 真正启动的还会是A。

    解决办法： 删除掉这个环境变量，或者使用移除了环境变量影响的[纯净版 Tomcat](http://how2j.cn/k/tomcat/tomcat-download/1130.html)。

  - 确定Web应用是否成功启动

    虽然Tomcat启动成功了，但是对应的Web应用启动失败，依然会导致404错误。

    怎么判断Web应用成功与失败呢？ 倘若Web引用启动失败，那么就一定会在Tomcat的logs目录下的 **localhost.当前日期.log** 里留下错误信息。打开这个文件，检查对应的Web应用是否启动过程中报错了。 也许是web.xml多写了一个标签结束，也许是对应的servlet类找不到。

  - webapps下的ROOT目录

    在server.xml 中配置的<context 是以**“/"**为开始路径的，与此同时，在webapps目录下还存在一个ROOT目录，这个ROOT目录其实也是告诉tomcat，以**“/”** 为开始路径，那么这样就发生冲突了，Tomcat只能二选一，通常情况下都会选择ROOT目录，那么在server.xml中配置的<context 就无法启动了，导致访问对应的资源提示404错误。

    解决办法就是删除掉ROOT目录，或者把ROOT目录重命名

  - 访问地址的时候是否加了web应用的名称

    这个也是常犯的错误，加入部署的时候，指定了路径，比如：

    ```
    <Context path="/j2ee" docBase="e:\\project\\j2ee\\web" debug="0" reloadable="false" />
    ```

    那么访问的时候，要记得加上j2ee，像这样：http://127.0.0.1:8080/**j2ee**/hello  

  - 是否访问对资源了

    输错url了，自然出现404

  - 不能访问WEB-INF目录下的资源

    从安全角度出发，TOMCAT不允许访问WEB-INF目录下的HTML,JSP文件。 所以如果你的资源文件放在WEB-INF下，也会提示404错误

  - 访问地址后面多加了一个斜杠

- 端口被占用

  1. 查看80端口被哪些程序占用了

     ```
     netstat -ano|findstr "80"
     ```

  2. 根据pid（进程id） 查询对应的应用程序

     ```
     tasklist|findstr "1828"
     ```

     1828根据上一步找到的对应的pid 发现是一个java.exe程序占用了80端口  

  3. 根据名称 结束该程序

     ```
     taskkill /f /t /im java.exe
     ```

- 持久化异常

  - Tomcat启动的时候会报一个Exception loading sessions from persistent storage异常，但是又不影响正常的业务。

  - 该问题的原因是tomcat的session持久化机制引起的，tomcat这个功能本身的用意在于重启tomcat后保存之前的session，Tomcat会把session持久化在%TOMCAT%/work/Catalina/localhost/session.ser 这个文件里。 但是因为tomcat非正常关闭，所以这个文件没有正确地结束(无EOF标记)

  **解决办法治标：** 只需要删除 session.ser文件即可。

  **解决办法治本：**关闭tomcat的持久化功能，就能一劳永逸的解决这个问题。具体为修改conf下的server.xml文件。在项目的context间加入一句代码

  ```
  <Context path="/" docBase="D:\\project\\j2ee\\web" debug="0" reloadable="false" >
  <Manager className="org.apache.catalina.session.PersistentManager" saveOnRestart="false"/>
  </Context>
  ```

  重启tomcat以后再也不会报这个错误了。

- 纯净版 TOMCAT
  1. 移除了对换变量中配置的CATALINA_HOME和CATALINE_BASE的依赖，运行startup.bat就一定是启动当前的tomcat。 
  2. 删除了webapps里的所有文件夹，避免未删除的ROOT目录与server.xml中的context配置发生冲突可能导致的错误。

- 部署

  ```
  <Context path="/" docBase="E:\\project\\j2ee\\web" debug="0" reloadable="false" />
  ```

  - 修改docBase目录(项目的根目录) 注： 文件路径是**双斜杠**哦，不是单斜杠
  - 重启Tomcat的startup.bat