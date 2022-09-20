import java.util.Arrays;

public class Lc2305_distributeCookies {

    /**
     * lc2305. 公平分发饼干
     */

    public int ans = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        //准备k个桶
        int[] bucket = new int[k];
        //排序：降序排列，增加剪枝的命中率
        Arrays.sort(cookies);
        int left = 0, right = cookies.length - 1;
        while (left < right) {
            int temp = cookies[left];
            cookies[left] = cookies[right];
            cookies[right] = temp;
            left++;
            right--;
        }
        process(cookies, 0, bucket);
        return ans;
    }

    public void process(int[] cookies, int index, int[] bucket) {
        if (index == cookies.length) {
            // 记录一次划分中的最大值
            int max = 0;
            for (int b : bucket) {
                max = Math.max(max, b);
            }
            // 记录所有划分中最大值的最小值 (有点绕！！)
            ans = Math.min(ans, max);
            return ;
        }
        // 计算空桶数量
        int empty = 0;
        for (int b : bucket) {
            if (b == 0) empty++;
        }
        // 剪枝一：为了保证每个桶中至少有一个球，所以如果还剩 n 个空桶，但剩余球的数量小于 n，可直接跳过
        if (empty > cookies.length - index) return ;
        for (int i = 0; i < bucket.length; i++) {
            // 剪枝二：对于第一个球，任意放到某个桶中的效果都是一样的，所以我们规定放到第一个桶中
            if (i > 0 && index == 0) return ;
            // 剪枝三：如果当前桶和上一个桶内的元素和相等，则跳过。
            // 原因：如果元素和相等，那么当前球选择上一个桶和选择当前桶可以得到的结果是一致的
            if (i > 0 && bucket[i] == bucket[i - 1]) continue;
            // 剪枝四：如果桶中球的大小已经超过了最小值，则肯定不是最优解，可直接跳过
            if (bucket[i] + cookies[index] > ans) continue;
            //处理
            bucket[i] += cookies[index];
            //递归：处理下一个球
            process(cookies, index + 1, bucket);
            //回溯
            bucket[i] -= cookies[index];
        }
    }
}
