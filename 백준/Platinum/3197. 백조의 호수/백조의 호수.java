import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] map;
	// [r][c][0or1]
	// [r][c][0] r,c 대표의 r
	// [r][c][1] r,c 대표의 c
	static int[][][] uset;
	static int[][] visited;
	static RC swan1;
	static RC swan2;
	static Queue<RC> outerIceLs;
	
	static class RC{
		int r;
		int c;
		
		public RC(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + c;
			result = prime * result + r;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RC other = (RC) obj;
			if (c != other.c)
				return false;
			if (r != other.r)
				return false;
			return true;
		}
		
		
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		uset = new int[R][C][2];
		int swan = 1;
		for(int r = 0; r < R; r++) {
			String str = br.readLine();
			for(int c = 0; c < C; c++) {
				char cur = str.charAt(c);
				
				uset[r][c][0] = r;
				uset[r][c][1] = c;
				
				if(cur=='L') {
					// 백조는 따로 저장해두고 . 으로 넣자
					cur='.';
					if(swan == 1) {
						swan1 = new RC(r,c);
						swan++;
					} else if(swan==2) {
						swan2 = new RC(r,c);
					}
				}
				map[r][c] = cur;
			}
		}
	
		
		visited = new int[R][C];
		outerIceLs = new LinkedList<>();
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c]=='.' && visited[r][c]==0) {
					bfs(r,c);
				}
			}			
		}
		
//		for(boolean[] bar : visited) {
//			System.out.println(Arrays.toString(bar));
//		}
		
		// 일단 먼저 확인
		boolean findresult = false;
		if(findParent(swan1).equals(findParent(swan2))) {
			bw.write("0");
			findresult = true;
		}
		
		RC timecounter = new RC(-1,-1);
		outerIceLs.add(timecounter);
		int time = 0;
		if(!findresult) {
			
			while(outerIceLs.size()>0) {
				RC cur = outerIceLs.poll();
				
				int curr = cur.r;
				int curc = cur.c;
				
				
				if(curr==-1 && curc==-1) {
					time++;
					if(findParent(swan1).equals(findParent(swan2))) {
						bw.write(time+"");
						break;
					}
					if(outerIceLs.size()==0) {
						break;
					} 
					outerIceLs.add(timecounter);
					continue;
				}
				map[curr][curc]='.';
				for(int d = 0; d < 4; d++) {
					int nr = curr+dr[d];
					int nc = curc+dc[d];
					
					// true라는거는 물 or 이미 녹은 물 -> 유니온 가능
					if(inRange(nr,nc) && visited[nr][nc]==1 && map[nr][nc]=='.') {
						RC nspot = new RC(nr,nc);
						unionSet(cur,nspot);
					} else if(inRange(nr,nc) && visited[nr][nc]==0 && map[nr][nc]=='X') {
						RC nspot = new RC(nr,nc);
						visited[nr][nc]=1;
						outerIceLs.add(nspot);
					}
				}
				
			}
		}
//		System.out.println(time);
//		for(int varr[] : visited) {
//			System.out.println(Arrays.toString(varr));
//			
//		}
		
		
		
		bw.flush();
		bw.close();
		br.close();

	}

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	
	
	static void bfs(int r,int c) {
		
		Queue<RC> q = new LinkedList<>();
		RC start = new RC(r,c);
		visited[r][c] = 1;
		q.add(start);
		
		while(q.size()>0) {
			RC cur = q.poll();
			int curr = cur.r;
			int curc = cur.c;
			for(int d = 0; d < 4; d++) {
				int nr = curr+dr[d];
				int nc = curc+dc[d];
				if(inRange(nr,nc) && visited[nr][nc]==0) {
					if(map[nr][nc]=='.') {
						// cur과 new spot union
						RC nspot = new RC(nr,nc);
						unionSet(cur,nspot);
						visited[nr][nc]=1;
						q.add(nspot);
					} else if(map[nr][nc]=='X') {
						// 다음번에 녹이고 여기부터 시작할꺼니까 따로 담아두기
						visited[nr][nc]=1;
						outerIceLs.add(new RC(nr,nc));
					}
				}
			}
			
		}
		
	}
	
	static RC findParent(RC child) {
		int curr = child.r;
		int curc = child.c;
		
		if(uset[curr][curc][0] == curr && uset[curr][curc][1] == curc) {
			return child;
		} else {
			RC parent = findParent(new RC(uset[curr][curc][0],uset[curr][curc][1]));
			uset[curr][curc][0] = parent.r;
			uset[curr][curc][1] = parent.c;
			return parent;
		}
		
	}
	
	static void unionSet(RC left, RC right) {
		RC ParentLeft = findParent(left);
		RC ParentRight = findParent(right);
		// 같으면 사이클
		if(ParentLeft.equals(ParentRight)) {
//			return false;
		} else {
			uset[ParentRight.r][ParentRight.c][0] = ParentLeft.r;
			uset[ParentRight.r][ParentRight.c][1] = ParentLeft.c;
//			return true;
		}
	}
	
	static boolean inRange(int nr, int nc) {
		if(nr>=0 && nr < R && nc>=0 && nc < C) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
