import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static Node parentZero = new Node();
    static Node[] nodeArr;
    static int N;
    static List<Edge>[] edgeList;
    static boolean[] visited;

    static class Edge {
        int start;
        int end;
        int dist;

        public Edge(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }

    static class Node {

        // parent[0] 2^0 = 1 번째 조상
        // parent[1] 2^1 = 2 번째 조상
        // parent[2] 2^2 = 4 번째 조상
        // ... 이렇게 점프 뛰기 위해 조상 설정
        Node[] parent;
        List<Node> childs;

        int num;

        int depth;

        // 위에서부터의 dist
        int dist;

        public Node() {
            this.parent = new Node[20];
            this.parent[0] = parentZero;
            childs = new ArrayList<>();
        }

    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine());

        nodeArr = new Node[N + 1];
        nodeArr[0] = parentZero;
        for (int i = 0; i < 20; i++) {
            nodeArr[0].parent[i] = nodeArr[0];
        }

        for (int i = 1; i <= N; i++) {
            nodeArr[i] = new Node();
            nodeArr[i].num = i;
        }

        Node root = nodeArr[1];
        edgeList = new List[N + 1];
        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            edgeList[i] = new LinkedList<>();
        }
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edgeList[a].add(new Edge(a,b,d));
            edgeList[b].add(new Edge(b,a,d));
        }

        visited[1] = true;
        makeTree();

        for (int y = 1; y < 20; y++) {
            for(int x = 1; x <= N; x++){
                nodeArr[x].parent[y] = nodeArr[nodeArr[x].parent[y - 1].num].parent[y - 1];
            }
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int lcaA = Integer.parseInt(st.nextToken());
            int lcaB = Integer.parseInt(st.nextToken());
            long l = doLCA(lcaA, lcaB);
            bw.write(l + "\n");
        }


        bw.flush();
        bw.close();
        br.close();

    }

    private static void makeTree() {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(nodeArr[1]);

        while (queue.size()>0){
            Node poll = queue.poll();
            int cur = poll.num;

            List<Edge> edges = edgeList[cur];
            for (Edge edge : edges) {
                int child = edge.end;
                if (visited[child] == true) {
                    continue;
                }
                visited[child] = true;

                nodeArr[child].parent[0] = nodeArr[cur];
                nodeArr[cur].childs.add(nodeArr[child]);
                nodeArr[child].depth = poll.depth+1;
                nodeArr[child].dist = poll.dist+edge.dist;
                queue.offer(nodeArr[child]);
            }
        }
    }

    private static long doLCA(int pre, int cur) {
        Node preNode = nodeArr[pre];
        Node curNode = nodeArr[cur];
        long resultdist = 0;
        if(preNode == curNode){
            return 0;
        }
        // curNode의 depth를 더 낮게 해서 편하게 할려고
        if (preNode.depth > curNode.depth) {
            preNode = nodeArr[cur];
            curNode = nodeArr[pre];
        }
        // curNode의 parent가 prenode이면 당연히 LCA도 prenode
        if (curNode.parent[0] == preNode) {
            return curNode.dist - preNode.dist;
        }
        for (int i = 19; i >= 0; i--) {
            if (curNode.depth - preNode.depth >= (1 << i)) {
                resultdist += (curNode.dist - curNode.parent[i].dist);
                curNode = curNode.parent[i];
                if (curNode == preNode) {
                    return resultdist;
                }
            }
        }
        if (curNode.parent[0] != preNode.parent[0]) {
            for (int i = 19; i >= 0; i--) {
                if (preNode.parent[i] != curNode.parent[i]) {
                    resultdist += (preNode.dist - preNode.parent[i].dist);
                    resultdist += (curNode.dist - curNode.parent[i].dist);
                    preNode = preNode.parent[i];
                    curNode = curNode.parent[i];
                }
            }
        }
        if (preNode.parent[0] == curNode.parent[0]) {
            resultdist += (preNode.dist - preNode.parent[0].dist);
            resultdist += (curNode.dist - curNode.parent[0].dist);
            return resultdist;
        }
        return resultdist;
    }

}