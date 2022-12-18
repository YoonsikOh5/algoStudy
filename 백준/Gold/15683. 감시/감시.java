import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백준 15683번 감시 라이브 코딩
public class Main {

	static int N, M;
	static int[][] board;
	static List<CCTV> cctvLs;
	static boolean[][] watched;
	
	static int resultMin;
	
	// 중복순열 결과 담을 배열
	static int[] permArr;
	
	// 4방탐색 상우하좌 (1,2,3,4)
	static int[] dr = {0,-1,0,1,0};
	static int[] dc = {0,0,1,0,-1};
	
	static class CCTV {
		
		int r;
		int c;
		
		// 1~5
		int type;	
		
		// 생성자
		public CCTV(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
		
		// 감시하는 영역 반환 메소드
		public void watchArea(int direction) {
			if(type == 1) {
				
				watchAreaModule(this.r, this.c, direction);
				
			} else if(type == 2) {
				for(int d = 1; d <=4; d++) {
					
					if((direction % 2)!=(d % 2)) {
						continue;
					}
					watchAreaModule(this.r, this.c, d);
							
				}
			} else if(type == 3) {
				
				watchAreaModule(this.r, this.c, direction);
				
				int next = (direction+1) % 5;
				if(next == 0) {
					next = 1;
				}
				
				watchAreaModule(this.r, this.c, next);
				
			} else if(type == 4) {
				
				for(int d = 1; d <=4; d++) {
					
					if(d==direction) {
						continue;
					}
					
					watchAreaModule(this.r, this.c, d);
			
				}
				
			} else if(type == 5) {
				
				for(int d = 1; d <=4; d++) {
									
					watchAreaModule(this.r, this.c, d);
				
				}
			
				
			}
			
		}
		
		
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	board = new int[N][M];
    	
    	cctvLs = new ArrayList<CCTV>();
    	
    	for(int r = 0; r < N; r++) {
    		st = new StringTokenizer(br.readLine());
    		for(int c = 0; c < M; c++) {
    			int num = Integer.parseInt(st.nextToken());
    			board[r][c] = num;
    			if(num >= 1 && num <= 5) {
    				cctvLs.add(new CCTV(r,c,num));    				
    			}
    		}
    	}
    	
    	permArr = new int[cctvLs.size()];
    	
    	resultMin = Integer.MAX_VALUE;
    	
    	// 중복순열
    	repPerm(0);
    	
    	bw.write(resultMin+"");
    	bw.flush();
        bw.close();
        br.close();
    }
    
    static int cnt;
    
    static void repPerm(int index) {
    	// 기저조건
    	if(index == cctvLs.size()) {
    		// cctv 사각지대 확인하고 리턴
    		blindSpot();
    		
    		return;
    	}
    	
    	
    	for(int i = 1; i <= 4; i++) {
    		permArr[index] = i;
    		
    		repPerm(index+1);

    		if(cctvLs.get(index).type==2) {
    			if(i==2){
    				return;    				
    			}
    		}

    		if(cctvLs.get(index).type==5) {
    			return;
    		}
    		
    		if(resultMin == 0) {
    			return;
    		}
    	}
    	
    }
    
    static void blindSpot() {
    	
    	watched = new boolean[N][M];
    	
    	for(int i = 0, size = cctvLs.size(); i < size; i++) {
    		cctvLs.get(i).watchArea(permArr[i]);
    	}
    	
    	int blindSpotCnt = 0;
    	
    	for(int r = 0; r < N; r++) {
    		for(int c = 0; c < M; c++) {
    			if(watched[r][c]==false && board[r][c]==0) {
    				blindSpotCnt++;
    			}
    		}
    	}
    	
    	resultMin = Math.min(resultMin, blindSpotCnt);
    	
    	
    }
    
    static boolean inRange(int nr, int nc) {
    	if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    static void watchAreaModule(int r, int c, int direction){
    	int dist = 0;
		 
		 int nr = r + dr[direction]*dist;
		 int nc = c + dc[direction]*dist;
		 
		 boolean meetWall = false;
		 
		 while(inRange(nr,nc) && !meetWall) {
			 
			 watched[nr][nc] = true;
			 
			 if(board[nr][nc]==6) {
				 meetWall = true;
			 }
			 
			 dist++;
			 nr = r + dr[direction]*dist;
			 nc = c + dc[direction]*dist;
			 
		 }
    }
    
}
