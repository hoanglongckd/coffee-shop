package beanAdmin;

import java.sql.Timestamp;

public class BillAdmin {
	private int id_bill;
	private int id_staff;
	private int id_table;
	private int status_pay;
	private float sumMoney;
	private Timestamp date_single_up;
	private String note;
	private String name_staff;
	private String name_table;
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
	public float getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(float sumMoney) {
		this.sumMoney = sumMoney;
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
	public String getName_staff() {
		return name_staff;
	}
	public void setName_staff(String name_staff) {
		this.name_staff = name_staff;
	}
	public String getName_table() {
		return name_table;
	}
	public void setName_table(String name_table) {
		this.name_table = name_table;
	}
	public BillAdmin(int id_bill, int id_staff, int id_table, int status_pay, float sumMoney, Timestamp date_single_up,
			String note, String name_staff, String name_table) {
		super();
		this.id_bill = id_bill;
		this.id_staff = id_staff;
		this.id_table = id_table;
		this.status_pay = status_pay;
		this.sumMoney = sumMoney;
		this.date_single_up = date_single_up;
		this.note = note;
		this.name_staff = name_staff;
		this.name_table = name_table;
	}
	

}
