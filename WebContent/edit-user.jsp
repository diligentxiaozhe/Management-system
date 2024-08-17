<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>

<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>修改用户信息页面</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	<!-- BEGIN GLOBAL MANDATORY STYLES -->

	<jsp:include page="pageResources/css.jsp"></jsp:include>

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES -->

	<link rel="stylesheet" type="text/css" href="media/css/select2_metro.css" />

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

			
				<div class="portlet-body form">

					<form action="EditServlet?do=edit" method="post" class="horizontal-form">

						<div class="row-fluid">

							<div class="span12 ">

								<div class="control-group">

									<label class="control-label">姓名</label>

									<div class="controls">

										<input type="text" name="name" value="${user.name }"  class="m-wrap span12">

									</div>

								</div>

							</div>
					

						</div>
						
						<div class="row-fluid">

							<div class="span12 ">

								<div class="control-group">

									<label class="control-label">年龄</label>

									<div class="controls">

										<input type="text" name="age" value="${user.age }" class="m-wrap span12">
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid">

							<div class="span12 ">

								<div class="control-group">

									<label class="control-label">密码</label>

									<div class="controls">

										<input type="password"  name="password" value="${user.password }" class="m-wrap span12">
                                        <input type="hidden"  name="id" value="${user.id }">
									</div>

								</div>

							</div>
					

						</div>
						
					<div class="row-fluid">

							<div class="span12 ">

								<div class="control-group">

									<label class="control-label">邮箱</label>

									<div class="controls">

										<input type="text" name="email" value="${user.email }" class="m-wrap span12">
									</div>
								</div>
							</div>
					</div>



						<div class="form-actions">

							<button type="submit" class="btn blue">
								<i class="icon-ok"></i> 提交
							</button>

							<button type="button" class="btn">取消</button>

						</div>

					</form>
				</div>


			</div>

			<!-- END PAGE CONTAINER-->

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<jsp:include page="pageResources/foot.jsp"></jsp:include>

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