package com.api.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.api.adapter.dto.ProductsDto;

public class SearchProduct {
    public static ProductsDto searchById(Statement statement, int id) throws SQLException {
        ResultSet resultSet = (ResultSet) statement.executeQuery("SELECT * FROM produtos where id = " + id);

        if (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String descricao = resultSet.getString("descricao");
            double preco = resultSet.getDouble("preco");
            int quantidade = resultSet.getInt("quantidade");
            return new ProductsDto(id, nome, descricao, preco, quantidade);
        } else
            return null;
    }
}