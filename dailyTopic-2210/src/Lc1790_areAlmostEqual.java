public class Lc1790_areAlmostEqual {

    /*
    1790. 仅执行一次字符串交换能否使两个字符串相等
     */
    public static boolean areAlmostEqual(String s1, String s2) {
        int N = s1.length();
        int notEqualCount = 0;
        int[] indexArr = new int[2];
        for (int i = 0; i < N; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            } else if (notEqualCount < 2) { //不相等 并且加上这个不相等的此时不相等总数 <= 2
                indexArr[notEqualCount++] = i;
            } else { //不相等 并且加上这个不相等的，此时不相等总数 > 2
                return false;
            }
        }
        if (notEqualCount == 0) return true;
        if (notEqualCount == 1) return false;
        // 此时 肯定有两个不相等的，下标分别是 indexArr[0] indexArr[1]
        if (s1.charAt(indexArr[0]) == s2.charAt(indexArr[1]) && s1.charAt(indexArr[1]) == s2.charAt(indexArr[0])) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "kelb";
        String s2 = "kelb";
        System.out.println("areAlmostEqual(s1, s2) = " + areAlmostEqual(s1, s2));
    }
}
