package demo.news.model;

import java.util.Date;

public class New {
	private int new_id;
	private String title;
	private Date date;
	private String url;
	
	public New(int new_id, String title, Date date, String url) {
		super();
		this.new_id = new_id;
		this.title = title;
		this.date = date;
		this.url = url;
	}
	public int getNew_id() {
		return new_id;
	}
	public void setNew_id(int new_id) {
		this.new_id = new_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
