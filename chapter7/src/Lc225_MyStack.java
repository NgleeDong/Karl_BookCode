import java.util.LinkedList;
import java.util.Queue;

public class Lc225_MyStack {

    static class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2; //q2当做是个工具队列：用来备份用的

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            q1.offer(x);
        }

        public int pop() {
            while (q1.size() != 1) { //把q1中除最后一个元素外放入q2中备份
                q2.offer(q1.poll());
            }
            int res = q1.poll();
            while (!q2.isEmpty()) { //把q2中备份的还给q1
                q1.offer(q2.poll());
            }
            return res;
        }

        public int top() {
            int popVal = pop();//调用pop方法，把popVal弹出去了
            q1.offer(popVal);//在把popValue放回去
            return popVal;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

}
