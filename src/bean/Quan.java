package bean;

public class Quan {
	private int id;
	private String ten;
	private String diaChi;
	private String sdt;
	private String ghiChu;
	
	
	
	
	
	public Quan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quan(int id, String ten, String diaChi, String sdt, String ghiChu) {
		super();
		this.id = id;
		this.ten = ten;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.ghiChu = ghiChu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	
}
