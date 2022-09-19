import java.util.*;

public class Lc1636_frequencySort {

    /**
     * lc1636. 按照频率将数组升序排序
     */
    public int[] frequencySort(int[] nums) {
        //遍历数组，用Map记录频率
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int fruquency = map.getOrDefault(num, 0);
            map.put(num, ++fruquency);
        }
        //根据Map的Value对Map进行排序
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                //如果有多个值的频率相同，请你按照数值本身将它们 降序 排序
                if (o1.getValue() == o2.getValue()) return o2.getKey() - o1.getKey();
                return o1.getValue() - o2.getValue();
            }
        });
        //遍历list，对数组进行赋值
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            int num = entry.getKey();
            int N = entry.getValue();
            for (int i = 0; i < N; i++) {
                nums[index++] = num;
            }
        }
        return nums;
    }

}
