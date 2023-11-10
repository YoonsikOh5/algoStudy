import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] lsArr;
    static int[][] seArr;
    static int cnt;
    static int[] sumTree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lsArr = new List[N+1];
        for (int i = 1; i <= N; i++) {
            lsArr[i] = new LinkedList<>();
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();

        for (int i = 2; i <= N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            lsArr[parent].add(i);
        }

        seArr = new int[N+1][2];

        // 오일러 경로
        dfs(1);

        sumTree = new int[4 * (N + 1)];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int num = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                int queryIndex = seArr[num][0];
                update(1, 1, N, queryIndex, value);
            } else if (cmd == 2) {
                int num = Integer.parseInt(st.nextToken());
                int queryLeft = seArr[num][0];
                int queryRight = seArr[num][1];
                long result = querySum(1, 1, N, queryLeft, queryRight);
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

    private static void update(int node, int nodeLeft, int nodeRight, int queryIndex, int value) {
        if (queryIndex < nodeLeft || nodeRight < queryIndex) {
            return;
        }

        if (nodeLeft == nodeRight) {
            sumTree[node] += value;
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryIndex, value);
        update(node * 2 + 1, mid + 1, nodeRight, queryIndex, value);

        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }

    private static void dfs(int cur) {
        seArr[cur][0] = ++cnt;
        List<Integer> childs = lsArr[cur];
        for (Integer child : childs) {
            dfs(child);
        }
        seArr[cur][1] = cnt;
    }


}