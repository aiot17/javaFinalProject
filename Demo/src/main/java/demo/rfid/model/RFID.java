package demo.rfid.model;

import java.sql.Timestamp;

public class RFID {
	private int rfidId;
	private String userAddress;
	private String rfidName;
	private String rfidNum;
	private Timestamp createdDate;
	private Timestamp lastModifiedDate;
	
	
	
	public RFID(int rfidId, String userAddress, String rfidName, String rfidNum) {
		super();
		this.rfidId = rfidId;
		this.userAddress = userAddress;
		this.rfidName = rfidName;
		this.rfidNum = rfidNum;
	}
	public RFID(String userAddress, String rfidName, String rfidNum) {
		super();
		this.userAddress = userAddress;
		this.rfidName = rfidName;
		this.rfidNum = rfidNum;
	}
	public RFID(int rfidId, String userAddress, String rfidName, String rfidNum, Timestamp createdDate,
			Timestamp lastModifiedDate) {
		super();
		this.rfidId = rfidId;
		this.userAddress = userAddress;
		this.rfidName = rfidName;
		this.rfidNum = rfidNum;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}
	public int getRfidId() {
		return rfidId;
	}
	public void setRfidId(int rfidId) {
		this.rfidId = rfidId;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getRfidName() {
		return rfidName;
	}
	public void setRfidName(String rfidName) {
		this.rfidName = rfidName;
	}
	public String getRfidNum() {
		return rfidNum;
	}
	public void setRfidNum(String rfidNum) {
		this.rfidNum = rfidNum;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
}