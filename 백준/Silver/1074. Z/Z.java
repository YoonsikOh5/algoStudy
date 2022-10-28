import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, r, c;
	
	static int divider;
	
	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		divider = (int) Math.pow(2, N-1);
		
		count = 0;
		
		findnum(r,c,divider);
		
		bw.write(count+"");
		bw.flush();
		bw.close();
		br.close();
	}

	static void findnum(int r, int c, int divider) {
		
		if(divider == 0) {
			return; 
		}
		
		int rdiv = r/divider;
		int cdiv = c/divider;
		
		int mul = divider * divider;
		
		// 1사분면
		if(rdiv == 0 && cdiv == 0) {
			count += 0;
		// 2사분면
		} else if(rdiv == 0 && cdiv == 1) {
			count += mul;
		// 3사분면
		} else if(rdiv == 1 && cdiv == 0) {
			count += mul*2;
		// 4사분면
		} else if(rdiv == 1 && cdiv == 1) {
			count += mul*3;
		}
		
		findnum(r%divider, c%divider, divider/2);
		
	}

}