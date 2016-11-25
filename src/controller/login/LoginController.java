package controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import bo.UserBo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/admin/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("idNhanVien")!=null){
			response.sendRedirect(request.getContextPath()+"/admin/dashboard");
		}else {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/login.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("idNhanVien")!=null)
			response.sendRedirect(request.getContextPath() + "/admin/dashboard");
		//get
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//kiem tra MaNV
		UserBo userBo = new UserBo();
		User user = userBo.CheckLogin(username, password);
		if(user!=null&&user.getId_QuanLY()==0){	
			//kiem tra password
				//tao session
				session.setAttribute("idNhanVien", user.getId_NV());
				//chuyen sang trang dashboardController
				response.sendRedirect(request.getContextPath() + "/admin/dashboard");
				//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/_content.jsp");
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");
			rd.forward(request, response);
		}
	}
}
