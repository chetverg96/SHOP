package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 15000, "HP");
        Product product2 = new Product("Phone", 7000, "Sasmsung");
        Product product3 = new Product("Watch", 12000, "LG");
        Product product4 = new Product("Refrigeration", 20000, "LG");
        Product product5 = new Product("Keyboard", 1000, "Trust");

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(product1);
        catalog.addProduct(product2);
        catalog.addProduct(product3);
        catalog.addProduct(product4);
        catalog.addProduct(product5);

        List<Product> products = new ArrayList<>();
        Cart cart = new Cart(products);

        ShopApp shopApp = new ShopApp(catalog, cart);
        shopApp.run();

    }
}





