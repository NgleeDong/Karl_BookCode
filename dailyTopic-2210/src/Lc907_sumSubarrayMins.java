import java.util.Stack;

public class Lc907_sumSubarrayMins {

    /*
    lc907. 子数组的最小值之和

    给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。

    由于答案可能很大，因此 返回答案模 10^9 + 7 。

     */

    /**
     * 思路一：
     * 维护一个双指针，i是子数组开头，j是子数组结尾
     * ans每次加上子数组中的最小值
     * 复杂度O(n^2) 在lc跑会超时
     */
    public static int sumSubarrayMins1(int[] arr) {
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int curMin = arr[i];
            for (int j = i; j < arr.length; j++) {
                curMin = Math.min(curMin, arr[j]);
                ans += curMin;
            }
        }
        return (int) (ans % (1e9 + 7));
    }


    /**
     * 方法二：单调栈
     * 某个数 找 左边离他最近的比他小的 右边离他最近的比他小的
     * 两个位置之间 数的个数 * 这个数 就是这个数对总结果的贡献值
     */
    public static int sumSubarrayMins2(int[] arr) {
        long ans= 0;
        long mod = 1000000007;
        //先假设数组中没有重复元素
        Stack<Integer> stack = new Stack<>();//栈中存放的是下标
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int index = stack.pop();
                int cur = arr[index];
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();//左边离他最近的比他小的下标
                int rightIndex = i;//右边离他最近的比他小的下标
                ans += (long) (cur * (index - leftIndex) * (rightIndex - index));
            }
            stack.push(i);
        }
        //收集栈中的信息
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int cur = arr[index];
            int leftIndex = stack.isEmpty() ? -1 : stack.peek();//左边离他最近的比他小的下标
            int rightIndex = arr.length;//右边离他最近的比他小的下标
            ans += (long) (cur * (index - leftIndex) * (rightIndex - index));
        }
        return (int)(ans % mod);
    }




    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        System.out.println("sumSubarrayMins(nums) = " + sumSubarrayMins1(nums));
        System.out.println("sumSubarrayMins(nums) = " + sumSubarrayMins2(nums));
        //System.out.println("444 % ( 10 ^ 9 + 7) = " + 444 % ( 10e9 + 7));
    }

}
