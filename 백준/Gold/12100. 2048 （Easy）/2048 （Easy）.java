import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int board[][];
	static int maxcand;
	static int result_max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		int sum = 0;
		result_max = 0;
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
				sum += board[r][c];
				result_max = Math.max(result_max, board[r][c]);
			}
		}
		// 될 수 있는 가장 최대 숫자 == 모든 수를 다 합친수 보다 작은 최대의 2의 배수
		maxcand = 1; 
		while(sum > 1) {
			sum /= 2;
			maxcand *= 2;
		}
		
		// 스타트 1~4(방향) 5번 뽑는 순열
		perm(board, 0);
		bw.write(result_max+"");
		bw.flush();
		bw.close();
		br.close();
	}
	static int permcnt = 0;
	public static void perm(int[][] board, int depth) {
		// 기저조건
		if(depth == 5 || result_max==maxcand) {
			return;
		}
		
		// 유도파트
		for(int i = 1; i <= 4; i++) {
			perm(move(board,i),depth+1);
		}
		
	}
	

	public static int[][] move(int[][] board, int direction) {
		int[][] temp = new int[N][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				temp[r][c] = board[r][c];
			}			
		}
		
		// direction 1 위로 2 아래 3 왼쪽 4 오른쪽

		if (direction == 1) {
			// 위로 움직일때 할 것들
			// 맨 윗줄부터 확인해서 0이라면 0 이아닌 숫자를 만날때까지 내려가다가 만나면 위로 땡겨주기
			// 0이 아닌 숫자를 만나면 다른 0 이아닌 숫자를 만날때까지 탐색 만났는데 같은 숫자다 -> 합치고 *2
			// 만났는데 다른 숫자다 -> 그냥 바로 밑에 붙여줌
			// 한 열 붙이고 다음 열 붙이고 이런식으로 갈거임

			// 먼저 합치고 뒤에 빈칸 땡기는게 맞는듯
			for (int c = 0; c < N; c++) {
				int curnum = -1;
				int curnumidx = -1;
				for (int r = 0; r < N; r++) {
					if (curnum == -1) {
						if (temp[r][c] != 0) {
							curnum = temp[r][c];
							curnumidx = r;
							continue;
						}
					} else {
						if (temp[r][c] != 0) {
							if (temp[r][c] == curnum) {
								int mergenum = curnum * 2;
								temp[curnumidx][c] = mergenum;
								result_max = Math.max(result_max, mergenum);
								temp[r][c] = 0;
								curnum = -1;
								curnumidx = -1;
							} else {
								curnum = temp[r][c];
								curnumidx = r;
								continue;
							}
						}
					}
				}
			}

			// 한꺼번에 하려니까 너무 복잡함 빈칸만 쭉 땡겨주기
			for (int c = 0; c < N; c++) {
				int blankcnt = 0;
				for (int r = 0; r < N; r++) {
					if (temp[r][c] == 0) {
						blankcnt++;
					} else {
						temp[r - blankcnt][c] = temp[r][c];
						if (blankcnt > 0) {
							temp[r][c] = 0;
						}
					}
				}
			}

		} else if (direction == 2) {
			// 아래로 움직일때 할 것들

			// 먼저 합치고
			for (int c = 0; c < N; c++) {
				int curnum = -1;
				int curnumidx = -1;
				for (int r = N-1; r >= 0; r--) {
					if (curnum == -1) {
						if (temp[r][c] != 0) {
							curnum = temp[r][c];
							curnumidx = r;
							continue;
						}
					} else {
						if (temp[r][c] != 0) {
							if(temp[r][c]==curnum) {
								int mergenum = curnum * 2;
								temp[curnumidx][c] = mergenum;
								result_max = Math.max(result_max, mergenum);
								temp[r][c]=0;
								curnum = -1;
								curnumidx = -1;
							} else {
								curnum = temp[r][c];
								curnumidx = r;
								continue;
							}
						}
					}
				}
			}

			// 한꺼번에 하려니까 너무 복잡함 빈칸만 쭉 땡겨주기
			for (int c = 0; c < N; c++) {
				int blankcnt = 0;
				for (int r = N-1; r >= 0; r--) {
					if (temp[r][c] == 0) {
						blankcnt++;
					} else {
						temp[r + blankcnt][c] = temp[r][c];
						if (blankcnt > 0) {
							temp[r][c] = 0;
						}
					}
				}
			}

		} else if (direction == 3) {
			// 왼쪽으로 움직일때 할 것들

			// 먼저 합치기
			for (int r = 0; r < N; r++) {
				int curnum = -1;
				int curnumidx = -1;
					for (int c = 0; c < N; c++) {
					if (curnum == -1) {
						if (temp[r][c] != 0) {
							curnum = temp[r][c];
							curnumidx = c;
							continue;
						}
					} else {
						if (temp[r][c] != 0) {
							if (temp[r][c] == curnum) {
								int mergenum = curnum * 2;
								temp[r][curnumidx] = mergenum;
								result_max = Math.max(result_max, mergenum);
								temp[r][c] = 0;
								curnum = -1;
								curnumidx = -1;
							} else {
								curnum = temp[r][c];
								curnumidx = c;
								continue;
							}
						}
					}
				}
			}

			// 한꺼번에 하려니까 너무 복잡함 빈칸만 쭉 땡겨주기
			for (int r = 0; r < N; r++) {
				int blankcnt = 0;
				for (int c = 0; c < N; c++) {
					if (temp[r][c] == 0) {
						blankcnt++;
					} else {
						temp[r][c - blankcnt] = temp[r][c];
						if (blankcnt > 0) {
							temp[r][c] = 0;
						}
					}
				}
			}

		} else if (direction == 4) {
			// 오른쪽으로 움직일때 할 것들

			// 먼저 합치기
			for (int r = 0; r < N; r++) {
				int curnum = -1;
				int curnumidx = -1;
					for (int c = N-1; c >= 0; c--) {
					if (curnum == -1) {
						if (temp[r][c] != 0) {
							curnum = temp[r][c];
							curnumidx = c;
							continue;
						}
					} else {
						if (temp[r][c] != 0) {
							if (temp[r][c] == curnum) {
								int mergenum = curnum * 2;
								temp[r][curnumidx] = mergenum;
								result_max = Math.max(result_max, mergenum);
								temp[r][c] = 0;
								curnum = -1;
								curnumidx = -1;
							} else {
								curnum = temp[r][c];
								curnumidx = c;
								continue;
							}
						}
					}
				}
			}

			// 한꺼번에 하려니까 너무 복잡함 빈칸만 쭉 땡겨주기
			for (int r = 0; r < N; r++) {
				int blankcnt = 0;
				for (int c = N-1; c >= 0; c--) {
					if (temp[r][c] == 0) {
						blankcnt++;
					} else {
						temp[r][c + blankcnt] = temp[r][c];
						if (blankcnt > 0) {
							temp[r][c] = 0;
						}
					}
				}
			}

		}

		
		return temp;
	}

}