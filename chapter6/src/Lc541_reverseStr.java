import java.util.Arrays;

public class Lc541_reverseStr {

    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     *
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length/(2*k); //n记录有多少个2k区间
        int start = 0;
        int end = 0 + k - 1;
        for (int i = 0; i < n; i++) {
            reverse(arr,start,end);
            start+=(2*k);
            end+=(2*k);
        }
        //循环结束后剩下的区间长度<2k
        start = 2*n*k; //剩下的区间的左下标
        if ((arr.length - start >= k)) {
            reverse(arr, start, start + k - 1);
        } else {
            reverse(arr, start, arr.length - 1);
        }
        String s1 = new String(arr);
        return s1;
    }

    public static void reverse(char[] s, int start, int end) {
        //双指针
        int left = start;
        int right = end;
        while (left < right) {
            char ch = s[left];
            s[left] = s[right];
            s[right] = ch;
            left++;
            right--;
        }

    }

    public static void main(String[] args) {
        String s = reverseStr("asdfghjkl", 3);
        System.out.println("s = " + s);
    }
}
