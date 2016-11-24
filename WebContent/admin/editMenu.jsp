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
<%@include file="/templates/inc/header.jsp"%>
<%@include file="/templates/inc/left_bar.jsp"%>



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
					MenuAdmin Item = (MenuAdmin) request.getAttribute("objItem");
				%>
				<form action="" method="POST">
					
                            
                      <%
						ArrayList<TypeMenu> alItemU = (ArrayList<TypeMenu>) request.getAttribute("alItem");
					%>
                               <div class="form-group">
								<label>Đơn Vị</label> <select name="idtypemenu"
								class="input-short form-control">

						<% for(TypeMenu itemM : alItemU) {
							String selected ="";
							if(itemM.getIdType()== Item.getId_type_Menu()){
								selected ="selected=\"selected\"";
							}else{
								selected="";
							}
						%>
								<option <%=selected %> value="<%=itemM.getIdType()%>"><%=itemM.getNameType() %></option>
						<%}%>		

							</select>
						</div>
						
						<div class="form-group">
                     
                               <label>Tên Thực Đơn</label> <input class="form-control" name="name" value="<%=Item.getName() %>"
								placeholder="Please Enter Username" />
							<label>Giá Tiên</label> <input class="form-control" name="price" value="<%=Item.getPrice() %>"
								placeholder="Please Enter Username" />
							<label>Đường dẫn hình ảnh </label> <input class="form-control" name="link" value="<%=Item.getLink() %>"
								placeholder="Please Enter Username" />
							<label>Mô tả</label> <input class="form-control" name="note" value="<%=Item.getMota() %>"
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
