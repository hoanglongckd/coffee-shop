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

	public int delItemByBill(int id) {
		return itemDao.delItemByBill(id);
	}

	public ArrayList<DetailBill> getListByIDBill(int id) {
		return itemDao.getListByIDBill(id);
	}

	public int setMoneyByID(int id, int count, float money, int id_menu) {
		return itemDao.setMoneyByID(id,count,money,id_menu);
	}

	public int delItemByID(int id) {
		return itemDao.delItemByID(id);
	}

}
