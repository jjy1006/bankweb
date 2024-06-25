package kr.ac.kopo.product.vo;


public class ProductVO {
//ID , Password , Name , BirthDay , Tel ,ResidentRegistrationNumber ,CreditScore
	private int no;
	private String productName;
	private String productType;//
	private String interestRate;
	private String period;
	private String fine;
	private String maximumLoanAmount;
	private String loanlateFees;//
	
	public ProductVO() {}

	public ProductVO(String productName, String productType, String interestRate, String period, String fine,
			String maximumLoanAmount, String loanlateFees) {
		super();
		this. productName = productName;
		this.productType = productType;
		this.interestRate = interestRate;
		this.period = period;
		this.fine = fine;
		this.maximumLoanAmount = maximumLoanAmount;
		this.loanlateFees = loanlateFees;
	}
	
	
	public int getNo() {	return no;	}
	public void setNo(int no) {	this.no = no;	}

	public String getProductName() {	return productName;	}
	public void setProductName(String productName) {	this.productName = productName;	}
	public String getProductType() {	return productType;	}
	public void setProductType(String productType) {	this.productType = productType;	}
	public String getInterestRate() {	return interestRate;	}
	public void setInterestRate(String interestRate) {	this.interestRate = interestRate;	}
	public String getPeriod() {	return period;	}
	public void setPeriod(String period) {	this.period = period;	}
	public String getFine() {	return fine;	}
	public void setFine(String fine) {	this.fine = fine;	}
	public String getMaximumLoanAmount() {	return maximumLoanAmount;	}
	public void setMaximumLoanAmount(String maximumLoanAmount) {
		this.maximumLoanAmount = maximumLoanAmount;	}
	public String getLoanlateFees() {	return loanlateFees;	}
	public void setLoanlateFees(String loanlateFees) {	this.loanlateFees = loanlateFees;	}
	
	@Override
	public String toString() {
		return "ProductVO [ProductName=" + productName + ", productType=" + productType + ", interestRate="
				+ interestRate + ", period=" + period + ", fine=" + fine + ", maximumLoanAmount=" + maximumLoanAmount
				+ ", loanlateFees=" + loanlateFees + "]";
	}
	
}



