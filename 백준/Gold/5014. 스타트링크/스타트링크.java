import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	static int F, S, G, U, D;
	static int step[];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		step = new int[F+1];
		bfs();
//		System.out.println(Arrays.toString(step));
		if(result != -1) {
			bw.write(result+"");
		} else {			
			bw.write("use the stairs");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int result = -1;
	
	static void bfs() {
		if(S==G) {
			result = 0;
			return;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(S);
		// 마지막에 1안더해줘도 됨
		step[S] = 1;
	
		
		while(q.size()>0) {
			int cur = q.poll();
			
			int un = cur+U;
			int dn = cur-D;

			if(un==G || dn==G) {
				result = step[cur];
				return;
			}
			
			if(inRange(un) && step[un]==0) {
				step[un] = step[cur]+1;
				q.add(un);
			}
			
			if(inRange(dn) && step[dn]==0) {
				step[dn] = step[cur]+1;
				q.add(dn);
			}
			
		}
		
		
	}
	
	static boolean inRange(int n) {
		if(n>=1 && n<=F) {
			return true;
		} else {
			return false;
		}
	}

}