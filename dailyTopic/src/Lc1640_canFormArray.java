import java.util.HashMap;
import java.util.Map;

public class Lc1640_canFormArray {

    /**
     * lc1640. 能否连接形成数组
     */
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        boolean flag = true;
        //遍历pieces二维数组，取出每一个子数组
        for (int i = 0; i < pieces.length; i++) {
            int[] sub = pieces[i];
            //找到 arr数组 中和 sub[0]相等的
            int k = 0;
            while (k < arr.length && arr[k] != sub[0]) {
                k++;
            }
            //找不到直接返回
            if (k == arr.length) {
                return false;
            }
            for (int j = 0; j < sub.length; j++) {
                if (k < arr.length && arr[k++] == sub[j]) {
                    continue;
                } else { // k >= arr.legnth || arr[k] != sub[j]
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static boolean canFormArray1(int[] arr, int[][] pieces) {
        int N = arr.length;
        int M = pieces.length;
        // pieces 的中每个子数组的首位数字与当前数组在 pieces 中的下标的 map
        // key: 每个 子数组 的首位数字, value: 该 子数组 在 pieces 中的索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            map.put(pieces[i][0], i);
        }
        //遍历arr:
        for (int i = 0; i < N; ) { //i只会指向对应pieces每一段的第一个数字
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int index = map.get(arr[i]);
            int[] sub = pieces[index]; //子数组
            // 判断当前 piece 段(子数组)是否完全出现在 arr 中
            for (int j = 0; j < sub.length; j++) {
                if (sub[j] != arr[i++]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {91,4,64,78};
        int[][] pieces = {{78},{4,64},{91}};
        boolean b = canFormArray(arr, pieces);
        System.out.println("b = " + b);
    }
}
