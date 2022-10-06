import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long[][] house;
	static long[][][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		house = new long[N+1][N+1];
		
		for(int r = 1; r <= N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= N; c++) {
				house[r][c] = Long.parseLong(st.nextToken());
			}			
		}
	
		// 0 가로 1 대각 2 세로 로 들어온 경우의 수
		dp = new long[N+1][N+1][3];
		dp[1][2][0] = 1;
		
		// 맨 윗줄은 무조건 1
		for(int c = 3; c <= N; c++) {
			if(house[1][c]==0) {
				dp[1][c][0] = dp[1][c-1][0];				
			}
		}
		
		
		for(int r = 2; r <= N; r++) {
			for(int c = 2; c <= N; c++) {
				if(house[r][c]==0) {					
				// 가로로 들어오려면  왼쪽칸에 가로, 대각으로 들어온 경우를 합치면 됨
				dp[r][c][0] = dp[r][c-1][0]+dp[r][c-1][1];
				// 대각으로 들어오려면 왼쪽 위칸의 모든 경우를 합치면 됨
				// 벽 판단은 대각으로 들어올때만 해주면 됨
				if(house[r-1][c]!=1&&house[r][c-1]!=1) {
					dp[r][c][1] = dp[r-1][c-1][0]+dp[r-1][c-1][1]+dp[r-1][c-1][2];					
				}
				// 세로로 들어오려면 위칸에 대각, 세로로 들어온 경우를 합치면 됨
				dp[r][c][2] = dp[r-1][c][1]+dp[r-1][c][2];
				}
			}
		}
		long result_cnt = 0;
		for(int i = 0; i < 3; i++) {
			result_cnt += dp[N][N][i];
		}
		bw.write(result_cnt+"");
		
		bw.flush();
		bw.close();
		br.close();
	}


}