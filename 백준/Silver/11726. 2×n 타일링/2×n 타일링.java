import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] memo = new int[n+1];
		
		memo[0] = 1;
		memo[1] = 1;
		if(n>=2) {
		memo[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			memo[i] = (memo[i-1]+memo[i-2])%10007;
		}

		}
		
		bw.write(memo[n]+"");
		bw.flush();
		bw.close();
		br.close();
	}


}