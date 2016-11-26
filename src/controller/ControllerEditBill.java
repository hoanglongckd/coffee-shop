package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanAdmin.BillAdmin;
import bo.BillBo;
import bo.MaterialBo;
import bo.TableBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerEditBill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerEditBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("idNhanVien")!=null){
			MaterialBo mBo = new MaterialBo();
			TableBo tableBo = new TableBo();
			BillBo itemBo = new BillBo();
			request.setAttribute("alItemN", mBo.getListStaff());
			request.setAttribute("alItemT", tableBo.getListTable());
	
			if (request.getParameter("submit") != null) {
				int Id = Integer.parseInt(request.getParameter("id"));
				int id_staff = Integer.parseInt(request.getParameter("idstaff"));
				int id_table = Integer.parseInt(request.getParameter("idtable"));
				int status = Integer.parseInt(request.getParameter("status"));
				String note  ="";
				if(request.getParameter("note")!=null){
				 note = new String(request.getParameter("note").getBytes("ISO-8859-1"), "UTF-8");
				}
				BillAdmin item = new BillAdmin(Id, id_staff, id_table, status, note);
				int result = itemBo.editItemAdmin(item);
				
				if (result > 0) {
					response.sendRedirect(request.getContextPath() + "/admin/indexBill?msg=1");
				} else {
					response.sendRedirect(request.getContextPath() + "/admin/indexBill?msg=0");
				}
	
			} else {
				int Id = Integer.parseInt(request.getParameter("id"));
				BillAdmin Item = itemBo.getItemByIdAdmin(Id);
				request.setAttribute("objItem", Item);
				RequestDispatcher rd = request.getRequestDispatcher("/admin/editBill.jsp");
				rd.forward(request, response);
			}
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/login");
		}
		
	}

}
