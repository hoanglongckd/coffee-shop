package controller.quanLyCaLamViec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CaLamViec;
import bean.NgayTrongTuan;
import bean.NhanVien;
import bean.PhanCongNhanVien;
import bo.CaLamViecBo;
import bo.NgayTrongTuanBo;
import bo.NhanVienBo;
import bo.PhanCongNhanVienBo;

/**
 * Servlet implementation class ControllerListCaLamViec
 */
@WebServlet("/admin/phancong")
public class ControllerPhanCongNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerPhanCongNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("idNhanVien")!=null){
		
			int idNhanVien = Integer.parseInt(session.getAttribute("idNhanVien").toString());
			ArrayList<NhanVien> listNhanVien = NhanVienBo.getInstance().getListNhanVien();
			for(NhanVien x :listNhanVien) if(x.getId()==idNhanVien) {
				listNhanVien.remove(x);
				break;
			}
			ArrayList<CaLamViec> listCaLamViec = CaLamViecBo.getInstance().getListCaLamViec();
			ArrayList<NgayTrongTuan> listNgayTrongTuan = NgayTrongTuanBo.getInstance().getListNgayTrongTuan();
			ArrayList<PhanCongNhanVien> listLichLamViecCuaNhanVien = PhanCongNhanVienBo.getInstance().getListPhanCongNhanVien();
			
			request.setAttribute("listCaLamViec", listCaLamViec);
			request.setAttribute("listNhanVien", listNhanVien);
			request.setAttribute("listLichLamViecCuaNhanVien", listLichLamViecCuaNhanVien);
			request.setAttribute("listNgayTrongTuan", listNgayTrongTuan);
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/phan-cong-nhan-vien.jsp");
			rd.forward(request, response);
		}else
		{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/login.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
