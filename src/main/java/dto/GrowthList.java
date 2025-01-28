package dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class GrowthList {

    private Integer id;
    private Date observationAt;
    private String watering;
    private String record;
	

	}


