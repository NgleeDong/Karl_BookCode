public class Lc1642_maxLengthBetweenEqualCharacters {

    /**
     * lc1624. 两个相同字符之间的最长子字符串
     */
    public static int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1;
        char[] strArr = s.toCharArray();
        for (int i = 0; i < strArr.length - 1; i++) {
            for (int j = strArr.length - 1; j > i ; j--) {
                if (strArr[i] == strArr[j]) { //找到了两个相同字符，且此时他们是最远的
                    maxLength = Math.max(maxLength,j - i - 1);
                    break;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int maxLengthBetweenEqualCharacters = maxLengthBetweenEqualCharacters("cabbac");
        System.out.println("maxLengthBetweenEqualCharacters = " + maxLengthBetweenEqualCharacters);
    }
}
