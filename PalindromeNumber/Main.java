package PalindromeNumber;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int number = 121;
        boolean result = palindromeSolution2(number);
        System.out.println("The number "+ number + " is a palindrome: " + result);

    }

    public static boolean palindromeSolution1(int x){
        if(x < 0){
            return false;
        }
        String numberString = String.valueOf(x);
        String reverseNumberString = new StringBuilder(numberString).reverse().toString();
        if(numberString.equalsIgnoreCase(reverseNumberString)){
            return true;
        }
        return false;
    }

    public static boolean palindromeSolution2(int x){
        if(x < 0){
            return false;
        }
        long reversed = 0;
        long temp = x;

        while (temp != 0) {
            int digit = (int) temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
        return (reversed == x);
    }
}