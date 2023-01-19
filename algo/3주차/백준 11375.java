import java.util.*;
import java.io.*;

public class Main {
    static int[] answer;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cow = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        answer = new int[m+1];
        visited = new boolean[m+1];

        for (int i = 0; i <= cow; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= cow; i++) {
            st = new StringTokenizer(br.readLine()); 
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int k = Integer.parseInt(st.nextToken());
                graph.get(i).add(k);
            }
        }

        for (int i = 1; i <= cow; i++) {
            Arrays.fill(visited, false);
            if (dfs(i)) count++;
        }

        System.out.println(count);
    }

    static boolean dfs(int n) {
        for (int a : graph.get(n)) {
            if (!visited[a]) {
                visited[a] = true;
                if (answer[a] == 0 || dfs(answer[a])) {
                    answer[a] = n;
                    return true;
                }
            }
        }
        return false;
    }
}
