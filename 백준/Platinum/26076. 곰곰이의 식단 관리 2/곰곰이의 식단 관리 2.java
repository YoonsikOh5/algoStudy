import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] board;
	static int[][] wall;

	static class RC {
		int r;
		int c;

		public RC(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N + 1][M + 1];
		wall = new int[N + 1][M + 1];

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= M; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		boolean tt = false;
		if (!bfs()) {
			bw.write(0 + "");
		} else {
			// 양쪽 끝에서 돌리면서 연결된 벽들 체크
			for (int c = 2; c <= M; c++) {
				if (board[1][c] == 1 && wall[1][c] == 0) {
					checkwall(1, c, 1);
				}
			}
			for (int r = 1; r < N; r++) {
				if (board[r][M] == 1 && wall[r][M] == 0) {
					checkwall(r, M, 1);
				}
			}

			for (int c = 1; c < M; c++) {
				if (board[N][c] == 1 && wall[N][c] == 0) {
					checkwall(N, c, 2);
				}
			}
			for (int r = 2; r < N; r++) {
				if (board[r][1] == 1 && wall[r][1] == 0) {
					checkwall(r, 1, 2);
				}
			}
			out : for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= M; c++) {
					if((r==1&&c==1)||(r==N&&c==M)) {
						continue;
					}
					if(board[r][c]==0) {
						if(checkifconnectable(r,c)) {
							bw.write(1+"");
							tt = true;
							break out;
						};
					}
				}
			}
			
			if(!tt) {
				bw.write(2+"");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static int dr[] = { 0, 0, -1, 1, -1, -1, 1, 1 };
	static int dc[] = { -1, 1, 0, 0, -1, 1, -1, 1 };

	static boolean bfs() {
		boolean visited[][] = new boolean[N + 1][M + 1];

		visited[1][1] = true;
		Queue<RC> q = new LinkedList<>();
		q.add(new RC(1, 1));

		while (q.size() > 0) {
			RC cur = q.poll();

			int curr = cur.r;
			int curc = cur.c;

			if (curr == N && curc == M) {
				return true;
			}

			for (int d = 0; d < 4; d++) {
				int nr = curr + dr[d];
				int nc = curc + dc[d];

				if (nr >= 1 && nr <= N && nc >= 1 && nc <= M) {
					if (board[nr][nc] == 0 && visited[nr][nc] == false) {
						visited[nr][nc] = true;
						q.add(new RC(nr, nc));
					}
				}
			}

		}

		return false;

	}

	static void checkwall(int r, int c, int group) {
		boolean visited[][] = new boolean[N + 1][M + 1];

		visited[r][c] = true;
		Queue<RC> q = new LinkedList<>();
		q.add(new RC(r, c));
		wall[r][c] = group;

		while (q.size() > 0) {
			RC cur = q.poll();

			int curr = cur.r;
			int curc = cur.c;

			for (int d = 0; d < 8; d++) {
				int nr = curr + dr[d];
				int nc = curc + dc[d];

				if (nr >= 1 && nr <= N && nc >= 1 && nc <= M) {
					if (board[nr][nc] == 1 && visited[nr][nc] == false && wall[nr][nc] == 0) {
						wall[nr][nc] = group;
						visited[nr][nc] = true;
						q.add(new RC(nr, nc));
					}
				}
			}

		}
	}
	
	static boolean checkifconnectable(int r, int c) {
		
		int arr[] = new int[3];
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			
			if(nr==0&& (nc>=2 && nc<=M)) {
				arr[1]++;
				if(arr[2]>0) {
					return true;
				}
				continue;
			} else if(nc==M+1 &&(nr>=1 && nr <N)) {
				arr[1]++;
				if(arr[2]>0) {
					return true;
				}
				continue;
			} else if(nc==0 && (nr>=2 && nr<N)) {
				arr[2]++;
				if(arr[1]>0) {
					return true;
				}
			} else if(nr==N+1 && (nc>=1 && nc<M)) {
				arr[2]++;
				if(arr[1]>0) {
					return true;
				}
			}


			if (nr >= 1 && nr <= N && nc >= 1 && nc <= M) {
				if(wall[nr][nc]==1) {
					arr[1]++;
					if(arr[2]>0) {
						return true;
					}
				}
				if(wall[nr][nc]==2) {
					arr[2]++;
					if(arr[1]>0) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

}