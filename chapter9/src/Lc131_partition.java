import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Lc131_partition {

    /**
     * lc131 分割回文串
     */

    List<List<String>> result = new ArrayList<>();
    Deque<String> path = new LinkedList<>();

    public void process(String s, int startIndex) {
        //base case
        //如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //处理节点
            String str = s.substring(startIndex, i + 1);//当前割的子串
            //如果是回文，则记录
            if (isPalindrome(str)) {
                path.addLast(str);
            } else {
                continue;
            }
            //递归
            process(s, i + 1);
            //回溯
            path.removeLast();
        }
    }

    //判断是否是回文串
    public boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        process(s, 0);
        return result;
    }
}
