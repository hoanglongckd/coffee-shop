package bo;

import java.util.ArrayList;

import bean.CaLamViec;
import bean.LichLamViec;
import dao.LichLamViecDao;



public class LichLamViecBo {
	
	private static LichLamViecBo x ;
	private LichLamViecBo(){}
	public static LichLamViecBo getInstance (){
		if (x==null) return (x = new LichLamViecBo());
		return x;
	}
	LichLamViecDao LichLamViecDao = new LichLamViecDao();
	
	LichLamViecDao  LichLamViecdao   = new LichLamViecDao();
	
	//
	public ArrayList<LichLamViec> getListLichLamViec() {
		return LichLamViecDao.getListLichLamViec();
	}

	public boolean addItem(LichLamViec LichLamViec) {
		return LichLamViecDao.addLichLamViec(LichLamViec);
	}
	public boolean editItem(LichLamViec LichLamViec) {
		return LichLamViecDao.editLichLamViec(LichLamViec);
	}

	

	
//	public LichLamViec getItemById(int taId) {
//		
//		return LichLamViecDao.getItemByID(taId);
//	}

	public boolean delItem(int tid) {
		if(LichLamViecDao.delLichLamViecByID(tid)==1)
			return true;
		else return false;
	}
	
	public ArrayList<LichLamViec> lichLamViecTrongTuan(){
		
		ArrayList<LichLamViec> arLichLamViec = new ArrayList<>();
		
		ArrayList<CaLamViec> arCaLamViec = CaLamViecBo.getInstance().getListCaLamViec();
		ArrayList<LichLamViec> arTenNgay = LichLamViecBo.getInstance().getListLichLamViec();
		
		for(LichLamViec  a : arTenNgay){
			for(CaLamViec b: arCaLamViec){
				LichLamViec c = new LichLamViec(0, b.getTenCaLamViec(), a.getTenNgay(), "0", "rong");
				LichLamViecBo.getInstance().addItem(c);
				arLichLamViec.add(c);
			}
		}
		System.out.println("tong so ca lam viec trong tuan:"+arLichLamViec.size());
		return arLichLamViec;
	}
	
}
