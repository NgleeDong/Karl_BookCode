public class Interview01_09_isFlipedString {

    /**
     * 面试题 01.09. 字符串轮转
     * https://leetcode.cn/problems/string-rotation-lcci/
     */
    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        String str = s1 + s1;
        if (str.contains(s2)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isFlipedString1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        int N = s1.length();
        //假设s1轮转 i 位，则 s2 j 的位置 对应 s1 (i+j) mod n的位置 !!!!!!!!!
        for (int i = 0; i < N; i++) { //假设s1轮转 i 位
            boolean flag = true;
            for (int j = 0; j < N; j++) {
                if (s1.charAt((i + j) % N) != s2.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        boolean flipedString = isFlipedString(s1, s2);
        System.out.println("flipedString = " + flipedString);
    }
}
