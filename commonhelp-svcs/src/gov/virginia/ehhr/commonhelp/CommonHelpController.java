package gov.virginia.ehhr.commonhelp;

import gov.virginia.ehhr.commonhelp.domain.Applicant;
import gov.virginia.ehhr.commonhelp.domain.ApplicationServiceResponse;
import gov.virginia.ehhr.commonhelp.domain.HouseholdMember;
import gov.virginia.ehhr.commonhelp.domain.Income;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
			appId = "APP"+randomGenerator.nextInt(10000);
			String applicantId = "A"+randomGenerator.nextInt(10000);
			applicant.setApplicationId(appId);
			applicant.setApplicantId(applicantId);
			store.put(appId, applicant);
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
	public ApplicationServiceResponse getIncome(@RequestParam(value="member-id") String memberId, @RequestParam(value="income-type") String incomeType){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		
		for (Map.Entry<String, Income> entry : incomeStore.entrySet()) {
			Income income = entry.getValue();
			if(income.getMemberId().equalsIgnoreCase(memberId) && income.getIncomeType().equalsIgnoreCase(incomeType)){
				svcsResponse.setIncome(income); 
				break;
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
	

}
