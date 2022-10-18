import java.util.HashMap;

public class Lc904_totalFruit {

    /*
    904. 水果成篮
     */

    /**
     * 我们可以使用滑动窗口解决本题，left 和right 分别表示满足要求的窗口的左右边界，
     * 同时我们使用哈希表存储这个窗口内的数以及出现的次数
     * 每次将 right 移动一个位置，并将 fruits[right] 加入哈希表。
     * 如果此时哈希表不满足要求（即哈希表中出现超过两个键值对），那么我们需要不断移动left，
     * 并将 fruits[left] 从哈希表中移除，直到哈希表满足要求为止。
     * 需要注意的是，将 fruits[left] 从哈希表中移除后，如果 fruits[left] 在哈希表中的出现次数减少为 0，
     * 需要将对应的键值对从哈希表中移除。
     */
    public int totalFruit(int[] fruits) {
        int N = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int ans = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
