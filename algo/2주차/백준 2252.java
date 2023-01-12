import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] indegree;
    static ArrayList<Integer> answer = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        indegree = new int[N+1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            indegree[b]++;
        }

        topologySort(N);

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }

    private static void topologySort(int n) {
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
            }
        }

        for (int i = 1; i <= n; i++) {

            if (que.isEmpty()) {
                System.out.print("cycle 발생");
                return;
            }
            int k = que.poll();
            answer.add(k);
            for (int a : graph.get(k)) {
                if (--indegree[a] == 0) {
                    que.offer(a);
                }
            }
        }
    }
}
