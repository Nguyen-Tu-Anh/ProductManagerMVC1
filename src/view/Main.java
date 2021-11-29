package view;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        do {
            menu();
            System.out.println("Enter your choice");
            Scanner scanner = new Scanner(System.in);
            choice = Integer.parseInt(scanner.nextLine());

            ProductView productView = new ProductView();

            switch (choice) {
                case 1:
                    productView.displayProduct();
                    break;
                case 2:
                    productView.formCreateProduct();
                    break;
                case 3:
                    productView.updateProduct();
                    break;
                case 4:
                    productView.deleteProduct();
                    break;
                case 5:
                    productView.sortProductList();
                    break;
                case 6:
                    productView.findProduct();
                    break;
                case 7:
                    productView.readFile();
                    break;
                case 8:
                    productView.writeToFile();
                    break;

            }

        } while (choice != 9);
    }

    private static void menu() {
        System.out.println("1. Display");
        System.out.println("2. Add product");
        System.out.println("3. Update product");
        System.out.println("4. Delete product");
        System.out.println("5. Sort product");
        System.out.println("6. Find product");
        System.out.println("7. Read file");
        System.out.println("8. Write file");
        System.out.println("9. Exit");
    }
}
