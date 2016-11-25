package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.ImportGoodsBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerDelImport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDelImport() {
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
		ImportGoodsBo importBo = new ImportGoodsBo();
		
		int id = Integer.parseInt(request.getParameter("id"));
		int result = importBo.delItem(id);
		if(result > 0){
			response.sendRedirect(request.getContextPath()+"/admin/indexImport?msg=1");
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/indexImport?msg=0");
		}
	}

}
