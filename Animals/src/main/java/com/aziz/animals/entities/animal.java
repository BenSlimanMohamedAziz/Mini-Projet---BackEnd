package com.aziz.animals.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class animal {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idAnimal;

@NotNull
@Size (min = 4,max = 15)
private String nomAnimal;

public Groupe getGroupe() {
	return groupe;
}
public void setGroupe(Groupe groupe) {
	this.groupe = groupe;
}

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateAjout;

@ManyToOne
private Groupe groupe;
public animal() {
super();
}
public animal(String nomAnimal, Date dateAjout) {
super();
this.nomAnimal = nomAnimal;
this.dateAjout = dateAjout;
}
public Long getIdAnimal() {
return idAnimal;
}
public void setIdAnimal(Long idAnimal) {
this.idAnimal = idAnimal;
}
public String getNomAnimal() {
return nomAnimal;
}
public void setNomAnimal(String nomAnimal) {
this.nomAnimal = nomAnimal;
}

public Date getDateAjout() {
return dateAjout;
}
public void setDateAjout(Date dateAjout) {
this.dateAjout = dateAjout;
}
@Override
public String toString() {
	return "animal [idAnimal=" + idAnimal + ", nomAnimal=" + nomAnimal + ", dateAjout=" + dateAjout + ", groupe="
			+ groupe + "]";
}

}
