import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int allair;
	static int aircnt;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		allair = n*m;
		map = new int[n+1][m+1];
		for(int r = 1; r <= n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= m; c++) {
				int cur = Integer.parseInt(st.nextToken());
				map[r][c] = cur;
			}
		}
		visited = new boolean[n+1][m+1];
		int result_time = 0;
		
		aircnt = 0;
		for(int r = 1; r <= n; r++) {
			for(int c = 1; c <= m; c++) {
				if(map[r][c]==0) {
					aircnt++;
				}
			}
		}
		
		while(!(aircnt==allair)) {
			bfs();
			result_time++;
			meltcheese();
		}
		
		bw.write(result_time+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	static void meltcheese(){
		List<RC> meltingls = new ArrayList<>();
		for(int r = 1; r <= n; r++) {
			for(int c = 1; c <= m; c++) {
				if(map[r][c]==1) {
					boolean ismelting = false;
					int cnt=0;
					for(int d = 0; d < 4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if(nr>=1 && nc >= 1 && nr <= n && nc <= m) {
							if(visited[nr][nc]) {
								cnt++;
								if(cnt==2) {
									ismelting = true;									
									break;
								}
							}
						}
					}
					if(ismelting) {
						meltingls.add(new RC(r,c));
					}
				}
			}
		}
		
		for(int i = 0, size = meltingls.size(); i < size; i++) {
			RC cur = meltingls.get(i);
			int curr = cur.r;
			int curc = cur.c;
			
			map[curr][curc] = 0;
			aircnt++;
		}
	}

	
	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static void bfs() {
		
		visited = new boolean[n+1][m+1];
		Queue<RC> q = new LinkedList<RC>();
		q.add(new RC(1,1));
		visited[1][1] = true;
		
		
		while(q.size()>0){
			RC cur = q.poll();
			
			int curr = cur.r;
			int curc = cur.c;
			
			for(int d = 0; d < 4; d++) {
				int nr = curr+dr[d];
				int nc = curc+dc[d];
				
				if(nr>=1 && nc >= 1 && nr <= n && nc <= m) {
					if(map[nr][nc]==0 && visited[nr][nc]==false) {
						visited[nr][nc] = true;
						q.add(new RC(nr,nc));
					}
				}
			}
		}
		
	}
	
	static class RC{
		int r;
		int c;
		
		public RC(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "RC [r=" + r + ", c=" + c + "]";
		}
		
		
	}
}