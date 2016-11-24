package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Process;
import bo.MaterialBo;
import bo.MenuBo;
import bo.ProcessBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerAddProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAddProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProcessBo ItemBo = new ProcessBo();
		MaterialBo maBo = new MaterialBo();
		MenuBo meBo = new MenuBo();
		request.setAttribute("alItemM", maBo.getList());
		request.setAttribute("alItemT", meBo.getListMenu());
		if(request.getParameter("submit")!= null){// dang nhan nut submit
			 int id_menu =0;
			 int id =0;
			 int id_material =0;
			 int quantity =0;
			//String name  =new String( request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			 if(request.getParameter("material")!=null){
				 id_material = Integer.parseInt(request.getParameter("material"));
			 }
			 
			 if(request.getParameter("count")!=null){
				 quantity = Integer.parseInt(request.getParameter("count"));
			 }
			 if(request.getParameter("menu")!=null){
				 id_menu = Integer.parseInt(request.getParameter("menu"));
			 } 
			Process Item = new Process(id, id_menu, id_material,1, quantity);
			int result = ItemBo.addItem(Item);
			if(result >0){
				response.sendRedirect(request.getContextPath()+"/admin/indexProcess?msg=1");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/indexProcess?msg=0");
			}
			
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addProcess.jsp");
			rd.forward(request, response);
		}
	}
	
}
