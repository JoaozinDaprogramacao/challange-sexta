package com.alura.api.adotapet.tutor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TutorDto(
		@Email
		@Size(max = 255)
		@NotBlank
		String email,
		@Size(max = 8)
		@NotBlank
		String senha,
		@Size(max = 255)
		@NotBlank
		String nome
		) {

	public Tutor toTutor() {
		return new Tutor(this.email, this.senha, this.nome);
	}

}
