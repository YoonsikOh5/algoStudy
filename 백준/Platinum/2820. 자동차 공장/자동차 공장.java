import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] initArr;
    static List<Integer>[] lsArr;
    static int[][] seArr;
    static int[] oArr;
    static int cnt;
    static int[] segTree;
    static int[] lazyTree;
    static int result;


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        initArr = new int[N + 1];
        lsArr = new List[N + 1];
        oArr = new int[N + 1];
        seArr = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            lsArr[i] = new LinkedList<>();
        }

        st = new StringTokenizer(br.readLine());
        initArr[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            initArr[i] = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());
            lsArr[parent].add(i);
        }

        dfs(1);


        segTree = new int[4 * (N + 1)];
        lazyTree = new int[4 * (N + 1)];
        init(1, 1, N);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            if (cmd == 'p') {
                int num = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                int queryLeft = seArr[num][0];
                int queryRight = seArr[num][1];
                if (queryLeft == queryRight) continue;
                update(1, 1, N, queryLeft + 1, queryRight, value);
            } else if (cmd == 'u') {
                int num = Integer.parseInt(st.nextToken());
                int queryIndex = seArr[num][0];
                queryFind(1, 1, N, queryIndex);
                bw.write(result + "\n");
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
            result = segTree[node];
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        queryFind(node * 2, nodeLeft, mid, queryIndex);
        queryFind(node * 2 + 1, mid + 1, nodeRight, queryIndex);
    }

    private static void update(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight, int value) {
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
        update(node * 2, nodeLeft, mid, queryLeft, queryRight, value);
        update(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight, value);
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

    private static void init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            segTree[node] = initArr[oArr[nodeLeft]];
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        init(node * 2, nodeLeft, mid);
        init(node * 2 + 1, mid + 1, nodeRight);
    }

    private static void dfs(int cur) {
        seArr[cur][0] = ++cnt;
        oArr[seArr[cur][0]] = cur;
        List<Integer> childs = lsArr[cur];
        for (Integer child : childs) {
            dfs(child);
        }

        seArr[cur][1] = cnt;
    }


}