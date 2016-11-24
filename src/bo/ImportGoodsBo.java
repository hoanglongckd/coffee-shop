package bo;

import java.util.ArrayList;

import bean.ImportGoods;
import dao.ImportGoodsDao;



public class ImportGoodsBo {
	ImportGoodsDao  itemDao   = new ImportGoodsDao();
	public ArrayList<ImportGoods> getList() {
		return itemDao.getList();
	}

	public int addItem(ImportGoods Item) {
		return itemDao.addItem(Item);
	}
	public int editItem(ImportGoods Item) {
		return itemDao.editItem(Item);
	}

	public ImportGoods getItemById(int Id) {
		
		return itemDao.getItemByID(Id);
	}

	public int delItem(int id) {
		return itemDao.delItemByID(id);
	}

	
}
