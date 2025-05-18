import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt(), mod = 1000000000;
        int[] t = { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        for (int i = 2; i <= N; i++) {
            int[] dp = new int[10];
            for (int j = 0; j < 10; j++) {
                dp[j] = ((j > 0 ? t[j - 1] : 0) + (j < 9 ? t[j + 1] : 0)) % mod;
            }
            t = dp;
        }

        int ans = 0;
        for (int v : t)
            ans = (ans + v) % mod;

        System.out.println(ans);
    }
}
