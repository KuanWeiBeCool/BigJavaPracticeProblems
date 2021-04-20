import java.awt.*;

public class E2_4 {
    public static void main(String[] args) {
        Rectangle test = new Rectangle(10, 10, 20, 20);
        double perimeter = (test.getHeight() + test.getWidth()) * 2;
        System.out.printf("Test value: %.3f%n", perimeter);
        System.out.println("Expected value: 80.00");
    }
}
