package br.com.alura.forum.domain.topicos;

public record DadosAtualizacaoTopicoPorId(
    String titulo,
	String mensagem,
    StatusTopico status) {

}
