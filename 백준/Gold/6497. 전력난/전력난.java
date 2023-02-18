import java.io.*;
import java.util.*;


public class Main {

    static int m, n;

    static PriorityQueue<Road> pq;

    static int parent[];

    static class Road implements Comparable<Road> {
        int x;
        int y;
        int z;

        public Road(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }


        @Override
        public int compareTo(Road o) {
            return this.z - o.z;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean run = true;
        while (run) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) {
                break;
            }

            pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                pq.offer(new Road(x, y, z));
            }

            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            doKruskal();

            bw.write(resultsum + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static long resultsum;

    private static void doKruskal() {
        resultsum=0;
        while (pq.size() > 0) {

            Road curRoad = pq.poll();

            if (!union(curRoad.x, curRoad.y)) {
                resultsum += curRoad.z;
            }

        }

    }

    private static boolean union(int x, int y) {
        int xparent = findParent(x);
        int yparent = findParent(y);
        if (xparent != yparent) {
            parent[xparent] = yparent;
            return true;
        }
        return false;
    }

    private static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = findParent(parent[x]);
            return parent[x];
        }
    }


}
