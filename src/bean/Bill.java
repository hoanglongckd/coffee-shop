package bean;

import java.sql.Timestamp;

public class Bill {
	private int id_bill;
	private int id_staff;
	private int id_table;
	private int status_pay;
	private float sumMoney;
	private Timestamp date_single_up;
	private String note;
	public int getId_bill() {
		return id_bill;
	}
	public void setId_bill(int id_bill) {
		this.id_bill = id_bill;
	}
	public int getId_staff() {
		return id_staff;
	}
	public void setId_staff(int id_staff) {
		this.id_staff = id_staff;
	}
	public int getId_table() {
		return id_table;
	}
	public void setId_table(int id_table) {
		this.id_table = id_table;
	}
	public int getStatus_pay() {
		return status_pay;
	}
	public void setStatus_pay(int status_pay) {
		this.status_pay = status_pay;
	}
	public Timestamp getDate_single_up() {
		return date_single_up;
	}
	public void setDate_single_up(Timestamp date_single_up) {
		this.date_single_up = date_single_up;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public float getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(float sumMoney) {
		this.sumMoney = sumMoney;
	}
	public Bill(int id_bill, int id_staff, int id_table, int status_pay, Timestamp date_single_up, String note) {
		super();
		this.id_bill = id_bill;
		this.id_staff = id_staff;
		this.id_table = id_table;
		this.status_pay = status_pay;
		this.date_single_up = date_single_up;
		this.note = note;
	}
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(int id_Table, int id_staff) {
		super();
		this.id_table = id_Table;
		this.id_staff = id_staff;
	}
	public Bill(int id_bill, int id_staff, int id_table, int status_pay, float sumMoney, Timestamp date_single_up,
			String note) {
		super();
		this.id_bill = id_bill;
		this.id_staff = id_staff;
		this.id_table = id_table;
		this.status_pay = status_pay;
		this.sumMoney = sumMoney;
		this.date_single_up = date_single_up;
		this.note = note;
	}
	

}
