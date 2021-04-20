import java.awt.*;

public class E2_5 {
    public static void main(String[] args) {
        Rectangle test1 = new Rectangle(0, 0, 42, 1);
        Rectangle test2 = new Rectangle(0, 0, 20, 1);
        System.out.printf("Area: %.1f%n", test1.getHeight() * test1.getWidth());
        System.out.printf("Perimeter: %.1f%n", (test2.getHeight() + test2.getWidth()) * 2);
    }
}
