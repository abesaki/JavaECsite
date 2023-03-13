package entity;

import java.sql.Date;
import java.sql.Timestamp;

public class UsersInformation {

	//field.
	private int no; //no int(10) PRIMARY KEY AUTO_INCREMENT,
	private String userId; //userid varchar(10) NOT NULL UNIQUE,
	private String familyName; //familyname varchar(10),
	private String firstName; //firstname varchar(10),
	private String familyNameFurigana; //familyname_furigana varchar(10),
	private String firstNameFurigana; //firstname_furigana varchar(10),
	private String gender; //gender varchar(5),
	private Date birthday; //birthday date,
	private String addressPrefectures; //address_prefectures varchar(5),
	private String addressMunicipality; //address_municipality varchar(100),
	private String emailAddress; //email_address varchar(50),
	private String phoneNumber; //phone_number varchar(15),
	private Timestamp timeStamp; //timestamp timestamp,

	//setter,getter.
	public void setNo(int no) {this.no = no;}
	public int getNo() {return this.no;}

	public void setUserId(String userId) {this.userId = userId;}
	public String getUserId() {return this.userId;}

	public void setFamilyName(String familyName) {this.familyName = familyName;}
	public String getFamilyName() {return this.familyName;}

	public void setFirstName(String firstName) {this.firstName = firstName;}
	public String getFirstName() {return this.firstName;}

	public void setFamilyNameFurigana(String familyNameFurigana) {this.familyNameFurigana = familyNameFurigana;}
	public String getFamilyNameFurigana() {return this.familyNameFurigana;}

	public void setFirstNameFurigana(String firstNameFurigana) {this.firstNameFurigana = firstNameFurigana;}
	public String getFirstNameFurigana() {return this.firstNameFurigana;}

	public void setGender(String gender) {this.gender = gender;}
	public String getGender() {return this.gender;}

	public void setBirthday(Date birthday) {this.birthday = birthday;}
	public Date getBirthday() {return this.birthday;}

	public void setAddressPrefectures(String addressPrefectures) {this.addressPrefectures = addressPrefectures;}
	public String getAddressPrefectures() {return this.addressPrefectures;}

	public void setAddressMunicipality(String addressMunicipality) {this.addressMunicipality = addressMunicipality;}
	public String getAddressMunicipality() {return this.addressMunicipality;}

	public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}
	public String getEmailAddress() {return this.emailAddress;}

	public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
	public String getPhoneNumber() {return this.phoneNumber;}

	public void setTimeStamp(Timestamp timeStamp) {this.timeStamp = timeStamp;}
	public Timestamp getTimeStamp() {return this.timeStamp;}
}
