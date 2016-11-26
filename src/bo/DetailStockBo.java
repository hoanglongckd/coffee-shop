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

	public int addDetailStock(DetailStock detailStock) {
		return itemDao.addDetailStock(detailStock);
	}

	public int getIdDetailByID(int id_import) {
		return itemDao.getIdDetailByID(id_import);
	}

	public boolean checkIdMenuByID(int id_menu) {
		return itemDao.checkIdMenuByID(id_menu);
	}

	public int getAcountGoodByIDMenu(int id_menu) {
		return itemDao.getAcountGoodByIDMenu(id_menu);
	}

	public void setAcountGoodByID(int id_menu, int count_menu) {
		itemDao.setAcountGoodByID(id_menu, count_menu);
		
	}

	
}
