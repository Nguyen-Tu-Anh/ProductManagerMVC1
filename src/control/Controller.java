package control;

import model.Product;
import service.ProductServiceImpl;

import java.util.List;

public class Controller {
    ProductServiceImpl productService = new ProductServiceImpl();

    public List<Product> showProductList() {
        return productService.findAll();
    }

    public void addProduct(Product product) {
        productService.save(product);
    }

    public void updateProduct(int id, String name, Double price, Integer quantity, String description) {
        productService.update(id, name, price, quantity, description);
    }

    public int findId(int index) {
        return productService.findId(index);
    }

    public void deleteProduct(int id) {
        productService.delete(id);
    }

    public void sortProductList(List<Product> list) {
        productService.sort(list);
    }

    public Product findProduct() {
        return productService.findProduct();
    }

    public void readFile() {
        productService.readFile();
    }

    public void writeToFile() {
        productService.writeToFile();
    }
}
