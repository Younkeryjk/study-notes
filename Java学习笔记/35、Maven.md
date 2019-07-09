# Maven

### 介绍

- 什么是Maven

  Maven 是专门用于构建和管理Java相关项目的工具。

- Maven 主要用处

  1. 相同的项目结构
     - 有一个pom.xml 用于维护当前项目都用了哪些jar包
     - 所有的java代码都放在 src/main/java 下面
     - 所有的测试代码都放在src/test/java 下面
  2. 统一维护jar包
     - 比如说有3个Java 项目，这些项目都不是maven风格。那么这3个项目，就会各自维护一套jar包。 而其中有些jar包是相同的。
     - 而maven风格的项目，首先把所有的jar包都放在"[仓库](http://how2j.cn/k/maven/maven-repositories/1330.html)“ 里，然后哪个项目需要用到这个jar包，只需要给出jar包的名称和版本号就行了。 这样**jar包就实现了共享**

### 下载与配置

- 下载

- 配置环境变量

  右键我的电脑-属性-高级系统设置-环境变量-系统变量-Path：填写Maven的bin目录路径

- 检验版本

  mvn -v

### 仓库

- 仓库概念

  仓库就是用于存放项目需要的jar包的。maven采用一个仓库，多个项目的方式，让多个项目共享一个仓库里的相同jar包。

- 仓库默认位置

  打开Maven安装位置\conf\settings.xml文件：

  ```
  Default: ${user.home}/.m2/repository
  ```

- 使用阿里云下载路径

  maven 会默认从maven官方提供的服务器下载jar包，可以使用国内maven 阿里云的下载地址

  打开Maven安装位置\conf\settings.xml，新加一个阿里云的镜像地址：

  ```
  <mirror>
  	<id>alimaven</id>
  	<mirrorOf>central</mirrorOf>
  	<name>aliyun maven</name>  				   
  	<url>http://maven.aliyun.com/nexus/content/repositories/central/</url>
  </mirror>
  ```

- 修改仓库位置

  打开Maven安装位置\conf\settings.xml文件：

  ```
  <localRepository>d:/maven/repository</localRepository>
  ```

### 创建maven项目

- 创建maven项目

  ```
  mvn archetype:generate -DgroupId=com.how2java -DartifactId=j2se -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
  ```

  **archetype:generate** 表示创建个项目
  **-DgroupId** 项目包名: com.how2java
  **-DartifactId** 项目名称: j2se
  **-DarchetypeArtifactId** 项目类型: maven-archetype-quickstart
  **-DinteractiveMode:false** 表示前面参数都给了，就不用一个一个地输入了

- 运行package命令进行打包

  在项目根目录运行：

  ```
  mvn package
  ```

  package做了很多事情，编译，测试，打包，最后生成了一个**j2se-1.0-SNAPSHOT.jar**包

- 执行Jar

  ```
  java -cp target/j2se-1.0-SNAPSHOT.jar com.how2java.App
  ```


### IDEA设置Maven

- File->Settings->Build, Execute, Deployment->Build Tools->Maven
- 修改 Maven home directory: d:/software/apache-maven-3.5.0
- 修改 User settings file: D:\software\apache-maven-3.5.0\conf\settings.xml
- Local repository 会被自动识别为 d:\maven\repository

### IDEA创建Maven项目

1. 新建项目

2. 选择maven项目

   1. 左边选择Maven
   2. 勾选Create from archetype
   3. 选择org.apache.maven.archetypes:maven-archetype-quickstart
   4. Next

3. 填写项目参数

4. 确认创建项目

5. Maven Import

   Maven项目创建了，IDEA还会做一些初始化的工作，那么需要点击右下角的 Import Changes

### IDEA增加jar包

- 修改pom.xml

  添加依赖

  ```
  <dependency>
  	<groupId>mysql</groupId>
  	<artifactId>mysql-connector-java</artifactId>
  	<version>5.1.21</version>
  </dependency>
  ```

- Maven import

  - 在修改了pom.xml之后，IDEA上会弹出这么一个 Maven projects need to be imported，点击Import Changes

  ![Maven import](http://stepimagewm.how2j.cn/5762.png)

- 再次执行

  再次执行可以观察到导入的jar包生效了

### IDEA Maven Web

1. 新建项目

2. 选中maven webapp格式

   1. 左边选中Maven
   2. 勾选Create from archetype
   3. 选中 org.apache.maven.archetypes:maven-archetype-webapp
   4. Next

3. 填写项目参数

4. 确认创建项目

5. Maven Import

   每次新建Maven项目，或者pom.xml有改动，都会有这个提示，这次点击Enable Auto-Import，自动导入，省掉麻烦。

6. 新建java源代码目录

   maven web项目默认是没有java源代码目录的，所以需要手动创建，并设置其为源代码目录
   右键main目录-> New->Directory->输入java->右键java->Mark Directory as-> Sources Root
   这样就创建了存放java源文件的目录了

7. 创建Servlet

   右键java->New->Servlet->HelloServlet

8. 修改web.xml

   修改web.xml,添加/hello映射

   ```
   <web-app>
     <display-name>Archetype Created Web Application</display-name>
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

9. 修改pom.xml

   修改pom.xml, 添加servletjar包依赖

   ```
   <dependency>
   	<groupId>javax.servlet</groupId>
   	<artifactId>javax.servlet-api</artifactId>
   	<version>3.1.0</version>
   </dependency>
   ```

10. 配置Tomcat

11. 启动Tomcat

12. 运行并测试

13. 看不到Servlet选项？请更新.iml文件

    1. 在IDEA中打开.iml文件
    2. 添加如图所示的代码，或者复制此处代码覆盖j2ee.iml文件
    3. 菜单-File->Close Project
    4. 重新打开项目，就能够看到[新建Servlet](http://how2j.cn/k/idea/idea-maven-web/1356.html#step5771)步骤截图里的Servlet选项了

    ```
    <sourceRoots>
      <root url="file://$MODULE_DIR$/src/main/resources" />
      <root url="file://$MODULE_DIR$/src/main/java" />
    </sourceRoots>
    ```

    ![çä¸å°Servletéé¡¹ï¼è¯·æ´æ°.imlæä»¶](http://stepimagewm.how2j.cn/5772.png)

### IDEA父子项目

- 父子-聚合项目

  通过 maven 可以创建父子-聚合项目。 所谓的父子项目，即有一个父项目，有多个子项目。

  这些子项目，在业务逻辑上，都归纳在这个父项目下，并且一般来说，都会有重复的jar包共享。
  所以常用的做法会把重复的 jar 包都放在父项目下进行依赖，那么子项目就无需再去依赖这些重复的 jar 包了。

- 创建流程

  1. 创建父项目

  2. 选择父项目maven项目

     1. 左边选择Maven
     2. 勾选Create from archetype
     3. 选择org.apache.maven.archetypes:maven-archetype-quickstart
     4. Next

  3. 输入父项目参数

  4. 确认创建父项目

  5. 修改父项目pom.xml

     1. 默认是 jar, 修改为pom。 这样才可以作为父项目存在。

        ```
        <packaging>pom</packaging>
        ```

     2. 增加 hutool jar 和 junit 包的依赖，用于后来子项目里观察对其的调用。

        ```
        <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
          <modelVersion>4.0.0</modelVersion>
          <groupId>cn.how2j</groupId>
          <artifactId>parentMavenProject</artifactId>
          <version>0.0.1-SNAPSHOT</version>
          <modules>
            <module>childMavenProject</module>
          </modules>
          <name>parentMavenProject</name>
          <description>parentMavenProject</description>
          <packaging>pom</packaging>
          <dependencies>
            <dependency>
              <groupId>junit</groupId>
              <artifactId>junit</artifactId>
              <version>4.11</version>
              <scope>test</scope>
            </dependency>
            <dependency>
              <groupId>cn.hutool</groupId>
              <artifactId>hutool-all</artifactId>
              <version>4.3.1</version>
            </dependency>
          </dependencies>
        </project>
        ```

  6. 创建子项目

     所谓的子项目，其实是maven module.
     右键点击 parentMavenProject->New->Module.

  7. 选择子项目maven项目

     1. 左边选择Maven
     2. 勾选Create from archetype
     3. 选择org.apache.maven.archetypes:maven-archetype-quickstart
     4. Next

  8. 输入子项目参数

  9. 确认创建子项目

  10. 测试

      在 childMavenProject 下新建 TestHutool类，并运行。
      可以发现，是可以使用 hutool jar 里的类的。 这说明子项目，能够使用 父项目中的 jar 包了。