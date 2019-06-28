<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 <div style="width:500px;margin:0px auto;text-align:center">
 	
 	<div>
 		当前分类:	 ${category.name}
 	</div>
	<table align='center' border='1' cellspacing='0'>
	    <tr>
	        <td>id</td>
	        <td>name</td>
	        <td>price</td>
	        <td>编辑</td>
	        <td>删除</td>
	    </tr>
	    <c:forEach items="${ps}" var="p" varStatus="st">
	        <tr>
	            <td>${p.id}</td>
	            <td>${p.name}</td>
	            <td>${p.price}</td>
	            <td><a href="editProduct?id=${p.id}">编辑</a></td>
	            <td><a href="deleteProduct?id=${p.id}">删除</a></td>
	        </tr>
	    </c:forEach>
	</table>
	<div style="text-align:center">
		<a href="?id=${category.id}&start=0">首  页</a>
		<a href="?id=${category.id}&start=${page.start-page.count}">上一页</a>
		<a href="?id=${category.id}&start=${page.start+page.count}">下一页</a>
		<a href="?id=${category.id}&start=${page.last}">末  页</a>
	</div>
	
	
	<div style="text-align:center;margin-top:40px">
		
		<form method="post" action="addProduct">
			产品名称： <input name="name" value="" type="text"> <br><br>
			产品价格： <input name="price" value="" type="text"> <br><br>
			<input name="category.id" value="${category.id}" type="hidden"> <br><br>
			<input type="submit" value="增加分类">
		</form>

	</div>	
 </div>
