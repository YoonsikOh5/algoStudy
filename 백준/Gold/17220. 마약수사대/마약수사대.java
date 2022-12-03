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

	static int N, M;
	static int[][] adj;
	static boolean[] visited;

	static int result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		adj = new int[N][N];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int fromP = st.nextToken().charAt(0) - 'A';
			int toP = st.nextToken().charAt(0) - 'A';

			adj[fromP][toP] = 1;
		}

		st = new StringTokenizer(br.readLine());

		int arrestedCnt = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= arrestedCnt; i++) {
			int arrested = st.nextToken().charAt(0) - 'A';
			visited[arrested] = true;
		}
		List<Integer> startls = new ArrayList<>();
		for (int c = 0; c < N; c++) {
			boolean isStart = true;
			for (int r = 0; r < N; r++) {
				if (adj[r][c] == 1) {
					isStart = false;
					break;
				}
			}
			if (isStart) {
				startls.add(c);
			}
		}
		
		for(int i = 0; i < startls.size(); i++) {
			if(visited[startls.get(i)]==false) {
				bfs(startls.get(i));				
			}
		}

		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();

		q.add(start);

		visited[start] = true;

		while (q.size() > 0) {
			int next = q.poll();
			for (int i = 0; i < N; i++) {
				if (adj[next][i] == 1 && visited[i] == false) {
					result++;
					visited[i] = true;
					q.add(i);
				}
			}
		}

	}

}