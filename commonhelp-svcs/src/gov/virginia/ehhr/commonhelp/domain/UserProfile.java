package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;
import java.util.List;

public class UserProfile implements Serializable {

	private static final long serialVersionUID = 4200785183355493990L;
	
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String authtoken;
	private String applicationId;
	List<SecurityQA> securityQAList;
	
	// advanced fields
	private String ssn;
	private String dob;
	private String phone;
	private Address address;
	private List<KnowledgeBaseAuthQA> kbaList;
	private Integer accessLevel = 1;
	
	private boolean memberPortalAccess = true;
	private boolean providerAccess = true;
	private boolean claimsAccess = true;
	private boolean pharmacyAccess = false;
	private boolean mmisAccess = false;
	private boolean reportsAccess = false;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getAuthtoken() {
		return authtoken;
	}
	public void setAuthtoken(String authtoken) {
		this.authtoken = authtoken;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public List<SecurityQA> getSecurityQAList() {
		return securityQAList;
	}
	public void setSecurityQAList(List<SecurityQA> securityQAList) {
		this.securityQAList = securityQAList;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<KnowledgeBaseAuthQA> getKbaList() {
		return kbaList;
	}

	public void setKbaList(List<KnowledgeBaseAuthQA> kbaList) {
		this.kbaList = kbaList;
	}
	public Integer getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(Integer accessLevel) {
		this.accessLevel = accessLevel;
	}
	public boolean isMemberPortalAccess() {
		return memberPortalAccess;
	}
	public void setMemberPortalAccess(boolean memberPortalAccess) {
		this.memberPortalAccess = memberPortalAccess;
	}
	public boolean isProviderAccess() {
		return providerAccess;
	}
	public void setProviderAccess(boolean providerAccess) {
		this.providerAccess = providerAccess;
	}
	public boolean isClaimsAccess() {
		return claimsAccess;
	}
	public void setClaimsAccess(boolean claimsAccess) {
		this.claimsAccess = claimsAccess;
	}
	public boolean isPharmacyAccess() {
		return pharmacyAccess;
	}
	public void setPharmacyAccess(boolean pharmacyAccess) {
		this.pharmacyAccess = pharmacyAccess;
	}
	public boolean isMmisAccess() {
		return mmisAccess;
	}
	public void setMmisAccess(boolean mmisAccess) {
		this.mmisAccess = mmisAccess;
	}
	public boolean isReportsAccess() {
		return reportsAccess;
	}
	public void setReportsAccess(boolean reportsAccess) {
		this.reportsAccess = reportsAccess;
	}

}
