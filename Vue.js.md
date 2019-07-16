# Vue

#### 简介

- 什么是 Vue

  我们要把一个 json对象的数据，显示到一个元素上去。

  如果不使用 Vue, 那么就会用到 JS 或者 JQuery，通过操作 HTML DOM 的方式，把数据显示上去。

  如果使用Vue, 那么仅仅需要提供数据，以及数据要绑定到的元素的id,就行了,不需要显式地操作HTML DOM。

- JS 的方式

  1. 首先准备一个div元素，它其实就是视图
  2. 然后在js代码中准备一个json数据。
  3. 接着通过 原生的js 获取 div 对应的 html dom
  4. 最后把 json 数据赋给 html dom，就导致 div 里显示 英雄的名称了

  ```
  <div id="div1">
     
  </div>
    
  <script>
    
  //准备数据
  var gareen = {"name":"盖伦","hp":616};
   
  //获取 html dom
  var div1 = document.getElementById("div1");
   
  //显示数据
  div1.innerHTML= gareen.name;
    
  </script>
  ```

- js 方式的问题

  html dom其实只是手段，我们真正想要的，就是数据，显示在元素上。 

  而vue.js 就是用来解决这个问题的。

- Vue 的方式

  1. 首先导入 vue.js 要用到的库

  2. 同样准备一个div元素，其id是div1.

  3. 在js中准备json数据 gareen

  4. 创建一个Vue对象。 这个Vue对象就把数据 gareen和 视图 div1 关联起来了

     ```
     new Vue({
     	  el: '#div1',
     	  data: {
     	    message: gareen
     	  }
     })
     ```

  5. 在视图div中，就可以通过如下方式把数据取出来了。

     ```
     {{gareen.name}}
     ```

  ```
  <script src="http://how2j.cn/study/vue.min.js"></script>
   
  <div id="div1">
     
    {{gareen.name}}
   
  </div>
    
  <script>
    
  //准备数据
  var gareen = {"name":"盖伦","hp":616};
   
  //通过vue.js 把数据和对应的视图关联起来
  new Vue({
        el: '#div1',
        data: {
          message: gareen
        }
      })
    
  </script>
  ```

#### 监听事件

- v-on 监听事件

  ```
  <script src="vue.min.js"></script>
  <div id="div1">
    <div>一共点击了{{clickNumber}}次</div> 
    <button v-on:click="count">点击</button>
  </div>
  <script>
  	new Vue({
  		el: "#div1", 
  		data: {
  			clickNumber: 0
  		},
  		methods: {
  			count: function() {
  				this.clickNumber++;
  			}
  		}
  	});
  </script>
  ```

- v-on: 缩写为 @

  原来写法：

  ```
  <button v-on:click="count">点击</button>
  ```

  缩写之后：

  ```
  <button @click="count">点击</button>
  ```

- 事件修饰符

  vue.js 还提供了各种事件修饰符来方便开发者使用。

  ```
  .stop
  .prevent
  .capture
  .self
  .once
  ```

- 冒泡事件

  什么是冒泡？

  父元素里有 子元素， 如果点击了 子元素, 那么click 事件不仅会发生在子元素上，也会发生在其父元素上，依次不停地向父元素冒泡，直到document元素。

  ```
  <div id="content">
      <div id="grandFather"  v-on:click="doc">
          grandFather
          <div id="father" v-on:click="doc">
              father
              <div id="me" v-on:click="doc">
                  me
                  <div id="son" v-on:click="doc">
                  son
              </div>
              </div>
          </div>
      </div>
   
  </div>
     
  <script>
      var content = new Vue({
          el: "#content",
          data: {
              id: ''
          },
          methods: {
              doc: function () {
                  this.id= event.currentTarget.id;
                  alert(this.id)
              }
          }
      })
  </script>
  ```

- 阻止冒泡 .stop

  在me上的click后面加一个 .stop， 那么冒泡到了这里就结束了，就不会冒到father上面去了。

  ```
  <div id="me" v-on:click.stop="doc">
  ```

- 事件修饰符 优先触发 .capture

  在father 上增加一个.capture

  ```
  <div id="father" v-on:click.capture="doc">
  ```

  那么当冒泡发生的时候，就会优先让father捕捉事件。
  点击son或者me的时候，都会优先触发它

- 事件修饰符 只有自己能触发，子元素无法触发.self

  修改father,增加 .self

  ```
  <div id="father" v-on:click.self="doc">
  ```

  这样点击son 和 me都不会导致其触发click事件，只有点击father自己，才会导致事件发生。

- 事件修饰符 只能提交一次 .once

  修改father,增加 .once

  ```
  <div id="father" v-on:click.once="doc">
  ```

  这样father点击一次之后，就不会再监听到click了，但是有意思的是，grandFather还能监听到~

- 事件修饰符 阻止提交 .prevent

  通过在 click 后面添加 .prevent 可以阻止页面刷新。

  ```
  @click.prevent="jump"
  ```

  也可以直接用@click.prevent后面不跟函数

  ```
  @click.prevent
  ```

  **注：** **只有超链和form这种会导致页面刷新的操作，.prevent 才有用。 普通的不导致页面刷新的按钮，加上这个没有任何变化。**

  ```
  <div id="div1">
     
    <a href="http://12306.com" @click="jump" >正常的链接 http://12306.com</a>
     
    <br>
    <a href="http://12306.com" @click.prevent="jump" >prevent jump()之后的链接 http://12306.com</a>
    <br>
    <a href="http://12306.com" @click.prevent >纯prevent之后的链接 http://12306.com</a>
     
    <br>
    <br>
    <form @submit="jump" action="http://12306.com">
      <button type="submit">正常的form</button>
    </form>
    <form @submit.prevent="jump" action="http://12306.com">
      <button type="submit">prevent jump()之后的form</button>
    </form>
    <form @submit.prevent action="http://12306.com">
      <button type="submit">纯prevent之后的form</button>
    </form>
     
  </div>
      
  <script>
      
  new Vue({
        el: '#div1',
        data: {
        },
        methods:{
            jump:function(){
                alert("jump()函数被调用");
            }
        }
      })
      
  </script>
  ```

#### 条件语句

- v-if

  通过toggle函数切换show的值。 通过v-if 语句，当show 是true的时候，显示当前元素

  ```
  <div id="div1">
     
    <button v-on:click="toggle">切换隐藏显示</button>
    <div v-if="show"> 默认这一条是看得见的</div>
       
  </div>
      
  <script>
      
  new Vue({
        el: '#div1',
        data: {
            show:true
        },
        methods:{
            toggle: function(){
                this.show=!this.show;
            }
        }
      })
      
  </script>
  ```

- v-else

  ```
  <div id="div1">
     
    <button v-on:click="moyiba"> 摸一把彩票 10%的几率</button>
    <div v-if="show"> 中了500万！</div>
    <div v-else>谢谢惠顾！</div> 
       
  </div>
      
  <script>
      
  new Vue({
        el: '#div1',
        data: {
            show:false
        },
        methods:{
            moyiba: function(){
               this.show=Math.random()<0.1
            }
        }
      })
      
  </script>
  ```

- v-else-if

  ```
  <div id="div1">
     
    <button v-on:click="toutai"> 看看下辈子投胎是做什么的 </button>
    <div v-if="number>98"> 神仙</div>
    <div v-else-if="number>95"> 国家领导人</div>
    <div v-else-if="number>90"> 大富商</div>
    <div v-else-if="number>80"> 大企业主</div>
    <div v-else-if="number>70"> 演艺明星</div>
    <div v-else-if="number>60"> 小企业主</div>
    <div v-else-if="number>50"> 普通公务员</div>
    <div v-else-if="number>40"> 小个体户</div>
    <div v-else-if="number>30"> 血汗工厂工人</div>
    <div v-else-if="number>20"> 偏远山区农民</div>
    <div v-else> 流浪汉</div>
       
  </div>
      
  <script>
      
  new Vue({
        el: '#div1',
        data: {
            number:0
        },
        methods:{
            toutai: function(){
               this.number=Math.random()*100
            }
        }
      })
      
  </script>
  ```

#### 循环语句

- v-for循环语句

  ```
  <div id="div1">
     
      <table align="center" >
          <tr class="firstLine">
              <td>name</td>
              <td>hp</td>
          </tr>
           
          <tr v-for="hero in heros">
              <td>{{hero.name}}</td>
              <td>{{hero.hp}}</td>
          </tr>
           
      </table>
   
  </div>
      
  <script>
    
  var data = [
            {name:"盖伦",hp:341},
            {name:"提莫",hp:225},
            {name:"安妮",hp:427},
            {name:"死歌",hp:893}
      ];
  new Vue({
        el: '#div1',
        data: {
            heros:data
        }
      })
      
  </script>
  ```

- index用法

  ```
  <div id="div1">
     
      <table align="center" >
          <tr class="firstLine">
              <td>number</td>
              <td>name</td>
              <td>hp</td>
          </tr>
           
          <tr v-for="hero,index in heros">
              <td>{{index+1}}</td>
              <td>{{hero.name}}</td>
              <td>{{hero.hp}}</td>
          </tr>
           
      </table>
   
  </div>
      
  <script>
    
  var data = [
            {name:"盖伦",hp:341},
            {name:"提莫",hp:225},
            {name:"安妮",hp:427},
            {name:"死歌",hp:893}
      ];
  new Vue({
        el: '#div1',
        data: {
            heros:data
        }
      })
      
  </script>
  ```

- 纯数字遍历

  ```
  <div id="div1">
      <div v-for="i in 10">
       {{ i }}
      </div>
  </div>
      
  <script>
    
  new Vue({
        el: '#div1'
      })
      
  </script>
  
  ```

#### 属性绑定

- v-bind 做属性绑定

  ```
  <div id="div1">
      <a v-bind:href="page">http://12306.com</a>
  </div>
      
  <script>
    
  new Vue({
        el: '#div1',
        data:{
            page:'http://12306.com'
        }
      })
      
  </script>
  ```

- v-bind:href 简写成 :href

  本来是 v-bind:href, 可以简写成 :href

#### 双向绑定

- v-model 双向绑定

  前面的例子，都是把 Vue对象上的数据显示在视图上，那么如何把视图上的数据放到Vue对象上去呢？

  这时就需要用到v-model进行双向绑定

  例：当input里面的值发生变化的时候，就会自动把变化后的值，绑定到Vue对象上去了

  ```
  <div id="div1">
       
      hero name: <input v-model="name" >
      <button @click="doClick" >提交数据</button>
       
  </div>
      
  <script>
    
  new Vue({
        el: '#div1',
        data:{
          name:"teemo"
        },
        methods:{
            doClick:function(){
                alert(this.name);
            }
        }
      })
      
  </script>
  ```

- 多种风格数据的绑定

  ```
  <div id="div1">
      
      <table align="center" >
          <tr class="firstLine">
              <td>视图类型</td>
              <td>输入数据</td>
              <td>绑定到Vue上的数值</td>
          </tr>       
          <tr>
              <td>
                  单行文本
              </td>
              <td>
                  <input v-model="input" placeholder="输入数据">
              </td>
              <td>
                  <p>{{ input }}</p>   
              </td>
          </tr>
          <tr>
              <td>
                  多行文本
              </td>
              <td>
                  <textarea v-model="textarea" placeholder="输入数据"></textarea>
              </td>
              <td>
                  <p>{{ textarea }}</p>   
              </td>
          </tr>
          <tr>
              <td>
                  单个复选框
              </td>
              <td>
                  <input type="checkbox" id="checkbox" v-model="checked">
              </td>
              <td>
                  <p>{{ checked }}</p>   
              </td>
          </tr>
          <tr>
              <td>
                  多个复选框
              </td>
              <td>
                    <input type="checkbox" id="teemo" value="teemo" v-model="checkedes">
                    <label for="teemo">teemo</label>
                    <input type="checkbox" id="gareen" value="gareen" v-model="checkedes">
                    <label for="gareen">gareen</label>
                    <input type="checkbox" id="annie" value="annie" v-model="checkedes">
                    <label for="annie">annie</label>
              </td>
              <td>
                  <p>{{ checkedes }}</p>   
              </td>
          </tr>
          <tr>
              <td>
                  单选按钮
              </td>
              <td>
                <input type="radio" id="one" value="One" v-model="radio">
                <label for="one">One</label>
                <br>
                <input type="radio" id="two" value="Two" v-model="radio">
                <label for="two">Two</label>
              </td>
              <td>
                  <p>{{ radio }}</p>   
              </td>
          </tr>
          <tr>
              <td>
                  单选选择框
              </td>
              <td>
                <select v-model="selected" size="5">
                  <option disabled value="">请选择</option>
                  <option>AD</option>
                  <option>AC</option>
                  <option>ADC</option>
                </select>
              </td>
              <td>
                  <p>{{ selected }}</p>   
              </td>
          </tr>
          <tr>
              <td>
                  多选选择框
              </td>
              <td>
                (通过ctrl或者shift进行多选)<br>
                <select v-model="selecteds" multiple size="5">
                  <option disabled value="">请选择</option>
                  <option>AD</option>
                  <option>AC</option>
                  <option>ADC</option>
                </select>
              </td>
              <td>
                  <p>{{ selecteds }}</p>   
              </td>
          </tr>
          <tr>
              <td>
                  单个复选框
              </td>
              <td>
                  默认值是true或者false,也可以修改为自定义的值<br>
                  <input type="checkbox" id="toggle" true-value="yes" false-value="no" v-model="toggle">
              </td>
              <td>
                  <p>{{ toggle }}</p>   
              </td>
          </tr>       
   
      </table>
    
  </div>
       
  <script>
     
  new Vue({
        el: '#div1',
        data: {
            input:'',
            textarea:'',
            checked:'',
            checkedes:[],
            radio:'',
            selected:'',
            selecteds:[],
            toggle:'',
             
        }
      })
       
  </script>
  ```

- 修饰符

  vue.js 还提供了一些修饰符方便用户操作，常见的有
  .lazy 
  .number
  .trim

- 修饰符 .lazy

  对于输入元素，默认的行为方式是一旦有数据变化，马上进行绑定。
  但是加上.lazy之后，相当于监听change操作，只有在失去焦点的时候，才会进行数据绑定了

  ```
  <div id="div1">
      
      <table align="center" >
          <tr class="firstLine">
              <td>视图类型</td>
              <td>输入数据</td>
              <td>绑定到Vue上的数值</td>
          </tr>       
          <tr>
              <td>
                  单行文本1
              </td>
              <td>
                  <input v-model.lazy="input1" placeholder="输入数据">
              </td>
              <td>
                  <p>{{ input1 }}</p>   
              </td>
          </tr>
          <tr>
              <td>
                  单行文本2
              </td>
              <td>
                  <input v-model.lazy="input2" placeholder="输入数据">
              </td>
              <td>
                  <p>{{ input2 }}</p>   
              </td>
          </tr>
      </table>
    
  </div>
       
  <script>
     
  new Vue({
        el: '#div1',
        data: {
            input1:'',
            input2:''
             
        }
      })
       
  </script>
  ```

- 修饰符 .number

  有时候，拿到了数据需要进行数学运算， 为了保证运算结果，必须先把类型转换为number类型，而v-model默认是string类型，所以就可以通过.number方式确保获取到的是数字类型了。

  ```
  <div id="div1">
       
      <table align="center" >
          <tr class="firstLine">
              <td>视图类型</td>
              <td>输入数据</td>
              <td>绑定到Vue上的数值</td>
              <td>数值类型</td>
          </tr>      
          <tr>
              <td>
                  单行文本1
              </td>
              <td>
                  <input v-model="input1" type="number" placeholder="输入数据">
              </td>
              <td>
                  <p>{{ input1 }}</p>  
              </td>
              <td>
                  <p>{{ typeof input1 }}</p>  
              </td>
          </tr>
          <tr>
              <td>
                  单行文本2
              </td>
              <td>
                  <input v-model.number="input2"   type="number"  placeholder="输入数据">
              </td>
              <td>
                  <p>{{ input2 }}</p>  
              </td>
              <td>
                  <p>{{ typeof input2 }}</p>  
              </td>
          </tr>
      </table>
     
  </div>
        
  <script>
      
  new Vue({
        el: '#div1',
        data: {
            input1:'',
            input2:''
              
        }
      })
        
  </script>
  ```

- 修饰符 .trim

  trim 去掉前后的空白

  ```
  <div id="div1">
       
      <table align="center" >
          <tr class="firstLine">
              <td>视图类型</td>
              <td>输入数据</td>
              <td>绑定到Vue上的数值</td>
          </tr>      
          <tr>
              <td>
                  单行文本
              </td>
              <td>
                  <input v-model.trim="input" placeholder="输入数据">
              </td>
              <td>
                  <p>"{{ input }}"</p>  
              </td>
          </tr>
      </table>
     
  </div>
        
  <script>
      
  new Vue({
        el: '#div1',
        data: {
            input:'',
            input2:''
              
        }
      })
        
  </script>
  ```

#### 计算属性

- 先看不用 computed

  ```
  <div id="div1">
       
      <table align="center" >
          <tr class="firstLine">
              <td>人民币</td>
              <td>美元</td>
          </tr>      
          <tr>
              <td align="center" colspan="2">
              汇率： <input type="number" v-model.number="exchange" />
              </td>
          </tr>
           
          <tr>
           
              <td align="center">
                  ￥: <input type="number" v-model.number = "rmb"  />
              </td>
              <td align="center">
                  $: {{ rmb/exchange }}
              </td>
          </tr>
      </table>
     
  </div>
        
  <script>
      
  new Vue({
        el: '#div1',
        data: {
            exchange:6.4,
            rmb:0
        }
      })
        
  </script>
  ```

- 再看看 computed 的做法

  如果运算过程比较复杂，那么维护起来就比较麻烦。

  ```
  {{ rmb/exchange }}
  ```

  所以可以把运算过程，都放在computed里去，只用显示运算结果就好了。

  ```
  {{ dollar }}
  ```

  ```
  <div id="div1">
       
      <table align="center" >
          <tr class="firstLine">
              <td>人民币</td>
              <td>美元</td>
          </tr>      
          <tr>
              <td align="center" colspan="2">
              汇率： <input type="number" v-model.number="exchange" />
              </td>
          </tr>
           
          <tr>
           
              <td align="center">
                  ￥: <input type="number" v-model.number = "rmb"  />
              </td>
              <td align="center">
                  $: {{ dollar }}
              </td>
          </tr>
      </table>
     
  </div>
        
  <script>
      
  new Vue({
        el: '#div1',
        data: {
            exchange:6.4,
            rmb:0
        },
        computed:{
            dollar:function() {
                return this.rmb / this.exchange;
            }
        }
      })
        
  </script>
  ```

- methods 也能达到一样的效果

  methods 也能达到一样的效果，调用的时候，要加上括号

  ```
  <div id="div1">
       
      <table align="center" >
          <tr class="firstLine">
              <td>人民币</td>
              <td>美元</td>
          </tr>      
          <tr>
              <td align="center" colspan="2">
              汇率： <input type="number" v-model.number="exchange" />
              </td>
          </tr>
           
          <tr>
           
              <td align="center">
                  ￥: <input type="number" v-model.number = "rmb"  />
              </td>
              <td align="center">
                  $: {{ getDollar() }}
              </td>
          </tr>
      </table>
     
  </div>
        
  <script>
      
  new Vue({
        el: '#div1',
        data: {
            exchange:6.4,
            rmb:0
        },
        methods:{
            getDollar:function() {
                return this.rmb / this.exchange;
            }
        }
      })
        
  </script>
  ```

- computed 和 methods 的区别

  computed 是有缓存的，只要rmb没有变化，dollar 会直接返回以前计算出来的值，而不会再次计算。 这样如果是复杂计算，就会节约不少时间。
  而methods每次都会调用

#### 监听属性

- watch

  vue可以通过watch来监听属性值的变化。

  ```
  <div id="div1">
       
      <table align="center" >
          <tr class="firstLine">
              <td>人民币</td>
              <td>美元</td>
          </tr>      
          <tr>
              <td align="center" colspan="2">
              汇率： <input type="number" v-model.number="exchange" />
              </td>
          </tr>
           
          <tr>
           
              <td align="center">
                  ￥: <input type="number" v-model.number = "rmb"  />
              </td>
              <td align="center">
                  $: <input type="number" v-model.number = "dollar"   />
              </td>
          </tr>
      </table>
     
  </div>
        
  <script>
      
  new Vue({
        el: '#div1',
        data: {
            exchange:6.4,
            rmb:0,
            dollar:0
        },
        watch:{
            rmb:function(val) {
                this.rmb = val;
                this.dollar = this.rmb / this.exchange;
            },
            dollar:function(val) {
                this.dollar = val;
                this.rmb = this.dollar * this.exchange;
            },
        }
         
      })
        
  </script>
  ```

#### 过滤器

- 一个过滤器

  ```
  <div id="div1">
       
      <table align="center" >
          <tr class="firstLine">
              <td>输入数据</td>
              <td>过滤后的结果</td>
          </tr>      
          <tr>
              <td align="center">
                  <input v-model= "data"  />
              </td>
              <td align="center">
                  {{ data|capitalize }}
              </td>
          </tr>
      </table>
     
  </div>
        
  <script>
      
  new Vue({
        el: '#div1',
        data: {
            data:''
        },
        filters:{
            capitalize:function(value) {
                  if (!value) return '' //如果为空，则返回空字符串
                  value = value.toString()
                  return value.charAt(0).toUpperCase() + value.substring(1)
            }
        }
      })
        
  </script>
  ```

- 多个过滤器

  ```
  <div id="div1">
       
      <table align="center" >
          <tr class="firstLine">
              <td>输入数据</td>
              <td>过滤后的结果</td>
          </tr>      
          <tr>
              <td align="center">
                  <input v-model= "data"  />
              </td>
              <td align="center">
                  {{ data|capitalize|capitalizeLastLetter }}
              </td>
          </tr>
      </table>
     
  </div>
        
  <script>
      
  new Vue({
        el: '#div1',
        data: {
            data:''
        },
        filters:{
            capitalize:function(value) {
                  if (!value) return '' //如果为空，则返回空字符串
                  value = value.toString()
                  return value.charAt(0).toUpperCase() + value.substring(1)
            },
            capitalizeLastLetter:function(value) {
                  if (!value) return '' //如果为空，则返回空字符串
                  value = value.toString()
                  return value.substring(0,value.length-1)+ value.charAt(value.length-1).toUpperCase()
            }
        }
      })
        
  </script>
  ```

- 全局过滤器

  在上面的例子里可以看到，过滤器是定义在Vue对象里的。 但是有时候，很多不同的页面都会用到相同的过滤器，如果每个Vue对象里都重复开发相同的过滤器，不仅开发量增加，维护负担也增加了。
  所以就可以通过全局过滤器的方式，只定义一次过滤器，然后就可以在不同的Vue对象里使用了。

  ```
  <div id="div1">
       
      <table align="center" >
          <tr class="firstLine">
              <td>输入数据</td>
              <td>过滤后的结果</td>
          </tr>      
          <tr>
              <td align="center">
                  <input v-model= "data"  />
              </td>
              <td align="center">
                  {{ data|capitalize|capitalizeLastLetter }}
              </td>
          </tr>
      </table>
     
  </div>
        
  <script>
  Vue.filter('capitalize', function (value) {
      if (!value) return ''
      value = value.toString()
      return value.charAt(0).toUpperCase() + value.slice(1)
  })
       
  Vue.filter('capitalizeLastLetter', function (value) {
      if (!value) return '' //如果为空，则返回空字符串
      value = value.toString()
      return value.substring(0,value.length-1)+ value.charAt(value.length-1).toUpperCase()
  })
   
  new Vue({
        el: '#div1',
        data: {
            data:''
        }
      })
        
  </script>
  ```

#### 组件

- 组件是什么

  每个产品展示，就是一个模板。 只用做一个模板，然后照着这个模板，传递不同的参数就可以看到不同的产品展示了。

  这个模板，就是组件。

- 局部组件

  在 Vue对象里增加 components：

  ```
    components:{
  	  'product':{
  		  template:'<div class="product" >MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮</div>'
  	  }
  ```

  然后在视图里，通过如下方式就可以调用了

  ```
  <product></product>
  ```

  如果想重复使用，则多写几次就行了

  ```
  <product></product>
  <product></product>
  <product></product>
  ```

  完整代码：

  ```
  <div id="div1">
      <product></product>
      <product></product>
      <product></product>
  </div>
    
  <script>
  new Vue({
    el: '#div1',
    components:{
        'product':{
            template:'<div class="product" >MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮</div>'
        }
    }
  })
  </script>
  ```

- 全局组件

  和vue.js 里的过滤器一样，有的组件会在不同页面使用，这个时候就可以考虑用全局组件。

  ```
  Vue.component('product', {
  	  template: '<div class="product" >MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮</div>'
  	})
  ```

  完整代码：

  ```
  <div id="div1">
      <product></product>
      <product></product>
      <product></product>
  </div>
    
  <script>
  Vue.component('product', {
        template: '<div class="product" >MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮</div>'
      })
   
  new Vue({
    el: '#div1'
  })
  </script>
  ```

- 参数

  设置参数name, 并且在组件里使用这个name:

  ```
  Vue.component('product', {
  	  props:['name'],
  	  template: '<div class="product" >{{name}}</div>'
  	})
  ```

  调用的时候，就当作是一个自定义属性传进去就可以了

  ```
  <product name="MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮"></product>
      <product name="宾度 男士手包真皮大容量手拿包牛皮个性潮男包手抓包软皮信封包"></product>
      <product name="唯美诺新款男士手包男包真皮大容量小羊皮手拿包信封包软皮夹包潮"></product>
  ```

  完整代码：

  ```
  <div id="div1">
      <product name="MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮"></product>
      <product name="宾度 男士手包真皮大容量手拿包牛皮个性潮男包手抓包软皮信封包"></product>
      <product name="唯美诺新款男士手包男包真皮大容量小羊皮手拿包信封包软皮夹包潮"></product>
  </div>
    
  <script>
  Vue.component('product', {
        props:['name'],
        template: '<div class="product" >{{name}}</div>'
      })
   
  new Vue({
    el: '#div1'
  })
  </script>
  ```

- 动态参数

  所谓的动态参数，就是指组件内的参数可以和组件外的值关联起来
  如效果所示，在组件外的input输入数据，就可以传递到组件内了
  关键是这一行，name表示组件内的属性name, outName就是组件外的

  ```
  <product v-bind:name="outName"></product>
  ```

  完整代码：

  ```
  <div id="div1">
      组件外的值：<input v-model="outName" ><br>
      <product v-bind:name="outName"></product>
  </div>
    
  <script>
  Vue.component('product', {
        props:['name'],
        template: '<div class="product" >{{name}}</div>'
      })
   
  new Vue({
    el: '#div1',
    data:{
        outName:'产品名称'
    }
  })
  </script>
  ```

- 自定义事件

  增加自定义事件和在一个Vue对象上增加 methods 是一样的做法

  先来个methods:

  ```
   methods:{
  	  increaseSale:function(){
  		  this.sale++
  	  }
    }
  ```

  然后在组件里：

  ```
  v-on:click="increaseSale"
  ```

  **注**，这里是在组件上增加的，而不是在视图上增加的。

  完整代码：

  ```
  <div id="div1">
      <product name="MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮" sale="10" ></product>
      <product name="宾度 男士手包真皮大容量手拿包牛皮个性潮男包手抓包软皮信封包" sale="20" ></product>
      <product name="唯美诺新款男士手包男包真皮大容量小羊皮手拿包信封包软皮夹包潮" sale="30" ></product>
  </div>
   
  <script>
  Vue.component('product', {
        props:['name','sale'],
        template: '<div class="product" v-on:click="increaseSale">{{name}} 销量: {{sale}} </div>',
        methods:{
            increaseSale:function(){
                this.sale++
            }
        }
      })
   
  new Vue({
    el: '#div1'
  })
  </script>
  ```

- 遍历 json 数组

  大部分时候是拿到一个 json 数组，然后遍历这个 json 数组为多个组件实例。

  1. 首先准备产品数组

     ```
     products:[
                 {"name":"MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮","sale":"18"},
                 {"name":"宾度 男士手包真皮大容量手拿包牛皮个性潮男包手抓包软皮信封包","sale":"35"},
                 {"name":"唯美诺新款男士手包男包真皮大容量小羊皮手拿包信封包软皮夹包潮","sale":"29"}
                 ]
     ```

  2. 然后在视图里通过 v-for 遍历 products

     ```
     <product v-for="item in products" v-bind:product="item"></product>
     ```

  3. 接着修改组件，让接受的参数为 v-bind:product 里的这个 product，显示和方法里也通过 product.xxx 来调用。

     ```
     Vue.component('product', {
     	  props:['product'],
     	  template: '<div class="product" v-on:click="increaseSale">{{product.name}} 销量: {{product.sale}} </div>',
     	  methods:{
     		  increaseSale:function(){
     			  this.product.sale++
     		  }
     	  }
     	})
     ```

  完整代码：

  ```
  <div id="div1">
      <product v-for="item in products" v-bind:product="item"></product>
  </div>
   
  <script>
  Vue.component('product', {
        props:['product'],
        template: '<div class="product" v-on:click="increaseSale">{{product.name}} 销量: {{product.sale}} </div>',
        methods:{
            increaseSale:function(){
                this.product.sale++
            }
        }
      })
   
  new Vue({
    el: '#div1',
    data:{
        products:[
                  {"name":"MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮","sale":"18"},
                  {"name":"宾度 男士手包真皮大容量手拿包牛皮个性潮男包手抓包软皮信封包","sale":"35"},
                  {"name":"唯美诺新款男士手包男包真皮大容量小羊皮手拿包信封包软皮夹包潮","sale":"29"}
                  ]
    }
  })
  </script>
  ```

- template写在html里

  另外 template 部分因为比较复杂，就不好写在一个 单引号 ' ' 里维护起来，所以就直接写在html里，然后通过html dom 获取出来，这样编写起来略微容易一点。 

  完整代码：

  ```
  <div id="tempalate" style="display:none">
      <div class="product" v-on:click="increaseSales">
          <div class="price">
                      ¥ {{product.price}}
          </div>
          <div class="productName">
              {{product.name}}
          </div>
          <div class="sale"> 月成交 {{product.sale}} 笔</div>
          <div class="review"> 评价 {{product.review}} </div>
      </div>
  </div>
   
  <div id="div1">
      <product v-for="item in products" v-bind:product="item"></product>
  </div>
    
  <script>
  var tempalateDiv=document.getElementById("tempalate").innerHTML;
  var templateObject = {
      props: ['product'],
      template: tempalateDiv,
        methods: {
              increaseSales: function () {
                  this.product.sale = parseInt(this.product.sale);
                this.product.sale += 1
                this.$emit('increment')
              }
            }
   
  }
   
  Vue.component('product', templateObject)
   
  new Vue({
    el: '#div1',
    data:{
        products:[
                  {"name":"MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮","price":"889","sale":"18","review":"5"},
                  {"name":"宾度 男士手包真皮大容量手拿包牛皮个性潮男包手抓包软皮信封包","price":"322","sale":"35","review":"12"},
                  {"name":"唯美诺新款男士手包男包真皮大容量小羊皮手拿包信封包软皮夹包潮","price":"523","sale":"29","review":"3"},
                  ]
    }
  })
  </script>
  ```

#### 自定义指令

- 自定义指令的方式：

  1. 使用Vue.directive 来自定义
  2. 第一个参数就是 指令名称
  3. el 表示当前的html dom对象
  4. 在方法体内就可以通过 innerHTML style.color 等方式操控当前元素了

  ```
  <div id="div1">
      <div v-xart> 好好学习，天天向上 </div>
  </div>
   
  <script>
   
  Vue.directive('xart', function (el) {
      el.innerHTML = el.innerHTML + ' ( x-art ) '
      el.style.color = 'pink'
  })
   
  new Vue({
    el: '#div1'
  })
  </script>
  ```

- 带参数的自定义指令

  binding.value 就是指 v-xart=“xxx” 这个xxx。 此时xxx是一个json对象，所以就可以通过.text, .color取出对应的值出来。

  ```
  Vue.directive('xart', function (el,binding) {
  	el.innerHTML = el.innerHTML + '( ' + binding.value.text + ' )'
  	el.style.color = binding.value.color
  })
  ```

  视图上用就传递个json 对象进去

  ```
  <div v-xart="{color:'red',text:'best learning video'}"> 好好学习，天天向上 </div>
  ```

  完整代码：

  ```
  <div id="div1">
      <div v-xart="{color:'red',text:'best learning video'}"> 好好学习，天天向上 </div>
  </div>
   
  <script>
  Vue.directive('xart', function (el,binding) {
      el.innerHTML = el.innerHTML + '( ' + binding.value.text + ' )'
      el.style.color = binding.value.color
  })
   
  new Vue({
    el: '#div1'
  })
  </script>
  ```

- 钩子函数

   钩子函数是什么意思? 又叫做回调函数，或者事件响应函数。 指的是，一个指令在创建过程中，经历不同生命周期的时候，vue.js 框架调用的函数。
  事件常见的有如下几种：
  bind：只调用一次，指令第一次绑定到元素时调用。在这里可以进行一次性的初始化设置。
  update：所在组件的 VNode 更新时调用，但是可能发生在其子 VNode 更新之前。指令的值可能发生了改变，也可能没有。但是你可以通过比较更新前后的值来忽略不必要的模板更新 (详细的钩子函数参数见下)。
  unbind：只调用一次，指令与元素解绑时调用。

  以bind为例，可以传递主要是用到binding里的属性

  - name：指令名，不包括 v- 前缀。
  - value：指令的绑定值，本例就是hello vue.js
  - oldValue：指令绑定的前一个值，仅在 update 和 componentUpdated 钩子中可用。无论值是否改变都可用。
  - expression：字符串形式的指令表达式。本例就是 message
  - arg：传给指令的参数，本例就是hello
  - modifiers：一个包含修饰符的对象。本例就是 .a .b

  这样拿到这些自定义指令的各项参数，那么在函数体里就方便做各种自定义功能了  

  ```
  <div id="div1">
       
      <div v-xart:hello.a.b="message"> </div>
       
  </div>
   
  <script>
  Vue.directive('xart', {
        bind: function (el, binding, vnode) {
              var s = JSON.stringify
              el.innerHTML =
                'name: '       + s(binding.name) + '<br>' +
                'value: '      + s(binding.value) + '<br>' +
                'expression: ' + s(binding.expression) + '<br>' +
                'argument: '   + s(binding.arg) + '<br>' +
                'modifiers: '  + s(binding.modifiers) + '<br>' +
                'vnode keys: ' + Object.keys(vnode).join(', ')
        },
         
        update: function (newValue, oldValue) {
          // 值更新时的工作
          // 也会以初始值为参数调用一次
        },
        unbind: function () {
          // 清理工作
          // 例如，删除 bind() 添加的事件监听器
        }
      })
       
  new Vue({
    el: '#div1',
    data:{
        message:'hello vue.js'
    }
  })
  </script>
  ```

#### 路由

- vue.js 里的路由概念

  vue.js 里的路由相当于就是局部刷新。 
  如效果所示，点击左边的菜单，右边的内容在不刷新整个页面的情况下，进行局部刷新

- vue-router.min.js

  为了实现路由，需要一个额外的库： vue-router.min.js

- 路由示例

  ```
  <div id="app">
      <div class="menu">
          <!--
              router-link 相当于就是超链
              to 相当于就是 href
          -->
          <router-link to="/user">用户管理</router-link>
          <router-link to="/product">产品管理</router-link>
          <router-link to="/order">订单管理</router-link>
      </div>
       
      <div class="workingRoom">
          <!--
              点击上面的/user,那么/user 对应的内容就会显示在router-view 这里
           -->
           <router-view></router-view>   
      </div>
   
  </div>
  <script>
      /*
      * 申明三个模板( html 片段 )
      */
      var user = { template: '<p>用户管理页面的内容</p>' };
      var second = { template: '<p>产品管理页面的内容</p>' };
      var order = { template: '<p>订单管理页面的内容</p>' };
      /*
      * 定义路由
      */
      var routes = [
          { path: '/', redirect: '/user'}, // 这个表示会默认渲染 /user，没有这个就是空白
          { path: '/user', component: user },
          { path: '/product', component: second },
          { path: '/order', component: order }
      ];
      /*
      * 创建VueRouter实例
      */
      var router = new VueRouter({
          routes:routes
      });
      /*
      * 给vue对象绑定路由
      */
      new Vue({
          el:"#app",
          router
      })
   
  </script>
  ```

#### fetch.js

- fetch.js

  一般说来 Vue 不会直接使用原生的 Ajax 而是使用 ajax 框架。 而 fetch.js 就是眼下比较流行的一种 ajax 框架

- 准备 json数据

  ```
  {"name":"gareen","hp":"355"}
  ```

- 通过 fetch 获取数据

  ```
  <div id="hero">
    
  </div>
    
  <script>
  var url = "http://how2j.cn/study/json.txt"
  fetch(url).then(function(response) {
      response.json().then(function (jsonObject) {
          var jsonString = JSON.stringify(jsonObject)
          document.getElementById("hero").innerHTML = "通过fetch获取到的json数据："+ jsonString;
      })
  }).catch(function(err){
      console.log("Fetch错误:"+err);
  })
    
  </script>
  ```

#### axios.js

-  axios.js

  一般说来 Vue 不会直接使用原生的 Ajax 而是使用 ajax 框架。 而 axios.js 就是眼下比较流行的一种 ajax 框架

- 准备 json数据

  {"name":"gareen","hp":"355"}

- 通过 axions 获取数据

  ```
  <div id="hero">
    
  </div>
    
  <script>
  var url = "http://how2j.cn/study/json.txt"
      axios.get(url).then(function(response) {
          var jsonObject = response.data;
          var jsonString = JSON.stringify(jsonObject)
          document.getElementById("hero").innerHTML = "通过 axios 获取到的json数据："+ jsonString;
      })
    
  </script>
  ```

#### Ajax

- Ajax

  Vue.js 并没有限制使用哪种方式进行 ajax 访问，所以可以使用如下方式
  1. 原生 ajax
  2. JQuery
  3. vue-resource
  4. fetch.js
  5. axios.js

  那么到底用哪种方式呢？

  1. 原生一般不在项目中直接用
  2. jquery 不如4，5方便
  3. vue-resource 已经不再维护了，所以不推荐
  4. fetch.js 是 vue.js 官方推荐
  5. axios.js 是vue.js 官方推荐

- 首先准备 json 数组

  ```
  [
      ``{"name":"gareen","hp":"355"},
      ``{"name":"teemo","hp":"287"},
      ``{"name":"annie","hp":"420"}
  ]
  ```

- fetch.js 方式

  ```
  mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
  ```

  ```
  <script src="vue.min.js"></script>
  <script src="fetch.min.js"></script>
  <div id="div1">
      
      <table align="center" >
          <tr class="firstLine">
              <td>name</td>
              <td>hp</td>
          </tr>
            
          <tr v-for="hero in heros">
              <td>{{hero.name}}</td>
              <td>{{hero.hp}}</td>
          </tr>
            
      </table>
    
  </div>
    
  <script>
  var url = "http://how2j.cn/study/jsons.txt";
  new Vue({
      el:'#div1',
      data:{
          heros:[]
      },
      mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
          self=this
          fetch(url).then(function(response) {
              response.json().then(function (jsonObject) {
                  self.heros = jsonObject
              })
          }).catch(function(err){
              console.log("Fetch错误:"+err);
          })
      }
  })
  </script>
  ```

- axios.js 方式

  mounted 表示 Vue 对象加载成功了。

  ```
  mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
  ```

  ```
  <script src="vue.min.js"></script>
  <script src="axios.min.js"></script>
  <div id="div1">
      
      <table align="center" >
          <tr class="firstLine">
              <td>name</td>
              <td>hp</td>
          </tr>
            
          <tr v-for="hero in heros">
              <td>{{hero.name}}</td>
              <td>{{hero.hp}}</td>
          </tr>
            
      </table>
    
  </div>
    
  <script>
  var url = "http://how2j.cn/study/jsons.txt";
  new Vue({
      el:'#div1',
      data:{
          heros:[]
      },
      mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
          var self = this
          axios.get(url).then(function(response) {
              self.heros= response.data; //此时还是字符串
              self.heros = eval("("+self.heros+")");  //字符串转换为数组对象
          })     
      }
  })
  </script>
  
  ```

#### vue-cli

- vue-cli 概念

  vue-cli 是 vue 出来的一个脚手架，可以进行 组件式地开发。
  
  但是要运用 vue-cli , 必须要有 node.js 和 webpack 的基础，否则里面很多命令既运行不了，也无法理解。
  
- 准备项目目录

- 安装 vue-cli

  ```
  npm install -g @vue/cli@3.0.1
  ```

- 查看版本

  ```
  vue --version
  ```

- 原型工具

  vue-cli 提供了一个很方便的原型工具，按照如下方式安装

  ```
  npm install -g @vue/cli-service-global@3.0.1
  ```

- test.vue

  在项目下新建一个 test.vue 文件

  ```
  <template>
    <h1>Hello Vue-Cli</h1>
  </template>
  ```

- 运行命令

  ```
  vue serve test.vue
  ```

  就会提示，让打开如下 URL 进行测试： 

  ```
  http://localhost:8081/
  ```

- 关于 vue 文件

   虽然 vue 可以通过 组件的方式重复使用很多代码，但是 <component> 方式有一些缺陷：

  1. 组件用 '' 方式写，如果比较复杂，写起来麻烦
  2. 组件里 不包含 js
  3. 组件里不包含 css

  而用 vue 就可以化解这个问题。

- 改造test.vue

  html部分放在 <template> 标签里
  提供数据部分放在 <script> 里
  样式部分放在 <style> 里

  ```
  <template>
    <p>{{greeting}}  Vue-Cli</p>
  </template>
   
  <script>
   
  export default {
      data () {
          return {
              greeting: 'Hi'
          }
      }
  }
  </script>
   
  <style scoped>
      p{
          font-size: 2em;
          text-align:center;
          color:blue;
      }
  </style>
  ```

- 重新运行

  再运行命令

  vue serve test.vue

  然后在测试地址观察

  ```
   http://localhost:8081/
  ```

- 创建项目

  刚才的例子是仅仅基于 test.vue 这么一个单个文件。
  接下来，通过 vue-cli 创建一个项目

  ```
   vue create hello-world
  ```

- 运行项目

  创建好之后，执行如下命令运行项目

  ```
  cd hello-world
  npm run serve
  ```

- 访问测试地址

  这就启动了一个 vue 项目， 其实就是启动了 main.js 文件

  ```
  E:\project\vue-cli\hello-world\src\main.js
  ```

  间接得加载了 App.vue，然后又间接地加载了 components/HelloWorld.vue 文件。
  HelloWorld.vue文件里，就是上面这些 html 超链了。。。

- vue-cli 缺点

  vue-cli ，单页应用 SPA(single page application) 开发的时候是很方便的，但是多页复杂系统的话用起来就比较麻烦了。
  并不是 vue-cli 不支持 多页系统， 而是为了让 vue-cli 支持多页系统，需要额外装很多插件和工具，用起来就相当的麻烦

#### CRUD

- 查询

  ```
  <div id="app">
              <table id="heroListTable" >
                  <thead>
                      <tr>
                          <th>英雄名称</th>
                          <th>血量</th>
                      </tr>
                  </thead>
                  <tbody>
                      <tr v-for="hero in heros ">
                          <td>{{hero.name}}</td>
                          <td>{{hero.hp}}</td>
                      </tr>
                  </tbody>
              </table>
               
      </div>
   
  <script type="text/javascript">
      //Model
      var data = {
          heros: [
          { id: 1, name: '盖伦', hp: 318},
          { id: 2, name: '提莫', hp: 320},
          { id: 3, name: '安妮', hp: 419},
          { id: 4, name: '死歌', hp: 325},
          { id: 5, name: '米波', hp: 422},
          ]
      };
           
      //ViewModel
      var vue = new Vue({
          el: '#app',
          data: data
      });
  </script>
  ```

- 增加

  1. 准备输入框

     ```
     <td colspan="3">
     英雄名称:
     <input type="text"    v-model="hero4Add.name" />
     <br>
     血量：
     <input type="number"    v-model="hero4Add.hp" />
     <br>
     <button type="button"  v-on:click="add">增加</button>  
     </td> 
     ```

     输入组件都和 hero4Add 对象通过 v-model 进行了双向绑定。
     增加按钮也监听了 add 函数

  2.  maxId

     ```
     //用于记录最大id值
     var maxId = 5;
     //计算最大值
     for (var i=0;i<data.heros.length;i++){
         if (data.heros[i].id > maxId)
             maxId=  this.heros[i].id;
     }   	
     ```

     准备了 maxId，作为自增长键，初始值取当前数据的最大id.

  3. add函数

     ```
     methods: {
         add: function (event) {
             //获取最大id
             maxId++;
             //赋予新id
             this.hero4Add.id = maxId;
             if(this.hero4Add.name.length==0)
                 this.hero4Add.name = "Hero#"+this.hero4Add.id;
             //把对象加入到数组
             this.heros.push(this.hero4Add);
             //让 hero4Add 指向新的对象
             this.hero4Add = { id: 0, name: '', hp: '0'}
         }
     }   
     ```

- 删除

  1. 增加删除的链接

     ```
     <td>
         <a href="#nowhere" @click="deleteHero(hero.id)">删除</a>
     </td>
     ```

  2. 增加 deleteHero 函数，就是遍历所有的hero对象，如果id相同，就删掉。

     ```
     deleteHero: function (id) {
         for (var i=0;i<this.heros.length;i++){
             if (this.heros[i].id == id) {
                 this.heros.splice(i, 1);
                 break;
             }
         }
     }
     ```

     **注:** 方法名是 deleteHero 而不是 delete, 因为 delete 是关键字

- 编辑和更新

  1. 增加链接

     ```
     <a href="#nowhere" @click="edit(hero)">编辑</a>
     ```

  2. 增加用于编辑的 div

     ```
     <div id="div4Update">
                     英雄名称:
                     <input type="text"    v-model="hero4Update.name" />
                     <br>
                     血量：
                     <input type="number"    v-model="hero4Update.hp" />                        
                     <input type="hidden"    v-model="hero4Update.id" />                        
                     <br>
                     <button type="button"  v-on:click="update">修改</button>                 
                     <button type="button"  v-on:click="cancel">取消</button>                 
      
     </div>
     ```

  3. 增加相关函数

     ```
     edit: function (hero) {
         $("#heroListTable").hide();
         $("#div4Update").show();
         this.hero4Update = hero;
     },
     update:function(){
         //因为v-model，已经同步修改了，所以只需要进行恢复显示就行了
         $("#heroListTable").show();
         $("#div4Update").hide();           
     },
     cancel:function(){
         //其实就是恢复显示
         $("#heroListTable").show();
         $("#div4Update").hide();
     }
     ```

完整代码：

```
<html>
<head>
    <script src="jquery.min.js"></script>
    <script src="vue.min.js"></script>
    <style type="text/css">
        td{
            border:1px solid gray;
        }
         
        table{
            border-collapse:collapse;
        }
     
        div#app{
            margin:20px auto;
            width:400px;
            padding:20px;
        }       
    </style>
</head>
 
<body>
    <div id="app">
            <table id="heroListTable" >
                <thead>
                    <tr>
                        <th>英雄名称</th>
                        <th>血量</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="hero in heros ">
                        <td>{{hero.name}}</td>
                        <td>{{hero.hp}}</td>
                        <td>
                            <a href="#nowhere" @click="edit(hero)">编辑</a>
                            <a href="#nowhere" @click="deleteHero(hero.id)">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            英雄名称:
                            <input type="text"    v-model="hero4Add.name" />
                            <br>
                            血量：
                            <input type="number"    v-model="hero4Add.hp" />
                            <br>
                            <button type="button"  v-on:click="add">增加</button>  
                         </td>                   
                    </tr>
                </tbody>
            </table>
             
            <div id="div4Update">
             
                            英雄名称:
                            <input type="text"    v-model="hero4Update.name" />
                            <br>
                            血量：
                            <input type="number"    v-model="hero4Update.hp" />                        
                            <input type="hidden"    v-model="hero4Update.id" />                        
                            <br>
                            <button type="button"  v-on:click="update">修改</button>                 
                            <button type="button"  v-on:click="cancel">取消</button>                 
             
            </div>
    </div>
 
    <script type="text/javascript">
        //修改区域隐藏起来先
        $("#div4Update").hide();
 
        //Model
        var data = {
            heros: [
            { id: 1, name: '盖伦', hp: 318},
            { id: 2, name: '提莫', hp: 320},
            { id: 3, name: '安妮', hp: 419},
            { id: 4, name: '死歌', hp: 325},
            { id: 5, name: '米波', hp: 422},
            ],
            hero4Add: { id: 0, name: '', hp: '0'},
            hero4Update: { id: 0, name: '', hp: '0'}
        };
         
        //用于记录最大id值
        var maxId = 5;
        //计算最大值
        for (var i=0;i<data.heros.length;i++){
            if (data.heros[i].id > maxId)
                maxId=  this.heros[i].id;
        }       
         
    //ViewModel
    var vue = new Vue({
        el: '#app',
        data: data,
        methods: {
            add: function (event) {
                //获取最大id
                maxId++;
                //赋予新id
                this.hero4Add.id = maxId;
                if(this.hero4Add.name.length==0)
                    this.hero4Add.name = "Hero#"+this.hero4Add.id;
                //把对象加入到数组
                this.heros.push(this.hero4Add);
                //让 hero4Add 指向新的对象
                this.hero4Add = { id: 0, name: '', hp: '0'}
            },
            deleteHero: function (id) {
                console.log("id"+id);
                for (var i=0;i<this.heros.length;i++){
                    if (this.heros[i].id == id) {
                        this.heros.splice(i, 1);
                        break;
                    }
                }
            },
            edit: function (hero) {
                $("#heroListTable").hide();
                $("#div4Update").show();
                this.hero4Update = hero;
            },
            update:function(){
                //因为v-model，已经同步修改了，所以只需要进行恢复显示就行了
                $("#heroListTable").show();
                $("#div4Update").hide();           
            },
            cancel:function(){
                //其实就是恢复显示
                $("#heroListTable").show();
                $("#div4Update").hide();
            }
        }
    });
    </script>
<div style="height:300px"></div>
</body>
</html>
```

