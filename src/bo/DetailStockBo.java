package bo;

import java.util.ArrayList;

import bean.DetailStock;
import dao.DetailStockDao;



public class DetailStockBo {
	DetailStockDao  itemDao   = new DetailStockDao();
	public ArrayList<DetailStock> getList() {
		return itemDao.getList();
	}

	public int addItem(DetailStock Item) {
		return itemDao.addItem(Item);
	}
	public int editItem(DetailStock Item) {
		return itemDao.editItem(Item);
	}

	public DetailStock getItemById(int Id) {
		
		return itemDao.getItemByID(Id);
	}

	public int delItem(int id) {
		return itemDao.delItemByID(id);
	}

	
}
