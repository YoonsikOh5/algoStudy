import java.io.*;
import java.util.*;

class Solution {
    

    static List<Path>[] lsarr;

    static class Path {
        int nodeNum;
        int length;

        public Path(int nodeNum, int length) {
            this.nodeNum = nodeNum;
            this.length = length;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        lsarr = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            lsarr[i] = new LinkedList<>();
        }

        int length = paths.length;
        for (int i = 0; i < length; i++) {
            int from = paths[i][0];
            int to = paths[i][1];
            int len = paths[i][2];

            boolean isgateconnected = false;
            boolean issummitconnected = false;
            for (int g = 0; g < gates.length; g++) {
                if (gates[g] == from) {
                    lsarr[from].add(new Path(to, len));
                    isgateconnected = true;
                    break;
                } else if (gates[g] == to) {
                    lsarr[to].add(new Path(from, len));
                    isgateconnected = true;
                    break;
                }
            }
            for (int s = 0; s < summits.length; s++) {
                if (summits[s] == from) {
                    lsarr[to].add(new Path(from, len));
                    issummitconnected = true;
                    break;
                } else if (summits[s] == to) {
                    lsarr[from].add(new Path(to, len));
                    issummitconnected = true;
                    break;
                }
            }
            if (!isgateconnected && !issummitconnected) {
                lsarr[from].add(new Path(to, len));
                lsarr[to].add(new Path(from, len));
            }
        }

        long[] dijkstra = dijkstra(n, paths, gates, summits);

        int mingate = Integer.MAX_VALUE;
        long minintensity = Long.MAX_VALUE;
        int slen = summits.length;
        for (int i = 0; i < slen; i++) {
            if (minintensity > dijkstra[summits[i]]) {
                minintensity = dijkstra[summits[i]];
                mingate = summits[i];
            } else if (minintensity == dijkstra[summits[i]]) {
                mingate = Math.min(mingate, summits[i]);
            }
        }
        
        int intminintensity = ((Long) minintensity).intValue();
        int answer[] = {mingate, intminintensity};
        return answer;
    }

    static class NodeIntensity {
        int nodeNum;
        long intensity;

        public NodeIntensity(int nodeNum, long intensity) {
            this.nodeNum = nodeNum;
            this.intensity = intensity;
        }
    }

    private static long[] dijkstra(int n, int[][] paths, int[] gates, int[] summits) {
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<NodeIntensity> pq = new PriorityQueue(new Comparator<NodeIntensity>() {
            @Override
            public int compare(NodeIntensity o1, NodeIntensity o2) {
                return (int) (o1.intensity - o2.intensity);
            }
        });

        long[] intensity = new long[n + 1];
        Arrays.fill(intensity, Long.MAX_VALUE);
        int visitedNodeCnt = 0;

        int glen = gates.length;
        for (int i = 0; i < glen; i++) {
            int gate = gates[i];
            visited[gate] = true;
            visitedNodeCnt++;
            intensity[gate] = 0;
            List<Path> gpaths = lsarr[gate];
            for (Path gpath : gpaths) {
                int nodeNum = gpath.nodeNum;
                int length = gpath.length;

                long max = Math.max(0, length);
                if (intensity[nodeNum] > max) {
                    intensity[nodeNum] = max;
                    pq.offer(new NodeIntensity(nodeNum, intensity[nodeNum]));
                }
            }
        }

        while (pq.size() > 0) {
            NodeIntensity poll = pq.poll();
            if (visited[poll.nodeNum]) {
                continue;
            }
            visited[poll.nodeNum] = true;
            visitedNodeCnt++;

            List<Path> gpaths = lsarr[poll.nodeNum];
            for (Path gpath : gpaths) {
                int nodeNum = gpath.nodeNum;
                int length = gpath.length;
                if (visited[nodeNum] == false) {

                    long max = Math.max(intensity[poll.nodeNum], length);
                    if (intensity[nodeNum] > max) {
                        intensity[nodeNum] = max;
                        pq.offer(new NodeIntensity(nodeNum, intensity[nodeNum]));
                    }

                }
            }
        }
        return intensity;
    }
}