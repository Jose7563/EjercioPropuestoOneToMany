package com.example.demo.controller;

import java.time.LocalDateTime;

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

import com.example.demo.entity.Pago;
import com.example.demo.service.InquilinoService;
import com.example.demo.service.PagoService;

@Controller
public class PagoController {

	@Autowired
	PagoService service;

	@Autowired
	InquilinoService serviceInquilinos;

	@GetMapping("/pagos")
	public String index(Model model) {
		model.addAttribute("pagos", service.listaPagos());
		return "pagos";
	}

	@GetMapping("/pagoNuevo")
	public String nuevo(Model model) {
		model.addAttribute("pago", new Pago());
		model.addAttribute("inquilinos", serviceInquilinos.listaInquilinos());
		return "pagoCrear";
	}

	@PostMapping("/pagoCrear")
	public String proveedorIns(@Validated Pago pago, BindingResult result,Model model, RedirectAttributes red) {
		if (result.hasErrors()) {
			model.addAttribute("inquilinos", serviceInquilinos.listaInquilinos());
			
			return "pagoCrear";
		}
		pago.setFecha(LocalDateTime.now());
		red.addFlashAttribute("mensaje", " Se registro pago correctamente");
		service.registroActualizaPago(pago);
		return "redirect:/pagos";
	}
	
	
	@GetMapping("/pagoObtener/{id}")
	public String actualizar(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("pago", service.obtenerPagoId(id));
		model.addAttribute("inquilinos", serviceInquilinos.listaInquilinos());
		return "pagoActualizar";
	}
	
	@PostMapping("/pagoActualizar")
	public String pagoUpd(@Validated Pago pago, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "pagoActualizar";
		}
		service.registroActualizaPago(pago); 
		return "redirect:/pagos";
	}
	
	@GetMapping("/pagoEliminar")
	public String inquilinosElim(@RequestParam("id") Integer id) {
		service.pagoEliminar(id); 
		return "redirect:/pagos";
	}
	
}
