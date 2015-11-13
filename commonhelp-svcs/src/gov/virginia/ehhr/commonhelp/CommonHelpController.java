package gov.virginia.ehhr.commonhelp;

import gov.virginia.ehhr.commonhelp.domain.Applicant;
import gov.virginia.ehhr.commonhelp.domain.ApplicationServiceResponse;
import gov.virginia.ehhr.commonhelp.domain.EmployeeHealthInsurance;
import gov.virginia.ehhr.commonhelp.domain.FileUpload;
import gov.virginia.ehhr.commonhelp.domain.HouseholdMember;
import gov.virginia.ehhr.commonhelp.domain.Income;
import gov.virginia.ehhr.commonhelp.domain.KnowledgeBaseAuthQA;
import gov.virginia.ehhr.commonhelp.domain.MedicalData;
import gov.virginia.ehhr.commonhelp.domain.MedicareData;
import gov.virginia.ehhr.commonhelp.domain.MemberHealthInsurance;
import gov.virginia.ehhr.commonhelp.domain.Relationship;
import gov.virginia.ehhr.commonhelp.domain.UserProfile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/medicaid/applicant")
public class CommonHelpController {
	
	static String str = "";
	static Logger LOGGER = LoggerFactory.getLogger(CommonHelpController.class);
	Map<String, Applicant> appStore = new HashMap<String, Applicant>();
	Map<String, Income> incomeStore = new LinkedHashMap<String, Income>();
	Map<String, UserProfile> profileStore = new HashMap<String, UserProfile>();
	Map<String, List<Relationship>> relationStore = new HashMap<String, List<Relationship>>();
	Map<String, MedicalData> medicalDataStore = new HashMap<String, MedicalData>();
	Map<String, MedicareData> medicareDataStore = new HashMap<String, MedicareData>();
	Map<String, EmployeeHealthInsurance> employeeHealthInsuranceStore = new HashMap<String, EmployeeHealthInsurance>();
	Map<String, MemberHealthInsurance> memberHealthInsuranceStore = new HashMap<String, MemberHealthInsurance>();
	Map<String, List<FileUpload>> fileStore = new HashMap<String, List<FileUpload>>();
	
	@RequestMapping(value = "/sign-up-basic", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"}, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse signUpBasic(@RequestBody UserProfile userProfile){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		String userName = userProfile.getUserName();
		
		if(profileStore.get(userName) == null){	
			if(userName.equalsIgnoreCase("kevinsmith") || userName.equalsIgnoreCase("dsg") || userName.equalsIgnoreCase("johndoe")){
				String authtoken = UUID.randomUUID().toString().replace("-", "");
				userProfile.setAuthtoken(authtoken);
				profileStore.put(userName, userProfile);
				svcsResponse.setUserProfile(userProfile);
				svcsResponse.setResponseCode(200);
			} else{
				svcsResponse.setError("Invalid Data");
				svcsResponse.setResponseCode(500);
			}
		} else{
			svcsResponse.setError("Duplicate Username");
			svcsResponse.setResponseCode(500);
		}
		
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/sign-up-advanced", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"}, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse signUpAdvanced(@RequestBody UserProfile userProfile){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		String userName = userProfile.getUserName();
		
		if(profileStore.get(userName) != null){
			UserProfile storedProfile = profileStore.get(userName);
			CommonHelpUtil.merge(storedProfile, userProfile);	
			svcsResponse.setResponseCode(200);
		} else{
			svcsResponse.setError("Invalid Username");
			svcsResponse.setResponseCode(500);
		}
		
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/sign-up-kba", 
    		method = RequestMethod.GET, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse signUpKBA(@RequestParam(value="username") String username){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		if(username != null){
			UserProfile storedProfile = profileStore.get(username);
			storedProfile.setKbaList(CommonHelpUtil.getKnowledgeBaseQAList(username));
			svcsResponse.setUserProfile(storedProfile);
			svcsResponse.setResponseCode(200);
		} else{
			svcsResponse.setError("Invalid Username");
			svcsResponse.setResponseCode(500);
		}
		
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/sign-up-kba", 
    		method = RequestMethod.POST, 
    				consumes = {"application/json"}, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse verifySignUpKBA(@RequestBody UserProfile userProfile){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		String username = userProfile.getUserName();
		boolean kbaAnsMismatched = false;
		UserProfile storedProfile;
		if(username != null){
			storedProfile = profileStore.get(username);
			List<KnowledgeBaseAuthQA> userKbaList = storedProfile.getKbaList();
			List<KnowledgeBaseAuthQA> submittedKbaList = userProfile.getKbaList();
			
			for(int i = 0; i < submittedKbaList.size(); i++){
				if(!userKbaList.get(i).getCorrectAnswer().equalsIgnoreCase(submittedKbaList.get(i).getCorrectAnswer())){
					kbaAnsMismatched = true;
					break;
				}
			}
			
			if(!kbaAnsMismatched)
				storedProfile.setAccessLevel(2);
			
			svcsResponse.setResponseCode(200);
		} else{
			svcsResponse.setError("Invalid Username");
			svcsResponse.setResponseCode(500);
		}
		
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/authorize", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"}, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse authorize(@RequestBody UserProfile userProfile){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		String userName = userProfile.getUserName();
		
		if(profileStore.get(userName) != null){
			UserProfile savedProfile = profileStore.get(userName);
			if(savedProfile.getPassword().equalsIgnoreCase(userProfile.getPassword())){
				svcsResponse.setUserProfile(savedProfile);
				svcsResponse.setResponseCode(200);
			} else{
				svcsResponse.setError("Username password do not match");
				svcsResponse.setResponseCode(500);
			}
		} else{
			svcsResponse.setError("Username password do not match");
			svcsResponse.setResponseCode(500);
		}
		
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/app-id", 
    		method = RequestMethod.GET, 
    		produces = {"application/json"})
	@ResponseBody 
	public ApplicationServiceResponse getApplicationId(){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		String appId = "A"+ new Random().nextInt(10000000);
		svcsResponse.setApplicationId(appId);
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/basic-info", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"}, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse setAboutYouData(@RequestBody Applicant applicant){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		String appId = applicant.getApplicationId();
		String applicantId = applicant.getApplicantId();
		if(applicantId == null || applicantId.isEmpty()){
			applicantId = "A"+new Random().nextInt(10000);
			applicant.setApplicantId(applicantId);
			appStore.put(appId, applicant);
			
			String userName = applicant.getUserName();
			profileStore.get(userName).setApplicationId(appId);
			
		} else{
			CommonHelpUtil.merge(appStore.get(appId), applicant);
		}
		svcsResponse.setApplicationId(appId);
		svcsResponse.setResponseCode(200);
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/basic-info", 
    		method = RequestMethod.GET, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse getAboutYouData(@RequestParam(value="app-id") String appId){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		svcsResponse.setApplicant(appStore.get(appId));
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/household-member", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"}, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse setHouseholdMember(@RequestBody HouseholdMember hhMemberReq) throws Exception{
		boolean addHhMember =  true;
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		String appId = hhMemberReq.getApplicationId();
		
		if(appId == null || appId.isEmpty())
			throw new Exception("App ID not found");
		
			
		Applicant applicant = appStore.get(appId);
		List<HouseholdMember> hhMemberList = applicant.getHhMemberList();
		
		if(hhMemberList == null){
			hhMemberList = new ArrayList<HouseholdMember>();
			applicant.setHhMemberList(hhMemberList);
		} else{
			for(HouseholdMember hhMember : hhMemberList){
				if(hhMember.getHhMemberId().equalsIgnoreCase(hhMemberReq.getHhMemberId())){
					CommonHelpUtil.merge(hhMember, hhMemberReq);
					addHhMember = false;
				}
			}
		}	
		
		if(addHhMember){
			Random randomGenerator = new Random();
			String hhMemberId = "HH"+randomGenerator.nextInt(10000);
			hhMemberReq.setHhMemberId(hhMemberId);
			hhMemberList.add(hhMemberReq);
		}
		
		svcsResponse.setApplicationId(appId);
		svcsResponse.setResponseCode(200);
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/household-member", 
    		method = RequestMethod.GET,
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse getHouseholdMember(@RequestParam(required = true, value="app-id") String appId, @RequestParam(required = false, value="hh-member-id") String hhMemberId) throws Exception{
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		
		Applicant applicant = appStore.get(appId);
		
		if(applicant == null)
			throw new Exception("Applicant not found");
		
		List<HouseholdMember> hhMemberList = applicant.getHhMemberList();
		for(HouseholdMember hhMember : hhMemberList){
			if(hhMemberId.equalsIgnoreCase(hhMember.getHhMemberId())){
				svcsResponse.setHhMember(hhMember);
			}
		}

		return svcsResponse;
	}
	
	@RequestMapping(value = "/income", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"}, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse setIncome(@RequestBody Income income){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		String incomeId = income.getIncomeId();
		
		if(incomeId == null || incomeId.isEmpty()){
			Random randomGenerator = new Random();
			incomeId = "INC"+randomGenerator.nextInt(10000);
			income.setIncomeId(incomeId);
			incomeStore.put(incomeId, income);
		} else{
			CommonHelpUtil.merge(incomeStore.get(incomeId), income);
		}

		svcsResponse.setResponseCode(200);
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/income", 
    		method = RequestMethod.GET, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse getIncome(@RequestParam(value="member-id") String memberId, @RequestParam(value="income-id", required = false) String incomeId, @RequestParam(value="income-type") String incomeType){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		
		for (Map.Entry<String, Income> entry : incomeStore.entrySet()) {
			Income income = entry.getValue();
			if(income.getMemberId().equalsIgnoreCase(memberId) && income.getIncomeType().equalsIgnoreCase(incomeType)){
				if(incomeId == null || income.getIncomeId().equalsIgnoreCase(incomeId)){
					svcsResponse.setIncome(income); 
					break;
				}
			}
		}
		
		return svcsResponse;
	}
	
	@RequestMapping(value = "/income", 
    		method = RequestMethod.DELETE, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse deleteIncome(@RequestParam(value="member-id") String memberId, @RequestParam(value="income-id") String incomeId){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		
		for (Map.Entry<String, Income> entry : incomeStore.entrySet()) {
			Income income = entry.getValue();
			if(income.getMemberId().equalsIgnoreCase(memberId) && income.getIncomeId().equalsIgnoreCase(incomeId)){
				incomeStore.remove(incomeId);
				break;
			}
		}
		
		return svcsResponse;
	}
	
	@RequestMapping(value = "/income/summary", 
    		method = RequestMethod.GET, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse getIncomeSummary(@RequestParam(value="applicationId") String applicationId){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		
		LinkedHashMap<String, List<Income>> incomeList = new LinkedHashMap<String, List<Income>>();
		
		for (Map.Entry<String, Income> entry : incomeStore.entrySet()) {
			List<Income> memberIncomeList = null;
			
			Income income = entry.getValue();
			String memberId = income.getMemberId();
			
			if(income.getApplicationId().equalsIgnoreCase(applicationId)){
				if(incomeList.get(memberId) == null){
					memberIncomeList = new ArrayList<Income>();
					incomeList.put(memberId, memberIncomeList);
				}
				else
					memberIncomeList = incomeList.get(memberId);
				
				memberIncomeList.add(income);
			}
		}
		
		svcsResponse.setIncomeList(incomeList);
		return svcsResponse;
	}
	
	@RequestMapping(value = "/medical-bills", 
    		method = RequestMethod.GET,  
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse getMedicalBills(@RequestParam(value="applicationId") String applicationId, @RequestParam(value="member-id") String memberId){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		MedicalData medicalData = medicalDataStore.get(memberId);
		svcsResponse.setMedicalData(medicalData);
		svcsResponse.setResponseCode(200);
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/medical-bills", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"}, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse setMedicalBills(@RequestBody MedicalData medicalData){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		medicalDataStore.put(medicalData.getMemberId(), medicalData);
		svcsResponse.setResponseCode(200);
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/medicare", 
    		method = RequestMethod.GET,  
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse getMedicare(@RequestParam(value="applicationId") String applicationId, @RequestParam(value="member-id") String memberId){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		MedicareData medicalData = medicareDataStore.get(memberId);
		svcsResponse.setMedicareData(medicalData);
		svcsResponse.setResponseCode(200);
		return svcsResponse;	
	}
	
	
	@RequestMapping(value = "/medicare", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"}, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse setMedicare(@RequestBody MedicareData medicareData){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		medicareDataStore.put(medicareData.getMemberId(), medicareData);
		svcsResponse.setResponseCode(200);
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/medical/summary", 
    		method = RequestMethod.GET, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse getMedicalSummary(@RequestParam(value="applicationId") String applicationId){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		
		List<MedicalData> medicalDataList = new ArrayList<MedicalData>();
		List<MedicareData> medicareDataList = new ArrayList<MedicareData>();
		
		for(Entry<String, MedicalData> medicalDataEntry : medicalDataStore.entrySet()){
			MedicalData medicalData = medicalDataEntry.getValue();
			if(medicalData.getApplicationId().equalsIgnoreCase(applicationId)){
				medicalDataList.add(medicalData);
			}
		}
		
		for(Entry<String, MedicareData> medicareDataEntry : medicareDataStore.entrySet()){
			MedicareData medicareData = medicareDataEntry.getValue();
			if(medicareData.getApplicationId().equalsIgnoreCase(applicationId)){
				medicareDataList.add(medicareData);
			}
		}
		
		svcsResponse.setMedicalDataList(medicalDataList);
		svcsResponse.setMedicareDataList(medicareDataList);
		
		return svcsResponse;
	}
	
	@RequestMapping(value = "/application", 
    		method = RequestMethod.GET, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse getApplicationId(@RequestParam(value="userName", required = true) String userName){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		svcsResponse.setApplicationId(profileStore.get(userName).getApplicationId());
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/relationship/summary", 
    		method = RequestMethod.GET, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse getRelationshipSummary(@RequestParam(value="app-id", required = true) String appId){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		List<Relationship> relationshipList = new ArrayList<Relationship>();
		Applicant applicant = appStore.get(appId);
		relationshipList.addAll(relationStore.get(applicant.getApplicantId()));
		
		List<HouseholdMember> hhMemberList = applicant.getHhMemberList();
		for(HouseholdMember hhMember : hhMemberList){
			if(relationStore.get(hhMember.getHhMemberId()) != null)
				relationshipList.addAll(relationStore.get(hhMember.getHhMemberId()));
		}
		
		svcsResponse.setRelationShipList(relationshipList);
		svcsResponse.setResponseCode(200);
		return svcsResponse;
	}
	
	
	@RequestMapping(value = "/relationship", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"}, 
    	    produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse setRelationship(@RequestBody Applicant applicant){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		List<Relationship> relationshipList = applicant.getRelationship();
		
		if(relationshipList != null){
			for(Relationship rs : relationshipList){
				String gender = rs.getMemberGender();
				if(gender.equalsIgnoreCase("male"))
					rs.setRelation(Relationship.maleRelations.get(rs.getRelationCode()));
				else
					rs.setRelation(Relationship.femaleRelations.get(rs.getRelationCode()));
			}
		}
		
		relationStore.put(relationshipList.get(0).getMemberId(), relationshipList);
		svcsResponse.setResponseCode(200);
		return svcsResponse;
	}
	
	@RequestMapping(value = "/relationship", 
    		method = RequestMethod.GET, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse getRelationship(@RequestParam(value="app-id", required = true) String appId, @RequestParam(value="member-id", required = true) String memberId){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		List<Relationship> rsList = new ArrayList<Relationship>();
		Applicant applicant = appStore.get(appId);
		if(relationStore.get(memberId) == null){
			List<HouseholdMember> hhMemberList = applicant.getHhMemberList();
			// relationship for applicant
			if(applicant.getApplicantId().equalsIgnoreCase(memberId)){
				for(HouseholdMember hhMember : hhMemberList){
					Relationship relationWithMember = new Relationship();
					relationWithMember.setMemberId(memberId);
					relationWithMember.setMemberGender(applicant.getGender());
					relationWithMember.setRelationWithMemberId(hhMember.getHhMemberId());
					relationWithMember.setRelation("");
					relationWithMember.setRelationCode("");
					rsList.add(relationWithMember);
				}
			} 
			// relationship for member
			else{ 
				String gender = "";
				for(HouseholdMember hhMember : hhMemberList){
					if(hhMember.getHhMemberId().equalsIgnoreCase(memberId)){
						gender = hhMember.getGender();
						break;
					}
				}
				
				for(HouseholdMember hhMember : hhMemberList){
					if(!hhMember.getHhMemberId().equalsIgnoreCase(memberId) && relationStore.get(hhMember.getHhMemberId()) == null){
						Relationship relationWithMember = new Relationship();
						relationWithMember.setMemberId(memberId);
						relationWithMember.setMemberGender(gender);
						relationWithMember.setRelationWithMemberId(hhMember.getHhMemberId());
						relationWithMember.setRelation("");
						relationWithMember.setRelationCode("");
						rsList.add(relationWithMember);
					}
				}
			}
			relationStore.put(memberId, rsList);
			svcsResponse.setRelationShipList(rsList);
		} else{
			rsList = relationStore.get(memberId);
			// check if new members are added
			List<HouseholdMember> hhMemberList = applicant.getHhMemberList();
			for(HouseholdMember hhMember : hhMemberList){
				boolean newMember = true;
				for(Relationship rs : rsList){
					if(rs.getMemberId().equalsIgnoreCase(hhMember.getHhMemberId()) || rs.getRelationWithMemberId().equalsIgnoreCase(hhMember.getHhMemberId())){
						newMember = false;
						break;
					}
				}
				
				if(newMember){
					Relationship relationWithMember = new Relationship();
					relationWithMember.setMemberId(memberId);
					relationWithMember.setMemberGender(rsList.get(0).getMemberGender());
					relationWithMember.setRelationWithMemberId(hhMember.getHhMemberId());
					relationWithMember.setRelation("");
					relationWithMember.setRelationCode("");
					rsList.add(relationWithMember);
				}
			}
			svcsResponse.setRelationShipList(rsList);
		}
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/emp-health-insurance", 
    		method = RequestMethod.GET,  
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse getEmpolyeeHealthInsurance(@RequestParam(value="applicationId") String applicationId, @RequestParam(value="member-id") String memberId){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		EmployeeHealthInsurance empHealthInsurance = employeeHealthInsuranceStore.get(memberId);
		svcsResponse.setEmpHealthInsurance(empHealthInsurance);
		svcsResponse.setResponseCode(200);
		return svcsResponse;	
	}
	
	
	@RequestMapping(value = "/emp-health-insurance", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"}, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse setEmpolyeeHealthInsurance(@RequestBody EmployeeHealthInsurance empHealthInsurance){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		employeeHealthInsuranceStore.put(empHealthInsurance.getMemberId(), empHealthInsurance);
		svcsResponse.setResponseCode(200);
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/member-health-insurance", 
    		method = RequestMethod.GET,  
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse getMemberHealthInsurance(@RequestParam(value="applicationId") String applicationId, @RequestParam(value="member-id") String memberId){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		MemberHealthInsurance memberHealthInsurance = memberHealthInsuranceStore.get(memberId);
		svcsResponse.setMemberHealthInsurance(memberHealthInsurance);
		svcsResponse.setResponseCode(200);
		return svcsResponse;	
	}
	
	
	@RequestMapping(value = "/member-health-insurance", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"}, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse setMemberHealthInsurance(@RequestBody MemberHealthInsurance memberHealthInsurance){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		memberHealthInsuranceStore.put(memberHealthInsurance.getMemberId(), memberHealthInsurance);
		svcsResponse.setResponseCode(200);
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/insurance/summary", 
    		method = RequestMethod.GET, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse getInsuracneSummary(@RequestParam(value="applicationId") String applicationId){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		
		List<EmployeeHealthInsurance> empHealthInsuranceList = new ArrayList<EmployeeHealthInsurance>();
		List<MemberHealthInsurance> memberHealthInsuranceList = new ArrayList<MemberHealthInsurance>();
		
		for(Entry<String, EmployeeHealthInsurance> empHealthInsuranceEntry : employeeHealthInsuranceStore.entrySet()){
			EmployeeHealthInsurance empHealthInsurance = empHealthInsuranceEntry.getValue();
			if(empHealthInsurance.getApplicationId().equalsIgnoreCase(applicationId)){
				empHealthInsuranceList.add(empHealthInsurance);
			}
		}
		
		for(Entry<String, MemberHealthInsurance> memberHealthInsuranceEntry : memberHealthInsuranceStore.entrySet()){
			MemberHealthInsurance memberHealthInsurance = memberHealthInsuranceEntry.getValue();
			if(memberHealthInsurance.getApplicationId().equalsIgnoreCase(applicationId)){
				memberHealthInsuranceList.add(memberHealthInsurance);
			}
		}
		
		svcsResponse.setEmpHealthInsuranceList(empHealthInsuranceList);
		svcsResponse.setMemberHealthInsuranceList(memberHealthInsuranceList);
		
		return svcsResponse;
	}
	
	@RequestMapping(value = "/clear", 
    		method = RequestMethod.GET, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse clean(){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		appStore.clear();
		profileStore.clear();
		incomeStore.clear();
		relationStore.clear();
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/delete", 
    		method = RequestMethod.GET, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse deleteUser(@RequestParam(value="userName", required = true) String userName){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		profileStore.remove(userName);
		return svcsResponse;	
	}
	
	@RequestMapping(value="/upload-file", method=RequestMethod.POST)
    public String handleFileUpload(
    		@RequestParam("applicationId") String applicationId,
    		@RequestParam("fileUploadMember") String fileUploadMember, 
    		@RequestParam("documentType") String documentType,
            @RequestParam("file") MultipartFile file,
            @RequestParam("redirectUrl") String redirectUrl){
		
		List<FileUpload> fileList = fileStore.get(applicationId);
		if(fileList == null)
			fileList = new ArrayList<FileUpload>();
		
		FileUpload fileUpload = new FileUpload();
		fileUpload.setFileName(file.getOriginalFilename());
		fileUpload.setDocumentType(documentType);
		fileUpload.setFileUploadMember(fileUploadMember);
		
		fileList.add(fileUpload);
		
		fileStore.put(applicationId, fileList);
		
	    return "redirect:" + redirectUrl;
	}
	
	@RequestMapping(value="/files", method=RequestMethod.GET)
	@ResponseBody
	public ApplicationServiceResponse getFiles(@RequestParam("applicationId") String applicationId){
		ApplicationServiceResponse response = new ApplicationServiceResponse();
		response.setFileList(fileStore.get(applicationId));
		
		return response;
	}
	
	@RequestMapping(value="/remove-file", method=RequestMethod.GET)
	@ResponseBody
	public ApplicationServiceResponse removeFile(@RequestParam("applicationId") String applicationId, @RequestParam("fileName") String fileName){
		ApplicationServiceResponse response = new ApplicationServiceResponse();
		
		List<FileUpload> fileList = fileStore.get(applicationId);
		FileUpload toBeRemovedFile = null;
		if(fileList != null){
			for(FileUpload file : fileList){
				if(file.getFileName().equalsIgnoreCase(fileName)){
					toBeRemovedFile = file;
					break;
				}
			}
		}
		
		if(toBeRemovedFile != null)
			fileList.remove(toBeRemovedFile);
		
		return response;
	}

}
