package com.hadil.api.rest.controllers;

import static com.hadil.api.rest.controllers.VehicleController.BASE_URI;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

import java.util.Arrays;

import org.apache.commons.lang3.Validate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.hadil.interfaces.services.IVehicleService;
import com.hadil.models.CreateVehicleModel;
import com.hadil.models.UpdateVehicleModel;
import com.hadil.models.VehicleModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(BASE_URI)
@Api(value = "API Vehicles Hexagon Java/Cloud Test", produces = "application/json")
@RequiredArgsConstructor
public class VehicleController {

	protected static final String BASE_URI = "/api/v1/vehicle";

	private final IVehicleService vehicleService;

	@ApiOperation(value = "Add new vehicle", produces = "application/json")
	@PostMapping("/")
	ResponseEntity<?> createVehicle(UriComponentsBuilder uriComponentsBuilder, @RequestBody CreateVehicleModel create) {

		Validate.noNullElements(Arrays.asList(create.getVehicleTypeId(), create.getName(), create.getPlate()),
				"Invalid input parameter/-s: vehicleTypeId=%s, name=%s, plate=%s", create.getVehicleTypeId(), create.getName(), create.getPlate());
		int result = vehicleService.insert(create);
		UriComponents uriComponents = uriComponentsBuilder.path(BASE_URI + "/{vehicleId}")
				.buildAndExpand(result);

		return created(uriComponents.toUri()).body(vehicleService.recoverById(result));
	}

	@ApiOperation(value = "Update vehicle or add new vehicle", produces = "application/json")
	@PutMapping("/{vehicleId}")
	ResponseEntity<?> putVehicleById(UriComponentsBuilder uriComponentsBuilder, @PathVariable int vehicleId,
			@RequestBody UpdateVehicleModel update) {

		Validate.notNull(vehicleId, "Missing mandatory input parameter: vehicleId");

		Validate.noNullElements(Arrays.asList(update.getVehicleTypeId(), update.getName(), update.getPlate()),
				"Invalid input parameter/-s: vehicleTypeId=%s, name=%s, plate=%s",update.getVehicleTypeId(), update.getName(), update.getPlate());
	
		return ok().body(vehicleService.update(vehicleId,update));		
	}

	@ApiOperation(value = "Get vehicle", produces = "application/json")
	@GetMapping("/{vehicleId}")
	ResponseEntity<?> getVehicleById(UriComponentsBuilder uriComponentsBuilder, @PathVariable int vehicleId) {

		Validate.notNull(vehicleId, "Missing mandatory input parameter: vehicleId");

		VehicleModel vehicle = vehicleService.recoverById(vehicleId);
		return ok().body(vehicle);

	}

	@ApiOperation(value = "Get all vehicle type", produces = "application/json")
	@GetMapping("/")
	ResponseEntity<?> getAllVehicle(UriComponentsBuilder uriComponentsBuilder) {
		return ok().body(vehicleService.recoverAll());
	}

	@ApiOperation(value = "Delete vehicle", produces = "application/json")
	@DeleteMapping("/{vehicleId}")
	ResponseEntity<?> deleteVehicleById(UriComponentsBuilder uriComponentsBuilder, @PathVariable int vehicleId) {

		Validate.notNull(vehicleId, "Missing mandatory input parameter: vehicleId");

		vehicleService.delete(vehicleId);
		return ok().body("Vehicle deleted");

	}

}
