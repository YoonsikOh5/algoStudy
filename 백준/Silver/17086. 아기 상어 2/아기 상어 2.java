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

	static int N,M;
	static int map[][];
	static int visited[][];
	static int step[][];
	static List<RC> slist;
	static int max_result;
	static final Integer MAX_D = 3000;
	
	public static class RC{
		int r;
		int c;
		
		public RC(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		slist = new ArrayList<>();
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				int cur = Integer.parseInt(st.nextToken());
				map[r][c] = cur;
				if(cur==1) {
					slist.add(new RC(r,c));
				}
			}			
		}
		step = new int[N][M];
		for(int[] arr : step) {
			Arrays.fill(arr, MAX_D);
		}
		visited = new int[N][M];
		bfs();
		max_result = Integer.MIN_VALUE;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				max_result = Math.max(max_result, step[r][c]);
			}			
		}
		
		bw.write(max_result+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	// 8방 탐색 위부터 시계
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	
	public static void bfs() {
		// 1부터 시작해서 visited까지 한꺼번에 처리하고 마지막에 -1빼고 계산
		Queue<RC> q = new LinkedList<>();
		for(int i = 0, size = slist.size(); i < size; i++) {
			RC cur = slist.get(i);
			int curr = cur.r;
			int curc = cur.c;
			step[curr][curc] = 0;
			visited[curr][curc] = 1;			
			q.add(cur);
		}
		
		while(q.size()>0) {
			RC cur = q.poll();
			int curr = cur.r;
			int curc = cur.c;
			
			for(int d = 0; d < 8; d++) {
				int nr = curr+dr[d];
				int nc = curc+dc[d];
				if(inRange(nr,nc) && visited[nr][nc]==0) {	
					step[nr][nc] = step[curr][curc]+1;
					visited[nr][nc]=1;
					q.add(new RC(nr,nc));
				}
			}
		}
		
	}
	
	public static boolean inRange(int nr, int nc) {
		if(nr>=0 && nr < N && nc>=0 && nc < M) {
			return true;
		}else {
			return false;			
		}
	}
	
}