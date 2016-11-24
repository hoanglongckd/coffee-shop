<%@page import="bean.Picture"%>
<%@page import="bean.Unit"%>
<%@page import="bean.Menu"%>
<%@page import="bean.Material"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>
<%@include file="/templates/inc/left_bar.jsp"%>
<title> Thêm Nguyên liệu</title>



<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Thêm Nguyên liệu <small>Add</small>
				</h1>

			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="" method="post">
					<div class="form-group">
						<%
						ArrayList<Unit> alItemU = (ArrayList<Unit>) request.getAttribute("alItemU");
					%>
						<div class="form-group">
							<label>Đơn vị Tính</label> <select name="unit"
								class="input-short form-control">

								<% for(Unit itemM : alItemU) {%>
								<option value="<%=itemM.getId_unit()%>"><%=itemM.getName() %></option>
								<%}%>

							</select>
						</div>

						<div class="form-group">
							<%
						ArrayList<Picture> alItemT = (ArrayList<Picture>) request.getAttribute("alItemP");
					%>
							<div class="form-group">
								<label>Thực Đơn</label> <select name="picture"
									class="input-short form-control">

									<% for(Picture itemT : alItemT) {%>
									<option value="<%=itemT.getIdPicture()%>"><%=itemT.getName()%></option>
									<%}%>

								</select>
							</div>
							<label>Tên Nguyên Liệu</label> <input class="form-control" name="name"
								placeholder="Please Enter Username" />
							<label>Ghi Chú</label> <input class="form-control" name="note"
								placeholder="Please Enter Username" />
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
