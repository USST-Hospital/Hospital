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
    <script src="${pageContext.request.contextPath}/javascript/admin.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <script>
        $(window.parent.document).find("#myIframe").load(function(){
            var main = $(window.parent.document).find("#myIframe");
            var thisheight = $(document).height()+30;
            main.height(thisheight);
        });
    </script>
</head>
<body>


<div>
    <div class="myTitle">手术室信息</div>

    <div>
        <table class="table table-bordered" >
            <tr>
                <th>
       	 手术室编号
                </th>
                <th>
                    手术室地址
                </th>
              

            </tr>
            <c:forEach var="operationroom" items="${ requestScope.operationRooms }"> 
                <tr id="${operationroom.id }">
                <td> <input  class="form-control" value="${ operationroom.id }" disabled></td>
                <td> <input  class="form-control" value="${ operationroom.location }" disabled></td>
               
                <td style="width: 130px;">  <button onclick="deletoperationroom(${operationroom.id})"  class="btn btn-info" id="del${ operationroom.id }">删除</button>&nbsp;&nbsp;
                       <button onclick="updateoperationroom(${operationroom.id})"  class="btn btn-info" id="updata${ operationroom.id }">修改</button>
                       <button onclick="saveoperationroom(${operationroom.id})" style="display:none" class="btn btn-info" id="save${ operationroom.id }">保存</button>
                       
                       </td>

                </tr>
            </c:forEach>
        </table>
       
    </div>
</div>


</body>
</html>
