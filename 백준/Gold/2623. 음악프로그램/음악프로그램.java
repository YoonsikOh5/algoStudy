import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	static int N,M;

	static TreeSet<Integer>[] edgeList;
	
	static int beforeArr[];
	static boolean visited[];
	
	static List<Integer> sortedList;
	
//	static class Edge{
//		int start;
//		int end;
//		
//		public Edge(int start, int end) {
//			this.start = start;
//			this.end = end;
//		}
//		
//	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 가수의 수
		N = Integer.parseInt(st.nextToken());
		// 보조 PD의 수
		M = Integer.parseInt(st.nextToken());
		
		edgeList = new TreeSet[N+1];
		
		for(int i = 1; i <= N; i++) {
			edgeList[i] = new TreeSet<>();
		}
		
		// beforeArr[i] i번째 가수 전에 출연해야 하는 가수들 수
		beforeArr = new int[N+1];
		visited = new boolean[N+1];
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int singernum = Integer.parseInt(st.nextToken());
			int sarr[] = new int[singernum];
			for(int j = 0; j < singernum; j++) {
				sarr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j = 1; j < singernum; j++) {
				if(!edgeList[sarr[j-1]].contains(sarr[j])) {
					edgeList[sarr[j-1]].add(sarr[j]);
					beforeArr[sarr[j]]++;
				}
			}
		}
		sortedList = new LinkedList<>();
		topologicalSort();
		
		if(sortedList.size()==N) {
			for(int i = 0; i < N; i++) {
				bw.write(sortedList.get(i)+"\n");
			}
		} else {
			bw.write("0");
		}
	
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void topologicalSort() {
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(beforeArr[i]==0) {
				sortedList.add(i);
				q.add(i);
				visited[i] = true;
			}
		}
		
		while(q.size()>0) {
			
			int cur = q.poll();
			TreeSet<Integer> curts = edgeList[cur];
			Iterator<Integer> it = curts.iterator();
			while(it.hasNext()) {
				int nextnum = it.next();
				beforeArr[nextnum]--;
				if(beforeArr[nextnum]==0) {
					sortedList.add(nextnum);
					q.add(nextnum);
					visited[nextnum] = true;
				}
			}
			
		}
		
		
	}
	

}