package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.domain.topicos.DadosAtualizacaoTopico;
import br.com.alura.forum.domain.topicos.DadosAtualizacaoTopicoPorId;
import br.com.alura.forum.domain.topicos.DadosNovoTopico;
import br.com.alura.forum.domain.topicos.Topico;
import br.com.alura.forum.domain.topicos.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public Topico novoTopico(@RequestBody @Valid DadosNovoTopico dados) {
        var topico = new Topico(dados);
        return topicoRepository.save(topico);
    }

    @GetMapping
    public List<Topico> carregarTodos() {
        return topicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Topico carregarTopico(@PathVariable("id") Long id) {
        return topicoRepository.findById(id).get();
    }

    @PutMapping
    @Transactional
    public void atualizarTopico(@RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topico = topicoRepository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizarTopicoPorId(@PathVariable("id") Long id, @RequestBody @Valid DadosAtualizacaoTopicoPorId dados) {
        var topico = topicoRepository.getReferenceById(id);
        topico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarTopicoPorId(@PathVariable("id") Long id) {
        topicoRepository.delete(topicoRepository.getReferenceById(id));
    }

}
    

