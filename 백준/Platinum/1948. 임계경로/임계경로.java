import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int S, E;

    static List<Edge>[] edgeLs;
    static List<Edge>[] edgeBackLs;
    static int[] prevArr;
    static int[] prevBackArr;
    static MaxRoad[] maxRoads;
    static MaxRoad[] maxBackRoads;
    static int maxRoadDist;
    static int maxRoadCnt;

    static class MaxRoad {
        int maxDist;
        public MaxRoad(int maxDist) {
            this.maxDist = maxDist;
        }
    }

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

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        prevArr = new int[N + 1];

        edgeLs = new List[N + 1];

        maxRoads = new MaxRoad[N + 1];

        prevBackArr = new int[N + 1];

        edgeBackLs = new List[N + 1];

        maxBackRoads = new MaxRoad[N + 1];


        for (int i = 0; i <= N; i++) {
            edgeLs[i] = new LinkedList<>();
            edgeBackLs[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            prevArr[end]++;
            prevBackArr[start]++;
            edgeLs[start].add(new Edge(start, end, dist));
            edgeBackLs[end].add(new Edge(end, start, dist));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        maxRoads[S] = new MaxRoad(0);
        maxBackRoads[E] = new MaxRoad(0);
        // 각 노드별 최장 거리 찾는 위상정렬
        topologySort();
        maxRoadDist = maxRoads[E].maxDist;
        // 뒤로 돌면서 정방향 맥스dist + 역방향 현재까지 dist가 최대면 카운트 늘려줌
        topologySortBack();
        bw.write(maxRoadDist + "\n" + maxRoadCnt);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void topologySortBack() {
        Queue<Integer> q = new LinkedList<>();
        q.add(E);
        while (q.size() > 0) {
            Integer poll = q.poll();
            List<Edge> pollEdge = edgeBackLs[poll];
            for (Edge edge : pollEdge) {
                int start = edge.start;
                int end = edge.end;
                int dist = edge.dist;
                MaxRoad startMaxRoad = maxBackRoads[start];
                int startMaxDist = startMaxRoad.maxDist;

                if (maxBackRoads[end] == null || (maxBackRoads[end].maxDist < (startMaxDist + dist))) {
                    MaxRoad maxRoad = new MaxRoad(startMaxDist + dist);
                    maxBackRoads[end] = maxRoad;
                }

                if((maxRoads[end].maxDist+maxBackRoads[start].maxDist+dist)==maxRoadDist){
                    maxRoadCnt++;
                }

                prevBackArr[end]--;
                if (prevBackArr[end] == 0) {
                    q.offer(end);
                }
            }
        }
    }

    private static void topologySort() {
        Queue<Integer> q = new LinkedList<>();
        q.add(S);

        while (q.size() > 0) {
            Integer poll = q.poll();
            List<Edge> pollEdge = edgeLs[poll];
            for (Edge edge : pollEdge) {
                int start = edge.start;
                int end = edge.end;
                int dist = edge.dist;
                MaxRoad startMaxRoad = maxRoads[start];
                int startMaxDist = startMaxRoad.maxDist;

                if (maxRoads[end] == null || (maxRoads[end].maxDist < (startMaxDist + dist))) {
                    MaxRoad maxRoad = new MaxRoad(startMaxDist + dist);
                    maxRoads[end] = maxRoad;
                }
                prevArr[end]--;
                if (prevArr[end] == 0) {
                    q.offer(end);
                }
            }
        }
    }
}