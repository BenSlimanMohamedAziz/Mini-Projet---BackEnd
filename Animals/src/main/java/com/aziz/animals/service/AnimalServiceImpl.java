package com.aziz.animals.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aziz.animals.entities.Groupe;
import com.aziz.animals.entities.animal;
import com.aziz.animals.repos.AnimalRepository;
@Service
public class AnimalServiceImpl implements AnimalService {
@Autowired
AnimalRepository animalRepository;
@Override
public animal saveAnimal(animal a) {
	return animalRepository.save(a);
	}
	@Override
	public animal updateAnimal(animal a) {
	return animalRepository.save(a);
	}
	@Override
	public void deleteAnimal(animal a) {
	animalRepository.delete(a);
	}
	 @Override
	public void deleteAnimalById(Long id) {
	animalRepository.deleteById(id);
	}
	@Override
	public animal getAnimal(Long id) {
	return animalRepository.findById(id).get();
	}
	@Override
	public List<animal> getAllAnimals() {
	return animalRepository.findAll();
	}
	@Override
	public Page<animal> getAllAnimalsParPage(int page, int size) {
		return animalRepository.findAll(PageRequest.of(page, size));

	}
	@Override
	public List<animal> findByNomAnimal(String nom) {
	return animalRepository.findByNomAnimal(nom);
	}
	@Override
	public List<animal> findByNomAnimalContains(String nom) {
	return animalRepository.findByNomAnimalContains(nom);
	}

	@Override
	public List<animal> findByGroupe(Groupe groupe) {
	return animalRepository.findByGroupe(groupe);
	}
	@Override
	public List<animal> findByGroupeIdGrp(Long id) {
	return animalRepository.findByGroupeIdGrp(id);
	}
	@Override
	public List<animal> findByOrderByNomAnimalAsc() {
	return animalRepository.findByOrderByNomAnimalAsc();
	}
	@Override
	public List<animal> trierAnimalsNoms() {
	return animalRepository.trierAnimalsNoms();
	}
}