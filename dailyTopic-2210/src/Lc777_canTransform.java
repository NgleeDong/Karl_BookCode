public class Lc777_canTransform {


    /**
     * lc777. 在LR字符串中交换相邻字符
     */
    /*
    根据题意，我们每次移动要么是将 XL 变为 LX，要么是将 RX 变为 XR，
    而该两者操作可分别看做将 L 越过多个 X 向左移动，将 R 越过多个 X 向右移动。
     */
    public static boolean canTransform(String start, String end) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }
                char c = start.charAt(i);
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        /*
        如果 i 和 j 中有一个下标大于等于 n，则有一个字符串已经遍历到末尾，
        继续遍历另一个字符串中的其余字符，如果其余字符中出现非 X 的字符，则该字符不能与任意字符匹配，返回false
         */
        while (i < n) {
            if (start.charAt(i) != 'X') {
                return false;
            }
            i++;
        }
        while (j < n) {
            if (end.charAt(j) != 'X') {
                return false;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
//        boolean canTransform = canTransform("RXXLRXRXL", "XRLXXRRLX");
//        System.out.println("canTransform = " + canTransform);
        boolean canTransform = canTransform("X", "L");
        System.out.println("canTransform = " + canTransform);
    }
}
