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

	static int N,M;
	static int map[][];
	static List<Lineys> lineList;
	static int setarr[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 섬의 번호를 묶어줌
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c]==1) {
					bfs(r,c);					
				}
			}
		}
		
//		for(int[] arr : map) {
//			System.out.println(Arrays.toString(arr));		
//		}
		
		// 섬끼리 연결가능한 간선 있는지 확인 
		// 간선 리스트
		lineList = new ArrayList<>();
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c]!=0) {
					findline(r,c);					
				}
			}
		}
		
		lineList.sort(new Comparator<Lineys>(){

			@Override
			public int compare(Lineys o1, Lineys o2) {
				
				return o1.lenofbridge - o2.lenofbridge;
			}
			
		});
		
//		for(Lineys line : lineList) {
//			System.out.println(line.toString());
//		}
		
		setarr = new int[team];
		
		for(int i = 2; i < team; i++) {
			setarr[i] = i;
		}
		

		doKrusKal();
		
		
		bw.write(result+"");
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
	
	static class Lineys{
		int island1;
		int island2;
		int lenofbridge;
		
		public Lineys(int island1, int island2, int lenofbridge) {
			this.island1 = island1;
			this.island2 = island2;
			this.lenofbridge = lenofbridge;
		}

		@Override
		public String toString() {
			return "Lineys [island1=" + island1 + ", island2=" + island2 + ", lenofbridge=" + lenofbridge + "]";
		}
		
	}
	
	// 상하좌우
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,-1,1};
	
	static boolean inRange(int nr, int nc) {
		if(nr>=0 && nr < N && nc >= 0 && nc < M) {
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
	
	
	static void findline(int r, int c) {
		// 현재 섬과 다른 섬을 발견하면 이어주면됨
		int curteam = map[r][c];
		
		int len = 0;
		boolean haspossibility = false;
		boolean udlr[] = {true, true, true, true};
		do {
			haspossibility=false;
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d]*(len+1);
				int nc = c + dc[d]*(len+1);
				
				if(udlr[d] && inRange(nr,nc) && map[nr][nc] != curteam) {
					// 섬을 찾으면
					if(map[nr][nc] != 0) {
						if(len >= 2) {
							//System.out.println("r "+r+" c "+c+" curteam "+curteam+" nr "+nr+" nc "+nc+" team2 "+map[nr][nc]+" len "+len);
							lineList.add(new Lineys(curteam, map[nr][nc], len));							
							udlr[d] = false;
						} else {
							udlr[d] = false;
						}
					} 
				} else {
					udlr[d] = false;
				}
			}
			for(int i = 0; i < 4; i++) {
				if(udlr[i]==true) {
					haspossibility=true;
				}
			}
			len++;
		} while(haspossibility);
		
	}
	
	static int result=-1;
	
	static void doKrusKal() {
		
		// 크루스칼 하면 끝
		int selectedLine = 0;
		int sum = 0;
		
		for(int idx = 0, size = lineList.size(); idx < size; idx++) {	
			int island1 = lineList.get(idx).island1;
			int island2 = lineList.get(idx).island2;
			int lenofbridge = lineList.get(idx).lenofbridge;
			
			int rep1 = findset(island1);
			int rep2 = findset(island2);
			
			if(rep1!=rep2) {
				unionset(rep1,rep2);
				sum+=lenofbridge;
				selectedLine++;
			}
			if(selectedLine==(team-3)) {
				result = sum;
				break;
			}
		}
		
	}
	
	static int findset(int island) {
		if(setarr[island]!=island) {
			setarr[island] = findset(setarr[island]);
		} 
		
		return setarr[island];
		
	}
	
	static void unionset(int rep1, int rep2) {
		setarr[rep1] = setarr[rep2];
	}

}
