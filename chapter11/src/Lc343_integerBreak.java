import com.oracle.net.Sdp;

public class Lc343_integerBreak {

    /**
     * lc343：整数拆分
     * @param n 某个正整数
     * @return 拆分后你可以获得的最大乘积
     */
    public int integerBreak(int n) {
        return dp(n);
    }

    /**
     * dp法
     */
    public int dp(int n) {
        int[] dp = new int[n+1];
//        dp[1] = 1;
        dp[2] = 1;
        //依次填表
        for(int i = 3; i <= n; i++){
            for(int j = 1; j <= i/2; j++){
                dp[i] = Math.max(dp[i], Math.max( j * (i - j), j * dp[i - j]));
                // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                //而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
            }
        }
        return dp[n];
    }

}
