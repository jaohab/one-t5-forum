package br.com.alura.forum.domain.topicos;

import br.com.alura.forum.domain.Curso;
import jakarta.validation.constraints.NotNull;

public record DadosNovoTopico(
    @NotNull
    String titulo,

    @NotNull
	String mensagem,
    
	Curso curso) {
    
}
