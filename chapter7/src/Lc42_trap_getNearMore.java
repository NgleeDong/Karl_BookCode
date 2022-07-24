import java.util.*;

public class Lc42_trap_getNearMore {

    /**
     * 接雨水扩展：利用单调栈求
     *  每个数左边离它最近且比大（小）的数，位置是啥？右边离它最近且比大（小）的数，位置是啥？
     *  参考：左程云中级班
     * @return 二维数组
     */
    public static int[][] getNearMore(int[] arr) {
        int N = arr.length;
        int[][] res = new int[N][2];
        // res[i][0]  i位置的数，左边离i最近，比arr[i]大的数，位置是啥
        // res[i][1]  i位置的数，右边离i最近，比arr[i]大的数，位置是啥

        //数组中可能有重复的
        //单调栈，存储的是下标，且对应的值： 栈底（大） -- > 栈顶（小）
        Stack<LinkedList<Integer>> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            //1、这个数比栈顶大
            while (!stack.isEmpty() && arr[stack.peek().get(0)]  < arr[i]) {
                //弹栈，并可以计算信息了
                LinkedList<Integer> popList = stack.pop();
                //左边离他最近的比他大的:栈中位于它下面位置的链表中，最晚加入的那个
                int leftHeight = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
                for (Integer index : popList) {
                    res[index][0] = leftHeight;
                    res[index][1] = i;//右边离他最近的比他大的数组下标：当前的i
                }
            }
            //2、这个数和栈顶的相等，下标压在一起
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else { //3.这个数比栈顶小，可以直接放进去
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                stack.push(list);
            }
        }
        //遍历结束，单独处理栈中的元素
        while (!stack.isEmpty()) {
            LinkedList<Integer> popIndexList = stack.pop();
            //左边离他最近的比他大的:栈中位于它下面位置的链表中，最晚加入的那个
            int leftHeight = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
            for (Integer index : popIndexList) {
                res[index][0] = leftHeight;
                res[index][1] = -1;//右边没有离他最近的比他大的数
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[][] res = getNearMore(height);
    }
}
