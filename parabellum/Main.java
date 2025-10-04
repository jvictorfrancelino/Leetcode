package parabellum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            int breadth;
            int height;

            breadth = scanner.nextInt();
            height = scanner.nextInt();

            if(breadth <= 0 || height <= 0){
                System.out.println("java.lang.Exception: Breadth and height must be positive");
            }else {
                System.out.println(breadth * height);
            }
        } catch (Exception ex) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }finally {
            scanner.close();
        }
    }
}
