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
					Material Item = (Material) request.getAttribute("objItem");
				%>
				<form action="" method="POST">
					
                            
                      <%
						ArrayList<Unit> alItemU = (ArrayList<Unit>) request.getAttribute("alItemU");
					%>
                               <div class="form-group">
								<label>Đơn Vị</label> <select name="unit"
								class="input-short form-control">

						<% for(Unit itemM : alItemU) {
							String selected ="";
							if(itemM.getId_unit()== Item.getUnit()){
								selected ="selected=\"selected\"";
							}else{
								selected="";
							}
						%>
								<option <%=selected %> value="<%=itemM.getId_unit()%>"><%=itemM.getName() %></option>
						<%}%>		

							</select>
						</div>
						
						<div class="form-group">
                      <%
						ArrayList<Picture> alItemT = (ArrayList<Picture>) request.getAttribute("alItemP");
					%>
                               <div class="form-group">
								<label>Thực Đơn</label> <select name="picture"
								class="input-short form-control">

						<% for(Picture itemT : alItemT) {
							String selected ="";
							if(itemT.getIdPicture()== Item.getId_picture()){
								selected ="selected=\"selected\"";
							}else{
								selected="";
							}
							%>
						
								<option <%=selected %> value="<%=itemT.getIdPicture()%>"><%=itemT.getName()%></option>
						<%}%>		

							</select>
						</div>
                                 <label>Tên Nguyên Liệu</label> <input class="form-control"  value="<%=Item.getName()%>" name="name"
								placeholder="Please Enter Username" />
							<label>Ghi Chú</label> <input class="form-control" value="<%=Item.getNote() %>" name="note"
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


</body>

</html>
