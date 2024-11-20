package SummerSales;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(200, 100, 150, 400, 300);
        int discount = 20;

        int total = SummerSales(prices, discount);
        System.out.println("Total: " + total);
    }

    public static int SummerSales(List<Integer> prices, int discount) {
        if (discount <= 0 || discount >= 100) {
            return 0;
        }
        if (prices.isEmpty()) {
            return 0;
        }
        for (int item : prices) {
            if (item <= 0 || item > 100000) {
                return 0;
            }
        }

        int maisCaroNaPromocao = 0;
        int total = 0;
        for (int item : prices) {
            if (item > maisCaroNaPromocao) {
                maisCaroNaPromocao = item;
            }
        }
        for (int item : prices) {
            if (item == maisCaroNaPromocao) {
                int desconto = (maisCaroNaPromocao / 100) * discount;
                item = maisCaroNaPromocao - desconto;
            }
            total = total + item;
        }

        return total;
    }
}