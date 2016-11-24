<%@page import="bean.Luong"%>
<%@page import="bean.User"%>
<%@page import="bean.Anh"%>
<%@page import="bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/inc/header.jsp" %>
<%@include file="/templates/inc/left_bar.jsp" %>

<!-- Page Content -->
<% NhanVien nhanVien=(NhanVien)request.getAttribute("nhanVien");
	Anh anh = (Anh) request.getAttribute("anh");
	User user = null;
	if(request.getAttribute("user")!=null)
		user = (User) request.getAttribute("user");
	Luong luong = null;
	if(request.getAttribute("luong")!=null)
		luong = (Luong) request.getAttribute("luong");
%>

<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Thông tin nhân viên
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<jsp:include page="/templates/inc/_message-block.jsp" />
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="${pageContext.request.contextPath}/admin/updateNhanVien"
					method="POST">
					<div>
					<input type="hidden" name="idNhanVien" value="<%=nhanVien.getId()%>"/>
					</div>
					<div class="form-group">
						<label>Ảnh: </label><br/>
						<img src="<%=anh.getDuongDan() %>" alt="Link anh khong ton tai" width="150" />
						<br/>
						<br/>
						<input class="form-control" type="text"	name="duongDan" value="<%=anh.getDuongDan() %>" />
					</div>
					<div class="form-group">
						<label>Quán: </label> <input class="form-control" type="text"
							name="quan" value="Moc Coffee" readonly="read-ony"/>
					</div>
					<div class="form-group">
						<label>Tên: </label> <input class="form-control" type="text"
							name="ten" value="<%=nhanVien.getTen()%>"/>
					</div>
					<%
					if(luong!=null){
					%>
					<div class="form-group">
						<label>Lương theo tháng: </label> <input class="form-control" type="text"
							name="luong" value="<%=luong.getLuong()%>" />
					</div>
					<%
					}else{
					%>	
					<div class="form-group">
					<label>Lương theo tháng: </label> <input class="form-control" type="text"
							name="luong" value="" placeholder="Nhập lương của nhân viên" />
					</div>
					<%	
					}
					if(user!=null){
					%>
					<div class="form-group">
						<label>Tên tài khoản: </label> <input class="form-control" type="text"
							name="username" value="<%=user.getUsername() %>" />
					</div>
					<div class="form-group">
						<label> Mật khẩu: </label> <input class="form-control" type="password"
							name="password" value="<%=user.getPassword() %>" />
					</div>
					<div>
					<input class="form-control" type="hidden"
							name="idUser" value="<%=user.getId_user()%>"/>
					</div>
					<%
					}
					else{
					%>
					<div class="form-group">
						<label>Tên tài khoản: </label> <input class="form-control" type="text"
							name="username" value="" placeholder=" Nhập Username"/>
					</div>
					<div class="form-group">
						<label>Mật khẩu: </label> <input class="form-control" type="password"
							name="password" value="" placeholder=" Nhập Password"/>
					</div>
					<%} %>
					<div class="form-group">
						<label>Ghi chú </label> <textarea  rows="5" cols="20" class="form-control" 
							name="ghiChu" ><%=nhanVien.getGhiChu() %></textarea>
					</div>
					<button type="submit" class="btn btn-default" onClick="return Warning();">Update</button>
					<button type="reset" class="btn btn-default">Reset</button>
				</form>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->
<script>
function Warning(){
    var retVal = confirm("Bạn có chắc chắn muốn thay đổi không ?");
    if( retVal == true ){
       return true;
    }
       return false;
 }
</script>
</body>

</html>