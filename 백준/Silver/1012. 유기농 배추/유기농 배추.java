import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 순회해서 숫자만 세면 되는거니까 bfs로 풀자

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			// 세로길이
			int M = Integer.parseInt(st.nextToken());
			// 가로길이
			int N = Integer.parseInt(st.nextToken());

			// 정점 수
			int K = Integer.parseInt(st.nextToken());
			int[][] matrix = new int[M][N];

			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				matrix[r][c] = i; // 요러면 1,2,3,4...로 들어감
			}

			adjList = new Cabbage[K + 1]; // 0번 안쓸꺼임
			visited = new boolean[K + 1];
			// 상하좌우 사방탐색용
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };

			// 매트릭스 순회하면서 간선정보 adjList에 넣기
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if (matrix[r][c] != 0) { // 0이 아닐때만 연결하면 됨
						int from = matrix[r][c];
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];

							if (nr >= 0 && nc >= 0 && nr < M && nc < N) {
								int to = matrix[nr][nc];
								if (to != 0) {
									adjList[from] = new Cabbage(to, adjList[from]); // 무향 그래프이지만 to자리에서도 from 연결할꺼니까 두번
																					// 안해줘도 됨
								}
							}
						}
					}
				}
			}

			int groupcnt = 0;
			// 연결 다 됐으니 bfs로 순회하고 정답 출력
			for (int R = 1; R <= K; R++) {
				if (visited[R] != true) {
					bfs(R);
					groupcnt++;
				}
			}

			bw.write(groupcnt + "\n");

		}

		bw.flush();
		bw.close();
		br.close();

	}

	static Cabbage[] adjList;
	static boolean[] visited;

	public static void bfs(int R) {

		visited[R] = true;

		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(R);
		while (q.size() > 0) {
			int cur = q.poll();
			for (Cabbage temp = adjList[cur]; temp != null; temp = temp.next) {
				if (visited[temp.to] == false) {
					visited[temp.to] = true;
					q.offer(temp.to);
				}
			}
		}


	}

}

class Cabbage {
	int to;
	Cabbage next;

	public Cabbage(int to, Cabbage next) {
		this.to = to;
		this.next = next;
	}

}
