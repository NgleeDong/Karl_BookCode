import java.util.Arrays;
import java.util.TreeMap;

public class Lc870_advantageCount {

    /**
     * lc870. 优势洗牌
     */


    /*
    若num1中有大于num2的数字，我们选择最小的大于num2的数字和其配对。
    若num1中没有大于num2的数字，则选择num1中最小的数字和其配对。
    以nums1 = [2,7,11,15], nums2 = [1,10,4,11]为例：

    大于1的最小元素为2，则ans[0] = 2;
    大于10的最小元素为11，则ans[1] = 11;
    大于4的最小元素为7，则ans[2] = 7;
    大于11的最小元素为15，则ans[3] = 15;

    根据上述，我们可以采用TreeMap来存放num1中的数字，然后遍历num2，找num2中的每个元素的匹配
     */

    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        //存放num1的元素
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] ans = new int[n];
        //遍历num2
        for (int i = 0; i < nums2.length; i++) {
            //找到大于 nums[i]的最小元素 略胜一筹
            Integer higher = map.higherKey(nums2[i]);
            //没有取 num1 中的最小值
            if (higher == null) {
                higher = map.firstKey();
            }
            ans[i] = higher;
            if (map.get(higher) == 1) {
                map.remove(higher);
            } else {
                map.put(higher, map.get(higher) - 1);
            }
        }
        return ans;
    }

    /*
    进一步优化
        我们可以不存放元素到Map中，我们将num1数组排序，通过二分查找找到num2中的匹配元素。
     */
    public static int[] advantageCount2(int[] nums1, int[] nums2) {
        //minIndex 是最小元素的索引
        int n = nums1.length, minIndex = 0;
        //判断num1的元素 是否使用
        boolean[] visited = new boolean[n];
        int[] ans = new int[n];
        //排序
        Arrays.sort(nums1);
        for (int i = 0; i < n; i++) {
            int left = 0, right = n;
            //二分查找 找最小的大于 num2[i]的元素
            while (left != right) {
                int mid = left + ((right - left) >> 1);
                if (nums1[mid] < nums2[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            //是否访问 或者 相同
            while (left < n && (visited[left] || nums1[left] == nums2[i])) {
                left++;
            }
            if (left == n) {
                //没有大于num[i]的元素，取最小的元素
                while (visited[minIndex]) {
                    minIndex++;
                }
                ans[i] = nums1[minIndex];
                visited[minIndex++] = true;
            } else {
                visited[left] = true;
                ans[i] = nums1[left];
            }
        }
        return ans;
    }


    /**
     * 方法一：遍历nums2， 每次遍历nums2的过程中遍历nums1
     * 超时！
     */

    public static int[] advantageCount11(int[] nums1, int[] nums2) {
        int N = nums1.length;
        boolean[] used = new boolean[N];
        //遍历nums2数组
        for (int i = 0; i < N; i++) {
            int cur = nums2[i];
            int minDiff = Integer.MAX_VALUE;
            int minDiffIndex = Integer.MAX_VALUE;
            //找出nums1数组中 比它大 且 差值最小的那个
            for (int j = 0; j < N; j++) {
                if (nums1[j] - cur > 0 && used[j] == false) {
                    int diff = nums1[j] - cur;
                    minDiffIndex = diff < minDiff ? j : minDiffIndex;
                    minDiff = diff < minDiff ? diff : minDiff;
                }
            }
            if (minDiffIndex == Integer.MAX_VALUE) { //没找到比他更大的
                continue;
            }
            used[i] = true; //标记i位置已经是最终值了
            if (minDiffIndex == i) continue;
            swap(nums1, i, minDiffIndex);//交换
        }
        return nums1;
    }
    
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,0,4,1,2};
        int[] nums2 = {1,3,0,0,2};
        int[] advantageShuffle = advantageCount(nums1, nums2);
        System.out.println("Arrays.toString(advantageShuffle) = " + Arrays.toString(advantageShuffle));
    }
}
