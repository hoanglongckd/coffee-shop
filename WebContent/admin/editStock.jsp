<%@page import="beanAdmin.MenuAdmin"%>
<%@page import="bean.Stock"%>
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
                        <h1 class="page-header">Edit Stock
                        </h1>
                    </div>
                    <!-- /.col-lg-12 -->
                    <div class="col-lg-7" style="padding-bottom:120px">
                        <form action="" method="post">
                            <div class="form-group">
                            <%Stock objstock =(Stock) request.getAttribute("objItem"); %>
                      <%
						ArrayList<MenuAdmin> alItemM = (ArrayList<MenuAdmin>) request.getAttribute("alItemM");
					%>
                               <div class="form-group">
								<label>Nguyên Liệu</label> <select name="material"
								class="input-short form-control">

						<% for(MenuAdmin itemM : alItemM) {
							String selected ="";
							if(itemM.getId_Menu()== objstock.getId_material()){
								selected ="selected=\"selected\"";
							}else{
								selected="";
							}
						%>
								<option <%=selected %> value="<%=itemM.getId_Menu()%>"><%=itemM.getName() %></option>
						<%}%>			

							</select>
						</div>
                                 <label>Số Lượng</label>
                                <input class="form-control" value="<%=objstock.getTotalNumber() %>" name="totalnumber" placeholder="Nhập tổng số lượng" />
                            </div>
                            <button type="submit" name= "submit" class="btn btn-default" > Edit</button>
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
