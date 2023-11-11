import java.io.*;
import java.util.*;

public class Main {

    static int N, C;
    static List<Integer>[] lsArr;
    static int[][] arr;
    static int cnt;
    static int[] sumTree;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        lsArr = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            lsArr[i] = new LinkedList<>();
        }

        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lsArr[x].add(y);
            lsArr[y].add(x);
        }
        // 0 오일러 시작 1 끝 2 깊이
        arr = new int[N + 1][3];

        dfs(C, -1, 1);

        sumTree = new int[4 * (N + 1)];

        int Q = Integer.parseInt(br.readLine());
        for (int q = 1; q <= Q; q++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int a = Integer.parseInt(st.nextToken());
                int queryIndex = arr[a][0];
                update(1, 1, N, queryIndex);
            } else if (cmd == 2) {
                int a = Integer.parseInt(st.nextToken());
                int queryLeft = arr[a][0];
                int queryRight = arr[a][1];
                int depth = arr[a][2];
                long resultSum = querySum(1, 1, N, queryLeft, queryRight);
                long result = resultSum * depth;
                bw.write(result + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static long querySum(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return 0;
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return sumTree[node];
        }

        int mid = (nodeLeft + nodeRight) / 2;
        long leftSum = querySum(node * 2, nodeLeft, mid, queryLeft, queryRight);
        long rightSum = querySum(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);

        return leftSum + rightSum;
    }

    private static void update(int node, int nodeLeft, int nodeRight, int queryIndex) {
        if (queryIndex < nodeLeft || nodeRight < queryIndex) {
            return;
        }
        if (nodeLeft == nodeRight) {
            sumTree[node] += 1;
            return;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryIndex);
        update(node * 2 + 1, mid + 1, nodeRight, queryIndex);
        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }

    private static void dfs(int cur, int parent, int depth) {

        arr[cur][0] = ++cnt;
        arr[cur][2] = depth;
        List<Integer> childs = lsArr[cur];
        for (Integer child : childs) {
            if (child != parent) {
                dfs(child, cur, depth + 1);
            }
        }
        arr[cur][1] = cnt;

    }


}