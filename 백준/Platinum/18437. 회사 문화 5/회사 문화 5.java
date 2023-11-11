import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] lsArr;
    static int[][] arr;
    static int cnt;
    static int[] sumTree;
    static int[] lazyTree;


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        lsArr = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            lsArr[i] = new LinkedList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            lsArr[parent].add(i);
        }

        arr = new int[N + 1][2];

        dfs(1);

        sumTree = new int[4 * (N + 1)];
        lazyTree = new int[4 * (N + 1)];
        init(1, 1, N);

        M = Integer.parseInt(br.readLine());
        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int queryLeft = arr[i][0] + 1;
            int queryRight = arr[i][1];
            
            if (cmd == 1) {
                update(1, 1, N, queryLeft, queryRight, 1);
            } else if (cmd == 2) {
                update(1, 1, N, queryLeft, queryRight, -1);
            } else if (cmd == 3) {
                int result = querySum(1, 1, N, queryLeft, queryRight);
                bw.write(result + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int querySum(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        propagate(node, nodeLeft, nodeRight);
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return 0;
        }
        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return sumTree[node];
        }
        int mid = (nodeLeft + nodeRight) / 2;
        int leftSum = querySum(node * 2, nodeLeft, mid, queryLeft, queryRight);
        int rightSum = querySum(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);

        return leftSum + rightSum;
    }

    private static void update(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight, int cmd) {
        propagate(node, nodeLeft, nodeRight);
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return;
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            lazyTree[node] = cmd;
            propagate(node, nodeLeft, nodeRight);
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryLeft, queryRight, cmd);
        update(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight, cmd);

        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }

    private static void propagate(int node, int nodeLeft, int nodeRight) {
        if (lazyTree[node] != 0) {
            if (lazyTree[node] == 1) {
                sumTree[node] = (nodeRight - nodeLeft + 1);
            } else if (lazyTree[node] == -1) {
                sumTree[node] = 0;
            }
            if (nodeLeft != nodeRight) {
                lazyTree[node * 2] = lazyTree[node];
                lazyTree[node * 2 + 1] = lazyTree[node];
            }
            lazyTree[node] = 0;
        }
    }

    private static void init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            sumTree[node] = 1;
            return;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        init(node * 2, nodeLeft, mid);
        init(node * 2 + 1, mid + 1, nodeRight);
        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }

    private static void dfs(int cur) {
        arr[cur][0] = ++cnt;
        List<Integer> childs = lsArr[cur];
        for (Integer child : childs) {
            dfs(child);
        }
        arr[cur][1] = cnt;
    }

}