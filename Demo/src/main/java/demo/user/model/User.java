package demo.user.model;

import java.sql.Timestamp;

public class User {
	private int user_id;
	private String user_name;
	private String facial_recognition;
	private String user_address;
	private String user_tel;
	private Timestamp created_date;
	private Timestamp last_modified_date;
	private String createdDateStr;
	
	public User(String user_name, String facial_recognition, String user_address, String user_tel) {
		super();
		this.user_name = user_name;
		this.facial_recognition = facial_recognition;
		this.user_address = user_address;
		this.user_tel = user_tel;
	}
	
	
	
	public User(int user_id, String user_name, String facial_recognition, String user_address, String user_tel) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.facial_recognition = facial_recognition;
		this.user_address = user_address;
		this.user_tel = user_tel;
	}



	public User(int user_id, String user_name, String facial_recognition, String user_address, String user_tel,
			Timestamp created_date, Timestamp last_modified_date) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.facial_recognition = facial_recognition;
		this.user_address = user_address;
		this.user_tel = user_tel;
		this.created_date = created_date;
		this.last_modified_date = last_modified_date;
	}



	public String getCreatedDateStr() {
		return createdDateStr;
	}



	public void setCreatedDateStr(String createdDateStr) {
		this.createdDateStr = createdDateStr;
	}



	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
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
	public String getFacial_recognition() {
		return facial_recognition;
	}
	public void setFacial_recognition(String facial_recognition) {
		this.facial_recognition = facial_recognition;
	}
}
