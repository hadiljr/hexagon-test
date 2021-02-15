package com.hadil.infra.data.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.hadil.entities.Vehicle;
import com.hadil.entities.VehicleType;
import com.hadil.interfaces.mappers.IVehicleMapper;
import com.hadil.models.CreateVehicleModel;
import com.hadil.models.UpdateVehicleModel;
import com.hadil.models.VehicleModel;


@Component
public class VehicleMapper implements IVehicleMapper{
	
	@Override
	public VehicleModel EntityToModel(Vehicle entity) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(entity, VehicleModel.class);
	}

	@Override
	public Vehicle ModelToEntity(VehicleModel model) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(model, Vehicle.class);
	}

	@Override
	public Vehicle CreateModelToEntity(CreateVehicleModel createModel) {
		
		return new Vehicle(0,createModel.getName(),createModel.getDesc(),createModel.getPlate(),new VehicleType(createModel.getVehicleTypeId(),null,null,null));
		//mapper.addMappings(customMap);
//		return mapper.map(createModel, Vehicle.class);
	}

	@Override
	public Vehicle UpdateModelToEntity(UpdateVehicleModel updateModel) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(updateModel, Vehicle.class);
	}

	@Override
	public Set<VehicleModel> SetEntityToSetModel(Set<Vehicle> setEntity) {
		ModelMapper mapper = new ModelMapper();
		return setEntity
				.stream()
				.map(elem -> mapper.map(elem, VehicleModel.class))
				.collect(Collectors.toSet());
	}

}
