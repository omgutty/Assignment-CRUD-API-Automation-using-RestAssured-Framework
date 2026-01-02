package enums;

public enum APIEndPoints {
	
	CREATE_BOOKING("/booking"),
	UPDATE_BOOKING("/booking/{id}"),
	DELETE_BOOKING("/booking/{id}"),
	CREAT_OBJECT("/objects"),
	UPDATE_OBJECT("/objects/{id}");
	
	
	
	
	
	private final String path;
	
	APIEndPoints (String path ){
		this.path= path;
	}
	
	public String getpath() {
		return path;
	}
	
	
	

}
