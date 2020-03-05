package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="whuser_tab")
public class WhUserType {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "whuser_seq" )
	@SequenceGenerator(name="whuser_seq", sequenceName = "whuser_seq", allocationSize=1)
	private Integer userId;
	@Column(name="user_type")
	private String userType;
	@Column(name="user_code")
	private String userCode;
	@Column(name="user_for")
	private String userFor;
	@Column(name="user_email")
	private String userEmail;
	@Column(name="user_contact")
	private String userContact;
	@Column(name="user_id_type")
	private String userIdType;
	@Column(name="if_other")
	private String ifOther;
	@Column(name="user_id_num")
	private String userIdNum;
	
	public WhUserType() {
		super();
	}
	
	public WhUserType(Integer userId) {
		super();
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserFor() {
		return userFor;
	}
	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserIdType() {
		return userIdType;
	}
	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}
	public String getIfOther() {
		return ifOther;
	}
	public void setIfOther(String ifOther) {
		this.ifOther = ifOther;
	}
	public String getUserIdNum() {
		return userIdNum;
	}
	public void setUserIdNum(String userIdNum) {
		this.userIdNum = userIdNum;
	}
	@Override
	public String toString() {
		return "WHUserType [userId=" + userId + ", userType=" + userType + ", userCode=" + userCode + ", userFor="
				+ userFor + ", userEmail=" + userEmail + ", userContact=" + userContact + ", userIdType=" + userIdType
				+ ", ifOther=" + ifOther + ", userIdNum=" + userIdNum + "]";
	}
	
}
