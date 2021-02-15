package com.hadil.models;

import lombok.Data;

@Data
public class CreateVehicleModel {
	
	private final String name;
	
	private final String desc;
	
	private final String plate;
	
	private final int vehicleTypeId;
	
	

}
