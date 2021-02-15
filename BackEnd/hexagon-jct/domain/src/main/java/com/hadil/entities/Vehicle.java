package com.hadil.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@Column(name = "description")
	private String desc;
	
	@Column(nullable=false)
	@NotBlank(message = "Plate is mandatory")
	private String plate;
	
	@ManyToOne(targetEntity=VehicleType.class, fetch = FetchType.LAZY)
	@NotNull(message="Type is mandatory")
	@JoinColumn(name="fk_type")
	private VehicleType type;
	

}
