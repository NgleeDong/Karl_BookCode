import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Lc237_topKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) { //包含此数值
                int repeatTimes = map.get(num);
                map.put(num, ++repeatTimes);
            } else { //不包含，放进去
                map.put(num,1);
            }
        }
        //for 结束后，map中key为 数组中的数组，value为重复次数
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        //建立一个小根堆,即根据value值正排序
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        //遍历entries
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        //循环结束后剩下的是出现频率前 k 高的元素的map集合
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey(); //弹出一个entry，并取出key赋值给结果数组
        }
        return res;
    }
}
