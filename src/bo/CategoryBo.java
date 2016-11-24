package bo;

import java.util.ArrayList;

import bean.Cat;
import dao.CatDao;

public class CategoryBo {
	CatDao catDao = new CatDao();
	CatDao  catD  = new CatDao();
	public ArrayList<Cat> getListCategory() {
		return catDao.getListCategory();
	}
	public ArrayList<Cat> getListCat() {
		return catD.getListCategory();
	}
	public int addCat(Cat objCat) {
		return catDao.addCat(objCat);
	}
//	public int editCat(Cat objCat) {
//		return catDao.editCat(objCat);
//	}
//	public int delCat(int id) {
//		return catDao.delCat(id);
//	}
}
