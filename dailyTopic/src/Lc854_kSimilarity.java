public class Lc854_kSimilarity {

    /**
     * lc854. 相似度为 K 的字符串
     */

    static int result = Integer.MAX_VALUE;

    public static int kSimilarity(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        process(s1Arr, s2Arr, 0, 0);
        return result;
    }

    public static void process(char[] s1, char[] s2, int startIndex, int curResult) {
        // base case
        if (curResult >= result) { // 如果"某种可能"当前的交换次数已经超过"到目前为止最小交换次数result"，终止递归
            return;
        }
        if (startIndex == s2.length - 1) {
            result = Math.min(curResult, result);
            return;
        }
        for (int i = startIndex; i < s2.length; i++) { //i指针控制 s2
            if (s2[i] != s1[i]) { //需要对 s1 进行字母交换的操作
                for (int j = i + 1; j < s1.length; j++) { //i指针控制 s1
                    if (s2[i] == s1[j]  && s1[j] != s2[j]) {
                        /*
                        为什么要加？  && s1[j] != s2[j] 加上这一句为什么性能会提升 60% ？？？
                         */
                        //交换
                        swap(s1, i, j);
                        //递归: 此时 i 和 j 交换的情况，往下给我计算去吧
                        process(s1, s2, startIndex + 1, curResult + 1);
                        //回溯
                        //为什么要回溯？ 因为i位置后面可能有好几个能交换的值，所以要回溯
                        swap(s1, i, j);
                    }
                }
                return;
                /*
                这里为什么要return ？？？
                 */
            }
        }

        /*
        这里为什么要更新？？？？
         */
        result = Math.min(curResult, result);
    }

    public static void swap(char[] str, int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        int kSimilarity = kSimilarity("abc", "bca");
        System.out.println("kSimilarity = " + kSimilarity);
    }

}
