import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int N;
	static List<int[]> headlist;
	static int[][] container;
	static int daycnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		headlist = new ArrayList<int[]>();

		container = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				container[r][c] = Integer.parseInt(st.nextToken());
				if (container[r][c] == 1) {
					headlist.add(new int[] { r, c });
				}
			}
		}

		
		bfs();
		
		boolean allgrown = true;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(container[r][c] == 0) {
					allgrown = false;
					break;
				}
			}			
		}
		
		if(allgrown) {
			System.out.println(daycnt);
		} else {
			System.out.println(-1);
		}
		
	}

	public static void bfs() {

		// 상하좌우 4방탐색
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		Queue<int[]> q = new ArrayDeque<int[]>();
		for (int i = 0, size = headlist.size(); i < size; i++) {
			q.offer(headlist.get(i));
		}
		// 날짜 카운트용
		int[] daycounter = new int[3];
		q.offer(daycounter);
		while (q.size() > 0) {
			int[] cur = q.poll();

			if (cur.length == 3) {
//				System.out.println("날짜가 지나간다"+daycnt);
//				for(int[] line : container) {
//					System.out.println(Arrays.toString(line));
//				}
//				for(int[] temp : q) {
//				System.out.println(Arrays.toString(temp));
//				}
				if (q.size() > 0) {
					q.offer(daycounter);
				} else {
					break;
				}
				daycnt++;
				continue;
			}
			int curr = cur[0];
			int curc = cur[1];

			for (int d = 0; d < 4; d++) {
				int nr = curr + dr[d];
				int nc = curc + dc[d];

				if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
					if (container[nr][nc] == 0) {
						container[nr][nc] = 1;
						q.offer(new int[] { nr, nc });
					}

				}

			}

		}

	}

}