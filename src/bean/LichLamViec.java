package bean;

public class LichLamViec {
	private int id;
	private int idCaLamViec;
	private String tenCaLamViec;
	private String tenNgay;
	private String date;
	private String ghiChu;
	
	
	
	
	
	public LichLamViec(int id, int idCaLamViec, String tenCaLamViec, String tenNgay, String date, String ghiChu) {
		super();
		this.id = id;
		this.idCaLamViec = idCaLamViec;
		this.tenCaLamViec = tenCaLamViec;
		this.tenNgay = tenNgay;
		this.date = date;
		this.ghiChu = ghiChu;
	}
	public LichLamViec() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LichLamViec(int id, String tenCaLamViec, String tenNgay, String date, String ghiChu) {
		super();
		this.id = id;
		this.tenCaLamViec = tenCaLamViec;
		this.tenNgay = tenNgay;
		this.date = date;
		this.ghiChu = ghiChu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenCaLamViec() {
		return tenCaLamViec;
	}
	public void setTenCaLamViec(String tenCaLamViec) {
		this.tenCaLamViec = tenCaLamViec;
	}
	public String getTenNgay() {
		return tenNgay;
	}
	public void setTenNgay(String tenNgay) {
		this.tenNgay = tenNgay;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public int getIdCaLamViec() {
		return idCaLamViec;
	}
	public void setIdCaLamViec(int idCaLamViec) {
		this.idCaLamViec = idCaLamViec;
	}
	
	
}
