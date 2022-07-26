package demo.booking.model;

public class Booking {
	protected int id;
	protected String user_name;
	protected String activity;
	protected String date;
	protected String site;
	protected String period;
	protected Boolean verify;
	
	public Booking() {
	}
	
	// #1 - all data
	public Booking(int id, String user_name, String activity, String date, String site) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.activity = activity;
		this.date = date;
		this.site = site;
	}
	
	public Booking(String user_name, String activity, String date, String site) {
		super();
		this.user_name = user_name;
		this.activity = activity;
		this.date = date;
		this.site = site;
	}
	
	public Booking(String period, Boolean verify) {
		super();
		this.period = period;
		this.verify = verify;
	}
	
//	@Override
//    public String toString() {
//		if (this.verify == true) {
//			return "<tr><td>" + this.period + "</td><td>已預定</td></tr>";
//		}else {
//			return "<tr><td>" + this.period + "</td><td><button class='select'>選擇 / Select</button></td></tr>";
//		}
//    }
	

	public Boolean getVerify() {
		return verify;
	}

	public void setVerify(Boolean verify) {
		this.verify = verify;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
}

