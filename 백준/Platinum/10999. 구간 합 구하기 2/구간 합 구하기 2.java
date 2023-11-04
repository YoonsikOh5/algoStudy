import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, MK;
    static long[] arr;
    static long[] sumTree;
    static long[] lazyTree;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        MK = M + K;

        arr = new long[N + 1];

        sumTree = new long[4 * (N + 1)];
        lazyTree = new long[4 * (N + 1)];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, 1, N);

        for (int i = 1; i <= MK; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());
                updateRange(1, 1, N, queryLeft, queryRight, value);
            } else if (cmd == 2) {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                long result = querySum(1, 1, N, queryLeft, queryRight);
                bw.write(result + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static long querySum(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        updateLazy(node, nodeLeft, nodeRight);
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

    private static void updateRange(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight, long value) {
        updateLazy(node, nodeLeft, nodeRight);
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return;
        }
        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            sumTree[node] += (nodeRight - nodeLeft + 1) * value;
            if (nodeLeft != nodeRight) {
                lazyTree[node * 2] += value;
                lazyTree[node * 2 + 1] += value;
            }
            return;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        updateRange(node * 2, nodeLeft, mid, queryLeft, queryRight, value);
        updateRange(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight, value);
        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }

    private static void updateLazy(int node, int nodeLeft, int nodeRight) {
        if (lazyTree[node] != 0) {
            sumTree[node] += (nodeRight - nodeLeft + 1) * lazyTree[node];
            if (nodeLeft != nodeRight) {
                lazyTree[node * 2] += lazyTree[node];
                lazyTree[node * 2 + 1] += lazyTree[node];
            }
            lazyTree[node] = 0;
        }
    }

    private static void init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            sumTree[node] = arr[nodeLeft];
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        init(node * 2, nodeLeft, mid);
        init(node * 2+1, mid + 1, nodeRight);

        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }

}