import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static long[][] memo;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		memo = new long[41][2];
		
		memo[0][0] = 1;
		memo[0][1] = 0;
		
		memo[1][0] = 0;
		memo[1][1] = 1;
		
		memo[2][0] = 1;
		memo[2][1] = 1;

		memo[3][0] = 1;
		memo[3][1] = 2;
		
		
		for(int i = 4; i <= 40; i++) {
			memo[i][0] = memo[i-1][0] + memo[i-2][0];
			memo[i][1] = memo[i-1][1] + memo[i-2][1];
		}
		
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			bw.write(memo[n][0]+" "+memo[n][1]+"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long cnt0;
	static long cnt1;
	


}