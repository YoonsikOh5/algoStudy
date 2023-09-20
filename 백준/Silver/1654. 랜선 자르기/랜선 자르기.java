import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String kn = br.readLine();
		StringTokenizer st = new StringTokenizer(kn);
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		long[] karr = new long[k];

		long k_sum = 0;
		for (int i = 0; i < k; i++) {
			karr[i] = Long.parseLong(br.readLine());
			k_sum += karr[i];
		}
		br.close();
		
		long n_average = k_sum / n;
		long start = 0;
		long end = n_average+1;// lowerbound니까 마지막+1까지 찾음
		long divider = (start + end) / 2;
		while (start != end) {
			long count = 0;
			for (int i = 0; i < k; i++) {
				count += karr[i] / divider;
			}
			// count가 n보다 작을때는 확실하게 아래쪽으로 가면 됨
			// 근데 결과값 아래에서는 전부 count가 n보다 큰경우라서 그 경계를 찾아야할듯?
			
			// lowerbound upperbound 머리 깨져~
			// count == n-1의 lowerbound로 찾는 버전
			if (count > n-1) {
				start = divider + 1;
				divider = (start + end) / 2;
			} else if (count <= n-1) {
				end = divider;
				divider = (start + end) / 2;
			}
			
			// count == n의 upperbound로 찾는 버전
//			if (count >= n) {
//				start = divider+1;
//				divider = (start + end) / 2;
//			} else if (count < n) {
//				end = divider;
//				divider = (start + end) / 2;
//			}
		}
		System.out.println(start-1);

	}

}