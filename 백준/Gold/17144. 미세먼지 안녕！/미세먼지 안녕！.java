import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T;

	static int[][] matrix;

	static airCleaner ac;

	// 상 하 좌 우
	static int[] dra = { -1, 1, 0, 0 };
	static int[] dca = { 0, 0, -1, 1 };

	static class airCleaner {

		int ur;
		int uc;
		int dr;
		int dc;

		void diffusion() {
			
			int[][] temp = new int[R + 1][C + 1];

			for (int r = 1; r <= R; r++) {
				for (int c = 1; c <= C; c++) {
					if (matrix[r][c] > 0) {
						int cnt = 0;
						int difamount = matrix[r][c] / 5;
						for (int d = 0; d < 4; d++) {
							int nr = r + dra[d];
							int nc = c + dca[d];
							if (nr >= 1 && nr <= R && nc >= 1 && nc <= C) {
								if (!(nc == 1 && (nr == ur || nr == dr))) {
									cnt++;
									temp[nr][nc] += difamount;
								}
							}
						}
						temp[r][c] += (matrix[r][c] - difamount * cnt);
					}
				}
			}

			matrix = temp;
		
		
		}

		void acRun() {
			int[][] temp = new int[R + 1][C + 1];
			for (int r = 1; r <= R; r++) {
				for (int c = 1; c <= C; c++) {
					// 윗쪽 공기 순환 시키기
					// 아래쪽 공기 순환 시키기
					if (r == 1) {
						if (c != C) {
							temp[r][c] = matrix[r][c + 1];
						} else if (c == C) {
							temp[r][c] = matrix[r + 1][c];
						}
					} else if (r == ur) {
						if (c != 1 && c != 2) {
							temp[r][c] = matrix[r][c - 1];
						} else if (c == 2) {
							temp[r][c] = 0;
						}
					} else if (r == R) {
						if (c != C) {
							temp[r][c] = matrix[r][c + 1];
						} else if (c == C) {
							temp[r][c] = matrix[r - 1][c];
						}
					} else if (r == dr) {
						if (c != 1 && c != 2) {
							temp[r][c] = matrix[r][c - 1];
						} else if (c == 2) {
							temp[r][c] = 0;
						}
					} else if (c == 1 && r < ur) {
						temp[r][c] = matrix[r - 1][c];
					} else if (c == 1 && r > dr) {
						temp[r][c] = matrix[r + 1][c];
					} else if (c == C && r < ur) {
						temp[r][c] = matrix[r + 1][c];
					} else if (c == C && r > dr) {
						temp[r][c] = matrix[r - 1][c];
					} else {
						temp[r][c] = matrix[r][c];
					}

				}
			}

			matrix = temp;

			

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		matrix = new int[R + 1][C + 1];

		ac = new airCleaner();

		for (int r = 1; r <= R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= C; c++) {
				matrix[r][c] = Integer.parseInt(st.nextToken());
				if (matrix[r][c] == -1) {
					if (ac.ur == 0 && ac.uc == 0) {
						ac.ur = r;
						ac.uc = c;
						ac.dr = r+1;
						ac.uc = c;
					}
				}
			}
		}

		for (int t = 1; t <= T; t++) {
			// 미세먼지 확산
			ac.diffusion();
			// 공기청정기 작동
			ac.acRun();
		}

		// 남은 미세먼지 양

		int sum = 0;
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				sum += matrix[r][c];
			}
		}

		bw.write(sum+"");
		bw.flush();
		bw.close();
		br.close();

	}

}
