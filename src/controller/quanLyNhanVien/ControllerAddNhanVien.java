package controller.quanLyNhanVien;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Anh;
import bean.NhanVien;
import bo.AnhBo;
import bo.NhanVienBo;

@WebServlet("/admin/addNhanVien")
public class ControllerAddNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public ControllerAddNhanVien() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin/them-nhan-vien.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("submit")!=null){
			String hoTen = request.getParameter("ten");
			String ghiChu = request.getParameter("ghiChu");
			String duongDan =request.getParameter("anh");
			//them anh
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String tenAnh = dateFormat.format(cal.getTime());
			System.out.println(tenAnh);
			Anh anh = new Anh(0,tenAnh,duongDan,1);
			AnhBo.getInstance().addItem(anh);
			anh = AnhBo.getInstance().getItemByName(tenAnh);
			//them NhanVien
			NhanVien nhanVien = new NhanVien(0,anh.getId(),1,hoTen,ghiChu);
			boolean valid = NhanVienBo.getInstance().addItem(nhanVien);
			HttpSession msg = request.getSession();
			if (valid) {
				msg.setAttribute("messages", "<ul><li>Thêm Nhân Viên thành công!</li></ul>");
			} else {
				msg.setAttribute("errors", "<ul><li>Có lỗi xảy ra! Vui lòng liên hệ với nhà cung cấp dịch vụ!</li></ul>");
			}
			response.sendRedirect(request.getContextPath() + "/admin/listNhanVien");
			
		}else{
			System.out.println("xxxxxxxxxxxxx");
		}
	}

}
