<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li class="sidebar-search">
					<div class="input-group custom-search-form">
						<input type="text" class="form-control" placeholder="Search...">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				<!-- /input-group -->
				</li>
				<li>
					<a href="<%=request.getContextPath()%>/dashboard"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
				</li>
				<li>
					<a href="#"><i class="fa fa-users"></i> Quản lý nhân viên<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="<%=request.getContextPath()%>/admin/addNhanVien">Thêm nhân viên</a></li>
						<li><a href="<%=request.getContextPath()%>/admin/listNhanVien">Danh sách nhân viên</a></li>
					</ul>
					<!-- /.nav-second-level -->
				</li>
				<li>
					<a href="#"><i class="fa fa-bars"></i> Quản lý bàn<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="<%=request.getContextPath()%>/admin/addTable">Thêm bàn</a></li>
						<li><a href="<%=request.getContextPath()%>/admin/indexTable">Danh sách bàn</a></li>
					</ul>
					<!-- /.nav-second-level -->
				</li>
				<li>
					<a href="#"><i class="fa fa-usd"></i> Thống kê lợi nhuận<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="#">Theo tháng</a></li>
							<li><a href="#">Theo năm</a></li>
						</ul>
					<!-- /.nav-second-level -->
				</li>
			</ul>
		</div>
	<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>