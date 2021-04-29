package person.enumtype;

public enum FinalEduCategoryType {
	HIGHSCHOOL("고등학교"), 
	ASSOCIATE("전문학사"), 
	BACHELOR("학사"), 
	GRADUATE("석사"), 
	DOCTOR("박사");
	
	private String finalEduCategory;
	
	FinalEduCategoryType(String finalEduCategory) {
		this.finalEduCategory = finalEduCategory;
	}
	
	public String getFinalEduCategory() {
		return finalEduCategory;
	}
}
