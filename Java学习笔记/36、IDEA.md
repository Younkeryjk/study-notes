# IDEA

### 配置文件位置

- IDEA的配置文件

  IDEA的配置信息存放在idea.properties 

  具体路径：安装目录\bin\idea.properties

### 增加Jar

- 添加jar到路径

  右键lib目录->Add as Library... ，弹出个对话框，点击ok

### Web Project

- 新建项目

  菜单->File->New->Project->勾上 Web Application(3.1)->OK

- 新建目录

  右键WEB-INF->New->Directory 新建两个目录：
  classes和lib目录

- 新建HelloServlet

  选中src目录，然后右键鼠标->New->Servlet->输入HelloServlet

- 下载jar包

  下载jar包复制到在[新建目录](http://how2j.cn/k/idea/idea-web-project/1352.html#step5735)步骤中新建的lib目录下

- 导入jar包

  1. 点击 project structure
  2. 点击 Libraries
  3. 点击加号，选中Java
  4. 指定E:\project\j2ee\web\WEB-INF\lib\servlet-api.jar
  5. 点击ok

- 指定输出目录

  1. 打开project structure

  2. 设置 project complier output 为：

     ```
     E:\project\j2ee\web\WEB-INF\classes
     ```

- 修改web.xml

  在web.xml中添加/hello路径的映射

  ```
  <servlet>
          <servlet-name>HelloServlet</servlet-name>
          <servlet-class>HelloServlet</servlet-class>
      </servlet>
   
      <servlet-mapping>
          <servlet-name>HelloServlet</servlet-name>
          <url-pattern>/hello</url-pattern>
      </servlet-mapping>
  ```

- 启动Tomcat

### 配置Tomcat

- 打开Tomcat配置

  1. 点击红框框1那里的下拉,然后点击 Edit Configurations
  2. 然后点击+号
  3. 选Tomcat Servet
  4. Local
  打开配置页面
  **注：** 步骤3，也许看不到Tomcat Server,那么点击下面那个 33 items more(irrelevant) 里面有Tomcat Server

- 指定Tomcat路径

  1. 在name这里输入tomcat7
  2. 点击Configure..
  3. 输入[下载Tomcat](http://how2j.cn/k/idea/idea-tomcat/1361.html#step5743)步骤下载解压的Tomcat Home: d：\tomcat7-8080-idea

  ![æå®Tomcatè·¯å¾](http://stepimagewm.how2j.cn/5745.png)

- 设置部署

  接下来就需要指定当前项目部署到Tomcat中
  1. 点击Deployment
  2. 点击加号
  3. 点击Artifact...
  4. 自动生成 j2ee.war
  最后. 点击OK

  ![è®¾ç½®é¨ç½²](http://stepimagewm.how2j.cn/5746.png)

- 运行

  点击绿色按钮，当出现j2ee.war deployed successfully的时候，就表示部署成功了

### 快捷键

- 实用快捷键

  ```
  psvm 快捷打出main方法
  sout 可以快捷打出System.out.println
  fori 打出for循环
  alt+enter 自动修复
  alt+insert 可以自动生成构造器、getter/setter等等常用方法
  ctrl+d 复制当前行到下一行
  ctrl+alt+L 格式化
  ctrl+k 提交代码到Github
  ctrl+t 更新同步本地代码
  ```

- 查找相关快捷键

  ```
  1.双击shift
  在项目的所有目录查找，就是你想看到你不想看到的和你没想过你能看到的都给你找出来
  
  2.ctrl+f
  当前文件查找特定内容
  
  3.ctrl+shift+f
  当前项目查找包含特定内容的文件
  
  4.ctrl+n
  查找类
  
  5.ctrl+shift+n
  查找文件
  
  6.ctrl+e
  最近的文件
  
  7.alt+F7
  非常非常频繁使用的一个快捷键，可以帮你找到你的函数或者变量或者类的所有引用到的地方
  ```

- 编辑相关快捷键

  ```
  1.shift+enter
  另起一行
  
  2.ctrl+r
  当前文件替换特定内容
  
  3.ctrl+shift+r
  当前项目替换特定内容
  
  4.shift+F6
  非常非常省心省力的一个快捷键，可以重命名你的类、方法、变量等等，而且这个重命名甚至可以选择替换掉注释中的内容
  
  5.ctrl+d
  复制当前行到下一行
  
  6.ctrl+x
  剪切当前行
  
  7.ctrl+c \ ctrl+v 
  大家都懂的
  
  8.ctrl+z
  撤销
  
  9.ctrl+shift+z
  取消撤销
  
  10.ctrl+k
  提交代码到Github
  
  11.ctrl+t
  更新同步本地代码
  
  12.alt+insert 
  可以自动生成构造器、getter/setter等等常用方法
  
  13.alt+enter 
  自动修复
  
  14.ctrl+alt+L 
  格式化
  
  15、ctrl+shift+enter 
  从"strstr"跳出到下一行
  ```

- IDEA所有快捷键

  ![IDEAææå¿«æ·é®](http://stepimagewm.how2j.cn/5778.png)

### 创建SSM项目

- 新建项目

  点击Create New Project新建项目

- 选中maven webapp格式

  1. 左边选中Maven
  2. 勾选Create from archetype
  3. 选中 org.apache.maven.archetypes:maven-archetype-webapp
  4. Next

- 填写项目参数

  GroupId: com.how2java
  ArtifactId: ssm

- 确认项目名称

  无需改动,点击Finish即可

- Maven import

  每次新建Maven项目，或者pom.xml有改动，都会有这个提示，点击Enable Auto-Import，自动导入，省掉麻烦。

- 新建java源代码目录

  maven web项目默认是没有java源代码目录的，所以需要手动创建，并设置其为源代码目录
  右键main目录-> New->Directory->输入java->右键java->Mark Directory as-> Sources Root
  这样就创建了存放java源文件的目录了

- 修改pom.xml

  ```
  <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.how2java</groupId>
    <artifactId>ssm</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>war</packaging>
   
    <properties>
      <spring.version>4.1.3.RELEASE</spring.version>
      <pagehelper.version>5.1.2-beta</pagehelper.version>
      <mysql.version>5.1.6</mysql.version>
      <mybatis.spring.version>1.2.3</mybatis.spring.version>
      <mybatis.version>3.1.1</mybatis.version>
      <junit.version>4.12</junit.version>
      <jstl.version>1.2</jstl.version>
      <jsqlparser.version>1.0</jsqlparser.version>
      <jackson.version>1.2.7</jackson.version>
      <servlet-api.version>3.1.0</servlet-api.version>
      <druid.version>1.0.18</druid.version>
      <log4j.version>1.2.16</log4j.version>
      <commons-logging.version>1.2</commons-logging.version>
      <commons-fileupload.version>1.2.1</commons-fileupload.version>
      <commons-io.version>1.3.2</commons-io.version>
      <commons-lang.version>2.6</commons-lang.version>
      <aopalliance.version>1.0</aopalliance.version>
      <mybatis-generator.version>1.3.5</mybatis-generator.version>
    </properties>
   
    <dependencies>
   
      <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>${junit.version}</version>
      </dependency>
   
      <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>${mybatis.version}</version>
      </dependency>
   
      <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>${mybatis.spring.version}</version>
      </dependency>
   
      <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>${mysql.version}</version>
      </dependency>
   
      <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>${druid.version}</version>
      </dependency>
   
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>${spring.version}</version>
      </dependency>
   
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>${spring.version}</version>
      </dependency>
   
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-beans</artifactId>
        <version>${spring.version}</version>
      </dependency>
   
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>${spring.version}</version>
      </dependency>
   
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>${spring.version}</version>
      </dependency>
   
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aspects</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <!-- JSP相关 -->
      <dependency>
        <groupId>jstl</groupId>
        <artifactId>jstl</artifactId>
        <version>${jstl.version}</version>
      </dependency>
   
      <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>${servlet-api.version}</version>
        <scope>provided</scope>
      </dependency>
   
      <!-- pageHelper -->
      <dependency>
        <groupId>com.github.pagehelper</groupId>
        <artifactId>pagehelper</artifactId>
        <version>${pagehelper.version}</version>
      </dependency>
   
      <!--jsqlparser-->
      <dependency>
        <groupId>com.github.jsqlparser</groupId>
        <artifactId>jsqlparser</artifactId>
        <version>${jsqlparser.version}</version>
      </dependency>
      <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>${log4j.version}</version>
      </dependency>
   
      <dependency>
        <groupId>commons-logging</groupId>
        <artifactId>commons-logging</artifactId>
        <version>${commons-logging.version}</version>
      </dependency>
   
      <dependency>
        <groupId>commons-fileupload</groupId>
        <artifactId>commons-fileupload</artifactId>
        <version>${commons-fileupload.version}</version>
      </dependency>
   
      <dependency>
        <groupId>commons-io</groupId>
        <artifactId>commons-io</artifactId>
        <version>${commons-io.version}</version>
      </dependency>
   
      <dependency>
        <groupId>commons-lang</groupId>
        <artifactId>commons-lang</artifactId>
        <version>${commons-lang.version}</version>
      </dependency>
   
      <dependency>
        <groupId>aopalliance</groupId>
        <artifactId>aopalliance</artifactId>
        <version>${aopalliance.version}</version>
      </dependency>
   
      <dependency>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-core</artifactId>
        <version>${mybatis-generator.version}</version>
      </dependency>
   
    </dependencies>
   
    <build>
      <finalName>${project.artifactId}</finalName>
      <plugins>
        <!-- 资源文件拷贝插件 -->
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-resources-plugin</artifactId>
          <version>2.7</version>
          <configuration>
            <encoding>UTF-8</encoding>
          </configuration>
        </plugin>
        <!-- java编译插件 -->
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.2</version>
          <configuration>
            <source>1.8</source>
            <target>1.8</target>
            <encoding>UTF-8</encoding>
          </configuration>
        </plugin>
      </plugins>
      <pluginManagement>
        <plugins>
          <!-- 配置Tomcat插件 -->
          <plugin>
            <groupId>org.apache.tomcat.maven</groupId>
            <artifactId>tomcat7-maven-plugin</artifactId>
            <version>2.2</version>
          </plugin>
        </plugins>
      </pluginManagement>
   
      <resources>
        <resource>
          <directory>src/main/resources</directory>
          <includes>
            <include>**/*.properties</include>
            <include>**/*.xml</include>
            <include>**/*.tld</include>
          </includes>
          <filtering>false</filtering>
        </resource>
        <resource>
          <directory>src/main/java</directory>
          <includes>
            <include>**/*.properties</include>
            <include>**/*.xml</include>
          </includes>
          <filtering>false</filtering>
        </resource>
      </resources>
   
    </build>
   
  </project>
  ```

- 复制resources文件

  把3个配置文件复制到ssm/src/main/resources下面

  ![å¤å¶resourceæä»¶](http://stepimagewm.how2j.cn/5958.png)

- 关于Category.xml

  按照maven ssm项目风格来说，这个文件本应该放在Resource目录的mapper文件夹下，但是这么做还要修改配置信息，为了避免问题复杂化，而且考虑到即使放在当前位置也是可以正常工作的，所以就暂时不修改它的位置了。

  ![å³äºCategory.xml ](http://stepimagewm.how2j.cn/5961.png)

- 配置Tomcat

- 启动Tomcat

- 测试

### 导入SSM项目

- 导入项目

  File->New->Project from existing sources

  选择项目的pom.xml文件

- 启动Tomcat

- 测试

### 调试

- Deployment 的时候要用 exploded

  在Tomcat的Deploy对应的 Artifacts这里，需要选择tmall_ssm:war exploded, 不要选择第一个tmall_ssm:war.
  因为选war的话，每次修改了jsp都要重新打包成war才能看到效果，不便于观察jsp修改后的效果

  ![Deployment çæ¶åè¦ç¨ exploded](http://stepimagewm.how2j.cn/5910.png)

- 勾上 Update classes and resources

  在Tomcat的Server 下面两个 On ： 都设置为 Update classes and resources.
  其作用是把类和资源文件修改 同步更新掉
  On 'Update' action 是手动更新，或者点击快捷键CTRL+10更新
  On frame deactivation 是当idea失去焦点，比如打开浏览器的时候自动更新
  所以都勾上就好了

  ![å¾ä¸ Update classes and resources](http://stepimagewm.how2j.cn/5911.png)

- 使用Debug模式运行

  运行Tomcat的时候，采用debug模式，这样 [勾上 Update classes and resources](http://how2j.cn/k/idea/idea-debug/1392.html#step5911) 这一步导致的类自动更新就会引起Tomcat的reload，那么就不需要重新启动Tomcat也能看到效果了，便于修改代码和观察效果

### Autowired错误

- Autowired错误

  IDEA有时候无法正确地识别 @Autowired ，并发出不应该的报错

- 解决办法

  解决办法就是把这个报错级别，设置为Warning就好了
  File->Settings->Editor->Inspections->Spring->Spring Core->Code->Autowiring for Bean Class-> 从Error 修改为Warning 就好了

  ![è§£å³åæ³](http://stepimagewm.how2j.cn/5908.png)

### Git

> 配置Git

- 为IDEA指定git路径

  默认情况下，IDEA是不自带git运行程序的，所以需要通过
  菜单->settings->Version Control->Git->Path to Git executable: 设置为[安装git](http://how2j.cn/k/idea/idea-git-install/1359.html)中所安装的git.exe

- 设置github账号

  菜单->settings->Version Control->GitHub->Create API Token

> pull项目

- pull项目

  如何用IDEA从github上pull一个现成的项目到本地，并使用

- checkout

  菜单->VCS->Chekout from Version Control->GitHub

- 输入项目参数

  Git Repositor URL:https://github.com/how2j/higit.git
  Parent Directory: e:\project
  Directory Name: higit
  然后点击 Clone

> 创建项目

- 首先在github创建一个仓库

  点击右上角账号左边的加号，点击New repository创建仓库。
  Git上仓库就相当于项目的意思

- 输入仓库名称

- 创建成功，得到git地址

  得到github地址：https://github.com/Younkeryjk/hiworld

- 接着在本地创建一个项目

- 建立本地仓库

  菜单->VCS->import into Version Control->Create Git Repository->e:\project\hiworld-OK

- 把项目加入到本地仓库

  右键项目->Git->Add

- 提交项目

  右键项目->Git->Commit Directory之后弹出如图所示的窗口，在Commit Message 输入 test， 然后点击 Commit And Push

- Push Commit

  这里会询问你要提交的哪里去，点击Define remote,并输入在 [创建成功，得到git地址 ](http://how2j.cn/k/idea/idea-create/1364.html#step5804)步骤中的：

  ```
  https://github.com/Younkeryjk/hiworld
  ```

  然后点击push

> 提交和更新

- 提交改动

  使用快捷键**CTRL+K**,就会弹出提交的界面，点击Commit and Push即可

- 更新

  点击快捷键**Ctrl+T**，就会弹出更新的界面，点击OK即可