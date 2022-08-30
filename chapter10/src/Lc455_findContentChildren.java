
import java.util.Arrays;

public class Lc455_findContentChildren {

    /**
     * Lc455:分发饼干
     * @param g 孩子的胃口值数组
     * @param s 饼干的最小尺寸
     * @return 满足数量最多的孩子的数值
     */
    public int findContentChildren(int[] g, int[] s) {
        int maxSatisfactionNum = 0;
        //排序
        Arrays.sort(g);
        Arrays.sort(s);
        int sIndex = 0;
        int gIndex = 0;
        while (sIndex < s.length && gIndex < g.length) {
            //若满足胃口
            if (s[sIndex] >= g[gIndex]) {
                maxSatisfactionNum++;
                sIndex++;
                gIndex++;
            } else { //不满足胃口，即胃口大，饼小,应该找一个更大的饼
                sIndex++;
            }
        }
        return maxSatisfactionNum;
    }
}
