package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog implements ProductFilter, ProductSearch {
    private List<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProductsByManufacturer(String manufacturerName) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getManufacturer().equals(manufacturerName)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    @Override
    public List<Product> filterByKeyword(String keyword) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(keyword) || product.getManufacturer().contains(keyword)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
//    Метод filterByKeyword фильтрует товары по ключевым словам. Он проходит по всем товарам в списке и добавляет только те
// товары в названии или производителе которых содержится указанное ключевое слово.

    @Override
    public List<Product> filterByPriceRange(int minPrice, int maxPrice) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
//    Метод filterByPriceRange() фильтрует товары по ценовому диапазону. Он проходит по всем товарам в списке и добавляет
// те товары, цена которых находится в указанном диапазоне (включая минимальную и максимальную цену).

    @Override
    public List<Product> filterByManufacturer(String manufacturer) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getManufacturer().equals(manufacturer)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
//    Метод filterByManufacturer() фильтрует товары по производителю. Он проходит по всем товарам в списке и
//    добавляет те товары, которые произведены указанным производителем.

    @Override
    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }
}


