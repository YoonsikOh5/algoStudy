import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    static int[] arr;

    static int[] sumTree;


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            arr = new int[N + 1];
            sumTree = new int[(N + M + 1) * 4];

            for (int i = 1; i <= N; i++) {
                arr[i] = N - i + 1;
            }

            init(1, 1, N + M);

            for (int i = 0; i < M; i++) {
                int cur = Integer.parseInt(st.nextToken());

                int curIdx = arr[cur];

                long curSum = querySum(1, 1, N + M, curIdx, N + M);

                update(1, 1, N + M, curIdx, 0);

                arr[cur] = N + i + 1;
                update(1, 1, N + M, N + i + 1, 1);

                bw.write(curSum - 1 + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static void update(int node, int nodeLeft, int nodeRight, int queryIdx, int queryValue) {
        if (queryIdx < nodeLeft || nodeRight < queryIdx) {
            return;
        }

        if (nodeLeft == nodeRight) {
            if (nodeLeft == queryIdx) {
                sumTree[node] = queryValue;
            }
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryIdx, queryValue);
        update(node * 2 + 1, mid + 1, nodeRight, queryIdx, queryValue);

        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
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

    private static void init(int node, int nodeLeft, int nodeRight) {

        if (nodeLeft == nodeRight) {
            if (nodeLeft <= N) {
                sumTree[node] = 1;
            }
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;

        init(node * 2, nodeLeft, mid);
        init(node * 2 + 1, mid + 1, nodeRight);

        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }


}