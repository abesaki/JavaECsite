package entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Users {

	//field.
	private int id; // `id` int(10) NOT NULL AUTO_INCREMENT,
	private String userId; // `userid` varchar(10) NOT NULL,
	private String password; // `password` varchar(20) NOT NULL,
	private String familyName; // `familyname` varchar(10) DEFAULT NULL,
	private String firstName; // `firstname` varchar(10) DEFAULT NULL,
	private String familyNameFurigana; // `familyname_furigana` varchar(10) DEFAULT NULL,
	private String firstNameFurigana; // `firstname_furigana` varchar(10) DEFAULT NULL,
	private Date birthDay; // `birthday` date DEFAULT NULL,
	private String addressPrefectures; // `address_prefectures` varchar(5) DEFAULT NULL,
	private String addressMunicipality; // `address_municipality` varchar(100) DEFAULT NULL,
	private String emailAddress; // `email_address` varchar(50) DEFAULT NULL,
	private int phoneNumber; // `phone_number` int(15) DEFAULT NULL,
	private Timestamp registrationDate; // `registration_date` timestamp NOT NULL DEFAULT current_timestamp(),
	private Timestamp updatedDate; // `updated_date` timestamp NOT NULL DEFAULT current_timestamp(),

	//setter,getter.
	public void setId(int id) {this.id = id;}
	public int getId() {return this.id;}

	public void setUserId(String userId) {this.userId = userId;}
	public String getUserId() {return this.userId;}

	public void setPassword(String password) {this.password = password;}
	public String getPassword() {return this.password;}

	public void setFamilyName(String familyName) {this.familyName = familyName;}
	public String getFamilyName() {return this.familyName;}

	public void setFirstName(String firstName) {this.firstName = firstName;}
	public String getFirstName() {return this.firstName;}

	public void setFamilyNameFurigana(String familyNameFurigana) {this.familyNameFurigana = familyNameFurigana;}
	public String getFamilyNameFurigana() {return this.familyNameFurigana;}

	public void setFirstNameFurigana(String firstNameFurigana) {this.firstNameFurigana = firstNameFurigana;}
	public String getFirstNameFurigana() {return this.firstNameFurigana;}

	public void setBirthDay(Date birthDay) {this.birthDay = birthDay;}
	public Date getBirthDay() {return this.birthDay;}

	public void setAddressPrefectures(String addressPrefectures) {this.addressPrefectures = addressPrefectures;}
	public String getAddressPrefectures() {return this.addressPrefectures;}

	public void setAddressMunicipality(String addressMunicipality) {this.addressMunicipality = addressMunicipality;}
	public String getAddressMunicipality() {return this.addressMunicipality;}

	public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}
	public String getEmailAddress() {return this.emailAddress;}

	public void setPhoneNumber(int phoneNumber) {this.phoneNumber = phoneNumber;}
	public int getPhoneNumber() {return this.phoneNumber;}

	public void setRegistrationDate(Timestamp registrationDate) {this.registrationDate = registrationDate;}
	public Timestamp getRegistrationDate() {return this.registrationDate;}

	public void setUpdatedDate(Timestamp updatedDate) {this.updatedDate = updatedDate;}
	public Timestamp getUpdatedDate() {return this.updatedDate;}

}

