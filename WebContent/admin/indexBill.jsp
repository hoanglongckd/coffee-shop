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
					Danh Sách Hóa Đơn<small>Danh Sách</small>
				</h1>


			</div>

			<%
				ArrayList<BillAdmin> alItem = (ArrayList<BillAdmin>) request.getAttribute("alItem");
			%>
			<form action="">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr align="center">


							<th>ID Hóa Đơn</th>
							<th>Tên Nhân Viên</th>
							<th>Tên Bàn</th>
							<th>Trạng Thái Thanh Toán</th>
							<th>Ngày Lập Hóa Đơn</th>
							<th>Tổng Tiền</th>
							<th>Ghi Chú</th>
							<th>Delete</th>
							<th>Edit</th>
							<th>Detail</th>
							


						</tr>
					</thead>
					<tbody>
						<%
							for (BillAdmin item : alItem) {
								
						%>
						<tr class="odd gradeX" align="center">
							<td><%=item.getId_bill()%></td>
							<td><%=item.getName_staff()%></td>
							<td><%=item.getName_table()%></td>
							<td><%=item.getStatus_pay()%></td>
							<td><%=item.getDate_single_up()%></td>
							<td><%=item.getSumMoney()%></td>
							<td><%=item.getNote()%></td>
							<td class="center"><i class="fa fa-trash-o  fa-fw"></i><a
								href="<%=request.getContextPath()%>/admin/delBill?id=<%=item.getId_bill()%>">
									Delete</a></td>
							<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
								href="<%=request.getContextPath()%>/admin/editBill?id=<%=item.getId_bill()%>">
									Edit</a></td>
							<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
								href="<%=request.getContextPath()%>/admin/detailBill?id=<%=item.getId_bill()%>">
									Detail</a></td>
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

