package gov.virginia.ehhr.commonhelp.domain;

import java.util.List;

public class MemberHealthInsurance {
	
	private String applicationId;
	private String memberId;
	private Boolean isMemberHealthInsurance;
	private String premiumAmount;
	private String policyNumber;
	private String coverageBeginDate;
	private String coverageEndDate;
	private String policyType;
	private String coverageType;
	private List<InsuranceCoverage> coverage;
	private String healthInsCompanyName;
	private String healthInsCompanyPhone;
	private Address healthInsCompanyAddress;
	
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Boolean getIsMemberHealthInsurance() {
		return isMemberHealthInsurance;
	}
	public void setIsMemberHealthInsurance(Boolean isMemberHealthInsurance) {
		this.isMemberHealthInsurance = isMemberHealthInsurance;
	}
	public String getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(String premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getCoverageBeginDate() {
		return coverageBeginDate;
	}
	public void setCoverageBeginDate(String coverageBeginDate) {
		this.coverageBeginDate = coverageBeginDate;
	}
	public String getCoverageEndDate() {
		return coverageEndDate;
	}
	public void setCoverageEndDate(String coverageEndDate) {
		this.coverageEndDate = coverageEndDate;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public String getCoverageType() {
		return coverageType;
	}
	public void setCoverageType(String coverageType) {
		this.coverageType = coverageType;
	}
	public List<InsuranceCoverage> getCoverage() {
		return coverage;
	}
	public void setCoverage(List<InsuranceCoverage> coverage) {
		this.coverage = coverage;
	}
	public String getHealthInsCompanyName() {
		return healthInsCompanyName;
	}
	public void setHealthInsCompanyName(String healthInsCompanyName) {
		this.healthInsCompanyName = healthInsCompanyName;
	}
	public String getHealthInsCompanyPhone() {
		return healthInsCompanyPhone;
	}
	public void setHealthInsCompanyPhone(String healthInsCompanyPhone) {
		this.healthInsCompanyPhone = healthInsCompanyPhone;
	}
	public Address getHealthInsCompanyAddress() {
		return healthInsCompanyAddress;
	}
	public void setHealthInsCompanyAddress(Address healthInsCompanyAddress) {
		this.healthInsCompanyAddress = healthInsCompanyAddress;
	}
	
	
}
