<%@page import="bean.Luong"%>
<%@page import="bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>
<%@include file="/templates/inc/left_bar.jsp"%>
<title> Danh sách Nhân viên</title>

<div id="wrapper">
	<!-- Page Content -->
	<%
	ArrayList<NhanVien> listNhanVien = null;
	if(request.getAttribute("listNhanVien")!=null){
		listNhanVien = (ArrayList<NhanVien>)request.getAttribute("listNhanVien");
	}
	ArrayList<Luong> listLuongNhanVien = null;
	if(request.getAttribute("listLuongNhanVien")!=null){
		listLuongNhanVien = (ArrayList<Luong>)request.getAttribute("listLuongNhanVien");
	}
	%>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Danh sách <small>Nhân viên</small>
					</h1>
				</div>
				
				<!-- /.col-lg-12 -->
				<jsp:include page="/templates/inc/_message-block.jsp" />
				
				<table class="table table-striped table-bordered table-hover" id="dataTables-example">
					<thead>
						<tr align="center">
							<th> Stt</th>
							<th> Ảnh</th>
							<th> Tên quán</th>
							<th> Tên nhân viên</th>
							<th> Lương</th>
							<th> Edit</th>
							<th> Delete</th>
						</tr>
					</thead>
					<tbody>
					
						<% int  i=1;
						for (NhanVien a : listNhanVien){
							
							%>
								<tr >
									<td><%=i%></td>
									<td>
										<img src="<%=a.getDuongDanAnh() %>" alt="No Image" width="50" />
									</td>
									
									<td> <%=a.getTenQuan() %></td>
									
									<td><%=a.getTen()%></td>
									
									<%
									boolean check=false;
									for(Luong luong : listLuongNhanVien){
										if(luong.getIdNhanVien() == a.getId()){
									%>
									<td><%=luong.getLuong() %></td>		
									<%
										check=true;
										break;
										}
									}
									if(check!=true){
									%>
									<td>Null</td>
									<%} %>						
									<td><i class="fa fa-pencil"></i> <a href="<%=request.getContextPath()%>/admin/updateNhanVien?idNhanVien=<%=a.getId()%>"> Detail</a> </td>
									<td><i class="fa fa-trash-o fa-fw"></i> <a href="<%=request.getContextPath()%>/admin/deleteNhanVien?idNhanVien=<%=a.getId()%>" onClick="return Warning();"> Delete</a></td>
								</tr>
						 <%
						 i++;
						 }%>
					</tbody>
				</table>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /#page-wrapper -->

</div>
<script>
function Warning(){
    var retVal = confirm("Do you want to delete ?");
    if( retVal == true ){
       return true;
    }
       return false;
 }
</script>
<jsp:include page="/templates/inc/_footer-start.jsp" />
<jsp:include page="/templates/inc/_footer-end.jsp" />
