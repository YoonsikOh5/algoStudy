import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int map[][];
	static int min_result=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 섬의 번호를 묶어줌
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c]==1) {
					bfs(r,c);					
				}
			}
		}
		
//		for(int[] arr : map) {
//			System.out.println(Arrays.toString(arr));		
//		}
		
	
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c]>1) {
					bfs2(r,c);					
				}
			}
		}


		bw.write(min_result+"");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static int team = 2;
	
	static class Rc{
		int r;
		int c;
		
		public Rc(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		
	}
	

	// 상하좌우
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,-1,1};
	
	static boolean inRange(int nr, int nc) {
		if(nr>=0 && nr < N && nc >= 0 && nc < N) {
			return true;
		}else {
			return false;			
		}
	}
	
	
	// 섬끼리 같은 팀으로 묶어주는 bfs 섬의 번호는 2번부터
	static void bfs(int r, int c) {
		
		Queue<Rc> q = new LinkedList<>();
		
		
		q.add(new Rc(r,c));
		map[r][c] = team;
		
		while(q.size()>0) {
			Rc cur = q.poll();
			
			int curr = cur.r;
			int curc = cur.c;
			
			for(int d = 0; d < 4; d++) {
				int nr = curr+dr[d];
				int nc = curc+dc[d];
				
				if(inRange(nr,nc)&&map[nr][nc]==1) {
					map[nr][nc] = team;
					q.add(new Rc(nr,nc));
				}
				
			}
			
		}
		team++;
	}
	
	static boolean visited[][];
	
	static void bfs2(int r, int c) {
		// 현재 섬과 다른 섬을 발견하면 이어주면됨
		int curteam = map[r][c];
		visited = new boolean[N][N];
		visited[r][c] = true;
		Queue<Rc> q = new LinkedList<>();
		
		q.add(new Rc(r,c));
		q.add(new Rc(-1,-1));
		int count = 0;
		
		whileloop : while(q.size()>0) {
			Rc cur = q.poll();
			int curr = cur.r;
			int curc = cur.c;
			if(curr==-1 && curc==-1) {
				count++;
				if(q.size()==0) {
					break whileloop;
				}
				q.add(new Rc(-1,-1));
				continue;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = curr+dr[d];
				int nc = curc+dc[d];
				
				if(inRange(nr,nc) && (visited[nr][nc]==false)) {
					if(map[nr][nc]==0) {
						visited[nr][nc] = true;
						q.add(new Rc(nr,nc));						
					} else if (map[nr][nc]>=2 && map[nr][nc]!=curteam) {
						min_result = Math.min(min_result, count);
						break whileloop;
					}
				}
				
			}
			
		}
	}

}
