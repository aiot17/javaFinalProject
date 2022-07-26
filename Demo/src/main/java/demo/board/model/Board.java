package demo.board.model;

public class Board {
	protected int id;
	protected String date;
	protected String title;
	protected String info;
	protected String last_modified;
	
	public Board() {
	}
	
	// #1 - all data
	public Board(int id, String date, String title, String info, String last_modified) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.info = info;
		this.last_modified = last_modified;
	}
	
	public Board(int id, String date, String title, String info) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.info = info;
	}

	
	public Board(String date, String title, String info) {
		super();
		this.date = date;
		this.title = title;
		this.info = info;
	}

	public String getLast_modified() {
		return last_modified;
	}

	public void setLast_modified(String last_modified) {
		this.last_modified = last_modified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
