#Log4j 

>System.out.println

- System.out.println的缺点： 
  1. 不知道这句话是在哪个类，哪个线程里出来的
  2. 不知道前后两句输出间隔了多少时间 
  3. 无法关闭调试信息，一旦System.out.println多了之后，到处都是输出，增加定位自己需要信息的难度 

***

 > 使用Log4j

- 导入jar包

- 使用Log4j看到输出结果有几个改观：
  1. 知道是log4j.TestLog4j这个类里的日志 
  2. 是在[main]线程里的日志 
  3. 日志级别可观察，一共有6个级别 TRACE DEBUG INFO WARN ERROR FATAL 
  4. 日志输出级别范围可控制， 如代码所示，只输出高于DEBUG级别的，那么TRACE级别的日志自动不输出
  5. 每句日志消耗的毫秒数(最前面的数字)，可观察，这样就可以进行性能计算 

- 代码讲解：

​	1.基于类的名称获取日志对象 

​	`static Logger logger = Logger.getLogger(TestLog4j.class); `

​	2.进行默认配置 

​	`BasicConfigurator.configure(); `

​	3.设置日志输出级别 

​	logger.setLevel(Level.DEBUG); 

​	4.进行不同级别的日志输出 

```
logger.trace("跟踪信息");
logger.debug("调试信息");
logger.info("输出信息");
Thread.sleep(1000);
logger.warn("警告信息");
logger.error("错误信息");
logger.fatal("致命信息");
```

***

>  配置Log4j

- log4j.properties：

在src目录下添加log4j.properties文件：

```
log4j.rootLogger=debug, stdout, R

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout

# Pattern to output the caller's file name and line number.
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] (%F:%L) - %m%n

log4j.appender.R=org.apache.log4j.RollingFileAppender
log4j.appender.R.File=example.log

log4j.appender.R.MaxFileSize=100KB
# Keep one backup file
log4j.appender.R.MaxBackupIndex=5

log4j.appender.R.layout=org.apache.log4j.PatternLayout
log4j.appender.R.layout.ConversionPattern=%p %t %c - %m%n
```

- 有两个效果

  1. 输出在控制台，并且格式有所变化，如图所示，会显示是哪个类的哪一行输出的信息 
  2. 不仅仅在控制台有输出，在把日志记录到了 example.log 这个文件

- 分析代码

  采用指定配置文件： 

  ```
  PropertyConfigurator.configure("e:\\project\\log4j\\src\\log4j.properties");
  ```

- 解释log4j.properties

  设置日志输出的等级为debug,低于debug就不会输出了 

  设置日志输出到两种地方，分别叫做 stdout和 R 

  ```
  log4j.rootLogger=debug, stdout, R
  ```

  第一个地方stdout, 输出到控制台

  ```
  log4j.appender.stdout=org.apache.log4j.ConsoleAppender
  ```

  第二个地方R, 以滚动的方式输出到文件，文件名是example.log,文件最大100k, 最多滚动5个文件 

  ```
  log4j.appender.R=org.apache.log4j.RollingFileAppender
  log4j.appender.R.File=example.log
  log4j.appender.R.MaxFileSize=100KB
  log4j.appender.R.MaxBackupIndex=5
  ```

- 格式解释 

  log4j日志输出格式： 

  - %c 输出日志信息所属的类的全名 
  - %d 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyy-MM-dd HH:mm:ss }，输出类似：2002-10-18- 22：10：28 
  - %f 输出日志信息所属的类的类名 
  - %l 输出日志事件的发生位置，即输出日志信息的语句处于它所在的类的第几行 
  - %m 输出代码中指定的信息，如log(message)中的message 
  - %n 输出一个回车换行符，Windows平台为“rn”，Unix平台为“n” 
  - %p 输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL。如果是调用debug()输出的，则为DEBUG，依此类推 
  - %r 输出自应用启动到输出该日志信息所耗费的毫秒数 
  - %t 输出产生该日志事件的线程名 

%5p [%t] (%F:%L) - %m%n 就表示：

宽度是5的优先等级 线程名称 (文件名:行号) - 信息 回车换行 

![æ ¼å¼è§£é](http://stepimagewm.how2j.cn/4166.png) 

------

> log4j.xml 

- 也可以使用xml格式进行配置：

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration PUBLIC "-//log4j/log4j Configuration//EN" "log4j.dtd">
 
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
     
    <appender name="STDOUT" class="org.apache.log4j.ConsoleAppender">
       <layout class="org.apache.log4j.PatternLayout"> 
          <param name="ConversionPattern" value="%d %-5p %c.%M:%L - %m%n"/> 
       </layout> 
    </appender>
  
    <!-- specify the logging level for loggers from other libraries -->
    <logger name="com.opensymphony">
        <level value="ERROR" />
    </logger>
 
    <logger name="org.apache">
         <level value="ERROR" />
    </logger>
    <logger name="org.hibernate">
         <level value="ERROR" />
    </logger>
   
   <!-- for all other loggers log only debug and above log messages -->
     <root>
        <priority value="ERROR"/> 
        <appender-ref ref="STDOUT" /> 
     </root> 
     
</log4j:configuration> 
```

