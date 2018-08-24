package ajax0823;

public class LatLngVO {
	private String title;
	private double lat,lng;
	
	public LatLngVO(String title, double lat, double lng) {
		super();
		this.title = title;
		this.lat = lat;
		this.lng = lng;
	}
	public LatLngVO() {
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
}
