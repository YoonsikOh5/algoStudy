import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> primels = new ArrayList<>();
		int arr[] = new int[n+1];
		for(int i = 2; i <= n; i++) {
			if(arr[i]==0) {
				primels.add(i);
			int idx = 2;
			int nextnum = i*idx;
			while(nextnum <= n) {
				arr[nextnum] = 1;
				idx++;
				nextnum = i*idx;
				}
			}
		}
		int j = 0;
		int sum = 0;
		int cnt = 0;
		for(int i = 0, size = primels.size(); i < size; i++) {
			
			while(j < size && sum < n) {
				sum += primels.get(j);
				j++;
			}
			
			if(sum==n) {
				cnt++;
			}
			
			sum -= primels.get(i);
			
		}
		
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
		
	}

}
