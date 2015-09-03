package gov.virginia.ehhr.commonhelp.domain;

public class EmployeeHealthInsurance {
	
	private String applicationId;
	private String memberId;
	private Boolean isEmployeeHealthInsurance;
	private String employerName;
	private Address employerAddress;
	private String employerPhone;
	private String employerPhoneExt;
	private String employerEIN;
	private String employerContactName;
	private String employerContactPhone;
	private String employerContactEmail;
	private String policyNumber;
	
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
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
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
	public String getEmployerPhoneExt() {
		return employerPhoneExt;
	}
	public void setEmployerPhoneExt(String employerPhoneExt) {
		this.employerPhoneExt = employerPhoneExt;
	}
	public String getEmployerEIN() {
		return employerEIN;
	}
	public void setEmployerEIN(String employerEIN) {
		this.employerEIN = employerEIN;
	}
	public String getEmployerContactName() {
		return employerContactName;
	}
	public void setEmployerContactName(String employerContactName) {
		this.employerContactName = employerContactName;
	}
	public String getEmployerContactPhone() {
		return employerContactPhone;
	}
	public void setEmployerContactPhone(String employerContactPhone) {
		this.employerContactPhone = employerContactPhone;
	}
	public String getEmployerContactEmail() {
		return employerContactEmail;
	}
	public void setEmployerContactEmail(String employerContactEmail) {
		this.employerContactEmail = employerContactEmail;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public Boolean getIsEmployeeHealthInsurance() {
		return isEmployeeHealthInsurance;
	}
	public void setIsEmployeeHealthInsurance(Boolean isEmployeeHealthInsurance) {
		this.isEmployeeHealthInsurance = isEmployeeHealthInsurance;
	}

}
