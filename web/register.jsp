<%--
  Created by IntelliJ IDEA.
  User: 田野
  Date: 2020/4/6
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>注册界面</title>
</head>
<body>
<div style="text-align:center;margin-top:120px">
    <h1 >请注册</h1>
    <form action="RegisterServlet" method="post">
        <table style="margin-left:40%">
            <caption>用户注册</caption>
            <tr>
                <td>登录名：</td>
                <td><input name="name" type="text" size="20"></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input name="password" type="password" size="20"></td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td><input name="email" type="text" size="20"></td>
            </tr>
        </table>
        <input type="submit" value="注册">
        <input type="reset" value="重置">
    </form>
    <br>
    <a href="login.jsp">登录</a>
</div>
</body>
</html>
