package gov.virginia.ehhr.commonhelp;

import gov.virginia.ehhr.commonhelp.domain.Applicant;
import gov.virginia.ehhr.commonhelp.domain.ApplicationServiceResponse;
import gov.virginia.ehhr.commonhelp.domain.HouseholdMember;
import gov.virginia.ehhr.commonhelp.domain.Income;
import gov.virginia.ehhr.commonhelp.domain.KnowledgeBaseAuthQA;
import gov.virginia.ehhr.commonhelp.domain.UserProfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

@Controller
@RequestMapping("/medicaid/applicant")
public class CommonHelpController {
	
	static Logger LOGGER = LoggerFactory.getLogger(CommonHelpController.class);
	HashMap<String, Applicant> store = new HashMap<String, Applicant>();
	LinkedHashMap<String, Income> incomeStore = new LinkedHashMap<String, Income>();
	HashMap<String, UserProfile> profileStore = new HashMap<String, UserProfile>();
	
	
	@RequestMapping(value = "/sign-up-basic", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"}, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse signUpBasic(@RequestBody UserProfile userProfile){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		String userName = userProfile.getUserName();
		
		if(profileStore.get(userName) == null){	
			if(userName.equalsIgnoreCase("kevinsmith") || userName.equalsIgnoreCase("chrisbell") || userName.equalsIgnoreCase("johndoe")){
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
	
	@RequestMapping(value = "/basic-info", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"}, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse setAboutYouData(@RequestBody Applicant applicant){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		String appId = applicant.getApplicationId();
		if(appId == null || appId.isEmpty()){
			Random randomGenerator = new Random();
			appId = "A"+randomGenerator.nextInt(10000000);
			String applicantId = "A"+randomGenerator.nextInt(10000);
			applicant.setApplicationId(appId);
			applicant.setApplicantId(applicantId);
			store.put(appId, applicant);
			
			String userName = applicant.getUserName();
			profileStore.get(userName).setApplicationId(appId);
			
		} else{
			CommonHelpUtil.merge(store.get(appId), applicant);
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
		svcsResponse.setApplicant(store.get(appId));
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
		
			
		Applicant applicant = store.get(appId);
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
		
		Applicant applicant = store.get(appId);
		
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
	
	@RequestMapping(value = "/application", 
    		method = RequestMethod.GET, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse getApplicationId(@RequestParam(value="userName", required = true) String userName){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		svcsResponse.setApplicationId(profileStore.get(userName).getApplicationId());
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
	

}
