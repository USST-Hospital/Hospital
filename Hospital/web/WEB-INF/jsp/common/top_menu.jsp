<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<div class="row" >
	<div class="col-md-12 c" style="padding-top: 20px;padding-bottom: 20px;">

		<%--<div class="row" style="height: 20px"></div>--%>
		<div class="row" style="text-align: center">

			<div class="col-md-4 "></div>




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



		<%--<div class="row">--%>
			<%--<div class="col-md-12 ">--%>
				<%--<c:if test="${ sessionScope.power==1 }">--%>
					<%--<h4>--%>
						<%--&nbsp;&nbsp;&nbsp;&nbsp;欢迎您，${ myTag:getStudentName(sessionScope.sn) }--%>
						<%--&nbsp;&nbsp;--%>

						<%--&lt;%&ndash; <c:if test="${ myTag:isAnswer(sessionScope.sn) }">--%>
						<%--通知：您的提问已经被回答，请查看						--%>
						<%--</c:if> &ndash;%&gt;--%>
					<%--</h4>--%>
				<%--</c:if>--%>
				<%--<c:if test="${ sessionScope.power==2 }">--%>
					<%--<h4>--%>
						<%--&nbsp;&nbsp;&nbsp;&nbsp;欢迎您，${ myTag:getTeacherName(sessionScope.tn) }--%>
						<%--&nbsp;&nbsp; &lt;%&ndash; 通知：您有--%>
						<%--<mycount>${ myTag:getQuestionCount(sessionScope.tn) }</mycount>--%>
						<%--个问题等待回答 &ndash;%&gt;--%>
					<%--</h4>--%>
				<%--</c:if>--%>
				<%--<c:if test="${ sessionScope.power==3 }">--%>
					<%--<h4>--%>
						<%--&nbsp;&nbsp;&nbsp;&nbsp;欢迎您，管理员--%>
					<%--</h4>--%>
				<%--</c:if>--%>
			<%--</div>--%>
		<%--</div>--%>




	</div>
</div>



