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
        查询病人信息
    </div>


    <div class="col-md-5 col-md-offset-3">

        <form action="patient_info.do" class="form-horizontal">

            <div class="form-group">
                <label class="col-sm-3 control-label">病人病号</label>
                <div class="col-sm-9">
                    <input class="form-control" name="patientId" placeholder="patientId">
                </div>
            </div>


            <div class="form-group">
                <div class="col-sm-offset-6 col-sm-6">
                    <button type="submit" class="btn btn-success">确定</button>
                </div>
            </div>
        </form>

    </div>


</div>

</body>
</html>
