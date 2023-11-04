import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] sumTree;
    static int[] lazyTree;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sumTree = new int[(N + 1) * 4];
        lazyTree = new int[(N + 1) * 4];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 0) {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                // update
                update(1, 1, N, queryLeft, queryRight);
            } else if (cmd == 1) {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                // sum
                int result = querySum(1, 1, N, queryLeft, queryRight);
                bw.write(result + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int querySum(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        lazy(node, nodeLeft, nodeRight);
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

    private static void update(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        lazy(node, nodeLeft, nodeRight);
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return;
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            sumTree[node] = (nodeRight - nodeLeft + 1 - sumTree[node]);
            if (nodeLeft != nodeRight) {
                lazyTree[node * 2] += 1;
                lazyTree[node * 2] %= 2;
                lazyTree[node * 2 + 1] += 1;
                lazyTree[node * 2 + 1] %= 2;
            }
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryLeft, queryRight);
        update(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);

        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }

    private static void lazy(int node, int nodeLeft, int nodeRight) {
        if (lazyTree[node] != 0) {
            sumTree[node] = (nodeRight - nodeLeft + 1 - sumTree[node]);
            if (nodeLeft != nodeRight) {
                lazyTree[node * 2] += lazyTree[node];
                lazyTree[node * 2] %= 2;
                lazyTree[node * 2 + 1] += lazyTree[node];
                lazyTree[node * 2 + 1] %= 2;
            }
            lazyTree[node] = 0;
        }
    }
}