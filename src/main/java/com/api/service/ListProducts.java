package com.api.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.api.adapter.dto.ProductsDto;

public class ListProducts {

    public static List<ProductsDto> list(Statement statement) throws SQLException {
        List<ProductsDto> produtos = new ArrayList<>();
        ResultSet resultSet;
        resultSet = statement.executeQuery("SELECT * FROM produtos");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String descricao = resultSet.getString("descricao");
            double preco = resultSet.getDouble("preco");
            int quantidade = resultSet.getInt("quantidade");
            System.out.println("ID: " + id + ", Nome: " + nome + ", Descricao: " + descricao + ", Preço: " + preco
                    + ", Quantidade: " + quantidade);
            ProductsDto products = new ProductsDto(id, nome, descricao, preco, quantidade);
            produtos.add(products);
        }
        return produtos;
    }
}