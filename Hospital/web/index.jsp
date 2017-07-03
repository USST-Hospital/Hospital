<%--
  Created by IntelliJ IDEA.
  User: 28444
  Date: 2017/6/29
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/bootstrap3/js/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css"/>
    <script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/javascript/myJavaScript.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

    <script>
        $(document).ready(function () {
            $('#login').click(function () {
                alert('test login');
                var account = $('#account').val();
                var password = $('#password').val();
                var power = $('[name="power"]:checked').val();
                if(account!=''&&password!='') {
                    $.post("login.do",{'account':account,'password':password,'power':power},function (data,status) {
                        if(data=='success'&&status=='success') {
                            if(power=='doctor') {
                                window.location.href('doctor/doctor.do');
                            }else if(power=='analgesist') {
                                window.location.href('analgesist/analgesist.do');
                            }else if(power=='nurse') {
                                window.location.href('nurse/nurse.do');
                            }else if(power=='admin') {
                                window.location.href('admin/admin.do');
                            }
                        }else{
                           alert('账号或密码错误！')
                        }
                    })
                }else {
                    alert('账号或密码错误！');
                }
            });
        })
    </script>
    <title>Login</title>
</head>
<body>
<%-- <iframe name="testIframe" style="width: 100%;height: 300px;"></iframe>sdfsdf--%>
<a href="doctor/test.do" target="testIframe">test</a><br>
<a href="doctor/doctor.do">医生页面2</a><br>
<a href="admin/admin.do">adminX</a>

<body class="body">

<div class="container">
    <jsp:include page="WEB-INF/jsp/common/top_menu.jsp"></jsp:include>
    <div style="height: 100px;"></div>
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4" style="text-align: center;">
            <div>

                <h4> <label class="control-label">账号：</label></h4>
                <input type="text" class="form-control" id="account"  placeholder="Account"><br>
                <h4> <label class="control-label">密码：</label></h4>
                <input type="password" class="form-control" id="password" placeholder="Password">
                <br> <input type="radio" name="power" value="doctor" checked="checked"> 医生&nbsp;
                <input type="radio" name="power" value="analgesist"> 麻醉师&nbsp;
                <input  type="radio" name="power" value="nurse"> 护士&nbsp;
                <input  type="radio" name="power" value="admin"> 管理员
                <br> <br>

                <button type="button" class="btn btn-primary" id="login">登录</button>
                <!-- <input type="submit" value="登录"> -->
            </div>


        </div>
        <div class="col-md-4"></div>
    </div>

</div>

<div style="height: 100px;"></div>
<jsp:include page="WEB-INF/jsp/common/footer.jsp"></jsp:include>


</body>
</html>
