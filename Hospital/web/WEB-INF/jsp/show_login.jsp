<%--
  Created by IntelliJ IDEA.
  User: 28444
  Date: 2017/6/29
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/bootstrap3/js/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css"/>
    <script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.js"></script>
    <%--<script src="${pageContext.request.contextPath}/javascript/myJavaScript.js"></script>--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

    <script>
        $.getScript('http://php.weather.sina.com.cn/iframe/index/w_cl.php?code=js&day=1&city=&dfc=1&charset=utf-8',
            function (a) {
                var s = "", r = "", q = "";
                for (s in window.SWther.w) {
                    q = SWther.w[s][0];
                    r = {
                        city: s,
                        date: SWther.add.now.split(" ")[0] || "",
                        day_weather: q.s1,
                        night_weather: q.s2,
                        day_temp: q.t1,
                        night_temp: q.t2,
                        day_wind: q.p1,
                        night_wind: q.p2
                    }
                    $("#city").text(r.city);
                    $("#temp").text(r.night_temp + '°C~' + r.day_temp + '°C');
                    $("#weather").text(r.day_weather + '/' + r.night_weather);
                    $("#date").text(r.date);
                }
            });


        $(document).ready(function () {
            if(window.parent!=window) {
                window.parent.location.href = '/Hospital/index.jsp';
            }

            $('#login').click(function () {
                var account = $('#account').val();
                var password = $('#password').val();
                var power = $('[name="power"]:checked').val();
                if(account!=''&&password!='') {
                    $.post("login.do",{'account':account,'password':password,'power':power},function (data,status) {
                        if(data=='success'&&status=='success') {
                            if(power=='doctor') {
                                window.location.href='doctor/doctor.do';
                            }else if(power=='analgesist') {
                                window.location.href='analgesist/analgesist.do';
                            }else if(power=='nurse') {
                                window.location.href='nurse/nurse.do';
                            }else if(power=='admin') {
                                window.location.href='admin/admin.do';
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

<body class="body">

<div class="container">


    <%--<jsp:include page="common/top_menu.jsp"></jsp:include>--%>
    <div class="row">
        <div class="col-md-12 c" style="padding-top: 20px;">

            <%--<div class="row" style="height: 20px"></div>--%>
            <div class="row" style="text-align: center">

                <div class="col-md-4 ">   </div>

                <div class="col-md-4">
                    <h1>
                        <div class="label label-primary">Java Web</div>
                    </h1>
                    <!--#f0ad4e  -->
                    <h1>手术排班系统</h1>
                </div>
                <div class="col-md-1"></div>


                <div class="col-md-3  "
                     style="margin-top: 30px;/*  background-color: white; */">
                    <div>
                        城市：<span id="city"></span>
                    </div>
                    <div>
                        温度：<span id="temp"></span>
                    </div>
                    <div>
                        天气：<span id="weather"></span>
                    </div>
                    <div>
                        日期：<span id="date"></span>
                    </div>

                </div>
            </div>


            <div class="row">
                <div class="col-md-4 " style="padding-left: 50px;padding-bottom: 35px;">

                </div>
            </div>


        </div>
    </div>


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
<jsp:include page="common/footer.jsp"></jsp:include>


</body>
</html>
