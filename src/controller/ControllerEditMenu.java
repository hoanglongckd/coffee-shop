package controller;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cost;
import beanAdmin.MenuAdmin;
import bo.AnhBo;
import bo.CostBo;
import bo.MenuBo;
import bo.TypeMenuBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerEditMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerEditMenu() {
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
	
			if (request.getParameter("submit") != null) {
				int Id = Integer.parseInt(request.getParameter("id"));
				MenuAdmin Item = itemBo.getMenuByID(Id);
				int id_type_menu = 0;
	
				float price = 0;
				Timestamp date_update = new Timestamp(System.currentTimeMillis());
	
				if (request.getParameter("idtypemenu") != null) {
					id_type_menu = Integer.parseInt(request.getParameter("idtypemenu"));
				}
				String link = new String(request.getParameter("link").getBytes("ISO-8859-1"), "UTF-8");
	
				String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
				String note = new String(request.getParameter("note").getBytes("ISO-8859-1"), "UTF-8");
				if (request.getParameter("price") != null) {
					price = Float.parseFloat(request.getParameter("price"));
				}
				Cost costNew = new Cost(Item.getId_Cost(), Item.getId_Menu(),price, date_update);
				int resultChangeCost = costBo.setPriceByID(costNew);
				if (resultChangeCost > 0) {
	
					int resultPicture = AnhBo.getInstance().setLinkPictuteByID(Item.getId_picture(), link);
					if (resultPicture > 0) {
						MenuAdmin itemNewMenu = new MenuAdmin(Item.getId_Menu(), Item.getId_picture(), 1, id_type_menu,
								Item.getId_Cost(), name, 100, 1, note);
						int result = itemBo.editItem(itemNewMenu);
	
						if (result > 0) {
							response.sendRedirect(request.getContextPath() + "/admin/indexMenu?msg=1");
						} else {
							response.sendRedirect(request.getContextPath() + "/admin/indexMenu?msg=0");
						}
					}
				}
			} else {
				int Id = Integer.parseInt(request.getParameter("id"));
				MenuAdmin Item = itemBo.getMenuByID(Id);
				request.setAttribute("objItem", Item);
				RequestDispatcher rd = request.getRequestDispatcher("/admin/editMenu.jsp");
				rd.forward(request, response);
			}
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/login");
		}
	}
}
