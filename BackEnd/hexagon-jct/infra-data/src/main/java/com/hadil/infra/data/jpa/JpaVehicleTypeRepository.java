package com.hadil.infra.data.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hadil.entities.VehicleType;
import com.hadil.interfaces.repositories.IVehicleTypeRepository;

public interface JpaVehicleTypeRepository extends PagingAndSortingRepository<VehicleType, Integer>, IVehicleTypeRepository{

}
