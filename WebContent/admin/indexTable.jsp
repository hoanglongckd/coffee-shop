<%@page import="bean.Table"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>
<%@include file="/templates/inc/left_bar.jsp"%>

<title>Danh sách bàn</title>

<!-- Page Content -->

<div id="page-wrapper">

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">

				<h1 class="page-header">
					MANAGER TABLE <small>List</small>
				</h1>
			</div>

			<%
				ArrayList<Table> alItem = (ArrayList<Table>) request.getAttribute("alItem");
			%>
			<table class="table table-striped table-bordered table-hover" id="dataTables-example">
				<thead>
					<tr align="center">

						<th>ID Table</th>
						<th>Name Table</th>
						<th>Status</th>
						<th>Delete</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Table table : alItem) {
					%>
					<tr class="odd gradeX" align="center">
						<td><%=table.getId_table()%></td>
						<td><%=table.getName_table()%></td>
						<td><%=table.getStatus()%></td>
						<td class="center"><i class="fa fa-trash-o  fa-fw"></i><a
							href="<%=request.getContextPath()%>/admin/delTable?tid=<%=table.getId_table()%>"> Delete</a></td>
						<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
							href="<%=request.getContextPath()%>/admin/editTable?tid=<%=table.getId_table()%>"> Edit</a></td>
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