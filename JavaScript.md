# JavaScript

### 语言基础

#### Hello JavaScript

- 组成

  完整的javascript由[语言基础](http://how2j.cn/k/javascript/javascript-type/428.html)，[BOM](http://how2j.cn/k/javascript/javascript-bom-window/449.html)和[DOM](http://how2j.cn/k/dom/dom-node/457.html)组成。

  只有通过javascript操作DOM对象的时候，才会带来很好的实用效果

- 编译型语言和解释型语言的区别

  - 编译型语言在程序执行之前，有一个单独的编译过程，将程序翻译成机器语言，以后执行这个程序的时候，就不用再进行翻译了

  - 解释型语言，是在运行的时候将程序翻译成机器语言，所以运行速度相对于编译型语言要慢

  - C/C++ 等都是编译型语言，而Java，C#，Javascript 等都是解释型语言。

    但是Java明明有一个从.java文件编译成.class文件的过程，为什么不是编译语言，而是解释语言呢？ 因为.class文件，并不是机器语言，而是一个平台无关的"中间语言“ 需要再在虚拟机中再执行

#### 变量

- 声明

  使用var声明一个变量

- 不使用var

  不用var则是一个全局变量

- 变量命名

  开头可以用 _$和字母，其他部分可以用 $ _ 字母或者数字

#### 基本数据类型

- 5种基本数据类型

  1. undefined

     当一个变量被声明了，却没有赋值的时候，叫做 undefined

     ```
     <script>
       var x; //声明了变量x,但是没有赋值
       document.write('声明了，但是没有赋值的变量 x: '+x);
     </script>
     ```

  2. Boolean

     Boolean变量有两种值，分别是true或者false

  3. Number

     javascript中的Number可以表示十进制，八进制，十六进制整数，浮点数，科学记数法

     ```
     <script>
       var a=10; //十进制
       var b=012;//第一位是0，表示八进制
       var c=0xA;//0x开头表示十六进制
       var d=3.14;//有小数点表示浮点数
       var e=3.14e2;//使用e的幂表示科学计数法
       document.write("十进制 10 的值: "+a);
       //十进制 10 的值: 10
       document.write("八进制 012 的值: "+b);
       //八进制 012 的值: 10
       document.write("十六进制 0xA 的值: "+c);
       //十六进制 0xA 的值: 10
       document.write("浮点数 3.14 的值: "+d);
       //浮点数 3.14 的值: 3.14
       document.write("科学记数法 3.14e2 的值: "+e);
       //科学记数法 3.14e2 的值: 314
     </script>
     ```

  4. String

     - javaScript中没有字符的概念

       与java不同的是，javascript中没有字符的概念，只有字符串，所以单引号和双引号，都用来表示字符串。

  5. null

     null表示一个对象不存在

- 动态类型

  变量的类型是动态的，当值是整数的时候，就是Number类型，当值是字符串的时候，就是String类型

  ```
  <script>
    var x=10; //Number类型
    document.write("此时 x的值是 "+x+" 类型是数字");
    //此时 x的值是 10 类型是数字
    x = "hello javascript"; //String类型
    document.write("此时 x的值是 "+x+" 类型是字符串");
    //此时 x的值是 hello javascript 类型是字符串
  </script>
  ```

- 变量类型判断

  使用**typeof**来进行判断数据类型

  正是因为变量是动态类型的，所以无法确定**当前到底是哪种类型**，这个时候，就可以使用typeof来进行判断

  ```
  <script>
    var x;
    document.write('声明了但是未赋值的时候，类型是： '+typeof x);
   //声明了但是未赋值的时候，类型是： undefined
    x=5;
    document.write('赋值为5之后，类型是： '+typeof x);
    //赋值为5之后，类型是： number
    x=5.1;
    document.write('赋值为5.1之后，类型是： '+typeof x);
    //赋值为5.1之后，类型是： number
    x=true;
    document.write('赋值为true之后，类型是： '+typeof x);
    //赋值为true之后，类型是： boolean
    x="hello";
    document.write('赋值为hello之后，类型是： '+typeof x);
    //赋值为hello之后，类型是： string
  </script>
  ```

#### 类型转换

- 伪对象

  即便是基本类型，也是伪对象，所以他们都有属性和方法。

  例：变量a的类型是字符串，通过调用其为伪对象的属性length获取其长度

  ```
  <script>
    var a="hello javascript";
    document.write("变量a的类型是:"+(typeof a));
    //变量a的类型是:string
    document.write("变量a的长度是:"+a.length);
    //变量a的长度是:16
  </script>
  ```

  

- 转换为字符串

  toString方法用于转换为字符串

  ```
  <script>
    var a=10;
    document.write("数字 "+a+" 转换为字符串"+a.toString());
   //数字 10 转换为字符串10
    var b=true;
    document.write("布尔 "+b+" 转换为字符串"+b.toString());
   //布尔 true 转换为字符串true
    var c="hello javascript";
    document.write("字符串 "+c+" 转换为字符串 "+c.toString());
   //字符串 hello javascript 转换为字符串 hello javascript
  </script>
  ```

- 数字转字符串

  Number转换为字符串的时候有**默认模式**和**基模式**两种

  ```
  <script>
    var a=10;
    document.write('默认模式下，数字10转换为十进制的'+a.toString()); //默认模式，即十进制
    //默认模式下，数字10转换为十进制的10
    document.write('基模式下，数字10转换为二进制的'+a.toString(2)); //基模式，二进制
    //基模式下，数字10转换为二进制的1010
  </script>
  ```

- 转换为数字

  javascript分别提供内置函数 parseInt()和parseFloat()，转换为数字

  **注：如果被转换的字符串，同时由数字和字符构成，那么parseInt会一直定位数字，直到出现非字符。 所以"10abc" 会被转换为 10**

  ```
  <script>
    document.write("字符串的\"10\"转换为数字的:"+parseInt("10")); //转换整数
    //字符串的"10"转换为数字的:10
    document.write("字符串的\"3.14\"转换为数字的:"+parseFloat("3.14"));//转换浮点数
    //字符串的"3.14"转换为数字的:3.14
    document.write("字符串的\"10abc\"转换为数字的:"+parseInt("10abc")); //判断每一位，直到发现不是数字的那一位
    //字符串的"10abc"转换为数字的:10
    document.write("字符串的\"hello javascript\"转换为数字的:"+parseInt("hello javascript")); //如果完全不包含数字，则返回NaN - Not a Number
    //字符串的"hello javascript"转换为数字的:NaN
  </script>
  ```

- 转换为Boolean

  使用内置函数Boolean() 转换为Boolean值

  - 当转换字符串时：**非空即为true**
  - 当转换数字时：**非0即为true**
  - 当转换对象时：**非null即为true**

  ```
  document.write("空字符串''转换为布尔后的值:"+Boolean(""));  //空字符串
  //空字符串''转换为布尔后的值:false
  document.write("非空字符'hello javascript '串转换为布尔后的值:"+Boolean("hello javascript"));  //非空字符串
  //非空字符'hello javascript '串转换为布尔后的值:true
  document.write("数字 0 转换为布尔后的值:"+Boolean(0));  //0
  //数字 0 转换为布尔后的值:false
  document.write("数字 3.14 转换为布尔后的值:"+Boolean(3.14)); //非0
  //数字 3.14 转换为布尔后的值:true
  document.write("空对象 null 转换为布尔后的值:"+Boolean(null));  //null
  //空对象 null 转换为布尔后的值:false
  document.write("非空对象 new Object() 转换为布尔后的值:"+Boolean(new Object()));  //对象存在
  //非空对象 new Object() 转换为布尔后的值:true
  ```

- Number()和parseInt()的区别

  Number()和parseInt()一样，都可以用来进行数字的转换，区别在于：

  **当转换的内容包含非数字的时候，Number() 会返回NaN(Not a Number)**
  **parseInt() 要看情况，如果以数字开头，就会返回开头的合法数字部分，如果以非数字开头，则返回NaN**

  ```
  <script>
    document.write("通过Number() 函数转换字符串'123' 后得到的数字："+Number("123"));   //正常的
    //通过Number() 函数转换字符串'123' 后得到的数字：123
    document.write("通过Number() 函数转换字符串'123abc' 后得到的数字："+Number("123abc"));   //包含非数字
    //通过Number() 函数转换字符串'123abc' 后得到的数字：NaN
    document.write("通过Number() 函数转换字符串'abc123' 后得到的数字："+Number("abc123"));   //包含非数字
    //通过Number() 函数转换字符串'abc123' 后得到的数字：NaN
   
    document.write("通过parseInt() 函数转换字符串'123' 后得到的数字："+parseInt("123"));   //正常的
    //通过parseInt() 函数转换字符串'123' 后得到的数字：123
    document.write("通过parseInt() 函数转换字符串'123abc' 后得到的数字："+parseInt("123abc"));   //包含非数字,返回开头的合法数字部分
    //通过parseInt() 函数转换字符串'123abc' 后得到的数字：123
    document.write("通过parseInt() 函数转换字符串'abc123' 后得到的数字："+parseInt("abc123"));   //包含非数字,以非数字开头，返回NaN
    //通过parseInt() 函数转换字符串'abc123' 后得到的数字：NaN
  </script>
  ```

- String()和toString()的区别

  String()和toString()一样都会返回字符串，区别在于对null的处理：

  **String()会返回字符串"null"**
  **toString() 就会报错，无法执行**

  ```
  <script>
    var a = null;
    document.write('String(null) 把空对象转换为字符串：'+String(a)); 
    //String(null) 把空对象转换为字符串：null
    document.write('null.toString() 就会报错，所以后面的代码不能执行'); 
    document.write(a.toString()); 
    document.write("因为第5行报错，所以这一段文字不会显示"); 
  </script>
  ```

#### 函数

- 与Java中的方法在调用时的区别

  比如一个函数有两个参数，JS里调用函数愿意传几个参数就传几个，Java必须传两个参数

- 没有多态（重载）

  不管参数是否一样，后面的同名函数会覆盖前面的同名函数，前面的函数会无效

#### 作用域

- 参数的作用域

  一个参数的作用域就在这个函数内部，超出函数就看不见该参数了

  ```
  <script>
  function f1(a){
     document.write('参数的作用域在函数以内，其值是 '+a);//参数a的作用范围，所以打印出来是5；
  }
   
  function f2(){
     document.write('在函数里不能访问其他函数的参数'+a); //不在参数a的作用范围，是一个未声明的变量，无法打印
  }
   
  f1(5);
  f2();
  document.write('在函数外也不能访问'+a);//也不在参数a的作用范围，是一个未声明的变量，无法打印
  </script>
  ```

- 全局变量的作用域

  定义在函数前面，即全局变量，所有函数都可以访问

  ```
  <script>
  var a = 0; //定义在函数前面，即全局变量，所有函数都可以访问
   
  function f1(){
    document.write('通过函数f1 设置全局变量a的值 为 5');
    a = 5; //能够访问
  }
   
  function f2(){
    document.write('通过函数f2 访问并打印全局变量a的值 '+a); //能够访问
  }
   
  f1(); //通过f1，设置a的值
  //通过函数f1 设置全局变量a的值 为 5
  f2(); //通过f2,  打印a的值
  //通过函数f2 访问并打印全局变量a的值 5
  </script>
  ```

#### 事件

- 事件是javascript允许html与用户交互的行为。 用户任何对网页的操作，都会产生一个事件。

  事件有很多种，比如鼠标移动，鼠标点击，键盘点击等等。  

  ```
  <script>
  function showHello(){
     alert("Hello JavaScript");
  }
  </script>
   
  <button onclick="showHello()">点击一下</button>
  ```

#### 算数运算符

- 基本算数运算符

  +-* / %（取余数）

- 自增，自减运算符

  自增++在原来的基础上 ，增加 1.
  需要注意的是
  如果 ++放在 **前面** ，就是 **先运算，后取值** 。
  如果 ++放在 **后面** ，就是 **先取值，后运算**。
  自减 -- 是一个道理。

  ```
  <script>
   
  var a = 5;
  document.write('a++ 是先取值，再运算，所以打印出来是：'+a++); //先取值 ，即5
   
  document.write("<br>");
  var b = 5;
  document.write('++b 是先运算，再取值，所以打印出来是：'+ ++b); //先运算，再取值，即6
   
  </script>
  ```

- 赋值运算符

  =，+=，-=，*=，/=，%=

- +运算符的多态

  具备**多态**特征：

  - 当两边都是数字的时候 ，表现为算数运算符

  - 当任意一边是字符串的时候，表现为字符串连接符

  ```
  <script>
  document.write('当+两边都是数字的时候，+就是加法运算符，所以1+2='+(1+2));
  //当+两边都是数字的时候，+就是加法运算符，所以1+2=3
  document.write('当+任意一边是字符串的时候，+就是字符串连接符，所以1+\"2\"='+ (1+"2"));
  //当+任意一边是字符串的时候，+就是字符串连接符，所以1+"2"=12
  </script>
  ```

#### 其他运算符

- 关系运算符

  关系运算符 包含如下 ：==  !=  >  >=等，返回一个Boolean类型的值，true或者false

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  p("1==2: "+(1==2));
  p("1!=2: "+(1!=2));
  p("1>2: "+(1>2));
  p("1<2: "+(1<2));
  p("1>=2: "+(1>=2));
   
  </script>
  ```

- 绝对等，绝对不等于

  与==进行值是否相等的判断不同 ，绝对等 ===还会进行 类型的判断

  比如 数字1和 字符串'1'比较，值是相等的，但是类型不同；所以==会返回true,但是===会返回false

  绝对不等于!== 与上是一个道理

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  p("1=='1': "+(1=='1'));
  p("1==='1': "+(1==='1'));
  </script>
  ```

- 三目运算符

  三目运算符 ?: 有三个操作数；如果第一个返回true,就返回第二个操作符；否则就返回第三个操作符。

  ```
  <script>
   
  var age = 15;
   
  var movie = age<18?"卡通":"你懂的";
   
  document.write('使用?: 三相运算法进行判断。 <br>');
  //使用?: 三相运算法进行判断。
  document.write('age<18?"卡通":"你懂的" <br>表示当年纪小于18的时候，就看卡通，否则就看 你懂得<br>');
   //age<18?"卡通":"你懂的"表示当年纪小于18的时候，就看卡通，否则就看 你懂得
  document.write('而age变量的值是15，所以返回 '+movie);
  //而age变量的值是15，所以返回 卡通
  </script>
  ```

#### 条件语句

- if

- else

- else if

- switch

  ```
  <script>
  var day=new Date().getDay(); //通过日期对象获取数字形式的星期几
  var today;
  switch (day)
  {
  case 0:
    today="星期天";
    break;
  case 1:
    today="星期一";
    break;
  case 2:
    today="星期二";
    break;
  case 3:
    today="星期三";
    break;
  case 4:
   today="星期四";
    break;
  case 5:
    today="星期五";
    break;
  case 6:
    today="星期六";
    break;
  }
  ```

#### 循环语句

- for

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  document.write("使用for循环打印 0 到 4<br>");
   
  for(var i=0;i<5;i++){
    p(i);
  }
   
  </script>
  ```

- while

  其实 while就是另一种形式的for

  **注意： 进行循环的时候，一定要设置好自增和结束条件，否则会导致无限循环，浏览器直接挂掉。**

  ```
  <script>
  document.write("使用while循环打印 0 到 4<br>");
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  var i = 0;
  while(i<5){
    p(i);
    i++;
  }
   
  </script>
  ```

- do while

  其实do-while与while的区别在于，至少会执行一次

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
  document.write("使用do-while循环打印 0 到 4<br>");
  var i = 0;
   
  do{
   p(i);
   i++;
  } while(i<5);
   
  </script>
  ```

- forEach

  forEach是增强的for循环，主要用于遍历数组。

- continue

  表示放弃本次循环，进行下一次循环

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
    
  document.write("使用for循环打印 0 到 4<br>如果发现是3，就<span style='color:red'>放弃本次循环，并且进入下一次</span>循环<br>");
    
  for(i=0;i<5;i++){
    if(i==3)
      continue;
    p(i);
  }
  </script>
  使用for循环打印 0 到 4
  如果发现是3，就放弃本次循环，并且进入下一次循环
  0
  1
  2
  4
  ```

- break

  break表示终止循环，循环体结束

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
     
  document.write("使用for循环打印 0 到 4<br>如果发现是3，就<span style='color:red'>终止循环，循环体结束 </span><br>");
     
  for(i=0;i<5;i++){
    if(i==3)
      break;
    p(i);
  }
  </script>
  使用for循环打印 0 到 4
  如果发现是3，就终止循环，循环体结束
  0
  1
  2
  ```

#### 错误处理

- try catch

  ```
  <script>
   
  function f1(){
    //函数f1是存在的
  }
  try{
     document.write("试图调用不存在的函数f2()<br>");
      f2();  //调用不存在的函数f2();
  }
  catch(err){
     document.write("捕捉到错误产生:");
      document.write(err.message);
  }
   
  document.write("<p>因为错误被捕捉了，所以后续的代码能够继续执行</p>");
  </script>
  ```


### 对象

JavaScript中的对象是有着属性和方法的一种特殊数据类型。

常见的对象有数字Number，字符串String，日期Date，数组Array等。

#### 数字

- 创建一个数字对象

  可以通过new Number()创建一个数字对象，与基本类型的数字不同，对象类型的数字，拥有更多的属性和方法。

  ```
  <script>
   
  var x = new Number(123);
   document.write('数字对象x的值:'+x);
   //数字对象x的值:123
   document.write('数字对象x的类型:'+typeof x); //通过typeof 获知这是一个object
   //数字对象x的类型:object
  var y = 123;
   document.write('基本类型y的值:'+y);
   //基本类型y的值:123
   document.write('基本类型y的类型:'+typeof y); //通过typeof 获知这是一个number
   //基本类型y的类型:number
  </script>
  ```

- 最小值 最大值

  ```
  <script>
   
   document.write('Number对象的最小值:'+Number.MIN_VALUE);
   //Number对象的最小值:5e-324
   
   document.write('Number对象的最大值:'+Number.MAX_VALUE);
   //Number对象的最大值:1.7976931348623157e+308
  </script>
  ```

- 表示不是数字

  **NaN**(Not a Number),表示不是一个数字；当通过非数字创建Number的时候，就会得到NaN.

  **注意： 不能通过 是否等于Number.NaN来判断 是否 “不是一个数字”，应该使用函数 isNaN()**

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  var a = new Number("123abc"); //通过非数字创建Number对象，得到的是一个NaN
  p('通过非数字字符串"123abc"创建出来的Number对象 a的值是：'+a);
  //通过非数字字符串"123abc"创建出来的Number对象 a的值是：NaN
  p('但是, a==Number.NaN会返回:'+(a==Number.NaN)); //即便是一个NaN 也"不等于" Number.NaN
  //但是, a==Number.NaN会返回:false 
  p('正确判断是否是NaN的方式是调用isNaN函数:'+isNaN(a)); //正确的方式是通过isNaN() 函数进行判断
  //正确判断是否是NaN的方式是调用isNaN函数:true 
  </script>
  ```

- 返回一个数字的小数表达

  toFixed返回一个数字的小数表达

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  var a = new Number("123");
  p("数字对象123通过toFixed(2) 保留两位小数:"+a.toFixed(2)); //保留两位小数点
  //数字对象123通过toFixed(2) 保留两位小数:123.00 
  
  var b = new Number("3.1415926");
  p("PI 通过toFixed(3) 保留三位小数:"+b.toFixed(3));//保留三位小数点
  //PI 通过toFixed(3) 保留三位小数:3.142 
  </script>
  ```

- 返回一个数字的科学计数法表达

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
    
  var a = new Number("123");
    
  p("数字对象123通过toExponential 返回计数法表达 "+a.toExponential ());
  //数字对象123通过toExponential 返回计数法表达 1.23e+2  
  var b = new Number("3.1415926");
    
  p("数字对象3.1415926通过toExponential 返回计数法表达 "+b.toExponential ());
  //数字对象3.1415926通过toExponential 返回计数法表达 3.1415926e+0  
  </script>
  ```

- 返回一个数字对象的基本数字类型

  方法 valueOf() 返回一个基本类型的数字

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  var a = new Number("123");
   
  var b = a.valueOf();
   
  p('数字对象a的类型是: '+typeof a); //返回object
  p('通过valueOf()返回的值的类型是'+typeof b); //返回number
   
  </script>
  ```

#### 字符串

与数字类似，基本类型String也有一个对应的String 对象，并且提供了很多有用的方法。

- 创建字符串对象

  可以通过**new String()**创建一个**String对象**

  ```
  <script>
  var x = "5";
  var y = new String(x);
  document.write("变量x的值是:"+x);
  //变量x的值是:5
  document.write("变量x的类型是:"+(typeof x));
  //变量x的类型是:string
  document.write("变量y的值是:"+y);
  //变量y的值是:5
  document.write("变量y的类型是:"+(typeof y));
  //变量y的类型是:object
  </script>
  ```

- 字符串长度

  属性 length 返回字符串的长度

  ```
  <script>
  var y = new String("Hello JavaScript");
  document.write("通过.length属性获取字符串'Hello JavaScript'的长度"+y.length);
  </script>
  ```

- 返回指定位置的字符

  charAt 返回指定位置的字符
  charCodeAt 返回指定位置的字符对应的Unicode码

  ```
  <script>
  var y = new String("Hello JavaScrpt");
  document.write("字符串y的值:"+y);
  //字符串y的值:Hello JavaScrpt
  document.write('通过 charAt(0)获取位置0的字符串： '+y.charAt(0)); //返回H
  //通过 charAt(0)获取位置0的字符串： H
  document.write('通过 charCodeAt(0)获取位置0的字符的 Unicode码 ：'+y.charCodeAt(0)); //返回H对应的Unicode码 72
  //通过 charCodeAt(0)获取位置0的字符的 Unicode码 ：72 
  </script>
  ```

- 字符串拼接

  concat用于进行字符串拼接

  ```
  <script>
   
  var x = new String("Hello ");
  var y = new String("Javascript");
   
  document.write( '字符串x的值: '+x);
  //字符串x的值: Hello
  document.write( '字符串y的值: '+y);
  //字符串y的值: Javascript
  document.write( '通过函数concat()把x和y连接起来: ' +  x.concat(y) );
  //通过函数concat()把x和y连接起来: Hello Javascript 
  </script>
  ```

- 子字符串出现的位置

  indexOf 返回子字符串第一次出现的位置
  lastIndexOf 返回子字符串最后一次出现的位置

  ```
  <script>   
  var y = new String("Hello JavaScript");
  document.write( '字符串y的值: '+y);
  //字符串y的值: Hello JavaScript
  document.write('通过 indexOf ("a")获取子字符"a" 第一次出现的位置 '+y.indexOf ("a"));
  //通过 indexOf ("a")获取子字符"a" 第一次出现的位置 7
  document.write('通过 lastIndexOf ("a")获取子字符"a" 最后出现的位置 '+y.lastIndexOf ("a"));
  //通过 lastIndexOf ("a")获取子字符"a" 最后出现的位置 9
  </script>
  ```

- 比较两段字符串是否相同

  localeCompare 比较两段字符串是否相同，0即表示相同，非0表示不同

  ```
  <script>
  var x = new String("Hello");
  var y = new String("Hello");
  var z = new String("aloha");
     
  document.write( '字符串x的值: '+x);
  //字符串x的值: Hello
  document.write( '字符串y的值: '+y);
  //字符串y的值: Hello
  document.write( '字符串z的值: '+z);
  //字符串z的值: aloha
   
  document.write('通过 localeCompare()判断 x和y是否相等 '+x.localeCompare(y));
  //通过 localeCompare()判断 x和y是否相等 0
  document.write('通过 localeCompare()判断 x和z是否相等 '+x.localeCompare(z));
  //通过 localeCompare()判断 x和z是否相等 1
   
  document.write('0 表示相等<br>');
  document.write('1 表示字母顺序靠后<br>');
  document.write('-1 表示字母顺序靠前<br>');
  </script>
  ```

- 截取一段子字符串

  substring 截取一段子字符串
  **注：** **第二个参数，取不到**

  ```
  <script>
  var x = new String("Hello JavaScript");
   document.write( '字符串x的值: '+x);
  //字符串x的值: Hello JavaScript
  document.write('x.substring (0,3) 获取位0到3的字符串： '+x.substring (0,3) );
  //x.substring (0,3) 获取位0到3的字符串： Hel
  document.write('左闭右开，取得到0，取不到3');
  </script>
  ```

- 根据分隔符，把字符串转换为数组

  split 根据分隔符，把字符串转换为数组。
  **注： 第二个参数可选，表示返回数组的长度**

  ```
  <script>
  var x = new String("Hello This Is JavaScript");
  document.write( '字符串x的值: '+x);
  //字符串x的值: Hello This Is JavaScript
  var y =  x.split(" ");
  document.write('通过空格分隔split(" "),得到数组'+y);
  //通过空格分隔split(" "),得到数组Hello,This,Is,JavaScript
  var z =  x.split(" ",2);
  document.write('通过空格分隔split(" ",2),得到数组，并且只保留前两个'+z);
  //通过空格分隔split(" ",2),得到数组，并且只保留前两个Hello,This
  </script>
  ```

- 替换子字符串

  replace(search,replacement)
  找到满足条件的子字符串search，替换为replacement

  注: 默认情况下只替换找到的第一个子字符串，如果要所有都替换，需要写成：

  ```
  x.replace(/a/g, "o");
  或者
  var regS = new RegExp("a","g");
  x.replace(regS, "o");
  ```

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
    
  var x = new String("Hello JavaScript");
  p('这个是原字符串: '+x);
  //这个是原字符串: Hello JavaScript
  var y = x.replace("a","o");
  p('只替换第一个 a:  '+y);
  //只替换第一个 a: Hello JovaScript
  var regS = new RegExp("a","g");
  var z = x.replace(regS, "o");
  p('替换掉所有的 a:  '+z);
  //替换掉所有的 a: Hello JovoScript 
  </script>
  ```

- 返回基本类型

  **需要注意的是，所有返回字符串类型的方法，返回的都是基本类型的String**

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  var x = new String("Hello JavaScript");
  var temp = x.charAt(0);
  p('charAt返回的值'+temp);
  //charAt返回的值H
  p('其类型是'+ typeof temp );
  //其类型是string 
  var temp = x.concat("!!!");
  p('concat返回的值'+temp);
  //concat返回的值Hello JavaScript!!!
  p('其类型是'+ typeof temp );
  //其类型是string 
  var temp = x.substring(0,5);
  p('substring返回的值'+temp);
  //substring返回的值Hello
  p('其类型是'+ typeof temp );
  //其类型是string 
  </script>
  ```

#### 数组

javascript中的数组是动态的，即长度是可以发生变化的。

- 创建数组对象

  创建数组对象的3种方式：
  1. new Array() 创建长度是0的数组
  2. new Array(5); 创建长度是5的数组,，但是其每一个元素都是undefine
  3. new Array(3,1,4,1,5,9,2,6); 根据参数创建数组

  ```
  <script>
  function p(s,v){
    document.write(s+' '+v);
    document.write("<br>");
  }
   
  var x = new Array(); //创建长度是0的数组
  p('通过 new Array()创建一个空数组:',x);
  //通过 new Array()创建一个空数组:
  x = new Array(5); //创建长度是5的数组,，但是其每一个元素都是undefine
  p('通过 new Array(5)创建一个长度是5的数组:',x);
  //通过 new Array(5)创建一个长度是5的数组: ,,,,
  p('像new Array(5) 这样没有赋初值的方式创建的数组，每个元素的值都是:',x[0]);
  //像new Array(5) 这样没有赋初值的方式创建的数组，每个元素的值都是: undefined
  x = new Array(3,1,4,1,5,9,2,6); //根据参数创建数组
  p('创建有初值的数组new Array(3,1,4,1,5,9,2,6) :',x);
  //创建有初值的数组new Array(3,1,4,1,5,9,2,6) : 3,1,4,1,5,9,2,6 
  </script>
  ```

- 数组长度

  属性length 获取一个数组的长度

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  var x = new Array(3,1,4,1,5,9,2,6); //根据参数创建数组
  p('当前数组是:'+x);
  p('通过.length获取当前数组的长度:'+x.length);
  </script>
  ```

- 遍历一个数组

  遍历有两种方式
  1.结合for循环，通过下标遍历
  2.使用增强for in循环遍历

  **需要注意的是，在增强for in中，i是下标的意思。**

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  var x = new Array(3,1,4);
  p('当前数组是:'+x);
  p("使用普通的for循环遍历数组");
  for(i=0;i<x.length;i++){  //普通for循环
    p(x[i]);
  }
  p("使用增强for循环遍历数组");
  for(i in x){  //for in 循环
    p(x[i]);
  }
  </script>
  当前数组是:3,1,4
  使用普通的for循环遍历数组
  3
  1
  4
  使用增强for循环遍历数组
  3
  1
  4
  ```

- 连接数组

  方法 concat 连接两个数组

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
  var x = new Array(3,1,4);
  var y = new Array(1,5,9,2,6);
  p('数组x是:'+x);
  p('数组y是:'+y);
   
  var z = x.concat(y);
  p('使用concat连接数组x和y');
  p('数组z是:'+z);
   
  </script>
  数组x是:3,1,4
  数组y是:1,5,9,2,6
  使用concat连接数组x和y
  数组z是:3,1,4,1,5,9,2,6
  ```

- 通过指定分隔符，返回一个数组的字符串表达

  方法 join 通过指定分隔符，返回一个数组的字符串表达

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  var x = new Array(3,1,4);
  p('数组x是:'+x);
  var y = x.join();
  p('y = x.join() 得到的是数组x的字符串表达，其值是'+y+" 其类型是 :" +(typeof y));
  var z = x.join("@");
  p('z = x.join("@");是x的字符串表达，不过分隔符不是默认的"," 而是"@" : '+z);
   
  </script>
  数组x是:3,1,4
  y = x.join() 得到的是数组x的字符串表达，其值是3,1,4 其类型是 :string
  z = x.join("@");是x的字符串表达，不过分隔符不是默认的"," 而是"@" : 3@1@4
  ```

- 分别在最后的位置插入数据和获取数据(获取后删除)

  方法 push pop,分别在**最后的位置**插入数据和获取数据(获取后删除)
  就像**先入后出的栈**一样

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  var x = new Array(3,1,4);
  p('数组x是:'+x);
   
  x.push(5);
  p('向x中push 5,得到 ' + x);
  var e = x.pop();
  p('从x中pop一个值出来，其值是 ' + e);
   
  p('pop之后，x数组的值是:'+x);
   
  </script>
  数组x是:3,1,4
  向x中push 5,得到 3,1,4,5
  从x中pop一个值出来，其值是 5
  pop之后，x数组的值是:3,1,4
  ```

- 分别在最开始的位置插入数据和获取数据(获取后删除)

  方法 unshift shift ,分别在**最开始的位置**插入数据和获取数据(获取后删除)

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  var x = new Array(3,1,4);
  p('数组x是:'+x);
  x.unshift (5);
  p('对数组 unshift 值5(在最前面加)，数组变为:' + x);
  var e = x.shift ();
  p('从数组中 shift 一个数(从最前面取)，其值是:' + e);
  p('shift之后，数组变为:' + x);
  </script>
  数组x是:3,1,4
  对数组 unshift 值5(在最前面加)，数组变为:5,3,1,4
  从数组中 shift 一个数(从最前面取)，其值是:5
  shift之后，数组变为:3,1,4
  ```

- 对数组的内容进行排序

  方法 sort对数组的内容进行排序

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  var x = new Array(3,1,4,1,5,9,2,6);
  p('数组x是:'+x);
  x.sort();
  p('使用sort排序后的数组x是:'+x);
   
  </script>
  数组x是:3,1,4,1,5,9,2,6
  使用sort排序后的数组x是:1,1,2,3,4,5,6,9
  ```

- 自定义排序算法

  sort()默认采用正排序，即小的数排在前面。 如果需要采用自定义排序的算法，就把比较器函数作为参数传递给sort()。
  比较器函数:

  ```
  function comparator(v1,v2){
     return v2-v1;  //v2-v1表示大的放前面，小的放后面
  }
  ```

  调用sort函数的时候，把这个比较器函数comparator作为参数传递进去即可

  ```
  x.sort(comparator);
  ```

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  function comparator(v1,v2){
     return v2-v1;
  }
   
  var x = new Array(3,1,4,1,5,9,2,6);
  p('数组x是:'+x);
  x.sort(comparator);
  p('使用sort 进行自定义倒排序后的数组x是:'+x);
   
  </script>
  数组x是:3,1,4,1,5,9,2,6
  使用sort 进行自定义倒排序后的数组x是:9,6,5,4,3,2,1,1
  ```

- 对数组的内容进行反转

  方法 reverse，对数组的内容进行反转

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
    
  var x = new Array(3,1,4,1,5,9,2,6);
  p('数组x是:'+x);
  x.reverse();
  p('使用reverse()函数进行反转后的值是:'+x);
   
  </script>
  数组x是:3,1,4,1,5,9,2,6
  使用reverse()函数进行反转后的值是:6,2,9,5,1,4,1,3
  ```

- 获取子数组

  方法 slice 获取子数组

  **注意： 第二个参数取不到**

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
     
  var x = new Array(3,1,4,1,5,9,2,6);
  p('数组x是:'+x);
  var y = x.slice(1);
  p('x.slice(1)获取的子数组是:'+y);
  var z = x.slice(1,3);
  p('x.slice(1,3)获取的子数组是:'+z);
  p('第二个参数取不到');
  </script>
  数组x是:3,1,4,1,5,9,2,6
  x.slice(1)获取的子数组是:1,4,1,5,9,2,6
  x.slice(1,3)获取的子数组是:1,4
  第二个参数取不到
  ```

- 删除和插入元素

  方法 splice (**不是** [slice](http://how2j.cn/k/javascript/javascript-array/441.html#step1139)) 用于删除数组中的元素

  **奇葩的是 ，它还能用于向数组中插入元素**

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
     
  var x = new Array(3,1,4,1,5,9,2,6);
  p('数组x是:'+x);
  x.splice (3,2);//从位置3开始 ，删除2个元素
  p('x.splice (3,2) 表示从位置3开始 ，删除2个元素:'+x);
  x.splice(3,0,1,5);
  p('x.splice(3,0,1,5) 从位置3开始，删除0个元素，但是插入1和5,最后得到:'+x);
  </script>
  数组x是:3,1,4,1,5,9,2,6
  x.splice (3,2) 表示从位置3开始 ，删除2个元素:3,1,4,9,2,6
  x.splice(3,0,1,5) 从位置3开始，删除0个元素，但是插入1和5,最后得到:3,1,4,1,5,9,2,6
  ```

#### 日期

JavaScript使用Date对象表示日期

- 创建日期对象

  通过new Date创建一个日期对象，这个对象就表示当前日期(现在)

- 年/月/日
  **需要注意的是，getMonth()返回的月数，是基零的，0代表1月份**

  ```
  <script>
    var d = new Date();
    document.write('分别获取年月日: ');
    document.write(d.getFullYear());
    document.write("/");
    document.write(d.getMonth()+1);
    document.write("/");
    document.write(d.getDate());
  </script>
  分别获取年月日: 2019/9/9
  ```

- 时:分:秒:毫秒

  ```
  <script>
    var d = new Date();
    document.write("分别获取时:分:秒:毫秒 ");
    document.write(d.getHours());
    document.write(":");
    document.write(d.getMinutes());
    document.write(":");
    document.write(d.getSeconds());
    document.write(":");
    document.write(d.getMilliseconds());
  </script>
  分别获取时:分:秒:毫秒 10:35:10:514
  ```

- 一周的第几天

  通过getDay()获取，今天是本周的第几天

  **与getMonth()一样，返回值是基0的。**

  ```
  <script>
  var day=new Date().getDay(); //通过日期对象获取数字形式的星期几
  var weeks = new Array("星期天","星期一","星期二","星期三","星期四","星期五","星期六");
   
  document.write("今天是 ： "+weeks[day]);
    
  </script>
  今天是 ： 星期一
  ```

- 经历的毫秒数

  获取从1970/1/1 08:00:00 至今的毫秒数

  ```
  <script>
  var time = new Date().getTime();
  document.write("从1970/1/1 08:00:00 到今天的毫秒数： "+ time);
  </script>
  从1970/1/1 08:00:00 到今天的毫秒数： 1567996510554
  ```

- 修改日期和时间

  把日期对象设置为2012/12/12 00:00:00

  ```
  <script>
  var d=new Date();
  document.write("修改日期对象的值为世界末日:<br>");
  d.setFullYear(2012);
  d.setMonth(11); //月份是基0的，所以11表示12月
  d.setDate(12);
   
  d.setHours(0);
  d.setMinutes(0);
  d.setSeconds(0);
   
  document.write(d);
  </script>
  修改日期对象的值为世界末日:
  Wed Dec 12 2012 00:00:00 GMT+0800 (中国标准时间)
  ```

#### Math

Math是JavaScript的工具对象，用于常见的数学运算

- 自然对数和圆周率

  属性E PI，分别表示自然对数和圆周率PI

  ```
  <script>
  document.write(Math.E);
  document.write("<br>");
  document.write(Math.PI);
  </script>
  2.718281828459045
  3.141592653589793
  ```

- 绝对值

  方法 abs 取绝对值

  ```
  <script>
  document.write(Math.abs(-1));
  </script>
  ```

- 最小最大

  方法 min max 分别取最小值，最大值

  ```
  <script>
  document.write(Math.min(1,100));
  document.write("<br>");
  document.write(Math.max(1,100));
  </script>
  1
  100
  ```

-  求幂

  方法 pow 求一个数的n次方

  ```
  <script>
  document.write(Math.pow(3,3)); //3的立方，即27
  </script>
  ```

- 四舍五入

  方法 round,小数四舍五入取整

  ```
  <script>
  document.write(Math.round(3.4));
  document.write("<br>");
  document.write(Math.round(3.5));
  </script>
  3
  4
  ```

- 随机数

  方法 random 取0-1之间的随机数

  ```
  <script>
  document.write("一个 0-1 之间的随机数 : Math.random():");
  document.write("<br>");
  document.write(Math.random());
  document.write("<br>");
  document.write("十个 5-10 之间的随机数 : Math.round(Math.random() *5)+5 ");
  document.write("<br>");
  for(i=0;i<10;i++){
  document.write(Math.round(Math.random() *5)+5 ); //5-10之间的随机整数
  document.write("<br>");
  }
  </script>
  一个 0-1 之间的随机数 : Math.random():
  0.5774087433711836
  十个 5-10 之间的随机数 : Math.round(Math.random() *5)+5
  9
  7
  6
  7
  8
  10
  6
  9
  10
  7
  ```

#### 自定义对象

- 通过new Object创建对象

  ```
  <script>
  var hero = new Object();
  hero.name = "盖伦"; //定义一个属性name，并且赋值
  hero.kill = function(){
    document.write(hero.name + " 正在杀敌" ); //定义一个函数kill
  }
    
  hero.kill(); //调用函数kill
    
  </script>
  ```

- 通过function设计一个对象

  通过new Object创建对象有个问题，就是每创建一个对象，都得重新定义属性和函数。这样代码的重用性不好；那么，采用另一种方式，通过function**设计一种对象**。 然后实例化它 。这种思路很像Java里的**设计一种类**，但是 javascript没有类，只有对象，所以我们叫**设计一种对象**

  ```
  <script>
  function Hero(name){
    this.name = name;
    this.kill = function(){
       document.write(this.name + "正在杀敌<br>");
    }
  }
   
  var gareen = new Hero("盖伦");
  gareen.kill();
   
  var teemo = new Hero("提莫");
  teemo.kill();
  </script>
  ```

- 为已经存在的对象，增加新的方法

  现在Hero对象已经设计好了，但是我们发现需要追加一个新的方法keng(),那么就需要通过prototype实现这一点

  ```
  <script>
  function Hero(name){
    this.name = name;
    this.kill = function(){
       document.write(this.name + "正在杀敌<br>");
    }
  }
    
  var gareen = new Hero("盖伦");
  gareen.kill();
    
  var teemo = new Hero("提莫");
  teemo.kill();
    
  Hero.prototype.keng = function(){
    document.write(this.name + "正在坑队友<br>");
  }
    
  gareen.keng();
  teemo.keng();
    
  </script>
  ```

### BOM

BOM即 浏览器对象模型(Browser Object Model)

浏览器对象包括：

1. Window(窗口)
2. Navigator(浏览器)
3. Screen (客户端屏幕)
4. History(访问历史)
5. Location(浏览器地址)

#### Window

- 获取文档显示区域的高度和宽度

  一旦页面加载，就会自动创建window对象，所以无需手动创建window对象。
  通过window对象可以获取文档显示区域的高度和宽度

  ```
  <script>
    document.write("文档内容");
    document.write("文档显示区域的宽度"+window.innerWidth);
    document.write("<br>");
    document.write("文档显示区域的高度"+window.innerHeight);
  </script>
  ```

- 获取外部窗体的宽度和高度

  所谓的外部窗体即浏览器，可能用的是360，火狐，IE, Chrome等等。

  ```
  <script>
    document.write("浏览器的宽度:"+window.outerWidth);
    document.write("<br>");
    document.write("浏览器的高度:"+window.outerHeight);
  </script>
  ```

- 打开一个新的窗口

  一些网站会自动打开另一个网站，就是通过window的open方法做到的

  **不建议使用**，如果需要打开一个新的网站，应该通过超级链接等方式让用户主动打开，在没有告知用户的前提下就打开一个新的网站会影响用户的体验

  ```
  <script>
  function openNewWindow(){
    myWindow=window.open("/");
  }
  </script>
   
  <button onclick="openNewWindow()">打开一个新的窗口</button>
  ```

#### Navigator

Navigator即浏览器对象，提供浏览器相关的信息

- 打印浏览器相关信息

  ```
  <script type="text/javascript">
  document.write("<p>浏览器产品名称：");
  document.write(navigator.appName + "</p>");
   
  document.write("<p>浏览器版本号：");
  document.write(navigator.appVersion + "</p>");
   
  document.write("<p>浏览器内部代码：");
  document.write(navigator.appCodeName + "</p>");
   
  document.write("<p>操作系统：");
  document.write(navigator.platform + "</p>");
   
  document.write("<p>是否启用Cookies：");
  document.write(navigator.cookieEnabled + "</p>");
   
  document.write("<p>浏览器的用户代理报头：");
  document.write(navigator.userAgent + "</p>");
  </script>
  浏览器产品名称：Netscape
  
  浏览器版本号：5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36
  
  浏览器内部代码：Mozilla
  
  操作系统：Win32
  
  是否启用Cookies：true
  
  浏览器的用户代理报头：Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36
  ```

#### Screen

返回用户的屏幕大小，以及可用屏幕大小

```
<script type="text/javascript">
document.write("用户的屏幕分辨率: ")
document.write(screen.width + "*" + screen.height)
document.write("<br />")
document.write("可用区域大小: ")
document.write(screen.availWidth + "*" + screen.availHeight)
document.write("<br />")
</script>
用户的屏幕分辨率: 1440*900
可用区域大小: 1440*860
```

#### History

- 返回上一次的访问

  ```
  <script>
  function goBack()
    {
       history.back();
    }
  </script>
   
  <button onclick="goBack()">返回</button>
  ```

- 返回上上次的访问

  ```
  <script>
  function goBack()
    {
       history.go(-2); //-1表示上次，-2表示上上次，以次类推
    }
  </script>
   
  <button onclick="goBack()">返回上上次</button>
  ```

#### Location

- 刷新当前页面

  reload方法刷新当前页面

  ```
  <span>当前时间:</span>
  <script>
    var d = new Date();
    document.write(d.getHours());
    document.write(":");
    document.write(d.getMinutes());
    document.write(":");
    document.write(d.getSeconds());
    document.write(":");
    document.write(d.getMilliseconds());
   
  function refresh(){
    location.reload();
  }
  </script>
   
  <br>
  <button onclick="refresh()">刷新当前页面</button>
  ```

- 跳转到另一个页面

  ```
  <script>
  function jump(){
    //方法1
    //location="/";
   
    //方法2
    location.assign("/");
     
  }
  </script>
   
  <br>
  <button onclick="jump()">跳转到首页</button>
  ```

- Location的其他属性

  协议 location.protocol:http:
  主机名 location.hostname:how2j.cn
  端口号 (默认是80，没有即表示80端口)location.port:
  主机加端口号 location.host: how2j.cn
  访问的路径 location.pathname: /k/javascript/javascript-bom-location/451.html
  锚点 location.hash:
  参数列表 location.search:

  ```
  <script>
  function p(s){
    document.write(s);
    document.write("<br>");
  }
   
  p("协议 location.protocol:"+location.protocol);
  p("主机名 location.hostname:"+location.hostname);
  p("端口号 (默认是80，没有即表示80端口)location.port:"+location.port);
   
  p("主机加端口号 location.host: "+location.host);
  p("访问的路径  location.pathname: "+location.pathname);
   
  p("锚点 location.hash: "+location.hash);
  p("参数列表 location.search: "+location.search);
   
  </script>
  ```


#### 弹出框

浏览器上常见的弹出框有警告框，确认框，提示框 这些都是通过调用window的方法实现的。

- 警告框

  警告框 alert，常用于消息提示，比如注册成功等等

- 确认框

  确认框 confirm，常用于危险性操作的确认提示。 比如删除一条记录的时候，弹出确认框confirm返回基本类型的Boolean true或者false

- 输入框

  输入框 prompt，用于弹出一个输入框，供用户输入相关信息。 因为弹出的界面并不好看，很有可能和网站的风格不一致，所以很少会在实际工作中用到。

#### 计时器

- 只执行一次

  函数setTimeout(functionname, 距离开始时间毫秒数 );

  通过setTimeout在指定的毫秒数时间后，**执行一次** 函数functionname

  ```
  <script>
   
  function printTime(){
    var d = new Date();
    var h= d.getHours();
    var m= d.getMinutes();
    var s= d.getSeconds();
    document.getElementById("time").innerHTML= h+":"+m+":"+s;
   
  }
  
  function showTimeIn3Seconds(){
     setTimeout(printTime,3000);  
  }
   
  </script>
  <div id="time"></div>
  <button onclick="showTimeIn3Seconds()">点击后3秒钟后显示当前时间，并且只显示一次</button>
  ```

- 不停地重复执行

  函数setInterval(函数名, 重复执行的时间间隔毫秒数 );

  通过setInterval**重复执行同一个函数**，重复的时间间隔由第二个参数指定

  ```
  <p>每隔1秒钟，打印当前时间</p>
     
  <div id="time"></div>
     
  <script>
     
  function printTime(){
    var d = new Date();
    var h= d.getHours();
    var m= d.getMinutes();
    var s= d.getSeconds();
    document.getElementById("time").innerHTML= h+":"+m+":"+s;
     
  }
     
  var t = setInterval(printTime,1000);
  </script>
  ```

- 终止重复执行

  通过clearInterval终止一个不断重复的任务

  ```
  <p>每隔1秒钟，打印当前时间</p>
     
  <div id="time"></div>
     
  <script>
     
  var t = setInterval(printTime,1000);
   
  function printTime(){
    var d = new Date();
    var h= d.getHours();
    var m= d.getMinutes();
    var s= d.getSeconds();
    document.getElementById("time").innerHTML= h+":"+m+":"+s;
    if(s%5==0)
       clearInterval(t);
  } 
  </script>
  ```

- 不要在setInterval调用的函数中使用document.write();

  **注：**部分浏览器，比如firefox有这个问题，其他浏览器没这个问题。

  假设setInterval调用的函数是printTime, 在printTime中调用document.write();
  只能看到一次打印时间的效果。
  这是因为document.write，会创建一个新的文档，而新的文档里，只有打印出来的时间字符串，并没有setInterval这些javascript调用，所以只会看到执行一次的效果。

  ```
  <p>每隔1秒钟，通过document.write打印当前时间</p>
   
  <script>
   
  function printTime(){
    var d = new Date();
    document.write(d.getHours());
    document.write(":");
    document.write(d.getMinutes());
    document.write(":");
    document.write(d.getSeconds());
    document.close();
  }
   
  var t = setInterval(printTime,1000);
  </script>
  ```

  