package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;
    private List<Product> addedItems;

    public Cart(List<Product> items) {
        this.items = items;
        this.addedItems = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }
    // Метод addItem() добавляет товар в корзину. Он принимает объект Product в качестве параметра
    // и добавляет его в список items.

    public void removeItem(Product product) {
        items.remove(product);
    }
// Метод removeItem() удаляет товар из корзины, принимает объект Product в качестве параметра и удаляет его из списка items

    public void clearCart() {
        items.clear();
    }
// Метод clearCart() очищает корзину, удаляя все товары из списка items.

    public List<Product> getItems() {
        return items;
    }
// Метод getItems() возвращает список товаров в корзине.

    public List<Product> getAddedItems() {
        return addedItems;
    }

    public Order checkout() {
        Order order = new Order(addedItems);
        clearCart();
        return order;
    }
// Метод checkout() оформляет заказ, создавая новый объект класса Order на основе товаров в корзине.
// Затем он очищает корзину, используя метод clearCart(), и возвращает созданный заказ.
}
