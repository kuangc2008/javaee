<%@ page import="_001login1.ReigsterServert" %><%--
  Created by IntelliJ IDEA.
  User: kuangcheng
  Date: 2019-03-30
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>


    登陆成功了, 上次登陆时间是 <%= request.getAttribute(ReigsterServert.TIME) %>





<%

    Cookie cookie = new Cookie(ReigsterServert.TIME, System.currentTimeMillis()+"");
    response.addCookie(cookie);
%>
</body>
</html>
