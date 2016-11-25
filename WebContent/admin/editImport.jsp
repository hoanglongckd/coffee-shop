<%@page import="beanAdmin.MenuAdmin"%>
<%@page import="bean.NhanVien"%>
<%@page import="bean.ImportGoods"%>
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
<title>Sửa nhập hàng</title>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>


<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
				Sửa
				<small>Edit</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<%
				ImportGoods Item = (ImportGoods) request.getAttribute("objItem");
				%>
				<form action="" method="POST">
					<%
						ArrayList<MenuAdmin> alItemM = (ArrayList<MenuAdmin>) request.getAttribute("alItemN");
					%>
                    <div class="form-group">
						<label>Nguyên Liệu</label> 
						<select name="material" class="input-short form-control">
							<% for(MenuAdmin itemM : alItemM) {
								String selected ="";
								if(itemM.getId_Menu()== Item.getId_material()){
									selected ="selected=\"selected\"";
								}else{
									selected="";
								}
							%>
							<option <%=selected %> value="<%=itemM.getId_Menu()%>"><%=itemM.getName() %></option>
							<%}%>		
						</select>
					</div>
						
					<%
						ArrayList<NhanVien> alItemN = (ArrayList<NhanVien>) request.getAttribute("alItemM");
					%>
                   	<div class="form-group">
						<label>Nhân Viên</label> 
						<select name="staff" class="input-short form-control">
						<% for(NhanVien itemM : alItemN) {
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
                    	
                   	<div class="form-group">
                       	<label>Số lượng</label> 
                       	<input type="number" class="form-control" name="sl" value="<%=Item.getCount_goods() %>"
							placeholder="Nhập số lượng" required /> 
					</div>	
					
					<div class="form-group">
						<label>Giá tiền</label> 
						<input type="number" class="form-control" name="money"  value="<%=Item.getCount_money() %>"
							placeholder="Nhập số tiền" required />
					</div>
					
					<div class="form-group">
						<label>Ngày hết hạn</label> 
						<input class="form-control" type="text" name="date_end" value="<%=Item.getDate_end() %>"
							placeholder="Nhập ngày hết hạn" required />
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
