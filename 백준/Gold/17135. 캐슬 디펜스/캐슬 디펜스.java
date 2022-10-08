import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, D;
	static int map[][];
	static boolean visited[][];
	static boolean enemydown[][];
	static int enemyCnt;
	static int result_max = Integer.MIN_VALUE;
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 세로
		N = Integer.parseInt(st.nextToken());
		// 가로
		M = Integer.parseInt(st.nextToken());
		// 공격범위
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		enemyCnt = 0;
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==1) {
					enemyCnt++;
				}
			}
		}
		
		// 궁수의 위치를 MC3 조합으로 브루트포스
		comb(0, 0);
		
		// 궁수의 위치가 정해지면 시뮬레이션 돌려줘야됨
		
		bw.write(result_max+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int archerspot[] = new int [3];
	
	public static void comb(int depth, int start) {
		
		// 기저조건 3군데 다 정하면 시뮬
		if(depth == 3) {
			simulation();
			return;
		}
		
		// 유도파트 3군데 정하기
		for(int i = start; i < M; i++) {
			archerspot[depth] = i;
			comb(depth+1, i+1);
		}
		
	}
	
	
	//
	static List<RC> rounddownenemy;
	
	public static void simulation() {
		// archerspot은 결정 됐고
		// 적 잡았는지 안잡았는지는 enemydown로 처리
		// 적의 이동은 궁수가 쏘는 위치를 조정
		enemydown = new boolean[N][M];
		int curRound = 1;
		int allEnemyDown = 0;
		int shotDown = 0;
		while(allEnemyDown != enemyCnt) {
			rounddownenemy = new ArrayList<>();
			shot(curRound, archerspot[0]);
			shot(curRound, archerspot[1]);
			shot(curRound, archerspot[2]);
			// 여기서 enemydown true 처리
			for(int i = 0, size=rounddownenemy.size(); i < size; i++) {
				RC currc = rounddownenemy.get(i);
				int curr = currc.r;
				int curc = currc.c;
				if(enemydown[curr][curc]==false) {
					enemydown[curr][curc]=true;
					allEnemyDown++;
					shotDown++;				
				}
			}
			
			for(int c = 0; c < M; c++) {
				if(map[N-curRound][c]==1 && enemydown[N-curRound][c]==false) {
					enemydown[N-curRound][c] = true;
					allEnemyDown++;
				}
				
			}
			curRound++;
		}
		
		result_max = Math.max(result_max, shotDown);
		
	}
	
	// 왼쪽 위 오른쪽
	static int dr[] = {0, -1, 0};
	static int dc[] = {-1, 0, 1};


	
	public static void shot(int curRound, int aspot) {
		// 궁수의 현재 위치 바로 위칸을 시작점으로
		// 왼쪽 위 오른쪽을 탐색하는 bfs를 시행
		visited = new boolean[N][M];
		// 시작 궁수의 위치 r +1
		int curar = N-curRound;
		
		Queue<RC> q = new LinkedList<>();
		q.add(new RC(curar, aspot));
		RC rangecounter = new RC(-1, -1);
		q.add(rangecounter);
		int range = 1;
		visited[curar][aspot] = true;
		
		if(map[curar][aspot]==1 && enemydown[curar][aspot]==false) {
			rounddownenemy.add(new RC(curar,aspot));
			return;
		} 
		if(D==1) {
			return;
		}
		
		while(q.size()>0) {
			RC cur = q.poll();
			int curr = cur.r;
			int curc = cur.c;
			
			if(curr==-1 && curc==-1) {
				range++;
				if(range>=D) {
					return;
				}
				q.add(rangecounter);
				continue;
			}
			
			
			for(int d = 0; d < 3; d++) {
				int nr = curr+dr[d];
				int nc = curc+dc[d];
				
				if(nr>=0 && nr < N && nc >=0 && nc < M && visited[nr][nc]==false) {
					visited[nr][nc] = true;
					// 아직 안죽은 적 발견하면 쏘고 나가기
					if(map[nr][nc]==1 && enemydown[nr][nc]==false) {
						rounddownenemy.add(new RC(nr,nc));
						return;
					} else {
						q.add(new RC(nr,nc));
					}
				}
			}
		}
		
	}

	
	static class RC { 
		int r;
		int c;
		
		public RC(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		
	}
	
}