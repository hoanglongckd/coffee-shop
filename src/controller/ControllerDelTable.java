package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.TableBo;

public class ControllerDelTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerDelTable() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TableBo tableBo = new TableBo();
		int tid = Integer.parseInt(request.getParameter("tid"));
		int result = tableBo.delItem(tid);
		if(result > 0){
			response.sendRedirect(request.getContextPath()+"/admin/indexTable?msg=1");
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/indexTable?msg=0");
		}
	}

}
