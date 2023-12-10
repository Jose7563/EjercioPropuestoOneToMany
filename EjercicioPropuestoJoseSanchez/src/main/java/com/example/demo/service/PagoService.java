package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Inquilino;
import com.example.demo.entity.Pago;
import com.example.demo.repository.PagoRepository;

@Service
public class PagoService {

	@Autowired
	PagoRepository repository;

	public List<Pago> listaPagos() {
		return repository.findAll();
	}
	
	
	public Pago  registroActualizaPago(Pago inq) {
		return repository.save(inq);
	}
	
	
	public Pago obtenerPagoId(Integer id) {
		return repository.findById(id).orElse(new Pago());
	}

	public void pagoEliminar(Integer id) {
		repository.deleteById(id);
	}
}
