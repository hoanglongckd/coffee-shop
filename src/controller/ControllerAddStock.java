package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Stock;
import bo.MaterialBo;
import bo.StockBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerAddStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAddStock() {
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
		
		MaterialBo maBo = new MaterialBo();
		StockBo ItemBo = new StockBo();
		request.setAttribute("alItemM", maBo.getList());
		
		if(request.getParameter("submit")!= null){// dang nhan nut submit
			 int id_Shop =1;
			 int id =0;
			 int id_material =0;
			 int totalNumber =0;
			//String name  =new String( request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			 if(request.getParameter("material")!=null){
				 id_material = Integer.parseInt(request.getParameter("material"));
			 }
			 
			 if(request.getParameter("totalnumber")!=null){
				 totalNumber = Integer.parseInt(request.getParameter("totalnumber"));
			 }
			
			Stock Item = new Stock(id, id_material, id_Shop, totalNumber);
			int result = ItemBo.addItem(Item);
			if(result >0){
				response.sendRedirect(request.getContextPath()+"/admin/indexStock?msg=1");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/indexStock?msg=0");
			}
			
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addStock.jsp");
			rd.forward(request, response);
		}
	}
	
}
