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
<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script type="text/javascript" src="<%=request.getContextPath() %>/templates/js/jquery-2.1.1.min.js" ></script>
<%@include file="/templates/inc/_header.jsp" %>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>
<%@include file="/templates/inc/left_bar.jsp"%>

<!-- Page Content -->
<% 
ArrayList<NhanVien> listNhanVien = (ArrayList<NhanVien>)request.getAttribute("listNhanVien");
ArrayList<CaLamViec> listCaLamViec = (ArrayList<CaLamViec>)request.getAttribute("listCaLamViec");
ArrayList<PhanCongNhanVien> listLichLamViecTrongTuan = (ArrayList<PhanCongNhanVien>)request.getAttribute("listLichLamViecCuaNhanVien");
ArrayList<NgayTrongTuan> listNgayTrongTuan =(ArrayList<NgayTrongTuan>) request.getAttribute("listNgayTrongTuan");
int idSelectTag = 0;
%>

<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Phân công lịch làm việc
				</h1>
			</div class="col-lg-12">
			<!-- /.col-lg-12 -->
			<jsp:include page="./_message-block.jsp" />
			<div>
			 <label>Lịch làm việc</label>
			</div>
			<%
			for(NhanVien nhanVien : listNhanVien){
			%>
				<div class="col-lg-12">
					<label><p style="color:red"><%=nhanVien.getTen() %></p></label> 
					<table class="table table-striped table-bordered table-hover" id="dataTables-example">
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
											(phanCong.getCaLamViec().equals(caLamViec.getTenCaLamViec()))&&
											(phanCong.getIdNhanVien()==Integer.parseInt(idNhanVienx)))
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
			<%} %>
			<div class="form-group">
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