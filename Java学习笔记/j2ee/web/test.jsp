<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
    session.setAttribute("test", 1);
    session.setAttribute("test", 2);
    session.removeAttribute("test");
%>