public class E2_2 {
    public static void main(String[] args) {
        String testString = "  white space  ";
        System.out.printf("This is before trim: %s%n", testString);
        System.out.printf("This is after trim: %s%n", testString.trim());
        System.out.printf("This is with replace method: %s%n", testString.replace(" ", ""));
    }
}
