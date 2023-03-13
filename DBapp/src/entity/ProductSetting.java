package entity;

import java.sql.Timestamp;

public class ProductSetting {

	//field.
	private int no; //`id` int(10) NOT NULL AUTO_INCREMENT.
	private String productName; //`productName` varchar(10) NOT NULL.
	private int autoAddStockCount; //`autoAddStockCount` int(10) DEFAULT 100.
	private int countLowerLimit; //`countLowerLimit` int(10) DEFAULT 10.
	private Timestamp timeStamp; //`timestamp` timestamp NOT NULL DEFAULT current_timestamp().

	//setter,getter.
	public void setNo(int no) {this.no = no;}
	public int getNo() {return this.no;}

	public void setProductName(String productName) {this.productName = productName;}
	public String getProductName() {return this.productName;}

	public void setAutoAddStockCount(int autoAddStockCount) {this.autoAddStockCount = autoAddStockCount;}
	public int getAutoAddStockCount() {return this.autoAddStockCount;}

	public void setCountLowerLimit(int countLowerLimit) {this.countLowerLimit = countLowerLimit;}
	public int getCountLowerLimit() {return this.countLowerLimit;}

	public void setTimeStamp(Timestamp timeStamp) {this.timeStamp = timeStamp;}
	public Timestamp getTimeStamp() {return this.timeStamp;}

}
