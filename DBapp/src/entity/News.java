package entity;

import java.util.Date;

public class News {

	//field.
	private int no; //int(10) PRIMARY KEY AUTO_INCREMENT,.
	private Date date; //date NOT NULL DEFAULT(CURRENT_DATE)(現在日時).
	private String title; //varchar(50) NOT NULL.
	private String body; //varchar(500) NOT NULL.
	private String author; //varchar(50) DEFAULT('NoName').
	private Date timestamp; //timestamp NOT NULL DEFAULT current_timestamp().


	//setter,getter.
	public void setNo(int no) {this.no = no;}
	public int getNo() {return this.no;}

	public void setDate(Date date) {this.date = date;}
	public Date getDate() {return this.date;}

	public void setTitle(String title) {this.title = title;}
	public String getTitle() {return this.title;}

	public void setBody(String body) {this.body = body;}
	public String getBody() {return this.body;}

	public void setAuthor(String author) {this.author = author;}
	public String getAuthor() {return this.author;}

	public void setTimestamp(Date timestamp) {this.timestamp = timestamp;}
	public Date getTimestamp() {return this.timestamp;}

}

