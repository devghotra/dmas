package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class ApplicationServiceResponse implements Serializable{

	private static final long serialVersionUID = 2899187746194208977L;
	
	private int responseCode;
	private String error;
	private String applicationId;
	private Applicant applicant;
	private List<HouseholdMember> hhMemberList;
	private HouseholdMember hhMember;
	private Income income;
	private HashMap<String, List<Income>> incomeList;
	private UserProfile userProfile;
	private List<Relationship> relationShipList;
	private MedicalData medicalData;
	private MedicareData medicareData;
	private List<MedicalData> medicalDataList;
	private List<MedicareData> medicareDataList;

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

	public List<HouseholdMember> getHhMemberList() {
		return hhMemberList;
	}

	public void setHhMemberList(List<HouseholdMember> hhMemberList) {
		this.hhMemberList = hhMemberList;
	}

	public HouseholdMember getHhMember() {
		return hhMember;
	}

	public void setHhMember(HouseholdMember hhMember) {
		this.hhMember = hhMember;
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public HashMap<String, List<Income>> getIncomeList() {
		return incomeList;
	}

	public void setIncomeList(HashMap<String, List<Income>> incomeList) {
		this.incomeList = incomeList;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public List<Relationship> getRelationShipList() {
		return relationShipList;
	}

	public void setRelationShipList(List<Relationship> relationShipList) {
		this.relationShipList = relationShipList;
	}

	public MedicalData getMedicalData() {
		return medicalData;
	}

	public void setMedicalData(MedicalData medicalData) {
		this.medicalData = medicalData;
	}

	public MedicareData getMedicareData() {
		return medicareData;
	}

	public void setMedicareData(MedicareData medicareData) {
		this.medicareData = medicareData;
	}

	public List<MedicalData> getMedicalDataList() {
		return medicalDataList;
	}

	public void setMedicalDataList(List<MedicalData> medicalDataList) {
		this.medicalDataList = medicalDataList;
	}

	public List<MedicareData> getMedicareDataList() {
		return medicareDataList;
	}

	public void setMedicareDataList(List<MedicareData> medicareDataList) {
		this.medicareDataList = medicareDataList;
	}
	
	
}
