package controller.quanLyNhanVien;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CaLamViec;
import bean.LichLamViec;
import bean.PhanCongNhanVien;
import bo.CaLamViecBo;
import bo.LichLamViecBo;
import bo.PhanCongNhanVienBo;
import dao.PhanCongNhanVienDao;

/**
 * Servlet implementation class ControllerChangeLichLamViec
 */
@WebServlet("/admin/changelichlamviec")
public class ControllerChangeLichLamViec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerChangeLichLamViec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String  idNhanVienx = (request.getParameter("idNhanVienx"));
		String  caLamViec = (request.getParameter("tenCaLamViec"));
		String  tenNgay = (request.getParameter("tenNgay"));
		String trangThai = (request.getParameter("trangThai"));
		CaLamViec caLamViecDetail = CaLamViecBo.getInstance().getItemByTen(caLamViec);
		if(trangThai.equals("work")){
			//add
			LichLamViec x = LichLamViecBo.getInstance().getLichLamViec(tenNgay, caLamViecDetail.getIdCaLamViec());
			PhanCongNhanVien item = new PhanCongNhanVien(0,x.getId(), Integer.parseInt(idNhanVienx));
			PhanCongNhanVienBo.getInstance().addItem(item);
		}else{
			if(trangThai.equals("free")){
			//delete
			LichLamViec x = LichLamViecBo.getInstance().getLichLamViec(tenNgay, caLamViecDetail.getIdCaLamViec());
			PhanCongNhanVienBo.getInstance().delItemByIdLichLamViecIdNhanVien(x.getId(),Integer.parseInt(idNhanVienx));
			}
		}
	}

}
