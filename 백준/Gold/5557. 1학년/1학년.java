import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;

	static int arr[];


	// dp[i][j] i번째까지 수까지 고려했을때 값이 j가 되는 경우의 수
	static long dp[][];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp = new long[N + 1][21];

		dp[0][0] = 1;
		dp[1][arr[1]] = 1;

		for (int i = 2; i < N; i++) {
			for (int j = 0; j <= 20; j++) {
					
					if (j+arr[i] <= 20) {
						dp[i][j] += dp[i - 1][j+arr[i]];
					}

					
					if (j-arr[i] >= 0) {
						dp[i][j] += dp[i - 1][j-arr[i]];
					}
					
			}
		}
		
		
		bw.write(dp[N-1][arr[N]] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}