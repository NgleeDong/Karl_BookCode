import java.util.Arrays;

public class Lc459_repeatedSubstringPattern {

    /*
    有错误
    错误的原因是next数组的构造出现了问题
    如：按照左程云老师在KMP算法那一节讲的next数组的构造方式
        abab的next数组是[-1,0,0,1]
    而abac的next数组也是[-1,0,0,1]

     */

    public static boolean repeatedSubstringPattern(String s) {
        char[] ss = s.toCharArray();
        int[] next = getNextArray(ss);
        System.out.println(Arrays.toString(next));
        int i = next.length - 1;
        while (next[i] > 1 && next[i] - 1 == next[i-1]) {
            i--;
        }
        return next[i] == 1 ? true : false;
    }


    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] {-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos] = 0;
                pos++;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcdeabcdeabcde";
        String str1 = "aba";
        String str2 = "ababab";
        String str3 = "ababac";
        System.out.println(repeatedSubstringPattern(str1));
    }
}
