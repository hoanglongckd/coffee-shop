package bean;

import java.sql.Timestamp;

public class DetailStock {
	private int id_detail;
	private int id_import;
	private int material;
	private Timestamp  date_expiration;
	private  int  amountOfStock;
	private int use_status;
	public int getId_detail() {
		return id_detail;
	}
	public void setId_detail(int id_detail) {
		this.id_detail = id_detail;
	}
	public int getId_import() {
		return id_import;
	}
	public void setId_import(int id_import) {
		this.id_import = id_import;
	}
	public int getMaterial() {
		return material;
	}
	public void setMaterial(int material) {
		this.material = material;
	}
	public Timestamp getDate_expiration() {
		return date_expiration;
	}
	public void setDate_expiration(Timestamp date_expiration) {
		this.date_expiration = date_expiration;
	}
	public int getAmountOfStock() {
		return amountOfStock;
	}
	public void setAmountOfStock(int amountOfStock) {
		this.amountOfStock = amountOfStock;
	}
	public int getUse_status() {
		return use_status;
	}
	public void setUse_status(int use_status) {
		this.use_status = use_status;
	}
	public DetailStock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetailStock(int id_detail, int id_import, int material, Timestamp date_expiration, int amountOfStock,
			int use_status) {
		super();
		this.id_detail = id_detail;
		this.id_import = id_import;
		this.material = material;
		this.date_expiration = date_expiration;
		this.amountOfStock = amountOfStock;
		this.use_status = use_status;
	}
	
}
	