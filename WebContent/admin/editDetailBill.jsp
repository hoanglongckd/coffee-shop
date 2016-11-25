<%@page import="bean.DetailBill"%>
<%@page import="beanAdmin.MenuAdmin"%>
<%@page import="bean.Picture"%>
<%@page import="bean.Unit"%>
<%@page import="bean.Menu"%>
<%@page import="bean.Material"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Process"%>
<%@page import="bean.TypeMenu"%>
<%@page import="bean.Table"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>


<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Thực Đơn <small>Edit</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<%
					DetailBill Item = (DetailBill) request.getAttribute("objItem");
				%>
				<form action="" method="POST">
					
                            
                      <%
						ArrayList<MenuAdmin> alItemU = (ArrayList<MenuAdmin>) request.getAttribute("alItem");
					%>
                               <div class="form-group">
								<label>Thực Đơn</label> <select name="menu"
								class="input-short form-control">

						<% for(MenuAdmin itemM : alItemU) {
							String selected ="";
							if(itemM.getId_Menu()== Item.getId_menu()){
								selected ="selected=\"selected\"";
							}else{
								selected="";
							}
						%>
								<option <%=selected %> value="<%=itemM.getId_Menu()%>"><%=itemM.getName()%></option>
						<%}%>		

							</select>
						</div>
						
						<div class="form-group">
                     
                               <label>Số Lượng</label> <input class="form-control" name="count" value="<%=Item.getCount_menu() %>"
								placeholder="Please Enter Username" />
							
                            </div>
                            
                            


					<button type="submit" name="submit" class="btn btn-default">
						Edit</button>
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
