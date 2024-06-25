package kr.ac.kopo.transaction.vo;

public class TransactionVO {
	private int	no;//
	private String transactionType;
	private String senderAccountnumber;
	private String receiverAccountnumber;
	private int	transferAmount;
	private int	afterBalance;
	private String transactionDatetime;
	private String Direction;
		
	public TransactionVO(int no, String transactionType, String senderAccountnumber, String receiverAccountnumber,
			int transferAmount, int afterBalance, String transactionDatetime) {
		super();
		this.no = no;
		this.transactionType = transactionType;
		this.senderAccountnumber = senderAccountnumber;
		this.receiverAccountnumber = receiverAccountnumber;
		this.transferAmount = transferAmount;
		this.afterBalance = afterBalance;
		this.transactionDatetime = transactionDatetime;
	}
	
	public TransactionVO() {}

	public int getNo() {	return no;	}
	public void setNo(int no) {	this.no = no;	}
	public String getTransactionType() {	return transactionType;	}
	public void setTransactionType(String transactionType) {	this.transactionType = transactionType;	}
	public String getSenderAccountnumber() {	return senderAccountnumber;	}
	public void setSenderAccountnumber(String senderAccountnumber) {	this.senderAccountnumber = senderAccountnumber;	}
	public String getReceiverAccountnumber() {	return receiverAccountnumber;	}
	public void setReceiverAccountnumber(String receiverAccountnumber) {	this.receiverAccountnumber = receiverAccountnumber;	}
	public int getTransferAmount() {	return transferAmount;	}
	public void setTransferAmount(int transferAmount) {	this.transferAmount = transferAmount;	}
	public int getAfterBalance() {	return afterBalance;	}
	public void setAfterBalance(int afterBalance) {	this.afterBalance = afterBalance;	}
	public String getTransactionDatetime() {	return transactionDatetime;	}
	public void setTransactionDatetime(String transactionDatetime) {	this.transactionDatetime = transactionDatetime;	}
	public String getDirection() {	return Direction;	}
	public void setDirection(String direction) {	Direction = direction;	}

}




