package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Material;
import bo.AnhBo;
import bo.MaterialBo;
import bo.UnitBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerEditMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerEditMaterial() {
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
		MaterialBo maBo = new MaterialBo();

		UnitBo unitBo = new UnitBo();

		if (request.getParameter("submit") != null) {
			int Id = Integer.parseInt(request.getParameter("id"));
			Material Item = maBo.getItemById(Id);
			

			String link = new String(request.getParameter("link").getBytes("ISO-8859-1"), "UTF-8");
			String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
			String note = new String(request.getParameter("note").getBytes("ISO-8859-1"), "UTF-8");
			String name_unit = new String(request.getParameter("unit").getBytes("ISO-8859-1"), "UTF-8");
			System.out.println("lik"+link);
			int resultPicture = AnhBo.getInstance().setLinkPictuteByID(Item.getId_picture(), link);
			if (resultPicture > 0) {
				int resultUnit = unitBo.setUnitById(Item.getUnit(), name_unit);
				if (resultUnit > 0) {

					Material itemNewMa = new Material(Id, Item.getId_picture(), Item.getUnit(), 1, name, note);
					int result = maBo.editItem(itemNewMa);
					if (result > 0) {
						response.sendRedirect(request.getContextPath() + "/admin/indexMaterial?msg=1");
					} else {
						response.sendRedirect(request.getContextPath() + "/admin/indexMaterial?msg=0");
					}
				}
			}
		} else {
			int Id = Integer.parseInt(request.getParameter("id"));
			Material Item = maBo.getItemById(Id);
			request.setAttribute("objItem", Item);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editMaterial.jsp");
			rd.forward(request, response);
		}
	}
}
