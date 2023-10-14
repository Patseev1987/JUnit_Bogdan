package seminars.first.homework;

import seminars.first.Calculator.Calculator;
import seminars.first.Shop.ShopTest;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Price is %.2f", Calculator.calculatingDiscount(100, 10));

        // TASK 2 --------------------

        ShopTest.checkSortedProductList();
        ShopTest.checkMostExpensiveProduct();
        ShopTest.checkBasket();
    }
}
