package course.enumtype;

public enum CourseProgressType {
	
	진행예정("TOBE"), 
	진행중("PROGRESS"),
	진행완료("FINISHED"),
	진행취소("CANCELED");
	
	private String  courseProgress;
	
	CourseProgressType(String courseProgress) {
		this.courseProgress = courseProgress;
	}
	
	public String getCourseProgress() {
		return courseProgress;
	}
}
