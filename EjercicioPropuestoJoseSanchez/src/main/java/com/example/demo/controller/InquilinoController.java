package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Inquilino;
import com.example.demo.service.InquilinoService;

@Controller
public class InquilinoController {

	@Autowired
	InquilinoService service;
	
	@GetMapping("/inquilinos")
	public String index(Model model) {
		model.addAttribute("inquilinos", service.listaInquilinos()); 
		return "index"; 
	}
	@GetMapping("/inquilinoNuevo")
	public String nuevo(Model model) {
		model.addAttribute("inquilino", new Inquilino());
		return "inquilinoCrear";
	}
	@PostMapping("/inquilinoCrear")
	public String inquilinoIns(@Validated Inquilino inquilino, BindingResult result, RedirectAttributes red) {
		if (result.hasErrors()) {
			return "inquilinoCrear";
		}
		red.addFlashAttribute("mensaje", " Se inserto Inquilo");
		service.registroActualizaInquilino(inquilino);
		return "redirect:/inquilinos";
	}
	
	@GetMapping("/inquilinoObtener/{id}")
	public String actualizar(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("inquilino", service.obtenerInquilinoId(id));
		return "inquilinoActualizar";
	}
	
	@PostMapping("/inquilinoActualizar")
	public String inquilinoUpd(@Validated Inquilino inquilino, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "inquilinoActualizar";
		}
		service.registroActualizaInquilino(inquilino); 
		return "redirect:/inquilinos";
	}
	
	@GetMapping("/inquilinoEliminar")
	public String inquilinosElim(@RequestParam("id") Integer id) {
		service.inquilinoEliminar(id); 
		return "redirect:/inquilinos";
	}
	
}
