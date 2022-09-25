import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int min_result = Integer.MAX_VALUE;
		int j = 0;
		boolean find = false;
		for(int i = 0; i < n; i++) {
			
			while(j < n && sum < s) {
			sum += arr[j];
			j++;
			}
			
			if(sum >= s) {
				find = true;
				int len = j-i;
				if(min_result > len) {
					min_result = len;
				}
			}
			
			sum -= arr[i];
			
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if(!find) {
			bw.write("0\n");
		} else {
			bw.write(min_result+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}
