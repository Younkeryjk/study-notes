# BootStrap

### 入门

- DOCTYPE头

  因为bootstrap用到了html5的特性，为了正常使用，需要在最开头加上 

  ```
  <!DOCTYPE html>
  ```

- 导入js、css

  Bootstrap需要**JQuery**才能正常工作，所以需要导入jquery.min.js
  接着是 **Bootstrap的css**，里面定义了各种样式
  最后是 **Bootstrap的js**，用于产生交互效果，比如关闭警告框
  注：顺序不要搞错了，否则有一些效果会出不来。

  ```
  <script src="jquery.min.js"></script>
  <link href="bootstrap.min.css" rel="stylesheet">
  <script src="bootstrap.min.js"></script>
  ```

- 套用class

  使用是非常简单的，只需要套用 bootstrap css中定义的class即可

### 基本样式

#### 	按钮

- 按钮样式 可以用于：

  ```
  按钮元素<button> 
  超链元素<a> 
  按钮类型的input元素 <input type="button"> 
  提交类型的input元素 <input type="submit"> 
  重置类型的input元素 <input type="reset">
  ```

- 原始样式按钮

  把button标签变成了平面的，一般不使用

  ```
  <button type="button" class="btn">原始样式按钮</button>
  ```

- 默认按钮

  无色按钮

  ```
  <button type="button" class="btn btn-default">默认按钮</button>
  ```

- 提交按钮

  用于提交数据

  ```
  <button type="button" class="btn btn-primary">提交按钮</button>
  ```

- 成功按钮

  一般用于一系列操作的最后一步，比如购物车的最后付款一步

  ```
  <button type="button" class="btn btn-success">成功按钮</button>
  ```

- 信息按钮

  点击后，显示更多的信息

  ```
  <button type="button" class="btn btn-info">信息按钮</button>
  ```

- 警告按钮

  一般用于修改行为的按钮

  ```
  <button type="button" class="btn btn-warning">警告按钮</button>
  ```

- 危险按钮

  一般用于严重行为的按钮，比如删除

  ```
  <button type="button" class="btn btn-danger">危险按钮</button>
  ```

- 表现为链接

  button标签会**表现为**一个超链，但是**依然是**一个button标签

  ```
  <button type="button" class="btn btn-link">表现为链接</button>
  ```

- 大一点的按钮

  引起瞩目的按钮

  ```
  <button type="button" class="btn btn-lg">大一点的按钮</button>
  ```

- 小一点的按钮

  放不下的时候，就用小一点的按钮

  ```
  <button type="button" class="btn btn-sm">小一点的按钮</button>
  ```

- 最小的按钮

  还放不下就用这个

  ```
  <button type="button" class="btn btn-xs">最小的按钮</button>
  ```

- 宽屏按钮

  水平方向占用父容器的100%

  ```
  <button type="button" class="btn btn-block">宽屏按钮</button>
  ```

- 激活状态按钮

  按钮处于正在被按下状态，一般用于显示一个需要消耗较多时间的操作，比如上传一个图片

  ```
  <button type="button" class="btn active">激活状态按钮</button>
  ```

- 无效按钮

  按钮处于无效状态，不可点击，比如发了2秒钟后的红包

  ```
  <button type="button" class="btn disabled">领红包</button>
  ```

- 多种按钮样式混用

  多种按钮样式可以用在一起

  ```
  <button type="button" class="btn disabled btn-danger btn-xs">发红包</button>
  ```

#### 表格

- 基本表格

  拥有横向分割线的表格，宽度占用父容器的

  ```
  <table class="table">
  ```

- 带斑马线的表格

  通过斑马线把奇偶行的区别表现出来

  ```
  <table class="table table-striped">
  ```

- 带边框的表格

  给表格的单元格加上边框

  ```
  <table class="table table-bordered">
  ```

- 有鼠标悬停状态的表格

  鼠标悬停高亮显示

  ```
  <table class="table table-hover">
  ```

- 更加紧凑的表格

  ```
  <table class="table table-condensed">
  ```

- 多种表格效果整合在一起

  ```
  <table class="table table-striped table-bordered table-hover  table-condensed">
  ```

- 激活样式

  用于表示该行被选中

  ```
  <tr  class="active">
  ```

- 成功样式

  ```
  <tr  class="success">
  ```

- 信息样式

  ```
  <tr  class="info">
  ```

- 警告样式

  ```
  <tr  class="warning">
  ```

- 危险样式

  ```
  <tr  class="danger">
  ```

#### 图片

- 圆角

  ```
  <img src="http://how2j.cn/example.gif" class="img-rounded">
  ```

- 圆形

  ```
  <img src="http://how2j.cn/example.gif" class="img-circle">
  ```

- 缩略图

  ```
  <img src="http://how2j.cn/example.gif" class="img-thumbnail">
  ```

#### 表单

​	对输入元素使用form-control 可以去除阴影，边框附带淡蓝色，输入状态更加柔和

- 表单输入元素

  一般会在文本框 密码框和文本域上使用

  ```
  <input type="text" class="form-control" value="文本框">
  <input type="password" class="form-control" value="password">
  <textarea  class="form-control">文本域</textarea>
  <select class="form-control">
     <option>Java</option>
     <option>Html</option>
     <option>IOS</option>
  </select>
  ```

#### 文本

- 淡灰色文本

  ```
  <span class="text-muted">muted</span>
  ```

- 强调的文本

  ```
  <span class="text-primary">primary</span>
  ```

- 操作成功文本

  ```
  <span class="text-success">success</span>
  ```

- 提示信息文本

  ```
  <span class="text-info">info</span>
  ```

- 警告文本

  ```
  <span class="text-warning">warning</span>
  ```

- 危险操作文本

  ```
  <span class="text-danger">danger</span>
  ```

#### 背景

- 强调的背景

  一般用在需要强调的文字上

  ```
  <p class="bg-primary">强调</p>
  ```

- 成功操作文字的背景

  ```
  <p class="bg-success">操作成功</p>
  ```

- 信息提示文字的背景

  ```
  <p class="bg-info">请输入姓名</p>
  ```

- 警告提示文字的背景

  ```
  <p class="bg-warning">警告语</p>
  ```

- 危险提示文字的背景

  ```
  <p class="bg-danger">本操作会导致服务器挂掉</p>
  ```

#### 其他

- 关闭按钮

  ```
  <button type="button" class="close" aria-hidden="true">
        &times;
  </button>
  ```

- 下拉菜单的按钮

  ```
  <span class="caret"></span>
  ```

- 左浮动

  ```
  <div class="pull-left">文字浮动到左边</div>
  ```

- 右浮动

  ```
  <div class="pull-right">文字浮动到右边</div>
  ```

- 显示

  ```
  <div class="show">显示</div>
  ```

- 隐藏

  强行隐藏，会把该元素的位置也让出来

  ```
  <div class="hidden">隐藏</div>
  ```

- 隐藏

  强行隐藏，该元素的位置会保留

  ```
  <div class="invisible">隐藏</div>
  ```

#### 格栅布局

- 栅格系统

  运用Bootstrap的栅格系统，可以做出像table那样**定义多少行，多少列**效果，但是又比table灵活。

  运用Bootstrap的栅格系统，首选需要准备一个**class=container**的div
  紧接着需要一个**class=row**的 div，表示行
  再挨着的div，就是列了。

  Bootstrap的栅格系统会默认把一行，分成12列。
  
  当同一行的栅格总数超过12的时候，就会自动换行
  
  ```
  注：一行不是必须添满的，比如只填了3个 1/4，最后一个1/4就可以空着
  ```
  
  ```
  <div class="container">
      <div class="row">
          <div class="col-xs-8 ">8格</div>
          <div class="col-xs-6 ">6格</div>
      </div>
  </div>
  <div class="container">
      <div class="row">
          <div class="col-xs-4 ">1/3</div>
          <div class="col-xs-4 ">1/3</div>
          <div class="col-xs-4 ">1/3</div>
      </div>
  </div>
  <div class="container">
      <div class="row">
          <div class="col-xs-3 ">1/4</div>
          <div class="col-xs-3 ">1/4</div>
          <div class="col-xs-3 ">1/4</div>
      </div>
  </div>
  ```

### 组件

#### 字体图标

- 一个字体图标

  ```
  <span class="glyphicon glyphicon-asterisk"></span>
  ```

- 字体图标设置颜色

  ```
  <span class="glyphicon glyphicon-asterisk text-success"></span>
  ```

- 字体图标上加超链

  ```
  <a href="#nowhere">
      <span class="glyphicon glyphicon-asterisk"></span> 连接
  </a>
  ```

- 在button上使用字体图标

  ```
  <button class="btn btn-primary btn">
      <span class="glyphicon glyphicon-asterisk"></span> 按钮
  </button>
  ```

- 所有的字体图标

  ```
  class							图标
  glyphicon glyphicon-asterisk	菊花
  glyphicon glyphicon-plus	加号
  glyphicon glyphicon-euro	欧元
  glyphicon glyphicon-eur	欧元
  glyphicon glyphicon-minus	减号
  glyphicon glyphicon-cloud	云
  glyphicon glyphicon-envelope	信封
  glyphicon glyphicon-pencil	铅笔
  glyphicon glyphicon-glass	酒杯
  glyphicon glyphicon-music	音乐
  glyphicon glyphicon-search	搜索
  glyphicon glyphicon-heart	心型
  glyphicon glyphicon-star	明星
  glyphicon glyphicon-star-empty	星空
  glyphicon glyphicon-user	用户
  glyphicon glyphicon-film	电影
  glyphicon glyphicon-th-large	粗颗粒
  glyphicon glyphicon-th	细颗粒
  glyphicon glyphicon-th-list	列表
  glyphicon glyphicon-ok	成功
  glyphicon glyphicon-remove	删除
  glyphicon glyphicon-zoom-in	放大
  glyphicon glyphicon-zoom-out	缩小
  glyphicon glyphicon-off	关闭
  glyphicon glyphicon-signal	信号
  glyphicon glyphicon-cog	设置
  glyphicon glyphicon-trash	垃圾箱
  glyphicon glyphicon-home	主页
  glyphicon glyphicon-file	文件
  glyphicon glyphicon-time	时间
  glyphicon glyphicon-road	道路
  glyphicon glyphicon-download-alt	下载
  glyphicon glyphicon-download	下载
  glyphicon glyphicon-upload	上传
  glyphicon glyphicon-inbox	收件箱
  glyphicon glyphicon-play-circle	播放
  glyphicon glyphicon-repeat	重复
  glyphicon glyphicon-refresh	刷新
  glyphicon glyphicon-list-alt	列表
  glyphicon glyphicon-lock	锁定
  glyphicon glyphicon-flag	旗帜
  glyphicon glyphicon-headphones	耳机
  glyphicon glyphicon-volume-off	静音
  glyphicon glyphicon-volume-down	调低音量
  glyphicon glyphicon-volume-up	调高音量
  glyphicon glyphicon-qrcode	二维码
  glyphicon glyphicon-barcode	条码
  glyphicon glyphicon-tag	标签
  glyphicon glyphicon-tags	复数标签
  glyphicon glyphicon-book	书籍
  glyphicon glyphicon-bookmark	书签
  glyphicon glyphicon-print	打印
  glyphicon glyphicon-camera	相机
  glyphicon glyphicon-font	字体
  glyphicon glyphicon-bold	粗体
  glyphicon glyphicon-italic	斜体
  glyphicon glyphicon-text-height	文本高度
  glyphicon glyphicon-text-width	文本宽度
  glyphicon glyphicon-align-left	左对齐
  glyphicon glyphicon-align-center	居中对齐
  glyphicon glyphicon-align-right	右对齐
  glyphicon glyphicon-align-justify	对齐
  glyphicon glyphicon-list	列表
  glyphicon glyphicon-indent-left	左缩进
  glyphicon glyphicon-indent-right	右缩进
  glyphicon glyphicon-facetime-video	视频
  glyphicon glyphicon-picture	图片
  glyphicon glyphicon-map-marker	地图标记
  glyphicon glyphicon-adjust	调整
  glyphicon glyphicon-tint	色彩
  glyphicon glyphicon-edit	编辑
  glyphicon glyphicon-share	分享
  glyphicon glyphicon-check	检查
  glyphicon glyphicon-move	移动
  glyphicon glyphicon-step-backward	单步后退
  glyphicon glyphicon-fast-backward	快速后退
  glyphicon glyphicon-backward	后退
  glyphicon glyphicon-play	播放
  glyphicon glyphicon-pause	暂停
  glyphicon glyphicon-stop	停止
  glyphicon glyphicon-forward	前进
  glyphicon glyphicon-fast-forward	快速前进
  glyphicon glyphicon-step-forward	单步向前
  glyphicon glyphicon-eject	弹出
  glyphicon glyphicon-chevron-left	左
  glyphicon glyphicon-chevron-right	右
  glyphicon glyphicon-plus-sign	增加
  glyphicon glyphicon-minus-sign	减少
  glyphicon glyphicon-remove-sign	删除
  glyphicon glyphicon-ok-sign	确定
  glyphicon glyphicon-question-sign	问题
  glyphicon glyphicon-info-sign	信息
  glyphicon glyphicon-screenshot	截图
  glyphicon glyphicon-remove-circle	删除
  glyphicon glyphicon-ok-circle	确定
  glyphicon glyphicon-ban-circle	禁止
  glyphicon glyphicon-arrow-left	左箭头
  glyphicon glyphicon-arrow-right	右箭头
  glyphicon glyphicon-arrow-up	上箭头
  glyphicon glyphicon-arrow-down	下箭头
  glyphicon glyphicon-share-alt	分享
  glyphicon glyphicon-resize-full	打开
  glyphicon glyphicon-resize-small	关闭
  glyphicon glyphicon-exclamation-sign	感叹号
  glyphicon glyphicon-gift	礼物
  glyphicon glyphicon-leaf	树叶
  glyphicon glyphicon-fire	火焰
  glyphicon glyphicon-eye-open	睁眼
  glyphicon glyphicon-eye-close	闭眼
  glyphicon glyphicon-warning-sign	警告
  glyphicon glyphicon-plane	飞机
  glyphicon glyphicon-calendar	日历
  glyphicon glyphicon-random	随机播放
  glyphicon glyphicon-comment	评论
  glyphicon glyphicon-magnet	磁铁
  glyphicon glyphicon-chevron-up	上调
  glyphicon glyphicon-chevron-down	下调
  glyphicon glyphicon-retweet	转发
  glyphicon glyphicon-shopping-cart	购物车
  glyphicon glyphicon-folder-close	关闭文件夹
  glyphicon glyphicon-folder-open	打开文件夹
  glyphicon glyphicon-resize-vertical	垂直调整
  glyphicon glyphicon-resize-horizontal	水平调整
  glyphicon glyphicon-hdd	硬盘
  glyphicon glyphicon-bullhorn	扩音器
  glyphicon glyphicon-bell	铃铛
  glyphicon glyphicon-certificate	证书
  glyphicon glyphicon-thumbs-up	赞同
  glyphicon glyphicon-thumbs-down	否定
  glyphicon glyphicon-hand-right	右手
  glyphicon glyphicon-hand-left	左手
  glyphicon glyphicon-hand-up	举起手
  glyphicon glyphicon-hand-down	放下手
  glyphicon glyphicon-circle-arrow-right	右箭头
  glyphicon glyphicon-circle-arrow-left	左箭头
  glyphicon glyphicon-circle-arrow-up	上箭头
  glyphicon glyphicon-circle-arrow-down	下箭头
  glyphicon glyphicon-globe	全球
  glyphicon glyphicon-wrench	扳手
  glyphicon glyphicon-tasks	任务
  glyphicon glyphicon-filter	过滤器
  glyphicon glyphicon-briefcase	公文包
  glyphicon glyphicon-fullscreen	全屏
  glyphicon glyphicon-dashboard	仪表板
  glyphicon glyphicon-paperclip	回形针
  glyphicon glyphicon-heart-empty	空的心型
  glyphicon glyphicon-link	链接
  glyphicon glyphicon-phone	手机
  glyphicon glyphicon-pushpin	图钉
  glyphicon glyphicon-usd	美元
  glyphicon glyphicon-gbp	英镑
  glyphicon glyphicon-sort	排序
  glyphicon glyphicon-sort-by-alphabet	字母正序
  glyphicon glyphicon-sort-by-alphabet-alt	字母倒序
  glyphicon glyphicon-sort-by-order	数字正序
  glyphicon glyphicon-sort-by-order-alt	数字倒序
  glyphicon glyphicon-sort-by-attributes	属性正序
  glyphicon glyphicon-sort-by-attributes-alt	属性倒序
  glyphicon glyphicon-unchecked	未选中
  glyphicon glyphicon-expand	扩展
  glyphicon glyphicon-collapse-down	向下扩展
  glyphicon glyphicon-collapse-up	向上扩展
  glyphicon glyphicon-log-in	登录
  glyphicon glyphicon-flash	闪电
  glyphicon glyphicon-log-out	注销
  glyphicon glyphicon-new-window	新窗口
  glyphicon glyphicon-record	记录
  glyphicon glyphicon-save	已保存
  glyphicon glyphicon-open	打开
  glyphicon glyphicon-saved	保存的
  glyphicon glyphicon-import	导入
  glyphicon glyphicon-export	导出
  glyphicon glyphicon-send	发送
  glyphicon glyphicon-floppy-disk	软盘
  glyphicon glyphicon-floppy-saved	软盘已保存
  glyphicon glyphicon-floppy-remove	软盘删除
  glyphicon glyphicon-floppy-save	软盘保存
  glyphicon glyphicon-floppy-open	软盘打开
  glyphicon glyphicon-credit-card	信用卡
  glyphicon glyphicon-transfer	转移
  glyphicon glyphicon-cutlery	餐具
  glyphicon glyphicon-header	标题
  glyphicon glyphicon-compressed	压缩
  glyphicon glyphicon-earphone	听筒
  glyphicon glyphicon-phone-alt	电话
  glyphicon glyphicon-tower	塔
  glyphicon glyphicon-stats	统计
  glyphicon glyphicon-sd-video	标清视频
  glyphicon glyphicon-hd-video	高清视频
  glyphicon glyphicon-subtitles	字幕
  glyphicon glyphicon-sound-stereo	音响音响
  glyphicon glyphicon-sound-dolby	声音杜比
  glyphicon glyphicon-sound-5-1	sound-5-1
  glyphicon glyphicon-sound-6-1	sound-6-1
  glyphicon glyphicon-sound-7-1	sound-7-1
  glyphicon glyphicon-copyright-mark	版权标志
  glyphicon glyphicon-registration-mark	注册商标
  glyphicon glyphicon-cloud-download	云下载
  glyphicon glyphicon-cloud-upload	云上传
  glyphicon glyphicon-tree-conifer	针叶树
  glyphicon glyphicon-tree-deciduous	落叶树
  glyphicon glyphicon-cd	CD
  glyphicon glyphicon-save-file	保存文件
  glyphicon glyphicon-open-file	打开文件
  glyphicon glyphicon-level-up	水平上升
  glyphicon glyphicon-copy	复制
  glyphicon glyphicon-paste	粘贴
  glyphicon glyphicon-alert	警报
  glyphicon glyphicon-equalizer	均衡器
  glyphicon glyphicon-king	国王
  glyphicon glyphicon-queen	女王
  glyphicon glyphicon-pawn	小卒
  glyphicon glyphicon-bishop	主教
  glyphicon glyphicon-knight	骑士
  glyphicon glyphicon-baby-formula	婴儿配方
  glyphicon glyphicon-tent	帐篷
  glyphicon glyphicon-blackboard	黑板
  glyphicon glyphicon-bed	床
  glyphicon glyphicon-apple	苹果
  glyphicon glyphicon-erase	擦除
  glyphicon glyphicon-hourglass	沙漏
  glyphicon glyphicon-lamp	灯
  glyphicon glyphicon-duplicate	复制
  glyphicon glyphicon-piggy-bank	储蓄罐
  glyphicon glyphicon-scissors	剪刀
  glyphicon glyphicon-bitcoin	比特币
  glyphicon glyphicon-btc	比特币
  glyphicon glyphicon-xbt	比特币
  glyphicon glyphicon-yen	日元
  glyphicon glyphicon-jpy	日元
  glyphicon glyphicon-ruble	卢布
  glyphicon glyphicon-rub	卢布
  glyphicon glyphicon-scale	仪表
  glyphicon glyphicon-ice-lolly	冰棍
  glyphicon glyphicon-ice-lolly-tasted	雪糕口味
  glyphicon glyphicon-education	教育
  glyphicon glyphicon-option-horizontal	水平
  glyphicon glyphicon-option-vertical	垂直
  glyphicon glyphicon-menu-hamburger	菜单
  glyphicon glyphicon-modal-window	模态窗口
  glyphicon glyphicon-oil	油
  glyphicon glyphicon-grain	粮食
  glyphicon glyphicon-sunglasses	太阳镜
  glyphicon glyphicon-text-size	文本大小
  glyphicon glyphicon-text-color	文本颜色
  glyphicon glyphicon-text-background	文本背景
  glyphicon glyphicon-object-align-top	向上对齐
  glyphicon glyphicon-object-align-bottom	向下对齐
  glyphicon glyphicon-object-align-horizontal	水平对齐
  glyphicon glyphicon-object-align-left	左对齐
  glyphicon glyphicon-object-align-vertical	垂直对齐
  glyphicon glyphicon-object-align-right	右对齐
  glyphicon glyphicon-triangle-right	三角右
  glyphicon glyphicon-triangle-left	三角左
  glyphicon glyphicon-triangle-bottom	三角下
  glyphicon glyphicon-triangle-top	三角上
  glyphicon glyphicon-console	控制台
  glyphicon glyphicon-superscript	上标
  glyphicon glyphicon-subscript	下标
  glyphicon glyphicon-menu-left	左菜单
  glyphicon glyphicon-menu-right	右菜单
  glyphicon glyphicon-menu-down	下菜单
  glyphicon glyphicon-menu-up	上菜单
  ```

#### 下拉菜单

- 下拉菜单

  ```
  <div class="dropdown">
  ```

  下拉按钮，id用来给下拉菜单指向用的

  ```
  <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
  ```

  菜单列表，aria-labelledby="dropdownMenu1" 就是用来指向哪个菜单(**供视觉障碍者使用**)，因为有可能有多个菜单

  ```
  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
  ```

  菜单项

  ```
  <li><a href="#">HTML</a></li> 
  ```

  ```
  <div class="dropdown">
      <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
        http://192.168.1.189
        <span class="caret"></span>         
      </button>
       
      <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
        <li>
           <a href="#">HTML</a>            
        </li>
        <li role="presentation">
           <a href="#">CSS</a>             
        </li>
   
        <li role="presentation">
           <a href="#">Javascript</a>          
        </li>
        <li role="presentation">
           <a href="#">AJAX</a>            
        </li>
      </ul>
  </div>   
  ```

- 标题不可点击

  ```
  <li role="presentation" class="dropdown-header">Dropdown header</li>
  ```

- 菜单分割线

  ```
  <li role="presentation" class="divider"></li>
  ```

- 禁用项

  ```
  <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Bootstrap(开发中)</a></li>
  ```

**注：aria-labelledby、role都是供视觉障碍者使用**

#### 按钮组

- 按钮组

  ```
  <div class="btn-group" role="group" aria-label="web">
    <button type="button" class="btn btn-default">Html</button>
    <button type="button" class="btn btn-default">Css</button>
    <button type="button" class="btn btn-default">JS</button>
  </div>
  ```

- 按钮工具栏

  ```
  <div class="btn-toolbar" role="toolbar" aria-label="study">
  <div class="btn-group" role="group" aria-label="java">
    <button type="button" class="btn btn-default">基础</button>
    <button type="button" class="btn btn-default">中级</button>
    <button type="button" class="btn btn-default">高级</button>
  </div>
   
  <div class="btn-group" role="group" aria-label="web">
    <button type="button" class="btn btn-default">Html</button>
    <button type="button" class="btn btn-default">Css</button>
    <button type="button" class="btn btn-default">JS</button>
  </div>
   
  <div class="btn-group" role="group" aria-label="framework">
    <button type="button" class="btn btn-default">Hiber</button>
    <button type="button" class="btn btn-default">Struts</button>
    <button type="button" class="btn btn-default">Spring</button>
  </div>
  </div>
  ```

- 按钮组大小

  btn-group-lg、btn-group、btn-group-sm、btn-group-xs

  ```
  <div class="btn-group btn-group-lg" role="group" aria-label="web">
    <button type="button" class="btn btn-default">Html</button>
    <button type="button" class="btn btn-default">Css</button>
    <button type="button" class="btn btn-default">JS</button>
  </div>
  ```

- 垂直排列的按钮组

  ```
  <div class="btn-group-vertical" role="group" aria-label="web">
    <button type="button" class="btn btn-default">Html</button>
    <button type="button" class="btn btn-default">Css</button>
    <button type="button" class="btn btn-default">JS</button>
  </div>
  ```

- 复选框

  ```
  <div class="btn-group" data-toggle="buttons">
    <label class="btn btn-default active">
      <input type="checkbox" checked>LOL(默认选中)
    </label>
    <label class="btn btn-default">
      <input type="checkbox" > DOTA
    </label>
    <label class="btn btn-default">
      <input type="checkbox" > WOW
    </label>
  </div>
  ```

- 单选框

  ```
  <div class="btn-group" data-toggle="buttons">
    <label class="btn btn-default active">
      <input type="radio" checked>LOL(默认选中)
    </label>
    <label class="btn btn-default">
      <input type="radio" > DOTA
    </label>
    <label class="btn btn-default">
      <input type="radio" > WOW
    </label>
  </div>
  ```

#### 按钮式下拉菜单

- 单按钮下拉菜单

  ```
  <div class="btn-group">
      <button type="button" class="btn btn-default dropdown-toggle "  data-toggle="dropdown">
       default
        <span class="caret"></span>         
      </button>
        
      <ul class="dropdown-menu" role="menu">
        <li>
           <a href="#">HTML</a>            
        </li>
        <li role="presentation">
           <a href="#">CSS</a>             
        </li>
    
        <li role="presentation">
           <a href="#">Javascript</a>          
        </li>
        <li role="presentation">
           <a href="#">AJAX</a>            
        </li>
      </ul>
  </div>   
  ```

- 分裂式按钮下拉菜单

  ```
  <div class="btn-group">
     <button type="button" class="btn btn-default">默认</button>
     <button type="button" class="btn btn-default dropdown-toggle"
        data-toggle="dropdown">
        <span class="caret"></span>
   
     </button>
     <ul class="dropdown-menu" role="menu">
       <li>
           <a href="#">HTML</a>            
        </li>
        <li role="presentation">
           <a href="#">CSS</a>             
        </li>
    
        <li role="presentation">
           <a href="#">Javascript</a>          
        </li>
        <li role="presentation">
           <a href="#">AJAX</a>            
        </li>
     </ul>
  </div>
  ```

- 按钮大小

  btn-lg、btn、btn-sm、btn-xs

  ```
  <div class="btn-group">
      <button type="button" class="btn btn-lg btn-default dropdown-toggle " data-toggle="dropdown">
       大号
        <span class="caret"></span>         
      </button>
         
      <ul class="dropdown-menu" role="menu">
        <li>
           <a href="#">HTML</a>            
        </li>
        <li role="presentation">
           <a href="#">CSS</a>             
        </li>
     
        <li role="presentation">
           <a href="#">Javascript</a>          
        </li>
        <li role="presentation">
           <a href="#">AJAX</a>            
        </li>
      </ul>
  </div>   
  ```

- 向上弹出式菜单

  ```
  <div class="btn-group dropup">
      <button type="button" class="btn btn-default dropdown-toggle " id="dropdownMenu1" data-toggle="dropdown">
       default
        <span class="caret"></span>         
      </button>
         
      <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
        <li>
           <a href="#">HTML</a>            
        </li>
        <li role="presentation">
           <a href="#">CSS</a>             
        </li>
     
        <li role="presentation">
           <a href="#">Javascript</a>          
        </li>
        <li role="presentation">
           <a href="#">AJAX</a>            
        </li>
      </ul>
  </div>   
  ```

#### 输入框组

- 基本组合

  ```
  <div class="input-group">
    <span class="input-group-addon" id="basic-addon1">@</span>
    <input type="text" class="form-control" placeholder="用户名" aria-describedby="basic-addon1">
  </div>
   
  <div class="input-group">
    <input type="text" class="form-control" placeholder="邮箱" aria-describedby="basic-addon2">
    <span class="input-group-addon" id="basic-addon2">@12306.com</span>
  </div>
   
  <div class="input-group">
    <span class="input-group-addon">$</span>
    <input type="text" class="form-control"  placeholder="金额" aria-label="Amount (to the nearest dollar)">
    <span class="input-group-addon">.00</span>
  </div>
  ```

- 尺寸

  ```
  <div class="input-group input-group-lg">
    <span class="input-group-addon" id="basic-addon1">@</span>
    <input type="text" class="form-control" placeholder="用户名" aria-describedby="basic-addon1">
  </div>
  <div class="input-group input-group">
    <span class="input-group-addon" id="basic-addon1">@</span>
    <input type="text" class="form-control" placeholder="用户名" aria-describedby="basic-addon1">
  </div>
  <div class="input-group input-group-sm">
    <span class="input-group-addon" id="basic-addon1">@</span>
    <input type="text" class="form-control" placeholder="用户名" aria-describedby="basic-addon1">
  </div>
  ```

- 复选框和单选框

  ```
  <div class="input-group">
        <span class="input-group-addon">
          <input type="checkbox" >
        </span>
        <input type="text" class="form-control" >
  </div>
  <div class="input-group">
        <span class="input-group-addon">
          <input type="radio" >
        </span>
        <input type="text" class="form-control" >
  </div>
  ```

- 整合按钮

  ```
  <div class="input-group">
        <span class="input-group-btn">
          <button class="btn btn-default" type="button">搜索</button>
        </span>
        <input type="text" class="form-control" placeholder="Search for...">
      </div>
   
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search for...">
        <span class="input-group-btn">
          <button class="btn btn-default" type="button">搜索</button>
        </span>
      </div>
  ```

- 整合下拉菜单

  ```
   <div class="input-group">
        <div class="input-group-btn">
          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">搜索<span class="caret"></span></button>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Google</a></li>
            <li><a href="#">百度</a></li>
            <li><a href="#">搜狗</a></li>
            <li class="divider"></li>
            <li><a href="#">人民搜索</a></li>
          </ul>
        </div>
        <input type="text" class="form-control" aria-label="...">
      </div>
   
      <div class="input-group">
        <input type="text" class="form-control" aria-label="...">
        <div class="input-group-btn">
          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">搜索<span class="caret"></span></button>
          <ul class="dropdown-menu dropdown-menu-right" role="menu">
            <li><a href="#">Google</a></li>
            <li><a href="#">百度</a></li>
            <li><a href="#">搜狗</a></li>
            <li class="divider"></li>
            <li><a href="#">人民搜索</a></li>
          </ul>
        </div>
      </div>
  ```

- 整合分裂式下拉菜单

  ```
  <div class="input-group">
    <input type="text" class="form-control" aria-label="...">
    <div class="input-group-btn">
  <button type="button" class="btn btn-default">提交</button>
     <button type="button" class="btn btn-default dropdown-toggle"
        data-toggle="dropdown">
        <span class="caret"></span>
   
     </button>
     <ul class="dropdown-menu dropdown-menu-right" role="menu">
       <li>
           <a href="#">HTML</a>             
        </li>
        <li role="presentation">
           <a href="#">CSS</a>              
        </li>
    
        <li role="presentation">
           <a href="#">Javascript</a>           
        </li>
        <li role="presentation">
           <a href="#">AJAX</a>             
        </li>
     </ul>
    </div>
  </div>
  ```

#### 导航栏

- 标签页

  ```
  <ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href="#">Java</a></li>
    <li role="presentation"><a href="#">IOS</a></li>
    <li role="presentation"><a href="#">Android</a></li>
  </ul>
  ```

- 胶囊式标签页

  ```
  <ul class="nav nav-pills">
    <li role="presentation" class="active"><a href="#">Java</a></li>
    <li role="presentation"><a href="#">IOS</a></li>
    <li role="presentation"><a href="#">Android</a></li>
  </ul>
  ```

- 垂直胶囊式标签页

  ```
  <ul class="nav nav-pills nav-stacked" style="width:100px">
    <li role="presentation" class="active"><a href="#">Java</a></li>
    <li role="presentation"><a href="#">IOS</a></li>
    <li role="presentation"><a href="#">Android</a></li>
  </ul>
  ```

- 禁用的链接

  ```
  <ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href="#">Java</a></li>
    <li role="presentation"><a href="#">IOS</a></li>
    <li role="presentation" ><a href="#">Android</a></li>
    <li role="presentation" class="disabled" ><a href="#">TokyoHot</a></li>
  </ul>
  ```

#### 面包屑导航

- 面包屑导航

  ```
  <ol class="breadcrumb">
    <li><a href="#">前端技术</a></li>
    <li><a href="#">BootStrap </a></li>
    <li class="active">BootStrap 面包屑导航 </li>
  </ol>
  ```

#### 分页

- 基本分页

  ```
  <nav>
    <ul class="pagination">
      <li>
        <a href="#" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
      <li><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li><a href="#">5</a></li>
      <li>
        <a href="#" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
  </nav>
  ```

- 禁用和激活状态

  最后一页不可点

  ```
  <nav>
    <ul class="pagination">
      <li>
        <a href="#" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
      <li><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li><a href="#">5</a></li>
      <li class="disabled">
        <a href="#" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
  </nav>
  ```

- 尺寸

  pagination-lg、 pagination-sm

  ```
  <nav>
    <ul class="pagination pagination-lg">
      <li>
        <a href="#" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
      <li><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li><a href="#">5</a></li>
      <li>
        <a href="#" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
  </nav>
  ```

- 翻页

  ```
  <nav>
    <ul class="pager">
      <li><a href="#">上一页</a></li>
      <li><a href="#">下一页</a></li>
    </ul>
  </nav>
  ```

- 两端对齐

  ```
  <nav>
    <ul class="pager">
      <li class="previous"><a href="#"><span aria-hidden="true">&larr;</span> 上一页</a></li>
      <li class="next"><a href="#">下一页 <span aria-hidden="true">&rarr;</span></a></li>
    </ul>
  </nav>
  ```

- 翻页禁用状态

  ```
  <nav>
    <ul class="pager">
      <li class="disabled"><a href="#">上一页</a></li>
      <li><a href="#">下一页</a></li>
    </ul>
  </nav>
  ```

#### 标签

- 默认标签

  ```
  <span class="label label-default">默认</span>
  ```

- 强调标签

  ```
  <span class="label label-primary">强调</span>
  ```

- 成功标签

  ```
  <span class="label label-success">成功</span>
  ```

- 信息标签

  ```
  <span class="label label-info">信息</span>
  ```

- 警告标签

  ```
  <span class="label label-warning">警告</span>
  ```

- 危险标签

  ```
  <span class="label label-danger">危险</span>
  ```

#### 徽章

- 超链旁的徽记

  ```
  <a href="#">新的消息<span class="badge">42</span></a>
  ```

- 按钮中的徽记

  ```
  <button class="btn btn-primary" type="button">
    未读消息<span class="badge">4</span>
  </button>
  ```

#### 超大屏幕

- 例子

  ```
  <div class="jumbotron">
    <div class="container" align="center">
        <h2 class="text-info" style="font-family:宋体;font-weight:bold;font-size:49px">逼乎</h2>
        <br>
        <div class="text-muted">与世界分享你的逼格</div>
        <br>
        <br>
        <p><a role="button" href="#" class="btn btn-success">注册</a></p>
    </div>
  </div>
  ```

#### 副标题

- 副标题

  ```
  <div class="page-header">
    <h1>正标题<small>副标题</small></h1>
  </div>
  ```

#### 缩略图

- 相册风格

  ```
  <div class="container">
  <div class="row">
    <div class="col-xs-3 ">
      <a href="#" class="thumbnail">
        <img src="http://how2j.cn/study/gareen.jpg">
      </a>
    </div>
    <div class="col-xs-3 ">
      <a href="#" class="thumbnail">
        <img src="http://how2j.cn/study/annie.jpg">
      </a>
    </div>
    <div class="col-xs-3 ">
      <a href="#" class="thumbnail">
        <img src="http://how2j.cn/study/teemo.jpg">
      </a>
    </div>
    <div class="col-xs-3 ">
      <a href="#" class="thumbnail">
        <img src="http://how2j.cn/study/katarina.jpg">
      </a>
    </div>
  </div>
  </div>
  ```

- 自定义内容

  ```
  <div class="container">
  <div class="row">
    <div class="col-xs-3 " >
      <a href="#" class="thumbnail">
        <img src="http://how2j.cn/study/gareen.jpg">
      </a>
  <div class="caption">
          <div class="text-muted">德玛西亚之力</div>
          <br>
          <p><a href="#" class="btn btn-primary" role="button">选中</a></p>
        </div>
    </div>
    <div class="col-xs-3 ">
      <a href="#" class="thumbnail">
        <img src="http://how2j.cn/study/annie.jpg">
      </a>
  <div class="caption">
  <div class="text-muted">黑暗之力</div>
  <br>
  <a href="#" class="btn btn-primary" role="button">选中</a></p>
      </div>
    </div>
    <div class="col-xs-3 ">
      <a href="#" class="thumbnail">
        <img src="http://how2j.cn/study/teemo.jpg">
      </a>
  <div class="caption">
  <div class="text-muted">迅捷斥候</div>
  <br>
  <a href="#" class="btn btn-primary" role="button">选中</a></p>
      </div>
    </div>
    <div class="col-xs-3 ">
      <a href="#" class="thumbnail">
        <img src="http://how2j.cn/study/katarina.jpg">
      </a>
  <div class="caption">
  <div class="text-muted">不详之刃</div>
  <br>
  <a href="#" class="btn btn-primary" role="button">选中</a></p>
      </div>
    </div>
  </div>
  </div>
  ```

#### 警告

- 警告框

  ```
  <div class="alert alert-success" role="alert">操作成功</div>
  <div class="alert alert-info" role="alert">信息提示</div>
  <div class="alert alert-warning" role="alert">警告提示</div>
  <div class="alert alert-danger" role="alert">危险提示</div>
  ```

- 可关闭的警告框

  ```
  <div class="alert alert-warning alert-dismissible" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    警告提示
  </div>
  ```

- 警告框中的链接

  ```
  <div class="alert alert-success" role="alert">
    <span>大减价！！！</span><a href="#nowhere" class="alert-link">点击购买</a>
  </div>
  <div class="alert alert-info" role="alert">
    <span>大减价！！！</span><a href="#nowhere" class="alert-link">点击购买</a>
  </div>
  <div class="alert alert-warning" role="alert">
    <span>大减价！！！</span><a href="#nowhere" class="alert-link">点击购买</a>
  </div>
  <div class="alert alert-danger" role="alert">
    <span>大减价！！！</span><a href="#nowhere" class="alert-link">点击购买</a>
  </div>
  ```

#### 进度条

- 基本进度条

  ```
  <div class="progress">
    <div class="progress-bar" style="width: 60%;">
    </div>
  </div>
  ```

- 带有提示的进度条

  ```
  <div class="progress">
    <div class="progress-bar" style="width: 60%; min-width: 2em;" >
      60%
    </div>
  </div>
  <div class="progress">
    <div class="progress-bar" style="width: 0%; min-width: 2em;" >
      0%
    </div>
  </div>
  ```

- 不同颜色的进度条

  ```
  <div class="progress">
    <div class="progress-bar progress-bar-success"  style="width: 40%">
      40%
    </div>
  </div>
  <div class="progress">
    <div class="progress-bar progress-bar-info"   style="width: 20%">
      20%
    </div>
  </div>
  <div class="progress">
    <div class="progress-bar progress-bar-warning"   style="width: 60%">
      60%
    </div>
  </div>
  <div class="progress">
    <div class="progress-bar progress-bar-danger"   style="width: 80%">
      80%
    </div>
  </div>
  ```

- 条纹

  ```
  <div class="progress">
    <div class="progress-bar progress-bar-success progress-bar-striped"  style="width: 40%">
      40%
    </div>
  </div>
  ```

- 发廊

  ```
  <div class="progress">
    <div class="progress-bar progress-bar-striped active" style="width: 45%">
      45%
    </div>
  </div>
  ```

- 堆叠

  ```
  <div class="progress">
    <div class="progress-bar progress-bar-success" style="width: 35%">
   
    </div>
    <div class="progress-bar progress-bar-warning progress-bar-striped" style="width: 20%">
   
    </div>
    <div class="progress-bar progress-bar-danger" style="width: 10%">
   
    </div>
  </div>
  ```

#### 列表组

- 基本列表组

  ```
  <ul class="list-group">
    <li class="list-group-item">回锅肉</li>
    <li class="list-group-item">烧烤</li>
    <li class="list-group-item">鱼香肉丝</li>
    <li class="list-group-item">麻婆豆腐</li>
    <li class="list-group-item">夫妻肺片</li>
  </ul>
  ```

- 徽记

  ```
  <ul class="list-group">
    <li class="list-group-item"><span class="badge">3</span>回锅肉</li>
    <li class="list-group-item"><span class="badge">14</span>烧烤</li>
    <li class="list-group-item"><span class="badge">15</span>鱼香肉丝</li>
    <li class="list-group-item"><span class="badge">92</span>麻婆豆腐</li>
    <li class="list-group-item"><span class="badge">6</span>夫妻肺片</li>
  </ul>
  ```

- 链接

  ```
  <div class="list-group">
    <a href="#" class="list-group-item active">
      回锅肉
    </a>
    <a href="#" class="list-group-item">烧烤</a>
    <a href="#" class="list-group-item">鱼香肉丝</a>
    <a href="#" class="list-group-item">麻婆豆腐</a>
    <a href="#" class="list-group-item">夫妻肺片</a>
  </div>
  ```

- 按钮

  ```
  <div class="list-group">
    <button type="button" class="list-group-item active">
      回锅肉
    </button>
    <button type="button" class="list-group-item">烧烤</button>
    <button type="button" class="list-group-item">鱼香肉丝</button>
    <button type="button" class="list-group-item">麻婆豆腐</button>
    <button type="button" class="list-group-item">夫妻肺片</button>
  </div>
  ```

- 颜色

  ```
  <div class="list-group">
    <a href="#" class="list-group-item active">
      回锅肉
    </a>
    <a href="#" class="list-group-item list-group-item-success">烧烤</a>
    <a href="#" class="list-group-item list-group-item-info">鱼香肉丝</a>
    <a href="#" class="list-group-item list-group-item-warning">麻婆豆腐</a>
    <a href="#" class="list-group-item list-group-item-danger">夫妻肺片</a>
  </div>
  ```

#### 面板

- 基本面板

  ```
  <div class="panel panel-default">
    <div class="panel-body">
      面板内容
    </div>
  </div>
  ```

- 面板标题

  ```
  <div class="panel panel-default">
    <div class="panel-heading">面板标题</div>
    <div class="panel-body">
      面板内容
    </div>
  </div>
  ```

- 面板脚注

  ```
  <div class="panel panel-default">
    <div class="panel-body">
      面板内容
    </div>
    <div class="panel-footer">面板脚注</div>
  </div>
  ```

- 面板颜色

  ```
  <div class="panel panel-default">
    <div class="panel-heading">面板标题</div>
    <div class="panel-body">
      面板内容
    </div>
  </div>
  <div class="panel panel-success">
    <div class="panel-heading">面板标题</div>
    <div class="panel-body">
      面板内容
    </div>
  </div>
  <div class="panel panel-info">
    <div class="panel-heading">面板标题</div>
    <div class="panel-body">
      面板内容
    </div>
  </div>
  <div class="panel panel-warning">
    <div class="panel-heading">面板标题</div>
    <div class="panel-body">
      面板内容
    </div>
  </div>
  <div class="panel panel-danger">
    <div class="panel-heading">面板标题</div>
    <div class="panel-body">
      面板内容
    </div>
  </div>
  ```

#### 嵌入效果

- 嵌入效果

  ```
  <div class="well">文字呈现嵌入效果</div>
  ```

#### 顶部底部

- 贴在顶部(不会消失）

  贴在顶部,如果内容比较多，需要下拉滚动才可以看到的时候，会继续保持帖在顶部的状态。
  使用的时候需要加上样式:

  ```
  body{
     padding-top:70px;
  }
  ```

  完整代码：

  ```
  <style>
    body{
      padding-top:70px;
    }
  </style>
  <nav class="navbar navbar-default navbar-fixed-top">
    <button class="btn btn-info">菜单1</button>
    <button class="btn btn-success">菜单2</button>
    <button class="btn btn-danger">菜单3</button>
  </nav>
   
  <div style="white-space:pre">
    很多内容 ，下拉才看得见，下拉时，置顶菜单不消失
    很多内容 ，下拉才看得见，下拉时，置顶菜单不消失
    很多内容 ，下拉才看得见，下拉时，置顶菜单不消失
    很多内容 ，下拉才看得见，下拉时，置顶菜单不消失
  </div>
  ```

- 贴在顶部(会消失)
  **不需要样式**

  ```
  body{
    /* padding-top:70px;*/
  }
  ```

  完整代码：

  ```
  <style>
    body{
      padding-bottom:70px;
    }
  </style>
  <nav class="navbar navbar-default navbar-static-top">
    <button class="btn btn-info">菜单1</button>
    <button class="btn btn-success">菜单2</button>
    <button class="btn btn-danger">菜单3</button>
  </nav>
   
  <div style="white-space:pre">
    很多内容 ，下拉才看得见，下拉时，置顶菜单会消失
    很多内容 ，下拉才看得见，下拉时，置顶菜单会消失
    很多内容 ，下拉才看得见，下拉时，置顶菜单会消失
    很多内容 ，下拉才看得见，下拉时，置顶菜单会消失
    很多内容 ，下拉才看得见，下拉时，置顶菜单会消失
    很多内容 ，下拉才看得见，下拉时，置顶菜单会消失
    很多内容 ，下拉才看得见，下拉时，置顶菜单会消失
  </div>
  ```

- 贴在底部 (不会消失)

  贴在底部
  需要加上如下样式： 

  ```
  body{
      padding-bottom:70px;
  }
  ```

  完整代码：

  ```
  <style>
    body{
      padding-bottom:70px;
    }
  </style>
   
  <div style="white-space:pre">
   拉动内容时，置底版权信息位置不变
   拉动内容时，置底版权信息位置不变
   拉动内容时，置底版权信息位置不变
   拉动内容时，置底版权信息位置不变
   
  </div>
   
  <nav class="navbar navbar-default navbar-fixed-bottom">
  <div style="text-align:center">
   版权所有
  </div>
  </nav>
  ```

### 插件

#### 模态窗体

- 静态模态窗口

  ```
  <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title">提问</h4>
            </div>
            <div class="modal-body">
              <p>问题描述</p>
              <textarea class="form-control"></textarea>
            </div>
            <div class="modal-footer">
              <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
              <button class="btn btn-primary" type="button">提交</button>
            </div>
          </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
  ```

- 点击弹出

  ```
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
   提问（点击弹出模态窗口）
  </button>
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title">提问</h4>
            </div>
            <div class="modal-body">
              <p>问题描述</p>
              <textarea class="form-control"></textarea>
            </div>
            <div class="modal-footer">
              <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
              <button class="btn btn-primary" type="button">提交</button>
            </div>
          </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
  </div>
  ```

- 不要动画效果

  ```
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
   提问（点击弹出模态窗口）
  </button>
  <div class="modal " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title">提问</h4>
            </div>
            <div class="modal-body">
              <p>问题描述</p>
              <textarea class="form-control"></textarea>
            </div>
            <div class="modal-footer">
              <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
              <button class="btn btn-primary" type="button">提交</button>
            </div>
          </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
  </div>
  ```

- 点击空白不会收起

  ```
  <div class="modal fade" id="myModal"  data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title">提问</h4>
            </div>
            <div class="modal-body">
              <p>问题描述</p>
              <textarea class="form-control"></textarea>
            </div>
            <div class="modal-footer">
              <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
              <button class="btn btn-primary" type="button">提交</button>
            </div>
          </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
  </div>
  ```

- 使用JS控制模态窗口

  ```
  <script>
  $(function(){
     $("#open").click(function(){
        $("#myModal").modal('show');
     });
     $("#submit").click(function(){
        alert("信息已经提交");
        $("#myModal").modal('hide');
     });
     $("#toggle").click(function(){
        $("#myModal").modal('toggle');
     });
  });
  </script>
   
  <button  class="btn btn-default" id="open"> 打开模态窗口</button>
  <button class="btn btn-default"  id="close"> 关闭模态窗口</button>
  <button class="btn btn-default"  id="toggle"> 切换模态窗口</button>
   
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title">提问</h4>
            </div>
            <div class="modal-body">
              <p>问题描述</p>
              <textarea class="form-control"></textarea>
            </div>
            <div class="modal-footer">
              <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
              <button class="btn btn-primary" id="submit" type="button">提交</button>
            </div>
          </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
  </div>
  ```

- 监听模态的变化

  ```
  <script>
  $(function(){
      $("#myModal").on("show.bs.modal",function(){
        alert("开始显示模态窗口");
      });
      $("#myModal").on("shown.bs.modal",function(){
        alert("显示模态窗口完毕");
      });
      $("#myModal").on("hide.bs.modal",function(){
        alert("开始隐藏模态窗口");
      });
      $("#myModal").on("hidden.bs.modal",function(){
        alert("隐藏模态窗口完毕");
      });
  });
  </script>
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
   提问（点击弹出模态窗口）
  </button>
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title">提问</h4>
            </div>
            <div class="modal-body">
              <p>问题描述</p>
              <textarea class="form-control"></textarea>
            </div>
            <div class="modal-footer">
              <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
              <button class="btn btn-primary" type="button">提交</button>
            </div>
          </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
  </div>
  ```

#### 可切换导航栏

- 可切换导航栏

  ```
  <style>
  p{
   
    margin-left:10px;
    margin-top:10px;
  }
  </style>
  <ul id="myTab" class="nav nav-tabs">
     <li class="active">
        <a href="#dota" data-toggle="tab">
           DotA
        </a>
     </li>
     <li><a href="#lol" data-toggle="tab">英雄联盟</a></li>
     <li class="dropdown">
        <a href="#" id="myTabDrop1" class="dropdown-toggle"
           data-toggle="dropdown">其他类似游戏
           <b class="caret"></b>
        </a>
        <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
           <li><a href="#storm" tabindex="-1" data-toggle="tab">风暴英雄</a></li>
           <li><a href="#h300" tabindex="-1" data-toggle="tab">300英雄</a></li>
        </ul>
     </li>
  </ul>
  <div id="myTabContent" class="tab-content">
     <div class="tab-pane fade in active" id="dota">
        <p>《DotA》（Defense of the Ancients），可以译作守护古树、守护遗迹、远古遗迹守卫， 是由暴雪公司出品即时战略游戏《魔兽争霸3》的一款多人即时对战、自定义地图，可支持10个人同时连线游戏，是暴雪公司官方认可的魔兽争霸的RPG地图。</p>
     </div>
     <div class="tab-pane fade" id="lol">
        <p>《英雄联盟》（简称lol）是由美国Riot Games开发，中国大陆地区由腾讯游戏运营的网络游戏。</p>
     </div>
     <div class="tab-pane fade" id="storm">
        <p>
        《风暴英雄》 是由暴雪娱乐公司开发的一款运行在Windows和Mac OS上的在线多人竞技PC游戏。</p>
         <p> 游戏中的英雄角色主要来自于暴雪三大经典游戏系列：《魔兽世界》、《暗黑破坏神》和《星际争霸》。它是一款道具收费的游戏，与《星际争霸Ⅱ》基于同一引擎开发。
        </p>
     </div>
     <div class="tab-pane fade" id="h300">
        <p>《300英雄》是由上海跳跃网络科技有限公司自主研发，深圳中青宝互动网络股份有限公司运营的一款类DOTA网游。游戏以7v7组队对抗玩法为主，提供永恒战场和永恒竞技场两种经典模式任由玩家选择，并创新性地加入勇者斗恶龙、克隆战争等多种休闲娱乐玩法。
        </p>
     </div>
  </div>
  ```

#### 提示工具

- 非Bootstrap工具提示

  ```
  <button class="btn btn-default" title="提示信息">非Bootstrap工具提示</button>
  ```

- 左侧提示

  ```
  <button style="margin-left:100px" type="button" class="btn btn-default" data-toggle="tooltip" data-placement="left" title="提示信息">鼠标悬停</button>
   
  <script>
     $(function () { $("[data-toggle='tooltip']").tooltip(); });
  </script>
  ```

- 右侧提示

  ```
  <button style="margin-right:100px" type="button" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="提示信息">鼠标悬停</button>
  ```

- 上方提示

  ```
  <button style="margin-top:50px" type="button" class="btn btn-default" data-toggle="tooltip" data-placement="top" title="提示信息">鼠标悬停</button>
  ```

- 下方提示

  ```
  <button style="margin-bottom:50px" type="button" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="提示信息">鼠标悬停</button>
  ```

#### 折叠

- 基本折叠

  ```
  <style>
  div.well{
    margin:10px;
  }
  </style>
  <a class="btn btn-info" role="button" data-toggle="collapse" href="#dota" aria-expanded="false" aria-controls="collapseExample">
    DotA
  </a>
  <button class="btn btn-info" type="button" data-toggle="collapse" data-target="#lol" aria-expanded="false" aria-controls="collapseExample">
    LOL
  </button>
  <div class="collapse" id="dota">
    <div class="well">
  《DotA》（Defense of the Ancients），可以译作守护古树、守护遗迹、远古遗迹守卫， 是由暴雪公司出品即时战略游戏《魔兽争霸3》的一款多人即时对战、自定义地图，可支持10个人同时连线游戏，是暴雪公司官方认可的魔兽争霸的RPG地图。
    </div>
  </div>
   
  <div class="collapse" id="lol">
    <div class="well">
  《英雄联盟》（简称lol）是由美国Riot Games开发，中国大陆地区由腾讯游戏运营的网络游戏。
    </div>
  </div>
  ```

- 面板折叠

  ```
  <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
    <div class="panel panel-default">
      <div class="panel-heading" role="tab" id="headingOne">
        <h4 class="panel-title">
          <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
            DOTA
          </a>
        </h4>
      </div>
      <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
        <div class="panel-body">
         《DotA》（Defense of the Ancients），可以译作守护古树、守护遗迹、远古遗迹守卫， 是由暴雪公司出品即时战略游戏《魔兽争霸3》的一款多人即时对战、自定义地图，可支持10个人同时连线游戏，是暴雪公司官方认可的魔兽争霸的RPG地图。
        </div>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading" role="tab" id="headingTwo">
        <h4 class="panel-title">
          <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
            LOL
          </a>
        </h4>
      </div>
      <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
        <div class="panel-body">
  《英雄联盟》（简称lol）是由美国Riot Games开发，中国大陆地区由腾讯游戏运营的网络游戏。
        </div>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading" role="tab" id="headingThree">
        <h4 class="panel-title">
          <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
            风暴英雄
          </a>
        </h4>
      </div>
      <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
        <div class="panel-body">
         《风暴英雄》 是由暴雪娱乐公司开发的一款运行在Windows和Mac OS上的在线多人竞技PC游戏。
        </div>
      </div>
    </div>
  </div>
  ```

#### 轮播

- 基本轮播

  ```
  <style>
    div.item img{
      width:100%;
     }
    div#carousel-example-generic{
      width:80%;
      margin:0 auto;
    }
  </style>
  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
      <li data-target="#carousel-example-generic" data-slide-to="2"></li>
      <li data-target="#carousel-example-generic" data-slide-to="3"></li>
    </ol>
   
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="http://how2j.cn/img/site/step/3491.png" >
      </div>
      <div class="item">
              <img src="http://how2j.cn/img/site/step/3492.png" >
      </div>
      <div class="item">
              <img src="http://how2j.cn/img/site/step/3493.png" >
      </div>
   
      <div class="item">
              <img src="http://how2j.cn/img/site/step/3494.png" >
      </div>
   
    </div>
  </div>
  ```

- 带标题的轮播

  ```
  <style>
    div.item img{
      width:100%;
     }
    div#carousel-example-generic{
      width:80%;
      margin:0 auto;
    }
  </style>
  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
      <li data-target="#carousel-example-generic" data-slide-to="2"></li>
      <li data-target="#carousel-example-generic" data-slide-to="3"></li>
    </ol>
   
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="http://how2j.cn/img/site/step/3491.png" >
        <div class="carousel-caption">
          LOL1
        </div>
      </div>
      <div class="item">
              <img src="http://how2j.cn/img/site/step/3492.png" >
        <div class="carousel-caption">
          LOL2
        </div>
      </div>
      <div class="item">
              <img src="http://how2j.cn/img/site/step/3493.png" >
        <div class="carousel-caption">
          LOL3
        </div>
      </div>
   
      <div class="item">
              <img src="http://how2j.cn/img/site/step/3494.png" >
        <div class="carousel-caption">
          LOL4
        </div>
      </div>
   
    </div>
   
  </div>
  ```

- 设置轮播速度

  ```
  <style>
    div.item img{
      width:100%;
     }
    div#carousel-example-generic{
      width:80%;
      margin:0 auto;
    }
  </style>
  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="1000">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
      <li data-target="#carousel-example-generic" data-slide-to="2"></li>
      <li data-target="#carousel-example-generic" data-slide-to="3"></li>
    </ol>
   
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="http://how2j.cn/img/site/step/3491.png" >
      </div>
      <div class="item">
              <img src="http://how2j.cn/img/site/step/3492.png" >
      </div>
      <div class="item">
              <img src="http://how2j.cn/img/site/step/3493.png" >
      </div>
   
      <div class="item">
              <img src="http://how2j.cn/img/site/step/3494.png" >
      </div>
   
    </div>
  </div>
  ```

- 控制前后的轮播

  ```
  <style>
    div.item img{
      width:100%;
     }
    div#carousel-example-generic{
      width:80%;
      margin:0 auto;
    }
  </style>
  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
      <li data-target="#carousel-example-generic" data-slide-to="2"></li>
      <li data-target="#carousel-example-generic" data-slide-to="3"></li>
    </ol>
   
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="http://how2j.cn/img/site/step/3491.png" >
      </div>
      <div class="item">
              <img src="http://how2j.cn/img/site/step/3492.png" >
      </div>
      <div class="item">
              <img src="http://how2j.cn/img/site/step/3493.png" >
      </div>
   
      <div class="item">
              <img src="http://how2j.cn/img/site/step/3494.png" >
      </div>
   
    </div>
   
    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
   
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
   
    </a>
   
  </div>
  ```