<%@page import="bean.Material"%>
<%@page import="bean.TypeMenu"%>
<%@page import="bean.Table"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>
<%@include file="/templates/inc/left_bar.jsp"%>
<title> Danh sách Nguyên liệu</title>

<!-- Page Content -->

<div id="page-wrapper">

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">

				<h1 class="page-header">
					Danh Sách Nguyên liệu <small>Danh Sách</small>
				</h1>


			</div>

			<%
				ArrayList<Material> alItem = (ArrayList<Material>) request.getAttribute("alItem");
			%>
			<form action="">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr align="center">


							<th>ID Nguyên liêu</th>
							<th>Tên Nguyên liệu</th>
							<th>Tên Đơn vị</th>
							<th>Ghi chú</th>
							<th>Tên ảnh</th>
							<th>Delete</th>
							<th>Edit</th>


						</tr>
					</thead>
					<tbody>
						<%
							for (Material item : alItem) {
								String pic = request.getContextPath() +"/files/" +item.getName_picture();
						%>
						<tr class="odd gradeX" align="center">
							<td><%=item.getId_material()%></td>
							<td><%=item.getName()%></td>
							<td><%=item.getName_unit()%></td>
							<td><%=item.getNote()%></td>
							<%
							if(!"".equals(item.getName_picture())){
								
							%>
							<td align="center"><img src="<%=pic %>" class="hoa" /></td>
							<%}else{ %>
								<p>chưa update anh</p>
							<%} %>
							
							<td class="center"><i class="fa fa-trash-o  fa-fw"></i><a
								href="<%=request.getContextPath()%>/admin/delMaterial?id=<%=item.getId_material()%>">
									Delete</a></td>
							<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
								href="<%=request.getContextPath()%>/admin/editMaterial?id=<%=item.getId_material()%>">
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

