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

    <script>
        $(document).ready(function () {
            var main = $(window.parent.document).find("#operationInfo");
            $.post("/Hospital/changeOperationInfo.do")
        })
    </script>
</head>
<body>


<div>
    <div class="myTitle">排班信息</div>

    <div>
        <table class="table table-bordered" >
            <tr>
                <th>
                    手术编号
                </th>
                <th>
                    手术名称
                </th>
                <th>
                    手术室
                </th>
                <th>
                    手术时间
                </th>
                <th>
                    医生
                </th>
                <th>
                    麻醉师
                </th>
                <th>
                    护士
                </th>
                <th>
                    病人
                </th>
            </tr>
            <c:forEach var="operation" items="${ requestScope.operations }">
                <tr>
                    <td>${ operation.id }</td>
                    <td>${ operation.name }</td>
                    <td>${ operation.operationRoom.location }</td>
                    <td>${ operation.showTime }</td>
                    <td>${ operation.doctor.name }</td>
                    <td>${ operation.analgesist.name }</td>
                    <td>${ operation.showNurses }</td>
                    <td>${ operation.patient.name }</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>


</body>
</html>
