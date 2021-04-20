import java.awt.*;

public class E2_3 {
    public static void main(String[] args) {
        Rectangle test = new Rectangle(10, 10, 20, 20);
        double area = test.getHeight() * test.getWidth();
        System.out.printf("Test value: %.3f%n", area);
        System.out.println("Expected value: 400.00");
        
    }
}
