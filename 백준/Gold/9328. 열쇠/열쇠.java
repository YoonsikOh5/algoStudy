import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int t;
    static int h, w;

    static char[][] building;

    static Sanggeun sanggeun;

    static int result;

    static boolean[][] visited;

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class RC {
        int r;
        int c;

        public RC(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Sanggeun {

        HashMap<Character, List<RC>> ableDoor = new HashMap<>();
        Set<Character> ableKeys = new HashSet<>();

        public Sanggeun() {
            for (int i = 0; i < 26; i++) {
                Character c = (char) ('A' + i);
                ableDoor.put(c, new LinkedList<>());
            }
        }

        boolean getKey(char d, RC cur) {
            if (ableKeys.contains(d)) {
                return true;
            } else {
                ableDoor.get(Character.toUpperCase(d)).add(cur);
                return false;
            }
        }

        void addKey(char k) {
            ableKeys.add(k);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            sanggeun = new Sanggeun();

            building = new char[h][w];
            visited = new boolean[h][w];

            for (int r = 0; r < h; r++) {
                String height = br.readLine();
                for (int c = 0; c < w; c++) {
                    building[r][c] = height.charAt(c);
                }
            }

            String initKeys = br.readLine();
            if (!initKeys.equals("0")) {
                int length = initKeys.length();
                for (int j = 0; j < length; j++) {
                    sanggeun.addKey(initKeys.charAt(j));
                }
            }
            result = 0;
            bfs();
            bw.write(result + "\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        Queue<RC> q = new LinkedList<>();

        // 외벽을 돌면서 출발점 찾기
        // 윗 벽
        // 아랫 벽
        for (int c = 0; c < w; c++) {
            char top = building[0][c];
            if (top != '*') {
                q.offer(new RC(0, c));
                visited[0][c] = true;
            }
            char bot = building[h-1][c];
            if (bot != '*') {
                q.offer(new RC(h - 1, c));
                visited[h - 1][c] = true;
            }
        }
        // 왼 벽
        // 오른 벽
        for (int r = 1; r < h - 1; r++) {
            char left = building[r][0];
            if (left != '*') {
                q.offer(new RC(r, 0));
                visited[r][0] = true;
            }
            char right = building[r][w - 1];
            if (right != '*') {
                q.offer(new RC(r, w - 1));
                visited[r][w - 1] = true;
            }
        }

        while (q.size() > 0) {
            RC poll = q.poll();

            int r = poll.r;
            int c = poll.c;

            // 여기서 처리
            if (building[r][c] == '$') {
                result++;
            } else if (Character.isUpperCase(building[r][c])) {
                if (!sanggeun.getKey(Character.toLowerCase(building[r][c]), poll)) {
                    continue;
                }
            } else if (Character.isLowerCase(building[r][c])) {
                sanggeun.addKey(building[r][c]);
                List<RC> rcs = sanggeun.ableDoor.get(Character.toUpperCase(building[r][c]));
                for (RC rc : rcs) {
                    q.offer(rc);
                }
                rcs = new LinkedList<>();
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
                    if (building[nr][nc] != '*') {
                        if (visited[nr][nc] == false) {
                            visited[nr][nc] = true;
                            q.offer(new RC(nr, nc));
                        }
                    }
                }

            }

        }

    }

}
