package bean;

public class VangNghi {
	private int idVangNghi;
	private int idNhanVien;
	private String ngayVang;
	private String ghiChu;
	public VangNghi(int idVangNghi, int idNhanVien, String ngayVang, String ghiChu) {
		super();
		this.idVangNghi = idVangNghi;
		this.idNhanVien = idNhanVien;
		this.ngayVang = ngayVang;
		this.ghiChu = ghiChu;
	}
	public VangNghi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdVangNghi() {
		return idVangNghi;
	}
	public void setIdVangNghi(int idVangNghi) {
		this.idVangNghi = idVangNghi;
	}
	public int getIdNhanVien() {
		return idNhanVien;
	}
	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	public String getNgayVang() {
		return ngayVang;
	}
	public void setNgayVang(String ngayVang) {
		this.ngayVang = ngayVang;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	
}
