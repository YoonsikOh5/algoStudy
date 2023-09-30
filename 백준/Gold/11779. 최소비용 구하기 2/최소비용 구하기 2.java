import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int start, end;
    static List<Edge>[] els;

    static class Edge {
        int left;
        int right;
        int cost;

        public Edge(int left, int right, int cost) {
            this.left = left;
            this.right = right;
            this.cost = cost;
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        els = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) {
            els[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            els[start].add(new Edge(start, end, len));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Util dodijk = dodijk();
        long sum = dodijk.sum;
        bw.write(sum + "\n");
        int size = dodijk.ls.size();
        bw.write((size+1)+ "\n");
        bw.write(start + " ");
        List<Integer> ls = dodijk.ls;
        for (Integer l : ls) {
            bw.write(l + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Util {
        int end;
        long sum;
        List<Integer> ls;

        public Util(int end, long sum) {
            this.end = end;
            this.sum = sum;
            this.ls = new LinkedList<>();
        }
    }

    private static Util dodijk() {
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Util> pq = new PriorityQueue<>(new Comparator<Util>() {
            @Override
            public int compare(Util o1, Util o2) {
                long l = o1.sum - o2.sum;
                if (l > 0) {
                    return 1;
                } else if (l == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        List<Edge> el = els[start];
        visited[start] = true;
        for (Edge edge : el) {
            Util util = new Util(edge.right, edge.cost);
            util.ls.add(edge.right);
            pq.offer(util);
        }

        while (pq.size() > 0) {
            Util poll = pq.poll();
            int pend = poll.end;
            long psum = poll.sum;
            List<Integer> ls = poll.ls;
            if (pend == end) {
                return poll;
            }
            visited[pend] = true;

            List<Edge> el1 = els[pend];
            for (Edge edge : el1) {
                if (visited[edge.right] == false) {
                    long l = psum + edge.cost;
                    Util util = new Util(edge.right, l);
                    for (Integer integer : ls) {
                        util.ls.add(integer);
                    }
                    util.ls.add(edge.right);
                    pq.offer(util);
                }
            }
        }
        return null;
    }
}