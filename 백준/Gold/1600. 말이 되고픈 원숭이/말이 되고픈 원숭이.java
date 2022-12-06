import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K, W, H;
	static int[][] board;
	static SK[][] steps;

	static class SK {
		int step;
		int K;

		public SK(int step, int k) {
			this.step = step;
			K = k;
		}

	}

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

		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		board = new int[H + 1][W + 1];
		steps = new SK[H + 1][W + 1];
		

		for (int r = 1; r <= H; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= W; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		bw.write(resultstep + "");
		bw.flush();
		bw.close();
		br.close();
	}

	// 원숭이 상하좌우
	static int[] mr = { -1, 1, 0, 0 };
	static int[] mc = { 0, 0, -1, 1 };

	// 말 8방향 왼위부터 시계
	static int[] hr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] hc = { -2, -1, 1, 2, 2, 1, -1, -2 };

	static int resultstep = -1;

	static void bfs() {
		
		Queue<RC> q = new LinkedList<>();

		q.add(new RC(1, 1));

		int step = 0;
		
		if(W==1 && H==1) {
			resultstep=0;
			return;
		}
		step++;
		steps[1][1] = new SK(step, K);

		RC stepcounter = new RC(-1, -1);
		q.add(stepcounter);

		whileloop: while (q.size() > 0) {
			RC cur = q.poll();

			int curr = cur.r;
			int curc = cur.c;

//			System.out.println(curr + " " + curc);

			if (curr == -1 && curc == -1) {
				step++;
				if (q.size() > 0) {
					q.add(stepcounter);
				} else {
					break whileloop;
				}
				continue;
			}
			int curK = steps[curr][curc].K;

			for (int d = 0; d < 4; d++) {
				int nr = curr + mr[d];
				int nc = curc + mc[d];

				if (nr == H && nc == W) {
					resultstep = step;
					break whileloop;
				}

				if (nr >= 1 && nr <= H && nc >= 1 && nc <= W) {
					if (board[nr][nc] == 0) {
						if (steps[nr][nc] == null) {
							steps[nr][nc] = new SK(step, curK);
							q.add(new RC(nr, nc));
						} else {
							SK cursk = steps[nr][nc];
							if (cursk.K < curK) {
								steps[nr][nc] = new SK(step, curK);
								q.add(new RC(nr, nc));
							}
						}
					}
				}
			}
			if (curK > 0) {
				for (int d = 0; d < 8; d++) {
					int nr = curr + hr[d];
					int nc = curc + hc[d];

					if (nr == H && nc == W) {
						resultstep = step;
						break whileloop;
					}

					if (nr >= 1 && nr <= H && nc >= 1 && nc <= W) {
						if (board[nr][nc] == 0) {
							if (steps[nr][nc] == null) {
								steps[nr][nc] = new SK(step, curK - 1);
								q.add(new RC(nr, nc));
							} else {
								SK cursk = steps[nr][nc];
								if (cursk.K < curK-1) {
									steps[nr][nc] = new SK(step, curK - 1);
									q.add(new RC(nr, nc));
								}
							}
						}
					}
				}
			}

		}

	}

}