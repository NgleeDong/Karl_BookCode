/**
 * 面试题 01.02. 判定是否互为字符重排
 * https://leetcode.cn/problems/check-permutation-lcci/
 */
public class Interview01_02_CheckPermutation {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[] nums = new int[26];//下标0-25，记录每个字母出现的次数,初始全为0
        for (int i = 0; i < str1.length; i++) {
            nums[str1[i] - 'a']++;
        }
        for (int i = 0; i < str2.length; i++) {
            nums[str2[i] - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
