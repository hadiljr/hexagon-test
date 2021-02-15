package com.hadil.interfaces.services;

import java.util.Set;

/**
 * 
 * @author Hadil
 *
 * @param <M> Model
 * @param <CM> Creation Model
 * @param <UM> Update Model
 */
public interface IServiceBase<M,CM,UM> {

	Set<M> recoverAll();
	
	M recoverById(int id);
	
	void delete(int id);
	
	int insert(CM creationModel);
	
	M update(int id, UM updateModel);
	
}
