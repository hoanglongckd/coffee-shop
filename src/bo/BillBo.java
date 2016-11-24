package bo;

import java.sql.Timestamp;
import java.util.ArrayList;

import bean.Bill;
import dao.BillDao;



public class BillBo {
	BillDao  itemDao   = new BillDao();
	public ArrayList<Bill> getList() {
		return itemDao.getList();
	}

	public int addItem(Bill Item) {
		return itemDao.addItem(new Bill(0, Item.getId_staff(), Item.getId_table(),0,new Timestamp(System.currentTimeMillis()), ""));
	}
	public int editItem(Bill Item) {
		return itemDao.editItem(Item);
	}

	public Bill getItemById(int Id) {
		
		return itemDao.getItemByID(Id);
	}

	public int delItem(int id) {
		return itemDao.delItemByID(id);
	}

	public Bill getItemByIdTable(int idTable) {
		return itemDao.getItemByIdTable(idTable);
	}

	public void setStatusPay(int id) {
		itemDao.setStatusPay(id);
		
	}

	public void setSumMoney(int idBill, float moeny) {
		itemDao.setSumMoney(idBill,moeny);
		
	}

	public int getIbBillByIDTable(int idTable) {
		return itemDao.getIbBillByIDTable(idTable);
	}

	
}
