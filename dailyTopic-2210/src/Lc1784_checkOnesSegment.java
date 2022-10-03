public class Lc1784_checkOnesSegment {

    /**
     * lc1784. 检查二进制字符串字段
     */
    public static boolean checkOnesSegment(String s) {
        int N = s.length();
        int index = 0;
        while (index < N && s.charAt(index) == '1') {
            index++;
            continue;
        }
        if (index == N) { //只有1
            return true;
        }
        while (index < N) {
            if (s.charAt(index) == '0') {
                index++;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = checkOnesSegment("110000000000");
        System.out.println("b = " + b);
    }
}
