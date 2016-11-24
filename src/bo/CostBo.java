package bo;

import java.util.ArrayList;

import bean.Cost;
import dao.CostDao;



public class CostBo {
	CostDao  itemDao   = new CostDao();
	public ArrayList<Cost> getListCost() {
		return itemDao.getList();
	}

	public int addItem(Cost Item) {
		return itemDao.addItem(Item);
	}
	public int editItem(Cost Item) {
		return itemDao.editItem(Item);
	}

	public Cost getItemById(int Id) {
		
		return itemDao.getItemByID(Id);
	}

	public int delItem(int id) {
		return itemDao.delItemByID(id);
	}

	public Cost getItemByIdMenu(int id_menu) {
		return itemDao.getItemByIdMenu(id_menu);
	}

	public int setItemCostByID(int id_cost, int id_menu) {
		return itemDao.setItemCostByID(id_cost,id_menu);
	}

	
	public int setPriceByID(Cost costNew) {
		return itemDao.setPriceByID(costNew);
	}

	
}
