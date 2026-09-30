package com.exemplo.seuprojeto.service;

import com.exemplo.seuprojeto.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final List<Produto> produtos = new ArrayList<>();

    private Long proximoId = 1L;

    // CREATE
    public Produto save(Produto produto) {
        produto.setId(proximoId++);
        produtos.add(produto);
        return produto;
    }

    // READ - Todos
    public List<Produto> findAll() {
        return produtos;
    }

    // READ - Por ID
    public Optional<Produto> findById(Long id) {
        return produtos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst();
    }

    // UPDATE
    public Optional<Produto> update(Long id, Produto produtoAtualizado) {

        Optional<Produto> produtoExistente = findById(id);

        if (produtoExistente.isPresent()) {

            Produto produto = produtoExistente.get();

            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());

            return Optional.of(produto);
        }

        return Optional.empty();
    }

    // DELETE
    public boolean deleteById(Long id) {
        return produtos.removeIf(produto -> produto.getId().equals(id));
    }
}