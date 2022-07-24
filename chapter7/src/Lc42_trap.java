import java.util.Stack;

public class Lc42_trap {

    /**
     * 接雨水
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] < height[stack.peek()]) { //情况一
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) { //情况二
                stack.pop();
                stack.push(i);
            } else { //情况三
                while (!stack.isEmpty() && height[stack.peek()]  < height[i]) { //形成凹槽
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int waterH = Math.min(height[stack.peek()], height[i]) - height[mid];
                        int waterW = i - stack.peek() - 1;
                        sum += waterH * waterW;
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
