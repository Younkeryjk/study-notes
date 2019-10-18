# SQL基础教程

## 数据库和SQL

#### 数据库是什么

###### 重点

- 用来管理数据库的计算机系统称为数据库管理系统（DBMS）。
- 关系数据库通过关系数据库管理系统（RDBMS）进行管理。

###### 我们身边的数据库

###### 为什么DBMS那么重要

###### DBMS的种类

#### 数据库的结构

###### 重点

- RDBMS通常使用客户端/服务器这样的系统结构。
- 通过从客户端向服务器端发送SQL语句来实现数据库的读写操作。
- 关系数据库采用被称为数据库表的二维表来管理数据。
- 数据库表由表示数据项目的列（字段）和表示一条数据的行（记录）所组成，以记录为单位进行数据读写。
- 将行和列交汇的方格称为单元格，每个单元格只能输入一个数据。

###### RDBMS的常见系统结构

###### 表的结构

#### SQL概要

###### 重点

- SQL是为操作数据库而开发的语言。
- 虽然SQL也有标准，但实际上根据RDBMS的不同SQL也不尽相同。
- SQL通过一条语句来描述想要进行的操作，发送给RDBMS。
- 原则上SQL语句都会使用分号结尾。
- SQL根据操作目的可以分为DDL、DML和DCL。

###### 标准SQL

###### SQL语句及其种类

- SQL根据功能不同可以分为三类，实际使用的 SQL 语句当中有 90% 属于 DML。

- DDL

  （Data Definition Language，数据定义语言） 用来创建或者删除存储数据用的数据库以及数据库中的表等对象。DDL 包含以下几种指令：

  1. CREATE ： 创建数据库和表等对象
  2. DROP ： 删除数据库和表等对象
  3. ALTER ： 修改数据库和表等对象的结构

- DML

  DML（Data Manipulation Language，数据操纵语言） 用来查询或者变更表中的记录。DML 包含以下几种指令：

  1. SELECT ：查询表中的数据
  2. INSERT ：向表中插入新数据
  3. UPDATE ：更新表中的数据
  4. DELETE ：删除表中的数据

- DCL

  DCL（Data Control Language，数据控制语言） 用来确认或者取消对数据库中的数据进行的变更。除此之外，还可以对 RDBMS 的用户是否有权限操作数据库中的对象（数据库表等）进行设定。DCL 包含以下几种指令：

  1. COMMIT ： 确认对数据库中的数据进行的变更
  2. ROLLBACK ： 取消对数据库中的数据进行的变更
  3. GRANT ： 赋予用户操作权限
  4. REVOKE ： 取消用户的操作权限

###### SQL的基本书写规则

- SQL语句要以分号（ ; ）结尾
- SQL语句不区分大小写
- 字符串和日期常数需要使用单引号（'）括起来。数字常数无需加注单引号（直接书写数字即可）。
- 单词需要用半角空格或者换行来分隔

#### 表的创建

###### 重点

- 表通过 CREATE TABLE 语句创建而成。
- 表和列的命名要使用有意义的文字。
- 指定列的数据类型（整数型、字符型和日期型等）。
- 可以在表中设置约束（主键约束和 NOT NULL 约束等）。

###### 表的内容的创建

###### 数据库的创建（ CREATE DATABASE 语句）

- CR EAT E DATABASE < 数据库名称 > ;

###### 表的创建（ CREATE TABLE 语句）

```
CREATE TABLE < 表名 >
（ < 列名 1> < 数据类型 > < 该列所需约束 > ，
< 列名 2> < 数据类型 > < 该列所需约束 > ，
< 列名 3> < 数据类型 > < 该列所需约束 > ，
< 列名 4> < 数据类型 > < 该列所需约束 > ，
.
.
.
< 该表的约束 1> ， < 该表的约束 2> ，……）；
```

###### 命名规则

- 数据库名称、表名和列名等可以使用以下三种字符。
  - 半角英文字母
  - 半角数字
  - 下划线（_）
- 名称必须以半角英文字母作为开头。
- 名称不能重复。

###### 数据类型的指定

- 数据类型分3中：

  1. 数字型
  2. 字符型
  3. 日期型

-  INTEGER 型

  用来指定存储整数的列的数据类型（数字型），不能存储小数。

- CHAR 型

  CHAR 是 CHARACTER（字符）的缩写，是用来指定存储字符串的列的数据类型（字符型）。

  **字符串以 定长字符串 的形式存储在被指定为 CHAR 型的列中，定长字符串在字符数未达到最大长度时会用半角空格补足。**

  **虽然之前我们说过 SQL 不区分英文字母的大小写，但是表中存储的字符串却是区分大小写的。**

-  VARCHAR 型

  同 CHAR 类型一样， VARCHAR 型也是用来指定存储字符串的列的数据类型（字符串类型）。

  **该类型的列是以 可变长字符串 的形式来保存字符串的，即使字符数未达到最大长度，也不会用半角空格补足。**

  例如，我们向 VARCHAR(8) 类型的列中输入字符串 ' abc ' 的时候，保存的就是字符串 ' abc ' 。

- DATE 型

  用来指定存储日期（年月日）的列的数据类型（日期型）。

###### 约束的设置

- NOT NULL 约束

- 主键约束

  PRIMARY KEY (product_id)

#### 表的删除和更新

###### 重点

- 使用 DROP TABLE 语句来删除表。
- 使用 ALTER TABLE 语句向表中添加列或者从表中删除列。

###### 表的删除（ DROP TABLE 语句）

```
DROP TABLE < 表名 > ；
```

###### 表定义的更新（ ALTER TABLE 语句）

- 添加列的 ALTER TABLE 语句

  ```
  ALTER TABLE < 表名 > ADD COLUMN < 列的定义 > ；
  ```

  ```
  Oracle和SQL Server中不用写 COLUMN 。
  ALTER TABLE < 表名 > ADD < 列名 > ；
  另外，在Oracle中同时添加多列的时候，可以像下面这样使用括号。
  ALTER TABLE < 表名 > ADD （ < 列名 > ， < 列名 > ，……）；
  ```

- 删除列的 ALTER TABLE 语句

  ```
  ALTER TABLE < 表名 > DROP COLUMN < 列名 > ；
  ```

  ```
  Oracle中不用写 COLUMN 。
  ALTER TABLE < 表名 > DROP < 列名 > ；
  另外，在Oracle中同时删除多列的时候，可以像下面这样使用括号来实现。
  ALTER TABLE < 表名 > DROP （ < 列名 > ， < 列名 > ，……）；
  ```

- 变更表名

  ```
  -- Oracle PostgreSQL
  ALTER TABLE Poduct RENAME TO Product;
  -- DB2
  RENAME TABLE Poduct TO Product;
  -- SQL Server
  sp_rename 'Poduct', 'Product';
  -- MySQL
  RENAME TABLE Poduct to Product;
  ```

## 查询基础

#### SELECT 语句基础

###### 重点

- 使用 SELECT 语句从表中选取数据。
- 为列设定显示用的别名。
- SELECT 语句中可以使用常数或者表达式。
- 通过指定 DISTINCT 可以删除重复的行。
- SQL语句中可以使用注释。
- 可以通过 WHERE 语句从表中选取出符合查询条件的数据。

###### 列的查询

- 通过 SELECT 语句查询并选取出必要数据的过程称为匹配查询或查询（query）
- 子句是 SQL 语句的组成要素，是以 SELECT 或者 FROM 等作为起始的短语。
- **查询结果中列的顺序和SELECT 子句中的顺序相同**

###### 查询出表中所有的列

- **如果使用星号的话，就无法设定列的显示顺序了， 这时就会按照 CREATE TABLE 语句的定义对列进行排序。**
- **SQL 语句使用换行符或者半角空格来分隔单词，在任何位置进行分隔都可以，但插入空行（无任何字符的行）会造成执行错误**

###### 为列设定别名

- AS 关键字
- 别名可以使用中文，使用中文时需要用双引号（"）括起来

###### 常数的查询

- 使用字符串或者日期常数时，必须使用单引号( ' )将其括起来，数字则不用。

###### 从结果中删除重复行

- 在 SELECT 语句中使用 DISTINCT 可以删除重复行

- **在使用 DISTINCT 时， NULL 也被视为一类数据。 NULL 存在于多行中时 ， 也会被合并为一条 NULL 数据**

- 在多列之前使用 DISTINCT

  ```
  SELECT DISTINCT product_type, regist_date
  FROM Product;
  ```

  product _ type 列为 ' 厨房用具 ' ，同时regist _ date 列为 '2009-09-20' 的两条数据被合并成了一条。

- DISTINCT 关键字只能用在第一个列名之前，因此不能写成 regist _ date , DISTINCT product _ type 

###### 根据 WHERE 语句来选择记录

- SELECT 语句通过 WHERE 子句来指定查询数据的条件
- 条件表达式：WHERE 子句中的“ product _ type = ' 衣服 ' ”就是用来表示查询条件的表达式（条件表达式）。
- 执行顺序：首先通过WHERE 子句查询出符合指定条件的行，然后再选取出 SELECT 语句指定的列
- SQL 中子句的书写顺序是固定的，不能随意更改；。 WHERE 子句必须紧跟在 FROM 子句之后

###### 注释的书写方法

- 1行注释：书写在“--”之后，只能写在同一行。
- 多行注释：书写在 /* 和  */ 之间，可以跨多行。

#### 算术运算符和比较运算符

###### 重点

- 运算符就是对其两边的列或者值进行运算（计算或者比较大小等）的符号。
- 使用算术运算符可以进行四则运算。
- 括号可以提升运算的优先顺序（优先进行运算）。
- 包含 NULL 的运算，其结果也是 NULL 。
- 比较运算符可以用来判断列或者值是否相等，还可以用来比较大小。
- 判断是否为 NULL ，需要使用 IS NULL 或者 IS NOT NULL 运算符。

###### 算术运算符

- SQL语句中可以使用运算表达式

  ```
  SELECT sale_price * 2 AS "sale_price_x2"
  FROM Product;
  ```

###### 需要注意 NULL

- 所有包含 NULL 的计算，结果肯定是 NULL 

  通常情况下，类似 5/0 这样除数为 0 的话会发生错误，只有 NULL 除以 0 时不会发生错误，并且结果还是 NULL 。

###### 比较运算符

- 像符号 = 这样用来比较其两边的列或者值的符号称为比较运算符

- <>运算符

- 一定要让不等号在左，等号在右。

-  WHERE 子句的条件表达式中也可以使用计算表达式，可以使用比较运算符对计算结果进行比较

  ```
  WHERE sale_price - purchase_price >= 500;
  ```

###### 对字符串使用不等号时的注意事项

- 字符串类型的数据原则上按照字典顺序进行排序，不能与数字的大小顺序混淆。

###### 不能对 NULL 使用比较运算符

- 希望选取不是 NULL 的记录时，需要使用 IS NOT NULL 运算符

#### 逻辑运算符

###### 重点

- 通过使用逻辑运算符，可以将多个查询条件进行组合。
- 通过 NOT 运算符可以生成“不是~”这样的查询条件。
- 两边条件都成立时，使用 AND 运算符的查询条件才成立。
- 只要两边的条件中有一个成立，使用 OR 运算符的查询条件就可以成立。
- 值可以归结为真（ TRUE ）和假（ FALSE ）其中之一的值称为真值。比较运算符在比较成立时返回真，不成立时返回假。但是，在SQL中还存在另外一个特定的真值——不确定（UNKNOWN）。
- 将根据逻辑运算符对真值进行的操作及其结果汇总成的表称为真值表。
- SQL中的逻辑运算是包含对真、假和不确定进行运算的三值逻辑。

###### NOT 运算符

- 想要指定“不是 ~”这样的否定条件时，需要使用 <> 运算符。除此之外还可以使用范围更
  广的运算符 NOT
- 不使用 NOT 运算符的查询条件更容易让人理解。使用 NOT 运算符时，我们不得不每次都在脑海中进行“大于等于 1000日元以上这个条件的否定就是小于 1000日元”这样的转换。

###### AND 运算符和 OR 运算符

- AND 运算符(集合中的交集)
- OR 运算符(集合中的并集)

###### 使用括号强化处理

- AND 运算符的优先级高于 OR 运算符。想要优先执行 OR 运算符时可以使用括号。

###### 逻辑运算符和真值

- 逻辑运算符： NOT 、 AND 和 OR；逻辑就是对真值进行操作的意思
- 真值就是值为真（ TRUE ）或假（ FALSE ）其中之一的值，在SQL中还存在“不确定”
  （UNKNOWN）这样的值

###### 含有 NULL 时的真值

- 只有 SQL 中的逻辑运算被称为三值逻辑：真、假、不确定

- 考虑 NULL 时的条件判断也会变得异常复杂，因此创建表时要给某些列设置 设置 NOT NULL 约束

## 聚合与排序

#### 对表进行聚合查询

###### 重点

- 使用聚合函数对表中的列进行计算合计值或者平均值等的汇总操作。
- 通常，聚合函数会对 NULL 以外的对象进行汇总。但是只有 COUNT 函数
  例外，使用 COUNT （*）可以查出包含 NULL 在内的全部数据的行数。
- 使用 DISTINCT 关键字删除重复值。

###### 聚合函数

- COUNT
- SUM 
- AVG
- MAX
- MIN
- 用于汇总的函数称为聚合函数或者聚集函数；聚合，就是将多行汇总为一行

###### 计算表中数据的行数

- COUNT ( *) 中的星号，即此处的输入值称为参数或者 parameter，执行结果称为返回值

###### 计算 NULL 之外的数据的行数

- COUNT 函数的结果根据参数的不同而不同。 COUNT (*) 会得到包含 NULL 的数据行数，而 COUNT (< 列名 >) 会得到 NULL 之外的数据行数。

###### 计算合计值

- 对于 SUM 函数来说，即使包含 NULL ，也可以计算出合计值
- **所有的聚合函数，如果以列名为参数，那么在计算之前就已经把NULL 排除在外了**；
- 所有的聚合函数使用中，只有COUNT (*)不会排除 NULL 。

###### 计算平均值

- **AVG会事先删除 NULL再进行计算平均值，但列的个数也会去除，导致计算平均数结果出错**

###### 计算最大值和最小值

-  MAX / MIN 函数几乎适用于所有数据类型的列。 SUM / AVG 函数只适用于数值类型的列。

  ```
  SELECT MAX(regist_date), MIN(regist_date)
  FROM Product;
  ```

###### 使用聚合函数删除重复值（关键字 DISTINCT ）

- 想要计算值的种类时，可以在 COUNT 函数的参数中使用 DISTINCT 。

  ```
  SELECT COUNT(DISTINCT product_type)
  FROM Product;
  ```

  **这时 DISTINCT 必须写在括号中。这是因为必须要在计算行数之前删除 product _ type 列中的重复数据。**

- 在聚合函数的参数中使用 DISTINCT ，可以删除重复数据。

  不仅限于 COUNT 函数，所有的聚合函数都可以使用 DISTINCT 

  ```
  SELECT SUM(sale_price), SUM(DISTINCT sale_price)
  FROM Product;
  ```

  

#### 对表进行分组

###### 重点

- 使用 GROUP BY 子句可以像切蛋糕那样将表分割。通过使用聚合函数和GROUP BY 子句，可以根据“商品种类”或者“登记日期”等将表分割后再进行汇总。
- 聚合键中包含 NULL 时，在结果中会以“不确定”行（空行）的形式表现出来。
- 使用聚合函数和 GROUP BY 子句时需要注意以下4点。
  ① 只能写在 SELECT 子句之中
  ② GROUP BY 子句中不能使用 SELECT 子句中列的别名
  ③ GROUP BY 子句的聚合结果是无序的
  ④ WHERE 子句中不能使用聚合函数

###### GROUP BY 子句

- 聚合建：在 GROUP BY 子句中指定的列称为聚合键或者分组列
- GROUP BY 就像是切分表的一把刀。
-  GROUP BY 子句的书写位置也有严格要求，一定要写在FROM 语句之后（如果有 WHERE 子句的话需要写在 WHERE 子句之后）。

###### 聚合键中包含 NULL 的情况

- 聚合键中包含 NULL 时，在结果中会以NULL(“不确定”)行（空行）的形式表现出来。

###### 使用 WHERE 子句时 GROUP BY 的执行结果

- 执行顺序

  GROUP BY 和 WHERE 并用时， SELECT 语句的执行顺序：FROM → WHERE → GROUP BY → SELECT

###### 与聚合函数和 GROUP BY 子句有关的易错点

1. 使用 GROUP BY 子句时， SELECT 子句中不能出现聚合键之外的列名。

   使用聚合函数时， SELECT 子句中只能存在以下三种元素：

   1. 常数
   2. 聚合函数
   3. GROUP BY 子句中指定的列名（也就是聚合键）(**MySQL可以这样使用，但在其他 DBMS 中并不是通用的，因此不要使用。**)

2. 在 GROUP BY 子句中不能使用 SELECT 子句中定义的别名。

   原因是 SQL 语句在 DBMS内部的执行顺序造成的—— SELECT 子句在 GROUP BY 子句之后执行。
   在执行 GROUP BY 子句时， SELECT 子句中定义的别名，DBMS 还并不知道。

   **MySQL可以这样使用，但在其他 DBMS 中并不是通用的，因此不要使用。**

3. GROUP BY 子句结果的显示是无序的。

4. 只有 SELECT 子句和 HAVING 子句（以及 ORDER BY 子句）中能够使用聚合函数。

###### DISTINCT 和 GROUP BY

都能够删除后续列中的重复数据

**在“想要删除选择结果中的重复记录”时使用 DISTINCT ，在“想要计算汇总结果”时使用 GROUP BY 。**

不使用 COUNT 等聚合函数进行汇总，而只使用 GROUP BY 子句的 SELECT 语句，会让人觉得非常奇怪

#### 为聚合结果指定条件

###### 重点

- 使用 COUNT 函数等对表中数据进行汇总操作时，为其指定条件的不是
  WHERE 子句，而是 HAVING 子句。
- 聚合函数可以在 SELECT 子句、 HAVING 子句和 ORDER BY 子句中使用。
- HAVING 子句要写在 GROUP BY 子句之后。
- WHERE 子句用来指定数据行的条件， HAVING 子句用来指定分组的条件。

###### HAVING 子句

-  WHERE子句只能指定记录（行）的条件，而不能用来指定组的条件（例如，“数
  据行数为 2 行”或者“平均值为 500”等）。
- 书写顺序：HAVING 子句必须写在 GROUP BY 子句之后
- 执行顺序：SELECT → FROM → WHERE → GROUP BY → HAVING

###### HAVING 子句的构成要素

- HAVING 子句和包含 GROUP BY 子句时的 SELECT 子句一样，能够使用的要素有一定的限制，限制内容也是完全相同的。HAVING 子句中只能存在以下三种元素：
  1. 常数
  2. 聚合函数
  3. GROUP BY 子句中指定的列名（也就是聚合键）(**MySQL可以这样使用，但在其他 DBMS 中并不是通用的，因此不要使用。**)

###### 相对于 HAVING 子句，更适合写在 WHERE 子句中的条件

- **聚合键所对应的条件不应该书写在 HAVING 子句当中，而应该书写在 WHERE 子句当中。**

  WHERE 子句 = 指定行所对应的条件

  HAVING 子句 = 指定组所对应的条件

- WHERE执行速度优势

  1. 通过 WHERE 子句指定条件时，由于排序之前就对数据进行了过滤，因此能够减少排序的数据量。但 HAVING 子句是在排序之后才对数据进行分组的，因此与在 WHERE 子句中指定条件比起来，需要排序的数据量就会多得多。
  2. 另一个理由是可以对 WHERE 子句指定条件所对应的列创建索引，这样也可以大幅提高处理速度

#### 对查询结果进行排序

###### 重点

- 使用 ORDER BY 子句对查询结果进行排序。
- 在 ORDER BY 子句中列名的后面使用关键字 ASC 可以进行升序排序，使用 DESC 关键字可以进行降序排序。
- ORDER BY 子句中可以指定多个排序键。
- 排序健中包含 NULL 时，会在开头或末尾进行汇总。
- ORDER BY 子句中可以使用 SELECT 子句中定义的列的别名。
- ORDER BY 子句中可以使用 SELECT 子句中未出现的列或者聚合函数。
- ORDER BY 子句中不能使用列的编号。

###### ORDER BY 子句

- ORDER BY 子句的书写顺序

  1. SELECT 子句 → 2. FROM 子句 → 3. WHERE 子句 → 4. GROUP BY 子句 →5.HAVING 子句 → 6. ORDER BY 子句

  不论何种情况， ORDER BY 子句都需要写在 SELECT 语句的末尾。这是因为对数据行进行排序的操作必须在结果即将返回时执行。

-  ORDER BY子句中书写的列名称为排序键

###### 指定升序或降序

- 未指定 ORDER BY 子句中排列顺序时会默认使用升序进行排列。
- 由于 ASC 和 DESC 这两个关键字是以列为单位指定的，因此可以同时指定一个列为升序，指定其他列为降序。

###### 指定多个排序键

- 同时指定多个排序键，规则是优先使用左侧的键，如果该列存在相同值的话，再接着参考右侧的
  键。

###### NULL 的顺序

- 排序键中包含 NULL 时，会在开头或末尾进行汇总。

###### 在排序键中使用显示用的别名

- 在 GROUP BY 子句中不能使用SELECT 子句中定义的别名，但是在 ORDER BY 子句中却是允许使用别名的。

- 使用 HAVING 子句时 SELECT 语句的顺序

  FROM → WHERE → GROUP BY → HAVING → SELECT → ORDER BY

  **一定要记住 SELECT 子句的执行顺序在 GROUP BY 子句之后， ORDER BY 子句之前。**

###### ORDER BY 子句中可以使用的列

- 在 ORDER BY 子句中可以使用 SELECT 子句中未使用的列和聚合函数。

###### 不要使用列编号

```
-- 通过列名指定
SELECT product_id, product_name, sale_price, purchase_price
FROM Product
ORDER BY sale_price DESC, product_id;
-- 通过列编号指定
SELECT product_id, product_name, sale_price, purchase_price
FROM Product
ORDER BY 3 DESC, 1;
```

上述第 2 条 SELECT 语句中的 ORDER BY 子句所代表的含义完全相同。虽然列编号使用起来非常方便，但我们并不推荐使用，原因有以下两点：

1. 第一，代码阅读起来比较难
2. 在 SQL-92 A 中已经明确指出该排序功能将来会被删除。

## 数据更新

#### 数据的插入（ INSERT 语句的使用方法）

###### 要点

- 使用 INSERT 语句可以向表中插入数据（行）。原则上， INSERT 语句每次执行一行数据的插入。
- 将列名和值用逗号隔开，分别括在（）内，这种形式称为清单。
- 对表中所有列进行 INSERT 操作时可以省略表名后的列清单。
- 插入 NULL 时需要在 VALUES 子句的值清单中写入 NULL 。
- 可以为表中的列设定默认值（初始值），默认值可以通过在 CREATE TABLE
  语句中为列设置 DEFAULT 约束来设定。
- 插入默认值可以通过两种方式实现，即在 INSERT 语句的 VALUES 子句
  中指定 DEFAULT 关键字（显式方法），或省略列清单（隐式方法）。
- 使用 INSERT … SELECT 可以从其他表中复制数据。

###### 什么是 INSERT

###### INSERT 语句的基本语法

```
INSERT INTO < 表名 > ( 列 1 , 列 2 , 列 3 , …… ) VALUES ( 值 1 , 值 2 , 值 3 , …… );
```

- 清单：将列名和值用逗号隔开，分别括在 （） 内，这种形式称为清单。

- 清单又分为列清单和值清单。

- 表名后面的列清单和 VALUES 子句中的值清单的列数必须保持一致。如下所示，列数不一致时会出错，无法插入数据。

- 多行 INSERT

  ```
  - 多行 INSERT （ Oracle 以外）
  INSERT INTO ProductIns VALUES ('0002', ' 打孔器 ', 
  ' 办公用品 ', 500, 320, '2009-09-11'),
  ('0003', ' 运动 T 恤 ', 
  ' 衣服 ', 4000, 2800, NULL),
  ('0004', ' 菜刀 ', 
  ' 厨房用具 ', 3000, 2800, '2009-09-20');
  ```

###### 列清单的省略

```
-- 省略列清单
INSERT INTO ProductIns VALUES ('0005', ' 高压锅 ', ' 厨房用具 ', 
6800, 5000, '2009-01-15');
```

这时 VALUES子句的值会默认按照从左到右的顺序赋给每一列。

###### 插入 NULL

- INSERT 语句中想给某一列赋予 NULL 值时，可以直接在 VALUES子句的值清单中写入 NULL 。
- 想要插入 NULL 的列一定不能设置 NOT NULL 约束。

###### 插入默认值

- 在 VALUES 子句中指定 DEFAULT 关键字

- 默认值的使用方法通常有显式和隐式两种。

  1. 通过显式方法插入默认值

     在 VALUES 子句中指定 DEFAULT 关键字

     ```
     INSERT INTO ProductIns (product_id, product_name, product_type, sale_price, purchase_price, regist_date) VALUES ('0007', ' 擦菜板 ', ' 厨房用具 ', DEFAULT, 790, '2009-04-28');
     ```

  2. 通过隐式方法插入默认值

     插入默认值时也可以不使用 DEFAULT 关键字，只要在列清单和VALUES 中省略设定了默认值的列就可以了。

     ```
     INSERT INTO ProductIns (product_id, product_name, product_type, purchase_price, regist_date) VALUES ('0007', ' 擦菜板 ', ' 厨房用具 ', 790, '2009-04-28');
     ```

  **建议大家使用显式的方法。因为这样可以一目了然地知道 sale _ price 列使用了默认值，SQL 语句的含义也更加容易理解。**

- 如果省略了没有设定默认值的列，该列的值就会被设定为 NULL 。

  因此，如果省略的是设置了 NOT NULL 约束的列， INSERT 语句就会出错

###### 从其他表中复制数据

-  INSERT … SELECT 语句

  ```
  -- 将商品表中的数据复制到商品复制表中
  INSERT INTO ProductCopy (product_id, product_name, product_type, 
  sale_price, purchase_price, regist_date)
  SELECT product_id, product_name, product_type, sale_price, 
  purchase_price, regist_date
  FROM Product;
  ```

- INSERT 语句的 SELECT 语句中，可以使用 WHERE 子句或者 GROUP BY 子句等任何SQL语法 （但使用 ORDER BY 子句并不会产生任何效果）。

  ```
  INSERT INTO ProductType (product_type, sum_sale_price, 
  sum_purchase_price)
  SELECT product_type, SUM(sale_price), SUM(purchase_price)
  FROM Product
  GROUP BY product_type;
  ```

#### 数据的删除（ DELETE 语句的使用方法）

###### 重点

- 如果想将整个表全部删除，可以使用 DROP TABLE 语句，如果只想删除表中全部数据，需使用 DELETE 语句。
- 如果想删除部分数据行，只需在 WHERE 子句中书写对象数据的条件即可。通过 WHERE 子句指定删除对象的 DELETE 语句称为搜索型 DELETE 语句。

###### DROP TABLE 语句和 DELETE 语句

- 删除数据的方法大体可以分为以下两种：

  1. DROP TABLE 语句可以将表完全删除

     因此删除之后再想插入数据，就必须使用 CREATE TABLE 语句重新创建一张表。

  2. DELETE 语句会留下表（容器），而删除表中的全部数据

     因此可以通过 INSERT 语句再次向表中插入数据。

###### DELETE 语句的基本语法

- DELETE FROM < 表名 >;
- 错误写法1：DELETE < 表名 >：无法正常执行的原因是删除对象不是表，而是表中的数据行
- 错误写法1： DELETE * FROM < 表名 >：因为 DELETE 语句的对象是行而不是列，所以 DELETE 语句无法只删除部分列的数据。

###### 指定删除对象的 DELETE 语句（搜索型 DELETE ）

- 可以通过 WHERE 子句指定对象条件来删除部分数据。

  DELETE 语句中不能使用 GROUP BY 、HAVING 和 ORDER BY 三类子句，而只能使用 WHERE 子句；原因很简单，GROUP BY 和 HAVING 是从表中选取数据时用来改变抽取数据形式的，而 ORDER BY 是用来指定取得结果显示顺序的。因此，在删除表中数据时它们都起不到什么作用。

- TRUNCATE < 表名 >;

  与 DELETE 不同的是， TRUNCATE 只能删除表中的全部数据，而不能通过WHERE 子句指定条件来删除部分数据。**也正是因为它不能具体地控制删除对象，所以其处理速度比 DELETE 要快得多。**

#### 数据的更新（ UPDATE 语句的使用方法）

###### 重点

- 使用 UPDATE 语句可以更改（更新）表中的数据。
- 更新部分数据行时可以使用 WHERE 来指定更新对象的条件。通过 WHERE
  子句指定更新对象的 UPDATE 语句称为搜索型 UPDATE 语句。
- UPDATE 语句可以将列的值更新为 NULL 。
- 同时更新多列时，可以在 UPDATE 语句的 SET 子句中，使用逗号分隔更新对象的多个列。

###### UPDATE 语句的基本语法

- UPDATE < 表名 > SET < 列名 > = < 表达式 >;

###### 指定条件的 UPDATE 语句（搜索型 UPDATE ）

- UPDATE < 表名 > SET < 列名 > = < 表达式 > WHERE < 条件 >;

  SET 子句中赋值表达式的右边不仅可以是单纯的值，还可以是包含列的表达式。

  ```
  UPDATE Product
  SET sale_price = sale_price * 10
  WHERE product_type = ' 厨房用具 ';
  ```

###### 使用 NULL 进行更新

- 使用 UPDATE 语句可以将值清空为 NULL （但只限于未设置 NOT NULL 约束和主键的列）。

  ```
  UPDATE Product
  SET regist_date = NULL
  WHERE product_id = '0008';
  ```

###### 多列更新

- 将多条 UPDATE 语句合并为一条 UPDATE 语句有两种方式：

  1. ```
     -- 使用逗号对列进行分隔排列
     UPDATE Product
     SET sale_price = sale_price * 10,
     purchase_price = purchase_price / 2
     WHERE product_type = ' 厨房用具 ';
     ```

  2. ```
     -- 将列用 () 括起来的清单形式
     UPDATE Product
     SET (sale_price, purchase_price) = (sale_price * 10, 
     purchase_price / 2)
     WHERE product_type = ' 厨房用具 ';
     ```

  **第二种方法可以在PostgreSQL和DB2中使用，并不通用，所以不要用**

#### 事务

###### 重点

- 事务是需要在同一个处理单元中执行的一系列更新处理的集合。通过使用事务，可以对数据库中的数据更新处理的提交和取消进行管理。
- 事务处理的终止指令包括 COMMIT （提交处理）和 ROLLBACK （取消处理）两种。
- DBMS的事务具有原子性（Atomicity）、一致性（Consistency）、隔离性（Isolation）和持久性（Durability）四种特性。通常将这四种特性的首字母结合起来，统称为ACID特性。

###### 什么是事务

- 事务是需要在同一个处理单元中执行的一系列更新处理的集合。

###### 创建事务

```
事务开始语句 ;
DML 语句① ;
DML 语句② ;
DML 语句③ ;
事务结束语句（ COMMIT 或者 ROLLBACK ）
```

- 需要特别注意的是事务的开始语句

  -  SQL Server、PostgreSQL
    BEGIN TRANSACTION

  -  MySQL
    START TRANSACTION

    ```
    START TRANSACTION;
    -- 将运动 T 恤的销售单价降低 1000 日元
    UPDATE Product
    SET sale_price = sale_price - 1000
    WHERE product_name = ' 运动 T 恤 ';
    -- 将 T 恤衫的销售单价上浮 1000 日元
    UPDATE Product
    SET sale_price = sale_price + 1000
    WHERE product_name = 'T 恤衫 ';
    COMMIT;
    ```

  -  Oracle、DB2
    无

    **其中 Oracle 和DB2 并没有定义特定的开始语句，因为标准 SQL 中规定了一种悄悄开始事务处理的方法。**

- 事务的结束需要用户明确地给出指示

  COMMIT 是提交事务包含的全部更新处理的结束指令，相当于文件处理中的覆盖保存；一旦提交，就无法恢复到事务开始前的状态了。

-  ROLLBACK ——取消处理

  ROLLBACK 是取消事务包含的全部更新处理的结束指令，相当于文件处理中的放弃保存；一旦回滚，数据库就会恢复到事务开始之前的状态。通常回滚并不会像提交那样造成大规模的数据损失。

  ```
  START TRANSACTION;
  -- 将运动 T 恤的销售单价降低 1000 日元
  UPDATE Product
  SET sale_price = sale_price - 1000
  WHERE product_name = ' 运动 T 恤 ';
  -- 将 T 恤衫的销售单价上浮 1000 日元
  UPDATE Product
  SET sale_price = sale_price + 1000
  WHERE product_name = 'T 恤衫 ';
  ROLLBACK;
  ```

  上述事务处理执行之后，表中的数据不会发生任何改变。这是因为执行最后一行的 ROLLBACK 之后，所有的处理都被取消了。

###### ACID特性

1. 原子性（Atomicity）

   - 原子性是指在事务结束时，其中所包含的更新处理要么全部执行，要么完全不执行，也就是要么占有一切要么一无所有。

     例如，在之前的例子中，在事务结束时，绝对不可能出现运动 T 恤的价格下降了，而 T 恤衫的价格却没有上涨的情况。**该事务的结束状态，要么是两者都执行了（ COMMIT ），要么是两者都未执行（ ROLLBACK ）**。

2. 一致性（Consistency）

   - 一致性也称为完整性

   - 一致性指的是事务中包含的处理要满足数据库提前设置的约束，如主键约束或者 NOT NULL 约束等。

     例如，设置了 NOT NULL 约束的列是不能更新为 NULL 的，试图插入违反主键约束的记录就会出错，无法执行。对事务来说，这些不合法的 SQL 会被回滚。也就是说，这些 SQL 处理会被取消，不会执行。

3. 隔离性（Isolation）

   - 隔离性指的是保证不同事务之间互不干扰的特性。

     即使某个事务向表中添加了记录，在没有提交之前，其他事务也是看不到新添加的记录的。

4. 持久性（Durability）

   - 持久性也可以称为耐久性，指的是在事务（不论是提交还是回滚）结束后，DBMS 能够保证该时间点的数据状态会被保存的特性。

## 复杂查询

#### 视图

###### 重点

- 从SQL的角度来看，视图和表是相同的，两者的区别在于表中保存的是实际的数据，而视图中保存的是 SELECT 语句（视图本身并不存储数据）。
- 使用视图，可以轻松完成跨多表查询数据等复杂操作。
- 可以将常用的 SELECT 语句做成视图来使用
- 创建视图需要使用 CREATE VIEW 语句。
- 视图包含“不能使用 ORDER BY ”和“可对其进行有限制的更新”两项限制。
- 删除视图需要使用 DROP VIEW 语句。

###### 视图和表

- 使用视图时并不会将数据保存到存储设备之中，而且也不会将数据保存到其他任何地方。实际上视图保存的是 SELECT 语句

  **从视图中读取数据时，视图会在内部执行该 SELECT 语句并创建出一张临时表。**

- 视图的优点

  1. 无需保存数据，因此可以节省存储设备的容量
  2. 可以将频繁使用的 SELECT 语句保存成视图，这样就不用每次都重新书写了。

###### 创建视图的方法

```
CREATE VIEW 视图名称 (< 视图列名 1>, < 视图列名 2>, …… )
AS
<SELECT 语句 >
```

- **这里的 AS 与定义别名时使用的 AS 并不相同，如果省略就会发生错误。**

- **表中的数据更新之后，视图也会自动更新，因为视图就是保存好的 SELECT 语句。**

- 使用视图的查询，通常有如下两个步骤：

  1. 首先执行定义视图的 SELECT 语句
  2. 根据得到的结果，再执行在 FROM 子句中使用视图的 SELECT 语句

- 多重视图：以视图为基础创建视图

  **应该尽量避免在视图的基础上创建视图。这是因为对多数DBMS来说，多重视图会降低SQL的性能。**

###### 视图的限制① ——定义视图时不能使用 ORDER BY 子句

- 这是因为视图和表一样，数据行都是没有顺序的。

  有些 DBMS(如PostgreSQL) 在定义视图的语句中是可以使用 ORDER BY 子句的，但是这并不是通用的语法。因此，在定义视图时请不要使用 ORDER BY 子句。

###### 视图的限制② ——对视图进行更新

- 如果定义视图的 SELECT 语句能够满足某些条件，那么这个视图就可以被更新。
  1. SELECT 子句中未使用 DISTINCT
  2. FROM 子句中只有一张表
  3. 未使用 GROUP BY 子句
  4. 未使用 HAVING 子句
- **视图和表需要同时进行更新，因此通过汇总得到的视图无法进行更新。**

###### 删除视图

- DROP VIEW 视图名称 (< 视图列名 1>, < 视图列名 2>, …… )
- 在PostgreSQL中，如果删除以视图为基础创建出来的多重视图，由于存在关联的视图，因此会发生如下错误。

#### 子查询

###### 重点

- 一言以蔽之，子查询就是一次性视图（ SELECT 语句）。与视图不同，子查询在 SELECT 语句执行完毕之后就会消失。
- 由于子查询需要命名，因此需要根据处理内容来指定恰当的名称。
- 标量子查询就是只能返回一行一列的子查询。

###### 子查询和视图

- 子查询就是将用来定义视图的 SELECT 语句直接用于 FROM 子句当中

  ```
  -- 根据商品种类统计商品数量的视图
  CREATE VIEW ProductSum (product_type, cnt_product)
  AS
  SELECT product_type, COUNT(*)
  FROM Product
  GROUP BY product_type;
  ```

  ```
  -- 能够实现同样功能的子查询：在 FROM 子句中直接书写定义视图的 SELECT 语句
  SELECT product_type, cnt_product
  FROM ( SELECT product_type, COUNT(*) AS cnt_product
  FROM Product
  GROUP BY product_type ) AS ProductSum;
  ```

  **“ AS ProductSum ”就是子查询的名称，但由于该名称是一次性的，因此不会像视图那样保存在存储介质（硬盘）之中，而是在 SELECT 语句执行之后就消失了。**

- SELECT 语句的执行顺序

  1. 首先执行 FROM 子句中的 SELECT 语句（子查询）

     ```
     SELECT product_type, COUNT(*) AS cnt_product
     FROM Product
     GROUP BY product_type;
     ```

  2. 根据1的结果执行外层的 SELECT 语句

     ```
     SELECT product_type, cnt_product
     FROM ProductSum;
     ```

- 子查询作为内层查询会首先执行。

###### 子查询的名称

- 为子查询设定名称时需要使用 AS 关键字，该关键字在Oracle中需要省略

###### 标量子查询

- 什么是标量子查询

  必须而且只能返回 1 行 1列的结果，也就是返回表中某一行的某一列的值

- 标量子查询的优势

  由于返回的是单一的值，因此标量子查询的返回值可以用在 = 或者 <> 这样需要单一值的比较运算符之中。

- 在 WHERE 子句中使用标量子查询

  ```
  -- 在 WHERE 子句中不能使用聚合函数
  SELECT product_id, product ＿ name, sale_price
  FROM Product
  WHERE sale_price > AVG(sale_price);
  ```

  因为在 WHERE 子句中不能使用聚合函数，可以用标量子查询实现：

  ```
  SELECT product_id, product_name, sale_price
  FROM Product
  WHERE sale_price > (SELECT AVG(sale_price) FROM Product);
  ```

-  SELECT 语句的执行顺序

  1. 首先执行内层的标量子查询
  2. 再执行外层的查询

###### 标量子查询的书写位置

- 标量子查询的书写位置并不仅仅局限于 WHERE 子句中，通常任何可以使用单一值的位置都可以使用。也就是说，能够使用常数或者列名的地方，无论是 **SELECT 子句、 GROUP BY 子句、 HAVING 子句，还是ORDER BY 子句**

###### 使用标量子查询时的注意事项

- **该子查询绝对不能返回多行结果**

  如果子查询返回了多行结果，那么它就不再是标量子查询，而仅仅是一个普通的子查询了，因此不能被用在 = 或者 <> 等需要单一输入值的运算符当中，也不能用在 SELECT 等子句当中。

#### 关联子查询

###### 重点

- 关联子查询会在细分的组内进行比较时使用。
- 关联子查询和 GROUP BY 子句一样，也可以对表中的数据进行切分。
- 关联子查询的结合条件如果未出现在子查询之中就会发生错误。

###### 普通的子查询和关联子查询的区别

- 在细分的组内进行比较时，需要使用关联子查询。

  使用关联子查询时，通常会使用“限定（绑定）”或者“限制”这样的语言，例如本次示例就是限定“商品种类”对平均单价进行比较。

###### 关联子查询也是用来对集合进行切分的

- 关联子查询也和 GROUP BY 子句一样，可以对集合进行切分

  ```
  SELECT product _type , product_name, sale_price
  FROM Product AS P1
  WHERE sale_price > (SELECT AVG(sale_price)
  FROM Product AS P2
  WHERE P1.product_type = P2.product_type);
  ```

- 关联子查询实际只能返回 1行结果。这也是关联子查询不出错的关键。

- 关联子查询执行时DBMS内部的执行情况

  ```
  SELECT 衣服 , T 恤衫 , 1000 FROM Product WHERE 1000 > 2500;
  SELECT 衣服 , 运动 T 恤 , 4000 FROM Product WHERE 4000 > 2500 ;
  -------------------------------------------------------------------
  SELECT 厨房用具 , 菜刀 , 3000 FROM Product WHERE 3000 > 2795 ;
  SELECT 厨房用具 , 高压锅 , 6800 FROM Product WHERE 6800 > 2795 ;
  SELECT 厨房用具 , 叉子 , 500 FROM Product WHERE 500 > 2795;
  SELECT 厨房用具 , 擦菜板 , 880 FROM Product WHERE 880 > 2795;
  -------------------------------------------------------------------
  SELECT 办公用品 , 圆珠笔 , 100 FROM Product WHERE 100 > 300;
  SELECT 办公用品 , 打孔器 , 500 FROM Product WHERE 500 > 300 ;
  ```

###### 结合条件一定要写在子查询中

```
-- 错误的关联子查询书写方法
SELECT product_type, product_name, sale_price
FROM Product AS P1
WHERE P1.product_type = P2.product_type
AND sale_price > (SELECT AVG(sale_price)
FROM Product AS P2
GROUP BY product_type);
```

关联名称就是像 P1 、 P2 这样作为表别名的名称，作用域（scope）就是生存范围（有效范围）。也就是说，关联名称存在一个有效范围的限制。具体来讲，子查询内部设定的关联名称，只能在该子查询内部使用。换句话说，就是“内部可以看到外部，而外部看不到内部”。

SQL是按照先内层子查询后外层查询的顺序来执行的。这样，子查询执行结束时只会留下执行结果，作为抽出源的 P2 表其实已经不存在了。因此，在执行外层查询时，由于 P2 表已经不存在了，因此就会返回“不存在使用该名称的表”这样的错误。

## 函数、谓词、 CASE 表达式

#### 各种各样的函数

###### 重点

- 根据用途，函数可以大致分为算术函数、字符串函数、日期函数、转换函数和聚合函数。
- 函数的种类很多，无需全都记住，只需要记住具有代表性的函数就可以了，其他的可以在使用时再进行查询。

###### 函数的种类

- 所谓函数，就是输入某一值得到相应输出结果的功能，输入值称为参数（parameter），输出值称为返回值。
- 函数种类
  - 算术函数（用来进行数值计算的函数）
  - 字符串函数（用来进行字符串操作的函数）
  - 日期函数（用来进行日期操作的函数）
  - 转换函数（用来转换数据类型和值的函数）
  - 聚合函数（用来进行数据聚合的函数）

###### 算术函数

-  +（加法）

- -（减法）

- （乘法）

-  / （除法）

- ABS 函数 ——绝对值

- MOD ——求余

  MOD( 被除数，除数 )

  因为
  **小数计算中并没有余数的概念，所以只能对整数类型的列使用 MOD 函数。**

  主流的 DBMS 都支持 MOD 函数，只有SQL Server 不支持该函数，SQL Server使用特殊的运算符（函数）“% ”来计算余数。

-  ROUND ——四舍五入

  ROUND( 对象数值，保留小数的位数 )

  如果指定四舍五入的位数为 1 ，那么就会对小数点第 2 位进行四舍五入处理。如果指定位数为 2 ，那么就会对第 3 位进行四舍五入处理

###### 字符串函数

-  || ——拼接

  字符串 1 || 字符串 2

  **SQL Server使用“+”运算符（函数）来连接字符串A。MySQL使用 CONCAT 函数来完成字符串的拼接。**

  ```
  SELECT str1, str2, str3,
  CONCAT(str1, str2, str3) AS str_concat
  FROM SampleStr;
  ```

-  LENGTH ——字符串长度

  LENGTH( 字符串 )

  **该函数也无法在 SQL Server 中使用，SQL Server使用 LEN 函数来计算字符串的长度。**

-  LOWER ——小写转换

  LOWER( 字符串 )

  LOWER 函数只能针对英文字母使用，它会将参数中的字符串全都转换为小写

-  UPPER ——大写转换

-  REPLACE ——字符串的替换

  REPLACE( 对象字符串，替换前的字符串，替换后的字符串 )

- SUBSTRING ——字符串的截取（PostgreSQL/MySQL专用语法）

  SUBSTRING （对象字符串 FROM 截取的起始位置 FOR 截取的字符数）

  ```
  -- 截取出字符串中第3位和第4位的字符
  SELECT str1,
  SUBSTRING(str1 FROM 3 FOR 2) AS sub_str
  FROM SampleStr;
  ```

  SUBSTRING 函数（SQL Server专用语法）

  - SUBSTRING( 对象字符串，截取的起始位置，截取的字符数 )

  SUBSTR 函数（Oracle/DB2专用语法）

  - SUBSTR( 对象字符串，截取的起始位置，截取的字符数 )

###### 日期函数

-  CURRENT_DATE ——当前日期

  ```
  SELECT CURRENT_DATE;
  ```

  SQL Server使用如下的 CURRENT_TIMESTAMP （后述）函数来获得当前日期。

  ```
  -- 使用 CAST （后述）函数将 CURRENT _ TIMESTAMP 转换为日期类型
  SELECT CAST(CURRENT_TIMESTAMP AS DATE) AS CUR_DATE;
  ```

  在Oracle中使用该函数时，需要在 FROM 子句中指定临时表（ DUAL ）。而在DB2中使用时，需要在 CRUUENT 和 DATE 之间添加半角空格，并且还需要指定临时表SYSIBM.SYSDUMMY1 （相当于Oracle中的 DUAL ）。

  ```
  -- Oracle
  SELECT CURRENT_DATE
  FROM dual;
  -- DB2
  SELECT CURRENT DATE
  FROM SYSIBM.SYSDUMMY1;
  ```

-  CURRENT_TIME ——当前时间

  区别同上面的CURRENT_DATE 

-  CURRENT_TIMESTAMP ——当前日期和时间

  区别同上面的CURRENT_DATE

- EXTRACT ——截取日期元素

  EXTRACT( 日期元素 FROM 日期 )

  使用 EXTRACT 函数可以截取出日期数据中的一部分，例如“年”，“月”，或者“小时”“秒”，该函数的返回值并不是日期类型而是数值类型。

  ```
  -- PostgreSQL和MySQL
  SELECT CURRENT_TIMESTAMP,
  EXTRACT(YEAR FROM CURRENT_TIMESTAMP) AS year,
  EXTRACT(MONTH FROM CURRENT_TIMESTAMP) AS month,
  EXTRACT(DAY FROM CURRENT_TIMESTAMP) AS day,
  EXTRACT(HOUR FROM CURRENT_TIMESTAMP) AS hour,
  EXTRACT(MINUTE FROM CURRENT_TIMESTAMP) AS minute,
  EXTRACT(SECOND FROM CURRENT_TIMESTAMP) AS second;
  ```

  SQL Server 也无法使用该函数，SQL Server使用 DATEPART 函数

  ```
  -- SQL Server
  SELECT CURRENT_TIMESTAMP,
  DATEPART(YEAR , CURRENT_TIMESTAMP) AS year,
  DATEPART(MONTH , CURRENT_TIMESTAMP) AS month,
  DATEPART(DAY , CURRENT_TIMESTAMP) AS day,
  DATEPART(HOUR , CURRENT_TIMESTAMP) AS hour,
  DATEPART(MINUTE , CURRENT_TIMESTAMP) AS minute,
  DATEPART(SECOND , CURRENT_TIMESTAMP) AS second;
  ```

  ```
  -- Oracle
  -- 在 FROM 子句中指定临时表（ DUAL ）
  SELECT CURRENT_TIMESTAMP,
  EXTRACT(YEAR FROM CURRENT_TIMESTAMP) AS year,
  EXTRACT(MONTH FROM CURRENT_TIMESTAMP) AS month,
  EXTRACT(DAY FROM CURRENT_TIMESTAMP) AS day,
  EXTRACT(HOUR FROM CURRENT_TIMESTAMP) AS hour,
  EXTRACT(MINUTE FROM CURRENT_TIMESTAMP) AS minute,
  EXTRACT(SECOND FROM CURRENT_TIMESTAMP) AS second
  FROM DUAL;
  
  --DB2
  /* CURRENT 和 TIME 之间使用了半角空格，指定临时表 SYSIBM.SYSDUMMY1 */
  SELECT CURRENT TIMESTAMP,
  EXTRACT(YEAR FROM CURRENT TIMESTAMP) AS year,
  EXTRACT(MONTH FROM CURRENT TIMESTAMP) AS month,
  EXTRACT(DAY FROM CURRENT TIMESTAMP) AS day,
  EXTRACT(HOUR FROM CURRENT TIMESTAMP) AS hour,
  EXTRACT(MINUTE FROM CURRENT TIMESTAMP) AS minute,
  EXTRACT(SECOND FROM CURRENT TIMESTAMP) AS second
  FROM SYSIBM.SYSDUMMY1;
  ```

###### 转换函数

- CAST ——类型转换

  CAST （转换前的值 AS 想要转换的数据类型）

  之所以需要进行类型转换，是因为可能会插入与表中数据类型不匹配的数据，或者在进行运算时由于数据类型不一致发生了错误，又或者是进行自动类型转换会造成处理速度低下。

  ```
  -- 将字符串类型转换为数值类型
  -- SQL Server和PostgreSQL
  SELECT CAST('0001' AS INTEGER) AS int_col;
  -- MySQL
  SELECT CAST('0001' AS SIGNED INTEGER) AS int_col;
  -- Oracle
  SELECT CAST('0001' AS INTEGER) AS int_col
  FROM DUAL;
  -- DB2
  SELECT CAST('0001' AS INTEGER) AS int_col
  FROM SYSIBM.SYSDUMMY1;
  ```

-  COALESCE ——将 NULL 转换为其他值

  COALESCE( 数据 1 ，数据 2 ，数据 3 …… )

  该函数会返回可变参数中左侧开始第1个不是 NULL 的值。

  **运算或者函数中含有 NULL 时，结果全都会变为NULL 。能够避免这种结果的函数就是 COALESCE 。**

  ```
  -- 将 NULL 转换为其他值
  -- SQL Server和PostgreSQL MySQL
  SELECT COALESCE(NULL, 1) AS col_1,
  COALESCE(NULL, 'test', NULL) AS col_2,
  COALESCE(NULL, NULL, '2009-11-01') AS col_3;
  -- Oracle
  SELECT COALESCE(NULL, 1) AS col_1,
  COALESCE(NULL, 'test', NULL) AS col_2,
  COALESCE(NULL, NULL, '2009-11-01') AS col_3
  FROM DUAL;
  -- DB2
  SELECT COALESCE(NULL, 1) AS col_1,
  COALESCE(NULL, 'test', NULL) AS col_2,
  COALESCE(NULL, NULL, '2009-11-01') AS col_3
  FROM SYSIBM.SYSDUMMY1;
  ```

  

#### 谓词

###### 重点

- 谓词就是返回值为真值的函数。
- 掌握 LIKE 的三种使用方法（前方一致、中间一致、后方一致）。
- 需要注意 BETWEEN 包含三个参数。
- 想要取得 NULL 数据时必须使用 IS NULL 。
- 可以将子查询作为 IN 和 EXISTS 的参数。

###### 什么是谓词

- 谓词就是返回值是真值的函数

  对通常的函数来说，返回值有可能是数字、字符串或者日期等，但是谓词的返回值全都是真值（ TRUE/
  FALSE/UNKNOWN ）。这也是谓词和函数的最大区别。

- 常用谓词

  - LIKE
  - BETWEEN
  - IS NULL 、 IS NOT NULL
  - IN
  - EXISTS

###### LIKE 谓词——字符串的部分一致查询

- 当需要进行字符串的部分一致查询时需要使用该谓词

- 部分一致大体可以分为前方一致、中间一致和后方一致三种类型。

  前方一致：'str%' 选取出“**ddd**abc”：就是选取出作为查询条件的字符串（这里是“ ddd ”）与查询对象字符串起始部分相同的记录的查询方法。

  中间一致：'%str%'  选取出“ abc**ddd** ”“ **ddd**abc ”“ ab**ddd**c ”：就是选取出查询对象字符串中含有作为查询条件的字符串的记录的查询方法。**无论该字符串出现在对象字符串的最后还是中间都没有关系。**

  后方一致：'%str' 选取出“ abc**ddd** ”：就是选取出作为查询条件的字符串与查询对象字符串的末尾部分相同的记录的查询方法。

  **查询条件最宽松，也就是能够取得最多记录的是中间一致。这是因为它同时包含前方一致和后方一致的查询结果。**

- 像这样不使用“ = ”来指定条件字符串，而以字符串中是否包含该条件的规则为基础的查询称为模式匹配，其中的模式也就是前面提到的“规则”。

- 其中的 % 是代表“0 字符以上的任意字符串”的特殊符号

- _：我们还可以使用 _（下划线）来代替 % ，与 % 不同的是，它代表了“任意 1 个字符”。

###### BETWEEN 谓词——范围查询

- 使用 BETWEEN 可以进行范围查询。该谓词与其他谓词或者函数的不同之处在于它使用了 3 个参数。

  ```
  SELECT product_name, sale_price
  FROM Product
  WHERE sale_price BETWEEN 100 AND 1000;
  ```

  **BETWEEN 的特点就是结果中会包含 100 和 1000 这两个临界值。如果不想让结果中包含临界值，那就必须使用 < 和 >。**

###### IS NULL 、 IS NOT NULL ——判断是否为 NULL

- 为了选取出某些值为 NULL 的列的数据，不能使用 = ，而只能使用特定的谓词 IS NULL
- 想要选取 NULL 以外的数据时，需要使用 IS NOT NULL

###### IN 谓词—— OR 的简便用法

-  IN ( 值 , …… )
-  NOT IN ( 值 , …… )
- **需要注意的是，在使用 IN 和 NOT IN 时是无法选取出 NULL 数据的。**

###### 使用子查询作为 IN 谓词的参数

- IN 谓词（ NOT IN 谓词）具有其他谓词所没有的用法，那就是可以使用子查询作为其参数。
- **IN或NOT IN的参数中包含 NULL时结果通常会为空，也就是无法选取出任何记录。** 

###### EXIST 谓词

- 实际上即使不使用 EXIST ，基本上也都可以使用 IN （或者 NOT IN ）来代替

- 判断是否存在满足某种条件的记录，如果存在这样的记录就返回真（ TRUE ），如果不存在就返回假（ FALSE ）。EXIST （存在）谓词的主语是“记录”。

  ```
  SELECT product_name, sale_price
  FROM Product AS P
  WHERE EXISTS (SELECT *
  FROM ShopProduct AS SP
  WHERE SP.shop_id = '000C'
  AND SP.product_id = P.product_id);
  ```

- EXIST 的参数

  **通常指定关联子查询作为 EXIST 的参数。**

   EXIST 只需要在右侧书写 1 个参数，该参数通常都会是一个子查询。

- 子查询中的 SELECT *

  由于 EXIST 只关心记录是否存在，因此返回哪些列都没有关系。

  SELECT * 改为 SELECT 1 也可以

  ```
  SELECT product_name, sale_price
  FROM Product AS P
  WHERE EXISTS (SELECT 1 -- 这里可以书写适当的常数
  FROM ShopProduct AS SP
  WHERE SP.shop_id = '000C'
  AND SP.product_id = P.product_id);
  ```

  **大家可以把在 EXIST 的子查询中书写 SELECT * 当作 SQL 的一种习惯。**

- 使用 NOT EXIST 替换 NOT IN

- **很多情况没有必要勉强使用 EXIST，但** **EXIST 拥有IN 所不具有的便利性**

#### CASE 表达式

###### 重点

- CASE 表达式分为简单 CASE 表达式和搜索 CASE 表达式两种。搜索CASE 表达式包含简单 CASE 表达式的全部功能。
- 虽然 CASE 表达式中的 ELSE 子句可以省略，但为了让SQL语句更加容易理解，还是希望大家不要省略。
- CASE 表达式中的 END 不能省略。
- 使用 CASE 表达式能够将 SELECT 语句的结果进行组合。
- 虽然有些DBMS提供了各自特有的 CASE 表达式的简化函数，例如Oracle中的 DECODE 和MySQL中的 IF ，等等，但由于它们并非通用的函数，功能上也有些限制，因此有些场合无法使用。

###### 什么是 CASE 表达式

- CASE 表达式是在区分情况时使用的，在编程中通常称为（条件）分支。

  和“ 1 + 1 ”或者“ 120 / 4 ”这样的表达式一样，是一种进行运算的功能。**这就意味着 CASE 表达式也是函数的一种。**

###### CASE 表达式的语法

- CASE 表达式的语法分为简单 CASE 表达式和搜索 CASE 表达式两种。

  搜索 CASE 表达式包含了简单 CASE 表达式的全部功能，简单 CASE 表达式虽然比搜索 CASE 表达式简单，但是会受到条件的约束，**通常情况下都会使用搜索 CASE 表达式**

- 搜索 CASE 表达式

  ```
  CASE WHEN < 求值表达式 > THEN < 表达式 >
  WHEN < 求值表达式 > THEN < 表达式 >
  WHEN < 求值表达式 > THEN < 表达式 >
  .
  .
  .
  ELSE < 表达式 >
  END
  ```

  WHEN 子句中的“< 求值表达式 >”就是类似“列 = 值”这样，返回值为真值（ TRUE / FALSE/UNKNOWN ）的表达式。**我们也可以将其看作使用 = 、 != 或者 LIKE 、 BETWEEN 等谓词编写出来的表达式。**

  CASE 表达式会从对最初的 WHEN 子句中的“< 求值表达式 >”进行求值开始执行。所谓**求值，就是要调查该表达式的真值是什么。如果结果为真（ TRUE ），那么就返回 THEN 子句中的表达式**， CASE 表达式的执行到此为止。如果结果不为真，那么就跳转到下一条 WHEN 子句的求值之中。如果直到最后的 WHEN 子句为止返回结果都不为真，那么就会返回 ELSE中的表达式，执行终止。

###### CASE 表达式的使用方法

```
SELECT product_name,
	CASE WHEN product_type = ' 衣服 '
		 THEN 'A ： ' || product_type
		 WHEN product_type = ' 办公用品 '
		 THEN 'B ： ' || product_type
		 WHEN product_type = ' 厨房用具 '
		 THEN 'C ： ' || product_type
		 ELSE NULL
		 END AS abc_product_type
FROM Product;
```

**||是连接字符串的意思，在MySQL中用CONCAT**

- 虽然 CASE 表达式中的 ELSE 子句可以省略，但还是希望大家不要省略。

- CASE 表达式中的 END 不能省略。

- **我们可以利用 CASE 表达式将下述 SELECT 语句结果中的行和列进行互换。**

  **通常使用 GROUP BY 也无法实现行列转换，但是这样得到的结果会以“行”的形式输出，而无法以列的形式进行排列**

  ```
  SELECT product_type,
  SUM(sale_price) AS sum_price
  FROM Product
  GROUP BY product_type;
  
  product_type | sum_price
  --------------+----------
  衣服 | 5000
  办公用品 | 600
  厨房用具 | 11180
  ```

  使用 CASE 表达式进行行列转换:

  ```
  -- 对按照商品种类计算出的销售单价合计值进行行列转换
  SELECT SUM(CASE WHEN product_type = ' 衣服 '
  THEN sale_price ELSE 0 END) AS sum_price_clothes,
  SUM(CASE WHEN product_type = ' 厨房用具 '
  THEN sale_price ELSE 0 END) AS sum_price_kitchen,
  SUM(CASE WHEN product_type = ' 办公用品 '
  THEN sale_price ELSE 0 END) AS sum_price_office
  FROM Product;
  
  sum_price_clothes | sum_price_kitchen | sum_price_office
  ------------------+-------------------+-----------------
  5000 | 11180 | 600
  ```

  **在对 SELECT 语句的结果进行编辑时， CASE 表达式能够发挥较大作用。**

- 简单 CASE 表达式

  ```
  CASE < 表达式 >
  WHEN < 表达式 > THEN < 表达式 >
  WHEN < 表达式 > THEN < 表达式 >
  WHEN < 表达式 > THEN < 表达式 >
  .
  .
  .
  ELSE < 表达式 >
  END
  ```

- 两种方式实现将字符串 A～C 添加到商品种类中

  ```
  -- 使用搜索 CASE 表达式的情况（重写代码清单 6-41 ）
  SELECT product_name,
  CASE WHEN product_type = ' 衣服 '
  THEN 'A ： ' | | product_type
  WHEN product_type = ' 办公用品 '
  THEN 'B ： ' | | product_type
  WHEN product_type = ' 厨房用具 '
  THEN 'C ： ' | | product_type
  ELSE NULL
  END AS abc_product_type
  FROM Product;
  
  -- 使用简单 CASE 表达式的情况
  SELECT product_name,
  CASE product_type
  WHEN ' 衣服 ' THEN 'A ： ' | | product_type
  WHEN ' 办公用品 ' THEN 'B ： ' | | product_type
  WHEN ' 厨房用具 ' THEN 'C ： ' | | product_type
  ELSE NULL
  END AS abc_product_type
  FROM Product;
  ```

  像“ CASE product_type ”这样，简单 CASE 表达式在将想要求值的表达式（这里是列）书写过一次之后，就无需在之后的 WHEN 子句中重复书写“ product_type ”了。**虽然看上去简化了书写，但是想要在 WHEN 子句中指定不同列时，简单 CASE 表达式就无能为力了。**

- MySQL 中使用 IF 代替 CASE 表达式

  ```
  -- MySQL 中使用 IF 代替 CASE 表达式
  SELECT product_name,
  IF( IF( IF(product_type = ' 衣服 ',
  CONCAT('A ： ', product_type), NULL)
  IS NULL AND product_type = ' 办公用品 ',
  CONCAT('B ： ', product_type),
  IF(product_type = ' 衣服 ',
  CONCAT('A ： ', product_type), NULL))
  IS NULL AND product_type = ' 厨房用具 ',
  CONCAT('C ： ', product_type),
  IF( IF(product_type = ' 衣服 ',
  CONCAT('A ： ', product_type), NULL)
  IS NULL AND product_type = ' 办公用品 ',
  CONCAT('B ： ', product_type),
  IF(product_type = ' 衣服 ',
  CONCAT('A ： ', product_type),
  NULL))) AS abc_product_type
  FROM Product;
  ```

- Oracle 中使用 DECODE 代替 CASE 表达式

  ```
  -- Oracle 中使用 DECODE 代替 CASE 表达式
  SELECT product_name,
  	DECODE(product_type,
  			' 衣服 ', 'A ： ' | | product_type,
  			' 办公用品 ', 'B ： ' | | product_type,
  			' 厨房用具 ', 'C ： ' | | product_type,
  			NULL) AS abc_product_type
  FROM Product;
  ```

  

## 集合运算

#### 表的加减法

###### 重点

- 集合运算就是对满足同一规则的记录进行的加减等四则运算。
- 使用 UNION （并集）、 INTERSECT （交集）、 EXCEPT （差集）等集合运算符来进行集合运算。
- 集合运算符可以去除重复行。
- 如果希望集合运算符保留重复行，就需要使用 ALL 选项。

###### 什么是集合运算

- 在数据库领域表示记录的集合。具体来说，表、视图和查询的执行结果都是记录的集合。
- 所谓集合运算，就是对满足同一规则的记录进行的加减等四则运算。
- **集合运算符会除去重复的记录。**

###### 表的加法—— UNION （并集）

```
SELECT product_id, product_name
FROM Product
UNION
SELECT product_id, product_name
FROM Product2;
```

###### 集合运算的注意事项

1. 作为运算对象的记录的列数必须相同

   像下面这样，一部分记录包含 2 列，另一部分记录包含 3 列时会发生错误，无法进行加法运算。

   ```
   -- 列数不一致时会发生错误
   SELECT product_id, product_name
   FROM Product
   UNION
   SELECT product_id, product_name, sale_price
   FROM Product2;
   ```

2. 作为运算对象的记录中列的类型必须一致

   从左侧开始，相同位置上的列必须是同一数据类型。例如下面的 SQL语句，虽然列数相同，但是第 2 列的数据类型并不一致（一个是数值类型，一个是日期类型），因此会发生错误。**一定要使用不同数据类型的列时，可以使用类型转换函数CAST 。**

   ```
   -- 数据类型不一致时会发生错误
   SELECT product_id, sale_price
   FROM Product
   UNION
   SELECT product_id, regist_date
   FROM Product2;
   ```

3. 可以使用任何 SELECT 语句，但 ORDER BY 子句只能在最后使用一次

   ```
   SELECT product_id, product_name
   FROM Product
   WHERE product_type = ' 厨房用具 '
   UNION
   SELECT product_id, product_name
   FROM Product2
   WHERE product_type = ' 厨房用具 '
   ORDER BY product_id;
   ```

###### 包含重复行的集合运算—— ALL 选项

- 在集合运算符中使用 ALL 选项，可以保留重复行。

  ```
  SELECT product_id, product_name
  FROM Product
  UNION ALL
  SELECT product_id, product_name
  FROM Product2;
  ```

###### 选取表中公共部分—— INTERSECT （交集）

- **MySQL中不支持**

- 使用 INTERSECT 选取出表中公共部分

  ```
  --Oracle、SQL Server、DB2、PostgreSQL
  SELECT product_id, product_name
  FROM Product
  INTERSECT
  SELECT product_id, product_name
  FROM Product2
  ORDER BY product_id;
  ```

- 与使用 AND 可以选取出一张表中满足多个条件的公共部分不同，INTERSECT 应用于两张表，选取出它们当中的公共记录。

###### 记录的减法—— EXCEPT （差集）

- **MySQL中不支持**

- 使用 EXCEPT 对记录进行减法运算

  ```
  -- SQL Server、DB2、PostgreSQL
  SELECT product_id, product_name
  FROM Product
  EXCEPT
  SELECT product_id, product_name
  FROM Product2
  ORDER BY product_id;
  
  -- Oracle 中使用 MINUS 而不是 EXCEPT
  SELECT …
  FROM …
  MINUS
  SELECT …
  FROM … ;
  ```

- EXCEPT 有一点与 UNION 和 INTERSECT 不同，**需要注意一下。那就是在减法运算中减数和被减数的位置不同，所得到的结果也不相同。**
  例：4 + 2 和 2 + 4 的结果相同，但是 4 - 2 和 2 - 4 的结果却不一样。

#### 联结（以列为单位对表进行联结）

###### 重点

- 联结（ JOIN ）就是将其他表中的列添加过来，进行“添加列”的集合运算。UNION 是以行（纵向）为单位进行操作，而联结则是以列（横向）为单位进行的。
- 联结大体上分为内联结和外联结两种。首先请大家牢牢掌握这两种联结的使用方法。
- 请大家一定要使用标准SQL的语法格式来写联结运算，对于那些过时的或者特定SQL中的写法，了解一下即可，不建议使用。

###### 什么是联结

- 联结（ JOIN ）运算，就是将其他表中的列添加过来，进行“添加列”的运算

###### 内联结—— INNER JOIN

```
-- SQL Server、DB2、PostgreSQL、MySQL，在Oracle的 FROM 子句中要去掉AS（否则会发生错误）。
SELECT SP.shop_id, SP.shop_name, SP.product_id, P.product_name, 
P.sale_price
FROM ShopProduct AS SP INNER JOIN Product AS P ①
ON SP.product_id = P.product_id;
```

- **内联结只能选取出同时存在于两张表中的数据**

- 内联结要点

  1.  FROM 子句

     进行联结时需要在 FROM 子句中使用多张表。

  2. ON 子句

     - **进行内联结时必须使用 ON 子句，并且要书写在 FROM 和 WHERE 之间。**

     - 可以在 ON 之后指定两张表联结所使用的列（联结键）， ON 是专门用来指定联结条件的，它能起到与 WHERE 相同的作用。
     - 需要指定多个键时，同样可以使用 AND 、 OR 。

  3. SELECT 子句

     使用联结时 SELECT 子句中的列需要按照“ < 表的别名 > . < 列名 > ”的格式进行书写。

- 内联结和 WHERE 子句结合使用

  ```
  -- SQL Server、DB2、Postgre、SQL MySQL，在Oracle的 FROM 子句中要去掉AS（否则会发生错误）。
  SELECT SP.shop_id, SP.shop_name, SP.product_id, P.product_name, 
  P.sale_price
  FROM ShopProduct AS SP INNER JOIN Product AS P ①
  ON SP.product_id = P.product_id
  WHERE SP.shop_id = '000A';
  ```

  像这样使用联结运算将满足相同规则的表联结起来时， **WHERE 、GROUP BY 、 HAVING 、 ORDER BY 等工具都可以正常使用**。我们可以将联结之后的结果想象为新创建出来的一张表，对这张表使用WHERE 子句等工具；这张“表”只在 SELECT 语句执行期间存在， SELECT 语句执行之后就会消失。如果希望继续使用这张“表”，还是将它创建成视图。

###### 外联结—— OUTER JOIN

- 外联结要点

  1. 选取出单张表中全部的信息

     - 对于外联结来说，只要数据存在于某一张表当中，就能够读取出来。

       **在实际的业务中，例如想要生成固定行数的单据时，就需要使用外联结。**如果使用内联结的话，根据 SELECT 语句执行时商店库存状况的不同，结果的行数也会发生改变，生成的单据的版式也会受到影响，而使用外联结能够得到固定行数的结果。

     - 外联结名称的由来也跟 NULL 有关，即“**结果中包含原表中不存在（在原表之外）的信息**”。相反，**只包含表内信息的联结也就被称为内联结**了。

  2. 要把哪张表作为主表

     - 外联结还有一点非常重要，那就是要把哪张表作为主表。**最终的结果中会包含主表内所有的数据。**
     - 指定主表的关键字是 LEFT 和 RIGHT 。使用 LEFT 时 FROM 子句中写在左侧的表是主表，使用 RIGHT
       时右侧的表是主表。

###### 交叉联结—— CROSS JOIN （笛卡儿积）

- 这种联结在实际业务中并不会使用，但因为交叉联结是所有联结运算的基础。
- 进行交叉联结时无法使用内联结和外联结中所使用的 ON 子句，这是因为交叉联结是对两张表中的全部记录进行交叉组合，因此**结果中的记录数通常是两张表中行数的乘积**。
- 内联结是交叉联结的一部分，“内”也可以理解为“包含在交叉联结结果中的部分”。相反，外联结的“外”可以理解为“交叉联结结果之外的部分”。
- 交叉联结没有应用到实际业务之中的原因有两个。一是其结果没有实用价值，二是由于其结果行数太多，需要花费大量的运算时间和高性能设备的支持。

###### 联结的特定语法和过时语法

- 语法的内联结

  ```
  SELECT SP.shop_id, SP.shop_name, SP.product_id, P.product_name, 
  P.sale_price
  FROM ShopProduct SP, Product P
  WHERE SP.product_id = P.product_id
  AND SP.shop_id = '000A';
  ```

  由于这样的语法不仅过时，而且还存在很多其他的问题，因此不推荐大家使用，理由主要有以下三点。

  1. 第一，使用这样的语法无法马上判断出到底是内联结还是外联结（又或者是其他种类的联结）。
  2. 第二，由于联结条件都写在 WHERE 子句之中，因此无法在短时间内分辨出哪部分是联结条件，哪部分是用来选取记录的限制条件。
  3. 第三，我们不知道这样的语法到底还能使用多久。

## SQL高级处理

#### 窗口函数

###### 什么是窗口函数

###### 窗口函数的语法

###### 语法的基本使用方法——使用 RANK 函数

###### 无需指定 PARTITION BY

###### 专用窗口函数的种类

###### 窗口函数的适用范围

###### 作为窗口函数使用的聚合函数

###### 计算移动平均

###### 两个 ORDER BY

#### GROUPING 运算符

###### 同时计算出合计值

###### ROLLUP ——同时得出合计和小计

###### GROUPING 函数——让 NULL 更加容易分辨

###### CUBE ——用数据来搭积木

###### GROUPING SETS ——取得期望的积木