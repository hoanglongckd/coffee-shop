<%@page import="bean.DetailBill"%>
<%@page import="beanAdmin.BillAdmin"%>
<%@page import="bean.Bill"%>
<%@page import="bean.ImportGoods"%>
<%@page import="bean.Material"%>
<%@page import="bean.TypeMenu"%>
<%@page import="bean.Table"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<title>Chi tiết hóa đơn</title>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>

<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Chi tiết
					<small>Hóa đơn</small>
				</h1>
			</div>
			<%
				ArrayList<DetailBill> alItem = (ArrayList<DetailBill>) request.getAttribute("alItem");
			%>
			<table class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr align="center">
						<th>ID Chi Tiết Hóa Đơn</th>
						<th>Tên Thực Đơn</th>
						<th>Số Lượng</th>
						<th>Số Tiền</th>
						<th>Delete</th>
						<th>Edit</th>
					</tr>
				</thead>
				
				<tbody>
					<%
						for (DetailBill item : alItem) {
							
					%>
					<tr class="odd gradeX" align="center">
						<td><%=item.getId_detail()%></td>
						<td><%=item.getName_menu()%></td>
						<td><%=item.getCount_menu()%></td>
						<td><%=item.getCount_money()%></td>
						
						<td class="center"><i class="fa fa-trash-o  fa-fw"></i><a
							href="<%=request.getContextPath()%>/admin/delDetailBill?id=<%=item.getId_detail()%>">
								Delete</a></td>
						<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
							href="<%=request.getContextPath()%>/admin/editDetailBill?id=<%=item.getId_detail()%>">
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