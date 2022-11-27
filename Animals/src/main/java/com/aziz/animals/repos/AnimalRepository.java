package com.aziz.animals.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.aziz.animals.entities.Groupe;
import com.aziz.animals.entities.animal;
@RepositoryRestResource(path="rest")
public interface AnimalRepository extends JpaRepository<animal, Long> {
	List<animal> findByNomAnimal(String nom);
	 List<animal> findByNomAnimalContains(String nom);
	 @Query("select a from animal a where a.groupe = ?1")
	 List<animal> findByGroupe (Groupe groupe);
	 List<animal> findByGroupeIdGrp(Long id);
	 List<animal> findByOrderByNomAnimalAsc();
	 @Query("select a from animal a order by a.nomAnimal ASC")
	 List<animal> trierAnimalsNoms();
}