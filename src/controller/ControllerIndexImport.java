package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.ImportGoodsBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerIndexImport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerIndexImport() {
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
			ImportGoodsBo ItemBo = new ImportGoodsBo();
			request.setAttribute("alItem", ItemBo.getList());
			RequestDispatcher rd = request.getRequestDispatcher("/admin/indexImport.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/login");
		}
	}

}
