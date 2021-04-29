package course.enumtype;

public enum CourseClassroomType {
	
	CLASSROOM1("1강의실"),
	CLASSROOM2("2강의실"),
	CLASSROOM3("3강의실"),
	CLASSROOM4("4강의실"),
	CLASSROOM5("5강의실");
	
	private String courseRoom;

	private CourseClassroomType(String courseRoom) {
		this.courseRoom = courseRoom;
	}

	public String getCourseRoom() {
		return courseRoom;
	}

}
