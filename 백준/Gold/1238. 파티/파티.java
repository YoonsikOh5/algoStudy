import java.io.*;
import java.util.*;

public class Main {

    static int N, M, X;
    static List<Road>[] oneWayRoads;

    static class Road {
        int start;
        int end;
        int length;

        public Road(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        oneWayRoads = new List[N + 1];
        for(int i = 0; i <= N; i++){
            oneWayRoads[i] = new LinkedList<Road>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            oneWayRoads[start].add(new Road(start, end, length));
        }
        int longestTime = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }
            longestTime = Math.max(longestTime, doDijkstra(i));
        }

        bw.write(longestTime + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Line {
        int end;
        int len;

        public Line(int end, int len) {
            this.end = end;
            this.len = len;
        }
    }

    private static int doDijkstra(int start) {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Line> pq = new PriorityQueue<Line>(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.len - o2.len;
            }
        });
        pq.add(new Line(start, 0));

        int lenToX = 0;
        while (pq.size() > 0) {
            Line poll = pq.poll();
            int curNum = poll.end;
            int curLen = poll.len;
            visited[curNum] = true;
            if (curNum == X) {
                lenToX = curLen;
                break;
            }
            List<Road> oneWayRoad = oneWayRoads[curNum];
            for (int i = 0; i < oneWayRoad.size(); i++) {
                Road road = oneWayRoad.get(i);
                if (visited[road.end] == false) {
                    pq.offer(new Line(road.end, (curLen + road.length)));
                }
            }
        }

        visited = new boolean[N + 1];
        pq = new PriorityQueue<Line>(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.len - o2.len;
            }
        });
        pq.add(new Line(X, 0));

        int lenFromX = 0;
        while (pq.size() > 0) {
            Line poll = pq.poll();
            int curNum = poll.end;
            int curLen = poll.len;
            visited[curNum] = true;
            if (curNum == start) {
                lenFromX = curLen;
                break;
            }
            List<Road> oneWayRoad = oneWayRoads[curNum];
            for (int i = 0; i < oneWayRoad.size(); i++) {
                Road road = oneWayRoad.get(i);
                if (visited[road.end] == false) {
                    pq.offer(new Line(road.end, (curLen + road.length)));
                }
            }
        }

        return (lenToX+lenFromX);
    }
}