import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int tp[][];
	
	// dp[i] N = i 일때의 최댓값
	static int dp[];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		tp = new int[N+1][2];
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			tp[i][0] = t;
			tp[i][1] = p;
		}
		
		dp = new int[N+1];
		dp[0] = 0;
		
		for(int i = 1; i <= N; i++) {
			dp[i] = dp[i-1];
			// tp배열의 1번부터 i까지 돌면서 i날에 끝나는 일이 있는지 확인
			for(int j = 1; j <= i; j++) {
				if((j+tp[j][0])-1==i) {
					dp[i] = Math.max(dp[i], tp[j][1]+dp[i-tp[j][0]]);
				}
			}
		}
		
//		for(int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(dp));
//		}
		bw.write(dp[N]+"");
		bw.flush();
		bw.close();
		br.close();
	}

}