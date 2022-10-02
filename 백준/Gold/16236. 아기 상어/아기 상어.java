import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int map[][];
	static boolean visited[][];
	static int result_sec;
	static int sec_count;
	static Bshark babyshark;

	public static class Bshark {
		int curr;
		int curc;
		// 처음 사이즈 2
		int len = 2;
		// 현재까지 먹은 물고기 수
		int stomach;

		public Bshark(int curr, int curc) {
			this.curr = curr;
			this.curc = curc;
		}

		void eatFish(Fish food) {
			// 물고기 먹었으니 물고기 자리로 가고 물고기자리 0 은 bfs에서 해줌
			this.curr = food.r;
			this.curc = food.c;

			// 물고기가 6까지밖에 없으니까 7이후는 사실상 의미 없음
			if (this.len < 7) {
				stomach++;
				if (stomach == this.len) {
					len++;
					stomach = 0;
				}
			}
		}
	}

	public static class Fish implements Comparable<Fish> {
		int r;
		int c;
		int len;

		public Fish(int r, int c, int len) {
			this.r = r;
			this.c = c;
			this.len = len;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.r == o.r) {
				return this.c - o.c;
			}
			return this.r - o.r;
		}

	}

	public static class RC {
		int r;
		int c;

		public RC(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int cur = Integer.parseInt(st.nextToken());
				map[r][c] = cur;
				if (cur == 9) {
					babyshark = new Bshark(r, c);
				}
			}
		}

		boolean run = true;
		while (run) {
			run = bfs();
			// 물고기 먹었으면 추가
			if (run) {
				result_sec += sec_count;
			}
		}

		bw.write(result_sec+"");
		bw.flush();
		bw.close();
		br.close();
	}

	// 4방 탐색 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 먹을 상어가 있다면 먹음
	public static boolean bfs() {
		visited = new boolean[N][N];
		//
		Queue<RC> q = new LinkedList<>();
		int startr = babyshark.curr;
		int startc = babyshark.curc;

		map[startr][startc] = 0;
		visited[startr][startc] = true;
		q.add(new RC(startr, startc));

		RC bcounter = new RC(-1, -1);
		q.add(bcounter);
		sec_count = 0;
		boolean findFish = false;
		PriorityQueue<Fish> pq = new PriorityQueue<>();
		while (q.size() > 0) {
			RC cur = q.poll();

			int curr = cur.r;
			int curc = cur.c;

			if (curr == -1 && curc == -1) {
				sec_count++;
				if (findFish) {
					break;
				} else if (q.size() == 0) {
					break;
				} else {
					q.add(bcounter);
					continue;
				}
			}

			//
			for (int d = 0; d < 4; d++) {
				int nr = curr + dr[d];
				int nc = curc + dc[d];
				if (inRange(nr, nc) && visited[nr][nc] == false) {
					if (isPassable(map[nr][nc])) {
						q.add(new RC(nr, nc));
						visited[nr][nc] = true;
					} else if (isEatable(map[nr][nc])) {
						findFish = true;
						pq.add(new Fish(nr, nc, map[nr][nc]));
					}
				}
			}
		}

		if (findFish) {
			Fish food = pq.poll();

			babyshark.eatFish(food);

			return true;
		} else {

			return false;
		}

	}

	public static boolean inRange(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isEatable(int len) {
		if (len >= 1 && len < babyshark.len) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isPassable(int len) {
		if (len == 0 || len == babyshark.len) {
			return true;
		} else {
			return false;
		}
	}

}