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
<title>Sửa nguyên liệu</title>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>


<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Sửa
					<small>Nguyên liệu</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<%
					Material Item = (Material) request.getAttribute("objItem");
				%>
				<form action="" method="POST">
                	<div class="form-group">
                   		<label>Tên Nguyên Liệu</label>
                   		<input type="text" class="form-control" name="name" 
                   			value="<%=Item.getName() %>" placeholder="Nhập tên nguyên liệu" required />
					</div>
					
					<div class="form-group">
						<label>Đơn Vị Tính</label>
						<input class="form-control" name="unit" value="<%=Item.getName_unit() %>"
							type="text" placeholder="Nhập đơn vị tính" required />
					</div>
					
					<div class="form-group">
						<label>Đường dẫn hình ảnh</label>
						<input class="form-control" name="link" value="<%=Item.getLink() %>"
								placeholder="Nhập URL hình ảnh" />
					</div>
					
					<div class="form-group">
						<label>Ghi Chú</label>
						<textarea class="form-control" name="note"
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