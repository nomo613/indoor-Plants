package dto;

import java.util.Date;

public class Growth {
	
	private Integer id;
	private Date observationAt;
	private String watering;
	private String record;
	
	public Growth(Integer id, Date observationAt, String watering, String record) {
		super();
		this.id = id;
		this.observationAt = observationAt;
		this.watering = watering;
		this.record = record;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getObservationAt() {
		return observationAt;
	}
	public void setObservationAt(Date observationAt) {
		this.observationAt = observationAt;
	}
	public String getWatering() {
		return watering;
	}
	public void setWatering(String watering) {
		this.watering = watering;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public void add(Growth growth) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	

}