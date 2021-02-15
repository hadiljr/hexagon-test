package com.hadil.validators.plate;

import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

import com.hadil.interfaces.validators.IPlateValidator;

@Component
public class BrazilPlateValidator implements IPlateValidator {

	/**
	 * @inheritDoc
	 */
	@Override
	public void matchesPlatePattern(String plate) {

		/**
		 * O ideal seria conectar em uma API para ver se a placa existe. Mas para o bem
		 * da simplicidade, escolhi validar com regex. Como existe a questão das placas
		 * antigas e as novas(mercosul), utilizei o regex do artigo
		 * https://ricardo.coelho.eti.br/regex-mercosul/ Uma forma de adicionar uma
		 * regra de negocio a mais no sistema.
		 */
		Validate.matchesPattern(plate, "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}", "Invalid plate on Brazil and Mercosul",
				plate);

	}

}
