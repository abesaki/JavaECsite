package entity;

import java.sql.Timestamp;

public class Product {

	//field.
	private int no; //`no` int(11) NOT NULL AUTO_INCREMENT.
	private String name; //`name` varchar(30) NOT NULL.
	private int price; //`price` int(255) NOT NULL DEFAULT 0.
	private int count; //`count` int(11) NOT NULL DEFAULT 0.
	private Timestamp timeStamp; //`timestamp` timestamp NOT NULL DEFAULT current_timestamp().

	//setter,getter.
	public void setNo(int no) {this.no = no;}
	public int getNo() {return this.no;}

	public void setName(String name) {this.name = name;}
	public String getName() {return this.name;}

	public void setPrice(int price) {this.price = price;}
	public int getPrice() {return this.price;}

	public void setCount(int count) {this.count = count;}
	public int getCount() {return this.count;}

	public void setTimeStamp(Timestamp timeStamp) {this.timeStamp = timeStamp;}
	public Timestamp getTimeStamp() {return this.timeStamp;}

}
