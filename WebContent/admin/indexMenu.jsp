<%@page import="beanAdmin.MenuAdmin"%>
<%@page import="bean.Material"%>
<%@page import="bean.TypeMenu"%>
<%@page import="bean.Table"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp"%>
<title>Danh sách thực đơn</title>
<%@include file="/templates/inc/_top.jsp"%>
<%@include file="/templates/inc/_menu.jsp"%>

<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">

				<h1 class="page-header">
					Danh Sách
					<small>Thực Đơn</small>
				</h1>


			</div>

			<%
				ArrayList<MenuAdmin> alItem = (ArrayList<MenuAdmin>) request.getAttribute("alItem");
			%>
			<form action="">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr align="center">
							<th>ID Thực Đơn</th>
							<th>Tên Thực Đơn</th>
							<th>Tên Loại Thực DƠn</th>
							<th>Gía Tiền</th>
							<th>Mô tả</th>
							<th>Hình Anh</th>
							<th>Delete</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (MenuAdmin item : alItem) {
						%>
						<tr class="odd gradeX" align="center">
							<td><%=item.getId_Menu()%></td>
							<td><%=item.getName()%></td>
							<td><%=item.getName_type_menu()%></td>
							<td><%=item.getPrice()%></td>
							<td><%=item.getMota()%></td>
							<td><img src="<%=item.getLink()%>" alt="No Image"
								width="50" /></td>
							<td class="center"><i class="fa fa-trash-o  fa-fw"></i><a
								href="<%=request.getContextPath()%>/admin/delMenu?id=<%=item.getId_Menu()%>">
									Delete</a></td>
							<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
								href="<%=request.getContextPath()%>/admin/editMenu?id=<%=item.getId_Menu()%>">
									Edit</a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</form>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

<jsp:include page="/templates/inc/_footer-start.jsp" />
<jsp:include page="/templates/inc/_footer-end.jsp" />