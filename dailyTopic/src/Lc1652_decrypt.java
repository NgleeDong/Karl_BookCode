import java.util.Arrays;

public class Lc1652_decrypt {

    /**
     * lc1652. 拆炸弹
     */

    public static int[] decrypt(int[] code, int k) {
        int N = code.length;
        int[] res = new int[N];

        if (k > 0) {
            //每个数字都被接下来 3 个数字之和替换。
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int index = i + 1; index <= i + k; index++) {
                    if (index >= N) {
                        sum += code[index % N];
                        continue;
                    }
                    sum += code[index];
                }
                res[i] = sum;
            }
        } else if (k < 0) {
            //将第 i 个数字用 之前 k 个数字之和替换。
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int index = i - 1; index >= i + k; index--) {
                    if (index < 0) {
                        sum += code[N + index];//index = -1 时，循环下标 = N - 1
                        continue;
                    }
                    sum += code[index];
                }
                res[i] = sum;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int code[] = {5,7,1,4};
        int k = 3;
        int[] decrypt = decrypt(code, k);
        System.out.println("Arrays.toString(decrypt) = " + Arrays.toString(decrypt));
    }
}
