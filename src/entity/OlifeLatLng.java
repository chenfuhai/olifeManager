package entity;
/**
 * 经纬度类
 * @author wuguofei
 *
 */

public class OlifeLatLng {
	private Double lng;// 经度

	private Double lat; // 纬度

	public OlifeLatLng(Double lat, Double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}
}
