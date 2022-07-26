package demo.admin.model;

public class Admin {
	protected int id;
	protected String name;
	protected String account;
	protected String password;
	protected String email;
	
	public Admin() {
	}
	
	// #1 - all data
	public Admin(int id, String name, String account, String password, String email) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.password = password;
		this.email = email;
	}
	
	public Admin(String name, String account, String password, String email) {
		super();
		this.name = name;
		this.account = account;
		this.password = password;
		this.email = email;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}