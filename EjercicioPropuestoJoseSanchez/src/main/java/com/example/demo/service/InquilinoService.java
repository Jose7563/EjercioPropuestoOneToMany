package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Inquilino;
import com.example.demo.repository.InquilinoRepository;

@Service
public class InquilinoService {

	@Autowired
	InquilinoRepository repository;

	public List<Inquilino> listaInquilinos() {
		return repository.findAll();
	}
	
	public Inquilino  registroActualizaInquilino(Inquilino inq) {
		return repository.save(inq);
	}
	public Inquilino obtenerInquilinoId(Integer id) {
		return repository.findById(id).orElse(new Inquilino());
	}

	public void inquilinoEliminar(Integer id) {
		repository.deleteById(id);
	}
	
	
}
