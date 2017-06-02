package entity;

public class OnekeyResultRecord {
	private String recordId;
	private String userId2;
	private String resultMark;//结果总分数
    private Double lng;
    private Double lat;
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getUserId2() {
		return userId2;
	}
	public void setUserId2(String userId2) {
		this.userId2 = userId2;
	}
	public String getResultMark() {
		return resultMark;
	}
	public void setResultMark(String resultMark) {
		this.resultMark = resultMark;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}

    
}
