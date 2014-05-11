package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;

public class Applicant implements Serializable{

	private static final long serialVersionUID = -4068121935349308807L;
	
	private String applicationId;
	private String firstName;
	private String miName;
	private String lastName;
	
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
	
	

}
