package com.hadil.infra.data.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.hadil.entities.VehicleType;
import com.hadil.interfaces.mappers.IVehicleTypeMapper;
import com.hadil.models.CreateVehicleTypeModel;
import com.hadil.models.UpdateVehicleTypeModel;
import com.hadil.models.VehicleTypeModel;

@Component
public class VehicleTypeMapper implements IVehicleTypeMapper{

	@Override
	public VehicleTypeModel EntityToModel(VehicleType vehicleType) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(vehicleType, VehicleTypeModel.class);
	}

	@Override
	public VehicleType ModelToEntity(VehicleTypeModel vehicleTypeModel) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(vehicleTypeModel, VehicleType.class);
	}

	@Override
	public VehicleType CreateModelToEntity(CreateVehicleTypeModel createVehicleTypeModel) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(createVehicleTypeModel, VehicleType.class);
	}

	@Override
	public VehicleType UpdateModelToEntity(UpdateVehicleTypeModel updateVehicleTypeModel) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(updateVehicleTypeModel, VehicleType.class);
	}

	@Override
	public Set<VehicleTypeModel> SetEntityToSetModel(Set<VehicleType> setEntity) {
		ModelMapper mapper = new ModelMapper();
		return setEntity
				.stream()
				.map(elem -> mapper.map(elem, VehicleTypeModel.class))
				.collect(Collectors.toSet());
	}

}
