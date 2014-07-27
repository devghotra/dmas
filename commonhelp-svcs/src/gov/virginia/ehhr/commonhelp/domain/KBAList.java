package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;
import java.util.List;

public class KBAList implements Serializable {

	private static final long serialVersionUID = 5742292862535696763L;
	
	private List<UserProfile> kba;

	public List<UserProfile> getKba() {
		return kba;
	}

	public void setKba(List<UserProfile> kba) {
		this.kba = kba;
	}
	
	

}
