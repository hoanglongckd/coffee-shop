<%@page import="bean.Table"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<title>Edit Table</title>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>


<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Sửa 
					<small>Bàn</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<%
					Table table = (Table) request.getAttribute("objTable");
				%>
				<form action="" method="POST">
					<div class="form-group">
					
						<label>Tên bàn</label>
						<input class="form-control" name="nameTable" value="<%=table.getName_table()%>"
							placeholder="Nhập tên bàn" required />
					</div>
					<div class="form-group">
						<label>Trạng thái</label> 
						<select name="status" class="input-short form-control" required >
							<%
								for (int i = 0; i < 2; i++) {
									String selected = "";
									if (table.getStatus() == i) {
										selected = "selected=\"selected\"";
									} else {
										selected = "";
									}
							%>
							<option <%=selected%> value="<%=i%>"><%=i%></option>
							<%
								}
							%>
							</select>
						
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