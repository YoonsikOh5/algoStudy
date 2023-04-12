import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static int[][] team;
    static boolean[][] visited;
    static int teamNum;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N + 1][M + 1];
        team = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int r = 1; r <= N; r++) {
            String s = br.readLine();
            for (int c = 1; c <= M; c++) {
                board[r][c] = s.charAt(c - 1);
            }
        }

        teamNum = 0;

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                if (visited[r][c] == false) {
                    bfs(r, c);
                }
            }
        }

        bw.write(teamNum+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static class RC {
        int r;
        int c;

        public RC(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static void bfs(int r, int c) {
        visited[r][c] = true;
        Queue<RC> q = new LinkedList<>();
        Queue<RC> readyQ = new LinkedList<>();

        q.offer(new RC(r, c));
        readyQ.offer(new RC(r, c));

        int curteam = teamNum + 1;

        while (q.size() > 0) {
            RC poll = q.poll();
            int pr = poll.r;
            int pc = poll.c;
            char c1 = board[pr][pc];
            int nr = pr;
            int nc = pc;
            switch (c1) {
                case 'U':
                    nr -= 1;
                    break;
                case 'D':
                    nr += 1;
                    break;
                case 'R':
                    nc += 1;
                    break;
                case 'L':
                    nc -= 1;
                    break;
            }
            if (visited[nr][nc] == true) {
                if (team[nr][nc] == 0) {
                    break;
                } else if (team[nr][nc] != 0) {
                    curteam = team[nr][nc];
                    break;
                }
            } else {
                visited[nr][nc] = true;
                q.offer(new RC(nr, nc));
                readyQ.offer(new RC(nr, nc));
            }
        }

        while (readyQ.size() > 0) {
            RC poll = readyQ.poll();
            team[poll.r][poll.c] = curteam;
        }
        if (curteam == teamNum + 1) {
            teamNum += 1;
        }

    }


}