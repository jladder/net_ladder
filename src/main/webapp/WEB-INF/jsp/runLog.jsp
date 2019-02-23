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
        <script type="text/javascript" src="/net_ladder/js/index.js"></script>
    </head>
    <body>
        <div class="css3"><span>css3</span></div>
        <div class="javascript">javascript</div>
        <table>
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Url</td>
                <td>Statuscode</td>
                <td>Contenttype</td>
                <td>Contentlength</td>
                <td>Contentencoding</td>
                <td>Protocolversion</td>
                <td>Reasonphrase</td>
                <td>Createtime</td>
                <td>Content</td>
                <td>操作</td>
            </tr>
            <c:forEach var="runLog" items="${runLogList}">
                <tr>
                    <td>${runLog.id}</td>
                    <td>${runLog.name}</td>
                    <td>${runLog.url}</td>
                    <td>${runLog.statuscode}</td>
                    <td>${runLog.contenttype}</td>
                    <td>${runLog.contentlength}</td>
                    <td>${runLog.contentencoding}</td>
                    <td>${runLog.protocolversion}</td>
                    <td>${runLog.reasonphrase}</td>
                    <td>${runLog.createtime}</td>
                    <td>${runLog.content}</td>
                    <td><a href="/net_ladder/runLog/batchDelete.html?ids=${runLog.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
