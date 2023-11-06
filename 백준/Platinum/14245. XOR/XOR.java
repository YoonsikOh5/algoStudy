import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] xorTree;
    static int[] lazyTree;
    static int result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        xorTree = new int[4 * N];
        lazyTree = new int[4 * N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(1, 0, N - 1);
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                doXOR(1, 0, N - 1, queryLeft, queryRight, value);
            } else if (cmd == 2) {
                int queryIndex = Integer.parseInt(st.nextToken());
                queryFind(1, 0, N - 1, queryIndex);
                bw.write(result + "\n");
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
            result = xorTree[node];
            return;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        queryFind(node * 2, nodeLeft, mid, queryIndex);
        queryFind(node * 2 + 1, mid + 1, nodeRight, queryIndex);
    }

    private static void doXOR(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight, int value) {
        lazy(node, nodeLeft, nodeRight);
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return;
        }
        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            if (nodeLeft == nodeRight) {
                xorTree[node] ^= value;
            } else {
                lazyTree[node * 2] ^= value;
                lazyTree[node * 2 + 1] ^= value;
            }

            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        doXOR(node * 2, nodeLeft, mid, queryLeft, queryRight, value);
        doXOR(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight, value);
    }

    private static void lazy(int node, int nodeLeft, int nodeRight) {
        if (lazyTree[node] != 0) {

            if (nodeLeft == nodeRight) {
                xorTree[node] ^= lazyTree[node];
            } else {
                lazyTree[node * 2] ^= lazyTree[node];
                lazyTree[node * 2 + 1] ^= lazyTree[node];
            }
            lazyTree[node] = 0;
        }
    }

    private static void init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            xorTree[node] = arr[nodeLeft];
            return;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        init(node * 2, nodeLeft, mid);
        init(node * 2 + 1, mid + 1, nodeRight);
    }

}