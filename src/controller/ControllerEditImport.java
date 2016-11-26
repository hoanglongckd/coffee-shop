package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.DetailStock;
import bean.ImportGoods;
import bean.Stock;
import bo.DetailStockBo;
import bo.ImportGoodsBo;
import bo.MaterialBo;
import bo.MenuBo;
import bo.StockBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerEditImport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerEditImport() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("idNhanVien")!=null){
			MenuBo meBo = new MenuBo();
			MaterialBo maBo = new MaterialBo();
			request.setAttribute("alItemM", maBo.getListStaff());
			request.setAttribute("alItemN", meBo.getListMenuAdmin());
			ImportGoodsBo itemBo = new ImportGoodsBo();
			DetailStockBo detailStockBo = new DetailStockBo();
			StockBo stockBo = new StockBo();
			if (request.getParameter("submit") != null) {
				//click 'sua' button
				int Id = Integer.parseInt(request.getParameter("id"));
				System.out.println("Id::"+Id);
				ImportGoods phieuNhapHang = itemBo.getItemById(Id);// lay phieu nhap hang theo idnhaphang
				int id_staff = Integer.parseInt(request.getParameter("staff"));//idNhanVien
				int id_materail = Integer.parseInt(request.getParameter("material"));//idNguyenLieu
				int sl = 0;
				float count_money = 0;
				if (request.getParameter("sl") != null) {
					sl = Integer.parseInt((request.getParameter("sl")));
				}
				if (request.getParameter("money") != null) {
					count_money = Float.parseFloat(request.getParameter("money"));
				}
				Timestamp date_import = new Timestamp(System.currentTimeMillis());
				String date_endS = request.getParameter("date_end");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date pareDate;
				Timestamp date_end = null;
	
				try {
					pareDate = sdf.parse(date_endS);
					date_end = new Timestamp(pareDate.getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("date_end:"+date_end);
				ImportGoods ItemNew = new ImportGoods(Id, id_materail, id_staff, 1, sl, date_import, count_money);
				int result_import = itemBo.editItem(ItemNew);//update vao bang nhap hang - true
				if (result_import > 0) {
					int id_detail = detailStockBo.getIdDetailByID(phieuNhapHang.getId_import());//lay idChiTietKho theo idNhapHang
					DetailStock detailStock = new DetailStock(id_detail, phieuNhapHang.getId_import(), id_materail, date_end, sl, 1);
					int result_detail = detailStockBo.editItem(detailStock);//sua trong chi tiet kho
					if (result_detail > 0) {
						boolean check = stockBo.getItemByIdMaterial(id_materail);
						int result = 0;
						if (check == true) {
							int slOld = stockBo.getQuality(id_materail);
							result = stockBo.setQualityByIDMaterial(id_materail, sl + slOld - phieuNhapHang.getCount_goods());
						} else {
							Stock itemStock = new Stock(0, id_materail, 1, sl);
							result = stockBo.addItem(itemStock);
						}
	
						if (result > 0) {
							response.sendRedirect(request.getContextPath() + "/admin/indexImport?msg=1");
						} else {
							response.sendRedirect(request.getContextPath() + "/admin/indexImport?msg=0");
						}
					}
				}
			} else { // chưa bấm 'sửa' button
				int Id = Integer.parseInt(request.getParameter("id"));
				ImportGoods Item = itemBo.getItemById(Id);
				request.setAttribute("objItem", Item);
				RequestDispatcher rd = request.getRequestDispatcher("/admin/editImport.jsp");
				rd.forward(request, response);
			}
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/login");
		}
	}
}
