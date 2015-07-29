package gov.virginia.ehhr.commonhelp.domain;

import java.util.List;

public class MedicalData {
	
	private String applicationId;
	private String memberId;
	private List<MedicalBill> medicalBills;
	
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

	public List<MedicalBill> getMedicalBills() {
		return medicalBills;
	}

	public void setMedicalBills(List<MedicalBill> medicalBills) {
		this.medicalBills = medicalBills;
	}
	

}
