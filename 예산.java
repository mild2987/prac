import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), b;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = s.nextInt();
        b = s.nextInt();
        Arrays.sort(a);
        if (Arrays.stream(a).sum() <= b) {
            System.out.print(a[n - 1]);
            return;
        }
        int l = 0, r = a[n - 1], ans = 0;
        while (l <= r) {
            int m = (l + r) / 2, t = 0;
            for (int x : a) t += Math.min(x, m);
            if (t <= b) { 
                ans = m;
                l = m + 1;
            } else
                r = m - 1;
        }
        System.out.print(ans);
    }
}
