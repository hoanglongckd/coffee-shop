<%@page import="bean.TypeMenu"%>
<%@page import="beanAdmin.MenuAdmin"%>
<%@page import="bean.Picture"%>
<%@page import="bean.Unit"%>
<%@page import="bean.Menu"%>
<%@page import="bean.Material"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<title> Thêm thực đơn</title>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>

<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Thêm
					<small>Thực đơn</small>
				</h1>

			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="" method="post">
					<%
						ArrayList<TypeMenu> alItemU = (ArrayList<TypeMenu>) request.getAttribute("alItem");
					%>
					<div class="form-group">
						<label>Danh mục</label> 
						<select name="idtypemenu" class="input-short form-control" required>
							<% for(TypeMenu itemM : alItemU) {%>
							<option value="<%=itemM.getIdType()%>"><%=itemM.getNameType()%></option>
							<%}%>
						</select>
					</div>
					
					<div class="form-group">
						<label>Tên thực đơn</label> 
						<input class="form-control" name="name"
							placeholder="Nhập tên thực đơn" required />
					</div>
					
					<div class="form-group">
						<label>Giá tiền</label> 
						<input type="number" class="form-control" name="price"
							placeholder="Nhập giá tiền" required />
					</div>
					
					<div class="form-group">
						<label>Đường dẫn hình ảnh </label> 
						<input type="text" class="form-control" name="link"
							placeholder="Nhập đường dẫn hình ảnh" required />
					</div>
					<div class="form-group">
						<label>Mô tả</label> 
						<textarea class="form-control" name="note" placeholder="Nhập mô tả"></textarea>
					</div>



						<button type="submit" name="submit" class="btn btn-default">
							Add</button>
						<!--  <button type="reset" class="btn btn-default">Reset</button> -->
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
