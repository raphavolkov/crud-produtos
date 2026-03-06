package com.raphavolkov.crud_produtos.service;

import com.raphavolkov.crud_produtos.entity.Produto;
import com.raphavolkov.crud_produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listar(){
        return repository.findAll();
    }

    public Produto buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto criar(Produto produto){
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto dados){
        Produto produto = buscarPorId(id);
        produto.setNome(dados.getNome());
        produto.setPreco(dados.getPreco());
        return repository.save(produto);
    }

    public void deletar(Long id){
        buscarPorId(id);
        repository.deleteById(id);
    }
}
