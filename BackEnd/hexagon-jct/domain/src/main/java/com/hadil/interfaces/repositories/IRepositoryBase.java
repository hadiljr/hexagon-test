package com.hadil.interfaces.repositories;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

public interface IRepositoryBase<E> {

	E save(E entity);
	
	Optional<E> findById(int id);
	
	default E findByIdOrFail(int id) {
		return findById(id).orElseThrow(() -> new NoSuchElementException(String.format("Id %d not found.",id)));
	}
	
	Set<E> findAll();
	
	void deleteById(int id);	
	
	void deleteAll();
	
	
	
	
}
