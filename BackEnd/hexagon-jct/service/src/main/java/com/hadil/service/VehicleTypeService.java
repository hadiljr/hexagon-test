package com.hadil.service;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hadil.entities.VehicleType;
import com.hadil.interfaces.mappers.IVehicleTypeMapper;
import com.hadil.interfaces.repositories.IVehicleTypeRepository;
import com.hadil.interfaces.services.IVehicleTypeService;
import com.hadil.models.CreateVehicleTypeModel;
import com.hadil.models.UpdateVehicleTypeModel;
import com.hadil.models.VehicleTypeModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleTypeService implements IVehicleTypeService {

	private final IVehicleTypeRepository repository;

	private final IVehicleTypeMapper mapper;

	@Override
	@Transactional
	public Set<VehicleTypeModel> recoverAll() {
		Set<VehicleType> res = repository.findAll();
		return mapper.SetEntityToSetModel(res);
	}

	@Override
	@Transactional
	public VehicleTypeModel recoverById(int id) {
		return mapper.EntityToModel(repository.findByIdOrFail(id));
	}

	@Override
	@Transactional
	public void delete(int id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public int insert(CreateVehicleTypeModel creationModel) {
		VehicleType entity = repository.save(mapper.CreateModelToEntity(creationModel));
		return entity.getId();
	}

	@Override
	@Transactional
	public VehicleTypeModel update(int id, UpdateVehicleTypeModel updateModel) {
		VehicleType entity = repository.save(mapper.UpdateModelToEntity(updateModel));
		return mapper.EntityToModel(entity);
	}

}
