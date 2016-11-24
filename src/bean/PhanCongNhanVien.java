package bean;

public class PhanCongNhanVien {

	private int id;
	private int idLichLamViec;
	private int idNhanVien;
	
	
	
	
	public PhanCongNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhanCongNhanVien(int id, int idLichLamViec, int idNhanVien) {
		super();
		this.id = id;
		this.idLichLamViec = idLichLamViec;
		this.idNhanVien = idNhanVien;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdLichLamViec() {
		return idLichLamViec;
	}
	public void setIdLichLamViec(int idLichLamViec) {
		this.idLichLamViec = idLichLamViec;
	}
	public int getIdNhanVien() {
		return idNhanVien;
	}
	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	
	
	
	
}
