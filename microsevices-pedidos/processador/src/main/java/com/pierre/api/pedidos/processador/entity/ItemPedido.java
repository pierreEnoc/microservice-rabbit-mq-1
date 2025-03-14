package com.pierre.api.pedidos.processador.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    private UUID id = UUID.randomUUID();

    @ManyToMany
    private  Produto produto;

    private Integer quantidade;

    @ManyToMany
    private Pedido pedido;
}
