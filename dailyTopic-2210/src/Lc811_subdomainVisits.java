import java.util.*;

public class Lc811_subdomainVisits {

    /**
     * lc811. 子域名访问计数
     */

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] split = cpdomains[i].split(" ");
            int count = Integer.parseInt(split[0]);

            String s = split[1];
            //先搞定最长的这个域名
            map.put(s, map.getOrDefault(s, 0) + count);
            //再搞定它的子域名
            while (s.indexOf('.') != -1) {
                int startIndex = s.indexOf('.') + 1;
                int endIndex = s.length();
                s = s.substring(startIndex, endIndex);
                //System.out.println("子域名： = " + s);
                map.put(s, map.getOrDefault(s, 0) + count);
            }
        }
        //统计map中的结果
        List<String> list = new ArrayList<>();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            list.add(entry.getValue().toString() + " " + entry.getKey());
        }
        return list;
    }

    //cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]

    //["901 mail.com",
    // "50 yahoo.com",
    // "900 google.mail.com",
    // "5 wiki.org",
    // "5 org",
    // "1 intel.mail.com",
    // "951 com"]
}
