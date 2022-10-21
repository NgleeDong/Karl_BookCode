import java.util.Stack;

public class Lc901_OnlineStockSpan {

    /*
    901. 股票价格跨度
    今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）
     */

    /**
     * 即：寻找某个数 左边离他近的比他大的数， 计算二者之间的距离即可
     * 当我们寻找 寻找某个数 左边离他近的比他大的数 和 右边离他近的比它大的，可以用 单调栈！
     * 那么栈中放什么呢？
     * 放一个pair {下标，值}，认为规定，第一个数下标是0
     */

    Stack<int[]> stack;
    int index;


    public Lc901_OnlineStockSpan() { //构造函数
        stack = new Stack<>();
        stack.push(new int[] {-1, Integer.MAX_VALUE});//维护一个底->顶（大->小)的栈
        index = 0;
    }

    public int next(int price) {
        //当前的值比栈顶的小，直接放入栈中，并返回它的信息（和左边离他近的比他大的数之间的距离
        if (price < stack.peek()[1]) {
            int res = index - stack.peek()[0];
            stack.push(new int[] {index++, price});
            return res;
        } else { //当前的值比栈顶的大
            while (stack.peek()[1] <= price) { //弹，直到当前的值比栈顶小
                stack.pop();
            }
            //统计
            int res = index - stack.peek()[0];
            stack.push(new int[] {index++, price});
            return res;
        }
    }

}
