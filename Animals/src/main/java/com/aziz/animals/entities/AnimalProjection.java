package com.aziz.animals.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomAnim", types = { animal.class })
public interface AnimalProjection {
public String getNomAnimal();
}