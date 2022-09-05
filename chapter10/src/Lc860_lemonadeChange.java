import java.util.HashMap;
import java.util.Map;

public class Lc860_lemonadeChange {

    /**
     * lc869：柠檬水找零
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            }
            if (bills[i] == 10) {
                if (five <= 0) return false;
                ten++;
                five--;
            }
            if (bills[i] == 20) {
                //优先消耗一个10和一个5
                if (ten >=1 && five >= 1) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //做复杂了。。。。
    public boolean lemonadeChange2(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) { //不用找零，直接存起来即可
                int n = map.getOrDefault(5, 0);
                map.put(5, n + 1);
            }
            if (bills[i] == 10) { //只能用5找零
                //放到map中
                int n = map.getOrDefault(10, 0);
                map.put(10, n + 1);
                int numFive = map.getOrDefault(5, 0);
                if (numFive <= 0){
                    return false;
                } else {
                    map.put(5, numFive - 1);
                }
            }
            if (bills[i] == 20) {//用 10 或 5 找零
                //不用放到map中，因为我们不会用20的找零
                //需要用1个10块的+1个五块的 或 3个五块的
                int numFive = map.getOrDefault(5, 0);
                int numTen = map.getOrDefault(10, 0);
                if (numTen >= 1 && numFive >= 1) { //优先消耗一个10和一个5
                    map.put(5, numFive - 1);
                    map.put(10, numTen - 1);
                } else if (numFive >= 3) {
                    map.put(5, numFive - 3);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
