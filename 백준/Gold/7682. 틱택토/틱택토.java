import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

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

		String str = br.readLine();

		while (!str.equals("end")) {
			char[][] map = new char[3][3];

			int idx = 0;
			int xcount = 0;
			int ocount = 0;
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					char cur = str.charAt(idx++);
					map[r][c] = cur;
					if (cur == 'X') {
						xcount++;
					} else if (cur == 'O') {
						ocount++;
					}
				}
			}
			// x가 선이니까 xcount==ocount 거나 x가 o보다 한개 많은경우 빼고는 다 invalid
			// x와 o가 같다 == o가 방금전에 놨다
			// 이경우는 9개 모두 놓은 경우가 발생하지는 않음 -> 무조건 o가 승리한게 있어야 끝남
			if (xcount == ocount) {
				if(isWinnerOneExist(map) && winner=='O') {
					bw.write("valid\n");
					str = br.readLine();
					continue;
				} else {
					bw.write("invalid\n");
					str = br.readLine();
					continue;
				}
				// x가 o보다 한개 많다 == x가 방금전에 놨다
				// 이경우는 9개를 모두 놓은 경우가 발생할 수 있음
				// 모두 놓은 경우 -> x가 승리한게 있거나 아무도 승리하지 못한 경우 끝
				// 9개보다 적게 놓은 경우 -> x가 승리한게 있는경우 끝
			} else if (xcount == ocount + 1) {
				if(xcount+ocount==9) {
					if(isWinnerOneExist(map) && winner=='X') {
						bw.write("valid\n");
						str = br.readLine();
						continue;
					} else if(!isWinnerOneExist(map) && winner=='T'){
						bw.write("valid\n");
						str = br.readLine();
						continue;
					} else {
						bw.write("invalid\n");
						str = br.readLine();
						continue;
					}
				} else {
					if(isWinnerOneExist(map) && winner=='X') {
						bw.write("valid\n");
						str = br.readLine();
						continue;
					} else {
						bw.write("invalid\n");
						str = br.readLine();
						continue;
					}
				}
				
			} else {
				bw.write("invalid\n");
				str = br.readLine();
				continue;
			}

		}

//		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static char winner;

	// 승자 한명 있는지 여부랑 승자 기록해둘꺼임
	static boolean isWinnerOneExist(char[][] map) {
//		int dr[] = {0,1,2};
//		int dc[] = {0,1,2};
		winner = 'W';

		int owincount = 0;
		int xwincount = 0;

		// 가로줄 판단
		for (int r = 0; r < 3; r++) {
			int oc = 0;
			int xc = 0;
			for (int c = 0; c < 3; c++) {
				if (map[r][c] == 'O') {
					oc++;
				} else if (map[r][c] == 'X') {
					xc++;
				}
			}
			if (oc == 3) {
				owincount++;
				if (xwincount > 0) {
					return false;
				}
			} else if (xc == 3) {
				xwincount++;
				if (owincount > 0) {
					return false;
				}
			}
		}

		// 세로줄 판단
		for (int c = 0; c < 3; c++) {
			int oc = 0;
			int xc = 0;
			for (int r = 0; r < 3; r++) {
				if (map[r][c] == 'O') {
					oc++;
				} else if (map[r][c] == 'X') {
					xc++;
				}
			}
			if (oc == 3) {
				owincount++;
				if (xwincount > 0) {
					return false;
				}
			} else if (xc == 3) {
				xwincount++;
				if (owincount > 0) {
					return false;
				}
			}
		}

		// 대각 오른쪽 판단
		int oc = 0;
		int xc = 0;
		for (int r = 0; r < 3; r++) {
			if (map[r][r] == 'O') {
				oc++;
			} else if (map[r][r] == 'X') {
				xc++;
			}
		}
		if (oc == 3) {
			owincount++;
			if (xwincount > 0) {
				return false;
			}
		} else if (xc == 3) {
			xwincount++;
			if (owincount > 0) {
				return false;
			}
		}
		
		
		oc = 0;
		xc = 0;
		for (int r = 0; r < 3; r++) {
			if (map[2-r][r] == 'O') {
				oc++;
			} else if (map[2-r][r] == 'X') {
				xc++;
			}
		}
		if (oc == 3) {
			owincount++;
			if (xwincount > 0) {
				return false;
			}
		} else if (xc == 3) {
			xwincount++;
			if (owincount > 0) {
				return false;
			}
		}
		
		
		if(owincount>0) {
			winner = 'O';
			return true;
		} else if(xwincount>0) {
			winner = 'X';
			return true;
		} else if ((owincount+xwincount)==0) {
			// 마지막에 타이 판단
			winner = 'T';
			return false;
		}
		return false;
		
	}

}