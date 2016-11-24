package bo;

import java.util.ArrayList;

import bean.Stock;
import dao.StockDao;



public class StockBo {
	StockDao  itemDao   = new StockDao();
	public ArrayList<Stock> getList() {
		return itemDao.getList();
	}

	public int addItem(Stock Item) {
		return itemDao.addItem(Item);
	}
	public int editItem(Stock Item) {
		return itemDao.editItem(Item);
	}

	public Stock getItemById(int Id) {
		
		return itemDao.getItemByID(Id);
	}

	public int delItem(int id) {
		return itemDao.delItemByID(id);
	}

	
}
