package org.example;

import java.util.List;

public interface ProductFilter {
    List<Product> filterByKeyword(String keyword);
    List<Product> filterByPriceRange(int minPrice, int maxPrice);
    List<Product> filterByManufacturer(String manufacturer);
}
