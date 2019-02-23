<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>显示用户信息</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
        <link rel="stylesheet" type="text/css" href="/net_ladder/css/index.css">
        <script type="text/javascript" src="/net_ladder/js/jquery.1.11.3.min.js"></script>
        <!--[if (gte IE 6)&(lte IE 8)]>
            <script type="text/javascript" src="/net_ladder/js/selectivizr.1.0.2.min.js"></script>
            <noscript><link rel="stylesheet" href="[fallback css]" /></noscript>
        <![endif]-->
        <style type="text/css">
            table tr:first-child td:last-child {
                background-color:lightgreen;
            }
        </style>
        <script type="text/javascript" src="/net_ladder/js/index.js"></script>
    </head>
    <body>
        <div class="css3"><span>css3</span></div>
        <div class="javascript">javascript</div>
        <table>
            <tr>
                <td>用户ID</td>
                <td>用户名</td>
                <td>出生日期</td>
                <td>工资</td>
                <td>登陆次数</td>
                <td>点赞数</td>
                <td>账户余额</td>
                <td>登录状态</td>
            </tr>
            <c:forEach var="user" items="${user}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.birthday}</td>
                    <td>${user.salary}</td>
                    <td>${user.logincount}</td>
                    <td>${user.praise}</td>
                    <td>${user.account}</td>
                    <td>${user.status}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
