public class Lc481_magicalString {

    /*
    481. 神奇字符串
    神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：

    神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。
    s 的前几个元素是 s = "1221121221221121122……" 。
    如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 2 1 22 1 22 11 2 11 22 ......" 。
    每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ......" 。
    上面的出现次数正是 s 自身。

    给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
     */

    /**
     * 思路 ：双指针， 本题其实是一个类似“数列”问题
     * 后面的字符串可由 “122” 这前三个字符决定
     */
    public int magicalString(int n) {
        if (n < 4) {
            return 1;
        }
        char[] str = new char[n];
        str[0] = '1';
        str[1] = '2';
        str[2] = '2';
        int res = 1;
        int i = 2;
        int j = 3;
        while (j < n) {
            int size = str[i] - '0'; // 后面要填几个由 i 位置的数决定
            char num = str[j - 1] == '1' ? '2' : '1'; // 后面要填什么字符由 j-1 位置的数决定
            while (size > 0 && j < n) {
                str[j] = num;
                if (num == '1') {
                    res++; //收集'1'的个数
                }
                j++;
                size--;
            }
            i++;
        }
        return res;
    }
}
