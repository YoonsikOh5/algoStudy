import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	// 배열돌리기 3과 같은 문제지만
	// R이 최대 10^8의 값을 가질 수 있다는 점이 다름
	// R이 커져도 상쇄시켜서 적게 돌리는게 목표

	static int[][] matrix;

	static int N, M, R;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 세로길이
		N = Integer.parseInt(st.nextToken());
		// 가로길이
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		matrix = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				matrix[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 0 번째 인덱스 안씀
		// 상하 반전 상황 1 정상 0
		int udrev = 0;
		// 좌우 반전 상황 1 정상 0
		int lrrev = 0;
		// 오른쪽으로 90도 회전얼마나 했는지 0(제자리), 1(90), 2(180), 3(270)
		int r90 = 0;
		// 4분할 시계방향 몇번 갔는지
		int div4clock = 0;

		// 커맨드
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int nextcmd = Integer.parseInt(st.nextToken());
			switch (nextcmd) {
			case 1:
				if (udrev == 0) {
					udrev = 1;
				} else if (udrev == 1) {
					udrev = 0;
				}
				break;
			case 2:
				if (lrrev == 0) {
					lrrev = 1;
				} else if (lrrev == 1) {
					lrrev = 0;
				}
				break;
			case 3:
				if (udrev + lrrev == 1) {
					if (--r90 == -1) {
						r90 = 3;
					}
				} else {
					if (++r90 == 4) {
						r90 = 0;
					}
				}

				break;
			case 4:
				if (udrev + lrrev == 1) {
					if (++r90 == 4) {
						r90 = 0;
					}
				} else {
					if (--r90 == -1) {
						r90 = 3;
					}
				}

				break;
			case 5:
				// 상하나 좌우 둘중 하나만 반전 되어서 반대로 가야되는 상황
				if (udrev + lrrev == 1) {
					if (--div4clock == -1) {
						div4clock = 3;
					}
				} else {
					if (++div4clock == 4) {
						div4clock = 0;
					}
				}
				break;
			case 6:
				// 상하나 좌우 둘중 하나만 반전 되어서 반대로 가야되는 상황
				if (udrev + lrrev == 1) {
					if (++div4clock == 4) {
						div4clock = 0;
					}
				} else {
					if (--div4clock == -1) {
						div4clock = 3;
					}
				}
				break;
			default:
				break;
			}
		}

		// 이러면 배열을 실제로 돌리는건 아무리 많아봐야 3번 3번 1번 1번 8번임 위에 연산에서 시간 초과 나는거 아니면 가능할듯
		// 정방향에서 돌려야 시계방향 돌린 상황 나오니까 이거먼저
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < div4clock; i++) {
			matrix = div4clockwise();
		}
		for (int i = 0; i < r90; i++) {
			matrix = right90();
		}
		if (udrev == 1) {
			matrix = reverseud();
		}
		if (lrrev == 1) {
			matrix = reverselr();
		}

		for (int r = 0, rs = matrix.length; r < rs; r++) {
			for (int c = 0, ls = matrix[0].length; c < ls; c++) {
				bw.write(matrix[r][c] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

	static int[][] reverseud() {
		int[][] temp = new int[matrix.length][matrix[0].length];

		for (int r = 0, rl = temp.length; r < rl; r++) {
			for (int c = 0, cl = temp[0].length; c < cl; c++) {
				temp[r][c] = matrix[rl - 1 - r][c];
			}
		}
		return temp;
	}

	static int[][] reverselr() {
		int[][] temp = new int[matrix.length][matrix[0].length];

		for (int r = 0, rl = temp.length; r < rl; r++) {
			for (int c = 0, cl = temp[0].length; c < cl; c++) {
				temp[r][c] = matrix[r][cl - 1 - c];
			}
		}
		return temp;

	}

	static int[][] right90() {
		int matr = matrix.length;
		int matc = matrix[0].length;
		int[][] temp = new int[matc][matr];

		for (int r = 0, rl = temp.length; r < rl; r++) {
			for (int c = 0, cl = temp[0].length; c < cl; c++) {
				temp[r][c] = matrix[matr - 1 - c][r];
			}
		}
		return temp;

	}

	// 안써서 필요없어짐
//		static int[][] left90() {
//			int matr = matrix.length;
//			int matc = matrix[0].length;
//			int[][] temp = new int[matc][matr];
	//
//			for (int r = 0, rl = temp.length; r < rl; r++) {
//				for (int c = 0, cl = temp[0].length; c < cl; c++) {
//					temp[r][c] = matrix[c][matc - 1 - r];
//				}
//			}
//			return temp;
//		}

	static int[][] div4clockwise() {
		int matr = matrix.length;
		int matc = matrix[0].length;
		int[][] temp = new int[matr][matc];
		int divr = matr / 2;
		int divc = matc / 2;

		for (int r = 0; r < divr; r++) {
			for (int c = 0; c < divc; c++) {
				temp[r][c] = matrix[divr + r][c];
				temp[divr + r][c] = matrix[divr + r][divc + c];
				temp[divr + r][divc + c] = matrix[r][divc + c];
				temp[r][divc + c] = matrix[r][c];
			}
		}

		return temp;
	}

	// 안써서 필요없어짐
//		static int[][] div4counterclockwise() {
//			int matr = matrix.length;
//			int matc = matrix[0].length;
//			int[][] temp = new int[matr][matc];
//			int divr = matr / 2;
//			int divc = matc / 2;
	//
//			for (int r = 0; r < divr; r++) {
//				for (int c = 0; c < divc; c++) {
//					temp[r][c] = matrix[r][divc + c];
//					temp[divr + r][c] = matrix[r][c];
//					temp[divr + r][divc + c] = matrix[divr + r][c];
//					temp[r][divc + c] = matrix[divr + r][divc + c];
//				}
//			}
	//
//			return temp;
//		}

}