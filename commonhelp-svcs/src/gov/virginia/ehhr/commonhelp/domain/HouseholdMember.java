package gov.virginia.ehhr.commonhelp.domain;
import gov.virginia.ehhr.commonhelp.domain.Ethnicity;
import gov.virginia.ehhr.commonhelp.domain.Race;

import java.io.Serializable;


public class HouseholdMember implements Serializable {

	private static final long serialVersionUID = 1279270126770281616L;
	
	private String applicationId;
	private String hhMemberId;
	private String firstName;
	private String miName;
	private String lastName;
	private String suffix;
	private String gender;
	private String dob;
	private String maritalStatus;
	private String livingType;
	private Boolean virginiaResidentFlag;
	private Boolean ssnFlag;
	private String ssn;
	private String noSsnReason;
	private String ssnAppliedDate;
	private String tribe;
	private Boolean usCitizenFlag;
	private Race race;
	private Ethnicity ethnicity;
	private String taxFileType;
	private Boolean tempAwayHomeFlag;
	private Boolean applyingAssitanceFlag;
	private Boolean pregnantFlag;
	private Alien alien;
	
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
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getLivingType() {
		return livingType;
	}
	public void setLivingType(String livingType) {
		this.livingType = livingType;
	}
	public Boolean getVirginiaResidentFlag() {
		return virginiaResidentFlag;
	}
	public void setVirginiaResidentFlag(Boolean virginiaResidentFlag) {
		this.virginiaResidentFlag = virginiaResidentFlag;
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
	public String getTribe() {
		return tribe;
	}
	public void setTribe(String tribe) {
		this.tribe = tribe;
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
	public Boolean getApplyingAssitanceFlag() {
		return applyingAssitanceFlag;
	}
	public void setApplyingAssitanceFlag(Boolean applyingAssitanceFlag) {
		this.applyingAssitanceFlag = applyingAssitanceFlag;
	}
	public String getHhMemberId() {
		return hhMemberId;
	}
	public void setHhMemberId(String hhMemberId) {
		this.hhMemberId = hhMemberId;
	}
	public Boolean getSsnFlag() {
		return ssnFlag;
	}
	public void setSsnFlag(Boolean ssnFlag) {
		this.ssnFlag = ssnFlag;
	}
	public Boolean getPregnantFlag() {
		return pregnantFlag;
	}
	public void setPregnantFlag(Boolean pregnantFlag) {
		this.pregnantFlag = pregnantFlag;
	}
	public Alien getAlien() {
		return alien;
	}
	public void setAlien(Alien alien) {
		this.alien = alien;
	}
	
	

}
