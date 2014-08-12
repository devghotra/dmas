package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;
import java.util.List;

public class Applicant implements Serializable{

	private static final long serialVersionUID = -4068121935349308807L;
	
	private String userName;
	private String applicationId;
	private String applicantId;
	private String firstName;
	private String miName;
	private String lastName;
	private String suffix;
	private String gender;
	private String dob;
	private String prefSpokenLanguage;
	private String prefReadLanguage;
	private String countyCity;
	private String maritalStatus;	
	private String prefCommunicationMethod;
	private String homePhone;
	private String workPhone;
	private String cellPhone;
	private String emailAddress;
	private String livingArrangement;
	private String livingType;
	private Address residentialAddress;
	private Address mailingAddress;
	private Boolean spouseOutHomeFlag;
	private Boolean mailAddressDifferentFlag;
	private Boolean languageFlag;
	private Boolean transportationFlag;
	private Boolean disabilityFlag;
	private Boolean virginiaResidentFlag;
	private String tribe;
	private Boolean childCareApplicationFlag;
	private Boolean medicaidApplicationFlag;
	private String ssn;
	private String noSsnReason;
	private String ssnAppliedDate;
	private Boolean usCitizenFlag;
	private Race race;
	private Ethnicity ethnicity;
	private String taxFileType;
	private Boolean tempAwayHomeFlag;
	private Boolean ssnFlag;
	private Boolean applyingAssitanceFlag;
	private List<HouseholdMember> hhMemberList;
	private Integer totalHouseHoldMembers;
	private Integer totalTaxDependents;
	
	
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiName() {
		return miName;
	}
	public void setMiName(String miName) {
		this.miName = miName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPrefSpokenLanguage() {
		return prefSpokenLanguage;
	}
	public void setPrefSpokenLanguage(String prefSpokenLanguage) {
		this.prefSpokenLanguage = prefSpokenLanguage;
	}
	public String getPrefReadLanguage() {
		return prefReadLanguage;
	}
	public void setPrefReadLanguage(String prefReadLanguage) {
		this.prefReadLanguage = prefReadLanguage;
	}
	public String getCountyCity() {
		return countyCity;
	}
	public void setCountyCity(String countyCity) {
		this.countyCity = countyCity;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Address getResidentialAddress() {
		return residentialAddress;
	}
	public void setResidentialAddress(Address residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	public Address getMailingAddress() {
		return mailingAddress;
	}
	public void setMailingAddress(Address mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	public String getPrefCommunicationMethod() {
		return prefCommunicationMethod;
	}
	public void setPrefCommunicationMethod(String prefCommunicationMethod) {
		this.prefCommunicationMethod = prefCommunicationMethod;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Boolean getSpouseOutHomeFlag() {
		return spouseOutHomeFlag;
	}
	public void setSpouseOutHomeFlag(Boolean spouseOutHomeFlag) {
		this.spouseOutHomeFlag = spouseOutHomeFlag;
	}
	public Boolean getMailAddressDifferentFlag() {
		return mailAddressDifferentFlag;
	}
	public void setMailAddressDifferentFlag(Boolean mailAddressDifferentFlag) {
		this.mailAddressDifferentFlag = mailAddressDifferentFlag;
	}
	public Boolean getLanguageFlag() {
		return languageFlag;
	}
	public void setLanguageFlag(Boolean languageFlag) {
		this.languageFlag = languageFlag;
	}
	public Boolean getTransportationFlag() {
		return transportationFlag;
	}
	public void setTransportationFlag(Boolean transportationFlag) {
		this.transportationFlag = transportationFlag;
	}
	public Boolean getDisabilityFlag() {
		return disabilityFlag;
	}
	public void setDisabilityFlag(Boolean disabilityFlag) {
		this.disabilityFlag = disabilityFlag;
	}
	public Boolean getVirginiaResidentFlag() {
		return virginiaResidentFlag;
	}
	public void setVirginiaResidentFlag(Boolean virginiaResidentFlag) {
		this.virginiaResidentFlag = virginiaResidentFlag;
	}
	public String getLivingArrangement() {
		return livingArrangement;
	}
	public void setLivingArrangement(String livingArrangement) {
		this.livingArrangement = livingArrangement;
	}
	public String getTribe() {
		return tribe;
	}
	public void setTribe(String tribe) {
		this.tribe = tribe;
	}
	public Boolean getChildCareApplicationFlag() {
		return childCareApplicationFlag;
	}
	public void setChildCareApplicationFlag(Boolean childCareApplicationFlag) {
		this.childCareApplicationFlag = childCareApplicationFlag;
	}
	public Boolean getMedicaidApplicationFlag() {
		return medicaidApplicationFlag;
	}
	public void setMedicaidApplicationFlag(Boolean medicaidApplicationFlag) {
		this.medicaidApplicationFlag = medicaidApplicationFlag;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getNoSsnReason() {
		return noSsnReason;
	}
	public void setNoSsnReason(String noSsnReason) {
		this.noSsnReason = noSsnReason;
	}
	public String getSsnAppliedDate() {
		return ssnAppliedDate;
	}
	public void setSsnAppliedDate(String ssnAppliedDate) {
		this.ssnAppliedDate = ssnAppliedDate;
	}
	public Boolean getUsCitizenFlag() {
		return usCitizenFlag;
	}
	public void setUsCitizenFlag(Boolean usCitizenFlag) {
		this.usCitizenFlag = usCitizenFlag;
	}
	public Race getRace() {
		return race;
	}
	public void setRace(Race race) {
		this.race = race;
	}
	public Ethnicity getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(Ethnicity ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getTaxFileType() {
		return taxFileType;
	}
	public void setTaxFileType(String taxFileType) {
		this.taxFileType = taxFileType;
	}
	public Boolean getTempAwayHomeFlag() {
		return tempAwayHomeFlag;
	}
	public void setTempAwayHomeFlag(Boolean tempAwayHomeFlag) {
		this.tempAwayHomeFlag = tempAwayHomeFlag;
	}
	public String getLivingType() {
		return livingType;
	}
	public void setLivingType(String livingType) {
		this.livingType = livingType;
	}
	public List<HouseholdMember> getHhMemberList() {
		return hhMemberList;
	}
	public void setHhMemberList(List<HouseholdMember> hhMemberList) {
		this.hhMemberList = hhMemberList;
	}
	public Integer getTotalHouseHoldMembers() {
		return totalHouseHoldMembers;
	}
	public void setTotalHouseHoldMembers(Integer totalHouseHoldMembers) {
		this.totalHouseHoldMembers = totalHouseHoldMembers;
	}
	public Integer getTotalTaxDependents() {
		return totalTaxDependents;
	}
	public void setTotalTaxDependents(Integer totalTaxDependents) {
		this.totalTaxDependents = totalTaxDependents;
	}
	public String getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Boolean getSsnFlag() {
		return ssnFlag;
	}
	public void setSsnFlag(Boolean ssnFlag) {
		this.ssnFlag = ssnFlag;
	}
	public Boolean getApplyingAssitanceFlag() {
		return applyingAssitanceFlag;
	}
	public void setApplyingAssitanceFlag(Boolean applyingAssitanceFlag) {
		this.applyingAssitanceFlag = applyingAssitanceFlag;
	}
	
	
	
}
