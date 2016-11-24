package bean;

public class LoginedAccount {
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
	public LoginedAccount(String username, String key, int idStaff) {
		super();
		this.username = username;
		this.key = key;
		this.idStaff = idStaff;
	}
	

}
