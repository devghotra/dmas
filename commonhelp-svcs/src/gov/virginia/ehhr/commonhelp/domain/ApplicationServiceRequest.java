package gov.virginia.ehhr.commonhelp.domain;

import java.util.List;

public class ApplicationServiceRequest {
	
	private List<UserProfile> userProfileList;

	public List<UserProfile> getUserProfileList() {
		return userProfileList;
	}

	public void setUserProfileList(List<UserProfile> userProfileList) {
		this.userProfileList = userProfileList;
	}

}
