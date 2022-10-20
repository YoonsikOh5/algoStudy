import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static String strA, strB;
	static int[][] dp;
	static int[][][] tracking;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		strA = br.readLine();
		strB = br.readLine();

		int strAlen = strA.length();
		int strBlen = strB.length();

		dp = new int[strBlen + 1][strAlen + 1];
		tracking = new int[strBlen + 1][strAlen + 1][2];

		for (int c = 1; c <= strAlen; c++) {
			if (strA.charAt(c - 1) == strB.charAt(0)) {
				if (tracking[1][c][0] == 0) {
					tracking[1][c][0] = 1;
					tracking[1][c][1] = c;
				} else {
					tracking[1][c][0] = tracking[1][c - 1][0];
					tracking[1][c][1] = tracking[1][c - 1][1];
				}

				dp[1][c] = Math.max(dp[1][c - 1], 1);

			} else {
				dp[1][c] = dp[1][c - 1];
				tracking[1][c][0] = tracking[1][c - 1][0];
				tracking[1][c][1] = tracking[1][c - 1][1];
			}

		}

		for (int r = 1; r <= strBlen; r++) {
			if (strA.charAt(0) == strB.charAt(r - 1)) {
				if (tracking[r][1][0] == 0) {
					tracking[r][1][0] = r;
					tracking[r][1][1] = 1;
				} else {
					tracking[r][1][0] = tracking[r-1][1][0];
					tracking[r][1][1] = tracking[r-1][1][1];
				}
				dp[r][1] = Math.max(dp[r - 1][1], 1);
			} else {
				dp[r][1] = dp[r - 1][1];
				tracking[r][1][0] = tracking[r-1][1][0];
				tracking[r][1][1] = tracking[r-1][1][1];
			}
		}

		for (int r = 1; r <= strBlen; r++) {
			for (int c = 1; c <= strAlen; c++) {
				if (r > strBlen || c > strAlen) {
					continue;
				}
				if (strA.charAt(c - 1) == strB.charAt(r - 1)) {
					tracking[r][c][0] = r;
					tracking[r][c][1] = c;
					dp[r][c] = dp[r - 1][c - 1] + 1;
				} else {
					dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
					if(dp[r-1][c]>dp[r][c-1]) {						
						tracking[r][c][0] = tracking[r-1][c][0];
						tracking[r][c][1] = tracking[r-1][c][1];
					} else {
						tracking[r][c][0] = tracking[r][c-1][0];
						tracking[r][c][1] = tracking[r][c-1][1];
					}
					
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		
		int endr = tracking[strBlen][strAlen][0];
		int endc = tracking[strBlen][strAlen][1];
		
		if(!(endr==0||endc==0)) {
			
		sb.append(strB.charAt(endr-1));

		int nextr = tracking[endr-1][endc-1][0];		
		int nextc = tracking[endr-1][endc-1][1];		
		while(nextr!=0 && nextc!=0){
			endr = tracking[nextr][nextc][0];		
			endc = tracking[nextr][nextc][1];	
		
			sb.append(strB.charAt(endr-1));
			
			nextr = tracking[endr-1][endc-1][0];		
			nextc = tracking[endr-1][endc-1][1];		
		}
		
//		for(int[][] map : tracking) {
//			for(int [] arr : map) {
//				System.out.print("( "+arr[0]+" ");
//				System.out.print(arr[1]+" )");
//			}
//			System.out.println();
//		}
		}

		bw.write(dp[strBlen][strAlen] + "\n");
		bw.write(sb.reverse().toString());
		bw.flush();
		bw.close();
		br.close();
	}

}