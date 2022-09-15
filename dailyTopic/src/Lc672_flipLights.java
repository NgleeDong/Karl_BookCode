public class Lc672_flipLights {

    /**
     * lc672. 灯泡开关 Ⅱ
     * @param n n个灯泡
     * @param presses 按压次数
     * @return 不同的状态数
     */
    public int flipLights(int n, int presses) {
        //不按开关
        if (presses == 0) {
            return 1;
        }
        //特殊情况处理
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            //特殊情况
            return presses == 1 ? 3 : 4;
        } else {
            //n >= 3
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }
}
