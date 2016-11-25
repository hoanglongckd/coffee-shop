<%@page import="bean.TypeMenu"%>
<%@page import="bean.Table"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<title>Sửa danh mục</title>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>


<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Sửa
					<small>Danh mục</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<%
					TypeMenu Item = (TypeMenu) request.getAttribute("objItem");
				%>
				<form action="" method="POST">
					<div class="form-group">
						<label>Tên danh mục</label> 
						<input class="form-control" name="nameTable" value="<%=Item.getNameType()%>"
							type="text" placeholder="Nhập tên danh mục" required />
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
</body>

</html>
