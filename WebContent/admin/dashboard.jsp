<%@page import="bean.Luong"%>
<%@page import="bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>

<title>Dashboard</title>
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
			</div>
			
			<div class="row">
				<div class="col-lg-3 col-md-6">
		            <div class="panel panel-primary">
		                <div class="panel-heading">
		                    <div class="row">
		                        <div class="col-xs-3">
		                            <i class="fa fa-square-o fa-5x"></i>
		                        </div>
		                        <div class="col-xs-9 text-right">
		                            <div class="huge"></div>
		                            <div>Quản lý bàn</div>
		                        </div>
		                    </div>
		                </div>
		                <a href="<%=request.getContextPath()%>/admin/indexTable">
		                    <div class="panel-footer">
		                        <span class="pull-left">Xem chi tiết</span>
		                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
		                        <div class="clearfix"></div>
		                    </div>
		                </a>
		            </div>
		        </div>
		        
		        <div class="col-lg-3 col-md-6">
		            <div class="panel panel-success">
		                <div class="panel-heading">
		                    <div class="row">
		                        <div class="col-xs-3">
		                            <i class="glyphicon glyphicon-th-large fa-5x"></i>
		                        </div>
		                        <div class="col-xs-9 text-right">
		                            <div class="huge"></div>
		                            <div>Danh mục</div>
		                        </div>
		                    </div>
		                </div>
		                <a href="<%=request.getContextPath()%>/admin/indexTypeMenu">
		                    <div class="panel-footer">
		                        <span class="pull-left">Xem chi tiết</span>
		                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
		                        <div class="clearfix"></div>
		                    </div>
		                </a>
		            </div>
		        </div>
		        
		        <div class="col-lg-3 col-md-6">
		            <div class="panel panel-default">
		                <div class="panel-heading">
		                    <div class="row">
		                        <div class="col-xs-3">
		                            <i class="fa fa-bars fa-5x"></i>
		                        </div>
		                        <div class="col-xs-9 text-right">
		                            <div class="huge"></div>
		                            <div>Thực đơn</div>
		                        </div>
		                    </div>
		                </div>
		                <a href="<%=request.getContextPath()%>/admin/indexMenu">
		                    <div class="panel-footer">
		                        <span class="pull-left">Xem chi tiết</span>
		                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
		                        <div class="clearfix"></div>
		                    </div>
		                </a>
		            </div>
		        </div>
		        
		        <div class="col-lg-3 col-md-6">
		            <div class="panel panel-danger">
		                <div class="panel-heading">
		                    <div class="row">
		                        <div class="col-xs-3">
		                            <i class="fa fa-cube fa-5x"></i>
		                        </div>
		                        <div class="col-xs-9 text-right">
		                            <div class="huge"></div>
		                            <div>Nhập hàng</div>
		                        </div>
		                    </div>
		                </div>
		                <a href="<%=request.getContextPath()%>/admin/indexImport">
		                    <div class="panel-footer">
		                        <span class="pull-left">Xem chi tiết</span>
		                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
		                        <div class="clearfix"></div>
		                    </div>
		                </a>
		            </div>
		        </div>
	        </div>
	        
	        <div class="row">
		        <div class="col-lg-3 col-md-6">
		            <div class="panel panel-info">
		                <div class="panel-heading">
		                    <div class="row">
		                        <div class="col-xs-3">
		                            <i class="fa fa-clone fa-5x"></i>
		                        </div>
		                        <div class="col-xs-9 text-right">
		                            <div class="huge"></div>
		                            <div>Hóa đơn</div>
		                        </div>
		                    </div>
		                </div>
		                <a href="<%=request.getContextPath()%>/admin/indexBill">
		                    <div class="panel-footer">
		                        <span class="pull-left">Xem chi tiết</span>
		                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
		                        <div class="clearfix"></div>
		                    </div>
		                </a>
		            </div>
		        </div>
		        
		        <div class="col-lg-3 col-md-6">
		            <div class="panel panel-warning">
		                <div class="panel-heading">
		                    <div class="row">
		                        <div class="col-xs-3">
		                            <i class="glyphicon glyphicon-inbox fa-5x"></i>
		                        </div>
		                        <div class="col-xs-9 text-right">
		                            <div class="huge"></div>
		                            <div>Quản lý kho</div>
		                        </div>
		                    </div>
		                </div>
		                <a href="<%=request.getContextPath()%>/admin/indexStock">
		                    <div class="panel-footer">
		                        <span class="pull-left">Xem chi tiết</span>
		                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
		                        <div class="clearfix"></div>
		                    </div>
		                </a>
		            </div>
		        </div>
		        
		        <div class="col-lg-3 col-md-6">
		            <div class="panel panel-success">
		                <div class="panel-heading">
		                    <div class="row">
		                        <div class="col-xs-3">
		                            <i class="fa fa-usd fa-5x"></i>
		                        </div>
		                        <div class="col-xs-9 text-right">
		                            <div class="huge"></div>
		                            <div>Thống kê lợi nhuận</div>
		                        </div>
		                    </div>
		                </div>
		                <a href="<%=request.getContextPath()%>/admin/thong-ke-theo-nam">
		                    <div class="panel-footer">
		                        <span class="pull-left">Xem chi tiết</span>
		                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
		                        <div class="clearfix"></div>
		                    </div>
		                </a>
		            </div>
		        </div>
		        
		        <div class="col-lg-3 col-md-6">
		            <div class="panel panel-info">
		                <div class="panel-heading">
		                    <div class="row">
		                        <div class="col-xs-3">
		                            <i class="fa fa-users fa-5x"></i>
		                        </div>
		                        <div class="col-xs-9 text-right">
		                            <div class="huge"></div>
		                            <div>Quản lý nhân viên</div>
		                        </div>
		                    </div>
		                </div>
		                <a href="<%=request.getContextPath()%>/admin/listNhanVien">
		                    <div class="panel-footer">
		                        <span class="pull-left">Xem chi tiết</span>
		                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
		                        <div class="clearfix"></div>
		                    </div>
		                </a>
		            </div>
		        </div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /#page-wrapper -->

</div>
<jsp:include page="/templates/inc/_footer-start.jsp" />
<jsp:include page="/templates/inc/_footer-end.jsp" />