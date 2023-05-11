import java.io.*;
import java.util.*;

public class Main {

    static List<Node>[] tree;

    static int maxlen;

    static boolean[] visited;

    static class Node {

        int num;
        int len;

        public Node(int num, int len) {
            this.num = num;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        tree = new LinkedList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new LinkedList<>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, len));
            tree[child].add(new Node(parent, len));
        }
        maxlen = 0;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, 0);
        }

        bw.write(maxlen + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int parent, int curlen) {

        List<Node> nodes = tree[parent];

        for (Node node : nodes) {
            if (visited[node.num] == false) {
                visited[node.num] = true;
                dfs(node.num, curlen + node.len);
            }
        }

        maxlen = Math.max(maxlen, curlen);
    }
}
