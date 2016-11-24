package bo;

import java.util.ArrayList;

import bean.MaterialsUseInDay;
import dao.MaterialUseInDayDao;



public class MaterialUselnDayBo {
	MaterialUseInDayDao  itemDao   = new MaterialUseInDayDao();
	public ArrayList<MaterialsUseInDay> getList() {
		return itemDao.getList();
	}

	public int addItem(MaterialsUseInDay Item) {
		return itemDao.addItem(Item);
	}
	public int editItem(MaterialsUseInDay Item) {
		return itemDao.editItem(Item);
	}

	public MaterialsUseInDay getItemById(int Id) {
		
		return itemDao.getItemByID(Id);
	}

	public int delItem(int id) {
		return itemDao.delItemByID(id);
	}

	
}
