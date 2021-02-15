package com.hadil.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleModel {

	private int id;
	
	private String name;
	
	private String desc;
	
	private String plate;
	
	private int vehicleTypeId;
	
	private String vehicleTypeName;
}
