package bo;

import java.util.ArrayList;

import bean.DetailBill;
import dao.DetailBillDao;

public class DetailBillBo {
	DetailBillDao itemDao = new DetailBillDao();
	
	BillBo billBo = new BillBo();

	public ArrayList<DetailBill> getList() {
		return itemDao.getList();
	}

	public int addItem(DetailBill Item) {
		
		
		return itemDao.addItem(Item);

	}
	

	public int editItem(DetailBill Item) {
		return itemDao.editItem(Item);
	}

	public DetailBill getItemById(int Id) {

		return itemDao.getItemByID(Id);
	}

	public int delItem(int id) {
		return itemDao.delItemByID(id);
	}

	public ArrayList<DetailBill> getOrderByIdBill(int idBill) {
		return itemDao.getOrderByIdBill(idBill);
	}

	public float getSumMoney(int idBill) {
		return itemDao.getSumMoney(idBill);
	}

}
