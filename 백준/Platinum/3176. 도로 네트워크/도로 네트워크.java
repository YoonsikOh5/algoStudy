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
    static long resultMax;
    static long resultMin;

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

    static class NodeMaxMin {
        Node node;
        long max;
        long min;

        public NodeMaxMin(Node node, long max, long min) {
            this.node = node;
            this.max = max;
            this.min = min;
        }
    }

    static class Node {

        // parent[0] 2^0 = 1 번째 조상
        // parent[1] 2^1 = 2 번째 조상
        // parent[2] 2^2 = 4 번째 조상
        // ... 이렇게 점프 뛰기 위해 조상 설정
        NodeMaxMin[] parent;
        List<Node> childs;

        int num;

        int depth;

        // 위에서부터의 dist
        int dist;

        public Node() {
            this.parent = new NodeMaxMin[20];
            this.parent[0] = new NodeMaxMin(parentZero, 0, 0);
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
            nodeArr[0].parent[i] = new NodeMaxMin(nodeArr[0], 0, 0);
        }

        for (int i = 1; i <= N; i++) {
            nodeArr[i] = new Node();
            nodeArr[i].num = i;
        }

        Node root = nodeArr[1];
        edgeList = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            edgeList[i] = new LinkedList<>();
        }
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edgeList[a].add(new Edge(a, b, d));
            edgeList[b].add(new Edge(b, a, d));
        }

        visited[1] = true;
        makeTree();

        for (int y = 1; y < 20; y++) {
            for (int x = 1; x <= N; x++) {
                long max = Math.max(nodeArr[x].parent[y - 1].max, nodeArr[nodeArr[x].parent[y - 1].node.num].parent[y - 1].max);
                long min = Math.min(nodeArr[x].parent[y - 1].min, nodeArr[nodeArr[x].parent[y - 1].node.num].parent[y - 1].min);
                Node node = nodeArr[nodeArr[x].parent[y - 1].node.num].parent[y - 1].node;
                NodeMaxMin nodeMaxMin = new NodeMaxMin(node, max, min);
                nodeArr[x].parent[y] = nodeMaxMin;
            }
        }

//        for (Node node : nodeArr) {
//            NodeMaxMin[] parent = node.parent;
//            for (NodeMaxMin nodeMaxMin : parent) {
////                System.out.println(node.num+" 노드넘 "+nodeMaxMin.node.num+"  노드패런트넘 "+nodeMaxMin.max+" 맥스 " + nodeMaxMin.min+" 민");
//            }
//        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            resultMin = Long.MAX_VALUE;
            resultMax = Long.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int lcaA = Integer.parseInt(st.nextToken());
            int lcaB = Integer.parseInt(st.nextToken());
            doLCA(lcaA, lcaB);
            bw.write(resultMin + " " + resultMax + "\n");
        }


        bw.flush();
        bw.close();
        br.close();

    }

    private static void makeTree() {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(nodeArr[1]);

        while (queue.size() > 0) {
            Node poll = queue.poll();
            int cur = poll.num;

            List<Edge> edges = edgeList[cur];
            for (Edge edge : edges) {
                int child = edge.end;
                if (visited[child] == true) {
                    continue;
                }
                visited[child] = true;
                NodeMaxMin nodeMaxMin = new NodeMaxMin(nodeArr[cur], edge.dist, edge.dist);
                nodeArr[child].parent[0] = nodeMaxMin;
                nodeArr[cur].childs.add(nodeArr[child]);
                nodeArr[child].depth = poll.depth + 1;
                nodeArr[child].dist = poll.dist;
                queue.offer(nodeArr[child]);
            }
        }
    }

    private static void doLCA(int pre, int cur) {
        Node preNode = nodeArr[pre];
        Node curNode = nodeArr[cur];
        long resultdist = 0;
        if (preNode == curNode) {
            resultMin = 0;
            resultMax = 0;
            return;
        }
        // curNode의 depth를 더 낮게 해서 편하게 할려고
        if (preNode.depth > curNode.depth) {
            preNode = nodeArr[cur];
            curNode = nodeArr[pre];
        }
        // curNode의 parent가 prenode이면 당연히 LCA도 prenode
        if (curNode.parent[0].node == preNode) {
            resultMax = curNode.parent[0].max;
            resultMin = curNode.parent[0].min;
            return;
        }
        for (int i = 19; i >= 0; i--) {
            if (curNode.depth - preNode.depth >= (1 << i)) {
                resultMax = Math.max(resultMax, curNode.parent[i].max);
                resultMin = Math.min(resultMin, curNode.parent[i].min);
                curNode = curNode.parent[i].node;
                if (curNode == preNode) {
                    return;
                }
            }
        }
        if (curNode.parent[0].node != preNode.parent[0].node) {
            for (int i = 19; i >= 0; i--) {
                if (preNode.parent[i].node != curNode.parent[i].node) {
//                    System.out.println("여기오는구나?"+curNode.num+" "+preNode.num+" "+pre+" "+cur);
                    resultMax = Math.max(resultMax, curNode.parent[i].max);
                    resultMin = Math.min(resultMin, curNode.parent[i].min);
                    resultMax = Math.max(resultMax, preNode.parent[i].max);
                    resultMin = Math.min(resultMin, preNode.parent[i].min);
                    preNode = preNode.parent[i].node;
                    curNode = curNode.parent[i].node;
                }
            }
        }
        if (preNode.parent[0].node == curNode.parent[0].node) {
            resultMax = Math.max(resultMax, curNode.parent[0].max);
            resultMin = Math.min(resultMin, curNode.parent[0].min);
            resultMax = Math.max(resultMax, preNode.parent[0].max);
            resultMin = Math.min(resultMin, preNode.parent[0].min);
            return;
        }
        return;
    }

}