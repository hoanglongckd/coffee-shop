package bo;

import java.util.ArrayList;

import bean.CaLamViec;
import dao.CaLamViecDao;



public class CaLamViecBo {
	
	private static CaLamViecBo x ;
	private CaLamViecBo(){}
	public static CaLamViecBo getInstance (){
		if (x==null) return (x = new CaLamViecBo());
		return x;
	}
	CaLamViecDao caLamViecDao = new CaLamViecDao();
	
	CaLamViecDao  CaLamViecdao   = new CaLamViecDao();
	public ArrayList<CaLamViec> getListCaLamViec() {
		return caLamViecDao.getListCaLamViec();
	}

//	public int addItem(CaLamViec CaLamViec) {
//		return caLamViecDao.addCaLamViec(CaLamViec);
//	}
	public boolean editItem(CaLamViec CaLamViec) {
		return caLamViecDao.editCaLamViec(CaLamViec);
	}

	public CaLamViec getItemById(int taId) {
		
		return caLamViecDao.getItemByID(taId);
	}

	public boolean delItem(int tid) {
		if(caLamViecDao.delCaLamViecByID(tid)==1)
			return true;
		else return false;
	}

	
}
