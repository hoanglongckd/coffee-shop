package controller.quanLyNhanVien;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Anh;
import bean.Luong;
import bean.NhanVien;
import bean.User;
import bo.AnhBo;
import bo.LuongBo;
import bo.NhanVienBo;
import bo.UserBo;

@WebServlet("/admin/updateNhanVien")
public class ControllerUpdateNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerUpdateNhanVien() {
        super();
    }
    UserBo userBo = new UserBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession msg = request.getSession();
		int idNhanVien=Integer.parseInt(request.getParameter("idNhanVien"));
		NhanVien nhanVien = NhanVienBo.getInstance().getItemById(idNhanVien);
		Anh anh = AnhBo.getInstance().getItemById(nhanVien.getIdAnh());
		User user = userBo.getItemByIdNhanVien(idNhanVien);
		Luong luong = LuongBo.getInstance().getItemByIdNhanVien(idNhanVien);
		//if(user==null)System.out.println("NULLLLLLLL");
		if(request.getParameter("msg")!=null){
			msg.setAttribute("errors", "<ul><li>Username đã được sử dụng!</li></ul>");
		}
		request.setAttribute("nhanVien", nhanVien);
		request.setAttribute("anh", anh);
		request.setAttribute("user", user);
		request.setAttribute("luong", luong);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/chinh-sua-nhan-vien.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int idNhanVien = Integer.parseInt(request.getParameter("idNhanVien"));
		String duongDan = request.getParameter("duongDan");
		String name = request.getParameter("ten");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String ghiChu = request.getParameter("ghiChu");
		String tienLuong = request.getParameter("luong");
		System.out.println("dd:"+",name:"+name+",username:"+username+",pass:"+password+",ghiChu:"+ghiChu+",tienLuong:"+tienLuong);
		//
		if (userBo.checkExistUsername(username,idNhanVien)) {
			response.sendRedirect(request.getContextPath()+"/admin/updateNhanVien?idNhanVien="+idNhanVien+"&&msg=2");
		}else{
			//
			NhanVien nhanVien = NhanVienBo.getInstance().getItemById(idNhanVien);
			Anh anh = AnhBo.getInstance().getItemById(nhanVien.getIdAnh());
			
			User user = new User(0, 1, idNhanVien, name, password);
			
			if(	userBo.getItemByIdNhanVien(idNhanVien)!=null){
				user = userBo.getItemByIdNhanVien(idNhanVien);
			}
			Luong luong = new Luong	(0, idNhanVien, 0);
			if(LuongBo.getInstance().getItemByIdNhanVien(idNhanVien)!=null){
			 luong = LuongBo.getInstance().getItemByIdNhanVien(idNhanVien);
			}
			//sua anh
			if((anh!=null)&&(!duongDan.equals(anh.getDuongDan()))){
				AnhBo.getInstance().editItem(new Anh(anh.getId(),anh.getTen(),duongDan,1));
			}else{
				AnhBo.getInstance().addItem(new Anh(0,nhanVien.getTen(),duongDan,1));
			}
	//		sua thong tin nhan vien
			
			if(!nhanVien.getTen().equals(name)){
				nhanVien.setTen(name);
			}
			if(!nhanVien.getGhiChu().equals(ghiChu)){
				nhanVien.setGhiChu(ghiChu);
			}
			NhanVienBo.getInstance().editItem(nhanVien);
	//		sua thong tin tai khoan dang nhap
			if(!username.equals(user.getUsername())){
				user.setUsername(username);
			}
			if(!password.equals(user.getPassword())){
				user.setPassword(password);
			}
			System.out.println(user.getId_NV()+","+user.getId_user()+","+user.getUsername()+","+user.getPassword());
			if(user.getId_user()!=0){
				userBo.editItem(user);
			}else{
				if((!user.getUsername().equals(""))&&(!user.getPassword().equals("")))
				userBo.addItem(user);
			}
			
	//		sua tien luong nhanvien
			if(tienLuong!=""){
				if(Integer.parseInt(tienLuong)!=luong.getLuong()){
				luong.setLuong(Integer.parseInt(tienLuong));
				}
			}
			if(luong.getIdLuong()!=0)
				LuongBo.getInstance().editItem(luong);
			else
				LuongBo.getInstance().addItem(luong);
			System.out.println(request.getContextPath()+"??????????"+nhanVien.getId());
			response.sendRedirect(request.getContextPath()+"/admin/updateNhanVien?idNhanVien="+nhanVien.getId());
		}
	}

}
