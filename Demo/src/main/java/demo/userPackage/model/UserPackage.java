package demo.userPackage.model;

import java.sql.Timestamp;

public class UserPackage {

	private int package_id;
	private String user_address;
	private String user_name;
	private String package_number;
	private int package_state;
	private Timestamp created_date;
	private Timestamp last_modified_date;
	
	public UserPackage(int package_id) {
		super();
		this.package_id = package_id;
	}

	public UserPackage(int package_id, String user_address, String user_name, String package_number) {
		super();
		this.package_id = package_id;
		this.user_address = user_address;
		this.user_name = user_name;
		this.package_number = package_number;
	}

	public UserPackage(int package_id, String user_address, String user_name, String package_number, int package_state,
			Timestamp created_date, Timestamp last_modified_date) {
		super();
		this.package_id = package_id;
		this.user_address = user_address;
		this.user_name = user_name;
		this.package_number = package_number;
		this.package_state = package_state;
		this.created_date = created_date;
		this.last_modified_date = last_modified_date;
	}
	

	public UserPackage(String user_address, String user_name, String package_number) {
		super();
		this.user_address = user_address;
		this.user_name = user_name;
		this.package_number = package_number;
	}

	public int getPackage_id() {
		return package_id;
	}

	public void setPackage_id(int package_id) {
		this.package_id = package_id;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPackage_number() {
		return package_number;
	}

	public void setPackage_number(String package_number) {
		this.package_number = package_number;
	}

	public int getPackage_state() {
		return package_state;
	}

	public void setPackage_state(int package_state) {
		this.package_state = package_state;
	}

	public Timestamp getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}

	public Timestamp getLast_modified_date() {
		return last_modified_date;
	}

	public void setLast_modified_date(Timestamp last_modified_date) {
		this.last_modified_date = last_modified_date;
	}
	
	
	
}
