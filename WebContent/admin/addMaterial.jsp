<%@page import="bean.Picture"%>
<%@page import="bean.Unit"%>
<%@page import="bean.Menu"%>
<%@page import="bean.Material"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<title> Thêm Nguyên liệu</title>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>

<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Thêm
					<small>Nguyên liệu</small>
				</h1>

			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="" method="post">
					<div class="form-group">
						<label>Tên Nguyên Liệu</label> 
						<input type="text" class="form-control" name="name" 
							placeholder="Nhập tên nguyên liệu" required />
					</div>
					
					<div class="form-group">
						<label>Đơn Vị Tính</label>
						<input type="text" class="form-control" name="unit" 
							placeholder="Nhập đơn vị tính" required />
					</div>
					
					<div class="form-group">
						<label>Đường dẫn hình ảnh</label> 
						<input type="text" class="form-control" name="link" 
							placeholder="Nhập URL hình ảnh" required />
					</div>
					
					<div class="form-group">
						<label>Ghi Chú</label> 
						<textarea class="form-control" name="note" 
							placeholder="Nhập ghi chú" ></textarea>
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
