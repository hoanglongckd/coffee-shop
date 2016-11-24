<%@page import="bean.Stock"%>
<%@page import="bean.Unit"%>
<%@page import="bean.Table"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>
<%@include file="/templates/inc/left_bar.jsp"%>
<title> Danh sách Nguyên liệu trong Kho</title>



<!-- Page Content -->

<div id="page-wrapper">

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">

				<h1 class="page-header">
					Kho <small>List</small>
				</h1>

			</div>

			<%
				ArrayList<Stock> alItem = (ArrayList<Stock>) request.getAttribute("alItem");
			%>
			<form action="">
			<table class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr align="center">

						<th>ID Kho</th>
						<th>Tên Nguyen Liệu</th>
						<th>Tổng số Lượng Còn</th>
						<th>Delete</th>
						<th>Edit</th>

						

					</tr>
				</thead>
				<tbody>
					<%
						for (Stock item : alItem) {
					%>
					<tr class="odd gradeX" align="center">
						<td><%=item.getId_stock()%></td>
						<td><%=item.getName_material()%></td>
						<td><%=item.getTotalNumber()%></td>
						<td class="center"><i class="fa fa-trash-o  fa-fw"></i><a
							href="<%=request.getContextPath()%>/admin/delStock?id=<%=item.getId_stock()%>"> Delete</a></td>
						<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
							href="<%=request.getContextPath()%>/admin/editStock?id=<%=item.getId_stock()%>"> Edit</a></td>
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




</body>

</html>
