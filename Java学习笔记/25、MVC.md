# MVC

> Hello MVC

- 仅仅使用Servlet的短处

  Servlet不仅要准备数据，还要准备html。 尤其是准备html，可读性非常差，维护起来也很麻烦

- 仅仅使用JSP的短处

  虽然编写html方便了，但是写java代码不如在Servlet中那么方便

- 结合Servlet和JSP

  **HeroEditServlet**：只用来从数据库中查询Hero对象，然后跳转到JSP页面

  服务端跳转到editHero.jsp，因为是服务端跳转，都属于**同一次请求**，所以可以在editHero.jsp通过request取出来

  **editHero.jsp:** 不做查询数据库的事情，直接获取从HeroEditServlet传过来的Hero对象，通过EL表达式把request中的hero显示出来

- MVC设计模式

  - M 代表 模型（**Model**）

    模型是什么呢？ 模型就是数据，就是dao,bean

  - V 代表 视图（**View**） 

    视图是什么呢？ 就是网页, JSP，用来展示模型中的数据

  - C 代表 控制器（**controller**) 

    控制器是什么？ 控制器用来把不同的数据，显示在不同的视图上。 在这个例子的，Servlet就是充当控制器的角色，把Hero对象，显示在JSP上。

    控制器的作用就是把不同的数据(Model)，显示在不同的视图(View)上。  