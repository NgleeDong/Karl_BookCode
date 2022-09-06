import java.util.*;

public class Lc828_uniqueLetterString {
//
//    static StringBuilder sb = new StringBuilder();
//    static int count = 0;
//    static boolean isDeep = false;
//
//    public static void process(char[] arr,int startIndex) {
//        //base case
//        if (startIndex >= arr.length) {
//            return;
//        }
//        //for循环横向遍历
//        for (int i = startIndex; i < arr.length; i++) {
//            if (sb.length() < 1) {
//                isDeep = false;
//            }
//            if (isDeep == true) continue; //若isDeep为true，则pass
//            //处理
//            sb.append(arr[i]);
//            count += countUniqueChars(sb.toString());
//            System.out.println("count = " + count);
//            //递归 纵向遍历
//            process(arr, i + 1);
//            //回溯
//            sb.deleteCharAt(sb.length() - 1);
//            isDeep = true;
//        }
//    }
//
//    public static int countUniqueChars(String s) {
//        //返回s只出现一次的个数
//        int repeat = 0;
//        Set<Character> set = new HashSet<>();
//        char[] chars = s.toCharArray();
//        for (char c : chars) {
//            if (set.contains(c)) { //已经有了，说明它是重复的
//                repeat++;
//            } else {
//                set.add(c);
//            }
//        }
//        return set.size() - repeat;
//    }
//
//

    /**
     * Lc828. 统计子串中的唯一字符(hard)
     * @param s
     * @return
     */
    public static int uniqueLetterString(String s) {
        Map<Character, List<Integer>> index = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<Integer>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int num = uniqueLetterString("LEETCODE");
        System.out.println("num = " + num);
    }
}
