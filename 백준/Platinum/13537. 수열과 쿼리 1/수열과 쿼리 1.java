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
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int queryLeft = Integer.parseInt(st.nextToken());
            int queryRight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            // 갯수 출력 메소드
            int rank = queryRank(1, 1, N, queryLeft, queryRight, value);
            bw.write(rank + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int queryRank(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight, int value) {
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return 0;
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            int[] arr = mergeSortTree[node];
            int index = Arrays.binarySearch(arr, value + 1);
            if (index < 0) {
                index *= -1;
                index -= 1;
            }
            return (nodeRight - nodeLeft + 1) - index;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        int leftRank = queryRank(node * 2, nodeLeft, mid, queryLeft, queryRight, value);
        int rightRank = queryRank(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight, value);

        return leftRank+rightRank;
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

        mergeSortTree[node] = new int[nodeRight - nodeLeft + 1];
        int[] leftArr = mergeSortTree[node * 2];
        int[] rightArr = mergeSortTree[node * 2 + 1];
        int leftIdx = 0;
        int rightIdx = 0;
        int len = leftArr.length + rightArr.length;
        for (int i = 0; i < len; i++) {
            if (leftIdx >= leftArr.length) {
                mergeSortTree[node][i] = rightArr[rightIdx];
                rightIdx++;
            } else if (rightIdx >= rightArr.length) {
                mergeSortTree[node][i] = leftArr[leftIdx];
                leftIdx++;
            } else {
                if (leftArr[leftIdx] < rightArr[rightIdx]) {
                    mergeSortTree[node][i] = leftArr[leftIdx];
                    leftIdx++;
                } else {
                    mergeSortTree[node][i] = rightArr[rightIdx];
                    rightIdx++;
                }
            }
        }
    }

}