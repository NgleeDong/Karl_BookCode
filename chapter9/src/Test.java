import java.util.List;

public class Test {

    public static void main(String[] args) {
        String s = "adsdss";
        System.out.println("s = " + s);
        System.out.println("s.length() = " + s.length());
        StringBuilder stringBuilder = new StringBuilder(s);
        System.out.println("stringBuilder = " + stringBuilder);
        System.out.println("stringBuilder.length() = " + stringBuilder.length());

        List<String> list = new Lc93_restoreIpAddresses().restoreIpAddresses("101023");
        for (String s1 : list) {
            System.out.println("s1 = " + s1);
        }
    }


}
