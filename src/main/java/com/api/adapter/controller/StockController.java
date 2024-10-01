package com.api.adapter.controller;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.adapter.database.StockDatabaseConnection;
import com.api.adapter.dto.ProductsDto;
import com.api.service.CreateProduct;
import com.api.service.ListProducts;
import com.api.service.SearchProduct;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController("/")
public class StockController {

    @GetMapping("/list")
    public ResponseEntity<List<ProductsDto>> ListItems() throws ClassNotFoundException, SQLException {
        Statement statement = StockDatabaseConnection.connectDatabase();
        List<ProductsDto> products = ListProducts.list(statement);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ProductsDto> SearchItem(@PathVariable("id") int id) throws ClassNotFoundException,
            SQLException {
        Statement statement = StockDatabaseConnection.connectDatabase();
        ProductsDto product = SearchProduct.searchById(statement, id);

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ProductsDto> CreateItem(@RequestBody ProductsDto request) throws ClassNotFoundException, SQLException {
        Statement statement = StockDatabaseConnection.connectDatabase();
        if (CreateProduct.create(statement, request)){
            return new ResponseEntity<>(request, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
