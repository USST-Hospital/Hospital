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
    <div class="myTitle">
        病人信息
    </div>


    <c:if test="${ status =='success'}">
        <div class="col-md-6 col-md-offset-3">


            <table class="table table-bordered" style="margin-bottom: 30px;">
                <tr>
                    <th>工号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>号码</th>
                </tr>
                <tr>
                    <td>${ patient.id }</td>
                    <td>${ patient.name }</td>
                    <td>${ patient.gender }</td>
                    <td>${ patient.age }</td>
                    <td>${ patient.number }</td>
                </tr>
            </table>
        </div>


        <table class="table table-bordered">
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


    </c:if>
    <c:if test="${status=='failure'}">
        <div style="margin: 40px;font-size: 30px;color: #c7254e;text-align: center;">
            不存在此人病人！
        </div>

    </c:if>
    <div style="text-align: center;">
        <a href="search_patient.do" type="button" class="btn btn-info">返回</a>

    </div>

</div>


</body>
</html>
