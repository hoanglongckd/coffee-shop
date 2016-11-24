package bo;

import java.util.ArrayList;

import bean.Order;
import dao.OrderDao;

public class OrderBo {
	OrderDao orderDao = new OrderDao();
	public ArrayList<Order> getList() {
		return orderDao.getList();
	}
	

}
