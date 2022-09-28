import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int map[][];
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N+1][M+1];

		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int curr = Integer.parseInt(st.nextToken());
			int curc = Integer.parseInt(st.nextToken());
			map[curr][curc] = 1;
		}
		
		for(int r = 1; r <= N; r++) {
			for(int c= 1; c <= M; c++) {
				if(map[r][c]==1) {
					bfs(r,c);									
				}
			}
		}
		
		bw.write(max_result+"");

		bw.flush();
		bw.close();
		br.close();

	}
	// 상하좌우
	static int dr[] = {-1, 1, 0,0};
	static int dc[] = {0,0,-1,1};
	
	public static boolean inRange(int nr, int nc) {
		if(nr >= 1 && nr <= N && nc >= 1 && nc <= M) {
			return true;
		} else {
			return false;
		}
	}
	
	static class RC{
		int r;
		int c;
		
		public RC(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		
	}
	
	static int max_result = Integer.MIN_VALUE;
	
	public static void bfs(int r, int c) {
		
		Queue<RC> q = new LinkedList<RC>();
		
		q.add(new RC(r,c));
		map[r][c] = 2;
		int sizeoftrash = 0;
		while(q.size()>0) {
			RC cur = q.poll();
			sizeoftrash++;
			int curr = cur.r;
			int curc = cur.c;
			
			for(int d = 0; d < 4; d++) {
				int nr = curr+dr[d];
				int nc = curc+dc[d];
				
				if(inRange(nr,nc) && map[nr][nc]==1) {
					map[nr][nc] = 2;
					q.add(new RC(nr,nc));
				}
				
			}
			
		}
		
		max_result = Math.max(max_result, sizeoftrash);
		
	}

}
