import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;

    static FireBall[][] beforeMove;
    static FireBall[][] afterMove;

    // 문제 조건에 따른 방향
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    static void move() {

        afterMove = new FireBall[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (beforeMove[r][c] != null) {
                    FireBall cur = beforeMove[r][c];
                    boolean ismerged = cur.move();
                    if (!ismerged) {
                        if (afterMove[cur.r][cur.c] != null) {
                            afterMove[cur.r][cur.c].merge(cur);
                        } else {
                            afterMove[cur.r][cur.c] = cur;
                        }
                    }
                }
            }
        }

        beforeMove = afterMove;
    }

    static class FireBall {
        int r;
        int c;
        int m;
        int s;
        int d;

        boolean merged = false;
        boolean alloddeven = true;
        int oddeven = 0;
        int mergecnt = 1;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        public int getM() {
            return m;
        }

        public void setM(int m) {
            this.m = m;
        }

        public int getS() {
            return s;
        }

        public void setS(int s) {
            this.s = s;
        }

        public int getD() {
            return d;
        }

        public void setD(int d) {
            this.d = d;
        }

        boolean move() {

            if (this.merged) {
                if ((this.m / 5) != 0) {
                    int[] direction;
                    if (this.alloddeven) {
                        direction = new int[]{0, 2, 4, 6};
                    } else {
                        direction = new int[]{1, 3, 5, 7};
                    }
                    for (int i = 0; i < 4; i++) {
                        int ns = this.s / this.mergecnt;
                        int nr = outBound((this.r + dr[direction[i]] * ns));
                        int nc = outBound((this.c + dc[direction[i]] * ns));
                        FireBall nfire = new FireBall(nr, nc, this.m / 5, ns, direction[i]);
                        if (afterMove[nr][nc] != null) {
                            afterMove[nr][nc].merge(nfire);
                        } else {
                            afterMove[nr][nc] = nfire;
                        }
                    }
                }
                return true;
            } else {

                int nr = outBound((this.r + dr[this.d] * this.s));
                int nc = outBound((this.c + dc[this.d] * this.s));

                this.r = nr;
                this.c = nc;
                return false;
            }

        }

        int outBound(int rc) {
            if (rc < 1) {
                while (rc < 1) {
                    rc = rc + N;
                }
            } else if (rc > N) {
                while (rc > N) {
                    rc = rc - N;
                }
            }
            return rc;
        }

        void merge(FireBall food) {
            if (this.merged == false) {
                this.oddeven = (this.d % 2);
                if (this.oddeven != (food.d % 2)) {
                    this.alloddeven = false;
                }
            } else {
                if (this.oddeven != (food.d % 2)) {
                    this.alloddeven = false;
                }
            }
            mergecnt++;

            this.m += food.m;
            this.s += food.s;

            this.merged = true;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        beforeMove = new FireBall[N + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            beforeMove[r][c] = new FireBall(r, c, m, s, d);
        }

        for (int i = 1; i <= K; i++) {
            move();

//            for(int r = 1; r <= N; r++){
//                for(int c = 1; c <= N; c++){
//                    if(beforeMove[r][c]!=null){
//                    System.out.print(beforeMove[r][c].m);
//                    } else {
//                        System.out.print(0);
//                    }
//                }
//                System.out.println();
//            }
        }

        int resultsum = 0;
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (beforeMove[r][c] != null && beforeMove[r][c].merged == false) {
                    resultsum += beforeMove[r][c].m;
                } else if (beforeMove[r][c] != null && beforeMove[r][c].merged == true) {
//                    System.out.println(beforeMove[r][c].m / 5);
                    resultsum += (beforeMove[r][c].m / 5) * 4;
                }
            }
        }

        bw.write(resultsum + "");
        bw.flush();
        bw.close();
        br.close();

    }

}
