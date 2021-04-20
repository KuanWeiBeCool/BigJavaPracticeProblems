public class E2_1 {
    public static void main(String[] args) {
        String testString = "Mississippi";
        String testString2 = testString.replace("i", "ii");
        System.out.println(testString2);
        System.out.println(testString2.length());
        String testString3 = testString2.replace("s", "ss");
        System.out.println(testString3);
        System.out.println(testString3.length());

    }
}
