package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;

public class OtherIncome implements Serializable {

	private static final long serialVersionUID = -3479669341278498792L;
	
	private String type;
	private String startDate;
	private String monthlyIncome;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	
	

}
