import java.awt.*;

public class E2_6 {
    public static void main(String[] args) {
        Rectangle box = new Rectangle(5, 10, 20, 30);
        box.add(0, 0);
        System.out.println("True location: " + box.getLocation());
        System.out.println("Expected location: (5, 10)");
        System.out.println("True width: " + box.getWidth());
        System.out.println("True height: " + box.getHeight());
    }
}
