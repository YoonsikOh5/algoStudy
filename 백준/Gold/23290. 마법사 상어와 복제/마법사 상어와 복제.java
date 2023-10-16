import java.io.*;
import java.util.*;

public class Main {

    static int M, S;
    static List<Fish>[][] fsBoard;
    static boolean[][] scBoard;
    static List<Scent> scList;
    static Shark shark;
    // 1번인덱스부터 좌 좌상 상 우상 우 우하 하 좌하
    static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    static class Scent {
        int r;
        int c;
        int cnt;

        public Scent(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static class Shark {
        int r;
        int c;

        public Shark(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Fish {
        int curr;
        int curc;
        int curd;


        public Fish(int r, int c, int d) {
            this.curr = r;
            this.curc = c;
            this.curd = d;
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        fsBoard = new List[5][5];
        scList = new LinkedList<Scent>();
        for (int r = 1; r <= 4; r++) {
            for (int c = 1; c <= 4; c++) {
                fsBoard[r][c] = new LinkedList<Fish>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Fish fish = new Fish(r, c, d);
            fsBoard[r][c].add(fish);
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        shark = new Shark(r, c);
        for (int t = 1; t <= S; t++) {
            // 1. 복제 마법 시전
            List<Fish> dupList = doDuplicate();

            // 2. 물고기 한 칸 이동
            moveFishes();

            // 3. 상어 3칸 이동
            moveShark();

            // 4. 2번 전의 냄새 없애기
            removeScent();

            // 5. 복제 마법 완료
            finishDuplicate(dupList);
        }
        long result = cntResult();

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();

    }

    private static long cntResult() {
        long result = 0;
        for (int r = 1; r <= 4; r++) {
            for (int c = 1; c <= 4; c++) {
                result += fsBoard[r][c].size();
            }
        }
        return result;
    }

    // 1번 인덱스부터 상좌하우
    static int[] sr = {0, -1, 0, 1, 0};
    static int[] sc = {0, 0, -1, 0, 1};

    static class SharkRoute {
        int m1r;
        int m1c;
        int m2r;
        int m2c;
        int m3r;
        int m3c;

        int sum;

        public SharkRoute() {
        }
    }

    private static void moveShark() {
        SharkRoute selectedRoute = new SharkRoute();
        selectedRoute.sum = -1;
        for (int m1 = 1; m1 <= 4; m1++) {
            int m1r = shark.r + sr[m1];
            int m1c = shark.c + sc[m1];
            if (!inRange(m1r, m1c)) continue;
            for (int m2 = 1; m2 <= 4; m2++) {
                int m2r = m1r + sr[m2];
                int m2c = m1c + sc[m2];
                if (!inRange(m2r, m2c)) continue;
                for (int m3 = 1; m3 <= 4; m3++) {
                    int m3r = m2r + sr[m3];
                    int m3c = m2c + sc[m3];
                    if (!inRange(m3r, m3c)) continue;
                    SharkRoute sharkRoute = new SharkRoute();
                    boolean visited[][] = new boolean[5][5];
                    sharkRoute.sum += fsBoard[m1r][m1c].size();
                    visited[m1r][m1c] = true;
                    if (!visited[m2r][m2c]) {
                        sharkRoute.sum += fsBoard[m2r][m2c].size();
                        visited[m2r][m2c] = true;
                    }
                    if (!visited[m3r][m3c]) {
                        sharkRoute.sum += fsBoard[m3r][m3c].size();
                    }
                    if (selectedRoute.sum < sharkRoute.sum) {
                        selectedRoute = sharkRoute;
                        sharkRoute.m1r = m1r;
                        sharkRoute.m1c = m1c;
                        sharkRoute.m2r = m2r;
                        sharkRoute.m2c = m2c;
                        sharkRoute.m3r = m3r;
                        sharkRoute.m3c = m3c;
                    }
                }
            }
        }

        if (fsBoard[selectedRoute.m1r][selectedRoute.m1c].size() > 0) {
            scList.add(new Scent(selectedRoute.m1r, selectedRoute.m1c, 0));
            fsBoard[selectedRoute.m1r][selectedRoute.m1c] = new LinkedList<>();
        }
        if (fsBoard[selectedRoute.m2r][selectedRoute.m2c].size() > 0) {
            scList.add(new Scent(selectedRoute.m2r, selectedRoute.m2c, 0));
            fsBoard[selectedRoute.m2r][selectedRoute.m2c] = new LinkedList<>();
        }
        if (fsBoard[selectedRoute.m3r][selectedRoute.m3c].size() > 0) {
            scList.add(new Scent(selectedRoute.m3r, selectedRoute.m3c, 0));
            fsBoard[selectedRoute.m3r][selectedRoute.m3c] = new LinkedList<>();
        }
        shark.r = selectedRoute.m3r;
        shark.c = selectedRoute.m3c;
    }

    private static void moveFishes() {
        scBoard = new boolean[5][5];
        for (Scent scent : scList) {
            scBoard[scent.r][scent.c] = true;
        }

        List<Fish>[][] tempBoard = new List[5][5];
        for (int r = 1; r <= 4; r++) {
            for (int c = 1; c <= 4; c++) {
                tempBoard[r][c] = new LinkedList<Fish>();
            }
        }

        for (int r = 1; r <= 4; r++) {
            for (int c = 1; c <= 4; c++) {
                List<Fish> fish = fsBoard[r][c];
                for (Fish cfish : fish) {
                    int curr = cfish.curr;
                    int curc = cfish.curc;
                    int curd = cfish.curd;
                    boolean isMoved = false;
                    for (int d = curd; d >= 1; d--) {
                        int nr = curr + dr[d];
                        int nc = curc + dc[d];
                        if (inRange(nr, nc)) {
                            if (!(nr == shark.r && nc == shark.c) && !scBoard[nr][nc]) {
                                isMoved = true;
                                Fish nfish = new Fish(nr, nc, d);
                                tempBoard[nr][nc].add(nfish);
                                break;
                            }
                        }
                    }
                    if (!isMoved) {
                        for (int d = 8; d > curd; d--) {
                            int nr = curr + dr[d];
                            int nc = curc + dc[d];
                            if (inRange(nr, nc)) {
                                if (!(nr == shark.r && nc == shark.c) && !scBoard[nr][nc]) {
                                    isMoved = true;
                                    Fish nfish = new Fish(nr, nc, d);
                                    tempBoard[nr][nc].add(nfish);
                                    break;
                                }
                            }
                        }
                    }
                    if(!isMoved){
                        tempBoard[curr][curc].add(cfish);
                    }
                }
            }
        }
        fsBoard = tempBoard;
    }

    private static boolean inRange(int nr, int nc) {
        if (nr >= 1 && nr <= 4 && nc >= 1 && nc <= 4) {
            return true;
        } else {
            return false;
        }
    }

    private static void removeScent() {
        List<Scent> removeList = new LinkedList<>();
        for (Scent scent : scList) {
            scent.cnt++;
            if (scent.cnt == 3) {
                removeList.add(scent);
            }
        }
        for (Scent scent : removeList) {
            scList.remove(scent);
        }
    }

    private static void finishDuplicate(List<Fish> dupList) {
        for (Fish fish : dupList) {
            int curr = fish.curr;
            int curc = fish.curc;
            fsBoard[curr][curc].add(fish);
        }
    }

    private static List<Fish> doDuplicate() {
        List<Fish> dupList = new LinkedList<>();
        for (int r = 1; r <= 4; r++) {
            for (int c = 1; c <= 4; c++) {
                List<Fish> fishes = fsBoard[r][c];
                for (Fish fish : fishes) {
                    int curr = fish.curr;
                    int curc = fish.curc;
                    int curd = fish.curd;
                    Fish nfish = new Fish(curr, curc, curd);
                    dupList.add(nfish);
                }
            }
        }
        return dupList;
    }


}