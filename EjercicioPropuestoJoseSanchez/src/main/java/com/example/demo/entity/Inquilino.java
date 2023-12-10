package com.example.demo.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "inquilinos")
public class Inquilino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInquilinos;
	
	@NotEmpty(message = "No debe estar vacio nombre ")
	//@Size(min = 8, max=8, message ="Debe contener solo 8 caracteres")
	@Pattern(regexp = "[0-9]{8}", message = "Solo debe contener 8 digitos")
	private String dni;
	
	
	@NotEmpty(message = "No debe estar vacio apellido")
	@Size(min = 2, max=30, message ="Debe contener de 2 a 30 caracteres")
	private String nombres;
	
	@NotEmpty(message = "No debe estar vacio apellido paterno")
	@Size(min = 2, max=30, message ="Debe contener de 2 a 30 caracteres")
	private String paterno;
	
	@NotEmpty(message = "No debe estar vacio apellido materno")
	@Size(min = 2, max=30, message ="Debe contener de 2 a 30 caracteres")
	private String materno;
	
	@NotEmpty(message = "No debe estar vacio ")
	@Size(min = 7, max=9, message ="Debe contener de 7 a 9 caracteres")
	private String telefono;
	
	@NotEmpty(message = "Colocar un dni")
	@Email(message = "Debe contener correo valido")
	private String correo;
	
	@NotNull(message = "El monto es obligatorio")
	@Min(20 )
	private Double deuda;
	
	@Past(message = "Debe contener una fecha anterior a hoy ")
	@NotNull(message = "Debe contener una fecha")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_ingreso")
	private Date fecha;
}
