import java.util.Arrays;

public class Lc647_countSubstrings {

    /*
    lc647. 回文子串
     */

    /**
     * 暴力循环 + 判断 ，可以Ac
     * 执行用时 367 ms, 在所有 Java 提交中击败了5.01%的用户
     */
    public static int countSubstrings(String s) {
        int N = s.length();
        int count = 0;
        for (int i = 0; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (isPalindrome(s.substring(i, j)) == true) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    //=============================================================

    /**
     * 方法二：Manacher算法
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.92%的用户
     */
    public static int countSubstrings1(String s) {
        //将字符串转化为处理串
        char[] strArr = new char[2 * s.length() + 1];
        int index = 0;
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = (i & 1) == 0 ? '#' : s.charAt(index++);
        }
        System.out.println("Arrays.toString(pArr) = " + Arrays.toString(strArr));
        //Manacher算法的核心
        int[] pArr = new int[strArr.length]; //回文半径数组
        int C = -1; //中心
        int R = -1; //当前扩出来的最右边界 的下一个位置
        for (int i = 0; i < strArr.length; i++) {
            //i位置至少的回文区域
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < strArr.length && i - pArr[i] > -1) {
                if (strArr[i + pArr[i]] == strArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
        }
        System.out.println("Arrays.toString(pArr) = " + Arrays.toString(pArr));
        //统计
        int count = 0;
        for (int i = 0; i < pArr.length; i++) {
            //只统计原串的
            if (pArr[i] - 1 > 0) {   //pArr[i] - 1 是对应原串的回文串长度
                //当前贡献为 (pArr[i] - 1) / 2 上取整, 即pArr[i] / 2
                count += pArr[i] / 2;
            }
        }
        return count;

    }


    public static void main(String[] args) {
        String str = "aaa";
        int i = countSubstrings1(str);
        System.out.println("i = " + i);
    }



}
