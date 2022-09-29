import java.util.HashSet;
import java.util.PriorityQueue;

public class Interview17_09_getKthMagicNumber {

    /**
     * 面试题 17.09. 第 k 个数
     * https://leetcode.cn/problems/get-kth-magic-number-lcci/
     * 力扣又是一道不说人话的题，就是说，一个数，他只能由3，5，7的乘法运算得到(1是例外)，
     * 让你按从小到大顺序求出第k个数是多少。所以思路呼之欲出，
     * 先是1*3 1*5 1*7 再是 3*3 3*5 3*7 然后5*3 5*5 5*7
     * 反正怎么写都可以，组合写法，动态规划，注意重复
     */
    public static int getKthMagicNumber1(int k) {
        int[] factors = new int[] {3, 5, 7};
        int count = 0;
        //准备一个小根堆
        PriorityQueue<Long> heap = new PriorityQueue<>();
        //准备一个哈希表用来去重
        HashSet<Long> set = new HashSet<>();
        heap.add(1L);
        set.add(1L);
        int res = 0;
        while (count != k) {
            // 取出堆顶元素 x，则 x 是堆中最小的数，
            long cur = heap.poll(); // Long --> long
            res = (int) cur; // long --> int
            count++;
            // 由于 3x, 5x, 7x 也是符合要求的数，因此将 3x, 5x, 7x加入堆
            for (int factor : factors) {
                Long m = factor * cur;
                if (!set.contains(m)) { //去重
                    set.add(m);
                    heap.add(m);
                }
            }
        }
        return res;
    }


    /**
     * 暴力，会超时
     */
    public static int getKthMagicNumber2(int k) {
        int n = 1;
        int count = 0;
        while (true) {
            int divisor = 2;
            boolean flag = true;
            while (divisor <= n) { //检查n 是不是素因子只有 3，5，7
                if (n % divisor == 0) { //说明divisor 是因子
                    boolean isPrime = true;
                    for (int i = 2; i < divisor; i++) { //判断 divisor 是否是素数
                        if (divisor % i == 0) {
                            isPrime = false;
                        }
                    }
                    if (isPrime) { //divisor 是素因子
                        if (divisor == 3 || divisor == 5 || divisor == 7) {
                            divisor++;
                            continue;
                        } else { //包含其他素因子，如11
                            flag = false;
                        }
                    }
                }
                divisor++;
            }
            if (flag) {
                count++;
            }
            if (count == k) {
                return n;
            }
            n++;
        }
    }

    public static void main(String[] args) {
        int kthMagicNumber1 = getKthMagicNumber1(5);
        int kthMagicNumber2 = getKthMagicNumber2(5);
        System.out.println("kthMagicNumber1 = " + kthMagicNumber1);
        System.out.println("kthMagicNumber2 = " + kthMagicNumber2);
    }
}
