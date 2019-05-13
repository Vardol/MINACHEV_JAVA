package ru.itpark.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itpark.app.models.Product;
import ru.itpark.app.repositories.ProductsRepository;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<Product> getProducts() {
        return productsRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productsRepository.save(product);
    }
}
