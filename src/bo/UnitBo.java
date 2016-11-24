package bo;

import java.util.ArrayList;

import bean.Unit;
import dao.UnitDao;



public class UnitBo {
	UnitDao  itemDao   = new UnitDao();
	public ArrayList<Unit> getList() {
		return itemDao.getList();
	}

	public int addItem(Unit Item) {
		return itemDao.addItem(Item);
	}
	public int editItem(Unit Item) {
		return itemDao.editItem(Item);
	}

	public Unit getItemById(int Id) {
		
		return itemDao.getItemByID(Id);
	}

	public int delItem(int id) {
		return itemDao.delItemByID(id);
	}

	
}
