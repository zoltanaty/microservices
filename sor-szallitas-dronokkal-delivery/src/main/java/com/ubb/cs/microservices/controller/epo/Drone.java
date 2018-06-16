package com.ubb.cs.microservices.controller.epo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Drone {
    private int id;
	private String modelName;
	private String modelType;
	private String capacity;
}
