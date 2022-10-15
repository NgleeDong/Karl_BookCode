import java.util.ArrayList;
import java.util.List;

public class Lc1441_buildArray {

    /**
     * 1441. 用栈操作构建数组
     */
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int targetIndex = 0;
        int arrIndex = 0;
        while (targetIndex < target.length && arrIndex < n) {
            if (target[targetIndex] == arr[arrIndex]) {
                res.add("Push");
                targetIndex++;
                arrIndex++;
            } else { //一定是target[targetIndex] < arr[arrIndex]
                res.add("Push");
                res.add("Pop");
                arrIndex++;
            }
        }
        return res;
    }
}
