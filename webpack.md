# webpack

#### 入门启动

- 介绍

  一个包含前端的项目，里面可能有多个 .js, 多个 .css , 多个静态图片， 多个其他前端资源。
  一些 js 资源彼此之前存在依赖关系，当一个页面需要加载多个 .js 的话，也会拖累整个页面的加载速度。
  所以为了解决这个问题， webpack 就把左边的各种各样的静态资源，打包成了一个所谓的 assets. 这样浏览器加载起来就快多了。

- node.js

  webpack 的运行，是需要依赖 node.js 的运行环境

- 关于 webpack 版本

  版本4 的一些做法与以前各种版本的做法又有相当的出入。 这就导致使用4，使得在网上找到的各种 webpack 教程都无法使用。
  不仅如此， webpack 对 windows 的兼容性也不太好，很多时候 在Linux 上跑的好好的，到了 windows 上就怎么都跑不起来。

  站长实验了各种版本，最后确定下来，在 windows 里安装， 用 cnpm 方式安装 @1.13.2 版本是可以正常运行的。 

- 创建项目

  项目目录名称 **不要用 webpack** ，会对 webpack 工具的使用产生冲突

- 安装 webpack

  安装的时候，不要使用 npm， 否则在 windows 上会失败。 请使用 cnpm
  cnpm 是一个国内的镜像。

  安装 webpack，使用全局安装方式：

  ```
  cnpm install -g webpack@1.13.2
  ```

  运行：

  ```
  webpack
  ```

  可以查看webpack是否安装成功

- 示例

  1. 在项目目录下创建 a.js

  2. 使用 webpack 命令打包

     ```
     webpack a.js bundle.js
     ```

     其运行导致 a.js 被打包到 bundle.js 文件里。
     从生产的角度讲，打包一个.js 文件到另一个 .js 文件没有实际意义，不过这里是演示这个效果

  3. index.html

     准备一个 index.html，运用使用这个 bundle.js 文件。

     ```
     <html>
         <head>
             <script src="bundle.js"></script>
         </head>
     </html>
     ```

#### 配置文件方式

- 命令行方式

  使用如下命令行方式

  ```
  webpack a.js bundle.js
  ```

  如果文件名比较复杂，每一次敲入也是比较烦心的事情，所以可以采用配置文件的方式

- webpack.config.js

  ```
  module.exports = {
    entry: './a.js',
    output: {
      filename: 'bundle.js'
    }
  };
  ```

- 运行

  再次运行，就不需要使用 参数了，而是直接运行 webpack 命令就行了。 因为参数已经都放在 webpack.config.js 文件里面了

#### webpack-dev-server

- webpack-dev-server 是什么

  直接通过浏览器打开 index.html 的页面，这种情况与实际的项目是有区别的，因为实际项目通常都会是在一个服务器上打开 index.html.
  webpack-dev-server 是什么呢？ 它其实就是一个微服务器，运行它，也就启动了一个 web 服务器，可以方便地从服务器上打开这个 index.html 了

- 安装

  webpack 是用 cnpm 安装的 1.32.2，考虑到兼容性， webpack-dev-server 也不会安装最新版本，而是与之兼容的版本： webpack-dev-server@1.15.0。

  ```
  cnpm install -g webpack-dev-server@1.15.0
  ```

- 运行

  运行如下命令：

  ```
  webpack-dev-server --open
  ```

  会自动打开与 http 协议关联的浏览器，并显示默认的 index.html 页面。

- 端口

  默认访问的是8080端口，如果这个端口被占用了，那可以自定义其他端口。
  修改 webpack.config.js 为如下代码。
  然后重新运行

  ```
   webpack-dev-derver --open
  ```

  ```
  module.exports = {
      entry: './a.js',
      output: {
          filename: 'bundle.js'
      },
      devServer: {
          port:8088
      }
  }
  ```

- 热更新

  webpack-dev-server 支持热更新。 所谓的热更新，即在 webpack.config.js 中的 entry 文件 ( a.js ) 发生了改变之后，会自动运行 webpack, 并且自动刷新页面，立即看到修改之后的效果。
  为了做到这一点，需要修改 webpack.config.js 文件(**本地测试不需修改也能热更新？？？**)。

  这个文件中导入了 webpack 模块

  ```
  var webpack = require('webpack')
  ```

  因为 webpack 模块是全局的，在某些情况下，通过这种方式导入不能够被识别，需要进行一次链接：

  ```
  npm link webpack
  ```

  ```
  var webpack = require('webpack')
  module.exports = {
      entry: './a.js',
      output: {
          filename: 'bundle.js'
      },
     plugins:[
          new webpack.HotModuleReplacementPlugin()
      ],
     devServer: {
          port:8088,
          inline:true,
          hot:true
      }
  }
  ```

- 热更新测试

  重新启动 webpack-dev-server

  ```
  webpack-dev-server --open
  ```

  随便改动一下 a.js 代码，会看到无需刷新 html 页面，自动看到最新的效果。

#### npm方式启动

- npm 启动方式

  前面的方式，是直接运行 webpack-dev-server 的方式，不过大都数的项目，都会通过npm 的方式运行。

- 初始化

  运行如下命令进行 package.json 配置文件的初始化

  ```
  npm init -y
  ```

  -y 的意思是都同意~ 就不用挨个挨个手动敲打回车了

- package.json

  修改 package.json，增加脚本：

  ```
   "dev": "webpack-dev-server --open"
  ```

  ```
  {
    "name": "webpack-demo",
    "version": "1.0.0",
    "main": "a.js",
    "scripts": {
      "dev": "webpack-dev-server --open"
    },
    "keywords": [],
    "author": "",
    "license": "ISC",
    "dependencies": {
      "webpack": "^1.13.2"
    },
    "devDependencies": {},
    "description": ""
  }
  ```

- 运行

  执行命令：

  ```
  npm run dev
  ```

  这样就和单独运行的效果是一样的了

#### 多个入口文件

- 多个入口文件

  有时候，会不止一个 js 文件，会有多个。 

- webpack.config.js

  ```
  module.exports = {
      entry: {
          bundle1: './a.js',
          bundle2: './b.js'
      },
      output: {
          filename: '[name].js'
      },
      devServer: {
          port:8088
      }
  }
  ```

   a.js 被打包到 bundle1.js , b.js 被打包到 bundle2.js。

- 修改 index.html

  ```
  <html>
      <head>
          <script src="bundle1.js"></script>
          <script src="bundle2.js"></script>       
      </head>
  </html>
  ```

- 运行测试

  ```
  npm run dev
  ```

#### Babel-loader

- 版本兼容问题

  本教程建立在 cnpm 安装的如下webpack@1.13.2 和 webpack-dev-server@1.15.0 版本上，其他版本未经测试，不确保可用。

- ES6

  ES6 的全称是 ECMAScript 6.0，是下一代的 javascript 语言标准。
  因为当前 javascript 标准 (ES5) 对于开发大型的 javascritp 应用支持力度不足够，所以才会推出一个 ES6

  ES5 和 ES6 在语法上会有区别。

  ES5:

  ```
  var name = "ES5"
  document.write(`hello `+ES5)
  ```

  ES6:

  ```
  const name = 'ES6'
  document.write(`hello ${name}`)
  ```

- babel

  因为 ES6 标准推出时间还不够久，所以并不是所有的浏览器都支持 ES6 的运行。 因此，需要把 ES6 的 javascript 代码，转换为 ES5 标准的代码，以期能够在当下浏览器上兼容运行。

  转换工具有很多种， babel 就是其中的一种。

- babel 安装

  这些版本号都是经过站长测试，表示能够和当前 webpack@1.32.2 兼容的。

- a.js

  语法使用 ES6 的写法，这个是无法直接在 浏览器使用的，需要转换为 ES5 才能够使用。

  ```
  const name = 'ES6'
  document.write(`hello ${name}`)
  ```

- webpack.config.js

  修改 webpack.config.js：
  1. 入口重新设置为只有 a.js

  2. 出口是 bundle.js

  3. loaders 配置
    3.1 表示仅仅转换 .js 文件

    ```
    test: /\.js$/,
    ```

    3.2 使用babel loader进行 es6 转换

    ```
     loader: 'babel',
    ```

    3.3 latest 表示用最新的语法规则进行

    ```
    query:{
          presets: ['latest']
    }
    ```

  完整代码：

  ```
  module.exports = {
      entry: './a.js',
      output: {
          filename: 'bundle.js'
      },
      devServer: {
          port:8088
      },
      module: {
          loaders: [
              {
                  test: /\.js$/,
                  loader: 'babel',
                  query:{
                      presets: ['latest']
                  }
              }
          ]
      }
  }
  ```

- index.html

  ```
  <html>
      <head>
          <script src="bundle.js"></script>
      </head>
  </html>
  ```

- 运行 webpack

  首先运行 webpack, 会把 a.js 转换为 bundle.js . 此时的 bundle.js 就是已经转换好了的。
  打开 bundle.js 翻到最后几行，如图所示就已经是普通的 javascript 语句了。

- 运行

  运行如下命令启动测试：

  ```
  npm run dev
  ```

  转换之后，能够识别 ES6。

#### css-loader

- 版本兼容问题

  本教程建立在 cnpm 安装的如下webpack@1.13.2 和 webpack-dev-server@1.15.0 版本上，其他版本未经测试，不确保可用。

- css 模块

  在 webpack 的概念里，所有文件都是模块。 所以一个 css 文件也是模块。

  用 css-loader 和 style-loader 把 css 文件作为一个模块打包到 bundle.js 文件里

- 安装 css-loader 和 style-loader

  ```
  cnpm install style-loader@0.13.1 css-loader@0.25.0 --save-dev
  ```

- style.css

  ```
  body {
      background-color: blue;
  }
  ```

- webpack.config.js

  增加 style-loader 和 css-loader。 要使得css 起作用，得同时使用这两个 loader

  ```
  module.exports = {
      entry: './a.js',
      output: {
          filename: 'bundle.js'
      },
      devServer: {
          port:8088
      },
      module: { 
          loaders: [ 
              {
                  test: /\.js$/,
                  loader: 'babel',
                  query:{
                      presets: ['latest']
                  }
              },
              {
                  test:/\.css/,
                  loader:'style-loader!css-loader'
              }
          ]
      }
  }
  ```

- a.js

  修改a.js ，把 style.css 当作一个模块加进来

  ```
  require("./style.css")
  const name = 'ES6'
  document.write(`hello ${name}`)
  ```

- 运行

  ```
  npm run dev
  ```

#### 其他

- HtmlWebpackPlugin, ExtractTextPlugin, Image-loader略

- 关于 webpack 的看法

  webpack 面临的最大问题，就是其各种 loader, plugin 的兼容问题。

  webpack 所有相关的默认安装，都是安装的最新版本。 但是并不是所有对应工具的最新版本之间都是兼容的

  **webpack 本来是用来提高工作效率的，但是花在 webpack 本身的时间，比开发业务功能还花更多的时间**