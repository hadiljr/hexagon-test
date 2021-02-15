package com.hadil.api.rest.controllers;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

import org.apache.commons.lang3.Validate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.hadil.interfaces.services.IVehicleTypeService;
import com.hadil.models.CreateVehicleTypeModel;
import com.hadil.models.UpdateVehicleTypeModel;
import com.hadil.models.VehicleTypeModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import static com.hadil.api.rest.controllers.VehicleTypeController.BASE_URI;

@RestController
@RequestMapping(BASE_URI)
@Api(value = "API Vehicles Hexagon Java/Cloud Test", produces = "application/json")
@RequiredArgsConstructor
public class VehicleTypeController {

	protected static final String BASE_URI = "/api/v1/vehicletype";

	private final IVehicleTypeService vehicleTypeService;

	@ApiOperation(value = "Add new vehicle type", produces = "application/json")
	@PostMapping("/")
	ResponseEntity<?> createVehicleType(UriComponentsBuilder uriComponentsBuilder, @RequestBody CreateVehicleTypeModel create) {

		//Validate.notNull(name, "Input parameter NAME is mandatory");
		int result = vehicleTypeService.insert(create);
		UriComponents uriComponents = uriComponentsBuilder.path(BASE_URI + "/{vehicleTypeId}")
				.buildAndExpand(result);

		return created(uriComponents.toUri()).body(vehicleTypeService.recoverById(result));
	}

	@ApiOperation(value = "Update vehicle type or add new vehicle type", produces = "application/json")
	@PutMapping("/{vehicleTypeId}")
	ResponseEntity<?> putVehicleTypeById(UriComponentsBuilder uriComponentsBuilder, @PathVariable int vehicleTypeId,
			@RequestBody UpdateVehicleTypeModel update) {

		Validate.notNull(vehicleTypeId, "Missing mandatory input parameter: vehicleTypeId");
		Validate.notNull(update.getName(), "Input parameter NAME is mandatory");

	
		return ok().body(vehicleTypeService.update(vehicleTypeId,update));
		

	}

	@ApiOperation(value = "Get vehicle type", produces = "application/json")
	@GetMapping("/{vehicleTypeId}")
	ResponseEntity<?> getVehicleTypeById(UriComponentsBuilder uriComponentsBuilder, @PathVariable int vehicleTypeId) {

		Validate.notNull(vehicleTypeId, "Missing mandatory input parameter: vehicleTypeId");

		VehicleTypeModel vehicleType = vehicleTypeService.recoverById(vehicleTypeId);
		return ok().body(vehicleType);

	}

	@ApiOperation(value = "Get all vehicle type", produces = "application/json")
	@GetMapping("/")
	ResponseEntity<?> getAllVehicleType(UriComponentsBuilder uriComponentsBuilder) {
		return ok().body(vehicleTypeService.recoverAll());
	}

	@ApiOperation(value = "Delete vehicle type", produces = "application/json")
	@DeleteMapping("/{vehicleTypeId}")
	ResponseEntity<?> deleteVehicleTypeById(UriComponentsBuilder uriComponentsBuilder,
			@PathVariable int vehicleTypeId) {

		Validate.notNull(vehicleTypeId, "Missing mandatory input parameter: vehicleTypeId");

		vehicleTypeService.delete(vehicleTypeId);
		return ok().body("Vehicle Type deleted");

	}

}
