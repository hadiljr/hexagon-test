package com.hadil.infra.data.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hadil.entities.Vehicle;
import com.hadil.interfaces.repositories.IVehicleRepository;

public interface JpaVehicleRepository extends PagingAndSortingRepository<Vehicle, Integer>, IVehicleRepository{

}
