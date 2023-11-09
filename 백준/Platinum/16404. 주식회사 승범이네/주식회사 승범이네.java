import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] lsArr;
    static int[][] arr;
    static int cnt;
    static int[] segTree;
    static int[] lazy;
    static int result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][2];

        lsArr = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            lsArr[i] = new LinkedList<>();
        }

        st = new StringTokenizer(br.readLine());
        int parent = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= N; i++) {
            parent = Integer.parseInt(st.nextToken());
            lsArr[parent].add(i);
        }

        // 오일러 경로
        dfs(1);


        segTree = new int[4 * (N + 1)];
        lazy = new int[4 * (N + 1)];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int num = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                int queryLeft = arr[num][0];
                int queryRight = arr[num][1];
                update(1, 1, N, queryLeft, queryRight, value);
            } else if (cmd == 2) {
                int num = Integer.parseInt(st.nextToken());
                int queryIndex = arr[num][0];
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
            result = segTree[node];
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        queryFind(node * 2, nodeLeft, mid, queryIndex);
        queryFind(node * 2 + 1, mid + 1, nodeRight, queryIndex);
    }

    private static void update(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight, int value) {
        lazy(node, nodeLeft, nodeRight);
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return;
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            if (nodeLeft == nodeRight) {
                segTree[node] += value;
            } else {
                lazy[node * 2] += value;
                lazy[node * 2 + 1] += value;
            }
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryLeft, queryRight, value);
        update(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight, value);

    }

    private static void lazy(int node, int nodeLeft, int nodeRight) {
        if (lazy[node] != 0) {
            if (nodeLeft == nodeRight) {
                segTree[node] += lazy[node];
            } else {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    private static void dfs(int cur) {
        if (cur > N) {
            return;
        }
        // 0 진입 시점
        arr[cur][0] = ++cnt;
        List<Integer> childs = lsArr[cur];
        for (Integer child : childs) {
            dfs(child);
        }
        // 1 끝까지 갔다가 온 시점
        arr[cur][1] = cnt;
    }


}