import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    static int[] arr;
    static int[][] mergeSortTree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSortTree = new int[4 * (N + 1)][];
        init(1, 1, N);
        M = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int queryLeft = a ^ result;
            int queryRight = b ^ result;
            int k = c ^ result;
            result = queryfind(1, 1, N, queryLeft, queryRight, k);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int queryfind(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight, int k) {
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return 0;
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            int[] cur = mergeSortTree[node];
            int idx = Arrays.binarySearch(cur, k+1);
            if (idx < 0) {
                idx *= -1;
                idx -= 1;
            }
            return (nodeRight - nodeLeft + 1 - idx);
        }

        int mid = (nodeLeft + nodeRight) / 2;
        int leftFind = queryfind(node * 2, nodeLeft, mid, queryLeft, queryRight, k);
        int rightFind = queryfind(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight, k);

        return leftFind + rightFind;
    }

    private static void init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            mergeSortTree[node] = new int[1];
            mergeSortTree[node][0] = arr[nodeLeft];
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        init(node * 2, nodeLeft, mid);
        init(node * 2 + 1, mid + 1, nodeRight);

        int[] leftTree = mergeSortTree[node * 2];
        int[] rightTree = mergeSortTree[node * 2 + 1];

        int llen = leftTree.length;
        int rlen = rightTree.length;
        int lrlen = llen + rlen;
        int lidx = 0;
        int ridx = 0;
        mergeSortTree[node] = new int[lrlen];
        for (int i = 0; i < lrlen; i++) {
            if (lidx >= llen) {
                mergeSortTree[node][i] = rightTree[ridx];
                ridx++;
            } else if (ridx >= rlen) {
                mergeSortTree[node][i] = leftTree[lidx];
                lidx++;
            } else {
                if (rightTree[ridx] < leftTree[lidx]) {
                    mergeSortTree[node][i] = rightTree[ridx];
                    ridx++;
                } else {
                    mergeSortTree[node][i] = leftTree[lidx];
                    lidx++;
                }
            }
        }
    }

}