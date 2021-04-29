package course.enumtype;

public enum CourseLocationType {
	
	남부("서울특별시 서초구 효령로 335"), 
	서초("서울특별시 서초구 서초대로46길 42"), 
	영등포("서울특별시 영등포구 선유로9길 30 106동 싹 영등포캠퍼스");
	
	private String locationAddress;
	
	CourseLocationType(String locationAddress) {
		this.locationAddress = locationAddress;
	}
	
	public String getCourseLocation() {
		return locationAddress;
	}
}
