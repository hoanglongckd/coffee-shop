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
					<a href="<%=request.getContextPath()%>/admin/dashboard"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
				</li>
				<li>
					<a href="#"><i class="fa fa-users"></i> Quản lý nhân viên<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="<%=request.getContextPath()%>/admin/addNhanVien">Thêm nhân viên</a></li>
						<li><a href="<%=request.getContextPath()%>/admin/listNhanVien">Danh sách nhân viên</a></li>
						<li><a href="<%=request.getContextPath()%>/admin/phancong">Lịch làm việc</a></li>
					</ul>
					<!-- /.nav-second-level -->
				</li>
				<li>
					<a href="#"><i class="fa fa-square-o"></i> Quản lý bàn<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="<%=request.getContextPath()%>/admin/addTable">Thêm bàn</a></li>
						<li><a href="<%=request.getContextPath()%>/admin/indexTable">Danh sách bàn</a></li>
					</ul>
					<!-- /.nav-second-level -->
				</li>
				<li>
                    <a  href="#"><i class="fa fa-bars"></i> Menu<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                    	<li><a href="<%=request.getContextPath()%>/admin/addMenu">Add Menu</a></li>
                        <li><a href="<%=request.getContextPath()%>/admin/indexMenu">List Menu</a></li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                
                <li>
                    <a  href="#"><i class="fa fa-bars"></i> Hóa Đơn<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                    	
                        <li><a href="<%=request.getContextPath()%>/admin/indexBill">List Hóa Đơn</a></li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="#"><i class="fa fa-cube fa-fw"></i> Nhập hàng<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                    	<li><a href="<%=request.getContextPath()%>/admin/addImport">Thêm hàng mới</a></li>
                        <li><a href="<%=request.getContextPath()%>/admin/indexImport">Danh sách hàng hóa</a></li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="#"><i class="fa fa-sticky-note-o"></i> Order <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                    	<li><a href="<%=request.getContextPath()%>/admin/addOrder.jsp">Add order</a></li>
                        <li><a href="<%=request.getContextPath()%>/admin/order.jsp">List order</a></li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
<!--                 <li> -->
<!--                     <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Count Profit <span class="fa arrow"></span></a> -->
<!--                     <ul class="nav nav-second-level"> -->
<!--                         <li> -->
<%--                             <a href="<%=request.getContextPath()%>/admin/countProfit.jsp">List Count profit</a> --%>
<!--                         </li> -->
<!--                     </ul> -->
<!--                     /.nav-second-level -->
<!--                 </li> -->
                <li>
                    <a href="#"><i class="glyphicon glyphicon-th-large"></i> Type Menu <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="<%=request.getContextPath()%>/admin/addTypeMenu"> Add Type Menu</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
<!--                 <li> -->
<!--                     <a href="#"><i class="fa fa-fire"></i> Chế Biến <span class="fa arrow"></span></a> -->
<!--                     <ul class="nav nav-second-level"> -->
<!--                     	<li> -->
<%--                             <a href="<%=request.getContextPath()%>/admin/addProcess"> Thêm Chế biến</a> --%>
<!--                         </li> -->
<!--                     	<li> -->
<%--                             <a href="<%=request.getContextPath()%>/admin/indexProcess"> List Chế biến</a> --%>
<!--                         </li> -->
<!--                     </ul> -->
<!--                     /.nav-second-level -->
<!--                 </li> -->
<!--                 <li> -->
<!--                     <a href="#"><i class="glyphicon glyphicon-th"></i> Đơn Vị Tinh <span class="fa arrow"></span></a> -->
<!--                     <ul class="nav nav-second-level"> -->
<!--                     <li> -->
<%--                         <a href="<%=request.getContextPath()%>/admin/addUnit"> Thêm Đơn Vị Tính</a> --%>
<!--                     </li> -->
<!--                     <li> -->
<%--                         <a href="<%=request.getContextPath()%>/admin/indexUnit"> List Đơn Vị Tính</a> --%>
<!--                     </li> -->
<!--                     </ul> -->
<!--                     /.nav-second-level -->
<!--                 </li> -->
                <li>
                    <a href="#"><i class="glyphicon glyphicon-inbox"></i> Nguyên Liệu Trong Kho <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="<%=request.getContextPath()%>/admin/indexStock"> List nguyên liệu trong kho</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="#"><i class="glyphicon glyphicon-list-alt"></i> Nguyên Liệu <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                    	<li>
                            <a href="<%=request.getContextPath()%>/admin/addMaterial"> Thêm Nguyên Liệu</a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/admin/indexMaterial"> Danh Sách Nguyên Liệu</a>
                        </li>
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