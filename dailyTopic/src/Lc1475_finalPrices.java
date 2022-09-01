import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Lc1475_finalPrices {

    /**
     * 1475. 商品折扣后的最终价格
     */

    public static int[] finalPrices(int[] prices) {
        return fun2(prices);
    }

    //方法二：单调栈（只统计右边的即可，有重复值,且相等也可以）
    public static int[] fun2(int[] prices) {
        //准备一个栈，作为单调栈,存储的是下标,且保证栈：栈底（小） -> 栈顶（大）
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            //这个数比栈顶所代表的的值小，或这个数等于栈顶所代表的的值,都要统计信息
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                //弹栈，并更新信息
                Integer popIndex = stack.pop();
                prices[popIndex] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }

    //方法一：双循环
    public int[] fun1(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] < prices[i]) { //只要遇到了第一个比它小的
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    public static void main(String[] args) {
//        int[] prices = {8,7,4,2,8,1,7,7,10,1};
        int[] prices = {8,4,6,2,3};
        int[] finalPrices = finalPrices(prices);
        System.out.println("finalPrices = " + Arrays.toString(finalPrices));
    }
}
