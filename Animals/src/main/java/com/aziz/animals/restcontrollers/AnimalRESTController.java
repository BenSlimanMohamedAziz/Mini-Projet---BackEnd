package com.aziz.animals.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.animals.entities.animal;
import com.aziz.animals.service.AnimalService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class AnimalRESTController {
@Autowired
AnimalService animalService;
@RequestMapping(path="all",method = RequestMethod.GET)
public List<animal> getAllAnimals() {
return animalService.getAllAnimals();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public animal getAnimalById(@PathVariable("id") Long id) {
return animalService.getAnimal(id);
 }
@RequestMapping(method = RequestMethod.POST)
public animal createAnimal(@RequestBody animal animal) {
return animalService.saveAnimal(animal);
}
@RequestMapping(method = RequestMethod.PUT)
public animal updateAnimal(@RequestBody animal animal) {
return animalService.updateAnimal(animal);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteAnimal(@PathVariable("id") Long id)
{
    animalService.deleteAnimalById(id);
}
@RequestMapping(value="/animalsgrp/{idGrp}",method = RequestMethod.GET)
public List<animal> getAnimalsByGrpId(@PathVariable("idGrp") Long idGrp) {
return animalService.findByGroupeIdGrp(idGrp);
}
@RequestMapping(value="/animalsByName/{nom}",method = RequestMethod.GET)
public List<animal> findByNomAnimalContains(@PathVariable("nom") String nom) {
return animalService.findByNomAnimalContains(nom);
}

}
