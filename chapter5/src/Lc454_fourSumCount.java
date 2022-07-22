import java.util.HashMap;

public class Lc454_fourSumCount {

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                if (map.containsKey(sum)) {
                    map.put(sum,map.get(sum) + 1);
                } else {
                    map.put(sum,1);
                }
            }
        }

        for (int i : nums3) {
            for (int j: nums4) {
                int _sum = 0 - (i + j);
                if (map.containsKey(_sum)) {
                    res+= map.get(_sum);
                }
            }
        }

        return res;
    }
}
