package bo;

import java.util.ArrayList;

import bean.ThongkeBean;
import dao.thongKeDao;

public class ThongKeBo {
	thongKeDao ThongKeDao = new thongKeDao();

	public ArrayList<ThongkeBean> getListThongKeTheoNam(String year) {
		return ThongKeDao.getListThongKeByNam(year);
	}


}
