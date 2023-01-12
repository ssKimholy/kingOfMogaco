import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] time;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        indegree = new int[N+1];
        time = new int[N+1];
        answer = new int[N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tim = Integer.parseInt(st.nextToken());
            time[i] = tim;
            while (true) {
                int t = Integer.parseInt(st.nextToken());
                if (t == -1) {
                    break;
                }
                graph.get(t).add(i);
                indegree[i]++;
            }
        }

        topologySort(N);

        for (int i = 1; i <= N; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static void topologySort(int n) {
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
                answer[i] = time[i];
            }
        }

        for (int i = 1; i <= n; i++) {

            if (que.isEmpty()) {
                System.out.print("cycle 발생");
                return;
            }
            int k = que.poll();
            for (int a : graph.get(k)) {
                answer[a] = Math.max(answer[a], answer[k] + time[a]);
                if (--indegree[a] == 0) {
                    que.offer(a);
                }
            }
        }
    }
}
