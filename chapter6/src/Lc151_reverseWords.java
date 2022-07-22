import java.util.Arrays;

public class Lc151_reverseWords {

    /**
     * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
     *
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     *
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     *
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     * @param s
     * @return
     */

    public static String reverseWords(String s) {
        //第一步，删除多余空格
        s = s.trim();
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == ' ' && (arr[i-1] == ' ' || arr[i+1] == ' ')) {
                //删除这个位置的空格
                System.arraycopy(arr,i+1,arr,i,arr.length-i-1);
                arr = Arrays.copyOf(arr, arr.length - 1);
//                System.out.println(i + Arrays.toString(arr));
            }
        }
//        System.out.println(Arrays.toString(arr));
        //for循环结束后，字符数组中的单词之间只含有一个空格
        //第二步：将整个字符数组反转（双指针）
        reverse(arr,0, arr.length-1);
        //第三步：再把单词反转
        //为了处理的统一，在arr末尾加个空格
        // 1. 扩容+1
        arr = Arrays.copyOf(arr, arr.length + 1);
        // 2. 向arr 尾部添加一个数据value
        arr[arr.length - 1] = ' ';
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                reverse(arr,left,i-1);
                left=i+1;//更新left
            }
        }
        //再去掉最后的空格
        arr = Arrays.copyOf(arr, arr.length - 1);
        return new String(arr);
    }

    public static void reverse(char[] s, int start, int end) {
        //双指针
        int left = start;
        int right = end;
        while (left < right) {
            char ch = s[left];
            s[left] = s[right];
            s[right] = ch;
            left++;
            right--;
        }

    }

    public static void main(String[] args) {
        String s = "a good   example";
        String str = reverseWords(s);
        System.out.println("str = " + str);
    }
}
