package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Cost;
import bo.CostBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerEditCost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerEditCost() {
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
		CostBo ItemBo = new CostBo();

		if (request.getParameter("submit") != null) {

			int id = Integer.parseInt(request.getParameter("tid"));
			int id_menu =0;
			 float cost = 0;
			//String name  =new String( request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			 if(request.getParameter("id_menu")!=null){
				 id_menu = Integer.parseInt(request.getParameter("id_menu"));
			 }
			  cost = Float.parseFloat(request.getParameter("cost"));
			  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			  Timestamp date_update = null; 
			 java.util.Date prareDate  = null;
			 try {
				prareDate = sdf.parse(request.getParameter("date"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 date_update = new Timestamp(prareDate.getTime());
			Cost item = new Cost(id, id_menu, cost, date_update);
			
			int result = ItemBo.editItem(item);
			if(result >0){
				response.sendRedirect(request.getContextPath()+"/admin/indexCost?msg=1");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/indexCost?msg=0");
			}

		} else {
			int Id = Integer.parseInt(request.getParameter("id"));
			Cost Item = ItemBo.getItemById(Id);
			request.setAttribute("objItem", Item);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editCost.jsp");
			rd.forward(request, response);
		}
	}
}
