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
	
	public Date getObservationAt() {
		return observationAt;
	}
	
	public String getWatering() {
		return watering;
	}

	public String getRecord() {
		return record;
	}
	
	

}