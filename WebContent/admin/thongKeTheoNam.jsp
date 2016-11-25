<%@page import="bean.ThongkeBean"%>
<%@page import="bean.Stock"%>
<%@page import="bean.Unit"%>
<%@page import="bean.Table"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<title>Thống kê theo năm</title>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>


<%
ArrayList<ThongkeBean> listThongKeTheoNam = (ArrayList<ThongkeBean>) request.getAttribute("listThongKeTheoNam");
String nam = request.getAttribute("nam").toString();
String tongLoiNhuan = request.getAttribute("tongLoiNhuan").toString();
%>

<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Thống kê
                <%
                	if (!"".equals(nam)) {
             	%>
             		<small>lợi nhuận năm <%=nam %></small>
                <%
                	}
                	else {
                %>
                	<small>lợi nhuận theo năm</small>
                <%
                	}
                %>
                </h1>
            </div>
            
            <div class="col-lg-4" style="margin-left: -0.1em; padding-left:0px;">
            <form method="POST">
            	<div class="form-inline" class="form-group">
            		<label>Tổng lợi nhuận</label>
            		<input class="form-control" type="text" name="totalcost" value="<%=tongLoiNhuan %>" readonly>
            	</div>
            	</form>
            </div>
            
            <div class="col-lg-4 col-lg-offset-4">
	            <form action="<%=request.getContextPath() %>/admin/thong-ke-theo-nam" class="form-inline" method="POST">
	            	<div class="form-group">
	            	<%
	            		if (!"".equals(nam)) {
	            	%>
	            		<input class="form-control" type="number" name="year" value="<%=nam %>"/>
	            	<%
	            		}
	            		else {
	            	%>
	            		<input class="form-control" type="number" placeholder="Nhập năm" name="year"/>
	            	<%
	            		}
	            	%>
						<button type="submit" class="btn btn-default">Thống kê</button>
					</div>
				</form>
            </div>
            <div class= "form-group">
            </br>
            </br>
            </div>
            <!-- /.col-lg-12 -->
            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                <thead>
                    <tr align="center">
                        <th>STT</th>
                        <th>Tên thực đơn </th>
                        <th>Số lượng nhập</th>
                        <th>Số lượng bán</th>
                        <th>Số tiền nhập</th>
                        <th>Số tiền bán</th>
                        <th>Số tiền lời</th>
                    </tr>
                </thead>
                <%
                int i=0;
                for(ThongkeBean thongKe : listThongKeTheoNam){
                	i++;
                %>
                <tbody>
               		<tr class="odd gradeX" align="center">
               			<td><%=i %></td>
               			<td><%=thongKe.getName_menu() %></td>
               			<td><%=thongKe.getSlnhap() %></td>
               			<td><%=thongKe.getSlBan() %></td>
               			<td><%=thongKe.getFee() %></td>
               			<td><%=thongKe.getProfit() %></td>
               			<td><%=(thongKe.getProfit()-thongKe.getFee()) %></td>
               		</tr>
                </tbody>
                <%} %>
            </table>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

<jsp:include page="/templates/inc/_footer-start.jsp" />
<jsp:include page="/templates/inc/_footer-end.jsp" />