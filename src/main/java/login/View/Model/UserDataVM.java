package login.View.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class UserDataVM implements Serializable {

	 private static final long serialVersionUID = 1L;
	
	private long id;
	private String email;
	private String name;
	private String password;
	private String position;
	private String birthdate;
	private String cowntry;
	private String state;
	private String city;
	private Date signindate;
	private UUID confirmcode;
	private boolean confirmed;
	private String role;
	private boolean first_login;
	
	public UserDataVM(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getCowntry() {
		return cowntry;
	}

	public void setCowntry(String cowntry) {
		this.cowntry = cowntry;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getSignindate() {
		return signindate;
	}

	public void setSignindate(Date signindate) {
		this.signindate = signindate;
	}

	public UUID getConfirmcode() {
		return confirmcode;
	}

	public void setConfirmcode(UUID confirmcode) {
		this.confirmcode = confirmcode;
	}

	public boolean isConfirmed() {
		return confirmed;
	}
	
	public boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean getFirst_login() {
		return first_login;
	}

	public void setFirst_login(boolean first_login) {
		this.first_login = first_login;
	}
	
}
