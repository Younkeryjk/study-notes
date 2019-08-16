<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div style="margin:50px auto; width:300px">
    <form action="updateHero" method=""post">
        name:&nbsp;&nbsp;<input name="name" value="${hero.name}"> <br><br>
        hp:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="hp" value="${hero.hp}">
        <br>

        <input type="hidden" name = "id" value="${hero.id}">
        <input type="submit" value="提交">
    </form>

</div>