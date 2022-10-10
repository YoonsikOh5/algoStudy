import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] board;
	static Marble[] startrb;

	static class Marble {

		int r;
		int c;
		boolean redout = false;
		boolean blueout = false;

		public Marble(int r, int c) {
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

		// 0번은 빨간 구슬 시작 1번은 파란 구슬 시작
		startrb = new Marble[2];

		board = new char[N][M];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				board[r][c] = str.charAt(c);
				if (str.charAt(c) == 'R') {
					startrb[0] = new Marble(r, c);
				}
				if (str.charAt(c) == 'B') {
					startrb[1] = new Marble(r, c);
				}
			}
		}
		perm(startrb, 1);

		if(min_result==Integer.MAX_VALUE) {
			bw.write("-1");
		} else {
			bw.write(min_result+"");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int min_result = Integer.MAX_VALUE;

	public static void perm(Marble[] currb, int depth) {

		if (depth == 11) {
			return;
		}

		for (int i = 1; i <= 4; i++) {
			Marble[] next = move(currb, i);

			if(next[1].blueout) {
				continue;
			} else if(next[0].redout) {
				min_result = Math.min(min_result, depth);
				continue;
			}
			// 이전 rb랑 현재랑 같으면 끊어버리기
			if((next[0].r==currb[0].r)&&(next[0].c==currb[0].c)&&(next[1].r==currb[1].r)&&(next[1].c==currb[1].c)){
				continue;
			}
			perm(next, depth + 1);
		}

	}

	// 이동
	public static Marble[] move(Marble[] currb, int direction) {
		Marble[] temp = new Marble[2];
		Marble red = new Marble(currb[0].r,currb[0].c);
		Marble blue = new Marble(currb[1].r,currb[1].c);
	
		if (direction == 1) {

			// 위로 이동
			// 해야할 것
			// 같은 열에 R 또는 B 있는지 확인
			// 있는 경우
			if (red.c == blue.c) {
				// 빨간게 위에 있는 경우
				// 빨간거를 먼저 위로
				if (red.r < blue.r) {
					for (int r = red.r - 1; r >= 0; r--) {
						if (board[r][red.c] == '#') {
							red.r = r + 1;
							break;
						} else if (board[r][red.c] == 'O') {
							red.redout = true;
							red.r = -1;
							red.c = -1;
							break;
						}
					}
					for (int r = blue.r - 1; r >= 0; r--) {
						if (board[r][blue.c] == '#') {
							blue.r = r + 1;
							break;
						} else if (r == red.r) {
							blue.r = r + 1;
							break;
						} else if (board[r][blue.c] == 'O') {
							blue.blueout = true;
							blue.r = -1;
							blue.c = -1;
							break;
						}
					}
					// 파란게 위에 있는 경우
				} else {
					for (int r = blue.r - 1; r >= 0; r--) {
						if (board[r][blue.c] == '#') {
							blue.r = r + 1;
							break;
						} else if (board[r][blue.c] == 'O') {
							blue.blueout = true;
							blue.r = -1;
							blue.c = -1;
							break;
						}
					}
					for (int r = red.r - 1; r >= 0; r--) {
						if (board[r][red.c] == '#') {
							red.r = r + 1;
							break;
						} else if (r == blue.r) {
							red.r = r + 1;
							break;
						} else if (board[r][red.c] == 'O') {
							red.redout = true;
							red.r = -1;
							red.c = -1;
							break;
						}
					}

				}
				// 없는 경우
			} else if (red.c != blue.c) {
				for (int r = red.r - 1; r >= 0; r--) {
					if (board[r][red.c] == '#') {
						red.r = r + 1;
						break;
					} else if (board[r][red.c] == 'O') {
						red.redout = true;
						red.r = -1;
						red.c = -1;
						break;
					}
				}
				for (int r = blue.r - 1; r >= 0; r--) {
					if (board[r][blue.c] == '#') {
						blue.r = r + 1;
						break;
					} else if (board[r][blue.c] == 'O') {
						blue.blueout = true;
						blue.r = -1;
						blue.c = -1;
						break;
					}
				}
			}

		}
		
		if (direction == 2) {

			// 아래로 이동
			// 해야할 것
			// 같은 열에 R 또는 B 있는지 확인
			// 있는 경우
			if (red.c == blue.c) {
				// 빨간게 위에 있는 경우
				// 파란거를 먼저 아래로
				if (red.r < blue.r) {
					for (int r = blue.r + 1; r < N; r++) {
						if (board[r][blue.c] == '#') {
							blue.r = r - 1;
							break;
						} else if (board[r][blue.c] == 'O') {
							blue.blueout = true;
							blue.r = -1;
							blue.c = -1;
							break;
						}
					}
					for (int r = red.r + 1; r <	N; r++) {
						if (board[r][red.c] == '#') {
							red.r = r - 1;
							break;
						} else if (r == blue.r) {
							red.r = r - 1;
							break;
						} else if (board[r][red.c] == 'O') {
							red.redout = true;
							red.r = -1;
							red.c = -1;
							break;
						}
					}
					
					// 파란게 위에 있는 경우
					// 빨간거를 먼저 아래로
				} else {
					for (int r = red.r + 1; r < N; r++) {
						if (board[r][red.c] == '#') {
							red.r = r - 1;
							break;
						}  else if (board[r][red.c] == 'O') {
							red.redout = true;
							red.r = -1;
							red.c = -1;
							break;
						}
					}
					for (int r = blue.r + 1; r < N; r++) {
						if (board[r][blue.c] == '#') {
							blue.r = r - 1;
							break;
						} else if (r == red.r) {
							blue.r = r - 1;
							break;
						} else if (board[r][blue.c] == 'O') {
							blue.blueout = true;
							blue.r = -1;
							blue.c = -1;
							break;
						}
					}
					

				}
				// 없는 경우
			} else if (red.c != blue.c) {
				for (int r = red.r + 1; r < N; r++) {
					if (board[r][red.c] == '#') {
						red.r = r - 1;
						break;
					} else if (board[r][red.c] == 'O') {
						red.redout = true;
						red.r = -1;
						red.c = -1;
						break;
					}
				}
				for (int r = blue.r + 1; r < N; r++) {
					if (board[r][blue.c] == '#') {
						blue.r = r - 1;
						break;
					} else if (board[r][blue.c] == 'O') {
						blue.blueout = true;
						blue.r = -1;
						blue.c = -1;
						break;
					}
				}
			}

		}
		
		if (direction == 3) {

			// 좌로 이동
			// 해야할 것
			// 같은 행에 R 또는 B 있는지 확인
			// 있는 경우
			if (red.r == blue.r) {
				// 빨간게 왼쪽에 있는 경우
				// 빨간거를 먼저 왼쪽으로
				if (red.c < blue.c) {

					for (int c = red.c - 1; c >= 0; c--) {
						if (board[red.r][c] == '#') {
							red.c = c + 1;
							break;
						} else if (board[red.r][c] == 'O') {
							red.redout = true;
							red.r = -1;
							red.c = -1;
							break;
						}
					}
					
					for (int c = blue.c - 1; c >= 0; c--) {
						if (board[blue.r][c] == '#') {
							blue.c = c + 1;
							break;
						} else if (c == red.c) {
							blue.c = c + 1;
							break;
						} else if (board[blue.r][c] == 'O') {
							blue.blueout = true;
							blue.r = -1;
							blue.c = -1;
							break;
						}
					}
					
					// 파란게 왼쪽에 있는 경우
					// 파란거를 먼저 왼쪽으로
				} else {
					
					for (int c = blue.c - 1; c >= 0; c--) {
						if (board[blue.r][c] == '#') {
							blue.c = c + 1;
							break;
						} else if (board[blue.r][c] == 'O') {
							blue.blueout = true;
							blue.r = -1;
							blue.c = -1;
							break;
						}
					}
					
					for (int c = red.c - 1; c >= 0; c--) {
						if (board[red.r][c] == '#') {
							red.c = c + 1;
							break;
						} else if (c == blue.c) {
							red.c = c + 1;
							break;
						}  else if (board[red.r][c] == 'O') {
							red.redout = true;
							red.r = -1;
							red.c = -1;
							break;
						}
					}

				}
				// 없는 경우
			} else if (red.r != blue.r) {
				for (int c = red.c - 1; c >= 0; c--) {
					if (board[red.r][c] == '#') {
						red.c = c + 1;
						break;
					} else if (board[red.r][c] == 'O') {
						red.redout = true;
						red.r = -1;
						red.c = -1;
						break;
					}
				}
				for (int c = blue.c - 1; c >= 0; c--) {
					if (board[blue.r][c] == '#') {
						blue.c = c + 1;
						break;
					} else if (board[blue.r][c] == 'O') {
						blue.blueout = true;
						blue.r = -1;
						blue.c = -1;
						break;
					}
				}
			}
		}
		
		if (direction == 4) {

			// 우로 이동
			// 해야할 것
			// 같은 행에 R 또는 B 있는지 확인
			// 있는 경우
			if (red.r == blue.r) {
				// 빨간게 오른쪽에 있는 경우
				// 빨간거를 먼저 오른쪽으로
				if (red.c > blue.c) {

					for (int c = red.c + 1; c < M; c++) {
						if (board[red.r][c] == '#') {
							red.c = c - 1;
							break;
						} else if (board[red.r][c] == 'O') {
							red.redout = true;
							red.r = -1;
							red.c = -1;
							break;
						}
					}
					
					for (int c = blue.c + 1; c < M; c++) {
						if (board[blue.r][c] == '#') {
							blue.c = c - 1;
							break;
						} else if (c == red.c) {
							blue.c = c - 1;
							break;
						} else if (board[blue.r][c] == 'O') {
							blue.blueout = true;
							blue.r = -1;
							blue.c = -1;
							break;
						}
					}
					
					// 파란게 오른쪽에 있는 경우
					// 파란거를 먼저 오른쪽으로
				} else {
					
					for (int c = blue.c + 1; c < M; c++) {
						if (board[blue.r][c] == '#') {
							blue.c = c - 1;
							break;
						} else if (board[blue.r][c] == 'O') {
							blue.blueout = true;
							blue.r = -1;
							blue.c = -1;
							break;
						}
					}
					
					for (int c = red.c + 1; c < M; c++) {
						if (board[red.r][c] == '#') {
							red.c = c - 1;
							break;
						} else if (c == blue.c) {
							red.c = c - 1;
							break;
						}  else if (board[red.r][c] == 'O') {
							red.redout = true;
							red.r = -1;
							red.c = -1;
							break;
						}
					}

				}
				// 없는 경우
			} else if (red.r != blue.r) {
				for (int c = red.c + 1; c < M; c++) {
					if (board[red.r][c] == '#') {
						red.c = c - 1;
						break;
					} else if (board[red.r][c] == 'O') {
						red.redout = true;
						red.r = -1;
						red.c = -1;
						break;
					}
				}
				for (int c = blue.c + 1; c < M; c++) {
					if (board[blue.r][c] == '#') {
						blue.c = c - 1;
						break;
					} else if (board[blue.r][c] == 'O') {
						blue.blueout = true;
						blue.r = -1;
						blue.c = -1;
						break;
					}
				}
			}
		}
		
		temp[0] = red;
		temp[1] = blue;

		return temp;
	}

}