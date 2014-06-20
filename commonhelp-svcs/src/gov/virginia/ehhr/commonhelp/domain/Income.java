package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;
import java.util.List;

public class Income implements Serializable {

	private static final long serialVersionUID = 1605911164479533153L;
	
	private String applicationId;
	private String memberId;
	private String incomeType;
	private String incomeId;
	private String employerName;
	private String employerType;
	private Address employerAddress;
	private String employerPhone;
	private String employmentStartDate;
	private String employmentEndDate;
	private String employmentFirstPayDate;
	private String finalPayCheckDate;
	private Boolean hourReducedFlag;
	private String payFrequency;
	private String payWeekDay;
	private String nextPayDate;
	private String payType;
	private String hourlyRate;
	private String weeklyHours;
	private String salaryPerPeriod;
	private String finalPayCheckAmount;
	private String jobEndedReasonCode;
	private String totalIncome;
	private List<ExtraIncome> extraIncomeList;
	private SelfEmployment selfEmployment;
	private Boolean changeInIncomeFlag;
	
	
	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public String getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(String incomeId) {
		this.incomeId = incomeId;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getEmployerType() {
		return employerType;
	}

	public void setEmployerType(String employerType) {
		this.employerType = employerType;
	}

	public Address getEmployerAddress() {
		return employerAddress;
	}

	public void setEmployerAddress(Address employerAddress) {
		this.employerAddress = employerAddress;
	}

	public String getEmployerPhone() {
		return employerPhone;
	}

	public void setEmployerPhone(String employerPhone) {
		this.employerPhone = employerPhone;
	}

	public String getEmploymentStartDate() {
		return employmentStartDate;
	}

	public void setEmploymentStartDate(String employmentStartDate) {
		this.employmentStartDate = employmentStartDate;
	}

	public String getEmploymentFirstPayDate() {
		return employmentFirstPayDate;
	}

	public void setEmploymentFirstPayDate(String employmentFirstPayDate) {
		this.employmentFirstPayDate = employmentFirstPayDate;
	}

	public Boolean getHourReducedFlag() {
		return hourReducedFlag;
	}

	public void setHourReducedFlag(Boolean hourReducedFlag) {
		this.hourReducedFlag = hourReducedFlag;
	}

	public String getPayFrequency() {
		return payFrequency;
	}

	public void setPayFrequency(String payFrequency) {
		this.payFrequency = payFrequency;
	}

	public String getPayWeekDay() {
		return payWeekDay;
	}

	public void setPayWeekDay(String payWeekDay) {
		this.payWeekDay = payWeekDay;
	}

	public String getNextPayDate() {
		return nextPayDate;
	}

	public void setNextPayDate(String nextPayDate) {
		this.nextPayDate = nextPayDate;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(String hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getWeeklyHours() {
		return weeklyHours;
	}

	public void setWeeklyHours(String weeklyHours) {
		this.weeklyHours = weeklyHours;
		this.setTotalIncome(null);
	}

	public String getSalaryPerPeriod() {
		return salaryPerPeriod;
	}

	public void setSalaryPerPeriod(String salaryPerPeriod) {
		this.salaryPerPeriod = salaryPerPeriod;
		this.setTotalIncome(null);
	}

	public List<ExtraIncome> getExtraIncomeList() {
		return extraIncomeList;
	}

	public void setExtraIncomeList(List<ExtraIncome> extraIncomeList) {
		this.extraIncomeList = extraIncomeList;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getEmploymentEndDate() {
		return employmentEndDate;
	}

	public void setEmploymentEndDate(String employmentEndDate) {
		this.employmentEndDate = employmentEndDate;
	}

	public String getFinalPayCheckDate() {
		return finalPayCheckDate;
	}

	public void setFinalPayCheckDate(String finalPayCheckDate) {
		this.finalPayCheckDate = finalPayCheckDate;
	}

	public String getFinalPayCheckAmount() {
		return finalPayCheckAmount;
	}

	public void setFinalPayCheckAmount(String finalPayCheckAmount) {
		this.finalPayCheckAmount = finalPayCheckAmount;
	}

	public String getJobEndedReasonCode() {
		return jobEndedReasonCode;
	}

	public void setJobEndedReasonCode(String jobEndedReasonCode) {
		this.jobEndedReasonCode = jobEndedReasonCode;
	}

	public SelfEmployment getSelfEmployment() {
		return selfEmployment;
	}

	public void setSelfEmployment(SelfEmployment selfEmployment) {
		this.selfEmployment = selfEmployment;
	}

	public Boolean getChangeInIncomeFlag() {
		return changeInIncomeFlag;
	}

	public void setChangeInIncomeFlag(Boolean changeInIncomeFlag) {
		this.changeInIncomeFlag = changeInIncomeFlag;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(String totalIncome) {
		int salary = salaryPerPeriod == null ? 0 : Integer.parseInt(salaryPerPeriod);
		int hrs = weeklyHours == null ? 0 : Integer.parseInt(weeklyHours);
		int hrRate = hourlyRate == null ? 0 : Integer.parseInt(hourlyRate);
		
		
		this.totalIncome = String.valueOf(salary + hrs*hrRate);
	}
	
	
}
