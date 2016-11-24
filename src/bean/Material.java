package bean;

public class Material {
	private int id_material;
	private int id_picture;
	private  int unit;
	private int id_shop;
	private  String name;
	private String note;
	private String name_picture;
	private String name_unit;
	public int getId_material() {
		return id_material;
	}
	public void setId_material(int id_material) {
		this.id_material = id_material;
	}
	public int getId_picture() {
		return id_picture;
	}
	public void setId_picture(int id_picture) {
		this.id_picture = id_picture;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getId_shop() {
		return id_shop;
	}
	public void setId_shop(int id_shop) {
		this.id_shop = id_shop;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getName_picture() {
		return name_picture;
	}
	public void setName_picture(String name_picture) {
		this.name_picture = name_picture;
	}
	public String getName_unit() {
		return name_unit;
	}
	public void setName_unit(String name_unit) {
		this.name_unit = name_unit;
	}
	public Material(int id_material, int id_picture, int unit, int id_shop, String name, String note,
			String name_picture, String name_unit) {
		super();
		this.id_material = id_material;
		this.id_picture = id_picture;
		this.unit = unit;
		this.id_shop = id_shop;
		this.name = name;
		this.note = note;
		this.name_picture = name_picture;
		this.name_unit = name_unit;
	}
	public Material(int id_material, int id_picture, int unit, int id_shop, String name, String note) {
		super();
		this.id_material = id_material;
		this.id_picture = id_picture;
		this.unit = unit;
		this.id_shop = id_shop;
		this.name = name;
		this.note = note;
	}
	public Material() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
