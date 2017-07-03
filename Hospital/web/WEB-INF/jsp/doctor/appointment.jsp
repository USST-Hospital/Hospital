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
    <script src="${pageContext.request.contextPath}/javascript/doctor.js"></script>
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
    <div class="myTitle">
        手术预约
    </div>
    <div class="col-md-8 col-md-offset-2">
        <form action="../../AdminCourse?o=a" method="post" class="form-horizontal">

            <div class="form-group">
                <label class="col-sm-3 control-label">手术名称</label>
                <div class="col-sm-6">
                    <input class="form-control" id="operationName" placeholder="operationName" >
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">医生</label>
                <div class="col-sm-6">
                    <input id="doctor" doctor-id="${ doctorId}" class="form-control" value="${ appointmentDoctor}" disabled>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">病人ID</label>
                <div class="col-sm-6">
                    <input id="patientId" class="form-control" name="name" placeholder="patienId">
                </div>
                <label id="patientName" class="col-sm-3 control-label" style="text-align: left;">
                    <img width="30px;" src="/Hospital/image/no.png">
                </label>

            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">手术日期</label>

                <div class="col-sm-2">
                    <select class="form-control" id="year">
                        <option value="-1">year</option>
                        <option value="2017">2017年</option>
                        <option value="2018">2018年</option>
                        <option value="2019">2019年</option>
                        <option value="2020">2020年</option>
                        <option value="2021">2021年</option>
                    </select>
                </div>


                <div class="col-sm-2">
                    <select class="form-control" id="month">
                        <option value="-1">month</option>
                        <option value="1">1月</option>
                        <option value="2">2月</option>
                        <option value="3">3月</option>
                        <option value="4">4月</option>
                        <option value="5">5月</option>
                        <option value="6">6月</option>
                        <option value="7">7月</option>
                        <option value="8">8月</option>
                        <option value="9">9月</option>
                        <option value="10">10月</option>
                        <option value="11">11月</option>
                        <option value="12">12月</option>
                    </select>
                </div>


                <div class="col-sm-2">
                    <select class="form-control" id="day">
                        <option value="-1">day</option>
                        <option value="1">1日</option>
                        <option value="2">2日</option>
                        <option value="3">3日</option>
                        <option value="4">4日</option>
                        <option value="5">5日</option>
                        <option value="6">6日</option>
                        <option value="7">7日</option>
                        <option value="8">8日</option>
                        <option value="9">9日</option>
                        <option value="10">10日</option>
                        <option value="11">11日</option>
                        <option value="12">12日</option>
                        <option value="13">13日</option>
                        <option value="14">14日</option>
                        <option value="15">15日</option>
                        <option value="16">16日</option>
                        <option value="17">17日</option>
                        <option value="18">18日</option>
                        <option value="19">19日</option>
                        <option value="20">20日</option>
                        <option value="21">21日</option>
                        <option value="22">22日</option>
                        <option value="23">23日</option>
                        <option value="24">24日</option>
                        <option value="25">25日</option>
                        <option value="26">26日</option>
                        <option value="27">27日</option>
                        <option value="28">28日</option>
                        <option value="29">29日</option>
                        <option value="30">30日</option>
                        <option value="31">31日</option>
                    </select>
                </div>
            </div>


            <div class="form-group">
                <label class="col-sm-3 control-label">开始时间</label>
                <div class="col-sm-6">
                    <select class="form-control" id="startTime">
                        <option value="-1">startTime</option>
                        <option value="0">0:00</option>
                        <option value="1">1:00</option>
                        <option value="2">2:00</option>
                        <option value="3">3:00</option>
                        <option value="4">4:00</option>
                        <option value="5">5:00</option>
                        <option value="6">6:00</option>
                        <option value="7">7:00</option>
                        <option value="8">8:00</option>
                        <option value="9">9:00</option>
                        <option value="10">10:00</option>
                        <option value="11">11:00</option>
                        <option value="12">12:00</option>
                        <option value="13">13:00</option>
                        <option value="14">14:00</option>
                        <option value="15">15:00</option>
                        <option value="16">16:00</option>
                        <option value="17">17:00</option>
                        <option value="18">18:00</option>
                        <option value="19">19:00</option>
                        <option value="20">20:00</option>
                        <option value="21">21:00</option>
                        <option value="22">22:00</option>
                        <option value="23">23:00</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">结束时间</label>
                <div class="col-sm-6">
                    <select class="form-control" id="endTime">
                        <option value="-1">endTime</option>
                        <option value="0">0:00</option>
                        <option value="1">1:00</option>
                        <option value="2">2:00</option>
                        <option value="3">3:00</option>
                        <option value="4">4:00</option>
                        <option value="5">5:00</option>
                        <option value="6">6:00</option>
                        <option value="7">7:00</option>
                        <option value="8">8:00</option>
                        <option value="9">9:00</option>
                        <option value="10">10:00</option>
                        <option value="11">11:00</option>
                        <option value="12">12:00</option>
                        <option value="13">13:00</option>
                        <option value="14">14:00</option>
                        <option value="15">15:00</option>
                        <option value="16">16:00</option>
                        <option value="17">17:00</option>
                        <option value="18">18:00</option>
                        <option value="19">19:00</option>
                        <option value="20">20:00</option>
                        <option value="21">21:00</option>
                        <option value="22">22:00</option>
                        <option value="23">23:00</option>
                    </select>
                </div>
                <label id="endTimeNotice" class="col-sm-3 control-label" style="text-align: left;">
                   <img width="30px;" src="/Hospital/image/no.png">
                </label>
            </div>


            <div class="form-group">
                <label class="col-sm-3 control-label">手术室</label>
                <div class="col-sm-6">
                    <select class="form-control" id="operationRoom" >
                        <option value="-1">未选择</option>
                        <c:forEach var="teacherInfo"
                                   items="${sdf}">
                            <option value="${ teacherInfo.tn }">${ teacherInfo.tn }&nbsp;&nbsp;${ teacherInfo.name }</option>
                        </c:forEach>
                    </select>
                </div>
            </div>


            <div class="form-group">
                <label class="col-sm-3 control-label">麻醉师</label>
                <div class="col-sm-6">
                    <select class="form-control" id="analgesist" >
                        <option value="-1">未选择</option>
                        <c:forEach var="roomInfo" items="${sdf }">
                            <option value="${ roomInfo.rn }">${ roomInfo.rn }&nbsp;&nbsp;${ roomInfo.place }</option>
                        </c:forEach>

                    </select>
                </div>
            </div>


            <div class="form-group">
                <label class="col-sm-3 control-label">护士</label>

                <div class="col-sm-6">
                    <select class="form-control" id="nurse">
                        <option value="-1">未选择</option>
                    </select>
                </div>

                <div class="col-sm-3">
                    <button id="chooseNurse" type="button" class="btn btn-info">确定选择</button>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-3 control-label"></div>

                <div class="col-sm-6">
                    <div class="panel panel-info">
                        <div class="panel-heading">已选护士</div>
                        <div class="panel-body" id="nurses" style="min-height: 60px;">

                        </div>
                    </div>
                </div>

            </div>


            <div class="form-group">
                <div class="col-sm-offset-6 col-sm-6">
                    <button id="appointment" type="button" class="btn btn-success">提交预约</button>
                </div>
            </div>

        </form>
    </div>
</div>


</body>
</html>
