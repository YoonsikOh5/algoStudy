import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int min_jump = 0;
		
		boolean findr = true;
		int idx = -1;
		for(int i = 0; i < n; i=idx) {
			int cur = arr[i];
			min_jump++;
			if(i+cur>=n-1) {
				break;
			}
			int max = 0;
			idx = -1;
			for(int j = i+1; j <= i+cur; j++) {
				if(max < j+arr[j]) {
					max = j+arr[j];
					idx = j;
				}
			}
			if(idx == -1) {
				findr = false;
				break;
			}
		}
		
		if(!findr) {
			bw.write("-1");
		} else {
			if(n==1) {
				bw.write("0");
			}else {
				bw.write(min_jump+"");				
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}