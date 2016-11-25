<%@page import="bean.Luong"%>
<%@page import="bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/inc/header.jsp" %>
<%@include file="/templates/inc/left_bar.jsp" %>


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
						Dash board
					</h1>
				</div>
				
				<!-- /.col-lg-12 -->
				<jsp:include page="./_message-block.jsp" />
				
				<large>Hello world !!</large>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /#page-wrapper -->

</div>

</body>

</html>
