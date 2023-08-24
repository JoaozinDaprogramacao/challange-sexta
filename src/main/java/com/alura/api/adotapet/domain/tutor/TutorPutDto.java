package com.alura.api.adotapet.domain.tutor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record TutorPutDto(
		@Email
		@Size(max = 255)
		String email,
		@Size(max = 8)
		String senha,
		@Size(max = 255)
		String nome          
		) {

	public TutorPutDto(Tutor entity) {
		this(entity.getEmail(), entity.getSenha(), entity.getNome());
	}

	public Tutor toTutor() {
		return new Tutor(this.email, this.senha, this.nome);
	}

}
