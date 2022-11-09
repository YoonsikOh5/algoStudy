import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;

	static PriorityQueue<Edge> pq;

	static int[] computers;

	static int resultSum;

	static class Edge implements Comparable<Edge> {

		int left;
		int right;
		int cost;

		public Edge(int left, int right, int cost) {
			super();
			this.left = left;
			this.right = right;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		pq = new PriorityQueue<>();

		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			pq.add(new Edge(left, right, cost));

		}

		computers = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			computers[i] = i;
		}

		doKruskal();

		bw.write(resultSum + "");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void doKruskal() {

		int selectedCnt = 0;

		while (selectedCnt < N - 1) {

			Edge cur = pq.poll();

			if (union(cur.left, cur.right)) {
				resultSum += cur.cost;
				selectedCnt++;
			}

		}

	}
	
	public static boolean union(int left, int right) {
		if(findParent(left)==findParent(right)) {
			return false;			
		} else {
			computers[findParent(left)] = findParent(right);
			return true;
		}
		
	}
	
	public static int findParent (int child) {
		
		if(computers[child]==child) {
			return child;
		} else {
			computers[child] = findParent(computers[child]);
			return computers[child];
		}
		
	}

}
