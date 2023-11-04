import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static long[] arr;
    static long[] findTree;
    static long[] lazyTree;
    static long result;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];
        findTree = new long[(N + 1) * 4];
        lazyTree = new long[(N + 1) * 4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        init(1, 1, N);
        M = Integer.parseInt(br.readLine());
        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());
                update(1, 1, N, queryLeft, queryRight, value);
            } else if (cmd == 2) {
                int queryIndex = Integer.parseInt(st.nextToken());
                queryFind(1, 1, N, queryIndex);
                bw.write(result+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void queryFind(int node, int nodeLeft, int nodeRight, int queryIndex) {
        lazy(node, nodeLeft, nodeRight);
        if (queryIndex < nodeLeft || nodeRight < queryIndex) {
            return;
        }
        if (nodeLeft == nodeRight) {
            result = findTree[node];
            return;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        queryFind(node * 2, nodeLeft, mid, queryIndex);
        queryFind(node * 2 + 1, mid + 1, nodeRight, queryIndex);
    }

    private static void update(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight, long value) {
        lazy(node, nodeLeft, nodeRight);
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return;
        }
        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            if (nodeLeft == nodeRight) {
                findTree[node] += value;
            }
            if (nodeLeft != nodeRight) {
                lazyTree[node * 2] += value;
                lazyTree[node * 2 + 1] += value;
            }
            return;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryLeft, queryRight, value);
        update(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight, value);
    }

    private static void lazy(int node, int nodeLeft, int nodeRight) {
        if (lazyTree[node] != 0) {
            findTree[node] += lazyTree[node];
            if (nodeLeft != nodeRight) {
                lazyTree[node * 2] += lazyTree[node];
                lazyTree[node * 2 + 1] += lazyTree[node];
            }
            lazyTree[node] = 0;
        }
    }

    private static void init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            findTree[node] = arr[nodeLeft];
            return;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        init(node * 2, nodeLeft, mid);
        init(node * 2 + 1, mid + 1, nodeRight);
    }

}