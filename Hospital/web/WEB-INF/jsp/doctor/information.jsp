<%--
  Created by IntelliJ IDEA.
  User: 28444
  Date: 2017/6/29
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>

    <script src="${pageContext.request.contextPath}/bootstrap3/js/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css"/>
    <script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/javascript/myJavaScript.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>


<div >
    <div class="myTitle">
        个人信息
    </div>
    <div class="col-md-6 col-md-offset-3">
        <div>
            <table  class="table table-bordered">
                <tr>
                    <th>工号</th>
                    <td>${ doctorInfo.id }</td>
                </tr>

                <tr>
                    <th>姓名</th>
                    <td>${ doctorInfo.name }</td>
                </tr>
                <tr>
                    <th>性别</th>
                    <td>${ doctorInfo.gender }</td>
                </tr>

                <tr>
                    <th>年龄</th>
                    <td>${ doctorInfo.age }</td>
                <tr>
                    <th>号码</th>
                    <td>${ doctorInfo.number }</td>
                </tr>
            </table>
        </div>
    </div>
</div>


</body>
</html>
