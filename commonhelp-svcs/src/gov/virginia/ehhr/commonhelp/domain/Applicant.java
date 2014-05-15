package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;

public class Applicant implements Serializable{

	private static final long serialVersionUID = -4068121935349308807L;
	
	private String applicationId;
	private String firstName;
	private String miName;
	private String lastName;
	private String suffix;
	private String gender;
	private String dob;
	private String prefSpokenLanguage;
	private String prefReadLanguage;
	private String countyCity;
	private boolean virginaResidentFlag;
	private String maritalStatus;
	private boolean languageFlag;
	private boolean transportationFlag;
	private boolean disabilityFlag;
	private Address residentialAddress;
	private Address mailingAddress;
	private boolean mailAddressDifferentFlag;
	private String prefCommunicationMethod;
	private String homePhone;
	private String workPhone;
	private String cellPhone;
	private String emailAddress;
	private boolean spouseOutHomeFlag;
	
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
	public boolean isVirginaResidentFlag() {
		return virginaResidentFlag;
	}
	public void setVirginaResidentFlag(boolean virginaResidentFlag) {
		this.virginaResidentFlag = virginaResidentFlag;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public boolean isLanguageFlag() {
		return languageFlag;
	}
	public void setLanguageFlag(boolean languageFlag) {
		this.languageFlag = languageFlag;
	}
	public boolean isTransportationFlag() {
		return transportationFlag;
	}
	public void setTransportationFlag(boolean transportationFlag) {
		this.transportationFlag = transportationFlag;
	}
	public boolean isDisabilityFlag() {
		return disabilityFlag;
	}
	public void setDisabilityFlag(boolean disabilityFlag) {
		this.disabilityFlag = disabilityFlag;
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
	public boolean isMailAddressDifferentFlag() {
		return mailAddressDifferentFlag;
	}
	public void setMailAddressDifferentFlag(boolean mailAddressDifferentFlag) {
		this.mailAddressDifferentFlag = mailAddressDifferentFlag;
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
	public boolean isSpouseOutHomeFlag() {
		return spouseOutHomeFlag;
	}
	public void setSpouseOutHomeFlag(boolean spouseOutHomeFlag) {
		this.spouseOutHomeFlag = spouseOutHomeFlag;
	}

	
	

}
