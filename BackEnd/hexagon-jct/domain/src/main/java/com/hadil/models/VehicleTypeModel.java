package com.hadil.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleTypeModel {

	private  int id;
	
	private  String name;
	
	private  String desc;
}
