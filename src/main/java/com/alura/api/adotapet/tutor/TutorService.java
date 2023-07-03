package com.alura.api.adotapet.tutor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

	@Autowired
	private TutorRepository repository;
	
	
	public TutorDto save(TutorDto dto) {
		repository.save(dto.toTutor());
		return dto;
	}
	
	public Object getAll() {
		
		List<Tutor> result = new ArrayList<Tutor>();
		
		if (repository.findAll().isEmpty()) {
			return "Não encontrado";
		}
		return repository.findAll();	
		
	}
}
