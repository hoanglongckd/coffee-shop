package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Anh;
import bean.Cost;
import beanAdmin.MenuAdmin;
import bo.AnhBo;
import bo.CostBo;
import bo.MenuBo;
import bo.TypeMenuBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerAddMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerAddMenu() {
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
		TypeMenuBo typemenuBo = new TypeMenuBo();
		MenuBo itemBo = new MenuBo();
		CostBo costBo = new CostBo();
		request.setAttribute("alItem", typemenuBo.getListTypeMenu());

		if (request.getParameter("submit") != null) {// dang nhan nut submit

			int id_type_menu = 0;

			float price = 0;
			Timestamp date_update = new Timestamp(System.currentTimeMillis());

			if (request.getParameter("idtypemenu") != null) {
				id_type_menu = Integer.parseInt(request.getParameter("idtypemenu"));
			}
			String link = new String(request.getParameter("link").getBytes("ISO-8859-1"), "UTF-8");
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String tenAnh = dateFormat.format(cal.getTime());
			System.out.println(tenAnh);
			Anh anh = new Anh(0, tenAnh, link, 1);
			AnhBo.getInstance().addItem(anh);
			anh = AnhBo.getInstance().getItemByName(tenAnh);

			String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
			String note = new String(request.getParameter("note").getBytes("ISO-8859-1"), "UTF-8");
			if (request.getParameter("price") != null) {
				price = Float.parseFloat(request.getParameter("price"));
			}
			Cost itemCost = new Cost(0, 1, price, date_update);
			int id_cost = costBo.addItem(itemCost);
			if (id_cost > 0) {
				MenuAdmin itemMenu = new MenuAdmin(0, anh.getId(), 1, id_type_menu, id_cost, name, 100, 1, note);
				int id_menu = itemBo.addItem(itemMenu);
				if (id_menu > 0) {
					int result = costBo.setItemCostByID(id_cost, id_menu);
					if (result > 0) {
						response.sendRedirect(request.getContextPath() + "/admin/indexMenu?msg=1");
					} else {
						response.sendRedirect(request.getContextPath() + "/admin/indexMenu?msg=0");
					}
				}
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addMenu.jsp");
			rd.forward(request, response);
		}
	}else{
		response.sendRedirect(request.getContextPath()+"/admin/login");
	}
	}

}
