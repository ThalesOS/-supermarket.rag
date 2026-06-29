package com.supermarket_rag.repositories;

import com.supermarket_rag.models.Pedido;
import com.supermarket_rag.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existsByNome(String nome);

    Produto findByName(String nome);
}
