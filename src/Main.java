import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Pairs> products = new ArrayList<>();
        products.add(new Pairs("A", 55));
        products.add(new Pairs("B", 20));
        products.add(new Pairs("C", 60));
        products.add(new Pairs("D", 10));
        products.add(new Pairs("E", 45));

        System.out.println("Termékek:");
        for (Pairs product : products) {
            System.out.println(product.getName() + " - " + product.getPrice() + " Ft");
        }

        System.out.print("Kérlek, add meg a kívánt termékeket: ");
        String input = scanner.nextLine();
        String[] selectedProducts = input.split("");// .split(" ") esetén csak a rendes inputot látja pl. DE hibát dob
        System.out.println("Fizetendő összeg: " + Calculator.calculatePrice(products, selectedProducts) + " Ft");

        scanner.close();
    }
}
