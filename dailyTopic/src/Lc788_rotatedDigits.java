public class Lc788_rotatedDigits {

    /**
     * Lc788:旋转数字
     */
    public static int rotatedDigits(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            boolean flag = false;
            int num = i; //要存起来，否则就会无限循环
            while (num != 0) {
                int temp = num % 10;
                if (temp == 3 || temp == 4 || temp == 7) { //只要碰到了 3 4 7 ，肯定不对
                    flag = false;
                    break;
                } else if (temp == 2 || temp == 5 || temp == 6 || temp == 9) {
                    flag = true;
                }
                num = num / 10;
            }
            if (flag) {
                total++;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int i = rotatedDigits(857);
        System.out.println("i = " + i);
    }
}
