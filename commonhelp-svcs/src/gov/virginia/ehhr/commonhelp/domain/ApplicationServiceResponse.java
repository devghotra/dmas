package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;

public class ApplicationServiceResponse implements Serializable{

	private static final long serialVersionUID = 2899187746194208977L;
	
	private int responseCode;
	private String applicationId;
	private Applicant applicant;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	
	

}
