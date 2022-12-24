import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 20005 보스몬스터 전리품
public class Main {

	static int M, N, P;
	static char[][] worldMap;
	static int[][] steps;
	static Boss boss;
	static Player[] players;
	static HashMap<Integer,List<Integer>> hm;
	
	static class Boss {
		
		int r;
		int c;
		int HP;
		
		public Boss(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public int getHP() {
			return HP;
		}

		public void setHP(int hP) {
			HP = hP;
		}
		
		
	}
	
	static class Player{
		
		char name;
		
		int r;
		int c;
		
		int distWithBoss;
		
		int dps;

		public Player(char name, int r, int c) {
			this.name = name;
			this.r = r;
			this.c = c;
		}

		public int getDps() {
			return dps;
		}

		public void setDps(int dps) {
			this.dps = dps;
		}

		public int getDistWithBoss() {
			return distWithBoss;
		}

		public void setDistWithBoss(int distWithBoss) {
			this.distWithBoss = distWithBoss;
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
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	P = Integer.parseInt(st.nextToken());
    	
    	worldMap = new char[M][N];
    	steps = new int[M][N];
    	players = new Player[27];
    	hm = new HashMap<Integer,List<Integer>>();
    	
    	for(int r = 0; r < M; r++) {
    		String str = br.readLine();
    		for(int c = 0; c < N; c++) {
    			char cur = str.charAt(c);
    			worldMap[r][c	] = cur;
    			if(cur == 'B') {
    				boss = new Boss(r,c);
    			} else if(cur != '.' && cur != 'X') {
    				players[cur-'a'] = new Player(cur,r,c);
    			}
    		}
    	}
    	
    	for(int i = 0; i < P; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		String name = st.nextToken();
    		
    		players[name.charAt(0)-'a'].setDps(Integer.parseInt(st.nextToken()));
    	}
    	
    	boss.setHP(Integer.parseInt(br.readLine()));
    	
    	
    	bossbfs();
    	
    	int resultPlayerCnt = 0;
    	int dpssum = 0;
    	int time = 1;
    	
    	while(boss.getHP()>0) {
    		
    		if(hm.containsKey(time)) {
    			List<Integer> curls = hm.get(time);
    			int size = curls.size();
   				resultPlayerCnt += size;
   				for(int i = 0; i < size; i++) {
   					dpssum += curls.get(i);
   				}
    		}
    		
    		boss.setHP(boss.getHP()-dpssum);
    		time++;
    	}
    	
    	bw.write(resultPlayerCnt+"");
    	bw.flush();
        bw.close();
        br.close();
    }
    	
    // 상하좌우
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    
    static void bossbfs() {
    	
    	Queue<RC> q = new LinkedList<RC>();
    	RC bossrc = new RC(boss.r,boss.c);
    	q.offer(bossrc);
    	// 일단은 1로 시작하고 밑에서 스텝 계산할때는 다 -1 시켜줄 것
    	// 0으로 시작하면 boss처음 위치가 방문 했는지 판단할때 조금 꼬임
    	steps[boss.r][boss.c] = 1;
    	
    	int playerCnt = 0;
    	
    	while(q.size()>0 && playerCnt<P) {
    		RC cur = q.poll();
    		
    		int curr = cur.r;
    		int curc = cur.c;
    		
    		int curstep = steps[curr][curc];
    		
    		for(int d = 0; d < 4; d++) {
    			int nr = curr + dr[d];
    			int nc = curc + dc[d];
    			
    			// steps가 0인지 아닌지로 visited까지 판단
    			if(inRange(nr,nc) && worldMap[nr][nc]!='X' && steps[nr][nc]==0) {
    				steps[nr][nc] = curstep+1;
    				if(worldMap[nr][nc]!='B' && worldMap[nr][nc]!='.') {
    					char curPlayer = worldMap[nr][nc];
    					players[curPlayer-'a'].distWithBoss = steps[nr][nc]-1;
    					if(hm.containsKey(steps[nr][nc]-1)) {
    						hm.get(steps[nr][nc]-1).add(players[curPlayer-'a'].dps);
    					} else {
    						List<Integer> dpsls = new ArrayList<>();
    						dpsls.add(players[curPlayer-'a'].dps);
    						hm.put(steps[nr][nc]-1, dpsls);
    					}
    					
    					playerCnt++;
    				}
    				q.offer(new RC(nr,nc));
    			}
    		}
    		
    	}
    	
    }
    
    static boolean inRange(int nr, int nc) {
    	if(nr >= 0 && nr < M && nc >= 0 && nc < N) {
    		return true;
    	} else {
    		return false;
    	}
    }

}
