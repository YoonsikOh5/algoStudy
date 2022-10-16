import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	
	static int lensum;
	
	static int[] rep;
	
	static PriorityQueue<Edge> q;
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int len;
		
		public Edge(int start, int end, int len) {
			super();
			this.start = start;
			this.end = end;
			this.len = len;
		}

		@Override
		public int compareTo(Edge o) {
			return this.len - o.len;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		rep = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			rep[i]= i;
		}
		
		q = new PriorityQueue<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			q.add(new Edge(start, end, len));
		}
		
		lensum = 0;
		
		doPrim();
		
		bw.write(lensum+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	static void doPrim() {
		
		int selectedEdgeCount = 0;
		
		// 마지막꺼 하나 안뽑으면 두개의 마을로 나뉨
		while(selectedEdgeCount!=N-2) {
			Edge cur = q.poll();
			
			int start = cur.start;
			int end = cur.end;
			int len = cur.len;
			
			if(unionSet(start,end)) {
				selectedEdgeCount++;
				lensum += len;
			}
			
		}
		
	}
	
	static boolean unionSet(int left, int right) {
		int leftParent = findParent(left);
		int rightParent = findParent(right);
		if(leftParent==rightParent) {
			return false;
		} else {
			rep[rightParent] = leftParent;
			return true;
		}
		
	}
	
	static int findParent(int child) {
		if(rep[child]==child) {
			return child;
		} else {
			rep[child] = findParent(rep[child]);
			return rep[child];
		}
		
	}

}