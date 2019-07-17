# CSS

#### 使用css和不使用css比较

- 不使用css

  不使用css 给每一个单元格加上背景颜色，就需要给每一个td元素加上bgcolor属性

  ```
  <td bgcolor="gray" >1</td>
  ```

- 使用css

  使用css 给每一个单元格加上背景颜色，只需要在最前面写一段css代码，所有的单元格都有背景颜色了

  ```
  <style>
  td{
    background-color:gray;
  }
  </style>
  ```

#### 语法

selector {property: value} 即 选择器{属性:值} 

- 选择所有的p元素

  ```
  <style>
  p{
     color:red;
  }
  </style>
  ```

- 直接在元素上增加style属性

  ```
  <p style="color:red">这是style为红色的</p>
  ```

#### 选择器

选择器主要分3种：元素选择器、id选择器、类选择器

- 元素选择器

  元素选择器通过标签名选择元素 

  ```
  <style>
  p{
    color:red;
  }
  </style>
  <p>p元素</p>
  <p>p元素</p>
  <p>p元素</p>
  ```

- id选择器

  通过id选择元素 

  ```
  <style>
  #p1{
    color:blue;
  }
  </style>
  <p id="p1">id=p1的p</p>
  ```

- 类选择器

  当需要多个元素，都使用同样的css的时候，就会使用类选择器

  ```
  <style>
  .pre{
    color:blue;
  }
  </style>
   
  <p class="pre">前3个</p>
  <p class="pre">前3个</p>
  <p class="pre">前3个</p>
  ```

- 更准确的选择

  同时根据元素名和class来选择

  ```
  <style>
   
  p.blue{
    color:blue;
  }
   
  </style>
   
  <p class="blue">class=blue的p</p>
   
  <span class="blue">class=blue的span</span>
  ```

#### 注释

注释以/* 开始，以*/结束 

#### 尺寸

- 尺寸大小

  属性：width
  值：可以是百分比或者像素

  ```
  <style>
  p#percentage{
    width:50%;
    height:50%;
    background-color:pink;
  }
  p#pix{
    width:180px;
    height:50px;
    background-color:green;
  }
  </style>
   
  <p id="percentage"> 按比例设置尺寸50%宽 50%高</p>
   
  <p id="pix"> 按象素设置尺寸  180px宽 50 px高</p>
  ```

  **p#percentage的height:50%;高度是根据父容器来定的，所以父容器没有高度，子容器的高度百分数就会作废**

#### 背景

- 背景颜色

  1. 预定义的颜色名字
    比如red,gray,white,black,pink

  2. rgb格式
    分别代表红绿蓝的比例 rgb(250,0,255) 即表示红色是满的，没有绿色，蓝色是满的，即红色和蓝色混合在一起：紫色

  3. 16进制的表示

     00ff00 等同于 rgb(0,255,0)

- 图片做背景

  ```
  <style>
  div#test
    {
      background-image:url(/study/background.jpg);
      width:200px;
      height:100px;
    }
  </style>
   
  <div id="test">
    这是一个有背景图的DIV
  </div>
  ```

- 背景重复

  background-repeat属性，值可以是以下几个：

  - repeat; 水平垂直方向都重复 
  - repeat-x; 只有水平方向重复 
  - repeat-y; 只有垂直方向重复 
  - no-repeat; 无重复

  ```
  <style>
  div#norepeat
    {
      background-image:url(/study/background_small.jpg);
      width:200px;
      height:100px;
      background-repeat: no-repeat;
    }
   
  div#repeat-x
    {
      background-image:url(/study/background_small.jpg);
      width:200px;
      height:100px;
      background-repeat: repeat-x;
    }
  </style>
   
  <div id="norepeat">
    背景不重复
  </div>
   
  <div id="repeat-x">
    背景水平重复
  </div>
  ```

- 背景平铺

  属性：background-size  值：contain

  ```
  <style>
  div#contain
    {
      background-image:url(/study/background_small.jpg);
      width:200px;
      height:100px;
      background-size: contain;
    }
  </style>
    
  <div id="contain">
     背景平铺，通过拉伸实现，会有失真
  </div>
  ```

#### 文本

- 文字颜色

  属性名color
  颜色的值可以采用3种方式
  1. 预定义的颜色名字
  比如red,gray,white,black,pink
  2. rgb格式
  分别代表红绿蓝的比例 rgb(250,0,255) 即表示红色是满的，没有绿色，蓝色是满的，即红色和蓝色混合在一起：紫色
  3. 16进制的表示

     00ff00 等同于 rgb(0,255,0)

  ```
  <style>
  div#colorful{
    color:pink
  }
   
  </style>
   
  <div id="colorful">
    粉红色
  </div>
  
  ```

- 对齐

  属性:text-align
  值：left,right,center

  div是块级元素，其默认宽度是100%，所以文本有对齐的空间前提。

  span是内联元素其默认宽度就是其文本内容的宽度

  ```
  <style>
  div#left{
    text-align:left;
  }
  /*让div和span的边框显露出来，便于理解本知识点*/
  div,span{
    border: 1px gray solid;
    margin:10px;
  }
  
  div#right{
    text-align:right;
  }
  
  div#center{
    text-align:center;
  }
  
  span#right{
    text-align:right;
  }
  
  </style>
  
  <div id="left">
  左对齐
  </div>
  
  <div id="right">
  右对齐
  </div>
  
  <div id="center">
  居中
  </div>
  
  <span id="right">
  span看不出右对齐效果
  
  </span>
  ```

- 文本修饰

  属性：text-decoration 
  值： overline(上划线)、line-through(删除效果)、underline(下划线)、blink(闪烁效果，大部分浏览器已经取消该效果)、none(去掉了下划线的超链)

  ```
  <style type="text/css">
  h1 {text-decoration: overline}
  h2 {text-decoration: line-through}
  h3 {text-decoration: underline}
  h4 {text-decoration:blink}
  .a {text-decoration: none}
  </style>
   
  <h1>上划线</h1>
  <h2>删除效果</h2>
  <h3>下划线</h3>
  <h4>闪烁效果，大部分浏览器已经取消该效果</h4>
  <a href="http://how2j.cn/">默认的超链</a>
  <a class="a" href="http://how2j.cn/">去掉了下划线的超链</a>
  ```

- 行间距

  属性：line-height 
  值：数字或者百分比

  ```
  <style>
  p{
    width:200px; 
  }
  
  .p{
    line-height:200%;
  }
  </style>
  
  <p>
  默认行间距
  默认行间距
  默认行间距
  </p>
  
  <p class="p">
  200%行间距
  200%行间距
  200%行间距
  </p>
  ```

- 字符间距

  属性：letter-spacing 
  值： 数字

  ```
  <style>
  p{
    width:200px;
  }
   
  .p{
    letter-spacing:2;
  }
  </style>
   
  <p>
  abcdefg abcdefg abcdefg abcdefg abcdefg abcdefg
  </p>
   
  <p class="p">
  abcdefg abcdefg abcdefg abcdefg abcdefg abcdefg
  </p>
  ```

- 单词间距

  属性：word-spacing 
  值： 数字

  ```
  <style>
  p{
    width:200px;
  }
   
  .p{
    word-spacing:10;
  }
  </style>
   
  <p>
  abcdefg abcdefg abcdefg abcdefg abcdefg abcdefg
  </p>
   
  <p class="p">
  abcdefg abcdefg abcdefg abcdefg abcdefg abcdefg
  </p>
  ```

- 首行缩进

  属性：text-indent 
  值： 数字

  ```
  <style>
  p{
    width:200px;
  }
   
  .p{
    text-indent:50;
  }
  </style>
   
  <p>
  没有缩进效果的一段文字没有缩进效果的一段文字没有缩进效果的一段文字没有缩进效果的一段文字
  </p>
   
  <p class="p">
  有缩进效果的一段文字有缩进效果的一段文字有缩进效果的一段文字有缩进效果的一段文字有缩进效果的一段
  文字
  </p>
  ```

- 大小写

  属性：text-transform 
  值： 
  uppercase 全部大写 
  capitalize 首字母大写 
  lowercase 全部小写 

  ```
  <style>
  p.u {text-transform:uppercase}
  p.c {text-transform:capitalize}
  p.l {text-transform:lowercase}
   
  </style>
   
  <p class="u">
  abcD
  </p>
   
  <p class="c">
  abcD
  </p>
   
  <p class="l">
  abcD
  </p>
  ```

- 空白格

  属性：white-space
  值：
  normal 默认。多个空白格或者换行符会被合并成一个空白格
  pre 有多少空白格，显示多少空白格，相当于pre标签,如果长度超出父容器也不会换行。
  pre-wrap 有多少空白格，显示多少空白格，相当于pre标签,如果长度超出父容器，会换行。
  nowrap 一直不换行，直到使用br

  ```
  <style>
  p.n {white-space:normal}
  p.p {white-space:pre}
  p.pw {white-space:pre-wrap}
  p.nw {white-space:nowrap}
  
  </style>
  
  <p class="n">
  在默认情况下，多个     空白格或者
  换行符
  
      会被     合并成一个空白格
  </p>
  
  <p class="p">
  保留所有的    空白格
  以及换行符 
  相当于pre元素,如果长度超出父容器也不会换行。
  </p>
  
  <p class="pw">
  保留所有的    空白格
  以及换行符 
  相当于pre元素,如果长度超出父容器会换行。
  </p>
  
  <p class="nw">
  不会换行
  不会换行
  直到br<br/>才换行
  </p>
  ```

#### 字体

- 大小 font-size

  属性：font-size 
  值：数字或者百分比

  ```
  <style>
  p.big{
    font-size:30px;
  }
   
  p.small{
    font-size:50%;
  }
     
  p.small2{
    font-size:0.5em;
  } 
  </style>
   
  <p >正常大小</p>
  <p class="big">30px大小的文字</p>
  <p class="small">50%比例的文字</p>
  <p class="small2">0.5em 等同于 50%比例的文字</p>
  ```

- 风格 font-style

  font-style: 
  normal 标准字体 
  italic 斜体

  ```
  <style>
  p.n{
    font-style:normal;
  }
   
  p.i{
    font-style:italic;
  }
  </style>
   
  <p >标准字体</p>
  <p class="n">标准字体</p>
  <p class="i">斜体</p>
  ```

- 粗细 font-weight

  属性 font-weight 
  normal 标准粗细 
  bold 粗一点

  ```
  <style>
  p.n{
    font-weight:normal;
  }
  p.b{
    font-weight:bold;
  }
  </style>
   
  <p >标准字体</p>
  <p class="n">标准字体</p>
  <p class="b">粗一点</p>
  ```

- 字库 font-family

  属性font-family

  ```
  <style>
  p.f1{
    font-family:"Times New Roman";
  }
   
  p.f2{
    font-family:Arial;
  }
  p.f3{
    font-family:宋体;
  }
  p.f6{
    font-family:微软雅黑;
  }
  </style>
   
  <p >默认字库 font family:default </p>
  <p class="f1">设置字库 font-family: Times New Roman</p>
  <p class="f2">设置字库 font-family: Arial</p>
  <p class="f3">设置字库 font-family: 宋体, 这种字体是IE默认字体</p>
  <p class="f6">设置字库 font-family: 微软雅黑, 这个字体是火狐默认字体</p>
  ```

- 声明在一起

  把大小，风格，粗细，字库都写在一行里面

  ```
  <style>
  p.all{
     font:italic bold 30px "Times New Roman";
  }
   
  </style>
   
  <p>默认字体</p>
   
  <p class="all">斜体的 粗体的 大小是30px的 "Times New Roman" </p>
  ```

#### 鼠标样式

- 鼠标样式

  - cursor:default
  - cursor:auto
  - cursor:crosshair
  - cursor:pointer
  - cursor:e-resize
  - cursor:ne-resize
  - cursor:nw-resize
  - cursor:n-resize
  - cursor:se-resize
  - cursor:sw-resize
  - cursor:w-resize
  - cursor:text
  - cursor:wait
  - cursor:help
  - cursor:not-allowed

  ```
  <style>
    span{
      cursor:crosshair;
    }
  </style>
    
  <span>鼠标移动到这段文字上，就看到鼠标样式变成了十字架</span>
  ```

#### 表格

- 表格布局

  属性:table-layout 

  automatic; 单元格的大小由td的内容宽度决定 

  fixed; 单元格的大小由td上设置的宽度决定 
  **注**：只对连续的英文字母起作用，如果使用中文就看不到效果

  ```
  <style>
  table.t1{
    table-layout:automatic;
  }
   
  table.t2{
    table-layout:fixed;
  }
   
  </style>
   
  <table class="t1" border="1" width="100%">
     <tr>
        <td width="10%">abcdefghijklmnopqrstuvwxyz</td>
        <td width="90%">abc</td>
     </tr>
  </table>
   
  <table class="t2" border="1" width="100%">
     <tr>
        <td width="50px">abcdefghijklmnopqrstuvwxyz</td>
        <td >abc</td>
     </tr>
  </table>
  ```

- 表格边框

  属性：border-collapse
  值：
  separate:边框分隔
  collapse:边框合并

  ```
  <style>
  table.t1{
    border-collapse:separate;
  }
   
  table.t2{
     border-collapse:collapse;
  }
   
  </style>
   
  <table class="t1" border="1" width="200px">
     <tr>
        <td width="50%">边框分离</td>
        <td width="50%">边框分离</td>
     </tr>
  </table>
   
  <br/>
  <br/>
   
  <table class="t2" border="1" width="200px">
     <tr>
        <td width="50%">边框合并</td>
        <td width="50%">边框合并</td>
     </tr>
  </table>
  ```

#### 边框

- 边框风格

  属性： border-style 
  solid: 实线 
  dotted:点状 
  dashed:虚线 
  double:双线

  ```
  <style>
  .solid{
     border-style:solid;
  }
  .dotted{
     border-style:dotted;
  }
  .dashed{
     border-style:dashed;
  }
  .double{
     border-style:double;
  }
   
  </style>
   
  <div> 默认无边框div </div>
   
  <div class="solid"> 实线边框  </div><br/>
   
  <div class="dotted"> 点状边框  </div> <br/>
  <div class="dashed"> 虚线边框  </div> <br/>
  <div class="double"> 双线边框  </div> <br/>
  ```

- 边框颜色

  属性：border-color 
  值：red,#ff0000,rgb(255,0,0)

  ```
  <style>
  .red{
     border-style:solid;
     border-color:red;
  }
   
  </style>
   
  <div> 默认无边框div </div>
   
  <div class="red"> 实线红色边框  </div><br/>
  ```

- 边框宽度

  属性：border-width 
  值：数字

  ```
  <style>
  .red{
     border-style:solid;
     border-color:red;
     border-width:1px;
  }
   
  .default{
     border-style:solid;
     border-color:red;
  }
   
  </style>
   
  <div> 默认无边框div </div>
   
  <div class="red"> 实线红色细边框  </div><br/>
   
  <div class="default"> 实线红色默认宽度边框  </div><br/>
  ```

- 都放在一起

  属性：border
  值：颜色 风格 宽度

  ```
  <style>
  .red{
     border:1px dotted LightSkyBlue;
  }
   
  </style>
   
  <div> 默认无边框div </div>
   
  <div class="red"> 点状天蓝色细边框  </div><br/>
  ```

- 只有一个方向有边框

  通过制定位置，可以只给一个方向设置边框风格，颜色和宽度

  ```
  <style>
   div{
     width:150px;
     height:150px;
     border-top-style:solid;
     border-top-color:red;
     border-top-width: 50px;
     background-color:lightgray;  
    }
  </style>
   
  <div>
  只有上面有边框
  </div>
  ```

- 有交界的边都有边框

    比如上和左就是有交界的，而上和下就没有交界

  当有交界的边同时出现边框的时候，就会以倾斜的形式表现交界线。  

  ```
  <style>
   div.lefttop{
     width:150px;
     height:150px;
     border-top-style:solid;
     border-top-color:red;
     border-top-width: 50px;
     border-left-style:solid;
     border-left-color:blue;
     border-left-width: 50px;  
     background-color:lightgray;  
    }
     
    div.alldirection{
     width:150px;
     height:150px;
     border-top-style:solid;
     border-top-color:red;
     border-top-width: 50px;
     border-left-style:solid;
     border-left-color:blue;
     border-left-width: 50px;  
     border-bottom-style:solid;
     border-bottom-color:green;
     border-bottom-width: 50px;
     border-right-style:solid;
     border-right-color:yellow;
     border-right-width: 50px;     
     background-color:lightgray;  
    }
  </style>
    
  <div class="lefttop">
  左边和上边都有边框
  </div>
  <br>
  <div class="alldirection">
  四边都有边框　
  </div>
  ```

- 块级元素和内联元素的边框区别

  可以看到，块级元素div默认是占用100%的宽度，常见的块级元素有：div h1 p 等
  而内联元素span的宽度由其内容的宽度决定，常见的内联元素有 a b strong i input 等

  ```
  <style>
  .red{
     border:1px solid red;
  }
   
  </style>
   
  <div> 默认无边框div </div>
   
  <div class="red"> 实线红色细边框  </div><br/>
  <span class="red"> 实线红色细边框  </span><br/>
  ```

#### 内边距

元素内边距 指的是元素里的内容与边框之间的距离 
属性： 
		padding-left: 左内边距 
		padding-right: 右内边距 
		padding-top: 上内边距 
		padding-bottom: 下内边距 
		padding: 上 右 下 左

- 左内边距

  属性:padding-left 
  值：数字 
  指的是，元素中的内容，与边框之间的距离

  ```
  <style>
  .red{
     border:5px solid red;
     background-color:green;
  }
   
  .pad-left{
     border:5px solid red;
     background-color:green;
     padding-left:50px;
  }
   
  </style>
   
  <span class="red"> 无内边距的span  </span><br/> <br/>
   
  <span class="pad-left"> 左边距为50的span  </span><br/>
  ```

- 内边距，写1个和写4个的区别

  属性：padding
  值：如果只写一个，即四个方向的值
  值：如果写四个，即四个方向的值
  **上 右 下 左**,依**顺时针**的方向依次赋值

  ```
  <style>
  .pad-left-one{
     border:5px solid red;
     background-color:green;
     padding: 20;
  }
    
  .pad-left-four{
     border:5px solid red;
     background-color:green;
     padding: 10 20 30 40;
  }
    
  </style>
  <br/>
  <span class="pad-left-one"> padding:20的span  </span> <br/> <br/> <br/> <br/>
    
  <span class="pad-left-four">
  padding: 10 20 30 40 的span </span> <br/> <br/> <br/> <br/>
  ```

- 当内边距的值少于4个的时候

  如果**缺少左**内边距的值，则**使用右**内边距的值。
  如果**缺少下**内边距的值，则**使用上**内边距的值。
  如果**缺少右**内边距的值，则**使用上**内边距的值。
  举例说明
  这是完整4个的
  	padding: 10 20 40 80
  如果只有3个
  	padding: 10 20 40
  那么left取right
  	padding: 10 20 40 = padding: 10 20 40 **20**
  如果只有两个
  	padding: 10 20
  那么bottom取top，left取right
  	padding: 10 20 = padding:10 20 **10 20**
  如果只有一个
  	padding:10
  那么right取top，bottom取top，left取top
  	padding:10 = padding:10 **10 10 10**

#### 外边距

- 左外边距

  属性: margin-left
  值：数字
  指的是元素边框和元素边框之间的距离

  **注**：**像span这样的内联元素，默认情况下，只有左右外边距，没有上下外边距。**

  ```
  <style>
  .red{
     border:1px solid red;
     background-color:green;
  }
   
  .margin{
     border:1px solid red;
     background-color:green;
     margin-left:10px;
  }
   
  </style>
   
  <span class="red"> 无外边距的span  </span>
  <span class="red"> 无外边距的span  </span>
   
  <br/>
   
  <span class="red"> 无外边距的span  </span>
  <span class="margin"> 有左外边距的span  </span>
  ```

#### 边框模型

- 边框模型

  真正决定一个元素的表现形式，是由其边框模型决定的

  ```
  <style>
  .box{
      width:70px;
      padding:5px;
      margin: 10px;
  }
   
  div{
     border:1px solid gray;
     font-size:70%;
  }
  </style>
   
  <div>
   其他元素
  </div>
   
  <div class="box">
     内容宽度70px <br><br>
     内边距：5px <br> <br>
     外边距：10px <br>
  </div>
   
  <div>
   其他元素
  </div>
  ```

  ![è¾¹æ¡æ¨¡å](http://stepimagewm.how2j.cn/483.png)

#### 超链状态

- 超链状态有4种：

  - link - 初始状态，从未被访问过 
  - visited - 已访问过 
  - hover - 鼠标悬停于超链的上方 
  - active - 鼠标左键点击下去，但是尚未弹起的时候

- 去除超链的下划线

  使用 text-decoration: none 文本修饰的样式来解决

  ```
  <style>
  a.no_underline {text-decoration: none}
  </style>
     
  <a href="http://www.12306.com">默认的超链</a>
  <br>
  <a class="no_underline" href="http://www.12306.com">去除了下划线的超链</a>
  ```


#### 隐藏

- 隐藏

  隐藏元素有两种方式：

  - display:none

    使用display:none; 隐藏一个元素，这个元素将不再占有原空间 “坑” 让出来了

  - visibility:hidden

    使用 visibility:hidden;隐藏一个元素，这个元素继续占有原空间，只是“看不见”



#### 优先级

- style标签与外部文件style.css样式重复

  外部文件style.css有一个.p1，同时style标签中也有一个.p1，那么优先使用： 最后出现的一个

- style标签上的与style属性冲突

  style标签上的与style属性冲突 
  优先使用style属性

- !important

  如果样式上增加了!important，则优先级最高，甚至高于style属性

  ```
  <style>
  .p1{
    color:green !important;
  }
   
  </style>
   
  <p class="p1" style="color:red">p1 颜色是绿色，优先使用!important样式</p>
  ```

#### 绝对定位

- 绝对定位

  属性：position 
  值： absolute 
  设置了绝对定位的元素，相当于该元素被从原文档中删除了 

  ```
  <style>
  p.abs{
    position: absolute;
    left: 150px;
    top: 50px;
  }
   
  </style>
   
  <p >正常文字1</p>
  <p >正常文字2</p>
  <p class="abs" >绝对定位的文字3</p>
  <p >正常文字4</p>
  <p >正常文字5</p>
  ```

- 绝对定位是基于最近的一个定位了的父容器

  对于 "绝对定位的文字" 这个p，其定位了的父容器即 class="absdiv" 的div 
  所以 "绝对定位的文字" 这个p 出现的位置是以这个div 为基础的

  ```
  <style>
  p.abs{
    position: absolute;
    left: 100px;
    top: 50px;
  }
  .absdiv{
    position: absolute;
    left: 150px;
    top: 50px;
    width:215px;
    border: 1px solid blue;
  }
  </style>
   
  <div>
  <p >正常文字a</p>
  <p >正常文字b</p>
  <p >正常文字c</p>
  <p >正常文字d</p>
  <p >正常文字e</p>
  <p >正常文字f</p>
  <p >正常文字g</p>
  </div>
   
  <div class="absdiv">
  这是一个定位了的div
  <p class="abs" >绝对定位的文字</p>
  </div>
  ```

- 如果没有定位了的父容器

  "绝对定位的文字" 这个p 的父容器div，并没有定位。 所以它的”最近的一个定位了的父容器” 即body

  ```
  <style>
  p.abs{
    position: absolute;
    left: 100px;
    top: 50px;
  }
   
  </style>
   
  <div>
  <p >正常文字a</p>
  <p >正常文字b</p>
  <p >正常文字c</p>
  <p >正常文字d</p>
  <p >正常文字e</p>
  <p >正常文字f</p>
  <p >正常文字g</p>
  </div>
   
  <div>
  这个div没有定位
  <p class="abs" >绝对定位的文字</p>
  </div>
  ```

- z-index

   通过绝对定位可以把一个元素放在另一个元素上，这样位置就重复了。

  重复了，就存在一个谁掩盖谁的问题。 这个时候就可以使用

  z-index属性， 当z-index的值越大，就表示放上面，z-index:越小就表示放下面。  

  ```
  <style>
  img#i1{
    position: absolute;
    left: 60px;
    top: 20px;
    z-index:1;
  }
     
    img#i2{
    position: absolute;
    left: 60px;
    top: 120px;
    z-index:-1;
  }
    
  </style>
    
  <div>
  <p >正常文字a</p>
  <p >正常文字b</p>
  <p >正常文字c</p>
  <p >正常文字d</p>
  <p >正常文字e</p>
  <p >正常文字f</p>
  <p >正常文字g</p>
  </div>
   
  <img id="i1" src="http://how2j.cn/example.gif" />
  <img id="i2" src="http://how2j.cn/example.gif" />
  ```

#### 相对定位

- 概念

  属性：position 
  值： relative 
  与绝对定位不同的是，相对定位不会把该元素从原文档删除掉，而是在原文档的位置的基础上，移动一定的距离

  ```
  <style>
  p.r{
    position: relative;
    left: 150px;
    top: 50px;
  }
    
  </style>
    
  <p >正常文字1</p>
  <p >正常文字2</p>
  <p class="r" >相对定位的文字3</p>
  <p >正常文字4</p>
  <p >正常文字5</p>
  ```

- 练习-相对定位，但是又不占用位置

  相对定位的文字3 在原来的位置的基础上，向右移动150个像素，但是又不占用原来的坑。 

  结合相对定位和绝对定位实现这个效果  

  ```
  <style>
  p.r {
  	position: relative;
  	left: 100px;
  	top: 0px;
  }
  div.a{
  	position: absolute;
  	top: 68px;
  }
  </style>
   
  <p>正常文字1</p>
  <p>正常文字2</p>
  <p class="r">相对定位的文字3</p>
  <div class="a">
  	<p>正常文字4</p>
  	<p>正常文字5</p>
  </div>
  ```

#### 浮动

​	浮动的框可以向左或向右移动，直到它的外边缘碰到包含框或另一个浮动框的边框为止。 

​	属性：float;

​	值： left,right

- 文字向右浮动

  文字向右浮动，浮动后，原来的“**坑**”就让出来了
  并且是在原来的高度的基础上，向右浮动

  ```
  <style>
  .f{
    float:right;
  }
   
  </style>
   
  <div >正常文字1</div>
  <div >正常文字2</div>
  <div class="f">浮动的文字</div>
  <div >正常文字4</div>
  <div >正常文字5</div>
  ```

- 文字向左浮动

  首先，向左浮动后，会把“坑”让出来，这个时候"正常的文字4“ 就会过来试图占这个坑，但是，发现 “浮动的文字”并没有走，结果，就只好排在它后面了

  ```
  <style>
  .f{
    float:left;
  }
   
  </style>
   
  <div >正常文字1</div>
  <div >正常文字2</div>
  <div class="f">浮动的文字</div>
  <div >正常文字4</div>
  <div >正常文字5</div>
  ```

- 文字围绕图片

  当图片不浮动时，文字就会换行出现在下面 
  当图片浮动时，文字围绕着图片

  当图片浮动的时候，就会让出这个“坑”出来，这个时候文字就试图去填补这个“坑”，结果发现，图片没走，那就只好围绕图片摆放了

  ```
  <style>
  .f{
    float:left;
  }
   
  div{
    width:320px;
  }
  </style>
   
  <div >
   <img src="http://how2j.cn/example.gif"/>
   
  <p>  当图片不浮动时，文字就会换行出现在下面
    当图片不浮动时，文字就会换行出现在下面
    当图片不浮动时，文字就会换行出现在下面
    当图片不浮动时，文字就会换行出现在下面
    当图片不浮动时，文字就会换行出现在下面
    当图片不浮动时，文字就会换行出现在下面
  </p>
  </div>
   
  <div >
   <img  class="f" src="http://how2j.cn/example.gif"/>
   
  <p>  当图片浮动时，文字围绕着图片
   当图片浮动时，文字围绕着图片
   当图片浮动时，文字围绕着图片
   当图片浮动时，文字围绕着图片
   当图片浮动时，文字围绕着图片
  </p>
  </div>
  ```

- 文字不想围绕图片

  不允许出现浮动元素 
  属性:clear 
  值: left right both none 
  如：p左边出现了浮动的元素，则设置clear:left 即达到不允许浮动元素出现在左边的效果

  ```
  <style>
  .f{
    float:left;
  }
   
  div{
    width:320px;
  }
   
  .clearp{
    clear:left;
  }
   
  </style>
   
  <div >
   <img  class="f" src="http://how2j.cn/example.gif"/>
   
  <p>  当图片浮动时，文字围绕着图片
   当图片浮动时，文字围绕着图片
   当图片浮动时，文字围绕着图片
   当图片浮动时，文字围绕着图片
   当图片浮动时，文字围绕着图片
  </p>
  </div>
   
  <div >
   <img  class="f" src="http://how2j.cn/example.gif"/>
   
  <p class="clearp">  当图片浮动时，文字却不想围绕图片
  当图片浮动时，文字却不想围绕图片
  当图片浮动时，文字却不想围绕图片
  当图片浮动时，文字却不想围绕图片
   
  </p>
  </div>
  ```

- 水平排列div

  默认的div排列是会换行的 
  如果使用float就可以达到水平排列的效果，通常会用在菜单，导航栏等地方 
  如果超出了父容器，还会有自动换行的效果

  ```
  <style>
  div#floatingDiv{
    width:200px;
  }
  div#floatingDiv div{
     float:left;
  }
  </style>
  默认的div排列是会换行的
   
   <div>
         菜单1
   </div>
   <div>
         菜单2
   </div>
   <div>
         菜单3
   </div>
   
  如果使用float就可以达到水平排列的效果，通常会用在菜单，导航栏等地方
   
  如果超出了父容器，还会有自动换行的效果
   
  <div id="floatingDiv">
    <div>
         菜单1
   </div>
   <div>
         菜单2
   </div>
   <div>
         菜单3
   </div>
   <div>
         菜单4
   </div>
   <div>
         菜单5
   </div>
   <div>
         菜单6
   </div>
  </div>
  ```

#### 显示方式

​	元素的display显示方式有多种，隐藏、块级、内联、内联-块级

- 隐藏

  **display:none;** 使得被选择的元素隐藏，并且不占用原来的位置

  ```
  <style>
  div.d{
    display:none;
  }
   
  </style>
    
  <div>可见的div1</div>
  <div class="d">隐藏的div2,使用display:none隐藏</div>
  <div>可见的div3</div>
  ```

- 块级

  **display:block;** 表示块级元素

  块级元素会自动在前面和后面加上换行，并且在其上的width和height也能够生效

  div默认是块级元素
  span默认是内联元素(不会有换行,width和height也不会生效)

  ```
  <style>
  div,span{
     border: 1px solid lightgray;
     margin:10px;
     width:200px;
     height:100px;
  }
   
  .d{
    display:block;
  }
  </style>
    
  <div>普通的div块</div>
  <span>这是普通span</span> <span>这是普通span</span> <span>这是普通span</span>
  <span class="d">这是span,被改造成了块级元素</span>
  ```

- 内联

  **display:inline;** 表示内联元素
  内联元素前后没有换行，并且在其上的width和height也无效。 其大小由其中的内容决定

  div默认是块级元素
  span默认是内联元素

  ```
  <style>
  div,span{
     border: 1px solid lightgray;
     margin:10px;
     width:200px;
     height:100px;
  }
   
  .s{
    display:inline;
  }
  </style>
   
  <span>这是普通span</span> <span>这是普通span</span> <span>这是普通span</span>
    
  <div class="s">这是div，被改造成了内联元素</div>
  ```

- 内联-块级

   内联不会换行，也不能指定大小
  块级能指定大小，但是会换行

  有时候，需要元素处于同一行，同时还能指定大小，这个时候，就需要用到**内联-块级** inline-block  

  ```
  <style>
  span{
     display:inline-block;
     border: 1px solid lightgray;
     margin:10px;
     width:100px;
  }
  </style>
  像这样 ，每个都能设置宽度 ，同时还能在同一行。
  <br>
   
  <span>盖伦</span>
  <span>蒙多医生</span>
  <span>奈德丽</span>
  <span>蒸汽机器人</span>
  ```

#### 水平居中

- 内容居中

  通过设置属性align="center" 居中的内容

  通过样式style="text-align:center" 居中的内容

  ```
  <style>
  div{
    border:1px solid lightgray;
    margin:10px;
  }
  </style>
  <div align="center">
  通过设置属性align="center" 居中的内容
  </div>
   
  <div  style="text-align:center">
  通过样式style="text-align:center" 居中的内容
  </div>
  ```

- 元素居中

  默认情况下div会占用100%的宽度,所以无法观察元素是否居中

  设置本div的宽度，然后再使用样式 margin: 0 auto来使得元素居中

  span 是内联元素，无法设置宽度，所以不能通过margin:0 auto居中

  span的居中可以通过放置在div中，然后让div text-align实现居中

  ```
  <style>
    div{
       border: solid 1px lightgray;
       margin: 10px;
    }
    span{
       border: solid 1px lightskyblue;
    }
  </style>
  <div> 默认情况下div会占用100%的宽度,所以无法观察元素是否居中</div>
   
  <div style="width:300px;margin:0 auto">
    设置本div的宽度，然后再使用样式 margin: 0 auto来使得元素居中</div>
   
  <span style="width:300px;margin:0 auto">
    span 是内联元素，无法设置宽度，所以不能通过margin:0 auto居中</span>
   
  <div style="text-align:center">
    <span>span的居中可以通过放置在div中，然后让div text-align实现居中</span>
  </div>
  ```

#### 左侧固定

- 左侧固定，右边自动占满

  ```
  <style>
   .left{
     width:200px;
     float:left;
     background-color:pink
    }
    .right{
      overflow:hidden;
      background-color:lightskyblue;
    }
  </style>
   
  <div class="left">左边固定宽度</div>
   
  <div class="right">右边自动填满</div>
  ```

  overflow:hidden的用途是清除浮动

  这里把overflow:hidden去掉，并且把.right的高度增加，就会看到.right会包围.left。 所以需要加上overflow:hidden

#### 垂直居中

- line-height方式

  line-height 适合单独一行垂直居中，不能用作图片

  ```
  <style>
  #d {
  line-height: 100px;
  }
  div{
    border:solid 1px lightskyblue;
  }
  </style>
   
  <div id="d">line-height 适合单独一行垂直居中</div>
  ```

- 内边距方式

  借助设置相同的上下内边距，实现垂直居中效果，可以用在多行文本上

  **对图片也可以居中，上一步 line-height就不能对图片居中**。

  ```
  <style>
  #d {
      padding: 30 0;
  }
  div{
      border:solid 1px lightskyblue;
  }
  </style>
   
  <div id="d">多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容 多行内容  </div>
  ```

- table方式

  首先通过**display: table-cell;**把div用单元格的形式显示，然后借用单元格的垂直居中**vertical-align: middle;** 来达到效果。**对图片也可以居中，上一步 line-height就不能对图片居中**。

#### 左右固定

- 左右固定，中间自适应的布局

  ```
  <style>
   .left{
     width:200px;
     float:left;
     background-color:pink
    }
    .right{
     width:200px;
     float:right;
     background-color:pink
    }
    .center {margin:0 200px;   background-color:lightblue}
  </style>
    
  <div class="left">左边固定宽度</div>
  <div class="right">左边固定宽度</div>
   <div class="center">中间自适应</div>
   
  </head>
   
  <body>
   
  </html>
  
  ```

  **个人认为此处的margin:0 200px替换为overflow:hidden，更符合自适应的要求**

- overflow:hidden与margin:0 200px的区别

  - overflow:hidden会清除掉浮动
  - margin:0 200px不会清除浮动，只会左右有200px的边距

  ```
  <style>
   .left{
     width:200px;
     float:left;
     background-color:pink
    }
    .right{
     width:200px;
     float:right;
     background-color:pink
    }
    .center { 
    margin:0 100px; 
    #overflow:hidden;
    background-color:lightblue; height:200px;}
  </style>
    
  <div class="left">左边固定宽度</div>
  <div class="right">左边固定宽度</div>
   <div class="center">中间自适应</div>
  ```

#### 贴在下方

- 一个div始终贴在下方

  首先把外面的div设置为相对定位

  然后把里面的div设置为绝对定位， **bottom: 0**表示贴在下面  

  ```
  <style>
  #div1
          {
              position: relative;
              height: 300px;
              background-color: skyblue;
          }
          #div2
          {
              position: absolute;
              bottom: 0;
              height: 30px;
              width: 100%;
              background-color: lightgreen;
          }
      </style>
   
  <div id="div1">
      <div id="div2"> 无论蓝色div高度如何变化，绿色div都会贴在下面
      </div>
  </div>
  
  ```

#### 块之间的空格

- 块之间有空格

  真正开发代码的时候，一般不会连续书写span,而是不同的span之间有回车换行，比如这样：

  ```
  <span>有换行的span</span>
  <span>有换行的span</span>
  <span>有换行的span</span>
  ```

  而这样编写代码，就会导致<span>之间出现空格

- 解决办法

  使用float来解决。
  float使用完毕之后，记得在下面加上 <div style="clear:both"></div> 用于使得后续的元素，不会和这些span重复在一起

  ```
  <style>
  div.nocontinue span{
  border-bottom:2px solid lightgray;
    float:left;
  }
  </style>
    
  <div class="nocontinue">
  <span>有换行的span</span>
  <span>有换行的span</span>
  <span>有换行的span</span>
  </div>
   
  <div style="clear:both"></div>
   
  <div>后续的内容</div>
  ```

#### 显示图片一部分

​	![img](http://how2j.cn/study/wangwang.gif)

- 使用背景方式

  使用背景的方式获取一部分图片

  ```
  background:transparent url(/study/wangwang.gif) no-repeat scroll -83px -0px ;
  ```

  等同于：

  ```
  background-color:transparent;
  background-image:url(/site/wangwang.gif);
  background-repeat:no-repeat;
  background-attachment:scroll;
  background-position: -83px -0px;
  ```

  设置**scroll -83px -0px** 把图片向左滚动83个像素，向上滚动0个像素。
  再把div大小设置为和小图片大小一样，即可大小只显示部分图片的效果

  ```
  <style>
  div{
      width:25;
      height:25;
      background:transparent url(http://how2j.cn/study/wangwang.gif) no-repeat scroll -83px -0px ;
  }
  </style>
   
  <div></div>
  ```

- 使用img方式

  借助裁剪的方式只显示部分图片：

  ```
  clip:rect(top, right, bottom, left)
  ```

  裁剪之后，只显示被裁剪出来的图片，所以还需要把整个图片向左移动，才看上去像拿到了想要的那部分图片

  ```
  <style>
  img{
      position:absolute;
      left:-83px;
      clip:rect(0px 108px 25px 83px);
  }
  </style>
   
  <img src="http://how2j.cn/study/wangwang.gif">
  ```

  