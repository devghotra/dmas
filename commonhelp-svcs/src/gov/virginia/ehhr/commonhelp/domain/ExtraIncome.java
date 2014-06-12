package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;

public class ExtraIncome implements Serializable {

	private static final long serialVersionUID = 6947239286894645702L;
	
	private String payType;
	private String payFrequency;
	private String payAmount;
	
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPayFrequency() {
		return payFrequency;
	}
	public void setPayFrequency(String payFrequency) {
		this.payFrequency = payFrequency;
	}
	public String getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}
	
	

}
