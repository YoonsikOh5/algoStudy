import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int arr[];
	static int dp[];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		// dp[i] : 길이 i를 만족하는 자리 i에 오는 수의 최소 값 
		dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int size = 0;
		for(int i = 0; i < N; i++) {
			int cur = arr[i];
			
			int inputidx = Arrays.binarySearch(dp, 0, size, cur);
			
			if(inputidx>=0) {
				continue;
			}
			
			int absidx = Math.abs(inputidx+1);
			dp[absidx] = cur;
			
			if(absidx==size) {
				size++;
			}
		}
		
		bw.write(size+"");
		bw.flush();
		bw.close();
		br.close();
	}


}