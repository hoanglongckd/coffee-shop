<%@page import="bean.NhanVien"%>
<%@page import="beanAdmin.BillAdmin"%>
<%@page import="beanAdmin.MenuAdmin"%>
<%@page import="bean.Picture"%>
<%@page import="bean.Unit"%>
<%@page import="bean.Menu"%>
<%@page import="bean.Material"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Process"%>
<%@page import="bean.TypeMenu"%>
<%@page import="bean.Table"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<title>Sửa thực đơn</title>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>



<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Sửa
					<small>Thực đơn</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<%
					BillAdmin Item = (BillAdmin) request.getAttribute("objItem");
				%>
				<form action="" method="POST">
                  	<%
						ArrayList<NhanVien> alItemU = (ArrayList<NhanVien>) request.getAttribute("alItemN");
					%>
                    <div class="form-group">
						<label>Nhân Viên</label> 
						<select name="idstaff" class="input-short form-control">
						<% for(NhanVien itemM : alItemU) {
							String selected ="";
							if(itemM.getId()== Item.getId_staff()){
								selected ="selected=\"selected\"";
							}else{
								selected="";
							}
						%>
								<option <%=selected %> value="<%=itemM.getId()%>"><%=itemM.getTen() %></option>
						<%}%>		
						</select>
					</div>
						
					<%
						ArrayList<Table> alItemT = (ArrayList<Table>) request.getAttribute("alItemT");
					%>
                    <div class="form-group">
						<label>Bàn</label>
						<select name="idtable" class="input-short form-control">
						<% for(Table itemM : alItemT) {
							String selected ="";
							if(itemM.getId_table()== Item.getId_table()){
								selected ="selected=\"selected\"";
							}else{
								selected="";
							}
						%>
							<option <%=selected %> value="<%=itemM.getId_table()%>"><%=itemM.getName_table() %></option>
						<%}%>		
						</select>
					</div>
					
                    <div class="form-group">
						<label>Trạng thái thanh toán</label>
						<select name="status" class="input-short form-control">
						<% for(int i= 0; i<2;i++) {
							String selected ="";
							if(Item.getStatus_pay()== i){
								selected ="selected=\"selected\"";
							}else{
								selected="";
							}
						%>
							<option <%=selected %> value="<%=i%>"><%=i %></option>
						<%}%>		
						</select>
					</div>
						
					<div class="form-group">
                    	<label>Ghi chú</label>
                    	<textarea class="form-control" name="note" rows="3"
                    		placeholder="Nhập ghi chú"><%=Item.getNote() %></textarea>
                    </div>

					<button type="submit" name="submit" class="btn btn-default">Edit</button>
					<button type="reset" class="btn btn-default">Reset</button>
				</form>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

<jsp:include page="/templates/inc/_footer-start.jsp" />
<jsp:include page="/templates/inc/_footer-end.jsp" />