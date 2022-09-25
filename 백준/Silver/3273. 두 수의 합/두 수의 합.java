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
		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		int j = n-1;
		int cnt = 0;
		firstloop : for(int i = 0; i < j; i++) {
			int cur = arr[i];
			
			while((cur+arr[j]>=x) && (cur + arr[j]) != x) {
				j--;
				if(j <= i) {
					break firstloop;
				}
			}
			if(cur+arr[j]==x) {
				cnt++;							
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
		
	}

}