public class Lc738_monotoneIncreasingDigits {

    /**
     * lc738. 单调递增的数字
     * @param n 给定一个整数 n
     * @return 返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
     *      从右向左扫描数字，若发现当前数字比其左边一位（较高位）小，
     *      则把其左边一位数字减1，并将该位及其右边的所有位改成9
     */
    public int monotoneIncreasingDigits(int n) {
        //把数字转化为字符数组，方便处理
        char[] array = String.valueOf(n).toCharArray();
        int flag = array.length;// flag用来标记赋值9从哪里开始
        //从后往前遍历
        for (int i = array.length - 1; i >= 1; i--) {
            if (array[i] < array[i - 1]) {
                flag = i;
                array[i - 1]--;
            }
        }

        for (int i = flag; i < array.length; i++) {
            array[i] = '9';
        }
        return Integer.parseInt(new String(array));
    }
}
