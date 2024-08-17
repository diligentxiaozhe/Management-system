<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

<meta charset="utf-8" />

<title>用户管理</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<meta content="" name="description" />

<meta content="" name="author" />

<!-- BEGIN GLOBAL MANDATORY STYLES -->

<jsp:include page="pageResources/css.jsp"></jsp:include>

<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN PAGE LEVEL STYLES -->

<link rel="stylesheet" type="text/css"
	href="media/css/select2_metro.css" />

<link rel="stylesheet" href="media/css/DT_bootstrap.css" />

<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon" href="media/image/favicon.ico" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

	<jsp:include page="pageResources/head.jsp"></jsp:include>

	<!-- BEGIN CONTAINER -->

	<div class="page-container row-fluid">

		<!-- BEGIN SIDEBAR -->

		<div class="page-sidebar nav-collapse collapse">

			<jsp:include page="pageResources/nav.jsp"></jsp:include>

		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

		<div class="page-content">

			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<div id="portlet-config" class="modal hide">

				<div class="modal-header">

					<button data-dismiss="modal" class="close" type="button"></button>

					<h3>portlet Settings</h3>

				</div>

				<div class="modal-body">

					<p>Here will be a configuration form</p>

				</div>

			</div>

			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<jsp:include page="pageResources/pagehead.jsp"></jsp:include>
				<!-- END PAGE HEADER-->

				<!-- BEGIN EXAMPLE TABLE PORTLET-->

				<div class="portlet box blue">

					<div class="portlet-title">

						<div class="caption">
							<i class="icon-edit"></i>用户列表
						</div>

						<div class="tools">

							<a href="javascript:;" class="collapse"></a> <a
								href="#portlet-config" data-toggle="modal" class="config"></a> <a
								href="javascript:;" class="reload"></a> <a href="javascript:;"
								class="remove"></a>

						</div>

					</div>

					<div class="portlet-body">

						<div class="clearfix">

							<div class="btn-group">

								 <button id="sample_editable_1_new" class="btn green">

									添加 <i class="icon-plus"></i>

								</button> 

							</div>

							<div class="btn-group pull-right">

								<button class="btn dropdown-toggle" data-toggle="dropdown">
									工具 <i class="icon-angle-down"></i>

								</button>

								<ul class="dropdown-menu pull-right">

									<li><a href="#">打印</a></li>

									<li><a href="#">保存为PDF</a></li>

									<li><a href="#">导出到 Excel</a></li>

								</ul>

							</div>

						</div>

						<table class="table table-striped table-hover table-bordered"
							id="sample_editable_1">

							<thead>

								<tr>

									<th>编号</th>

									<th>用户名</th>

									<th>年龄</th>
									<th>邮箱</th>
									<th>操作</th>

								</tr>

							</thead>

							<tbody>

	 <!-- ulist是servlet放到serssion中的，这里循环把他们取出来 -->
     <c:forEach items="${list}" var="list">
     <tr>
         <td>${list.id }</td>
         <td>${list.name }</td>
         <td>${list.age }</td>
         <td>${list.email }</td>
         <td>
         <a href="EditServlet?do=getEdit&id=${list.id }">修改</a>
         <a href="DeleteServlet?do=del&id=${list.id}" onclick="javascript:return confirm('确认删除吗？');">删除</a>
         </td>
     </tr>
     </c:forEach>
							</tbody>

						</table>

					</div>

				</div>

				<!-- END EXAMPLE TABLE PORTLET-->


			</div>

			<!-- END PAGE CONTAINER-->

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<jsp:include page="pageResources/foot.jsp"></jsp:include>

	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->
	<jsp:include page="pageResources/js.jsp"></jsp:include>
	<script>

		jQuery(document).ready(function() {       

		   App.init();

		   TableEditable.init();

		});

	</script>

</body>

<!-- END BODY -->

</html>