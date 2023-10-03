package br.com.alura.forum.domain.topicos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.forum.domain.Curso;
import br.com.alura.forum.domain.Resposta;
import br.com.alura.forum.domain.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao = LocalDateTime.now();
    
    @Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
	private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
	private Curso curso;

    // @ManyToOne(targetEntity = Resposta.class)
    // @JoinColumn(name = "resposta_id", referencedColumnName = "id")
	// private List<Resposta> respostas = new ArrayList<>();

	private boolean ativo = true;

	public Topico(String titulo, String mensagem, Curso curso) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.curso = curso;
	}

	public Topico(DadosNovoTopico dados) {
		this.titulo = dados.titulo();
		this.mensagem = dados.mensagem();
		this.curso = dados.curso();
	}

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
		Topico other = (Topico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Topico [id=" + id + ", titulo=" + titulo + ", mensagem=" + mensagem + ", dataCriacao=" + dataCriacao
				+ ", status=" + status + ", autor=" + autor + ", curso=" + curso + "]";
	}

	public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
		if (dados.titulo() != null) {
			this.titulo = dados.titulo();
		}
		if (dados.mensagem() != null) {
			this.mensagem = dados.mensagem();
		}
		if (dados.status() != null) {
			this.status = dados.status();
		}
	}

	public void atualizarInformacoes(DadosAtualizacaoTopicoPorId dados) {
		if (dados.titulo() != null) {
			this.titulo = dados.titulo();
		}
		if (dados.mensagem() != null) {
			this.mensagem = dados.mensagem();
		}
		if (dados.status() != null) {
			this.status = dados.status();
		}
	}

	public void excluir() {
        this.ativo = false;
    }

}
