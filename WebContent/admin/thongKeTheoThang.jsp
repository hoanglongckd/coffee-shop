<%@page import="bean.ThongkeBean"%>
<%@page import="bo.ThongKeBo"%>
<%@page import="bean.Stock"%>
<%@page import="bean.Unit"%>
<%@page import="bean.Table"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<title>Quản lý kho</title>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>

<%
	ArrayList<ThongkeBean> list = null;
	String month = "", year = "";
	long cost = 0;
	if (request.getAttribute("list") != null) {
		list = (ArrayList<ThongkeBean>) request.getAttribute("list");
	}
	if (request.getAttribute("month") != null && request.getAttribute("year") != null) {
		month = (String) request.getAttribute("month");
		year = (String) request.getAttribute("year");
	}
	if (request.getAttribute("cost") != null) {
		cost = (Long) request.getAttribute("cost");
	}
%>

<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Thống kê
                <%
                	if (!"".equals(month) && !"".equals(year)) {
             	%>
             		<small>lợi nhuận tháng <%=month %> năm <%=year %></small>
                <%
                	}
                	else {
                %>
                	<small>lợi nhuận theo tháng</small>
                <%
                	}
                %>
                </h1>
            </div>
            
            <div class="col-lg-4" style="margin-left: -0.1em; padding-left:0px;">
            <form method="POST">
            	<div class="form-inline" class="form-group">
            		<label>Tổng lợi nhuận</label>
            		<input class="form-control" type="text" name="totalcost" value="<%=cost %>" readonly>
            	</div>
            	</form>
            </div>
            
            <div class="col-lg-4 col-lg-offset-4">
	            <form class="form-inline" method="POST">
	            	<div class="form-group">
	            	<%
	            		if (!"".equals(month) && !"".equals(year)) {
	            	%>
	            		<input class="form-control" type="text" name="filter" value="<%=month %>/<%=year %>"/>
	            	<%
	            		}
	            		else {
	            	%>
	            		<input class="form-control" type="text" name="filter"/>
	            	<%
	            		}
	            	%>
						<button type="submit" class="btn btn-default">Thống kê</button>
					</div>
				</form>
            </div>
            
            
            <jsp:include page="../templates/inc/_message-block.jsp" />
            
            
            <!-- /.col-lg-12 -->
            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                <thead>
                    <tr align="center">
                        <th>STT</th>
                        <th>Tên thực đơn</th>
                        <th>Số lượng nhập</th>
                        <th>Số lượng bán</th>
                        <th>Số tiền nhập</th>
                        <th>Số tiền bán</th>
                        <th>Số tiền lời</th>
                    </tr>
                </thead>
                <tbody>
               	<%
               		int stt = 0;
               		if (list != null) {
               			for (ThongkeBean item : list) {
               				stt++;
               				
               	%>
               		<tr class="odd gradeX" align="center">
               			<td><%=stt %></td>
               			<td><%=item.getName_menu() %>
               			<td><%=item.getSlnhap() %></td>
               			<td><%=item.getSlBan() %></td>
               			<td><%=item.getFee() %></td>
               			<td><%=item.getProfit() %></td>
               			<td><%=item.getProfit() - item.getFee() %></td>
               		</tr>
               	<%
               				
               			}
               		}
               	%>
                </tbody>
            </table>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

<jsp:include page="/templates/inc/_footer-start.jsp" />
<script type="text/javascript">
	$(function() {
	    $('input[name="filter"]').daterangepicker({
	    	locale: 
	    	{
    	    	format: 'MM/YYYY'
    	    },
	    	singleDatePicker: true,
	        showDropdowns: true
	    });
	});
</script>
<jsp:include page="/templates/inc/_footer-end.jsp" />