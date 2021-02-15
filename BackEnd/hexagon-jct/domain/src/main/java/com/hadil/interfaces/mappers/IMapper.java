package com.hadil.interfaces.mappers;

import java.util.Set;

/**
 * 
 * @author Hadil
 *
 * @param <E> Entity
 * @param <M> Model
 * @param <CM> CreateModel
 * @param <UM> UpdateModel
 */
public interface IMapper<E,M,CM,UM> {

	M EntityToModel(E entity);
	E ModelToEntity(M model);
	E CreateModelToEntity(CM createModel);
	E UpdateModelToEntity(UM updateModel);
	Set<M> SetEntityToSetModel(Set<E> setEntity);
}
