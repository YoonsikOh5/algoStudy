import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int L, R, C;
    static char[][][] building;
    static LRC start;
    static int[][][] steps;

    //동서남북상하
    static int[] dl = {0, 0, 0, 0, -1, 1};
    static int[] dr = {1, -1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};

    static class LRC {

        int l;
        int r;
        int c;

        public LRC(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        while (!(L == 0 && R == 0 && C == 0)) {
            building = new char[L][R][C];

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String str = br.readLine();
                    for (int c = 0; c < C; c++) {
                        char cur = str.charAt(c);
                        building[l][r][c] = cur;
                        if (cur == 'S') {
                            start = new LRC(l, r, c);
                        }
                    }
                }
                br.readLine();
            }

            int minute = bfs();

            if (minute == -1) {
                bw.write("Trapped!\n");
            } else {
                bw.write("Escaped in " + minute + " minute(s).\n");
            }

            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

        }

        bw.flush();
        bw.close();
        br.close();

    }

    static int bfs() {

        steps = new int[L][R][C];
        // 밑에서 1 뺄꺼임
        steps[start.l][start.r][start.c] = 1;

        Queue<LRC> q = new LinkedList<>();

        q.offer(start);

        while (q.size() > 0) {

            LRC cur = q.poll();

            int curl = cur.l;
            int curr = cur.r;
            int curc = cur.c;
            int curstep = steps[curl][curr][curc];

            for (int d = 0; d < 6; d++) {
                int nl = curl + dl[d];
                int nr = curr + dr[d];
                int nc = curc + dc[d];

                if (inRange(nl, nr, nc) && building[nl][nr][nc]!='#'){
                    if(steps[nl][nr][nc]==0){
                        if(building[nl][nr][nc]=='.'){
                            steps[nl][nr][nc] = curstep+1;
                            q.offer(new LRC(nl,nr,nc));
                        } else if(building[nl][nr][nc]=='E'){
                            return curstep;
                        }
                    }
                }
            }

        }

        return -1;
    }

    static boolean inRange(int nl, int nr, int nc) {
        if (nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C) {
            return true;
        } else {
            return false;
        }
    }

}
