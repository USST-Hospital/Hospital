<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
            <div class="col-md-4 " style="padding-left: 50px;padding-bottom: 10px;">
                <c:if test="${ sessionScope.personText!=null}">
                    <span style="font-size: 17px;">欢迎您&nbsp;&nbsp;${ sessionScope.personText}</span><br>
                    <span id="operationInfo" style="color: red;font-size: 17px;"></span>
                    </span>
                </c:if>
            </div>
        </div>


    </div>
</div>



