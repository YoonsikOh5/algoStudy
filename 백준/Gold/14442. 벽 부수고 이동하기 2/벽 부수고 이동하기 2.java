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

	static int n, m, k;
	static char[][] map;
	static boolean[][][] visited;
	static int[][] step;
	static boolean[][][] wallls;
	static int min_route = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		wallls = new boolean[n][m][k+2];
		map = new char[n][];
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		
		
		step = new int[n][m];
		visited = new boolean[n][m][k+2];
		bfs();
//		for(int[] arr : step) {
//			System.out.println(Arrays.toString(arr));
//		}
		
//		System.out.println(step[n-1][m-1]);
		if(min_route==Integer.MAX_VALUE) {
			if(n==1&&m==1) {
				bw.write("1");
			}else {
				bw.write("-1");				
			}
		} else {
			bw.write(min_route+"");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = { 0, 0, -1, 1};
	
	static void bfs() {
		Queue<RC> q = new LinkedList<>();
		q.add(new RC(0,0));
		visited[0][0][0] = true;
		step[0][0] = 1;
		

		whileloop : while(q.size()>0) {
			RC cur = q.poll();
			int curr = cur.r;
			int curc = cur.c;
			
			for(int d = 0; d < 4; d++) {
				int nr = curr+dr[d];
				int nc = curc+dc[d];
				
				if(nr>=0 && nr<n && nc>=0 && nc<m) {
					if(map[nr][nc]=='0' && visited[nr][nc][cur.bcnt]==false) {
						visited[nr][nc][cur.bcnt] = true;
//						if(step[nr][nc]!=0 && step[nr][nc]<=step[curr][curc]+1) {
//							continue;
//						}
						step[nr][nc] = step[curr][curc]+1;
						if(nr == n-1 && nc == m-1) {
							min_route = Math.min(min_route, step[nr][nc]);
							break whileloop;
						}
						q.add(new RC(nr,nc,cur.bcnt));
					}
//					} else if(map[nr][nc]=='0' && visited[nr][nc][cur.bcnt]==false) {
//						visited[nr][nc][cur.bcnt] = true;
//						step[nr][nc] = step[curr][curc]+1;
//						if(nr == n-1 && nc == m-1) {
//							min_route = Math.min(min_route, step[nr][nc]);
//							break whileloop;
//						}
//						q.add(new RC(nr,nc,cur.bcnt));
//					} 
					if(map[nr][nc]=='1' && visited[nr][nc][cur.bcnt+1]==false && cur.bcnt<k && (wallls[nr][nc][cur.bcnt+1]==false)) {
						visited[nr][nc][cur.bcnt+1] = true;
						wallls[nr][nc][cur.bcnt+1] = true;
						step[nr][nc] = step[curr][curc]+1;
						q.add(new RC(nr,nc,cur.bcnt+1));
					}
				}
			}
			
		}

	}
	
	
	static class RC{
		int r;
		int c;
		int bcnt = 0;
		
		public RC(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public RC(int r, int c, int bcnt) {
			super();
			this.r = r;
			this.c = c;
			this.bcnt = bcnt;
		}
		
	}

}