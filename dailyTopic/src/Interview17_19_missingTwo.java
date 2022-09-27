import java.util.Arrays;

/**
 * 面试题 17.19. 消失的两个数字
 * https://leetcode.cn/problems/missing-two-lcci/
 */
public class Interview17_19_missingTwo {
    public static int[] missingTwo(int[] nums) {
        Arrays.sort(nums); //O(N*logN) 其实已经超时了
        int count = 0;
        int[] res = new int[2];
        int index = 0;
        int N = nums.length;
        //遍历
        for (int i = 1; i < N; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                continue;
            } else {
                count++;
                res[index++] = nums[i] - 1;
            }
        }
        //缺少头 或者 缺少尾
        if (count == 0) {
            if (nums[N - 1] == N + 2) { //仅仅头部缺少1，2,如[3] 或者[3,4,5,6]
                res[0] = 1;
                res[1] = 2;
            } else { //头 和 尾 都缺,如[2], [2,3,4,5,6]
                res[0] = nums[0] == 1 ? 2 : 1; //处理头部
                res[1] = N + 2; //处理尾部
            }
        } else if (count == 1) {
            // 此时中间缺失的已经计算过了，放入了res[0]中
            // 但还缺少头部的 1 或者尾部的 N+2,如[1],[1,2,3] 或 [2,3,5]
            res[1] = nums[0] == 1 ? N + 2 : 1;
        }
        return res;
    }

    /**
     * 位运算
     */
    public static int[] missingTwo2(int[] nums) {
        int N = nums.length + 2;
        int eor = 0;
        for (int i = 1; i <= N ; i++) {
            eor ^= i;
        }
        for (int i = 0; i < nums.length; i++) {
            eor ^= nums[i];
        }
        /*
            假设缺失的是 a，b 则此时 eor = a ^ b
         */
        int rightOne = eor & (~eor + 1);//提取最右侧的1
        int onlyOne = 0;
        for (int cur = 1; cur <=  N; cur++) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        /*
            假设缺失的是 a，b 则此时 onlyOne = a 或 b
         */
        return new int[]{onlyOne, onlyOne ^ eor};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 7, 9, 10};
        int[] two = missingTwo(nums);
        System.out.println("Arrays.toString(two) = " + Arrays.toString(two));
    }

}
