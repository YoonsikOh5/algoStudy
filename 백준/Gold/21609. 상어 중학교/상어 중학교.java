import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    static int[][] matrix;
    static boolean[][] visited;

    static class RC {
        int r;
        int c;

        public RC(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Group {

        int color;

        int rainbowCnt;

        RC head;

        List<RC> ls = new ArrayList<>();

        public Group(int color, RC head) {
            this.color = color;
            this.head = head;
        }

        void addBlock(RC block, boolean isRainbow) {
            if (isRainbow) {
                rainbowCnt++;
            }
            ls.add(block);
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][N];

        long score = 0;

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                matrix[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        

        boolean run = true;
        while (run) {
        visited = new boolean[N][N];
            PriorityQueue<Group> pq = new PriorityQueue<>(new Comparator<Group>() {
                @Override
                public int compare(Group o1, Group o2) {
                    if (o1.ls.size() == o2.ls.size()) {
                        if (o1.rainbowCnt == o2.rainbowCnt) {
                            if (o1.head.r == o2.head.r) {
                                return o2.head.c - o1.head.c;
                            }
                            return o2.head.r - o1.head.r;
                        }
                        return o2.rainbowCnt - o1.rainbowCnt;
                    }
                    return o2.ls.size() - o1.ls.size();
                }
            });

            // 1. 크기가 가장 큰 블록 그룹 찾기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int cur = matrix[r][c];
                    if (!visited[r][c] && cur > 0) {
                        visited[r][c] = true;
                        Group group = findGroup(r, c);
                        int size = group.ls.size();
                        pq.add(group);
                    }
                }
            }
            if (pq.size() > 0) {
                // 2-1. 찾은 블록 그룹 제거하기
                Group poll = pq.poll();
                int size = poll.ls.size();
                if(size==1){
                    break;
                }
                for (RC l : poll.ls) {
                    matrix[l.r][l.c] = -2;
                }


                // 2-2. 점수 획득
                score += (size * size);

                // 3. 중력 작용
                gravity();


                // 4. 90도 반시계 회전
                rotate90();


                // 5. 중력 작용
                gravity();


            } else {
                run = false;
            }
        }

        bw.write(score + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void rotate90() {
        int[][] after90 = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                after90[N - c - 1][r] = matrix[r][c];
            }
        }

        matrix = after90;
    }

    private static void gravity() {

        for (int c = 0; c < N; c++) {
            for (int r = (N - 1); r >= 0; r--) {
                if (matrix[r][c] == -2) {
                    for (int curr = r - 1; curr >= 0; curr--) {
                        if (matrix[curr][c] == -2) {
                            continue;
                        }
                        if (matrix[curr][c] == -1) {
                            break;
                        }
                        matrix[r][c] = matrix[curr][c];
                        matrix[curr][c] = -2;
                        break;
                    }
                }
            }
        }

    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    private static Group findGroup(int r, int c) {

        RC rc = new RC(r, c);
        int color = matrix[r][c];
        Group group = new Group(color, rc);
        group.addBlock(new RC(r,c),false);
        boolean[][] rainbowvisited = new boolean[N][N];

        Queue<RC> q = new LinkedList<>();
        q.offer(rc);

        while (q.size() > 0) {
            RC poll = q.poll();

            int pr = poll.r;
            int pc = poll.c;

            for (int d = 0; d < 4; d++) {
                int nr = pr + dr[d];
                int nc = pc + dc[d];

                if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                    if (visited[nr][nc] == false) {
                        if (matrix[nr][nc] == color) {
                            visited[nr][nc] = true;
                            group.addBlock(new RC(nr, nc), false);
                            q.offer(new RC(nr, nc));
                        }
                    }
                    if (rainbowvisited[nr][nc] == false && matrix[nr][nc] == 0) {
                        rainbowvisited[nr][nc] = true;
                        group.addBlock(new RC(nr, nc), true);
                        q.offer(new RC(nr, nc));
                    }
                }
            }

        }

        return group;

    }

}