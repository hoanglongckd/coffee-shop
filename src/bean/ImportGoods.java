package bean;

import java.sql.Timestamp;

public class ImportGoods {
	private int id_import;
	private int id_material;
	private  int id_staff;
	private  int id_shop;
	private int count_goods;
	private  Timestamp date_import;
	private  float count_money;
	public int getId_import() {
		return id_import;
	}
	public void setId_import(int id_import) {
		this.id_import = id_import;
	}
	public int getId_material() {
		return id_material;
	}
	public void setId_material(int id_material) {
		this.id_material = id_material;
	}
	public int getId_staff() {
		return id_staff;
	}
	public void setId_staff(int id_staff) {
		this.id_staff = id_staff;
	}
	public int getId_shop() {
		return id_shop;
	}
	public void setId_shop(int id_shop) {
		this.id_shop = id_shop;
	}
	public int getCount_goods() {
		return count_goods;
	}
	public void setCount_goods(int count_goods) {
		this.count_goods = count_goods;
	}
	public Timestamp getDate_import() {
		return date_import;
	}
	public void setDate_import(Timestamp date_import) {
		this.date_import = date_import;
	}
	public float getCount_money() {
		return count_money;
	}
	public void setCount_money(float count_money) {
		this.count_money = count_money;
	}
	public ImportGoods(int id_import, int id_material, int id_staff, int id_shop, int count_goods,
			Timestamp date_import, float count_money) {
		super();
		this.id_import = id_import;
		this.id_material = id_material;
		this.id_staff = id_staff;
		this.id_shop = id_shop;
		this.count_goods = count_goods;
		this.date_import = date_import;
		this.count_money = count_money;
	}
	public ImportGoods() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
