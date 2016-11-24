package bean;

public class CaLamViec {
	private int idCaLamViec;
	private String tenCaLamViec;
	private String thoiGianBatDau;
	private String thoiGianKetThuc;
	private int idQuan;
	
	
	
	
	
	public CaLamViec() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CaLamViec(int idCaLamViec, String tenCaLamViec, String thoiGianBatDau, String thoiGianKetThuc) {
		super();
		this.idCaLamViec = idCaLamViec;
		this.tenCaLamViec = tenCaLamViec;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public CaLamViec(int idCaLamViec, String tenCaLamViec, String thoiGianBatDau, String thoiGianKetThuc,
			int idQuan) {
		super();
		this.idCaLamViec = idCaLamViec;
		this.tenCaLamViec = tenCaLamViec;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.idQuan = idQuan;
	}
	public int getIdCaLamViec() {
		return idCaLamViec;
	}
	public void setIdCaLamViec(int idCaLamViec) {
		this.idCaLamViec = idCaLamViec;
	}
	public String getTenCaLamViec() {
		return tenCaLamViec;
	}
	public void setTenCaLamViec(String tenCaLamViec) {
		this.tenCaLamViec = tenCaLamViec;
	}
	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public int getIdQuan() {
		return idQuan;
	}
	public void setIdQuan(int idQuan) {
		this.idQuan = idQuan;
	}
	
	
}
