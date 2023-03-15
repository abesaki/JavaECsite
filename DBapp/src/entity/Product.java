package entity;

import java.sql.Timestamp;

public class Product {

	//field.
	private int no; //`no` int(11) NOT NULL AUTO_INCREMENT.
	private String name; //`name` varchar(30) NOT NULL UNIQUE.
	private int price; //`price` int(255) NOT NULL DEFAULT 0.
	private int count; //`count` int(11) NOT NULL DEFAULT 0.
	private Timestamp timeStampProduct; //`timestamp` timestamp NOT NULL DEFAULT current_timestamp().
	private int id; //`id` int(11) NOT NULL AUTO_INCREMENT.
	private String productName; //`productName` varchar(10) NOT NULL UNIQUE.
	private int autoAddStockCount; //`autoAddStockCount` int(10) DEFAULT 100.
	private int countLowerLimit; //`countLowerLimit` int(10) DEFAULT 10.
	private Timestamp timeStampProductSetting; //`timestamp` timestamp NOT NULL DEFAULT current_timestamp().

	//setter,getter.
	public void setNo(int no) {this.no = no;}
	public int getNo() {return this.no;}

	public void setName(String name) {this.name = name;}
	public String getName() {return this.name;}

	public void setPrice(int price) {this.price = price;}
	public int getPrice() {return this.price;}

	public void setCount(int count) {this.count = count;}
	public int getCount() {return this.count;}

	public void setTimeStampProduct(Timestamp timeStampProduct) {this.timeStampProduct = timeStampProduct;}
	public Timestamp getTimeStampProduct() {return this.timeStampProduct;}

	public void setId(int id) {this.id = id;}
	public int getId() {return this.id;}

	public void setProductName(String productName) {this.productName = productName;}
	public String getProductName() {return this.productName;}

	public void setAutoAddStockCount(int autoAddStockCount) {this.autoAddStockCount = autoAddStockCount;}
	public int getAutoAddStockCount() {return this.autoAddStockCount;}

	public void setCountLowerLimit(int countLowerLimit) {this.countLowerLimit = countLowerLimit;}
	public int getCountLowerLimit() {return this.countLowerLimit;}

	public void setTimeStampProductSetting(Timestamp timeStampProductSetting) {this.timeStampProductSetting = timeStampProductSetting;}
	public Timestamp getTimeStampProductSetting() {return this.timeStampProductSetting;}

}
