package bean;

public class LoginedAccount {
	private int id_user;
	private String username;
	private String key;
	private int idStaff;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public int getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}
	
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public LoginedAccount(int id_user, String username, String key, int idStaff) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.key = key;
		this.idStaff = idStaff;
	}
	
	

}
