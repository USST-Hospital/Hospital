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


<div>
    <div class="myTitle">医生信息</div>

    <div>
        <table class="table table-bordered" >
            <tr>
                <th>
                    工号
                </th>
                <th>
                    姓名
                </th>
                <th>
                    性别
                </th>
                <th>
                    年龄
                </th>
                <th>
                    号码
                </th>
                <th>

                </th>

            </tr>
            <%--<c:forEach var="doctor" items="${ requestScope.doctors }">--%>
                <tr>
                    <td>${ doctor.id }</td>
                    <td>${ doctor.name }</td>
                    <td>${ doctor.gender }</td>
                    <td>${ doctor.age }</td>
                    <td>${ doctor.number }</td>
                    <td style="width: 130px;">  <button onclick="delete(${doctor.id})"  class="btn btn-info">删除</button>&nbsp;&nbsp;
                        <button onclick="update(${doctor.id})"  class="btn btn-info">修改</button></td>

                </tr>
            <%--</c:forEach>--%>
        </table>
        <button type="button" class="btn btn-info">返回</button>
    </div>
</div>


</body>
</html>
