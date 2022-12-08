import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;

	static int[][] board;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class RC{
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

		board = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		boolean allwater = false;
		boolean notfound = true;
		while (!allwater) {
			year++;
			int[][] temp = new int[N][M];
			allwater = true;
			int ice = 0;
			int[] firstrc = new int[2];
			boolean firstice = true;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(board[r][c]>0) {
						int bwater = 0;
						for(int d = 0; d < 4; d++) {
							int nr = r+dr[d];
							int nc = c+dc[d];
							if(nr>=0 && nr < N && nc >=0 && nc <=M) {
								if(board[nr][nc]==0) {
									bwater++;
								}
							}
						}
						
						int next = board[r][c] - bwater;
						
						if(next>0) {
							ice++;							
							allwater = false;
							if(firstice) {
								firstrc[0] = r;
								firstrc[1] = c;
								firstice=false;
							}
						} else {
							next = 0;
						}
						temp[r][c] = next;
					}
				}
			}
			
			board = temp;
			if(!allwater) {
				if(ice!=bfs(firstrc)) {
					bw.write(year+"");
					notfound = false;
					break;
				}
			}
		}
		if(notfound) {
			bw.write(0+"");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int bfs(int[] firstrc) {
		int icecnt = 1;
		
		boolean visited[][] = new boolean[N][M];
		
		Queue<RC> q = new LinkedList<>();
		
		q.add(new RC(firstrc[0],firstrc[1]));
		
		visited[firstrc[0]][firstrc[1]]=true;
		
		while(q.size()>0) {
			RC cur = q.poll();
			
			int curr = cur.r;
			int curc = cur.c;
			
			for(int d = 0; d < 4; d++) {
				int nr = curr+dr[d];
				int nc = curc+dc[d];
				if(nr>=0 && nr < N && nc >=0 && nc <=M) {
					if(board[nr][nc]>0 && visited[nr][nc]==false) {
						visited[nr][nc] = true;
						icecnt++;
						q.add(new RC(nr,nc));
					}
				}
			}
		}
		
		return icecnt;
	}

}