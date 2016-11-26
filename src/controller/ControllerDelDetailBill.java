package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.DetailBill;
import bo.BillBo;
import bo.DetailBillBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerDelDetailBill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerDelDetailBill() {
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
	
			DetailBill detailBill = detailBo.getItemById(id);
			float moneyBill = itemBo.getMoneyByID(detailBill.getId_bill());
			int result1 = itemBo.setSumMoneyByIDBill(detailBill.getId_bill(), moneyBill - detailBill.getCount_money());
			if (result1 > 0) {
				int result2 = detailBo.delItemByID(id);
				if (result2 > 0) {
					int result = 0;
					if (detailBo.getItemByIdBillDel(detailBill.getId_bill()) == true) {
						result = itemBo.delItem(detailBill.getId_bill());
					} else {
						result = 1;
					}
					if (result > 0) {
						response.sendRedirect(request.getContextPath() + "/admin/detailBill?id=" + detailBill.getId_bill());
					} else {
						response.sendRedirect(request.getContextPath() + "/admin/indexBill?id=" + detailBill.getId_bill());
					}
				}
			}
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/login");
		}
	}

}
