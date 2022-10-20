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

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		strA = br.readLine();
		strB = br.readLine();

		int strAlen = strA.length();
		int strBlen = strB.length();

		dp = new int[strBlen + 1][strAlen + 1];

		for (int c = 1; c <= strAlen; c++) {
			if(strA.charAt(c-1)==strB.charAt(0)) {
				dp[1][c] = 	Math.max(dp[1][c-1],1);			
			} else {
				dp[1][c] = dp[1][c-1];
			}
			
		}

		for (int r = 1; r <= strBlen; r++) {
			if(strA.charAt(0)==strB.charAt(r-1)) {
				dp[r][1] = 	Math.max(dp[r-1][1],1);			
			} else {
				dp[r][1] = dp[r-1][1];
			}
		}
		
		
		for(int r = 1; r <= strBlen; r++) {
			for(int c = 1; c <= strAlen; c++) {
				if(r>strBlen || c>strAlen) {
					continue;
				}
				if(strA.charAt(c-1)==strB.charAt(r-1)) {
					dp[r][c] = dp[r-1][c-1]+1;			
				} else {
					dp[r][c] = Math.max(dp[r-1][c],dp[r][c-1]);
				}
			}
		}

		
		bw.write(dp[strBlen][strAlen]+"");
		bw.flush();
		bw.close();
		br.close();
	}

}