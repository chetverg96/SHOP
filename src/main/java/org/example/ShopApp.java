package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ShopApp {
    private final ProductCatalog productCatalog;
    private Cart cart;
    private Order currentOrder;
    private static int nextOrderId = 1;

    public ShopApp(ProductCatalog productCatalog, Cart cart) {
        this.productCatalog = productCatalog;
        this.cart = cart;
      
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Меню ===");
            System.out.println("1. Просмотр товаров");
            System.out.println("2. Фильтрация товаров");
            System.out.println("3. Добавление товара в корзину");
            System.out.println("4. Оформление заказа");
            System.out.println("5. Отслеживание статуса заказа");
            System.out.println("6. Отмена заказа");
            System.out.println("7. Просмотр корзины и удаление товара");
            System.out.println("8. Фильтрация по цене от меньшего к большему");
            System.out.println("0. Выход");
            System.out.print("Введите номер действия: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    filterProducts();
                    break;
                case 3:
                    addToCart();
                    break;
                case 4:
                    checkout();
                    break;
                case 5:
                    trackOrderStatus();
                    break;
                case 6:
                    cancelOrder();
                    break;
                case 7:
                    viewCart();
                    break;
                case 8:
                    filterProductsByPriceAscending();
                    break;
                case 0:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неверный номер действия. Попробуйте снова.");
            }
        }
    }

    private void filterProductsByPriceAscending() {
        List<Product> allProducts = productCatalog.getAllProducts();
        List<Product> filteredProducts = new ArrayList<>(allProducts);
        filteredProducts.sort(Comparator.comparingInt(Product::getPrice));
        System.out.println("Продукты, отсортированные по цене (от меньшего к большему):");
        for (Product product : filteredProducts) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }

    private void viewCart() {
        List<Product> cartItems = cart.getItems();
        if (cartItems.isEmpty()) {
            System.out.println("Корзина пуста. Добавьте товары перед просмотром.");
        } else {
            System.out.println("Товары в корзине:");
            for (Product product : cartItems) {
                System.out.println(product.getName() + " - " + product.getPrice());
            }
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите название товара для удаления: ");
            String productName = scanner.nextLine();
            Product productToRemove = null;
            for (Product product : cartItems) {
                if (product.getName().equalsIgnoreCase(productName)) {
                    productToRemove = product;
                    break;
                }
            }
            if (productToRemove != null) {
                cart.removeItem(productToRemove);
                System.out.println("Товар успешно удален из корзины.");
            } else {
                System.out.println("Товар не найден в корзине.");
            }
        }
    }

    private void displayProducts() {
        List<Product> products = productCatalog.getAllProducts();
        for (Product product : products) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }
// Метод displayProducts() - выводит список всех товаров с их названиями и ценами.

    private void filterProducts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя производителя");
        String manufacturerName = scanner.nextLine();
        List<Product> filteredProducts = productCatalog.getProductsByManufacturer(manufacturerName);
        for (Product product : filteredProducts) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }
// Метод  логики фильтрации товаров

    private void addToCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название товара: ");
        String productName = scanner.nextLine();
        Product product = productCatalog.findProductByName(productName);

        if (product != null) {
            cart.addItem(product);
            System.out.println("Товар добавлен в корзину.");
        } else {
            System.out.println("Товар не найден.");
        }
    }

    // Метод addToCart() запрашивает у пользователя название товара, находит его в ProductCatalog и добавляет в Cart.
    private void checkout() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Корзина пуста. Добавьте товары в корзину перед оформлением заказа.");
            return;
        }
        currentOrder = cart.checkout();
        currentOrder.setOrderId(nextOrderId);
        nextOrderId++;
        System.out.println("Заказ оформлен. Номер вашего заказа: " + currentOrder.getOrderId());
    }
    // метод checkout() оформляет заказ из Cart и сохраняет его в currentOrder.

    private void trackOrderStatus() {
        if (currentOrder == null) {
            System.out.println("У вас нет текущего заказа.");
            return;
        }
        System.out.println("Статус вашего заказа: " + currentOrder.getStatus());
    }
    // метод trackOrderStatus() выводит текущий статус заказа из currentOrder.

    private void cancelOrder() {
        if (currentOrder == null) {
            System.out.println("У вас нет текущего заказа для отмены.");
            return;
        }

        OrderStatus status = currentOrder.getStatus();

        if (status == OrderStatus.NEW) {
            currentOrder.setStatus(OrderStatus.CANCELLED);
            System.out.println("Заказ успешно отменен.");
        }
    }

}



