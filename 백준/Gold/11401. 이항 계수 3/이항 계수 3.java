import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int P = 1000000007;
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		// M이 크니까 미리 구해줌
		long[] modarr = new long[4000001];
		modarr[0] = 1;
		for(int i = 1; i <= 4000000; i++) {
			modarr[i] = (modarr[i-1]*i)%P; 
		}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			// 조합의 개수
			//      N!
			// (N-R)! * R!
			// 약분되는거 하나랑 나머지 밑에 깔린 분모는 (P-2)제곱의 곱으로 바꿔줌
			
			
			long left = modarr[N];
			long right = (modarr[N-R]*modarr[R])%P;
			
			
			// right^(p-2)는 재귀로
			long result = ((left%P)*(rmod(right,P-2)%P))%P;
			
			
			bw.write(result+"\n");
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long rmod(long a, long b) {
		if(b==1) {
			return a;
		}
		
		long half = rmod(a,b/2);
		if(b%2==0) {
			return (half*half)%P;
		} else {
			return ((half*half)%P*a)%P;
		}
		
	}

}