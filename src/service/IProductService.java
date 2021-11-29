package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    void update(int id, String name, Double price, Integer quantity, String description);

    void delete(int id);

    void sort(List<Product> list);

    Product findProduct();

//    void readFile();


    void writeToFile();


}

