package ru.itpark.app.services;

import ru.itpark.app.models.Product;

import java.util.List;

public interface ProductsService {
    List<Product> getProducts();

    void add(Product product);
}
