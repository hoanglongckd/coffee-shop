package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerDelMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDelMenu() {
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
//		MenuBo ietmBo = new MenuBo();
//		
//		int id = Integer.parseInt(request.getParameter("id"));
//		int result = itemBo.delItem(id);
//		if(result > 0){
//			response.sendRedirect(request.getContextPath()+"/admin/indexMaterial?msg=1");
//		}else{
//			response.sendRedirect(request.getContextPath()+"/admin/indexMaterial?msg=0");
//		}
	}

}
