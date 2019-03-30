<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: kuangcheng
  Date: 2019-03-30
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

商品列表



<p><a href="SessionDemoServlet?id=0">小米6</a></p>  :   <%= session.getAttribute("0")%>
<p><a href="SessionDemoServlet?id=1">iphone7</a></p> :   <%= session.getAttribute("1")%>
<p><a href="SessionDemoServlet?id=2">meizu3</a></p>  :   <%= session.getAttribute("2")%>
<p><a href="SessionDemoServlet?id=3">huawei pro</a></p>  :   <%= session.getAttribute("3")%>
<p><a href="SessionDemoServlet?id=4">vivo10</a></p> :   <%= session.getAttribute("4")%>


</body>
</html>
