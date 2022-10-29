import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	
	static int S,E;
	
	static int dp[][];
	
	static int arr[];
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		arr = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp[s][e] s~e 팰린드롬이면 1 아니면 -1
		dp = new int[N+1][N+1];
		// 한칸은 무조건 1
		for(int i = 1; i <= N; i++) {
			dp[i][i] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = i-1; j > 0; j--) {
				if(arr[i]==arr[j]) {
					if(j+1==i) {
						dp[j][i]=1;
						continue;
					}
					if(dp[j+1][i-1]==1) {
						dp[j][i]=1;
					} else if(dp[j+1][i-1]==-1) {
						dp[j][i]=-1;
					}
				} else if(arr[i]!=arr[j]) {
					dp[j][i]=-1;
				}
			}
		}
		
		M = Integer.parseInt(br.readLine());
		
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			// 일단 hm 확인
			if(dp[S][E]==1) {
				bw.write("1\n");
			} else if(dp[S][E]==-1){
				bw.write("0\n");
			}
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	
}