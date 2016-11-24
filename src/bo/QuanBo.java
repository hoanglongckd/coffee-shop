package bo;

import java.util.ArrayList;

import bean.Quan;
import dao.QuanDao;



public class QuanBo {
	
	private static QuanBo x ;
	private QuanBo(){}
	public static QuanBo getInstance (){
		if (x==null) return (x = new QuanBo());
		return x;
	}
	QuanDao QuanDao = new QuanDao();
	
	QuanDao  Quandao   = new QuanDao();
	
	//
	public ArrayList<Quan> getListQuan() {
		return QuanDao.getListQuan();
	}

	public boolean addItem(Quan Quan) {
		return QuanDao.addQuan(Quan);
	}
	public boolean editItem(Quan Quan) {
		return QuanDao.editQuan(Quan);
	}
	
	public Quan getItemById(int id){
		return QuanDao.getItemByID(id);
	}
	

	
//	public Quan getItemById(int taId) {
//		
//		return QuanDao.getItemByID(taId);
//	}

	public boolean delItem(int tid) {
		if(QuanDao.delQuanByID(tid)==1)
			return true;
		else return false;
	}
}