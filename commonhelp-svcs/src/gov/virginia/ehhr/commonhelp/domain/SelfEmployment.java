package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;
import java.util.List;

public class SelfEmployment implements Serializable{

	private static final long serialVersionUID = 1845826136084510164L;
	
	private String type;
	private String startDate;
	private String grossMonthlyIncome;
	private String hoursPerMonth;
	private String payFrequency;
	private String nextPayDate;
	private List<SelfEmploymentExpense> expenseList;
	
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
	public String getGrossMonthlyIncome() {
		return grossMonthlyIncome;
	}
	public void setGrossMonthlyIncome(String grossMonthlyIncome) {
		this.grossMonthlyIncome = grossMonthlyIncome;
	}
	
	public String getHoursPerMonth() {
		return hoursPerMonth;
	}
	public void setHoursPerMonth(String hoursPerMonth) {
		this.hoursPerMonth = hoursPerMonth;
	}
	public String getPayFrequency() {
		return payFrequency;
	}
	public void setPayFrequency(String payFrequency) {
		this.payFrequency = payFrequency;
	}
	public String getNextPayDate() {
		return nextPayDate;
	}
	public void setNextPayDate(String nextPayDate) {
		this.nextPayDate = nextPayDate;
	}
	public List<SelfEmploymentExpense> getExpenseList() {
		return expenseList;
	}
	public void setExpenseList(List<SelfEmploymentExpense> expenseList) {
		this.expenseList = expenseList;
	}
	
	

	
}
