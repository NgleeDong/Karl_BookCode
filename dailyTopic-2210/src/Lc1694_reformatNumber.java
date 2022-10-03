public class Lc1694_reformatNumber {

    /**
     * lc1694. 重新格式化电话号码
     * @param number
     * @return
     */
    public static String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder(number);
        int index = 0;
        // 删除 所有的空格和破折号
        while (index < sb.length()) {
            if (sb.charAt(index) == ' ' || sb.charAt(index) == '-') {
                sb.deleteCharAt(index);
                continue;
            } else {
                index++;
            }
        }
        System.out.println("sb = " + sb);

        if (sb.length() % 3 == 0) { //剩下3个数字
            System.out.println("最后一块3个数字");
            int count = sb.length() / 3;
            for (int i = 1; i < count; i++) {
                sb.insert(3 * i + i - 1, '-');
            }
        } else if (sb.length() % 3 == 2) { //剩下2个数字
            System.out.println("最后一块2个数字");
            int count = sb.length() / 3;
            for (int i = 1; i <= count; i++) {
                sb.insert(3 * i + i - 1, '-');
            }
        } else if (sb.length() % 3 == 1) { //剩下4个数字
            System.out.println("最后一块4个数字");
            int count = sb.length() / 3;
            for (int i = 1; i < count; i++) {
                sb.insert(3 * i + i - 1, '-');
            }
            sb.insert(sb.length() - 2, '-');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "--17-5 229 35-39475 ";
        String s = reformatNumber(str);
        System.out.println("s = " + s);
    }
}
