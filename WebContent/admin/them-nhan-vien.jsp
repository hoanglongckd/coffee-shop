<%@page import="bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>
<title>Thêm nhân viên</title>

<!-- Page Content -->
<% 
//int idQuan=Integer.parseInt(request.getAttribute("nhanVien")+"");
%>

<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Thêm <small> nhân viên</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="<%=request.getContextPath() %>/admin/addNhanVien"
					method="POST">
					<div class="form-group">
						<label>Ảnh: </label> <input class="form-control" type="text"
							name="anh" value="" placeholder="Nhập đường dẫn của ảnh" />
					</div>
					<div class="form-group">
						<label>Quán: </label> <input class="form-control" type="text"
							name="quan" value="Moc Coffee" readonly="read-ony"/>
					</div>
					<div class="form-group">
						<label>Tên: </label> <input class="form-control" type="text"
							name="ten" value=""/>
					</div>
					<div class="form-group">
						<label>Ghi chú: </label> 
					</div>
					<div>
						<textarea rows="4" cols="50" name= "ghiChu">
						</textarea>
					</div>
					<br/>
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

</body>

</html>