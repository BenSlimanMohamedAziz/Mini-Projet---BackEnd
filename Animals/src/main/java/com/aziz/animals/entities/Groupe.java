package com.aziz.animals.entities;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Entity
public class Groupe {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idGrp;
private String nomGrp;
private String descriptionGrp;
@JsonIgnore
@OneToMany(mappedBy = "groupe")
private List<animal> animals;
public Groupe() {}
public Groupe(String nomGrp, String descriptionGrp, List<animal> animals) 
{
super();
this.nomGrp = nomGrp;
this.descriptionGrp = descriptionGrp;
this.animals = animals;
}
public Long getIdGrp() {
return idGrp;
}
public void setIdGrp(Long idGrp) {
this.idGrp = idGrp;
}
public String getNomGrp() {
return nomGrp;
}
public void setNomGrp(String nomGrp) {
this.nomGrp = nomGrp;
}
public String getDescriptionGrp() {
return descriptionGrp;
}
public void setDescriptionGrp(String descriptionGrp) {
this.descriptionGrp = descriptionGrp;
}
public List<animal> getAnimals() {
return animals;
}
public void setAnimals(List<animal> animals) {
this.animals = animals;
}
@Override
public String toString() {
	return "Groupe [idGrp=" + idGrp + ", nomGrp=" + nomGrp + ", descriptionGrp=" + descriptionGrp + "]";
}
}