package com.exemplo.seuprojeto.controller;

import com.exemplo.seuprojeto.model.Produto;
import com.exemplo.seuprojeto.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Listar todos os produtos
    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.findAll();
    }

    // Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {

        Optional<Produto> produto = produtoService.findById(id);

        return produto
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar produto
    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    // Atualizar produto
    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(
            @PathVariable Long id,
            @RequestBody Produto produtoAtualizado) {

        Optional<Produto> produto =
                produtoService.update(id, produtoAtualizado);

        return produto
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Deletar produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {

        if (produtoService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}