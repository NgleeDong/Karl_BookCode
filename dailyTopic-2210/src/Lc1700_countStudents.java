import java.util.LinkedList;
import java.util.Stack;

public class Lc1700_countStudents {

    /*
    1700. 无法吃午餐的学生数量
     */

    /**
     * 思路：直接模拟这个过程
     * 执行用时：2 ms, 在所有 Java 提交中击败了26.00%的用户
     */
    public static int countStudents(int[] students, int[] sandwiches) {
        //准备一个学生队列
        LinkedList<Integer> stuQueue = new LinkedList<>(); //LinkedList可用来做双端队列
        for (int student : students) {
            stuQueue.add(student);
        }
        //准备一个栈
        Stack<Integer> stack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }
        int count = 0;
        while (!stuQueue.isEmpty() && !stack.isEmpty()) {
            if (stuQueue.getFirst() != stack.peek()) {
                count++;
                if (count == stuQueue.size()) {
                    break;
                }
                stuQueue.add(stuQueue.removeFirst()); //队列头 加入到 队列尾
            } else {
                //相等，即可以拿到三明治
                stuQueue.removeFirst();//出队
                stack.pop();//弹栈
                count = 0; //计数器计为0
            }
        }
        return stuQueue.size();
    }

    public static void main(String[] args) {
        int[] stus = {1,1,1,0,0,1};
        int[] sands = {1,0,0,0,1,1};
        int i = countStudents(stus, sands);
        System.out.println("i = " + i);
    }
}
