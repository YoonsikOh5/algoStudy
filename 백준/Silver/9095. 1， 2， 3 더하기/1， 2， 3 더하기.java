import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] memo;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		memo = new int[12];
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		for(int i = 4; i <= 11; i++) {
			memo[i] = memo[i-1]+memo[i-2]+memo[i-3];
		}
		
		for(int test_case = 0; test_case < T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			
			bw.write(memo[n]+"\n");
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	

}