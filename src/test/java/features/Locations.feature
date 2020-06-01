Feature: Creating, validating and deleting a location

@Create_Location @Create_and_Validate @Create_and_Delete
Scenario: Creating a new location
	Given the location with latidude -30.1 , longitude 20.3 and address "205 Fantasy Road"
	When a user "adds_this_location_to" the map
	Then "status" "OK" on response confirms the action was performed

@Get_Location @Create_and_Validate
Scenario: Validating if the location was correctly created
	Given an already created location
	When a user "gets_this_location_from" the map
	Then user cheks if this location has address "205 Fantasy Road"

@Delete_Location @Create_and_Delete
Scenario: Deletes location
	Given an already created location
	When a user "deletes_this_location_from" the map
	Then "status" "OK" on response confirms the action was performed 