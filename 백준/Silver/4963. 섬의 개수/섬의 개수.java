import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int W, H;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// W 너비 H 높이
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0) {
				break;
			}

			map = new int[H][W];
			visited = new boolean[H][W];
			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					int cur = Integer.parseInt(st.nextToken());
					map[r][c] = cur;
					if (cur == 0) {
						visited[r][c] = true;
					}
				}
			}

			// 탐색
			cnt = 0;
			search();
			bw.write(cnt+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static int cnt;

	public static void search() {

		// 8방탐색용 상 하 좌 우 오위 오아래 왼위 왼아래

		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (visited[r][c] == false) {
					visit(r, c);
					cnt++;
				}
			}
		}

	}

	public static void visit(int r, int c) {
		
		int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
		int[] dc = { 0, 0, -1, 1, 1, 1, -1, -1 };

		visited[r][c] = true;

		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < H && nc >= 0 && nc < W && visited[nr][nc] == false) {
				visited[nr][nc] = true;
				visit(nr, nc);
			}
		}
	}

}
