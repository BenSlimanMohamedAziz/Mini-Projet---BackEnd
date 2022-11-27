package com.aziz.animals.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.aziz.animals.entities.Groupe;

@RepositoryRestResource(path = "grp")
@CrossOrigin(origins = "http://localhost:4200/")
@Repository
public interface GrpRepository extends JpaRepository<Groupe, Long>{

}