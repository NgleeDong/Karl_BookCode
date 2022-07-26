public class Lc28_strStr_KMP {

    /**
     * 实现strStr()函数。
     * 给你两个字符串haystack 和 needle ，
     * 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
     * 说明：
     * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
     *
     */

    /**
     * 暴力解法：尝试每一个字符开头，能否匹配出str2
     * 最差情况：
     * str1：11111111111111111111111112
     * str2：1112
     * 每次匹配到str2最后才能确定某个位置开头不一样
     * O(m * n)的复杂度
     */
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() < 1) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        //解法一：普通解法
        char[] arr1 = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            int arr1Index = i;
            int arr2Index = 0;
            while (arr1Index < arr1.length && arr2Index < arr2.length) { //均未越界的情况下
                if (arr1[arr1Index] == arr2[arr2Index]) {
                    arr1Index++;
                    arr2Index++;
                } else {
                    break;
                }
            }
            if (arr2Index == arr2.length) { //arr2Index越界了，说明已经完全匹配了
                return i;
            }
            //否则继续循环
        }
        return -1;//没找到
    }

    //解法二：KMP算法
    public static int getIndex(String s,String m) {
        if (s == null || m == null ) {
            return 0;
        }
        if (m.length() < 1 || s.length() < m.length()) {
            return  -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int[] next = getNextArray(ms);//O(M) 关于str2的next数组
        int si = 0;
        int mi = 0;
        //O(N)
        while (si < ss.length && mi < ms.length) { //均未越界的情况下
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) { //也可以写成 mi == 0, 即mi没有办法再往前跳了
                si++; //str1换个开头吧
            } else { // mi 没到0位置，可以往前跳
                mi = next[mi]; //si不动， mi跳到前缀的下一个位置
            }
        }
        // si越界 或者 mi越界
        // mi越界 代表某个数开头配出了str2
        return mi == ms.length ? si - mi : -1;
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
        String str1 = "hello";
        String str2 = "ll";
        System.out.println(getIndex(str1,str2));
    }
}
