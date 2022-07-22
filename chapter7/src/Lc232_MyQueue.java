import java.util.Stack;

public class Lc232_MyQueue {


    static class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        //构造器
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            if (s2.empty()) {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public int peek() {
            if (s2.empty()) {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.empty() && s2.empty();
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        int p1 = myQueue.peek();
        System.out.println("p1 = " + p1);
        int p2 = myQueue.pop();
        System.out.println("p2 = " + p2);
        System.out.println(myQueue.empty());
    }

}
