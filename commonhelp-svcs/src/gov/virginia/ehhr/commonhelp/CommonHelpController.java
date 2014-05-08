package gov.virginia.ehhr.commonhelp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/application")
public class CommonHelpController {
	
	static Logger LOGGER = LoggerFactory.getLogger(CommonHelpController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public void test(){
		LOGGER.error("in test method");
	}

}
