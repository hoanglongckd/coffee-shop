package controller.quanLyNhanVien;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.NhanVienBo;

@WebServlet("/admin/deleteNhanVien")
public class ControllerDeleteNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerDeleteNhanVien() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession msg = request.getSession();
		int idNhanVien= Integer.parseInt(request.getParameter("idNhanVien").toString());
		boolean valid = NhanVienBo.getInstance().delItem(idNhanVien);
		if (valid) {
			msg.setAttribute("messages", "<ul><li>Xóa Nhân Viên thành công!</li></ul>");
		} else {
			msg.setAttribute("errors", "<ul><li>Có lỗi xảy ra! Vui lòng liên hệ với nhà cung cấp dịch vụ!</li></ul>");
		}
		response.sendRedirect(request.getContextPath() + "/admin/listNhanVien");
	}
}
