package bo;

import java.util.ArrayList;

import bean.Material;
import bean.Picture;
import dao.MaterialDao;



public class MaterialBo {
	MaterialDao  itemDao   = new MaterialDao();
	public ArrayList<Material> getList() {
		return itemDao.getList();
	}

	public int addItem(Material Item) {
		return itemDao.addItem(Item);
	}
	public int editItem(Material Item) {
		return itemDao.editItem(Item);
	}

	public Material getItemById(int Id) {
		
		return itemDao.getItemByID(Id);
	}

	public int delItem(int id) {
		return itemDao.delItemByID(id);
	}

	public ArrayList<Picture> getListPicture() {
		return itemDao.getListPicture();
	}

	
}
