package kr.ac.kopo.account.vo;
/*

	CREATE TABLE t_member(
		id varchar2(50) PRIMARY KEY
		, password varchar2(256) NOT NULL
		, name varchar2(100) NOT NULL
		, phone varchar2(15) 
		, TYPE char(1) DEFAULT 'U'
	)	

 */

/*
 	1. 모든 멤버변수는 private 접근제한자 설정
 	2. 기본생성자 필수
 	3. getter/setter 메소드
 */

public class AccountVO {
//ID , Password , Name , BirthDay , Tel ,ResidentRegistrationNumber ,CreditScore
	private String accountNumber;
	private String onwerId;
	private int transferPassword;
	private String name;
	private Long balance;
	private String accountOpeningDate;
	private int productNo;
	
	public AccountVO() {}

	public AccountVO(String accountNumber, String onwerId, int transferPassword, String name, Long balance,
			String accountOpeningDate, int productNo) {
		super();
		this.accountNumber = accountNumber;
		this.onwerId = onwerId;
		this.transferPassword = transferPassword;
		this.name = name;
		this.balance = balance;
		this.accountOpeningDate = accountOpeningDate;
		this.productNo = productNo;
	}

	public String getAccountNumber() {	return accountNumber;	}
	public void setAccountNumber(String accountNumber) {	this.accountNumber = accountNumber;	}
	public String getOnwerId() {	return onwerId;	}
	public void setOnwerId(String onwerId) {	this.onwerId = onwerId;	}
	public int getTransferPassword() {	return transferPassword;	}
	public void setTransferPassword(int transferPassword) {	this.transferPassword = transferPassword;	}
	public String getName() {	return name;	}
	public void setName(String name) {	this.name = name;	}
	public Long getBalance() {	return balance;	}
	public void setBalance(Long balance) {	this.balance = balance;	}
	public String getAccountOpeningDate() {	return accountOpeningDate;	}
	public void setAccountOpeningDate(String accountOpeningDate) {	this.accountOpeningDate = accountOpeningDate;	}
	public int getProductNo() {	return productNo;	}
	public void setProductNo(int productNo) {	this.productNo = productNo;	}

	@Override
	public String toString() {
		return "AccountVO [accountNumber=" + accountNumber + ", onwerId=" + onwerId + ", transferPassword="
				+ transferPassword + ", name=" + name + ", balance=" + balance + ", accountOpeningDate="
				+ accountOpeningDate + ", productNo=" + productNo + "]";
	}

	
}



