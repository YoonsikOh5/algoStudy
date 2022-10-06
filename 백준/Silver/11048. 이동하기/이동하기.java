import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] maze;
	static int[][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N+1][M+1];
		for(int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= M; c++) {
				maze[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N+1][M+1];
		for(int c = 1; c <= M; c++) {
			dp[1][c] = dp[1][c-1]+maze[1][c];
		}
		for(int r = 1; r <= N; r++) {
			dp[r][1] = dp[r-1][1]+maze[r][1];
		}
		
		for(int r = 2; r <= N; r++) {
			for(int c = 2; c <= M; c++) {
				dp[r][c] = Math.max(Math.max(dp[r-1][c], dp[r][c-1]),dp[r-1][c-1])+maze[r][c];
			}
		}
		
//		for(int[] arr : dp) {
//			System.out.println(Arrays.toString(arr));
//		}

		bw.write(dp[N][M]+"");
		bw.flush();
		bw.close();
		br.close();
	}


}