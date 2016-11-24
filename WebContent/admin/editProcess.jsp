<%@page import="bean.Menu"%>
<%@page import="bean.Material"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Process"%>
<%@page import="bean.TypeMenu"%>
<%@page import="bean.Table"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/header.jsp"%>
<%@include file="/templates/inc/left_bar.jsp"%>



<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Chế Biến <small>Edit</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<%
					Process Item = (Process) request.getAttribute("objItem");
				%>
				<form action="" method="POST">
					
                            
                      <%
						ArrayList<Material> alItemM = (ArrayList<Material>) request.getAttribute("alItemM");
					%>
                               <div class="form-group">
								<label>Nguyên Liệu</label> <select name="material"
								class="input-short form-control">

						<% for(Material itemM : alItemM) {
							String selected ="";
							if(itemM.getId_material()== Item.getId_material()){
								selected ="selected=\"selected\"";
							}else{
								selected="";
							}
						%>
								<option <%=selected %> value="<%=itemM.getId_material()%>"><%=itemM.getName() %></option>
						<%}%>		

							</select>
						</div>
						
						<div class="form-group">
                      <%
						ArrayList<Menu> alItemT = (ArrayList<Menu>) request.getAttribute("alItemT");
					%>
                               <div class="form-group">
								<label>Thực Đơn</label> <select name="menu"
								class="input-short form-control">

						<% for(Menu itemT : alItemT) {
							String selected ="";
							if(itemT.getId_Menu()== Item.getId_menu()){
								selected ="selected=\"selected\"";
							}else{
								selected="";
							}
							%>
						
								<option <%=selected %> value="<%=itemT.getId_Menu()%>"><%=itemT.getName()%></option>
						<%}%>		

							</select>
						</div>
                                 <label>Số Lượng</label>
                                <input class="form-control" value="<%=Item.getQuantity() %>" name="count" placeholder="Please Enter Username" />
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


</body>

</html>
