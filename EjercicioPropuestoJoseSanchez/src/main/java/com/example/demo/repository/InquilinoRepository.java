package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Inquilino;

public interface InquilinoRepository extends JpaRepository<Inquilino,Integer> {

}
