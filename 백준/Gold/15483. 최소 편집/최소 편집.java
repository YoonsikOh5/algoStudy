import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static String strA, strB;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		strA = br.readLine();
		strB = br.readLine();
		
		int lA = strA.length();
		int lB = strB.length();
		
		dp = new int[lA+1][lB+1];
		
		for(int i = 1; i <= lB; i++) {
			dp[0][i] = i;
		}
		for(int i = 1; i <= lA; i++) {
			dp[i][0] = i;
		}
		
		for(int a = 1; a<= lA; a++) {
			for(int b = 1; b<= lB; b++) {
				if(strA.charAt(a-1)==strB.charAt(b-1)) {
					dp[a][b] = dp[a-1][b-1];
				} else {
					dp[a][b] = Math.min(dp[a-1][b-1],Math.min(dp[a-1][b], dp[a][b-1]))+1;
				}
			}
		}
		
//		for(int[] sarr : dp) {
//			System.out.println(Arrays.toString(sarr));
//		}
		
		
		bw.write(dp[lA][lB]+"");
		bw.flush();
		bw.close();
		br.close();
	}

}