package bean;

public class Unit {
	private int id_unit;
	private String name;
	public int getId_unit() {
		return id_unit;
	}
	public void setId_unit(int id_unit) {
		this.id_unit = id_unit;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Unit(int id_unit, String name) {
		super();
		this.id_unit = id_unit;
		this.name = name;
	}
	public Unit() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
