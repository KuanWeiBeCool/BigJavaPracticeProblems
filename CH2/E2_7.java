public class E2_7 {
    public static void main(String[] args) {
        String test = "Mississippi";
        String newTest = test.replace("i", "!").replace("s", "$");
        System.out.println("Actual output: " + newTest);
        System.out.println("Expected output: M!$$!$$!pp!");
    }
}
