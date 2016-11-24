package bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private int id_user;
	private int id_QuanLY;
	private int id_NV;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}
	@XmlElement
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId_user() {
		return id_user;
	}
	@XmlElement
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_QuanLY() {
		return id_QuanLY;
	}
	@XmlElement
	public void setId_QuanLY(int id_QuanLY) {
		this.id_QuanLY = id_QuanLY;
	}
	public int getId_NV() {
		return id_NV;
	}
	@XmlElement
	public void setId_NV(int id_NV) {
		this.id_NV = id_NV;
	}

	public User(int id_user, int id_QuanLY, int id_NV, String username, String password) {
		super();
		this.id_user = id_user;
		this.id_QuanLY = id_QuanLY;
		this.id_NV = id_NV;
		this.username = username;
		this.password = password;

	}
	
	

}
