# Mybatis

> 入门

1. 创建实体类

   成员变量与数据库字段一一对应，包含setter、getter方法

2. 配置文件mybatis-config.xml

   - 在src目录下创建mybatis的主配置文件**mybatis-config.xml** ，其作用主要是提供连接数据库用的驱动，数据库名称，编码方式，账号密码以

   - 别名，自动扫描com.how2java.pojo下的类型，使得在后续配置文件Category.xml中使用resultType的时候，可以直接使用Category,而不必写全com.how2java.pojo.Category

     ```
     <typeAliases>
         <package name="com.how2java.pojo"/>
     </typeAliases>
     ```

   - 映射Category.xml

     ```
     <mappers>
         <mapper resource="com/how2java/pojo/Category.xml"/>
     </mappers>
     ```

   ```
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE configuration
   PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
   "http://mybatis.org/dtd/mybatis-3-config.dtd">
   <configuration>
   	<typeAliases>
   	  <package name="com.how2java.pojo"/>
   	</typeAliases>
       <environments default="development">
           <environment id="development">
               <transactionManager type="JDBC"/>
               <dataSource type="POOLED">
                   <property name="driver" value="com.mysql.jdbc.Driver"/>
                   <property name="url" value="jdbc:mysql://localhost:3306/how2java?characterEncoding=UTF-8"/>
                   <property name="username" value="root"/>
                   <property name="password" value="admin"/>
               </dataSource>
           </environment>
       </environments>
       <mappers>
           <mapper resource="com/how2java/pojo/Category.xml"/>
       </mappers>
   </configuration>
   ```

3. 配置文件Category.xml

   在包com.how2java.pojo下，新建文件**Category.xml**

   ```
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE mapper
   	PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
   	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   
   	<mapper namespace="com.how2java.pojo">
   	    <select id="listCategory" resultType="Category">
   	        select * from   category_      
   	    </select>
   	</mapper>
   ```

   ```
   namespace="com.how2java.pojo" 
   ```

   表示命名空间是com.how2java.pojo，在后续调用sql语句的时候，会用到它

   ```
   <select id="listCategory" resultType="Category">
   	select * from   category_     
   </select>
   ```

   这条sql语句用id: **listCategory** 进行标示以供后续代码调用。

   **resultType="Category"** 表示返回的数据和Category关联起来，这里本应该使用的是 com.how2java.pojo.Category, 但是因为上一步配置了别名，所以直接使用Category就行了

4. 测试类TestMybatis

   ```
   String resource = "mybatis-config.xml";
   InputStream inputStream = Resources.getResourceAsStream(resource);
   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
   SqlSession session=sqlSessionFactory.openSession();
   List<Category> cs=session.selectList("listCategory");
   ```

5. 总结

   1. 应用程序找Mybatis要数据

   2. mybatis从数据库中找来数据

      2.1 通过mybatis-config.xml 定位哪个数据库

      2.2 通过Category.xml执行对应的select语句

      2.3 基于Category.xml把返回的数据库记录封装在Category对象中

      2.4 把多个Category对象装在一个Category集合中

   3. 返回一个Category集合

> CRUD

- 配置文件Category.xml

  ```
  <?xml version="1.0" encoding="UTF-8"?>
  <!DOCTYPE mapper
  	PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
  	<mapper namespace="com.how2java.pojo">
  	    <insert id="addCategory" parameterType="Category" >
  	        insert into category_ ( name ) values (#{name})    
  	    </insert>
  	    
  	    <delete id="deleteCategory" parameterType="Category" >
  	        delete from category_ where id= #{id}   
  	    </delete>
  	    
  	    <select id="getCategory" parameterType="_int" resultType="Category">
  	        select * from   category_  where id= #{id}    
  	    </select>
  
  	    <update id="updateCategory" parameterType="Category" >
  	        update category_ set name=#{name} where id=#{id}    
  	    </update>
  	    <select id="listCategory" resultType="Category">
  	        select * from   category_      
  	    </select>	    
  	</mapper>
  ```

- 增加

  通过session.insert调用addCategory对应的SQL语句：

  ```
  Category c = new Category();
  c.setName("新增加的Category");
  session.insert("addCategory",c);
  ```

  addCategory对应的插入sql语句，#{name}会自动获取c对象的name属性值：

  ```
  <insert id="addCategory" parameterType="Category" >
      insert into category_ ( name ) values (#{name})    
  </insert>
  ```

- 删除

  删除id=6的对象：

  ```
  Category c = new Category();
  c.setId(6);
  session.delete("deleteCategory",c);
  ```

  deleteCategory对应删除的sql语句：

  ```
  <delete id="deleteCategory" parameterType="Category" >
      delete from category_ where id= #{id}   
  </delete>
  ```

- 获取

  通过session.selectOne获取id=3的记录：

  ```
  Category c= session.selectOne("getCategory",3);
  ```

  getCategory对应的sql语句：

  ```
  <select id="getCategory" parameterType="_int" resultType="Category">
      select * from   category_  where id= #{id}    
  </select>
  ```

- 修改

  通过session.update进行修改：

  ```
  session.update("updateCategory",c);
  ```

  updateCategory对应的sql语句：

  ```
  <update id="updateCategory" parameterType="Category" >
      update category_ set name=#{name} where id=#{id}    
  </update>
  ```

- 查询所有

  session.selectList执行查询语句：

  ```
  List<Category> cs = session.selectList("listCategory");
  ```

  listCategory对应的sql语句：

  ```
  <select id="listCategory" resultType="Category">
      select * from   category_      
  </select>
  ```

> 更多查询

- 模糊查询

  例：

  ```
  <select id="listCategoryByName"  parameterType="string" resultType="Category">
  	select * from   category_  where name like concat('%',#{0},'%')
  </select>   
  ```

  **concat('%',#{0},'%')** 这是mysql的写法

  测试代码：

  ```
  List<Category> cs = session.selectList("listCategoryByName","cat");
  ```

- 多条件查询

  例：

  ```
  <select id="listCategoryByIdAndName"  parameterType="map" resultType="Category">
      select * from   category_  where id> #{id}  and name like concat('%',#{name},'%')
  </select>
  ```

  测试代码：

  ```
  Map<String,Object> params = new HashMap<>();
  params.put("id", 3);
  params.put("name", "cat");
  List<Category> cs = session.selectList("listCategoryByIdAndName",params);
  ```

> 一对多

​	例：

​		通过left join关联查询，对Category和Product表进行关联查询。

```
<mapper namespace="com.how2java.pojo">
	<resultMap type="Category" id="categoryBean">
    	<id column="cid" property="id" />
    	<result column="cname" property="name" />

		<!-- 一对多的关系 -->
		<!-- property: 指的是集合属性的值, ofType：指的是集合中元素的类型 -->
		<collection property="products" ofType="Product">
			<id column="pid" property="id" />
			<result column="pname" property="name" />
			<result column="price" property="price" />
		</collection>
	</resultMap>
	<!-- 关联查询分类和产品表 -->
   	<select id="listCategory" resultMap="categoryBean">
            select c.*, p.*, c.id 'cid', p.id 'pid', c.name 'cname', p.name 'pname' from category_ c left join product_ p on c.id = p.cid
    </select>   
 </mapper>
```

这里不是用的resultType, 而是resultMap，通过resultMap把数据取出来放在**对应的** 对象属性里。

注： Category的id 字段 和Product的id字段同名，Mybatis不知道谁是谁的，所以需要通过取别名cid,pid来		区分，name字段同理。

> 多对一

- 修改Product.java

  为Product增加category属性：

  ```
  private Category category;
       
  public Category getCategory() {
       return category;
  }
  public void setCategory(Category category) {
       this.category = category;
  }
  ```

- Product.xml

  通过resultMap ，进行字段和属性的对应。

  使用association 进行多对一关系关联，指定表字段名称与对象属性名称的一一对应关系

  **注：** Category的id 字段 和Product的id字段同名，Mybatis不知道谁是谁的，所以需要通过取别名cid,pid来区分，name字段同理。

  ```
  <resultMap type="Product" id="productBean">
  	<id column="pid" property="id" />
  	<result column="pname" property="name" />
  	<result column="price" property="price" />
  
  	<!-- 多对一的关系 -->
  	<!-- property: 指的是属性名称, javaType：指的是属性的类型 -->
  	<association property="category" javaType="Category">
  		<id column="cid" property="id"/>
  		<result column="cname" property="name"/>
  	</association>
  </resultMap>
       
  <!-- 根据id查询Product, 关联将Orders查询出来 -->
  <select id="listProduct" resultMap="productBean">
  	select c.*, p.*, c.id 'cid', p.id 'pid', c.name 'cname', p.name 'pname' from category_ c left join product_ p on c.id = p.cid
  </select>   
  ```

- 修改product的cid

  - 方法一：

    ```
    Product p = session.selectOne("getProduct", 5);
    Category c = session.selectOne("getCategory", 1);
    p.setCategoy(c);
    p.setName("newName");
    session.update("updateProductCategory", p);
    ```

  - 方法二：

    ```
    Map<String, String> map = new HashMap<>();
    map.put("cid", "11");
    map.put("id", "5");
    session.update("updateProduct", map);
    ```

- JavaType和ofType的区别

  JavaType和ofType都是用来指定对象类型的，其区别是：

  - JavaType是用来指定pojo中属性的类型(如：Product的Category类型的属性category)
  - ofType指定的是映射到list集合属性中pojo的类型(如：Category的集合属性products)

- mapper映射的id名称一样

  加namespace进行区别：	

  ```
  <mapper namespace="com.domain.package1">
  	<select id="id1" resultType="Class1">
        ......         
      </select>
  </mapper>
  <mapper namespace="com.domain.package2">
  	<select id="id1" resultType="Class1">
        ......         
      </select>
  </mapper>
  ```

> 多对多

- 实体类Order和OrderItem

  OrderItem：

  ```
  private Order order;
  private Product product;	
  public Order getOrder() {
  	return order;
  }
  public void setOrder(Order order) {
  	this.order = order;
  }
  public Product getProduct() {
  	return product;
  }
  public void setProduct(Product product) {
  	this.product = product;
  }
  ```

  Order：

  ```
  List<OrderItem> orderItems;
  public List<OrderItem> getOrderItems() {
  	return orderItems;
  }
  public void setOrderItems(List<OrderItem> orderItems) {
  	this.orderItems = orderItems;
  }
  ```

- 映射文件

  Order.xml：

  ```
  <resultMap type="Order" id="orderBean">
      <id column="oid" property="id" />
      <result column="code" property="code" />
      <collection property="orderItems" ofType="OrderItem">
          <id column="oiid" property="id" />
          <result column="number" property="number" />
          <association property="product" javaType="Product">
              <id column="pid" property="id"/>
              <result column="pname" property="name"/>
              <result column="price" property="price"/>
          </association>               
      </collection>
  </resultMap>
  <select id="listOrder" resultMap="orderBean">
      select o.*,p.*,oi.*, o.id 'oid', p.id 'pid', oi.id 'oiid', p.name 'pname'
          from order_ o
          left join order_item_ oi    on o.id =oi.oid
          left join product_ p on p.id = oi.pid
  </select>
  <select id="getOrder" resultMap="orderBean">
  	select o.*,p.*,oi.*, o.id 'oid', p.id 'pid', oi.id 'oiid', p.name 'pname'
      	from order_ o
         	left join order_item_ oi on o.id =oi.oid
          left join product_ p on p.id = oi.pid
         	where o.id = #{id}
  </select>                  
  ```

  OrderItem.xml：

  ```
  <insert id="addOrderItem" parameterType="OrderItem">
   	insert into order_item_
   		values(null,#{order.id},#{product.id},#{number})
  </insert>   
  <insert id="deleteOrderItem" parameterType="OrderItem">
   	delete from order_item_
   		where oid = #{order.id} and pid = #{product.id}
  </insert>   
  ```

- 查询操作

  ```
  <resultMap type="Order" id="orderBean">
  	<id column="oid" property="id" />
  	<result column="code" property="code" />
  	
  	<collection property="orderItems" ofType="OrderItem">
  		<id column="oiid" property="id" />
  		<result column="number" property="number" />
  		<association property="product" javaType="Product">
  			<id column="pid" property="id"/>
  			<result column="pname" property="name"/>
  			<result column="price" property="price"/>
  		</association>				
  	</collection>
  </resultMap>
  ```

  查询结果 id和code字段放在Order对象里

  然后通过一对多的<collection>标签把oiid和number放在OrderItem对象里

  最后把pid,pname,price放进Product对象里

- 建立关系

  ```
  Order o1 = session.selectOne("getOrder", 1);
  Product p6 = session.selectOne("getProduct", 6);
  OrderItem oi = new OrderItem();
  oi.setProduct(p6);
  oi.setOrder(o1);
  oi.setNumber(200);
  session.insert("addOrderItem", oi);
  ```

  首先通过id分别获取Order对象和Product对象，然后创建一个新的OrderItem对象，接着设置Order，设置Product，设置数量，最后调用"addOrderItem" 对应的sql语句插入数据。

  addOrderItem调用insert into 语句插入一条OrderItem记录：

  ```
  <insert id="addOrderItem" parameterType="OrderItem">
  	insert into order_item_ 
  		values(null,#{order.id},#{product.id},#{number})
  </insert> 
  ```

- 删除关系

  ```
  Order o1 = session.selectOne("getOrder",1);
  Product p6 = session.selectOne("getProduct",6);
  OrderItem oi = new OrderItem();
  oi.setProduct(p6);
  oi.setOrder(o1);
  session.delete("deleteOrderItem", oi);  
  ```

  deleteOrderItem对应的SQL语句：

  ```
  <insert id="deleteOrderItem" parameterType="OrderItem">
  	delete from order_item_ 
  		where oid = #{order.id} and pid = #{product.id}
  </insert>
  ```

> 动态SQL

- if

  执行不同的条件限定，需要准备两条sql语句。

  假设需要对Product执行两条sql语句，一个是查询所有，一个是根据名称模糊查询。
  那么按照现在的方式，必须提供两条sql语句：listProduct和listProductByName

  如果Product的字段比较多的话，为了应付各个字段的查询，那么就需要写多条sql语句，这样就变得难以维护。
  这个时候，就可以使用Mybatis 动态SQL里的if标签

  ```
  <select id="listProduct" resultType="Product">
  	select * from product_
  	<if test="name!=null">
  		where name like concat('%',#{name},'%')
  	</if>		 	
  </select>
  ```

  ```
  System.out.println("查询所有的");
  List<Product> ps = session.selectList("listProduct");
  System.out.println("模糊查询");
  Map<String,Object> params = new HashMap<>();
  params.put("name","a");
  List<Product> ps2 = session.selectList("listProduct",params);
  ```

- where

  - 多条件的矛盾，例：

    ```
    <select id="listProduct" resultType="Product">
    	select * from product_
    	<if test="name!=null">
    		where name like concat('%',#{name},'%')
    	</if>		 	
    	<if test="price!=0">
    		and price > #{price}
    	</if>		 	
    </select>
    ```

    这么写的问题是：当没有name参数，却有price参数的时候，执行的sql语句就会是：

    ```
    select * from product_ and price > 10.
    ```

    这样执行就会报错

  - 这个问题可以通过<where>标签来解决：

    ```
    <select id="listProduct" resultType="Product">
    	select * from product_
    	<where>
    		<if test="name!=null">
    			and name like concat('%',#{name},'%')
    		</if>		 	
    		<if test="price!=null and price!=0">
    			and price > #{price}
    		</if>	
    	</where>	 	
    </select>
    ```

    <where>标签会进行自动判断
    如果任何条件都不成立，那么就在sql语句里就不会出现where关键字
    如果有任何条件成立，会自动去掉多出来的 and 或者 or。

    所以在测试代码里

    ```
    Map<String,Object> params = new HashMap<>(); 
    //params.put("name","a");
    params.put("price","10");
    ```

    这个参数map，无论是否提供值否都可以正常执行

  - set标签

    与[where标签](http://how2j.cn/k/mybatis/mybatis-where/1114.html#step4271)类似的，在update语句里也会碰到多个字段相关的问题。

    ```
    <set>
    	<if test="name != null">name=#{name},</if>
    	<if test="price != null">price=#{price}</if>
    </set>
    ```

    其效果与where标签类似，有数据的时候才进行设置，并且会自动去掉多出来的,

  - trim标签

    trim 用来去除指定的字符，比如where标签就可以用trim去除多余的and或or，set标签就可以用trim去除多余的,

    ```
    <trim prefix="WHERE" prefixOverrides="AND |OR ">
      ... 
    </trim>
    ```

    ```
    <trim prefix="SET" suffixOverrides=",">
      ...
    </trim>
    ```

  - ">"和“<”

    mybatis中 xml文件不支持 大于号 小于号，有两种方法可以解决：

    ```
    第一种：SELECT * FROM test WHERE ``1` `= ``1` `AND start_date  &lt;= CURRENT_DATE AND end_date &gt;= CURRENT_DATE
    ```

    ```
    第二种：<![CDATA[ when min(starttime)<=``'12:00'` `and max(endtime)<=``'12:00'` `]]>
    ```

- choose

  Mybatis里面没有else标签，但是可以使用when otherwise标签来达到if else 一样的效果。

  ```
  <select id="listProduct" resultType="Product">
  	  SELECT * FROM product_ 
  	  <where>
  	  	<choose>
  		  <when test="name != null">
  		    and name like concat('%',#{name},'%')
  		  </when>			  
  		  <when test="price !=null and price != 0">
  		    and price > #{price}
  		  </when>			  		
  	  	  <otherwise>
  	  	  	and id >1
  	  	  </otherwise>
  	  	</choose>
  	  </where>
  </select>
  ```

  其作用是： 提供了任何条件，就进行条件查询，否则就使用id>1这个条件。

  注：有多个when标签 符合条件时，只会执行第一个符合条件的when标签里的语句，类似于switch case加break的情况。

- foreach

  foreach标签通常用于in 这样的语法里：

  ```
  <select id="listProduct" resultType="Product">
  	SELECT * FROM product_
      	WHERE ID in
          	<foreach item="item" index="index" collection="list"
              open="(" separator="," close=")">
              	#{item}
              </foreach>
  </select>
  ```

  ```
  List<Integer> ids = new ArrayList();
  ids.add(1);
  ids.add(3);
  ids.add(5);
  List<Product> ps = session.selectList("listProduct",ids);
  ```

  - collection ：collection属性的值有三个分别是list、array、map三种，分别对应的参数类型为：List、数组、map集合，上面传的参数为List，所以值为list
  - item ： 表示在迭代过程中每一个元素的别名
  - index ：表示在迭代过程中每次迭代到的位置（下标）
  - open ：前缀
  - close ：后缀
  - separator ：分隔符，表示迭代时每个元素之间以什么分隔

- bind

  bind标签就像是再做一次字符串拼接，方便后续使用：

  ```
  <!-- 本来的模糊查询方式 -->
  <!-- <select id="listProduct" resultType="Product"> -->
  <!-- select * from   product_  where name like concat('%',#{0},'%') -->
  <!-- </select> -->
  
  <!-- bind方式 -->
  <select id="listProduct" resultType="Product">
  	<bind name="likename" value="'%' + name + '%'" />
  	select * from   product_  where name like #{likename}
  </select>
  ```

  - bind标签作用是 ,创建一个变量并将其绑定到上下文.

  - bind取代模糊查询的好处是提高了代码的可移植性。
    在进行模糊查询时，如果是MySQL数据库，常常用到的是一个concat，它用'%'和参数相连。然而在Oracle数据库则没有，Oracle数据库用连接符号”||“。
    当我们有了bind元素，就不必使用数据库语言，而是使用MyBatis的动态SQL即可完成。