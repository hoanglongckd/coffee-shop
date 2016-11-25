package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ThongkeBean;
import bo.ThongKeBo;

/**
 * Servlet implementation class ControllerIndexTable
 */
//@WebServlet("/admin/thong-ke-theo-nam")
public class ControllerThongKeTheoNam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerThongKeTheoNam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ThongKeBo thongkeBo = new ThongKeBo();
		System.out.println("thong ke theo nam");
		ArrayList<ThongkeBean> listThongKeTheoNam = thongkeBo.getListThongKeTheoNam("2016");
		int tongLoiNhuan=0;
		for(ThongkeBean thongKe : listThongKeTheoNam){
			tongLoiNhuan+=thongKe.getProfit()-thongKe.getFee();
		}
		request.setAttribute("listThongKeTheoNam", listThongKeTheoNam);
		request.setAttribute("nam", "2016");
		request.setAttribute("tongLoiNhuan", tongLoiNhuan);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/thongKeTheoNam.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ThongKeBo thongkeBo = new ThongKeBo();
		System.out.println("thong ke theo nam");
		String nam = request.getParameter("year").toString();
		ArrayList<ThongkeBean> listThongKeTheoNam = thongkeBo.getListThongKeTheoNam(nam);
		int tongLoiNhuan=0;
		for(ThongkeBean thongKe : listThongKeTheoNam){
			tongLoiNhuan+=thongKe.getProfit()-thongKe.getFee();
		}
		request.setAttribute("listThongKeTheoNam", listThongKeTheoNam);
		request.setAttribute("nam", nam);
		request.setAttribute("tongLoiNhuan", tongLoiNhuan);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/thongKeTheoNam.jsp");
		rd.forward(request, response);		
		
	}

}
