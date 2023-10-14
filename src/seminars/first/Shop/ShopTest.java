package seminars.first.Shop;


import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
    private static Shop shop = new Shop();
    private static Product oranges = new Product();
    private static Product bread = new Product();
    private static Product butter = new Product();
    private static Product knife = new Product();

    static {
        oranges.setCost(101);
        oranges.setTitle("Oranges");
        bread.setCost(70);
        bread.setTitle("Bread");
        butter.setCost(230);
        butter.setTitle("Butter");
        List<Product> bogdanProducts = new ArrayList<>();
        bogdanProducts.add(oranges);
        bogdanProducts.add(butter);
        bogdanProducts.add(bread);
        shop.setProducts(bogdanProducts);
    }

    public static void checkBasket() {

        assertThat(shop.getProducts()).isNotEmpty().hasSize(3).contains(butter, bread, oranges);
    }

    public static void checkMostExpensiveProduct() {
        int mostExpensivePrice = shop.getMostExpensiveProduct().getCost();
        int[] prices = new int[shop.getProducts().size()];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = shop.getProducts().get(i).getCost();
        }
        int expectedMaxPrice = Arrays.stream(prices).max().getAsInt();
        assert mostExpensivePrice == expectedMaxPrice : "This method doesn't give the most expensive product!";

    }

    public static void checkSortedProductList() {
        assert isSorted(shop.sortProductsByPrice());
    }

    private static boolean isSorted(List<Product> products) {
        for (int i = 0; i < products.size() - 1; i++) {
            if (products.get(i).getCost() > products.get(i + 1).getCost())
                return false;
        }
        return true;
    }

}