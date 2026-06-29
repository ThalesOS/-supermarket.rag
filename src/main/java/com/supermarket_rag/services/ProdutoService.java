package com.supermarket_rag.services;

import com.supermarket_rag.models.Produto;
import com.supermarket_rag.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto){
        if(produtoRepository.existsByNome(produto.getNome())){
            throw new RuntimeException("Produto já cadastrado");
        }else{
            return produtoRepository.save(produto);
        }
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findByName(String nome){
        if (produtoRepository.existsByNome(nome)){
            return produtoRepository.findByName(nome);
        } else{
            throw new RuntimeException("Produto não encontrado");
        }

    }

    public Produto updateProdutoById(Produto produtoAtualizado, Long id ){

        if(produtoRepository.existsById(id)){

            Produto p = produtoRepository.findById(id).get();
            p.setNome(produtoAtualizado.getNome());
            p.setPreco(produtoAtualizado.getPreco());

            return produtoRepository.save(p);
        }else{
            throw new RuntimeException("Produto não encontrado");
        }


    }

    public void deleteById(Long id){
        if(produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
        }else{
            throw new RuntimeException("Produto não encontrado");
        }

    }


}
