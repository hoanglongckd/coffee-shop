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
<title>Sửa thực đơn</title>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>

<!-- Page Content -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Sửa
					<small>Thực đơn</small>
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
						<label>Đơn Vị</label> 
						<select name="idtypemenu" class="input-short form-control" required>

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
                    	<label>Tên thực đơn</label>
                    	<input class="form-control" name="name" value="<%=Item.getName() %>"
								type="text" placeholder="Nhập tên thực đơn" required />
					</div>
					<div class="form-group">
						<label>Giá tiền</label>
						<input class="form-control" name="price" value="<%=Item.getPrice() %>"
								type="number" placeholder="Nhập giá tiền" required />
					</div>
					<div class="form-group">
						<label>Đường dẫn hình ảnh </label>
						<input class="form-control" name="link" value="<%=Item.getLink() %>"
								type="text" placeholder="Nhập đường dẫn hình ảnh" required />
					</div>
					<div class="form-group">
						<label>Mô tả</label>
						<textarea class="form-control" name="note"
							placeholder="Nhập mô tả" ><%=Item.getMota() %></textarea> 
                    </div>
					<button type="submit" name="submit" class="btn btn-default">Edit</button>
					<button type="reset" class="btn btn-default">Reset</button>
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