package entity;

import java.sql.Timestamp;

public class Product {

	//field.
	private int id; // `id` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY.
	private String name; // `name` varchar(20) NOT NULL UNIQUE KEY.
	private int price; // `price` int(10) DEFAULT 0.
	private int stock; // `stock` int(10) DEFAULT 0.
	private Timestamp stockUpdateTime; // `stock_update_time` timestamp NOT NULL DEFAULT current_timestamp().
	private int autoAddStockCount; // `auto_add_stock_count` int(10) DEFAULT 0.
	private int stockLowerLimit; // `stock_lower_limit` int(10) DEFAULT 0.
	private Timestamp settingChangeTime; // `setting_change_time` timestamp NOT NULL DEFAULT current_timestamp().

	//setter,getter.
	public void setId(int id) {this.id = id;}
	public int getId() {return this.id;}

	public void setName(String name) {this.name = name;}
	public String getName() {return this.name;}

	public void setPrice(int price) {this.price = price;}
	public int getPrice() {return this.price;}

	public void setStock(int stock) {this.stock = stock;}
	public int getStock() {return this.stock;}

	public void setStockUpdateTime(Timestamp stockUpdateTime) {this.stockUpdateTime = stockUpdateTime;}
	public Timestamp getStockUpdateTime() {return this.stockUpdateTime;}

	public void setAutoAddStockCount(int autoAddStockCount) {this.autoAddStockCount = autoAddStockCount;}
	public int getAutoAddStockCount() {return this.autoAddStockCount;}

	public void setStockLowerLimit(int stockLowerLimit) {this.stockLowerLimit = stockLowerLimit;}
	public int getStockLowerLimit() {return this.stockLowerLimit;}

	public void setSettingChangeTime(Timestamp settingChangeTime) {this.settingChangeTime = settingChangeTime;}
	public Timestamp getSettingChangeTime() {return this.settingChangeTime;}

}
