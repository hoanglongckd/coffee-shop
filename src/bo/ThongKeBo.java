package bo;

import java.util.ArrayList;

import bean.ThongkeBean;
import dao.thongKeDao;

public class ThongKeBo {
	static thongKeDao ThongKeDao = new thongKeDao();

	public static ArrayList<ThongkeBean> getListThongKeTheoNam(String year) {
		return ThongKeDao.getListThongKeByNam(year);
	}
	
	public static ArrayList<ThongkeBean> alItem(String year, String month) {
		return ThongKeDao.alItem(year, month);
	}


}
