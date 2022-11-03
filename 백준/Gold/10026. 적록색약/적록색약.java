import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;

	static int rgb[][];

	static boolean visited[][];

	static int normal_result_cnt = 0;
	static int rg_result_cnt = 0;

	static class RC {

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

		N = Integer.parseInt(br.readLine());

		rgb = new int[N][N];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				char nchar = str.charAt(c);
				if (nchar == 'R') {
					rgb[r][c] = 1;
				} else if (nchar == 'G') {
					rgb[r][c] = 2;
				} else if (nchar == 'B') {
					rgb[r][c] = 3;
				}
			}
		}

		// 빨강 1 초록 2 파랑 3

		visited = new boolean[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (visited[r][c] == false) {
					normalbfs(r, c);
				}
			}
		}

		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (visited[r][c] == false) {
					rgbfs(r, c);
				}
			}
		}

		bw.write(normal_result_cnt + " " + rg_result_cnt);
		bw.flush();
		bw.close();
		br.close();

	}

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void normalbfs(int sr, int sc) {
		normal_result_cnt++;
		Queue<RC> q = new LinkedList<>();
		q.add(new RC(sr, sc));
		visited[sr][sc] = true;

		while (q.size() > 0) {
			RC cur = q.poll();
			int ccolor = rgb[cur.r][cur.c];

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (inRange(nr, nc) && visited[nr][nc] == false) {
					int ncolor = rgb[nr][nc];
					if (ncolor == ccolor) {
						visited[nr][nc] = true;
						q.add(new RC(nr, nc));
					}
				}
			}

		}

	}

	public static void rgbfs(int sr, int sc) {
		rg_result_cnt++;
		Queue<RC> q = new LinkedList<>();
		q.add(new RC(sr, sc));
		visited[sr][sc] = true;

		while (q.size() > 0) {
			RC cur = q.poll();
			int ccolor = rgb[cur.r][cur.c];

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (inRange(nr, nc) && visited[nr][nc] == false) {
					int ncolor = rgb[nr][nc];
					if (ccolor == 3) {
						if (ncolor == 3) {
							visited[nr][nc] = true;
							q.add(new RC(nr, nc));
						}
					} else {
						if(ncolor == 1 || ncolor == 2) {
							visited[nr][nc] = true;
							q.add(new RC(nr, nc));							
						}
					}
				}
			}

		}

	}

	static boolean inRange(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
			return true;
		} else {
			return false;
		}
	}

}
