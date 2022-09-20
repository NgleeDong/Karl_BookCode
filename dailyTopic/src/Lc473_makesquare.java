import java.util.Arrays;

public class Lc473_makesquare {

    /**
     * lc473. 火柴拼正方形
     */
    public boolean makesquare(int[] matchsticks) {
        //计算和
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }
        //是否能符合拼成正方形的条件
        if (sum % 4 != 0) return false;
        int N = 4; //代表四条边
        //计算边长
        int target = sum / N;
        //N条边
        int[] sideArr = new int[N];
        //排序：降序排列，增加剪枝的命中率
        Arrays.sort(matchsticks);
        int left = 0, right = matchsticks.length - 1;
        while (left < right) {
            int temp = matchsticks[left];
            matchsticks[left] = matchsticks[right];
            matchsticks[right] = temp;
            left++;
            right--;
        }
        return process(matchsticks, 0, target, sideArr);
    }

    public boolean process(int[] matchsticks, int index, int target, int[] sideArr) {
        //base case
        if (index == matchsticks.length) {
            return true;
        }
        //matchsticks[index]选择去哪条边
        for (int i = 0; i < 4; i++) { //i代表哪条边
            //优化
            if (i > 0 && index == 0) break ;//对于第一个球，任意放到某个边中的效果都是一样的，所以我们规定放到第一个桶中
            if (i > 0 && sideArr[i] == sideArr[i - 1]) continue;// 如果当前桶和上一个桶内的元素和相等，则跳过
            //剪枝
            if (sideArr[i] + matchsticks[index] > target) {
                //选择另一条边吧
                continue;
            }
            //处理：把当前火柴加入到当前边
            sideArr[i] += matchsticks[index];
            //递归:去判断下一条火柴吧
            if (process(matchsticks, index + 1, target, sideArr)) return true;
            //回溯:当前做的选择出了问题
            sideArr[i] -= matchsticks[index];
        }
        //某个火柴 哪条边都加不进去
        return false;
    }
}
