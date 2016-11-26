package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.BillBo;
import bo.DetailBillBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerDelBill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerDelBill() {
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
			BillBo itemBo = new BillBo();
			DetailBillBo detailBo = new DetailBillBo();
			int id = Integer.parseInt(request.getParameter("id"));
			int result1 = detailBo.delItemByBill(id);
			if (result1 > 0) {
				int result = itemBo.delItem(id);
				if (result > 0) {
					response.sendRedirect(request.getContextPath() + "/admin/indexBill?msg=1");
				} else {
					response.sendRedirect(request.getContextPath() + "/admin/indexBill?msg=0");
				}
			}
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/login");
		}
	}

}
