public class Lc474_findMaxForm {

    /**
     * lc474. 一和零
     * https://leetcode.cn/problems/ones-and-zeroes/
     */


    /**
     * 方法一：递归  会超时
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        int N = strs.length;
        int[] mArr = new int[N];
        int[] nArr = new int[N];
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            int mNum = 0;
            int nNum = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    mNum++;
                } else {
                    nNum++;
                }
            }
            mArr[i] = mNum;
            nArr[i] = nNum;
        }
        return process(strs, 0, m, n, mArr, nArr);
    }

    public static int process(String[] strs, int index, int restm, int restn, int[] mArr, int[] nArr) {
        if (index == strs.length) {
            return  (restm >= 0 && restn >= 0) ? 0 : -1;
        }
        //选这个
        int p1 = 0;
        int next = process(strs, index + 1, restm - mArr[index], restn - nArr[index], mArr, nArr);
        if (next != -1) {
            p1 = next + 1;
        }
        //不选这个
        int p2 = 0;
        int next1 = process(strs, index + 1, restm, restn, mArr, nArr);
        if (next1 != -1) {
            p2 += next1;
        }
        return Math.max(p1, p2);
    }

    /**
     * 方法二：动态规划
     * 可变参数： index， used
     * index： 0~N
     * used：0~N
     */
    public static int dp(String[] strs, int m, int n) {
        return 0;
    }



    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println("findMaxForm(strs, 5, 3) = " + findMaxForm(strs, 5, 3));

        String[] test = {"0","11","1000","01","0","101","1","1","1","0","0","0","0","1","0","0110101","0","11","01","00","01111","0011","1","1000","0","11101","1","0","10","0111"};
        System.out.println("findMaxForm(test, 9, 80) = " + findMaxForm(test, 9, 80));

    }
}
