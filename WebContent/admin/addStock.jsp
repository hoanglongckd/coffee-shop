<%@page import="bean.Menu"%>
<%@page import="bean.Material"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>
<%@include file="/templates/inc/left_bar.jsp"%>
<title> Thêm Nguyên liệu vào Kho</title>



        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Add Process
                            <small>Add</small>
                        </h1>
                        
                    </div>
                    <!-- /.col-lg-12 -->
                    <div class="col-lg-7" style="padding-bottom:120px">
                        <form action="" method="post">
                            <div class="form-group">
                      <%
						ArrayList<Material> alItemM = (ArrayList<Material>) request.getAttribute("alItemM");
					%>
                               <div class="form-group">
								<label>Nguyên Liệu</label> <select name="material"
								class="input-short form-control">

						<% for(Material itemM : alItemM) {%>
								<option value="<%=itemM.getId_material()%>"><%=itemM.getName() %></option>
						<%}%>		

							</select>
						</div>
						
						
                                 <label>Số Lượng</label>
                                <input class="form-control" name="totalnumber" placeholder="Please Enter Username" />
                            </div>
                            
                            
                            
                            <button type="submit" name= "submit" class="btn btn-default" > Add</button>
                           <!--  <button type="reset" class="btn btn-default">Reset</button> -->
                        </form>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    <jsp:include page="/templates/inc/_footer-start.jsp" />
	<jsp:include page="/templates/inc/_footer-end.jsp" />
</body>

</html>
