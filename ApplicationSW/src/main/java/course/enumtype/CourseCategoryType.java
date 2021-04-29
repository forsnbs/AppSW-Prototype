package course.enumtype;

public enum CourseCategoryType {
	
	국가기간("NATIONAL"), 
	혁신성장("INNOVATION"), 
	K디지털("K_DIGITAL"), 
	싹SSAC("SSAC");
	
	private String courseCategory;
	
	private CourseCategoryType(String courseCategory) {
		this.courseCategory = courseCategory;
	}
	
	public String courseCategory() {
		return courseCategory;
	}
}
