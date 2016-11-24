package bo;

import java.util.ArrayList;

import bean.NgayTrongTuan;
import dao.NgayTrongTuanDao;



public class NgayTrongTuanBo {
	
	private static NgayTrongTuanBo x ;
	private NgayTrongTuanBo(){}
	public static NgayTrongTuanBo getInstance (){
		if (x==null) return (x = new NgayTrongTuanBo());
		return x;
	}
	NgayTrongTuanDao NgayTrongTuanDao = new NgayTrongTuanDao();
	
	NgayTrongTuanDao  NgayTrongTuandao   = new NgayTrongTuanDao();
	
	////
	public ArrayList<NgayTrongTuan> getListNgayTrongTuan() {
		return NgayTrongTuanDao.getListNgayTrongTuan();
	}

//	public int addItem(NgayTrongTuan NgayTrongTuan) {
//		return NgayTrongTuanDao.addNgayTrongTuan(NgayTrongTuan);
//	}
//	public boolean editItem(NgayTrongTuan NgayTrongTuan) {
//		return NgayTrongTuanDao.editNgayTrongTuan(NgayTrongTuan);
//	}

	public NgayTrongTuan getItemById(int taId) {
		
		return NgayTrongTuanDao.getItemByID(taId);
	}

//	public boolean delItem(int tid) {
//		if(NgayTrongTuanDao.delNgayTrongTuanByID(tid)==1)
//			return true;
//		else return false;
//	}

	
}
