package resources;

public enum API_Resources {
	
	adds_this_location_to("/maps/api/place/add/json"),
	gets_this_location_from("/maps/api/place/get/json"),
	deletes_this_location_from("/maps/api/place/delete/json");
	private String resource;
	
	API_Resources(String resource) {
		this.resource = resource;
	}
	
	public String getResourse( ) {
		return resource;
	}
}
