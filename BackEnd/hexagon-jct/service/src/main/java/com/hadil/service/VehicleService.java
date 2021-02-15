package com.hadil.service;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hadil.entities.Vehicle;
import com.hadil.interfaces.mappers.IVehicleMapper;
import com.hadil.interfaces.repositories.IVehicleRepository;
import com.hadil.interfaces.services.IVehicleService;
import com.hadil.models.CreateVehicleModel;
import com.hadil.models.UpdateVehicleModel;
import com.hadil.models.VehicleModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleService implements IVehicleService{

	private final IVehicleRepository repository;
	private final IVehicleMapper mapper;
	//private final IPlateValidator plateValidator;
	
	@Override
	@Transactional
	public Set<VehicleModel> recoverAll() {
		return mapper.SetEntityToSetModel(repository.findAll());
	}

	@Override
	@Transactional
	public VehicleModel recoverById(int id) {
		return mapper.EntityToModel(repository.findByIdOrFail(id));
	}

	@Override
	@Transactional
	public void delete(int id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public int insert(CreateVehicleModel creationModel) {
		//plateValidator.matchesPlatePattern(creationModel.getPlate());
		Vehicle entity = repository.save(mapper.CreateModelToEntity(creationModel));
		return entity.getId();
	}

	@Override
	@Transactional
	public VehicleModel update(int id, UpdateVehicleModel updateModel) {
		//plateValidator.matchesPlatePattern(updateModel.getPlate());
		Vehicle entity = repository.save(mapper.UpdateModelToEntity(updateModel));
		return mapper.EntityToModel(entity);
	}	

}
