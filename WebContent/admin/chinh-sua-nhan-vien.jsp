<%@page import="bean.NgayTrongTuan"%>
<%@page import="bo.PhanCongNhanVienBo"%>
<%@page import="bean.PhanCongNhanVien"%>
<%@page import="bo.CaLamViecBo"%>
<%@page import="bean.CaLamViec"%>
<%@page import="bean.Luong"%>
<%@page import="bean.User"%>
<%@page import="bean.Anh"%>
<%@page import="bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
    <script type="text/javascript" src="<%=request.getContextPath() %>/templates/js/jquery-2.1.1.min.js" ></script>
<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<title>Chỉnh sửa nhân viên</title>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>


<!-- Page Content -->
<% NhanVien nhanVien=(NhanVien)request.getAttribute("nhanVien");
	Anh anh = (Anh) request.getAttribute("anh");
	String idSelect="";
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
					Thông tin
					<small>Nhân viên</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<jsp:include page="./_message-block.jsp" />
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="${pageContext.request.contextPath}/admin/updateNhanVien"
					method="POST">
					<div>
					<input type="hidden"name="idNhanVien" value="<%=nhanVien.getId()%>"/>
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
					
				<div >
					<label>Lịch làm việc </label> 
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr align="center">
								<th> Ca làm việc</th>
								<th> Thứ 2</th>
								<th> Thứ 3</th>
								<th> Thứ 4</th>
								<th> Thứ 5</th>
								<th> Thứ 6</th>
								<th> Thứ 7</th>
								<th> Chủ nhật</th>
							</tr>
						</thead>
					<tbody>
<%
ArrayList<CaLamViec> listCaLamViec = (ArrayList<CaLamViec>)request.getAttribute("listCaLamViec");
ArrayList<PhanCongNhanVien> listLichLamViecTrongTuan = (ArrayList<PhanCongNhanVien>)request.getAttribute("listLichLamViecCuaNhanVien");
ArrayList<NgayTrongTuan> listNgayTrongTuan =(ArrayList<NgayTrongTuan>) request.getAttribute("listNgayTrongTuan");
int idSelectTag = 0;
for(CaLamViec caLamViec : listCaLamViec ){
						String idNhanVienx = nhanVien.getId()+"";
%>						<tr style="text-align: center">
							<td><%= caLamViec.getTenCaLamViec() %></br><%=caLamViec.getThoiGianBatDau() %>-<%=caLamViec.getThoiGianKetThuc()%></td>
							<%
							for(NgayTrongTuan ngay : listNgayTrongTuan){
								idSelectTag +=1;
								int i=1;
								String work="";
								String free="";
								int idPhanCong = 0;
								int trangThai = 0;
								for(PhanCongNhanVien phanCong : listLichLamViecTrongTuan){
									idPhanCong = phanCong.getId();
									if((phanCong.getTenNgay().equals(ngay.getTenNgay()))&&
											(phanCong.getCaLamViec().equals(caLamViec.getTenCaLamViec())))
									{
										work="Selected";
										trangThai = 1;
										i=2;
										listLichLamViecTrongTuan.remove(phanCong);
										break;
									}
								}
								if(i==1) free = "Selected";
								%>
								<td> 
									<select id ="trangthai<%=idSelectTag %>" onchange="changelichlamviec('<%= ngay.getTenNgay()%>','<%= caLamViec.getTenCaLamViec()%>','<%=idSelectTag %>','<%=idNhanVienx %>')" >
										  <option value="work" <%=work%> >Work </option>
										  <option value="free" <%=free%> >Free </option>
									</select>
								</td>
								<%
							}
							%>
							
						</tr>							
<%} %>					
					</tbody>
				</table>
			
			</div>
			<div class="form-group">
						<label>Ghi chú </label> <textarea  rows="5" cols="20" class="form-control" name="ghiChu" ><%= nhanVien.getGhiChu() %></textarea>
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
<script type="text/javascript">
function Warning(){
    var retVal = confirm("Bạn có chắc chắn muốn thay đổi không ?");
    if( retVal == true ){
       return true;
    }
       return false;
 }
</script>
<script>
function changelichlamviec(tenNgay,tenCaLamViec,idSelectTag,idNhanVienx) {
	var trangthai = document.getElementById("trangthai"+idSelectTag).value;
	//alert("name: "+name +"\nComment : "+cmt)
	$.ajax({
		url: '<%=request.getContextPath()%>/admin/changelichlamviec',
		type: 'post',
		cache: false,
		data: {
						//Dữ liệu gửi đi
				idNhanVienx :idNhanVienx,
				trangThai : trangthai,
				tenNgay: tenNgay,
				tenCaLamViec :tenCaLamViec 
				},
		success: function(data){
					// Xử lý thành công
				},
		error: function (){
				// Xử lý nếu có lỗi
		alert("có lỗi xãy ra");
		}
				
		});
		return false;
		}
</script>
<jsp:include page="/templates/inc/_footer-start.jsp" />
<jsp:include page="/templates/inc/_footer-end.jsp" />
</body>

</html>