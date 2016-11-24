<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/inc/header.jsp" %>
<%@include file="/templates/inc/left_bar.jsp" %>



        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Personnel
                            <small>List</small>
                        </h1>
                        <div class="search">
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
                        </ul>
                   </div>
                    </div>
                    <!-- /.col-lg-12 -->
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr align="center">
                                <th>ID</th>
                                <th>Username</th>
                                <th>Fullname</th>
                                <th>Gmail</th>
                                <th>Date birthday</th>
                                <th>Address</th>
                                <th>Phone number</th>
                                
                                <th>Delete</th>
                                <th>Edit</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="odd gradeX" align="center">
                                <td>1</td>
                                <td>quoctuan</td>
                                <td>nguyá»n quá»c toÃ n</td>
                                <td>somethiing@gmail.com</td>
                                <td>25/12/1996</td>
                                <td>hÃ²a khÃ¡nh</td>
                                <td>0966874528</td>
                                
                                <td class="center"><i class="fa fa-pencil fa-fw"></i> <a href="<%=request.getContextPath()%>/admin/delPer.jsp">Del</a></td>
                                <td class="center"><i class="fa fa-trash-o  fa-fw"></i><a href="<%=request.getContextPath()%>/admin/editPer.jsp">Edit</a></td>
                            </tr>
                            <tr class="odd gradeX" align="center">
                                <td>1</td>
                                <td>quoctuan</td>
                                <td>nguyá»n quá»c toÃ n</td>
                                <td>somethiing@gmail.com</td>
                                <td>25/12/1996</td>
                                <td>hÃ²a khÃ¡nh</td>
                                <td>0966874528</td>
                                
                                <td class="center"><i class="fa fa-pencil fa-fw"></i> <a href="<%=request.getContextPath()%>/admin/delPer.jsp">Del</a></td>
                                <td class="center"><i class="fa fa-trash-o  fa-fw"></i><a href="<%=request.getContextPath()%>/admin/editPer.jsp">Edit</a></td>
                            </tr>
                           <tr class="odd gradeX" align="center">
                                <td>1</td>
                                <td>quoctuan</td>
                                <td>nguyá»n quá»c toÃ n</td>
                                <td>somethiing@gmail.com</td>
                                <td>25/12/1996</td>
                                <td>hÃ²a khÃ¡nh</td>
                                <td>0966874528</td>
                                
                                <td class="center"><i class="fa fa-pencil fa-fw"></i> <a href="<%=request.getContextPath()%>/admin/delPer.jsp">Del</a></td>
                                <td class="center"><i class="fa fa-trash-o  fa-fw"></i><a href="<%=request.getContextPath()%>/admin/editPer.jsp">Edit</a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

   
    <!-- /#wrapper -->

    
</body>

</html>
