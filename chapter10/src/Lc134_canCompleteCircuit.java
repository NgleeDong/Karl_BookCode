public class Lc134_canCompleteCircuit {

    //贪心
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                start = i + 1; //把起始位置设为当前位置+1
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;//总油量-总消耗 < 0，说明不可能走一圈了
        return start;
    }

    //暴力循环
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            //记录剩余的油量
            int rest = gas[i] - cost[i];//此时相当于从i开始消耗了cost[i]升汽油到达了i+1位置
            int index = (i + 1) % gas.length;
            while (rest > 0 && index != i) {
                rest += gas[index] - cost[index]; //到了加油站 加油并继续消耗汽油往下一站
                index = (index + 1) % gas.length;
            }
            if (rest >= 0 && index == i) {
                return i; //说明转了一圈可以回到出发点
            }
        }
        return -1;
    }
}
