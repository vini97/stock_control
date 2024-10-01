package com.api.service;

import java.sql.SQLException;
import java.sql.Statement;

import com.api.adapter.dto.ProductsDto;

public class CreateProduct {
    public static boolean create(Statement statement, ProductsDto request) throws SQLException {

        String query = "INSERT INTO produtos (id, nome, descricao, preco, quantidade) VALUES ("
                + request.getId() + ", '"
                + request.getNome() + "', '"
                + request.getDescricao() + "', "
                + request.getPreco() + ", "
                + request.getQuantidade() + ")";

        int rowsAffected = statement.executeUpdate(query);

        return rowsAffected > 0;
    }
}
