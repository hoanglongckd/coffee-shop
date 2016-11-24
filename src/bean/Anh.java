package bean;

public class Anh {
	
	private int id;
	private String ten;
	private String duongDan;
	private int idQuan;
	
	
	
	
	public Anh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Anh(int id, String ten, String duongDan, int idQuan) {
		super();
		this.id = id;
		this.ten = ten;
		this.duongDan = duongDan;
		this.idQuan = idQuan;
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
	public String getDuongDan() {
		return duongDan;
	}
	public void setDuongDan(String duongDan) {
		this.duongDan = duongDan;
	}
	public int getIdQuan() {
		return idQuan;
	}
	public void setIdQuan(int idQuan) {
		this.idQuan = idQuan;
	}
	
	
}
