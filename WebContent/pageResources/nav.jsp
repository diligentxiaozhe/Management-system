
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<ul class="page-sidebar-menu">

	<li>
		<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

		<div class="sidebar-toggler hidden-phone"></div> <!-- BEGIN SIDEBAR TOGGLER BUTTON -->

	</li>

	<li>
		<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->

		<form class="sidebar-search">

			<div class="input-box">

				<a href="javascript:;" class="remove"></a> <input type="text"
					placeholder="搜索..." /> <input type="button" class="submit"
					value=" " />

			</div>

		</form> <!-- END RESPONSIVE QUICK SEARCH FORM -->

	</li>

	<li class="start active "><a href="index.jsp"> <i
			class="icon-home"></i> <span class="title">后台首页</span> <span
			class="selected"></span>

	</a></li>


	<li class="last"><a href="javascript:;"> <i class="icon-user"></i>

			<span class="title">用户管理</span> <span class="arrow "></span>

	</a>

		<ul class="sub-menu">

			<li><a href="SelectServlet?do=user-list">用户管理</a></li>

			<li><a href="AddServlet?do=add">添加用户</a></li>
		</ul></li>


	<!--权限管理  -->
	<li class="last"><a href="javascript:;"> <i
			class="icon-lock"></i> <span class="title">商品管理</span> <span
			class="arrow "></span>

	</a>

		<ul class="sub-menu">

			<li><a href="GoodsSelectServlet?do=goods-list">商品管理</a></li>
            <li><a href="AddGoodsServlet?do=add">添加商品</a></li>

		</ul></li>

	<!--菜单管理  -->
	<li class="last"><a href="javascript:;"> <i
			class="icon-sitemap"></i> <span class="title">菜单管理</span> <span
			class="arrow "></span>

	</a>

		<ul class="sub-menu">

			<li><a href="user-list.jsp">菜单列表</a></li>

			<li><a href="user-list.jsp">添加菜单</a></li>


		</ul></li>

</ul>