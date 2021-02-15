package com.hadil.interfaces.validators;

public interface IPlateValidator {
	
	/**
	 * Check if plate is valid 
	 * @param plate
	 * @throws IllegalArgumentException if plate is not valid
	 * @exception  
	 */
	void matchesPlatePattern(String plate) throws IllegalArgumentException;

}
