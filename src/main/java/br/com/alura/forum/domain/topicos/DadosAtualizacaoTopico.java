package br.com.alura.forum.domain.topicos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
    @NotNull
    Long id, 

    String titulo,
	String mensagem,
    StatusTopico status) {

}
