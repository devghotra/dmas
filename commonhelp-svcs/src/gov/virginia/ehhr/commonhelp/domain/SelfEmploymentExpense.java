package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;

public class SelfEmploymentExpense implements Serializable{

	private static final long serialVersionUID = 7862532429543990155L;
	
	private String expenseType;
	private String expenseAmount;
	
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getExpenseAmount() {
		return expenseAmount;
	}
	public void setExpenseAmount(String expenseAmount) {
		this.expenseAmount = expenseAmount;
	}
	
	

}
