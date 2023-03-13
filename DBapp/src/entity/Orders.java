package entity;

import java.sql.Timestamp;

public class Orders {

	//field.
	private int no; //`no` int(11) NOT NULL AUTO_INCREMENT.
	private String userId; //`userId` varchar(10) NOT NULL DEFAULT 'NONAME'.
	private String productName; //`productName` varchar(30) NOT NULL DEFAULT 'NONAME'.
	private int price; //`price` int(255) NOT NULL DEFAULT 0.
	private int buyCount; //`buyCount` int(255) NOT NULL DEFAULT 0.
	private Timestamp timeStamp; //`timestamp` timestamp NOT NULL DEFAULT current_timestamp().

	//setter,getter.
	public void setNo(int no) {this.no = no;}
	public int getNo() {return this.no;}

	public void setUserId(String userId) {this.userId = userId;}
	public String getUserId() {return this.userId;}

	public void setProductName(String productName) {this.productName = productName;}
	public String getProductName() {return this.productName;}

	public void setPrice(int price) {this.price = price;}
	public int getPrice() {return this.price;}

	public void setBuyCount(int buyCount) {this.buyCount = buyCount;}
	public int getBuyCount() {return this.buyCount;}

	public void setTimeStamp(Timestamp timeStamp) {this.timeStamp = timeStamp;}
	public Timestamp getTimeStamp() {return this.timeStamp;}

}