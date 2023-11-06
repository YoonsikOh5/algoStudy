import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[][] mergeSortTree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
        }
        mergeSortTree = new int[4 * (N + 1)][];
        init(1, 1, N);
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int queryLeft = Integer.parseInt(st.nextToken());
            int queryRight = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            // l r i i보다 작은 수의 갯수를 출력하는 메서드 만들기
            int left = -1000000000;
            int right = 1000000000;
            int res = 0;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int lessCnt = findLess(1, 1, N, queryLeft, queryRight, mid);
                if (lessCnt + 1 > k) {
                    right = mid;
                } else if (lessCnt + 1 <= k) {
                    res = mid;
                    left = mid+1;
                }
            }
            bw.write(res+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int findLess(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight, int value) {
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return 0;
        }
        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            int resultIndex = Arrays.binarySearch(mergeSortTree[node], value);
            if (resultIndex < 0) {
                resultIndex *= -1;
                resultIndex -= 1;
            }
            return resultIndex;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        int leftLess = findLess(node * 2, nodeLeft, mid, queryLeft, queryRight, value);
        int rightLess = findLess(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight, value);
        return leftLess + rightLess;
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
        int lrn = leftTree.length + rightTree.length;
        mergeSortTree[node] = new int[lrn];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < lrn; i++) {
            if (leftIndex >= leftTree.length) {
                mergeSortTree[node][i] = rightTree[rightIndex];
                rightIndex++;
            } else if (rightIndex >= rightTree.length) {
                mergeSortTree[node][i] = leftTree[leftIndex];
                leftIndex++;
            } else {
                if (leftTree[leftIndex] < rightTree[rightIndex]) {
                    mergeSortTree[node][i] = leftTree[leftIndex];
                    leftIndex++;
                } else {
                    mergeSortTree[node][i] = rightTree[rightIndex];
                    rightIndex++;
                }
            }
        }
    }
}