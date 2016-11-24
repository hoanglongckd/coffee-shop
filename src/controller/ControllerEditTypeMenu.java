package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.TypeMenu;
import bo.TypeMenuBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerEditTypeMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerEditTypeMenu() {
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
		TypeMenuBo ItemBo = new TypeMenuBo();

		if (request.getParameter("submit") != null) {

			int id = Integer.parseInt(request.getParameter("tMid"));
			String name = new String(request.getParameter("nameTable").getBytes("ISO-8859-1"), "UTF-8");
			
			 

			TypeMenu Item = new TypeMenu(id, name);
			
			int result = ItemBo.editItem(Item);
			if (result > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/indexTypeMenu?msg=1");
			} else {
				response.sendRedirect(request.getContextPath() + "/admin/indexTypeMenu?msg=0");
			}

		} else {
			int taId = Integer.parseInt(request.getParameter("tMid"));
			TypeMenu Item = ItemBo.getItemById(taId);
			request.setAttribute("objItem", Item);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editTypeMenu.jsp");
			rd.forward(request, response);
		}
	}
}
