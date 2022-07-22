import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 */


public class Lc242_isAnagram {

    public static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (!hashMap.containsKey(ch)) { //哈希表中不包含此key，放进去
                hashMap.put(ch,1);
            }else { //哈希表中包含此key,value++
                int count = hashMap.get(ch);
                hashMap.put(ch,++count);
            }
        }

        for (int i = 0; i < chars1.length; i++) {
            char ch = chars1[i];
            if (!hashMap.containsKey(ch)) { //哈希表中不包含此key，放进去
                return false;
            }else { //哈希表中包含此key,value--
                int count = hashMap.get(ch);
                hashMap.put(ch,--count);
            }
        }

        for(Character character : hashMap.keySet()) {
            if (hashMap.get(character) != 0) {
                return false;
            }
        }

        return true;
    }

    //法二
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] letter = new int[26];
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            letter[ch1[i] - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            letter[ch2[j] - 'a']--;
        }
        for (int k = 0; k < 26; k++) {
            if (letter[k] != 0) return false;
        }
        return true;
    }

    //法三
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);
        // for (int i = 0; i < s.length(); i++) {
        //     if (ch1[i] != ch2[i]) return false;
        // }
        // return true;
    }

    public static void main(String[] args) {
        String s = "eat";
        String t = "cat";
        boolean isAnagram = isAnagram1(s,t);
        System.out.println("isAnagram = " + isAnagram);
    }
}
