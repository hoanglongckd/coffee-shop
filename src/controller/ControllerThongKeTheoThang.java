package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ThongkeBean;
import bo.ThongKeBo;

//@WebServlet("/admin/ControllerThongKeTheoThang")
public class ControllerThongKeTheoThang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerThongKeTheoThang() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/admin/thongKeTheoThang.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession msg = request.getSession();
		String filter = request.getParameter("filter");
		System.out.println(filter);
		if (filter == null) {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin/thongKeTheoThang.jsp");
			dispatcher.forward(request, response);
		}
		else {
			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MM/yyyy");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy");
			SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("MM");
			String year = "";
			String month = "";
			try {
				Date date = simpleDateFormat1.parse(filter);
				year = simpleDateFormat2.format(date);
				month = simpleDateFormat3.format(date);
				ArrayList<ThongkeBean> thongkeBeans = ThongKeBo.alItem(year, month);
				long cost = 0;
				for (ThongkeBean item : thongkeBeans) {
					cost += item.getProfit() - item.getFee();
				}
				request.setAttribute("list", thongkeBeans);
				request.setAttribute("month", month);
				request.setAttribute("year", year);
				request.setAttribute("cost", cost);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin/thongKeTheoThang.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				msg.setAttribute("errors", "Sai định dạng ngày tháng. Vui lòng nhập theo định dạng <b>MM/YYYY</b>");
				response.sendRedirect(request.getContextPath() + "/admin/thongKeTheoThang.jsp");
			}
			
		}
	}

}
