package romanToInteger;

public class Main {
    public static void main(String[] args) {
        String romanLetters = "MCMXCIV";
        int total = RomanToIntegerConvert(romanLetters);
        System.out.println("The Roman letters: " + romanLetters + " is equal to: " + total);
    }

    public static int RomanToIntegerConvert(String s) {
        Integer prevValue = null;
        int totalValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int value = charToValue(c);
            if (prevValue != null && prevValue > value) {
                totalValue -= value;
            } else {
                totalValue += value;
            }
            prevValue = value;
        }
        return totalValue;
    }

    public static int charToValue(char c) {
        return switch (c) {
            case 'M' -> 1000;
            case 'D' -> 500;
            case 'C' -> 100;
            case 'L' -> 50;
            case 'X' -> 10;
            case 'V' -> 5;
            case 'I' -> 1;
            default -> throw new IllegalArgumentException("bad char");
        };
    }

}