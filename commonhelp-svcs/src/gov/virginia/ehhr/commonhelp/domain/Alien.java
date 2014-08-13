package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;

public class Alien implements Serializable{
	
	private static final long serialVersionUID = 37489763117697991L;
	
	private String alienNumber;
	private String alienStatus;
	private String documentType;
	private String dateOfEntry;
	
	public String getAlienNumber() {
		return alienNumber;
	}
	public void setAlienNumber(String alienNumber) {
		this.alienNumber = alienNumber;
	}
	public String getAlienStatus() {
		return alienStatus;
	}
	public void setAlienStatus(String alienStatus) {
		this.alienStatus = alienStatus;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDateOfEntry() {
		return dateOfEntry;
	}
	public void setDateOfEntry(String dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}
	
	
}
