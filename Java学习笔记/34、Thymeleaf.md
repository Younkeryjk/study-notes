# thymeleaf

### 入门

- pom.xml

  修改 pom.xml, 增加了对 thymeleaf 的支持。

  ```
  <dependency>
  	<groupId>org.springframework.boot</groupId>
  	<artifactId>spring-boot-starter-thymeleaf</artifactId>	
  </dependency>
  ```

- html文件

  在 resources 下新建目录 templates, 然后新建文件 hello.html

  **注：** **并不是在 webapp下，这点和 jsp 不一样**

  html文件 做了如下事情：

  1. 声明当前文件是 thymeleaf, 里面可以用th开头的属性

     ```
     <html xmlns:th="http://www.thymeleaf.org">
     ```

  2. 值显示用的是th开头的属性: th:text, 而取值用的是 "${name}" 

     ```
     <p th:text="${name}" >name</p>
     ```

  3. 字符串拼写

     两种方式，一种是用加号，一种是在前后放上 ||, 显然第二种方式可读性更好。 

     ```
     <p th:text="'Hello！ ' + ${name} + '!'" >hello world</p>
     <p th:text="|Hello！ ${name}!|" >hello world</p>
     ```

     这两种方式都会得到： hello thymeleaf。

- application.properties

  ```
  #thymeleaf 配置
  spring.thymeleaf.mode=HTML5
  spring.thymeleaf.encoding=UTF-8
  spring.thymeleaf.content-type=text/html
  #缓存设置为false, 这样修改之后马上生效，便于调试
  spring.thymeleaf.cache=false
  #上下文
  server.context-path=/thymeleaf
  ```

## url

- 静态文件

  在 webapp 目录下新建静态文件，包括css和js等文件

- 调用静态文件

  通过 th:href="@{/static/css/style.css}" 和 th:src="@{/static/js/thymeleaf.js}" 引入 css 和 js 文件

  ```
  <link rel="stylesheet" type="text/css" media="all" href="../../webapp/static/css/style.css" th:href="@{/static/css/style.css}"/>
  <script type="text/javascript" src="../../webapp/static/js/thymeleaf.js" th:src="@{/static/js/thymeleaf.js}"></script>
  ```

  注意几点： 
  1. 使用 @这种方式引入，在渲染后的html 里会自动生成 上下文路径，既如图所示的 /thymeleaf 这个路径

  2. 如果使用浏览器直接打开当前的 hello.html, 依然可以看到css 和 js 效果，所以这样就非常方便前端开发和测试，因为如下代码起作用：

     ```
     href="../../webapp/static/css/style.css"
     src="../../webapp/static/js/thymeleaf.js"
     ```

### 表达式

- 转义和非转义的html

  ```
  <p th:text="${htmlContent}" ></p>
  <p th:utext="${htmlContent}" ></p>
  ```

-  获取对象属性的两种方式

  ```
  <p th:text="${currentProduct.name}" ></p>
  <p th:text="${currentProduct.getName()}" ></p>
  ```

-  使用 *{} 方式显示当前对象的属性

  ```
  <div class="showing" th:object="${currentProduct}">
  <p th:text="*{name}" ></p>
  </div>
  ```

-  算数运算

  ```
  <p th:text="${currentProduct.price+999}" ></p>
  ```

### 包含

- include.html

  新建一个 include.html 文件，然后里面用 th:fragment 标记代码片段。

  footer1 是 不带参数的
  footer2 是带参数的

  ```
  <html xmlns:th="http://www.thymeleaf.org">
  <footer th:fragment="footer1"> 
     <p >All Rights Reserved</p>
  </footer>
  <footer th:fragment="footer2(start,now)"> 
     <p th:text="|${start} - ${now} All Rights Reserved|"></p>
  </footer>
  </html>
  双击选中所有代码
   步骤 5 : test.html
  ```

- 调用方式 test.html

  ```
  <div th:replace="include::footer1" ></div>
  <div th:replace="include::footer2(2015,2018)" ></div>
  ```

  除了th:replace， 还可以用th:insert, 区别：
  th:insert ：保留自己的主标签，保留th:fragment的主标签。
  th:replace ：不要自己的主标签，保留th:fragment的主标签。

### 条件

- th:if

  Thymeleaf 的条件判断是 通过 th:if 来做

  ```
  <p th:if="${testBoolean}" >如果testBoolean 是 true ，本句话就会显示</p>
  ```

- not和th:unless

  取反可以用not, 或者用th:unless.

  ```
  <p th:if="${not testBoolean}" >取反 ，所以如果testBoolean 是 true ，本句话就不会显示</p>
  <p th:unless="${testBoolean}" >unless 等同于上一句，所以如果testBoolean 是 true ，本句话就不会显示</p>
  ```

- 三元表达式

  $(expression)?var1:var2

  ```
  <p th:text="${testBoolean}?'当testBoolean为真的时候，显示本句话，这是用三相表达式做的':''" ></p>
  ```

### 遍历

- 普通遍历

  使用 th:each 遍历

  ```
  <tr th:each="p: ${ps}">
  	<td th:text="${p.name}"></td>
  </tr>
  ```

- 带状态的遍历

  使用 th:each="p,status: ${ps} 方式遍历就把状态放在 status里面了， 同时还用3元表达式判断奇偶

  ```
  th:class="${status.even}?'even':'odd'" 
  ```

  status里还包含了如下信息：

  - index 属性, 0 开始的索引值
  - count 属性, 1 开始的索引值
  - size 属性, 集合内元素的总量
  - current 属性, 当前的迭代对象
  - even/odd 属性, boolean 类型的, 用来判断是否是偶数个还是奇数个
  - first 属性, boolean 类型, 是否是第一个
  - last 属性, boolean 类型, 是否是最后一个

  ```
  <tr th:class="${status.even}?'even':'odd'" th:each="p,status: ${ps}">
  	<td  th:text="${status.index}"></td>
  	<td th:text="${p.name}"></td>
  </tr>
  ```

- 下拉框

  还是用 th:each,但是放在option元素上，就可以遍历出多个下拉框出来了。

  其中 th:selected 表示被选中的项。

  ```
  <select >
          <option th:each="p:${ps}" th:value="${p.id}"     th:selected="${p.id==currentProduct.id}"    th:text="${p.name}" ></option>
  </select>
  ```

- 单选框

  ```
  <input name="product" type="radio" th:each="p:${ps}" th:value="${p.id}"  th:checked="${p.id==currentProduct.id}"     th:text="${p.name}"  />
  ```

### 内置工具

- thymeleaf 内置工具

  一共有如下16种：

  ```
  Execution Info 获取页面模板的处理信息
  Messages 在变量表达式中获取外部消息的方法，与使用＃{...}语法获取的方法相同
  URIs/URLs 转义部分URL / URI的方法
  Conversions 用于执行已配置的转换服务的方法
  Dates 时间操作和时间格式化等
  Calendars 用于更复杂时间的格式化
  Numbers 格式化数字对象的方法
  Strings 字符串工具类
  Objects 一般对象类，通常用来判断非空
  Booleans 常用的布尔方法
  Arrays 数组工具类
  Lists List 工具类
  Sets Set 工具类
  Maps 常用Map方法
  Aggregates 在数组或集合上创建聚合的方法
  IDs 处理可能重复的id属性的方法
  ```

- Execution Info

  ```
  ${#execInfo.templateName}
  ${#execInfo.templateMode}
  ${#execInfo.processedTemplateName}
  ${#execInfo.processedTemplateMode}
  ${#execInfo.templateNames}
  ${#execInfo.templateModes}
  ${#execInfo.templateStack}
  ```

- Messages

  ```
  ${#messages.msg('msgKey')}
  ${#messages.msg('msgKey', param1)}
  ${#messages.msg('msgKey', param1, param2)}
  ${#messages.msg('msgKey', param1, param2, param3)}
  ${#messages.msgWithParams('msgKey', new Object[] {param1, param2, param3, param4})}
  ${#messages.arrayMsg(messageKeyArray)}
  ${#messages.listMsg(messageKeyList)}
  ${#messages.setMsg(messageKeySet)}
  ${#messages.msgOrNull('msgKey')}
  ${#messages.msgOrNull('msgKey', param1)}
  ${#messages.msgOrNull('msgKey', param1, param2)}
  ${#messages.msgOrNull('msgKey', param1, param2, param3)}
  ${#messages.msgOrNullWithParams('msgKey', new Object[] {param1, param2, param3, param4})}
  ${#messages.arrayMsgOrNull(messageKeyArray)}
  ${#messages.listMsgOrNull(messageKeyList)}
  ${#messages.setMsgOrNull(messageKeySet)}
  ```

- URIs/URLs

  ```
  ${#uris.escapePath(uri)}
  ${#uris.escapePath(uri, encoding)}
  ${#uris.unescapePath(uri)}
  ${#uris.unescapePath(uri, encoding)}
  ${#uris.escapePathSegment(uri)}
  ${#uris.escapePathSegment(uri, encoding)}
  ${#uris.unescapePathSegment(uri)}
  ${#uris.unescapePathSegment(uri, encoding)}
  ${#uris.escapeFragmentId(uri)}
  ${#uris.escapeFragmentId(uri, encoding)}
  ${#uris.unescapeFragmentId(uri)}
  ${#uris.unescapeFragmentId(uri, encoding)}
  ${#uris.escapeQueryParam(uri)}
  ${#uris.escapeQueryParam(uri, encoding)}
  ${#uris.unescapeQueryParam(uri)}
  ${#uris.unescapeQueryParam(uri, encoding)}
  ```

- Conversions

  ```
  ${#conversions.convert(object, 'java.util.TimeZone')}
  ${#conversions.convert(object, targetClass)}
  ```

- Dates

  ```
  ${#dates.format(date)}
  ${#dates.arrayFormat(datesArray)}
  ${#dates.listFormat(datesList)}
  ${#dates.setFormat(datesSet)}
  ${#dates.formatISO(date)}
  ${#dates.arrayFormatISO(datesArray)}
  ${#dates.listFormatISO(datesList)}
  ${#dates.setFormatISO(datesSet)}
  ${#dates.format(date, 'dd/MMM/yyyy HH:mm')}
  ${#dates.arrayFormat(datesArray, 'dd/MMM/yyyy HH:mm')}
  ${#dates.listFormat(datesList, 'dd/MMM/yyyy HH:mm')}
  ${#dates.setFormat(datesSet, 'dd/MMM/yyyy HH:mm')}
  ${#dates.day(date)}                    
  ${#dates.month(date)}                  
  ${#dates.monthName(date)}              
  ${#dates.monthNameShort(date)}         
  ${#dates.year(date)}                   
  ${#dates.dayOfWeek(date)}              
  ${#dates.dayOfWeekName(date)}          
  ${#dates.dayOfWeekNameShort(date)}     
  ${#dates.hour(date)}                   
  ${#dates.minute(date)}                 
  ${#dates.second(date)}                 
  ${#dates.millisecond(date)}            
  ${#dates.create(year,month,day)}
  ${#dates.create(year,month,day,hour,minute)}
  ${#dates.create(year,month,day,hour,minute,second)}
  ${#dates.create(year,month,day,hour,minute,second,millisecond)}
  ${#dates.createNow()}
  ${#dates.createNowForTimeZone()}
  ${#dates.createToday()}
  ${#dates.createTodayForTimeZone()}
  ```

- Calendars

  ```
  ${#calendars.format(cal)}
  ${#calendars.arrayFormat(calArray)}
  ${#calendars.listFormat(calList)}
  ${#calendars.setFormat(calSet)}
  ${#calendars.formatISO(cal)}
  ${#calendars.arrayFormatISO(calArray)}
  ${#calendars.listFormatISO(calList)}
  ${#calendars.setFormatISO(calSet)}
  ${#calendars.format(cal, 'dd/MMM/yyyy HH:mm')}
  ${#calendars.arrayFormat(calArray, 'dd/MMM/yyyy HH:mm')}
  ${#calendars.listFormat(calList, 'dd/MMM/yyyy HH:mm')}
  ${#calendars.setFormat(calSet, 'dd/MMM/yyyy HH:mm')}
  ${#calendars.day(date)}                
  ${#calendars.month(date)}              
  ${#calendars.monthName(date)}          
  ${#calendars.monthNameShort(date)}     
  ${#calendars.year(date)}               
  ${#calendars.dayOfWeek(date)}          
  ${#calendars.dayOfWeekName(date)}      
  ${#calendars.dayOfWeekNameShort(date)} 
  ${#calendars.hour(date)}               
  ${#calendars.minute(date)}             
  ${#calendars.second(date)}             
  ${#calendars.millisecond(date)}        
  ${#calendars.create(year,month,day)}
  ${#calendars.create(year,month,day,hour,minute)}
  ${#calendars.create(year,month,day,hour,minute,second)}
  ${#calendars.create(year,month,day,hour,minute,second,millisecond)}
  ${#calendars.createForTimeZone(year,month,day,timeZone)}
  ${#calendars.createForTimeZone(year,month,day,hour,minute,timeZone)}
  ${#calendars.createForTimeZone(year,month,day,hour,minute,second,timeZone)}
  ${#calendars.createForTimeZone(year,month,day,hour,minute,second,millisecond,timeZone)}
  ${#calendars.createNow()}
  ${#calendars.createNowForTimeZone()}
  ${#calendars.createToday()}
  ${#calendars.createTodayForTimeZone()}
  ```

- Numbers

  ```
  ${#numbers.formatInteger(num,3)}
  ${#numbers.arrayFormatInteger(numArray,3)}
  ${#numbers.listFormatInteger(numList,3)}
  ${#numbers.setFormatInteger(numSet,3)}
  ${#numbers.formatInteger(num,3,'POINT')}
  ${#numbers.arrayFormatInteger(numArray,3,'POINT')}
  ${#numbers.listFormatInteger(numList,3,'POINT')}
  ${#numbers.setFormatInteger(numSet,3,'POINT')}
  ${#numbers.formatDecimal(num,3,2)}
  ${#numbers.arrayFormatDecimal(numArray,3,2)}
  ${#numbers.listFormatDecimal(numList,3,2)}
  ${#numbers.setFormatDecimal(numSet,3,2)}
  ${#numbers.formatDecimal(num,3,2,'COMMA')}
  ${#numbers.arrayFormatDecimal(numArray,3,2,'COMMA')}
  ${#numbers.listFormatDecimal(numList,3,2,'COMMA')}
  ${#numbers.setFormatDecimal(numSet,3,2,'COMMA')}
  ${#numbers.formatDecimal(num,3,'POINT',2,'COMMA')}
  ${#numbers.arrayFormatDecimal(numArray,3,'POINT',2,'COMMA')}
  ${#numbers.listFormatDecimal(numList,3,'POINT',2,'COMMA')}
  ${#numbers.setFormatDecimal(numSet,3,'POINT',2,'COMMA')}
  ${#numbers.formatCurrency(num)}
  ${#numbers.arrayFormatCurrency(numArray)}
  ${#numbers.listFormatCurrency(numList)}
  ${#numbers.setFormatCurrency(numSet)}
  ${#numbers.formatPercent(num)}
  ${#numbers.arrayFormatPercent(numArray)}
  ${#numbers.listFormatPercent(numList)}
  ${#numbers.setFormatPercent(numSet)}
  ${#numbers.formatPercent(num, 3, 2)}
  ${#numbers.arrayFormatPercent(numArray, 3, 2)}
  ${#numbers.listFormatPercent(numList, 3, 2)}
  ${#numbers.setFormatPercent(numSet, 3, 2)}
  ${#numbers.sequence(from,to)}
  ${#numbers.sequence(from,to,step)}
  ```

- Strings

  ```
  ${#strings.toString(obj)}                           
  ${#strings.isEmpty(name)}
  ${#strings.arrayIsEmpty(nameArr)}
  ${#strings.listIsEmpty(nameList)}
  ${#strings.setIsEmpty(nameSet)}
  ${#strings.defaultString(text,default)}
  ${#strings.arrayDefaultString(textArr,default)}
  ${#strings.listDefaultString(textList,default)}
  ${#strings.setDefaultString(textSet,default)}
  ${#strings.contains(name,'ez')}                     
  ${#strings.containsIgnoreCase(name,'ez')}           
  ${#strings.startsWith(name,'Don')}                  
  ${#strings.endsWith(name,endingFragment)}           
  ${#strings.indexOf(name,frag)}                      
  ${#strings.substring(name,3,5)}                     
  ${#strings.substringAfter(name,prefix)}             
  ${#strings.substringBefore(name,suffix)}            
  ${#strings.replace(name,'las','ler')}               
  ${#strings.prepend(str,prefix)}                     
  ${#strings.append(str,suffix)}                      
  ${#strings.toUpperCase(name)}                       
  ${#strings.toLowerCase(name)}                       
  ${#strings.arrayJoin(namesArray,',')}
  ${#strings.listJoin(namesList,',')}
  ${#strings.setJoin(namesSet,',')}
  ${#strings.arraySplit(namesStr,',')}                
  ${#strings.listSplit(namesStr,',')}                 
  ${#strings.setSplit(namesStr,',')}                  
  ${#strings.trim(str)}                               
  ${#strings.length(str)}                             
  ${#strings.abbreviate(str,10)}                      
  ${#strings.capitalize(str)}                         
  ${#strings.unCapitalize(str)}                       
  ${#strings.capitalizeWords(str)}                    
  ${#strings.capitalizeWords(str,delimiters)}         
  ${#strings.escapeXml(str)}                          
  ${#strings.escapeJava(str)}                         
  ${#strings.escapeJavaScript(str)}                   
  ${#strings.unescapeJava(str)}                       
  ${#strings.unescapeJavaScript(str)}                 
  ${#strings.equals(first, second)}
  ${#strings.equalsIgnoreCase(first, second)}
  ${#strings.concat(values...)}
  ${#strings.concatReplaceNulls(nullValue, values...)}
  ${#strings.randomAlphanumeric(count)}
  ```

- Objects

  ```
  ${#objects.nullSafe(obj,default)}
  ${#objects.arrayNullSafe(objArray,default)}
  ${#objects.listNullSafe(objList,default)}
  ${#objects.setNullSafe(objSet,default)}
  ```

- Booleans

  ```
  ${#bools.isTrue(obj)}
  ${#bools.arrayIsTrue(objArray)}
  ${#bools.listIsTrue(objList)}
  ${#bools.setIsTrue(objSet)}
  ${#bools.isFalse(cond)}
  ${#bools.arrayIsFalse(condArray)}
  ${#bools.listIsFalse(condList)}
  ${#bools.setIsFalse(condSet)}
  ${#bools.arrayAnd(condArray)}
  ${#bools.listAnd(condList)}
  ${#bools.setAnd(condSet)}
  ${#bools.arrayOr(condArray)}
  ${#bools.listOr(condList)}
  ${#bools.setOr(condSet)}
  ```

- Arrays

  ```
  ${#arrays.toArray(object)}
  ${#arrays.toStringArray(object)}
  ${#arrays.toIntegerArray(object)}
  ${#arrays.toLongArray(object)}
  ${#arrays.toDoubleArray(object)}
  ${#arrays.toFloatArray(object)}
  ${#arrays.toBooleanArray(object)}
  ${#arrays.length(array)}
  ${#arrays.isEmpty(array)}
  ${#arrays.contains(array, element)}
  ${#arrays.containsAll(array, elements)}
  ```

- Lists

  ```
  ${#lists.toList(object)}
  ${#lists.size(list)}
  ${#lists.isEmpty(list)}
  ${#lists.contains(list, element)}
  ${#lists.containsAll(list, elements)}
  ${#lists.sort(list)}
  ${#lists.sort(list, comparator)}
  ${#sets.toSet(object)}
  ```

- Sets

  ```
  ${#sets.size(set)}
  ${#sets.isEmpty(set)}
  ${#sets.contains(set, element)}
  ${#sets.containsAll(set, elements)}
  ```

- Maps

  ```
  ${#maps.size(map)}
  ${#maps.isEmpty(map)}
  ${#maps.containsKey(map, key)}
  ${#maps.containsAllKeys(map, keys)}
  ${#maps.containsValue(map, value)}
  ${#maps.containsAllValues(map, value)}
  ```

- Aggregates

  ```
  ${#aggregates.sum(array)}
  ${#aggregates.sum(collection)}
  ${#aggregates.avg(array)}
  ${#aggregates.avg(collection)}
  ```

- IDs

  ```
  ${#ids.seq('someId')}
  ${#ids.next('someId')}
  ${#ids.prev('someId')}
  ```

