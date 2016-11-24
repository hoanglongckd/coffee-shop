<%@page import="bean.NhanVien"%>
<%@page import="bean.Picture"%>
<%@page import="bean.Unit"%>
<%@page import="bean.Menu"%>
<%@page import="bean.Material"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp"%>
<%@include file="/templates/inc/_top.jsp"%>
<%@include file="/templates/inc/_menu.jsp"%>
<%@include file="/templates/inc/left_bar.jsp"%>
<title>Thêm Nguyên liệu</title>



<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Nhập thêm hàng<small>Add</small>
				</h1>

			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="" method="post">
					<div class="form-group">

						<div class="form-group">
							<%
								ArrayList<Material> alItemM = (ArrayList) request.getAttribute("alItemM");
							%>
							<div class="form-group">
								<label>Nhập Nguyên Liệu</label> <select name="material"
									class="input-short form-control">

									<%
										for (Material itemM : alItemM) {
									%>
									<option value="<%=itemM.getId_material()%>"><%=itemM.getName()%></option>
									<%
										}
									%>

								</select>
							</div>

							<%
								ArrayList<NhanVien> alItemN = (ArrayList) request.getAttribute("alItemN");
							%>
							<div class="form-group">
								<label>Chọn Nhân Viên</label> <select name="staff"
									class="input-short form-control">

									<%
										for (NhanVien itemM : alItemN) {
									%>
									<option value="<%=itemM.getId()%>"><%=itemM.getTen()%></option>
									<%
										}
									%>

								</select>
							</div>

							<label>Nhập Số Lượng nhập hàng</label> <input
								class="form-control" name="sl"
								placeholder="Please Enter Username" /> <label>Nhập Số
								Tiền</label> <input class="form-control" name="money"
								placeholder="Please Enter Username" />
								<label>Nhập Ngày Hêt hạn</label> <input class="form-control" type="date" name="date_end"
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
