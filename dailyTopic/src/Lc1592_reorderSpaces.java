import java.util.Arrays;

public class Lc1592_reorderSpaces {

    /**
     * lc1592. 重新排列单词间的空格
     */
    public static String reorderSpaces(String text) {
        //用正则表达式分割单词
        String[] words = text.trim().split("\\s+");
        //统计单词总长度
        int totalWordNum = 0;
        for (String word : words) {
            totalWordNum += word.length();
        }
        //总的空格数 = 字符串总长度 - 单词长度
        int totalBlankNum = text.length() - totalWordNum;
        if (words.length == 1) {
            //直接在其后面拼接即可
            StringBuilder sb = new StringBuilder(words[0]);
            for (int i = 0; i < totalBlankNum; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }
        //每个单词间的空格数
        int avgBlankNum = totalBlankNum / (words.length - 1);
        //需要在末尾添加的空格数
        int endBlankNum = totalBlankNum % (words.length - 1);
        //拼接
        StringBuilder sb = new StringBuilder();
        StringBuilder blankSb = new StringBuilder();
        for (int i = 0; i < avgBlankNum; i++) {
            blankSb.append(' ');
        }
        for (int i = 0; i < words.length; i++) {
            if ( i != words.length - 1) {
                sb.append(words[i]).append(blankSb); //拼接word和空格
            } else {
                sb.append(words[i]);//只拼接word
            }
        }
        for (int i = 0; i < endBlankNum; i++) {
            sb.append(' '); //把多余空格拼接进去
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String text = "a b c ";
        System.out.println("text.length() = " + text.length());
        String s = reorderSpaces(text);
        System.out.println("s = " + s);
    }
}
