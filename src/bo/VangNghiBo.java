package bo;

import java.util.ArrayList;

import bean.VangNghi;
import dao.VangNghiDao;



public class VangNghiBo {
	
	private static VangNghiBo x ;
	private VangNghiBo(){}
	public static VangNghiBo getInstance (){
		if (x==null) return (x = new VangNghiBo());
		return x;
	}
	VangNghiDao VangNghiDao = new VangNghiDao();
	
	VangNghiDao  VangNghidao   = new VangNghiDao();
	
	//
	public ArrayList<VangNghi> getListVangNghi() {
		return VangNghiDao.getListVangNghi();
	}
	public ArrayList<VangNghi> getListVangNghi(int idQuan) {
		return VangNghiDao.getListVangNghi(idQuan);
	}

	public boolean addItem(VangNghi VangNghi) {
		return VangNghiDao.addVangNghi(VangNghi);
	}
//	public boolean editItem(VangNghi VangNghi) {
//		return VangNghiDao.editVangNghi(VangNghi);
//	}
	
	public VangNghi getItemById(int id){
		return VangNghiDao.getItemByID(id);
	}
	

	
//	public VangNghi getItemById(int taId) {
//		
//		return VangNghiDao.getItemByID(taId);
//	}

	public boolean delItem(int tid) {
		if(VangNghiDao.delVangNghiByID(tid)==1)
			return true;
		else return false;
	}
}