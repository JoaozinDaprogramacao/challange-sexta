package com.alura.api.adotapet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.api.adotapet.domain.tutor.TutorDto;
import com.alura.api.adotapet.domain.tutor.TutorPutDto;
import com.alura.api.adotapet.domain.tutor.TutorService;
import com.alura.api.adotapet.infra.exceptions.InternalEntityNotFoundException;
import com.alura.api.adotapet.infra.exceptions.NotFoundHandlerException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tutores")
public class TutorController {

	@Autowired
	private TutorService service;
	
	@PostMapping
	public ResponseEntity<TutorDto> save(@RequestBody @Valid TutorDto dto) {
		return service.save(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<TutorDto>> getAll() throws NotFoundHandlerException {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TutorDto> getById(@PathVariable Long id) throws NotFoundHandlerException {
		return service.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) throws NotFoundHandlerException {
		return service.deleteByid(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TutorDto> update(@PathVariable Long id, @RequestBody @Valid TutorPutDto dto) 
			throws InternalEntityNotFoundException {
		return service.update(id, dto);
	}
	
}
