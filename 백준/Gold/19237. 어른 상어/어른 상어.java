import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	// k번 이동 후 상어의 냄새가 사라짐
	static int N, M, k;

	// 상어의 현재 위치를 담는 2차원 배열
	// 일단은 번호를 넣어두고 번호에 맞는 shark는 HashMap에 넣어두기
	static int[][] sharkMatrix;

	static HashMap<Integer, Shark> hm;

	// 상어 냄새의 현황을 담는 2차원 배열
	static Scent[][] scentMatrix;

	// 4방향 1위 2아래 3왼 4오 0번 안씀
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };

	// 상어 냄새 클래스
	static class Scent {
		// 현재 배어있는 상어 냄새 없으면 0
		int curNum;

		// 상어 냄새 없어지는 시간
		int remainSecond;

		public Scent(int curNum, int remainSecond) {
			this.curNum = curNum;
			this.remainSecond = remainSecond;
		}

	}

	// 상어 클래스
	static class Shark {

		int r;
		int c;

		// 상어 번호
		int num;

		// 상어 방향
		int direction;

		// 위 아래 왼쪽 오른쪽 방향을 보고 있을 때의 우선순위
		int[][] priorD = new int[5][5];

		public Shark(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}

		void move() {
			// 이동할 때 고려할 우선 순위
			// 일단 향기가 있나 없나 주위를 한 번 둘러 봄
			boolean[] candD = new boolean[5];
			boolean findC = false;
			for (int d = 1; d <= 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (scentMatrix[nr][nc] == null) {
						candD[d] = true;
						findC = true;
					}
				}
			}
			// 향기가 없는곳이 여러개면 우선순위에 따라 이동
			if (findC) {
				int finalD = -1;
				for (int i = 1; i <= 4; i++) {
					int num = priorD[this.direction][i];
					if (candD[num] == true) {
						finalD = num;
						break;
					}
				}

				int fr = this.r + dr[finalD];
				int fc = this.c + dc[finalD];

				if (sharkMatrix[fr][fc] == 0) {
					sharkMatrix[fr][fc] = this.num;
					this.r = fr;
					this.c = fc;
					this.direction=finalD;
				} else {
					hm.remove(this.num);
				}

			} else {
				// 향기가 전부 있으면 그 중 자신의 번호가 있는 향기를 찾음
				candD = new boolean[5];
				findC = false;
				for (int d = 1; d <= 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (scentMatrix[nr][nc] != null && scentMatrix[nr][nc].curNum == this.num) {
							candD[d] = true;
							findC = true;
						}
					}
				}
				// 여러개면 우선순위에 따라 이동
				int finalD = -1;
				for (int i = 1; i <= 4; i++) {
					int num = priorD[this.direction][i];
					if (candD[num] == true) {
						finalD = num;
						break;
					}
				}

				int fr = this.r + dr[finalD];
				int fc = this.c + dc[finalD];

				if (sharkMatrix[fr][fc] == 0) {
					sharkMatrix[fr][fc] = this.num;
					this.r = fr;
					this.c = fc;
					this.direction=finalD;
				} else {
					hm.remove(this.num);
				}
			}

			// 이동했는데 이미 그 자리에 다른 상어가 있다면 번호순으로 진행하기 때문에 우선순위가 당연히 밀리므로
			// hm에서 빼기

		}

		void putScent() {
			scentMatrix[r][c] = new Scent(num, k);
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		scentMatrix = new Scent[N][N];

		hm = new HashMap<>();

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int num = Integer.parseInt(st.nextToken());
				if (num > 0) {
					hm.put(num, new Shark(r, c, num));
					scentMatrix[r][c] = new Scent(num, k);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			hm.get(i).direction = Integer.parseInt(st.nextToken());
		}

		for (int n = 1; n <= M; n++) {
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= 4; j++) {
					hm.get(n).priorD[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		boolean findR = false;
		// 1000초까지 돌리기
		int resultT = 0;
		while (resultT < 1000) {
			// 1초 증가
			resultT++;

			// 이동 하고 나서
			sharkMatrix = new int[N][N];
			for (int i = 1; i <= M; i++) {
				if (hm.getOrDefault(i, null) != null) {
					hm.get(i).move();
				}
			}

			// 향기 1씩 줄이기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (scentMatrix[r][c] != null) {
						scentMatrix[r][c].remainSecond--;
						if (scentMatrix[r][c].remainSecond == 0) {
							scentMatrix[r][c] = null;
						}
					}
				}
			}

			// 향기 뿌리기
			for (int i = 1; i <= M; i++) {
				if (hm.getOrDefault(i, null) != null) {
					hm.get(i).putScent();
				}
			}

			if (hm.size() == 1) {
				findR = true;
				break;
			}
		}

		if (findR) {
			bw.write(resultT + "");
		} else {
			bw.write("-1");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
