<%@page import="bean.ImportGoods"%>
<%@page import="bean.Material"%>
<%@page import="bean.TypeMenu"%>
<%@page import="bean.Table"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<title>Lịch sử nhập hàng</title>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>

<!-- Page Content -->

<div id="page-wrapper">

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">

				<h1 class="page-header">
					Lịch sử
					<small>Nhập hàng</small>
				</h1>

			</div>

			<%
				ArrayList<ImportGoods> alItem = (ArrayList<ImportGoods>) request.getAttribute("alItem");
			%>
			<table class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr align="center">
						<th>ID Nhập hàng</th>
						<th>Tên Nguyên liệu</th>
						<th>Tên Nhân Viên</th>
						<th>Số Lượng</th>
						<th>Số tiền</th>
						<th>Delete</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (ImportGoods item : alItem) {
							
					%>
					<tr class="odd gradeX" align="center">
						<td><%=item.getId_import()%></td>
						<td><%=item.getName_material()%></td>
						<td><%=item.getName_staff()%></td>
						<td><%=item.getCount_goods()%></td>
						<td><%=(int)item.getCount_money()%></td>
						
						<td class="center"><i class="fa fa-trash-o  fa-fw"></i><a
							href="<%=request.getContextPath()%>/admin/delImport?id=<%=item.getId_import()%>">
								Delete</a></td>
						<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
							href="<%=request.getContextPath()%>/admin/editImport?id=<%=item.getId_import()%>">
								Edit</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

<jsp:include page="/templates/inc/_footer-start.jsp" />
<jsp:include page="/templates/inc/_footer-end.jsp" />

