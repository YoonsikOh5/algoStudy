import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] lsArr;
    static int[] segTree;
    static int[] lazyTree;
    static int[] sumTree;
    static int[][] arr;
    static int cnt;
    static int downResult;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lsArr = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            lsArr[i] = new LinkedList<>();
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2; i <= N; i++) {
            // 상사 등록
            int cur = Integer.parseInt(st.nextToken());
            lsArr[cur].add(i);
        }
        arr = new int[N + 1][2];
        // 오일러 경로
        dfs(1);

        segTree = new int[4 * (N + 1)];
        lazyTree = new int[4 * (N + 1)];
        sumTree = new int[4 * (N + 1)];

        boolean isDown = true;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int num = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                if (isDown) {
                    // 아래로 칭찬
                    int queryLeft = arr[num][0];
                    int queryRight = arr[num][1];
                    updateRange(1, 1, N, queryLeft, queryRight, value);
                } else {
                    int queryIndex = arr[num][0];
                    update(1, 1, N, queryIndex, value);
                    // 위로 칭찬
                }
            } else if (cmd == 2) {
                int num = Integer.parseInt(st.nextToken());
                int queryIndex = arr[num][0];
                // 찾기
                queryFind(1, 1, N, queryIndex);

                int queryLeft = arr[num][0];
                int queryRight = arr[num][1];
                long result = querySum(1, 1, N, queryLeft, queryRight);
                bw.write((downResult + result) + "\n");
            } else if (cmd == 3) {
                isDown = !isDown;
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

    private static void queryFind(int node, int nodeLeft, int nodeRight, int queryIndex) {
        doLazy(node, nodeLeft, nodeRight);
        if (queryIndex < nodeLeft || nodeRight < queryIndex) {
            return;
        }

        if (nodeLeft == nodeRight) {
            downResult = segTree[node];
            return;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        queryFind(node * 2, nodeLeft, mid, queryIndex);
        queryFind(node * 2 + 1, mid + 1, nodeRight, queryIndex);

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

    private static void update(int node, int nodeLeft, int nodeRight, int queryIndex, int value) {
        if (queryIndex < nodeLeft || nodeRight < queryIndex) {
            return;
        }

        if (nodeLeft == nodeRight) {
            sumTree[node] += value;
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryIndex, value);
        update(node * 2 + 1, mid + 1, nodeRight, queryIndex, value);

        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }

    private static void updateRange(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight, int value) {
        doLazy(node, nodeLeft, nodeRight);
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return;
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            if (nodeLeft == nodeRight) {
                segTree[node] += value;
            } else {
                lazyTree[node * 2] += value;
                lazyTree[node * 2 + 1] += value;
            }
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        updateRange(node * 2, nodeLeft, mid, queryLeft, queryRight, value);
        updateRange(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight, value);
    }

    private static void doLazy(int node, int nodeLeft, int nodeRight) {
        if (lazyTree[node] != 0) {
            if (nodeLeft == nodeRight) {
                segTree[node] += lazyTree[node];
            } else {
                lazyTree[node * 2] += lazyTree[node];
                lazyTree[node * 2 + 1] += lazyTree[node];
            }
            lazyTree[node] = 0;
        }
    }

    private static void dfs(int cur) {
        arr[cur][0] = ++cnt;

        List<Integer> childs = lsArr[cur];
        for (Integer child : childs) {
            dfs(child);
        }

        arr[cur][1] = cnt;
    }

}