package seminars.first.Shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        // Допишите реализацию метода самостоятельно
        List<Product> sortProducts = new ArrayList<>(products);
        sortProducts.sort((a, b) -> a.getCost() - b.getCost());
        return sortProducts;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        return sortProductsByPrice().get(sortProductsByPrice().size() - 1);
    }

}