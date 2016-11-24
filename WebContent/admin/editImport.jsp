<%@page import="bean.NhanVien"%>
<%@page import="bean.ImportGoods"%>
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
				Nhập Hàng <small>Edit</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<%
				ImportGoods Item = (ImportGoods) request.getAttribute("objItem");
				%>
				<form action="" method="POST">
					
                            
                    
                       <!--  <div class="form-group"> -->
								
						
						<div class="form-group">
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
						
						<%
						ArrayList<NhanVien> alItemN = (ArrayList<NhanVien>) request.getAttribute("alItemN");
					%>
                               <div class="form-group">
								<label>Nhân Viên</label> <select name="staff"
								class="input-short form-control">

						<% for(NhanVien itemM : alItemN) {
							String selected ="";
							if(itemM.getId()== Item.getId_staff()){
								selected ="selected=\"selected\"";
							}else{
								selected="";
							}
						%>
								<option <%=selected %> value="<%=itemM.getId()%>"><%=itemM.getTen() %></option>
						<%}%>		

							</select>
						</div>
                     
                                 <<label>Nhập Số Lượng nhập hàng</label> <input
								class="form-control" name="sl" value="<%=Item.getCount_goods() %>"
								placeholder="Please Enter Username" /> <label>Nhập Số
								Tiền</label> <input class="form-control" name="money"  value="<%=Item.getCount_money() %>"
								placeholder="Please Enter Username" required="required""/>
								<label>Nhập Ngày Hêt hạn</label> <input class="form-control" type="date" name="date_end"
								placeholder="Please Enter Username" required="required"/>
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
