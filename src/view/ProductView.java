package view;

import control.Controller;
import model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();
    List<Product> productList = controller.showProductList();

    public void displayProduct() {
        for (int i = 0; i < productList.size(); i++) {
            if (i % 3 == 0 && i != 0) {
                scanner.nextLine();
            }
            System.out.println(productList.get(i));
        }
    }

    public void formCreateProduct() {
        Product product = create();
        controller.addProduct(product);
        System.out.println("Create completed!");
    }

    private Product create() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        double price;
        System.out.println("Enter price: ");
        while (true) {
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price >= 0 && price < Double.MAX_VALUE) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("---> Please enter Double! <---");
            }
        }

        System.out.println("Enter quantity: ");
        int quantity;
        while (true) {
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity >= 0 && quantity < Integer.MAX_VALUE) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("---> Please enter Integer! <---");
            }
        }


        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        return new Product(name, price, quantity, description);
    }

    public void updateProduct() {
        System.out.println("Enter id");
        int index;
        while (true) {
            try {
                index = Integer.parseInt(scanner.nextLine());
                if (index >= 0 && index < Integer.MAX_VALUE) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("---> Please enter Integer! <---");
            }
        }

        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        double price;
        System.out.println("Enter price: ");
        while (true) {
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price >= 0 && price < Double.MAX_VALUE) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("---> Please enter Double! <---");
            }
        }

        System.out.println("Enter quantity: ");
        int quantity;
        while (true) {
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity >= 0 && quantity < Integer.MAX_VALUE) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("---> Please enter Integer! <---");
            }
        }


        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        controller.updateProduct(controller.findId(index), name, price, quantity, description);
        System.out.println("Update product completed!");
    }

    public void deleteProduct() {
        System.out.println("Enter id");
        int index;
        while (true) {
            try {
                index = Integer.parseInt(scanner.nextLine());
                if (index >= 0 && index < Integer.MAX_VALUE) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("---> Please enter Integer! <---");
            }
        }
        controller.deleteProduct(controller.findId(index));
        System.out.println("Delete product completed!");
    }

    public void sortProductList() {
        controller.sortProductList(productList);
        System.out.println("Sort product completed!");
    }

    public void findProduct() {
        System.out.println("The most expensive product is: ");
        System.out.println(controller.findProduct());
    }

    public void readFile() {
        controller.readFile();
    }

    public void writeToFile() {
        controller.writeToFile();
    }

}
