import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] answer;
    static boolean[] finished;
    static int priority = 0;
    static boolean[] inDree;
    static int[] check;
    static Stack<Integer> stack;
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<ArrayList<Integer>> SCC;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            answer = new int[v+1];
            finished = new boolean[v+1];
            check = new int[v+1];
            stack = new Stack<>();
            graph = new ArrayList<>();
            SCC = new ArrayList<>();
            int count = 0;
            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
            }

            for (int i = 1; i <= v; i++) {
                if (answer[i] == 0) dfs(i);
            }

            inDree = new boolean[SCC.size()+1];

            for (int i = 1; i <= v; i++) {
                for (int j : graph.get(i)) {
                    if (check[i] != check[j]) {
                        inDree[check[j]] = true;
                    }
                }
            }

            for (int i = 1; i < inDree.length; i++) {
                if (!inDree[i]) count++;
            }

            System.out.println(count);
        }
    }

    static int dfs(int n) {
        answer[n] = ++priority;

        int parent = answer[n];
        stack.push(n);

        for (int a : graph.get(n)) {

            if (answer[a] == 0) parent = Math.min(parent, dfs(a));
            else if (!finished[a]) parent = Math.min(parent, answer[a]);
        }

        if (answer[n] == parent) {

            ArrayList<Integer> scc = new ArrayList<>();
            while (!stack.isEmpty()) {
                int k = stack.pop();
                scc.add(k);
                finished[k] = true;
                check[k] = SCC.size()+1;

                if (n == k) {
                    break;
                }
            }
            SCC.add(scc);
        }
        return parent;
    }


}
