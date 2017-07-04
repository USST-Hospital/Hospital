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
    <script src="${pageContext.request.contextPath}/javascript/myJavaScript.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

    <script>
        $(document).ready(function () {
            $('#doctorMenu').click(function () {
                $('#adminNurse').hide();
                $('#adminDoctor').show();
                $('#adminPatient').hide();
                $('#adminAnalgesist').hide();
                $('#adminOperation').hide();
                $('#adminOperationRoom').hide();
            });
            $('#patientMenu').click(function () {
                $('#adminNurse').hide();
                $('#adminDoctor').hide();
                $('#adminPatient').show();
                $('#adminAnalgesist').hide();
                $('#adminOperation').hide();
                $('#adminOperationRoom').hide();
            });

            $('#nurseMenu').click(function () {
                $('#adminNurse').show();
                $('#adminDoctor').hide();
                $('#adminAnalgesist').hide();
                $('#adminOperation').hide();
                $('#adminPatient').hide();
                $('#adminOperationRoom').hide();
            });

            $('#analgesistMenu').click(function () {
                $('#adminNurse').hide();
                $('#adminDoctor').hide();
                $('#adminAnalgesist').show();
                $('#adminPatient').hide();
                $('#adminOperation').hide();
                $('#adminOperationRoom').hide();
            });

            $('#operationMenu').click(function () {
                $('#adminNurse').hide();
                $('#adminDoctor').hide();
                $('#adminAnalgesist').hide();
                $('#adminPatient').hide();
                $('#adminOperation').show();
                $('#adminOperationRoom').hide();
            });

            $('#operationRoomMenu').click(function () {
                $('#adminNurse').hide();
                $('#adminDoctor').hide();
                $('#adminAnalgesist').hide();
                $('#adminOperation').hide();
                $('#adminOperationRoom').show();
                $('#adminPatient').hide();
            });
        })


    </script>

    <title>Admin</title>

</head>
<body>

<div class="container">


    <jsp:include page="../common/top_menu.jsp"></jsp:include>
    <%--<iframe src="common/top_menu.do"></iframe>--%>


    <div class="row">
        <div class="col-md-12 " >
            <div >

                <ul class="nav nav-pills ">
                    <li><a href="doctor/all_doctor.do" id="doctorMenu" target="adminIframe">医生信息管理</a></li>
                    <li><a href="nurse/all_nurse.do" id="nurseMenu" target="adminIframe">护士信息管理</a></li>
                    <li><a href="analgesist/all_analgesist.do" id="analgesistMenu" target="adminIframe">麻醉师信息管理</a></li>
                    <li><a href="operation_room/all_operation_room.do" id="operationRoomMenu" target="adminIframe">手术室管理</a></li>
                    <li><a href="operation/all_operation.do" id="operationMenu" target="adminIframe">手术管理</a></li>
                    <li><a href="patient/all_patient.do" id="patientMenu" target="adminIframe">病人管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout.do" >退出登录</a></li>
                </ul>
            </div>

        </div>
    </div>

    <div class="row" id="adminDoctor">
        <div class="col-md-12 " >
            <div >

                <ul class="nav nav-pills">
                    <li><a href="doctor/all_doctor.do" target="adminIframe" >查看医生信息</a></li>
                    <li><a href="doctor/add_doctor.do" target="adminIframe" >添加医生</a></li>
                 <!--    <li><a href="admin/appointment.do" target="adminIframe" >手术预约</a></li>
                    <li><a href="admin/search_patient.do" target="adminIframe" >查看病人信息</a></li>
                    <li><a href="admin/history.do" target="adminIframe">手术历史</a></li> -->
                </ul>
            </div>
        </div>
    </div>
      <div class="row" id="adminPatient" style="display: none;">
        <div class="col-md-12 " >
            <div >

                <ul class="nav nav-pills">
                    <li><a href="patient/all_patient.do" target="adminIframe" >查看病人信息</a></li>
                    <li><a href="patient/add_patient.do" target="adminIframe" >添加病人</a></li>
                 <!--    <li><a href="admin/appointment.do" target="adminIframe" >手术预约</a></li>
                    <li><a href="admin/search_patient.do" target="adminIframe" >查看病人信息</a></li>
                    <li><a href="admin/history.do" target="adminIframe">手术历史</a></li> -->
                </ul>
            </div>
        </div>
    </div>
    



    <div class="row" id="adminNurse" style="display: none;">
        <div class="col-md-12 " >
            <div >

                <ul class="nav nav-tabs ">
                    <li><a href="nurse/all_nurse.do" target="adminIframe">查看护士信息</a></li>
                    <li><a href="nurse/add_nurse.do" target="adminIframe">添加护士</a></li>
                    <!-- <li><a href="admin/appointment.do" target="adminIframe">手术预约</a></li>
                    <li><a href="admin/search_patient.do" target="adminIframe">查看病人信息</a></li>
                    <li><a href="admin/history.do" target="adminIframe">手术历史</a></li> -->
                </ul>
            </div>
        </div>
    </div>


    <div class="row" id="adminAnalgesist" style="display: none;">
        <div class="col-md-12 " >
            <div >

                <ul class="nav nav-tabs ">
                    <li><a href="analgesist/all_analgesist.do" target="adminIframe">查看麻醉师信息</a></li>
                    <li><a href="analgesist/add_analgesist.do" target="adminIframe">添加麻醉师</a></li>
                  <!--   <li><a href="admin/appointment.do" target="adminIframe">手术预约</a></li>
                    <li><a href="admin/search_patient.do" target="adminIframe">查看病人信息</a></li>
                    <li><a href="admin/history.do" target="adminIframe">手术历史</a></li> -->
                </ul>
            </div>
        </div>
    </div>


    <div class="row" id="adminOperation" style="display: none;">
        <div class="col-md-12 " >
            <div >

                <ul class="nav nav-tabs ">
                    <li><a href="operation/all_operation.do" target="adminIframe">查看手术信息</a></li>
                    <li><a href="operation/add_operation.do" target="adminIframe">添加手术信息</a></li>
                   <!--  <li><a href="admin/appointment.do" target="adminIframe">手术预约</a></li>
                    <li><a href="admin/search_patient.do" target="adminIframe">查看病人信息</a></li>
                    <li><a href="admin/history.do" target="adminIframe">手术历史</a></li> -->
                </ul>
            </div>
        </div>
    </div>


    <div class="row" id="adminOperationRoom" style="display: none;">
        <div class="col-md-12 " >
            <div >

                <ul class="nav nav-tabs ">
                    <li><a href="operation_room/all_operation_room.do" target="adminIframe">查看手术室信息</a></li>
                    <li><a href="operation_room/add_operation_room.do" target="adminIframe">添加手术手术室</a></li>
                    <!-- <li><a href="admin/appointment.do" target="adminIframe">手术预约</a></li>
                    <li><a href="admin/search_patient.do" target="adminIframe">查看病人信息</a></li>
                    <li><a href="admin/history.do" target="adminIframe">手术历史</a></li> -->
                </ul>
            </div>
        </div>
    </div>




    <div class="row">
        <div class="col-md-12">

            <iframe id="myIframe" class="myContent" src="doctor/all_doctor.do" name="adminIframe" >


            </iframe>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>


</body>
</html>
