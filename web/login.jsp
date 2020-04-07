<%--
  Created by IntelliJ IDEA.
  User: 田野
  Date: 2020/4/6
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<div style="text-align:center;margin-top:120px">
    <h2>个人主页</h2>
    <form action="LoginServlet" method="post">
        <table style="margin-left:40%">
            <marquee width="200"scrolldelay="250">用户登录</marquee>

            <tr>
                <td>登录名：</td>
                <td><input name="username" type="text" size="21"></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input name="password" type="password" size="21"></td>
            </tr>
        </table>
        <input type="submit" value="登录">
        <input type="reset" value="重置">
    </form>
    <br>
    <a href="register.jsp">注册</a>
</div>
</body>
</html>
