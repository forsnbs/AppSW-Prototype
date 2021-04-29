package attachedfile.enumtype;

public enum AttachedFileCategoryType {
	
	커리큘럼("CURRICULUM"),
	개인정보동의서("PERSONAL_INFO_AGREEMENT"),
	면접평가서("INTERVIEW_EVAL");

	private String attachedFileCateory;
	
	private AttachedFileCategoryType(String attachedFileCateory) {
		this.attachedFileCateory = attachedFileCateory;
	}
	
	public String getAttachedFileCateory() {
		return attachedFileCateory;
	}
}
