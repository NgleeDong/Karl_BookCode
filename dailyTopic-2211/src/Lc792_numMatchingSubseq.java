import java.util.ArrayList;
import java.util.List;

public class Lc792_numMatchingSubseq {

    /*
    792. 匹配子序列的单词数
     */

    /**
     * 存储字母的下标+二分
     */
    public static int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        //存储字母的下标
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }
        int res = words.length;
        for (String word : words) {
            if (word.length() > s.length()) { //剪枝
                res--;
                break;
            }
            int p = -1;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (pos[c - 'a'].isEmpty() || pos[c - 'a'].get(pos[c - 'a'].size() - 1) <= p) {
                    res--;
                    break;
                }
                p = binarySearch(pos[c - 'a'], p);
            }
        }
        return res;
    }

    public static int binarySearch(List<Integer> list, int target) {
        int L = 0;
        int R = list.size() - 1;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (list.get(mid) > target) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return list.get(L);
    }

    /**
     * 暴力方法
     * 超出时间限制
     */
    public int numMatchingSubseq1(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            int i = 0;
            int j = 0;
            while (i != word.length() && j != s.length()) {
                if (word.charAt(i) == s.charAt(j)) {
                    i++;
                    j++;
                    if (i == word.length()) res++; //说明此时匹配上了
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
