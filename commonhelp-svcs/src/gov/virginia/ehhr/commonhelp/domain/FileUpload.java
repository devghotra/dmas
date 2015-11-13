package gov.virginia.ehhr.commonhelp.domain;

public class FileUpload {
	
	private String fileUploadMember;
	private String fileName;
	private String documentType;
	
	public String getFileUploadMember() {
		return fileUploadMember;
	}
	public void setFileUploadMember(String fileUploadMember) {
		this.fileUploadMember = fileUploadMember;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

}
