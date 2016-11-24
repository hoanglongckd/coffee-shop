package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.TypeMenuBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerDelTypeMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDelTypeMenu() {
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
		int tid = Integer.parseInt(request.getParameter("tMid"));
		int result = itemBo.delItem(tid);
		if(result > 0){
			response.sendRedirect(request.getContextPath()+"/admin/indexTypeMenu?msg=1");
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/indexTypeMenu?msg=0");
		}
	}

}
