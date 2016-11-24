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

public class ControllerAddTypeMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAddTypeMenu() {
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
		TypeMenuBo itemBo = new TypeMenuBo();
		if(request.getParameter("submit")!= null){// dang nhan nut submit
			 
			String name  =new String( request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			TypeMenu item = new TypeMenu(0, name);
			
			int result = itemBo.addItem(item);
			if(result >0){
				response.sendRedirect(request.getContextPath()+"/admin/indexTypeMenu?msg=1");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/indexTypeMenu?msg=0");
			}
			
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addTypeMenu.jsp");
			rd.forward(request, response);
		}
	}
	
}
