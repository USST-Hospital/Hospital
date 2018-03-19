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
    </script>

    <title>Analgesist</title>

</head>
<body>

<div class="container">


    <jsp:include page="../common/top_menu.jsp"></jsp:include>


    <%--<iframe src="common/top_menu.do"></iframe>--%>


    <div class="row">
        <div class="col-md-12 " <%--style="padding: 1px;"--%>>
            <div <%--style="margin: 10px;"--%>>

                <ul class="nav nav-tabs ">
                    <li><a href="information.do" target="doctorIframe">查看个人信息</a></li>
                    <li><a href="schedule.do" target="doctorIframe">查看手术排班</a></li>
                    <%--<li><a href="appointment.do" target="doctorIframe">手术预约</a></li>--%>
                    <li><a href="history.do" target="doctorIframe">手术历史</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout.do">退出登录</a></li>
                </ul>
            </div>

        </div>
    </div>

    <div class="row">
        <div class="col-md-12">

            <iframe id="myIframe" class="myContent" src="information.do" name="doctorIframe">


            </iframe>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>


</body>
</html>
