import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean dfs(int curr, int depth, boolean[] visited, List<Integer>[] graph) {
        if (depth >= 4)
            return true;

        for (int next : graph[curr]) {
            if (!visited[next]) {
                visited[next] = true;
                if (dfs(next, depth + 1, visited, graph))
                    return true;
                visited[next] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt(), v = scanner.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            if (dfs(i, 0, visited, graph)) {
                System.out.println("1");
                return;
            }
            visited[i] = false;
        }

        System.out.println("0");
    }
}
