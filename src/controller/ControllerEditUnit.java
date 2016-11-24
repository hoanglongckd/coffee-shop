package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Unit;
import bo.UnitBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerEditUnit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerEditUnit() {
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
		UnitBo ItemBo = new UnitBo();

		if (request.getParameter("submit") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			System.err.println("jahshjdh");
			System.out.println("á"+request.getParameter("name"));
			String name  =new String( request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			
			Unit Item = new Unit(id, name);
			int result = ItemBo.editItem(Item);
			if(result >0){
				response.sendRedirect(request.getContextPath()+"/admin/indexUnit?msg=1");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/indexUnit?msg=0");
			}

		} else {
			int Id = Integer.parseInt(request.getParameter("id"));
			Unit Item = ItemBo.getItemById(Id);
			request.setAttribute("objItem", Item);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editUnit.jsp");
			rd.forward(request, response);
		}
	}
}
