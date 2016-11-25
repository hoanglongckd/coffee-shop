package bean;

public class PhanCongNhanVien {

	private int id;
	private int idLichLamViec;
	private int idNhanVien;
	private String caLamViec;
	private String tenNgay;
	
	
	
	
	public PhanCongNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public PhanCongNhanVien(int id,  int idNhanVien, String caLamViec, String tenNgay) {
		super();
		this.id = id;
		this.idNhanVien = idNhanVien;
		this.caLamViec = caLamViec;
		this.tenNgay = tenNgay;
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
	public int i() {
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
	public String getCaLamViec() {
		return caLamViec;
	}
	public void setCaLamViec(String caLamViec) {
		this.caLamViec = caLamViec;
	}
	public String getTenNgay() {
		return tenNgay;
	}
	public void setTenNgay(String tenNgay) {
		this.tenNgay = tenNgay;
	}
	public int getIdLichLamViec() {
		return idLichLamViec;
	}
	
	
	
	
}
