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
					Chế Biến <small>Edit</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<%
					Material Item = (Material) request.getAttribute("objItem");
				%>
				<form action="" method="POST">
					
                            
                    
                               <div class="form-group">
								
						
						<div class="form-group">
                     
                                 <label>Tên Nguyên Liệu</label> <input class="form-control" name="name" value="<%=Item.getName() %>"
								placeholder="Please Enter Username" />
								<label>Đơn Vị Tính</label> <input class="form-control" name="unit" value="<%=Item.getName_unit() %>"
								placeholder="Please Enter Username" />
							<label>Đường dẫn hình ảnh</label> <input class="form-control" name="link" value="<%=Item.getLink() %>"
								placeholder="Please Enter Username" />
							<label>Ghi Chú</label> <input class="form-control" name="note" value="<%=Item.getNote() %>"
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
