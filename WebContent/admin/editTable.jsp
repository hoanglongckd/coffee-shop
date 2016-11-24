<%@page import="bean.Table"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/header.jsp"%>
<%@include file="/templates/inc/left_bar.jsp"%>



<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Edit Table <small>Edit</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<%
					Table table = (Table) request.getAttribute("objTable");
				%>
				<form action="" method="POST">
					<div class="form-group">
						<label>Name Table</label> <input class="form-control"
							name="nameTable" value="<%=table.getName_table()%>"
							placeholder="Please Enter Username" />
					</div>
					<div class="form-group">
						<label>Status Table</label> <select name="status"
							class="input-short form-control">


							<option value="1">1</option>
							<option value="0">0</option>

						</select>
					</div>


					<button type="submit" name="submit" class="btn btn-default">
						Edit</button>
					<!--  <button type="reset" class="btn btn-default">Reset</button> -->
				</form>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->


</body>

</html>
