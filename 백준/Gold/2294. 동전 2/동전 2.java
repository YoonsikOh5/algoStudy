import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;
	static int[] dp;
	// 틀렸던 부분 dp에 들어갈 수 있는 최댓값은 k의 최댓값임 k를 1만 사용해서 만들면 k의 최댓값만큼 들어갈 수 있기 때문
	static final int MAX_N = 10001;
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 동전 종류 담을곳
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[M+1];
		Arrays.fill(dp, MAX_N);
		// 0은 0개로도 만들 수 있으니까
		dp[0] = 0;
		
	
		for(int i = 0; i < N; i++) {
			int cur = arr[i];
			for(int j = 0; j <= M; j++) {
				if((j-cur)>=0 && dp[j-cur]!=MAX_N) {
					dp[j] = Math.min(dp[j], dp[j-cur]+1);					
				}
			}
		}
		
//		System.out.println(Arrays.toString(dp));
		
		if(dp[M]!=MAX_N) {
			bw.write(dp[M]+"");			
		} else {
			bw.write("-1");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}


}