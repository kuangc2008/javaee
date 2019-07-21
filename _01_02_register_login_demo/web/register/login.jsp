<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script>
        window.onload = function(){
            document.getElementById("img").onclick = function(){
                this.src="checkCodeServlet?time="+new Date().getTime();
            }
        }


    </script>
    <style>
        div{
            color: red;
        }

    </style>

</head>
<body>

<form action="doLogin" method="post">
    <input type="text" placeholder="请输入用户名" name="username"><br>
    <input type="text" placeholder="请输入密码" name="password"><br>

验证码 <input type="text" name="checkCode"> <img id="img" src="checkCodeServlet">

    <br>
    <input type="submit" value="登陆"> <br>


    <div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></div>
    <div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error") %></div>


</form>

</body>
</html>