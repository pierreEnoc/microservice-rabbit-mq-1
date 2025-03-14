package com.pierre.api.pedidos.processador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pierre.api.pedidos.processador.entity.Produto;

import java.util.UUID;

@Repository
public interface ProdudoRepository extends JpaRepository<Produto, UUID> {
}
