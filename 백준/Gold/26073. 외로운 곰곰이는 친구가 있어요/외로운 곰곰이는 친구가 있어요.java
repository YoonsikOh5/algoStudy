import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, X, Y, T;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= N; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			X = Math.abs(Integer.parseInt(st.nextToken()));
			Y = Math.abs(Integer.parseInt(st.nextToken()));

			st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());
			arr = new int[T];
			for (int i = 0; i < T; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 모든 수의 최대공약수를 구해서 X와 Y 각각 나누어 떨어지는지보고 둘다 나누어떨어지면 Ta-da
			int gcd = arr[0];
			for (int i = 1; i < T; i++) {

				gcd = gcdofTwo(gcd, arr[i]);

			}
			
			if(X%gcd==0 && Y%gcd==0) {
				bw.write("Ta-da\n");
			} else {
				bw.write("Gave up\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
	static int gcdofTwo(int a, int b) {
		
		int d = a % b;
		
		if(d==0) {
			return b;
		}
		
		return gcdofTwo(b, d);
	}

}