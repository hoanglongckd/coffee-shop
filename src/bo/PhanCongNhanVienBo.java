package bo;

import java.util.ArrayList;

import bean.PhanCongNhanVien;
import dao.PhanCongNhanVienDao;



public class PhanCongNhanVienBo {
	
	private static PhanCongNhanVienBo x ;
	private PhanCongNhanVienBo(){}
	public static PhanCongNhanVienBo getInstance (){
		if (x==null) return (x = new PhanCongNhanVienBo());
		return x;
	}
	PhanCongNhanVienDao PhanCongNhanVienDao = new PhanCongNhanVienDao();
	
	PhanCongNhanVienDao  PhanCongNhanViendao   = new PhanCongNhanVienDao();
	
	//getList
	public ArrayList<PhanCongNhanVien> getListPhanCongNhanVien() {
		return PhanCongNhanVienDao.getListPhanCongNhanVien();
	}
	
	//add
	public boolean addItem(PhanCongNhanVien PhanCongNhanVien) {
		return PhanCongNhanVienDao.addPhanCongNhanVien(PhanCongNhanVien);
	}
	
	//edit
	public boolean editItem(PhanCongNhanVien PhanCongNhanVien) {
		return PhanCongNhanVienDao.editPhanCongNhanVien(PhanCongNhanVien);
	}

	//del
	public boolean delItem(int tid) {
		if(PhanCongNhanVienDao.delPhanCongNhanVienByID(tid)==1)
			return true;
		else return false;
	}
	
}
