package com.api.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductsDto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;
}
