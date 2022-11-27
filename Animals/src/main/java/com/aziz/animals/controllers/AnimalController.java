package com.aziz.animals.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.aziz.animals.entities.Groupe;
import com.aziz.animals.entities.animal;
import com.aziz.animals.service.GrpService;
import com.aziz.animals.service.AnimalService;
@Controller
public class AnimalController {
@Autowired
AnimalService animalService;
@Autowired
GrpService grpService;


@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
List<Groupe> grps = grpService.findAll();
modelMap.addAttribute("groupes", grps);
modelMap.addAttribute("animal", new animal());
modelMap.addAttribute("mode", "new");
return "formAnimal";
}
@RequestMapping("/saveAnimal")
public String saveAnimal(ModelMap modelMap,@Valid animal animal,
BindingResult bindingResult)
{
	List<Groupe> grps = grpService.findAll();
	modelMap.addAttribute("groupes", grps);
System.out.println(animal);
if (bindingResult.hasErrors()) return "formAnimal";
animalService.saveAnimal(animal);
return "redirect:/ListeAnimaux";
}

@RequestMapping("/showCreateGrp")
public String showCreateGrp(ModelMap modelMap)
{
modelMap.addAttribute("groupes", new Groupe());
modelMap.addAttribute("mode", "new");
return "formGroupe";
}
@RequestMapping("/saveGroupe")
public String saveGroupe(@ModelAttribute("groupe") Groupe groupe,ModelMap modelMap) throws ParseException 
{
Groupe saveGroupe = grpService.saveGroupe(groupe);
return "redirect:/ListeGrp";
}


@RequestMapping("/ListeGrp")
public String ListeGrp(ModelMap modelMap)
{
List <Groupe> grps = grpService.findAll();
modelMap.addAttribute("groupes", grps);
return "ListeGrp";
}

@RequestMapping("/ListeAnimaux")
public String ListeAnimaux(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
	List<Groupe> grps = grpService.findAll();
	modelMap.addAttribute("groupes", grps);
Page<animal> anims = animalService.getAllAnimalsParPage(page, size);
modelMap.addAttribute("animals", anims);
 modelMap.addAttribute("pages", new int[anims.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "ListeAnimaux";
}


@RequestMapping("/supprimerAnimal")
public String supprimerAnimal(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
	animalService.deleteAnimalById(id);
Page<animal> anims = animalService.getAllAnimalsParPage(page, 
size);
modelMap.addAttribute("animals", anims);
modelMap.addAttribute("pages", new int[anims.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "ListeAnimaux";
}
@RequestMapping("/supprimerGroupe")
public String supprimerGroupe(@RequestParam("id") Long id,
 ModelMap modelMap)
{ 
grpService.deleteGroupeById(id);
List<Groupe> grps = grpService.findAll();
modelMap.addAttribute("groupes", grps);
return "ListeGrp";
}

@RequestMapping("/modifierAnimal")
public String modifierAnimal(@RequestParam("id") Long id,ModelMap modelMap)
{
animal a= animalService.getAnimal(id);
List<Groupe> grps = grpService.findAll();
grps.remove(a.getGroupe());
modelMap.addAttribute("groupes", grps);
modelMap.addAttribute("animal", a);
modelMap.addAttribute("mode", "edit");
return "formAnimal";
}
@RequestMapping("/updateAnimal")
public String updateAnimal(@ModelAttribute("animal") animal animal,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException {
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateAjout = dateformat.parse(String.valueOf(date));
	 animal.setDateAjout(dateAjout);
	 
	 animalService.updateAnimal(animal);
	 List<animal> anims = animalService.getAllAnimals();
	 modelMap.addAttribute("animals", anims);
	return "ListeAnimaux";
	}
@RequestMapping("/modifierGroupe")
public String editerGroupe(@RequestParam("id") Long id,ModelMap modelMap)
{
Groupe g= grpService.getGroupe(id);
modelMap.addAttribute("groupes", g);
modelMap.addAttribute("mode", "edit");
return "formGroupe";
}
@RequestMapping("/updateGroupe")
public String updateGroupe(@ModelAttribute("groupe") Groupe groupe,ModelMap modelMap) throws ParseException {
	grpService.updateGroupe(groupe);
	 List<Groupe> grps = grpService.findAll();
	 modelMap.addAttribute("groupes", grps);
	return "ListeGrp";
	}


@RequestMapping("/search")
public String recherNom(@RequestParam("nom") String nom,
ModelMap modelMap)
{
	List<Groupe> grps = grpService.findAll();
	modelMap.addAttribute("groupes", grps);
List<animal> anims =animalService.findByNomAnimal(nom);
modelMap.addAttribute("animals",anims);
modelMap.addAttribute("mode", "SearchNomP");
return "ListeAnimaux";
}
@RequestMapping("/searchGrp")
public String recherGrp(@RequestParam("grp") Long grp,ModelMap modelMap)
{
Groupe grps = new Groupe();
grps.setIdGrp(grp);
List<Groupe> grps2 = grpService.findAll();
modelMap.addAttribute("groupes", grps2);
List<animal> anims = animalService.findByGroupe(grps);
modelMap.addAttribute("animals",anims);
modelMap.addAttribute("mode", "Searchgrp");
return "ListeAnimaux";
}
}