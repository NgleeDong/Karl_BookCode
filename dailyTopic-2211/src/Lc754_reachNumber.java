import java.util.Arrays;

public class Lc754_reachNumber {

    /*
    754. 到达终点数字

    在一根无限长的数轴上，你站在0的位置。终点在target的位置。

    你可以做一些数量的移动 numMoves :
        每次你可以选择向左或向右移动。
        第 i次移动（从 i == 1开始，到i == numMoves ），在选择的方向上走 i步。

    给定整数target ，返回 到达目标所需的 最小移动次数(即最小 numMoves )。

    测试用例：
    输入: target = 2
    输出: 3
    解释:
    第一次移动，从 0 到 1 。
    第二次移动，从 1 到 -1 。
    第三次移动，从 -1 到 2 。
     */


    /**
     * 从1到N一直累加, 直到SUM==TARGET, 或SUM减TARGET为正偶数.
     * 因为在第n步往回走一次,SUM就会减少2n, 所以他们的差必须是偶数才能到.
     */
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0;
        int steps = 0;
        while (sum < target || ((sum - target) & 1) == 1) { // 没有到达终点，或者相距奇数
            steps++;
            sum += steps;
        }
        return steps;
    }

}
