import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[][] minTree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        minTree = new int[(N + 1) * 4][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(1, 1, N);

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int queryIndex = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                update(1, 1, N, queryIndex, value);
            } else if (cmd == 2) {
                bw.write(minTree[1][1] + "\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

    private static void update(int node, int nodeLeft, int nodeRight, int queryIndex, int value) {
        if (queryIndex < nodeLeft || nodeRight < queryIndex) {
            return;
        }

        if (nodeLeft == nodeRight) {
            minTree[node][0] = value;
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryIndex, value);
        update(node * 2 + 1, mid + 1, nodeRight, queryIndex, value);

        if (minTree[node * 2][0] < minTree[node * 2 + 1][0]) {
            minTree[node][0] = minTree[node * 2][0];
            minTree[node][1] = minTree[node * 2][1];
        } else if (minTree[node * 2][0] > minTree[node * 2 + 1][0]) {
            minTree[node][0] = minTree[node * 2 + 1][0];
            minTree[node][1] = minTree[node * 2 + 1][1];
        } else {
            minTree[node][0] = minTree[node * 2 + 1][0];
            if (minTree[node * 2][1] < minTree[node * 2 + 1][1]) {
                minTree[node][1] = minTree[node * 2][1];
            } else {
                minTree[node][1] = minTree[node * 2 + 1][1];
            }
        }
    }

    private static void init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            minTree[node][0] = arr[nodeLeft];
            minTree[node][1] = nodeLeft;
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        init(node * 2, nodeLeft, mid);
        init(node * 2 + 1, mid + 1, nodeRight);

        if (minTree[node * 2][0] < minTree[node * 2 + 1][0]) {
            minTree[node][0] = minTree[node * 2][0];
            minTree[node][1] = minTree[node * 2][1];
        } else if (minTree[node * 2][0] > minTree[node * 2 + 1][0]) {
            minTree[node][0] = minTree[node * 2 + 1][0];
            minTree[node][1] = minTree[node * 2 + 1][1];
        } else {
            minTree[node][0] = minTree[node * 2 + 1][0];
            if (minTree[node * 2][1] < minTree[node * 2 + 1][1]) {
                minTree[node][1] = minTree[node * 2][1];
            } else {
                minTree[node][1] = minTree[node * 2 + 1][1];
            }
        }
    }

}