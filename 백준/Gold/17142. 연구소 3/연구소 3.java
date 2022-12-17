import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] initBoard;
	// 바이러스 좌표 리스트
	static List<RC> virusLs;
	static int minResult;
	
	// 좌표값 담을 클래스
	static class RC {
		
		int r;
		int c;
		
		public RC(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	initBoard = new int[N][N];
    	virusLs = new ArrayList<>();
    	
    	for(int r = 0; r < N; r++) {
    		st = new StringTokenizer(br.readLine());
    		for (int c = 0; c < N; c++) {
    			int num = Integer.parseInt(st.nextToken());
    			initBoard[r][c] = num;
    			if(num == 2) {
    				virusLs.add(new RC(r,c));
    			}
			}
    	}
    	
    	minResult = Integer.MAX_VALUE;
    	combArr = new int[M];
    	// 조합
    	comb(0, 0);
    	
    	// 모두 바이러스 감염시키는 경우를 못찾아서 갱신이 안되는 경우
    	if(minResult == Integer.MAX_VALUE) {
    		bw.write("-1");
    	} else {
    		bw.write(minResult+"");
    	}
    	
    	bw.flush();
        bw.close();
        br.close();
    }
    
    static int[] combArr;
    
    static void comb(int cnt, int start) {
    	// 기저조건 M개 뽑으면 끝
    	if(cnt == M) {
    		// 매 combArr을 가지고 bfs해서 최소거리 구하기
    		bfs();
    		return;
    	}
    	
    	int virusCnt = virusLs.size();

    	for(int i = start; i < virusCnt; i++) {
    		combArr[cnt] = i;
    		comb(cnt+1,i+1);
    	}    	
    	
    }
    
    // 상하좌우
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static void bfs() {
    	// 이동 시간들을 담은 2차원 배열
    	// 기존 initBoard의 값은 안건드리고 steps에만 시간을 적어 visited의 역할도 같이 할 것
    	// visited의 역할을 하기위해 스텝을 1부터 시작하고 결과값에 1을 감소시킬것
    	// 0부터 시작하면 초기값 0과 구분이 안되어 visited의 역할을 못 함
    	int[][] steps = new int[N][N];
    	
    	Queue<RC> q = new LinkedList<>();
    	
    	for(int i = 0; i < M; i++) {
    		RC cur = virusLs.get(combArr[i]);
    		q.add(cur);
    		steps[cur.r][cur.c] = 1;
    	}
    	
    	while(q.size()>0) {

    		RC cur = q.poll();
    		
    		int curstep = steps[cur.r][cur.c];
    		
    		for(int d = 0; d < 4; d++) {
    			int nr = cur.r+dr[d];
    			int nc = cur.c+dc[d];
    		
    			// 연구소 범위 안에 있고 벽(1)이 아닌 경우
    			if(inRange(nr,nc) && initBoard[nr][nc] != 1) {
    				// 한번도 방문하지 않은 곳이면 curstep에 + 1 하고 큐에 추가
    				if(steps[nr][nc]==0) {
    					steps[nr][nc]=curstep+1;    						
    					q.add(new RC(nr,nc));
    				}
    			}
    		}
    		
    	}
    	
    	// 이번 조합에서 가장 오래걸리는 스텝을 확인
    	int maxStep = -1;
    	
    	for(int r = 0; r < N; r++) {
    		for(int c = 0; c < N; c++) {
    			// 바이러스(비활성)가 있는 칸이었다면 step을 1로 갱신
    			// 이걸 안해주면 maxStep계산할때 비활성 바이러스가 있는칸이 maxStep이 될 수도 있음
    			if(initBoard[r][c]==2) {
    				steps[r][c]=1;
    			}

    			// steps가 0인데 initBoard가 벽이 아닌경우 -> 감염이 안된 것
    			if(steps[r][c]==0 && initBoard[r][c]!=1) {
    				// 아무것도 안하고 끝내버리기
    				return;
    			}
    			maxStep = Math.max(maxStep, steps[r][c]);
    		}
    	}
    	
    	
    	// 1을 추가한채로 시작했으니 -1
    	minResult = Math.min(minResult, maxStep-1);
    	
    }
    
    static boolean inRange(int nr, int nc) {
    	if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
}
