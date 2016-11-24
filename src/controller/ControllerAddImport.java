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

import bean.DetailStock;
import bean.ImportGoods;
import bean.Stock;
import bo.DetailStockBo;
import bo.ImportGoodsBo;
import bo.MaterialBo;
import bo.StockBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerAddImport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerAddImport() {
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

		MaterialBo maBo = new MaterialBo();
		request.setAttribute("alItemM", maBo.getList());
		request.setAttribute("alItemN", maBo.getListStaff());
		ImportGoodsBo itemBo = new ImportGoodsBo();
		DetailStockBo detailStockBo = new DetailStockBo();
		StockBo stockBo = new StockBo();

		if (request.getParameter("submit") != null) {// dang nhan nut submit
			int id_staff = Integer.parseInt(request.getParameter("staff"));
			int id_materail = Integer.parseInt(request.getParameter("material"));
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

			ImportGoods ItemNew = new ImportGoods(0, id_materail, id_staff, 1, sl, date_import, count_money);
			int result_import = itemBo.addItem(ItemNew);

			if (result_import > 0) {
				DetailStock detailStock = new DetailStock(0, result_import, id_materail, date_end, sl, 1);
				int result_detail = detailStockBo.addDetailStock(detailStock);
				if (result_detail > 0) {
					boolean check = stockBo.getItemByIdMaterial(id_materail);
					System.out.println("ch" + check);
					int result = 0;
					if (check == true) {
						int slOld = stockBo.getQuality(id_materail);
						System.out.println("a"+slOld);
						result = stockBo.setQualityByIDMaterial(id_materail, sl + slOld);
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

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addImport.jsp");
			rd.forward(request, response);
		}
	}

}
