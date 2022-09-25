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
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int j = n-1;
		int min_result = Integer.MAX_VALUE;
		int minleft = 0;
		int minright = 0;
		for(int i = 0; i < j;) {
			int left = arr[i];
			int right = arr[j];
			
			int sum = left+right;
			if(min_result > Math.abs(sum)) {
				minleft = arr[i];
				minright = arr[j];
				min_result = Math.abs(sum);
			}
			
			if(sum < 0) {
				i++;
			} else if(sum > 0){
				j--;
			} else if(sum == 0) {
				break;
			}
			
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(minleft+" "+minright);
		bw.flush();
		bw.close();
		br.close();
		
	}

}
