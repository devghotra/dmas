package gov.virginia.ehhr.commonhelp;

import gov.virginia.ehhr.commonhelp.domain.Applicant;
import gov.virginia.ehhr.commonhelp.domain.ApplicationServiceResponse;

import java.util.HashMap;
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
@RequestMapping("/application")
public class CommonHelpController {
	
	static Logger LOGGER = LoggerFactory.getLogger(CommonHelpController.class);
	HashMap<String, Applicant> store = new HashMap<String, Applicant>();
	
	@RequestMapping(value = "/about-you", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"}, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse setAboutYouData(@RequestBody Applicant applicant){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		String appId = applicant.getApplicationId();
		if(appId == null || appId.isEmpty()){
			Random randomGenerator = new Random();
			appId = "A"+randomGenerator.nextInt(10000);
			applicant.setApplicationId(appId);
			store.put(appId, applicant);
		} else{
			CommonHelpUtil.merge(store.get(appId), applicant);
		}
		svcsResponse.setApplicationId(appId);
		svcsResponse.setResponseCode(200);
		return svcsResponse;	
	}
	
	@RequestMapping(value = "/about-you", 
    		method = RequestMethod.GET, 
    		produces = {"application/json"})
	@ResponseBody
	public ApplicationServiceResponse getAboutYouData(@RequestParam(value="app-id") String appId){
		ApplicationServiceResponse svcsResponse = new ApplicationServiceResponse();
		svcsResponse.setApplicant(store.get(appId));
		return svcsResponse;	
	}

}
