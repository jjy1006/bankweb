package kr.ac.kopo.member.vo;
public class MemberVO {

	private String id;
	private String password;
	private String name;
	private String BirthDay;
	private String RegDate;
	private String Tel;
	private String RRN;
	private String Credit_Score;
	private String type; // 사용자 유형 (u: 일반 사용자, A: 관리자)
	
	public MemberVO() {}

	public MemberVO(String id, String password, String name, String birthDay, String tel, String rRN) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		BirthDay = birthDay;
		Tel = tel;
		RRN = rRN;
	}
	public MemberVO(String id, String password, String name, String birthDay, String reg_Date, String tel, String rRN,
			String credit_Score) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		BirthDay = birthDay;
		RegDate = reg_Date;
		Tel = tel;
		RRN = rRN;
		Credit_Score = credit_Score;
	}


	
	public String getReg_Date() {	return RegDate;	}
	public void setReg_Date(String reg_Date) {	RegDate = reg_Date;	}
	public String getCredit_Score() {	return Credit_Score;	}
	public void setCredit_Score(String credit_Score) {	Credit_Score = credit_Score;	}
	public String getId() {	return id;	}
	public void setId(String id) {	this.id = id;	}
	public String getPassword() {	return password;	}
	public void setPassword(String password) {	this.password = password;	}
	public String getName() {	return name;	}
	public void setName(String name) {	this.name = name;	}
	public String getBirthDay() {	return BirthDay;	}
	public void setBirthDay(String birthDay) {	BirthDay = birthDay;	}
	public String getTel() {	return Tel;	}
	public void setTel(String tel) {	Tel = tel;	}
	public String getRRN() {	return RRN;	}
	public void setRRN(String rRN) {	RRN = rRN;	}
	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", BirthDay=" + BirthDay
				+ ", Reg_Date=" + RegDate + ", Tel=" + Tel + ", RRN=" + RRN + ", Credit_Score=" + Credit_Score + ""
						+ ", type=" + type + "]";
	}
}



