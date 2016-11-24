package bo;

import java.util.ArrayList;

import bean.TypeMenu;
import dao.TypeMenuDao;



public class TypeMenuBo {
	TypeMenuDao  itemDao   = new TypeMenuDao();
	public ArrayList<TypeMenu> getListTypeMenu() {
		return itemDao.getListTypeMenu();
	}

	public int addItem(TypeMenu Item) {
		return itemDao.addTypeMenu(Item);
	}
	public int editItem(TypeMenu Item) {
		return itemDao.editTable(Item);
	}

	public TypeMenu getItemById(int taId) {
		
		return itemDao.getItemByID(taId);
	}

	public int delItem(int id) {
		return itemDao.delItemByID(id);
	}

	
}
