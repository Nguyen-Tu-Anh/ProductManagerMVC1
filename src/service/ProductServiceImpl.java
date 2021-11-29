package service;

import model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    public static List<Product> productList = new ArrayList<>();
    public static final String filePath = "data.txt";

    static {
        productList.add(new Product("Hat", 15.6, 5, "red"));
        productList.add(new Product("Shirt", 29.5, 20, "yellow"));
        productList.add(new Product("Jeans", 15.6, 9, "blue"));
        productList.add(new Product("Capo", 5, 31, "green"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void update(int id, String name, Double price, Integer quantity, String description) {
        productList.get(id).setName(name);
        productList.get(id).setPrice(price);
        productList.get(id).setQuantity(quantity);
        productList.get(id).setDescription(description);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }

    @Override
    public void sort(List<Product> list) {
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
    }

    @Override
    public Product findProduct() {
        List<Product> newProductList = productList;
        sort(newProductList);
        return newProductList.get(newProductList.size() - 1);
    }

    public int findId(int index) {
        for (int i = 0; i < productList.size(); i++) {
            if (index == productList.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public void readFile() {
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                List<Product> result = new ArrayList<>();
                String[] productLine = line.split(",");
                //productLine[0] => id
                //productLine[1] => name
                //productLine[2] => price
                //productLine[3] => description
                int id = Integer.parseInt(productLine[0]);
                String name = productLine[1];
                double price = Double.parseDouble(productLine[2]);
                int quantity = Integer.parseInt(productLine[3]);
                String description = productLine[4];
                Product newProduct = new Product(name, price, quantity, description);
                result.add(newProduct);
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static List<String> parseCsvLine(String csvLine) {
//        List<String> result = new ArrayList<>();
//        if (csvLine != null) {
//            String[] splitData = csvLine.split(",");
//            for (int i = 0; i < splitData.length; i++) {
//                result.add(splitData[i]);
//            }
//        }
//        return result;
//    }

    @Override
    public void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            for (Product product : productList) {
                fileWriter.write(product.toString());
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
