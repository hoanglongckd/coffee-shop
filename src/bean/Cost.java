package bean;

import java.sql.Timestamp;

public class Cost {
	private int id_cost;
	private int id_menu;
	private float cost;
	private Timestamp date_update;
	public int getId_cost() {
		return id_cost;
	}
	public void setId_cost(int id_cost) {
		this.id_cost = id_cost;
	}
	public int getId_menu() {
		return id_menu;
	}
	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Timestamp getDate_update() {
		return date_update;
	}
	public void setDate_update(Timestamp date_update) {
		this.date_update = date_update;
	}
	public Cost(int id_cost, int id_menu, float cost, Timestamp date_update) {
		super();
		this.id_cost = id_cost;
		this.id_menu = id_menu;
		this.cost = cost;
		this.date_update = date_update;
	}
	public Cost() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
