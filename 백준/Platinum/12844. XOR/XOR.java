import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] xorTree;
    static int[] lazyTree;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        xorTree = new int[(N + 1) * 4];
        lazyTree = new int[(N + 1) * 4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(1, 1, N);

        M = Integer.parseInt(br.readLine());

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                update(1, 1, N, queryLeft+1, queryRight+1, value);
            } else if (cmd == 2) {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                int result = queryXOR(1, 1, N, queryLeft+1, queryRight+1);
                bw.write(result + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int queryXOR(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        lazy(node, nodeLeft, nodeRight);
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return 0;
        }
        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return xorTree[node];
        }
        int mid = (nodeLeft + nodeRight) / 2;
        int xorLeft = queryXOR(node * 2, nodeLeft, mid, queryLeft, queryRight);
        int xorRight = queryXOR(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);
        return xorLeft ^ xorRight;
    }

    private static void update(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight, int value) {
        lazy(node, nodeLeft, nodeRight);
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return;
        }
        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            int curNum = nodeRight - nodeLeft + 1;
            int isOdd = curNum % 2;
            if (isOdd == 1) {
                xorTree[node] ^= value;
            }
            if (nodeLeft != nodeRight) {
                lazyTree[node * 2] ^= value;
                lazyTree[node * 2 + 1] ^= value;
            }
            return;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryLeft, queryRight, value);
        update(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight, value);
        xorTree[node] = xorTree[node * 2] ^ xorTree[node * 2 + 1];
    }

    private static void lazy(int node, int nodeLeft, int nodeRight) {
        if (lazyTree[node] != 0) {
            int curNum = nodeRight - nodeLeft + 1;
            int isOdd = curNum % 2;
            if (isOdd == 1) {
                xorTree[node] ^= lazyTree[node];
            }
            if (nodeLeft != nodeRight) {
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
        xorTree[node] = xorTree[node * 2] ^ xorTree[node * 2 + 1];
    }

}