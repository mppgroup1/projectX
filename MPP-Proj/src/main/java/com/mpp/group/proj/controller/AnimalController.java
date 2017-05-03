package com.mpp.group.proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.mpp.group.proj.model.*;
import com.mpp.group.proj.service.*;

@Controller
@RequestMapping(value="/animal")
public class AnimalController {
	
	@Autowired
	AnimalService animalService;
	@Autowired
	SpecieService specieService;
	@Autowired
	BreedService breedService;
	@Autowired
	MicrochipService microchipService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView listAnimal(){
		ModelAndView model = new ModelAndView("animal/animal");
		
		Animal animal = new Animal();
		List<Animal> list = animalService.listAllAnimal();
		List<Specie> listSpecies = specieService.listAllSpecie();
		List<Breed> listBreeds = breedService.listAllBreed();
		List<Microchip> listMicrochips = microchipService.listAllMicrochip();
		model.addObject("animalForm",animal);
		model.addObject("listAnimal",list);
		model.addObject("listStatus",Gender.values());
		model.addObject("listSpecies",listSpecies);
		model.addObject("listBreeds",listBreeds);
		model.addObject("listMicrochips",listMicrochips);
		
		return model;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView saveAnimal(@ModelAttribute("id") Animal animal){
	
		if(animal != null && animal.getId() != 0){
			//update
			animalService.updateAnimal(animal);
		}else{
			animalService.addAnimal(animal);
		}
		return new ModelAndView("redirect:/animal/");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteAnimal(ModelMap model, @RequestParam int id) {
		
		animalService.deleteAnimal(id);
		Animal animal = new Animal();
		List<Animal> list = animalService.listAllAnimal();
		List<Specie> listSpecies = specieService.listAllSpecie();
		List<Breed> listBreeds = breedService.listAllBreed();
		List<Microchip> listMicrochips = microchipService.listAllMicrochip();
		model.addAttribute("animalForm",animal);
		model.addAttribute("listAnimal",list);
		model.addAttribute("listStatus",Gender.values());
		model.addAttribute("listSpecies",listSpecies);
		model.addAttribute("listBreeds",listBreeds);
		model.addAttribute("listMicrochips",listMicrochips);
		
		return "animal/animal";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateAnimal(ModelMap model, @RequestParam int id) {
		
		List<Animal> list = animalService.listAllAnimal();
		Animal a = animalService.findAnimalById(id);
		List<Specie> listSpecies = specieService.listAllSpecie();
		List<Breed> listBreeds = breedService.listAllBreed();
		List<Microchip> listMicrochips = microchipService.listAllMicrochip();
		model.addAttribute("animalForm", a);
		model.addAttribute("listAnimal",list);
		model.addAttribute("listStatus",Gender.values());
		model.addAttribute("selectedGender",a.getGender());
		model.addAttribute("listSpecies",listSpecies);
		model.addAttribute("listBreeds",listBreeds);
		model.addAttribute("listMicrochips",listMicrochips);
		
		return "animal/animal";
	}


}
