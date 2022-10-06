import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
	
	public class Main {
	
		static int N;
		static int[] arr;
		static int[][] dp;
		
		public static void main(String[] args) throws IOException {
	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[N+1];
			for(int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// [0][N]은 증가하는 배열
			// [1][N]은 감소하는 배열
			dp = new int[2][N+1];
			
			dp[0][1] = 1;
			dp[1][1] = 1;
			
			for(int i = 1; i <= N; i++) {
				int cur = arr[i];
				
				for(int j = 0; j < i; j++) {
					// 증가하는 경우
					if(arr[j] < cur) {
						dp[0][i] = Math.max(dp[0][i], dp[0][j]+1);
					}
					if(arr[j] > cur) {
						dp[1][i] = Math.max(dp[1][i], dp[1][j]+1);
					}
				}
				// 다 하고 나서 dp[0][i]랑 dp[1][i] 비교해서 덮어줌
				dp[1][i] = Math.max(dp[0][i], dp[1][i]);
				
			}
			
//			for(int[] arr : dp) {
//			System.out.println(Arrays.toString(arr));
//			}
			
			int max_streak = 1;
			for(int i = 1; i <= N; i++) {
				max_streak = Math.max(max_streak, dp[1][i]);
			}
			
			
			bw.write(max_streak+"");									
			
			bw.flush();
			bw.close();
			br.close();
		}
		
		
	
	}