public class Lc1598_minOperations {
    /**
     * 1598. 文件夹操作日志搜集器
     */
    public static int minOperations(String[] logs) {
        int count = 0;
        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];
            if (count > 0 && log.equals("../")) {
                count--;
            } else if (log.equals("./") || (count <= 0 && log.equals("../"))) {
                continue;
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        String[] logs = {"d1/","d2/","../","d21/","./"};
//        String[] logs = {"d1/","d2/","./","d3/","../","d31/"};
        String[] logs = {"d1/","../","../","../"};
        System.out.println("minOperations(logs) = " + minOperations(logs));
    }
}
