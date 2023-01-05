import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int C, R;
    static int N, M;

    static Robot[] robots;
    static int board[][];

    // 방향 0북,1동,2남,3서 r의 방향이 위로 올라가는거 주의
    static int dr[] = {1, 0, -1, 0};
    static int dc[] = {0, 1, 0, -1};

    static BufferedWriter bw;

    static class Robot {

        int num;
        int r;
        int c;

        // 방향 0북,1동,2남,3서
        int direction;

        public Robot(int num, int r, int c, int direction) {
            this.num = num;
            this.r = r;
            this.c = c;
            this.direction = direction;
        }

        boolean docmd(char cmd) throws IOException {

            if (cmd == 'L') {
                this.direction = this.direction - 1;
                if (this.direction == -1) {
                    this.direction = 3;
                }
            } else if (cmd == 'R') {
                this.direction = this.direction + 1;
                if (this.direction == 4) {
                    this.direction = 0;
                }
            } else if (cmd == 'F') {
                int nr = this.r + dr[this.direction];
                int nc = this.c + dc[this.direction];

                if (inRange(nr, nc)) {
                    if (board[nr][nc] == 0) {
                        board[this.r][this.c] = 0;
                        board[nr][nc] = this.num;
                        this.r = nr;
                        this.c = nc;
                    } else {
                        bw.write("Robot " + this.num + " crashes into robot " + board[nr][nc]);
                        return false;
                    }
                } else {
                    bw.write("Robot " + this.num + " crashes into the wall");
                    return false;
                }
            }
            return true;
        }

    }

    static boolean inRange(int nr, int nc) {
        if (nr >= 1 && nr <= R && nc >= 1 && nc <= C) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[R + 1][C + 1];

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        robots = new Robot[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            int dirint = -1;
            if (direction == 'N') {
                dirint = 0;
            } else if (direction == 'E') {
                dirint = 1;
            } else if (direction == 'S') {
                dirint = 2;
            } else if (direction == 'W') {
                dirint = 3;
            }
            Robot robot = new Robot(i, r, c, dirint);
            robots[i] = robot;

            board[r][c] = i;
        }

        boolean isOK = false;
        outloop: for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int robotnum = Integer.parseInt(st.nextToken());
            char cmd = st.nextToken().charAt(0);
            int repeat = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= repeat; j++) {
                isOK = robots[robotnum].docmd(cmd);
                if (!isOK) {
                    break outloop;
                }
            }
        }

        if (isOK) {
            bw.write("OK");
        }

//        for(int r = R; r >= 1; r--){
//            for(int c = 1; c <= C; c++){
//                System.out.print(board[r][c]);
//            }
//            System.out.println();
//        }

        bw.flush();
        bw.close();
        br.close();

    }


}
