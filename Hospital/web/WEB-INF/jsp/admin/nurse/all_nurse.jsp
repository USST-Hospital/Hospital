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
    <div class="myTitle">护士信息</div>

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
		密码
                </th>
                <th>
                    操作
                </th>

            </tr>
            <c:forEach var="nurse" items="${ requestScope.nurses }"> 
                <tr id="${nurse.id }">
                <td> <input  class="form-control" value="${ nurse.id }" disabled></td>
                <td> <input  class="form-control" value="${ nurse.name }" disabled></td>
                <td> <input  class="form-control" value="${ nurse.gender }" disabled></td>
                <td> <input  class="form-control" value="${ nurse.age }" disabled></td>
                <td> <input  class="form-control" value="${ nurse.number }" disabled></td>
                <td> <input  class="form-control" value="${ nurse.password }" disabled></td>
                <td style="width: 150px;">  <button onclick="deletnurse(${nurse.id})"  class="btn btn-info" id="del${ nurse.id }">删除</button>&nbsp;&nbsp;
                       <button onclick="updatenurse(${nurse.id})"  class="btn btn-info" id="updata${ nurse.id }">修改</button>
                       <button onclick="savenurse(${nurse.id})" style="display:none" class="btn btn-info" id="save${ nurse.id }">保存</button>
                       
                       </td>

                </tr>
            </c:forEach>
        </table>
      
    </div>
</div>


</body>
</html>
