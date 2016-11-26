package controller;

import java.io.IOException;
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
import bean.Material;
import bean.Unit;
import bo.AnhBo;
import bo.MaterialBo;
import bo.UnitBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerAddMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerAddMaterial() {
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
		MaterialBo maBo = new MaterialBo();

		UnitBo unitBo = new UnitBo();

		if (request.getParameter("submit") != null) {// dang nhan nut submit

			String link = new String(request.getParameter("link").getBytes("ISO-8859-1"), "UTF-8");
			String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
			String note = new String(request.getParameter("note").getBytes("ISO-8859-1"), "UTF-8");
			String name_unit = new String(request.getParameter("unit").getBytes("ISO-8859-1"), "UTF-8");
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String tenAnh = dateFormat.format(cal.getTime());
			Anh anh = new Anh(0, tenAnh, link, 1);
			AnhBo.getInstance().addItem(anh);
			anh = AnhBo.getInstance().getItemByName(tenAnh);
			Unit unit = new Unit(0, name_unit);
			int id_unit = unitBo.addItem(unit);
			if (id_unit > 0) {
				Material Item = new Material(0, anh.getId(), id_unit, 1, name, note);
				int result = maBo.addItem(Item);
				if (result > 0) {
					response.sendRedirect(request.getContextPath() + "/admin/indexMaterial?msg=1");
				} else {
					response.sendRedirect(request.getContextPath() + "/admin/indexMaterial?msg=0");
				}
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addMaterial.jsp");
			rd.forward(request, response);
		}
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/login");
		}
	}

}
