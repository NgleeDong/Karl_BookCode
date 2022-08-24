import java.util.ArrayList;
import java.util.List;

public class Lc93_restoreIpAddresses {

    /**
     * Lc93：复原IP地址
     */

    List<String> result = new ArrayList<>();
    int pointNum = 0; //pointNum记录'.'的个数，当pointNum的个数为3时，字符串被分成了四段

    //递归函数
    public void process(StringBuilder s, int startIndex) {
        //当pointNum的个数为3时，字符串被分成了四段
        if(pointNum == 3) {
            //判断第四段是否合法
            String str = s.substring(startIndex, s.length());
//            System.out.println("第四段 = " + str);
            if (isVaildIpAddr(str)) {
                result.add(s.toString());
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            //处理:判断 [startIndex,i] 的串，即当前割的串 是否满足要求
            String s1 = s.substring(startIndex, i + 1);
//            System.out.println("当前割的 = " + s1);
            if (isVaildIpAddr(s1)) { //满足
                //从后面插入一个'.'
                s.insert(i + 1, '.');
                pointNum++;

                //递归,下一个子字符串的起始位置为 i+2
                process(s, i + 2);

                //回溯
                pointNum--;
                s.deleteCharAt(i + 1);
            }else {
                break; //不满足要求，结束本层循环
            }
        }

    }

    //判断字符串是否满足IP地址的要求
    public boolean isVaildIpAddr(String s) {
        //第四段若是空字符串 不满足
        if (s == "" || s.length() < 1) return false;
        //如果长度 >1 且 以0开头,不满足
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { //非数字字符不满足
                return false;
            }
        }
        //全都是数字字符，但大于255，不满足
        if (Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return null;
        StringBuilder stringBuilder = new StringBuilder(s);
        process(stringBuilder, 0);
        return result;
    }
}
