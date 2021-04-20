import java.util.Random;

public class E2_14 {
    public static void main(String[] args) {
        Random randomPrice = new Random();
        double price = 10.0 + randomPrice.nextDouble() * 9.95;
        System.out.println("$" + price);

    }
}
