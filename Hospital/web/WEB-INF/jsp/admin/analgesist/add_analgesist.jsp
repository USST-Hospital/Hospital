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
    <%-- <script src="${pageContext.request.contextPath}/javascript/myJavaScript.js"></script> --%>
    <script src="${pageContext.request.contextPath}/javascript/admin.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

    <script>
        $(window.parent.document).find("#myIframe").load(function () {
            var main = $(window.parent.document).find("#myIframe");
            var thisheight = $(document).height() + 30;
            main.height(thisheight);
        });
    </script>
</head>
<body>


<div>
    <div class="myTitle">
        添加麻醉师
    </div>


        <div class="col-md-5 col-md-offset-3">

            <div class="form-horizontal">

                <div class="form-group">
                    <label class="col-sm-3 control-label">麻醉师工号</label>
                    <div class="col-sm-9">
                        <input class="form-control" id="id" placeholder="id">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">姓名</label>
                    <div class="col-sm-9">
                        <input class="form-control" id="name" placeholder="name">
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">性别</label>
                    <div class="col-sm-9">
                        <input class="form-control" id="sex" placeholder="sex">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">年龄</label>
                    <div class="col-sm-9">
                        <input class="form-control" id="age" placeholder="age">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">号码</label>
                    <div class="col-sm-9">
                        <input class="form-control" id="number" placeholder="number">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">密码</label>
                    <div class="col-sm-9">
                        <input class="form-control" id="password" placeholder="password">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-6 col-sm-6">
                        <button type="button" class="btn btn-success"  onclick="addAnalgesist()">确定</button>
                    </div>
                </div>

            </div>

        </div>


</div>

</body>
</html>
