package com.hadil.models;

import lombok.Data;

@Data
public class UpdateVehicleModel {

	private final int id;
	
	private final String name;
	
	private final String desc;
	
	private final String plate;
	
	private final int vehicleTypeId;
	
}
