package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.StockBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerDelStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDelStock() {
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
		HttpSession session = request.getSession();
		if(session.getAttribute("idNhanVien")!=null){
			StockBo itemBo = new StockBo();
			int tid = Integer.parseInt(request.getParameter("id"));
			int result = itemBo.delItem(tid);
			if(result > 0){
				response.sendRedirect(request.getContextPath()+"/admin/indexStock?msg=1");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/indexStock?msg=0");
			}
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/login");
		}
	}

}
