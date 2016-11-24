package bean;

public class Luong {
	private int idLuong;
	private int idNhanVien;
	private int luong;
	
	
	
	
	public Luong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Luong(int idLuong, int idNhanVien, int luong) {
		super();
		this.idLuong = idLuong;
		this.idNhanVien = idNhanVien;
		this.luong = luong;
	}
	public int getIdLuong() {
		return idLuong;
	}
	public void setIdLuong(int idLuong) {
		this.idLuong = idLuong;
	}
	public int getIdNhanVien() {
		return idNhanVien;
	}
	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	public int getLuong() {
		return luong;
	}
	public void setLuong(int luong) {
		this.luong = luong;
	}
	
	
}
