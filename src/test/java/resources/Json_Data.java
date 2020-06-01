package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Add_Location;
import pojo.Delete_Location;
import pojo.Lat_and_Lng;

public class Json_Data {

	public Add_Location addPlacePayLoad(double lat, double lng, String address) {
		Add_Location al = new Add_Location();
		al.setAccuracy(50);
		al.setAddress(address);
		al.setLanguage("Portuguese");
		al.setName("Fantasy Land");
		al.setPhone_number("+00 (00) 5555-5555");
		al.setWebsite("https://github.com/leorrib");
		List<String> list = new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		al.setTypes(list);
		Lat_and_Lng loc = new Lat_and_Lng();
		loc.setLat(lat);
		loc.setLng(lng);
		al.setLocation(loc);
		return al;
	}
	
	public Delete_Location delete_Location(String place_id) {
		Delete_Location dl = new Delete_Location();
		dl.setPlace_id(place_id);
		return dl;
	}
	
}
