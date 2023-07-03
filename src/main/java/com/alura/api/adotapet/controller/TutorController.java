package com.alura.api.adotapet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.api.adotapet.tutor.TutorDto;
import com.alura.api.adotapet.tutor.TutorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tutores")
public class TutorController {

	@Autowired
	private TutorService service;
	
	@PostMapping
	public TutorDto save(@RequestBody @Valid TutorDto dto) {
		return service.save(dto);
	}
	
	@GetMapping
	public List<Object> getAll() {
		return service.getAll();
	}
	
}
