package br.com.alura.forum.domain;

import java.time.LocalDateTime;

import br.com.alura.forum.domain.topicos.Topico;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "respostas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resposta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensagem;

    // @OneToOne(mappedBy = "respostas")
	// private Topico topico;
	private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
	private Usuario autor;
	private Boolean solucao = false;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resposta other = (Resposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	// public Long getId() {
	// 	return id;
	// }

	// public void setId(Long id) {
	// 	this.id = id;
	// }

	// public String getMensagem() {
	// 	return mensagem;
	// }

	// public void setMensagem(String mensagem) {
	// 	this.mensagem = mensagem;
	// }

	// public Topico getTopico() {
	// 	return topico;
	// }

	// public void setTopico(Topico topico) {
	// 	this.topico = topico;
	// }

	// public LocalDateTime getDataCriacao() {
	// 	return dataCriacao;
	// }

	// public void setDataCriacao(LocalDateTime dataCriacao) {
	// 	this.dataCriacao = dataCriacao;
	// }

	// public Usuario getAutor() {
	// 	return autor;
	// }

	// public void setAutor(Usuario autor) {
	// 	this.autor = autor;
	// }

	// public Boolean getSolucao() {
	// 	return solucao;
	// }

	// public void setSolucao(Boolean solucao) {
	// 	this.solucao = solucao;
	// }

}