package com.alura.api.adotapet.domain.tutor;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alura.api.adotapet.infra.exceptions.InternalEntityNotFoundException;
import com.alura.api.adotapet.infra.exceptions.NotFoundHandlerException;

import jakarta.transaction.Transactional;

@Service
public class TutorService {

	@Autowired
	private TutorRepository repository;

	@Transactional
	public ResponseEntity<TutorDto> save(TutorDto dto) {
		Tutor entity = repository.save(dto.toTutor());
		
		String uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(entity.getId()).toUriString();

		
		return ResponseEntity.created(URI.create(uri)).body(dto);
	}

	public ResponseEntity<List<TutorDto>> getAll() throws NotFoundHandlerException {

		if (repository.findAll().isEmpty()) {
			throw new NotFoundHandlerException("Não foi encontrado nenhum tutor cadastrado");
		}
		
		List<TutorDto> dtos = new ArrayList<TutorDto>();
		repository.findAll().forEach(entity ->
		dtos.add(new TutorDto(entity)));
		
		return ResponseEntity.ok(dtos);

	}

	public ResponseEntity<TutorDto> getById(Long id) throws NotFoundHandlerException {

		if (!repository.existsById(id)) {
			throw new NotFoundHandlerException("Não foi encontrado nenhum tutor com esse id");
		}
		
		Tutor tutor = repository.getReferenceById(id);
		TutorDto dto = new TutorDto(tutor.getEmail(), tutor.getNome(), tutor.getSenha());

		return ResponseEntity.ok(dto);

	}

	@Transactional
	public ResponseEntity<?> deleteByid(Long id) throws NotFoundHandlerException {

		if (!repository.existsById(id)) {
			throw new NotFoundHandlerException("Não foi encontrado nenhum tutor com esse id");
		}
		
		repository.deleteById(id);
		return ResponseEntity.noContent().build();

	}

	@Transactional
	public ResponseEntity<TutorDto> update(Long id, TutorPutDto dto) throws InternalEntityNotFoundException {
		if (!repository.existsById(id)) {
			throw new InternalEntityNotFoundException("Nenhum depoimento foi encontrado");
		}

		Tutor entity = repository.getReferenceById(id);

		if (!(dto.email() == null)) {
			entity.setEmail(dto.email());
		}

		if (!(dto.nome() == null)) {
			entity.setNome(dto.nome());
		}

		if (!(dto.senha() == null)) {
			entity.setSenha(dto.senha());
		}
		
		

		return ResponseEntity.ok().body(new TutorDto(entity));
	}
}
