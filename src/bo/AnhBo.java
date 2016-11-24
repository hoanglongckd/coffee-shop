package bo;

import java.util.ArrayList;

import bean.Anh;
import dao.AnhDao;



public class AnhBo {
	
	private static AnhBo x ;
	private AnhBo(){}
	public static AnhBo getInstance (){
		if (x==null) return (x = new AnhBo());
		return x;
	}
	AnhDao AnhDao = new AnhDao();
	
	AnhDao  Anhdao   = new AnhDao();
	
	//
	public ArrayList<Anh> getListAnh() {
		return AnhDao.getListAnh();
	}
	public ArrayList<Anh> getListAnh(int idQuan) {
		return AnhDao.getListAnh(idQuan);
	}

	public boolean addItem(Anh Anh) {
		return AnhDao.addAnh(Anh);
	}
	public boolean editItem(Anh Anh) {
		return AnhDao.editAnh(Anh);
	}
	
	public Anh getItemById(int id){
		return AnhDao.getItemByID(id);
	}
	

	
//	public Anh getItemById(int taId) {
//		
//		return AnhDao.getItemByID(taId);
//	}

	public boolean delItem(int tid) {
		if(AnhDao.delAnhByID(tid)==1)
			return true;
		else return false;
	}
	public Anh getItemByName(String tenAnh) {
		return AnhDao.getItemByName(tenAnh);
	}
}