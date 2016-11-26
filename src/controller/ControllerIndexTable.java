package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.TableBo;

public class ControllerIndexTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerIndexTable() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("idNhanVien")!=null){	
			TableBo tableBo = new TableBo();
			request.setAttribute("alItem", tableBo.getListTable());
			RequestDispatcher rd = request.getRequestDispatcher("/admin/indexTable.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/login");
		}
	}

}
