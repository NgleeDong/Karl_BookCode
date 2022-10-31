import java.util.List;

public class Lc1773_countMatches {

    /*
    1773. 统计匹配检索规则的物品数量

    给你一个数组 items ，其中items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。

    另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。

    如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：

    ruleKey == "type" 且 ruleValue == typei 。
    ruleKey == "color" 且 ruleValue == colori 。
    ruleKey == "name" 且 ruleValue == namei 。
    统计并返回 匹配检索规则的物品数量 。

     */

    /**
     * 模拟这个过程即可
     */

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        int index = -1;
        if ("type".equals(ruleKey)) {
            index = 0;
        } else if ("color".equals(ruleKey)) {
            index = 1;
        } else if ("name".equals(ruleKey)) {
            index = 2;
        }
        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) {
                ans++;
            }
        }
        return ans;
    }
}
