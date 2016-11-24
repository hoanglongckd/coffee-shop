<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



   
            <!-- /.navbar-top-links -->

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
                            <a href="#"><i class="fa fa-users fa-fw"></i> Quản lý nhân viên<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/listNhanVien"> Danh sách nhân viên</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/addNhanVien"> Thêm nhân viên</a>
                                </li>
                                
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a  href="<%=request.getContextPath()%>/admin/menu.jsp"><i class="fa fa-cube fa-fw"></i>Menu<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/menu.jsp">List Menu</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/addMenu.jsp">Add Menu</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/admin/importProduct.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> Import Product<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/importProduct.jsp">List import product</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/addImportProduct.jsp">Add import product</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/admin/order.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> Order <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/order.jsp">List order</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/addOrder.jsp">Add order</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/admin/countProfit.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> Count profit <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/countProfit.jsp">List Count profit</a>
                                </li>
                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/admin/indexTypeMenu"><i class="fa fa-bar-chart-o fa-fw"></i> Type Menu <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/addTypeMenu"> Add Type Menu</a>
                                </li>
                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                         <li>
                            <a href="<%=request.getContextPath()%>/admin/indexProcess"><i class="fa fa-bar-chart-o fa-fw"></i> Chế Biến <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                            	<li>
                                    <a href="<%=request.getContextPath()%>/admin/indexProcess"> List Chế biến</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/addProcess"> Thêm Chế biến</a>
                                </li>
                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="<%=request.getContextPath()%>/admin/indexUnit"><i class="fa fa-bar-chart-o fa-fw"></i> Đơn Vị Tinh <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                            <li>
                                    <a href="<%=request.getContextPath()%>/admin/indexUnit"> List Đơn Vị Tính</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/addUnit"> Thêm Đơn Vị Tính</a>
                                </li>
                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                         <li>
                            <a href="<%=request.getContextPath()%>/admin/indexStock"><i class="fa fa-bar-chart-o fa-fw"></i> Nguyên Liệu Trong Kho <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/indexStock"> List nguyên liệu trong kho</a>
                                </li>
                                 <li>
                                    <a href="<%=request.getContextPath()%>/admin/addStock"> Thêm nguyên liệu trong kho</a>
                                </li>
                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="<%=request.getContextPath()%>/admin/indexMaterial"><i class="fa fa-bar-chart-o fa-fw"></i> Nguyên Liệu <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/indexMaterial"> Danh Sách Nguyên Liệu</a>
                                </li>
                               	<li>
                                    <a href="<%=request.getContextPath()%>/admin/addMaterial"> Thêm Nguyên Liệu</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
       
    <!-- /#wrapper -->

   
</body>

</html>
