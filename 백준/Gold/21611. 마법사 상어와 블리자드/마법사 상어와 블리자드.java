import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    // (N-1)/2;
    static int T;

    static SharkTheMagician stm;

    static Deque<MarblenumCount> dq;
    static int[][] board;

    // 0 상 하 좌 우
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};

    static long result;

    static class SharkTheMagician {

        int r, c;

        public SharkTheMagician(int r, int c) {
            this.r = r;
            this.c = c;
        }

        //블리자드 시전
        void castBlizzard(int d, int s) {

            for (int i = 1; i <= s; i++) {
                int nr = this.r + dr[d] * i;
                int nc = this.c + dc[d] * i;
                board[nr][nc] = 0;
            }
        }

    }

    static class MarblenumCount {
        int marblenum;
        int count;

        public MarblenumCount(int marblenum, int count) {
            this.marblenum = marblenum;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        T = (N - 1) / 2;

        stm = new SharkTheMagician(N / 2, N / 2);

        board = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            stm.castBlizzard(d, s);

            // 구슬 이동
            moveMarble();
            // 구슬 폭발
            explodeMarble();

            // 마지막은 할 필요 없으니까
            if (i != M) {
                // 구슬 재생성
                recreateMarble();
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void moveMarble() {
        // board 순회 방법을 만들어 놓으면 여기저기 쓸 수 있음
        // 하2 우4 상1 좌3 순으로 2*i 만큼씩 i <= (N-1)/2
        int curr = T;
        int curc = T;
        List<Integer> ls = new LinkedList<Integer>();
        for (int i = 1; i <= T; i++) {
            int mi = 2 * i;
            // 하
            int d = 2;
            int ir = curr;
            int ic = curc - 1;
            if (board[ir][ic] != 0) {
                ls.add(board[ir][ic]);
            }
            curr = ir;
            curc = ic;
            for (int m = 1; m < mi; m++) {
                int nr = curr + dr[d];
                int nc = curc + dc[d];
                if (board[nr][nc] != 0) {
                    ls.add(board[nr][nc]);
                }
                curr = nr;
                curc = nc;
            }
            // 우
            d = 4;
            for (int m = 1; m <= mi; m++) {
                int nr = curr + dr[d];
                int nc = curc + dc[d];
                if (board[nr][nc] != 0) {
                    ls.add(board[nr][nc]);
                }
                curr = nr;
                curc = nc;
            }
            // 상
            d = 1;
            for (int m = 1; m <= mi; m++) {
                int nr = curr + dr[d];
                int nc = curc + dc[d];
                if (board[nr][nc] != 0) {
                    ls.add(board[nr][nc]);
                }
                curr = nr;
                curc = nc;
            }
            // 좌
            d = 3;
            for (int m = 1; m <= mi; m++) {
                int nr = curr + dr[d];
                int nc = curc + dc[d];
                if (board[nr][nc] != 0) {
                    ls.add(board[nr][nc]);
                }
                curr = nr;
                curc = nc;
            }
        }
        dq = new ArrayDeque<MarblenumCount>();
        int curNum = 0;
        int streak = 0;
        int idx = 0;
        for (Integer l : ls) {
            if (idx == 0) {
                curNum = l;
                streak = 1;
                idx++;
                continue;
            }
            if (curNum != l) {
                dq.offerLast(new MarblenumCount(curNum, streak));
                curNum = l;
                streak = 1;
            } else {
                curNum = l;
                streak++;
            }
            idx++;
            if (idx == ls.size()) {
                dq.offerLast(new MarblenumCount(curNum, streak));
            }
        }

    }

    private static void explodeMarble() {

        boolean isExploded = true;

        while (isExploded) {
            isExploded = false;
            int size = dq.size();

            Deque<MarblenumCount> newdq = new ArrayDeque<>();

            while (dq.size() > 0) {
                MarblenumCount marblenumCount = dq.pollFirst();
                if (marblenumCount.count < 4) {
                    if (newdq.size() > 0) {
                        if (newdq.peekLast().marblenum != marblenumCount.marblenum) {
                            newdq.offerLast(marblenumCount);
                        } else {
                            newdq.peekLast().count += marblenumCount.count;
                        }
                    } else {
                        newdq.add(marblenumCount);
                    }
                } else {
                    int mul = marblenumCount.marblenum * marblenumCount.count;
                    result += mul;
                    isExploded = true;
                }
            }
            dq = newdq;
        }

    }

    private static void recreateMarble() {
        board = new int[N][N];

        int count = 0;
        int marblenum = 0;
        int curmc = 0;
        if (dq.size() > 0) {
            MarblenumCount curNC = dq.pollFirst();
            count = curNC.count;
            marblenum = curNC.marblenum;
        }

        int curr = T;
        int curc = T;
        for (int i = 1; i <= T; i++) {
            int mi = 2 * i;
            // 하
            int d = 2;
            int ir = curr;
            int ic = curc - 1;
            board[ir][ic] = count;
            curmc = 1;

            curr = ir;
            curc = ic;
            for (int m = 1; m < mi; m++) {
                int nr = curr + dr[d];
                int nc = curc + dc[d];
                if (curmc == 1) {
                    board[nr][nc] = marblenum;
                    if (dq.size() > 0) {
                        MarblenumCount curNC = dq.pollFirst();
                        count = curNC.count;
                        marblenum = curNC.marblenum;
                    } else {
                        marblenum = 0;
                        count = 0;
                    }
                    curmc = 0;
                } else if (curmc == 0) {
                    board[nr][nc] = count;
                    curmc = 1;
                }
                curr = nr;
                curc = nc;
            }
            // 우
            d = 4;
            for (int m = 1; m <= mi; m++) {
                int nr = curr + dr[d];
                int nc = curc + dc[d];
                if (curmc == 1) {
                    board[nr][nc] = marblenum;
                    if (dq.size() > 0) {
                        MarblenumCount curNC = dq.pollFirst();
                        count = curNC.count;
                        marblenum = curNC.marblenum;
                    } else {
                        marblenum = 0;
                        count = 0;
                    }
                    curmc = 0;
                } else if (curmc == 0) {
                    board[nr][nc] = count;
                    curmc = 1;
                }
                curr = nr;
                curc = nc;
            }
            // 상
            d = 1;
            for (int m = 1; m <= mi; m++) {
                int nr = curr + dr[d];
                int nc = curc + dc[d];
                if (curmc == 1) {
                    board[nr][nc] = marblenum;
                    if (dq.size() > 0) {
                        MarblenumCount curNC = dq.pollFirst();
                        count = curNC.count;
                        marblenum = curNC.marblenum;
                    } else {
                        marblenum = 0;
                        count = 0;
                    }
                    curmc = 0;
                } else if (curmc == 0) {
                    board[nr][nc] = count;
                    curmc = 1;
                }
                curr = nr;
                curc = nc;
            }
            // 좌
            d = 3;
            for (int m = 1; m <= mi; m++) {
                int nr = curr + dr[d];
                int nc = curc + dc[d];
                if (curmc == 1) {
                    board[nr][nc] = marblenum;
                    if (dq.size() > 0) {
                        MarblenumCount curNC = dq.pollFirst();
                        count = curNC.count;
                        marblenum = curNC.marblenum;
                    } else {
                        marblenum = 0;
                        count = 0;
                    }
                    curmc = 0;
                } else if (curmc == 0) {
                    board[nr][nc] = count;
                    curmc = 1;
                }
                curr = nr;
                curc = nc;
            }
        }

    }


}