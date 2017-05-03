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

import com.mpp.group.proj.model.Animal;
import com.mpp.group.proj.model.ImplantSite;
import com.mpp.group.proj.model.Microchip;
import com.mpp.group.proj.service.MicrochipService;


@Controller
@RequestMapping(value="/microchip")
public class MicrochipController {

	@Autowired
	MicrochipService microchipService;

	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView listMicrochip(){
		ModelAndView model = new ModelAndView("microchip/microchip");
		Microchip microchip = new Microchip();
		
		List<Microchip> list = microchipService.listAllMicrochip();

		model.addObject("microchipForm",microchip);
		model.addObject("listMicrochip",list);
		model.addObject("ImplantSiteList",ImplantSite.values());
		
		return model;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView saveMicrochip(@ModelAttribute("id") Microchip microchip ){
    
		if(microchip != null && microchip.getId() != 0){
			//update
			microchipService.updateMicrochip(microchip);
		}else{
			microchipService.addMicrochip(microchip);
		}
		return new ModelAndView("redirect:/microchip/");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteMicrochip(ModelMap model, @RequestParam int id) {
		
		microchipService.deleteMicrochip(id);
		Microchip microchip = new Microchip();
		List<Microchip> list = microchipService.listAllMicrochip();
		
		model.addAttribute("microchipForm",microchip);
		model.addAttribute("listMicrochip",list);
		model.addAttribute("ImplantSiteList", ImplantSite.values());
		
		return "microchip/microchip";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateMicrochip(ModelMap model, @RequestParam int id) {
		
		List<Microchip> list = microchipService.listAllMicrochip();
		Microchip a = microchipService.findMicrochipById(id);
		
		model.addAttribute("microchipForm", microchipService.findMicrochipById(id));
		model.addAttribute("listMicrochip",list);
		model.addAttribute("ImplantSiteList", ImplantSite.values());
		model.addAttribute("selectedImplantSite",a.getImplantSite());
		
		return "microchip/microchip";
	}
	
}
