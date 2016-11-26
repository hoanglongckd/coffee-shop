package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cost;
import bean.DetailBill;
import bo.BillBo;
import bo.CostBo;
import bo.DetailBillBo;
import bo.MenuBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerEditDetailBill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerEditDetailBill() {
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
			DetailBillBo itemBo = new DetailBillBo();
			
			CostBo costBo = new CostBo();
			BillBo billBo = new BillBo();
			MenuBo menuBo = new MenuBo();
			request.setAttribute("alItem", menuBo.getListMenuAdmin());
			if (request.getParameter("submit") != null) {
				int Id = Integer.parseInt(request.getParameter("id"));
				DetailBill Item = itemBo.getItemById(Id);
				int id_menu = Integer.parseInt(request.getParameter("menu"));
				int count = Integer.parseInt(request.getParameter("count"));
				Cost cost = costBo.getItemByIdMenu(id_menu);
				float money = cost.getCost() * count;
				int result1 = itemBo.setMoneyByID(Id, count, money,id_menu);
				if (result1 > 0) {
					float moneyOld = billBo.getMoneyByID(Item.getId_bill());
					int result = billBo.editItemAdminByIDBill((moneyOld -Item.getCount_money())+  money,Item.getId_bill());
	
					if (result > 0) {
						response.sendRedirect(request.getContextPath() + "/admin/detailBill?id="+Item.getId_bill());
					} else {
						response.sendRedirect(request.getContextPath() + "/admin/detailBill?id="+Item.getId_bill());
					}
				}
	
			} else {
				int Id = Integer.parseInt(request.getParameter("id"));
				DetailBill Item = itemBo.getItemById(Id);
				request.setAttribute("objItem", Item);
				RequestDispatcher rd = request.getRequestDispatcher("/admin/editDetailBill.jsp");
				rd.forward(request, response);
			}
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/login");
		}	
	}

}
