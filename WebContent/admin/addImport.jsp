<%@page import="beanAdmin.MenuAdmin"%>
<%@page import="bean.NhanVien"%>
<%@page import="bean.Picture"%>
<%@page import="bean.Unit"%>
<%@page import="bean.Menu"%>
<%@page import="bean.Material"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp"%>
<title>Nhập hàng hóa</title>
<%@include file="/templates/inc/_top.jsp"%>
<%@include file="/templates/inc/_menu.jsp"%>




<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Nhập
					<small>Hàng hóa</small>
				</h1>

			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="" method="post">
					<%
						ArrayList<MenuAdmin> alItemM = (ArrayList) request.getAttribute("alItemN");
					%>
					<div class="form-group">
						<label>Nhập Nguyên Liệu</label> 
						<select name="material" class="input-short form-control">

							<%
								for (MenuAdmin itemM : alItemM) {
							%>
							<option value="<%=itemM.getId_Menu()%>"><%=itemM.getName()%></option>
							<%
								}
							%>
						</select>
					</div>
					
					<div class="form-group">
						<label>Số lượng</label> 
						<input type="number" class="form-control" name="sl"
							placeholder="Nhập số lượng" required /> 
					</div>
							
					<div class="form-group">
						<label>Nhập số tiền</label> 
						<input type="number" class="form-control" name="money"
							placeholder="Please Enter Username" required />
					</div>
					
					<div class="form-group">
						<label>Nhập Ngày Hêt hạn</label> 
						<input class="form-control" type="date" name="date_end"
							placeholder="Nhập ngày hết hạn" required />
					</div>

					<button type="submit" name="submit" class="btn btn-default">Add</button>
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
