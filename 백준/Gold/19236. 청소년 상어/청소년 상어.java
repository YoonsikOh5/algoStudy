import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준 19236번 청소년 상어 라이브 코딩
public class Main {
	
	static Fish[][] board;
	
	// 위 부터 반시계로 8방향(1~8)
	static int[] dr = {0, -1,-1,0,1,1,1,0,-1};
	static int[] dc = {0, 0,-1,-1,-1,0,1,1,1};
	
	static int resultMax;
	
	static class Shark{
		int r;
		int c;
		
		int sumofFish;
		
		int direction;

		public Shark(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		void eatFish(Fish[][] board) {
			sumofFish += board[r][c].num;
			this.direction = board[r][c].direction;
			board[r][c] = null;
		}
		
	}
	
	static class Fish {
		int r;
		int c;
		
		int num;
		
		int direction;

		public Fish(int r, int c, int num, int direction) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.direction = direction;
		}
		
		

		@Override
		public String toString() {
			return "" + num;
		}



		void move(Shark shark, Fish[][] board){
			
			boolean moved = false;
			int movecnt = 0;
			
			while(!moved) {
				
				int direction = (this.direction+movecnt)%9;
				if(direction==0) {
					direction = 1;
				}
				int nr = this.r+dr[direction];
				int nc = this.c+dc[direction];
				
				int curr = this.r;
				int curc = this.c;
				
				if(inRange(nr,nc) && !(shark.r==nr && shark.c==nc)) {
					if(board[nr][nc]!=null) {						
						Fish temp = board[nr][nc];
						board[nr][nc] = board[curr][curc];
						board[curr][curc] = temp;

						board[curr][curc].r = curr;
						board[curr][curc].c = curc;
					
						board[nr][nc].r = nr;
						board[nr][nc].c = nc;
					
					} else if(board[nr][nc]==null) {
						board[nr][nc] = board[curr][curc];
						board[nr][nc].r = nr;
						board[nr][nc].c = nc;
						
						board[curr][curc] = null;
					}
					this.direction = direction;
					moved = true;
				} else {
					movecnt++;					
					if(movecnt==8) {
						return;
					}
				}
			}
			
		}
		
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	board = new Fish[4][4];
    	
    	for(int r = 0; r < 4; r++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int c = 0; c < 4; c++) {
    			int num = Integer.parseInt(st.nextToken());
    			int direction = Integer.parseInt(st.nextToken());
    			
    			board[r][c] = new Fish(r,c,num,direction);
    		}
    	}

    	Shark shark= new Shark(0,0);
    	
    	resultMax = Integer.MIN_VALUE;
    	
    	goShark(shark, board);
    	
    	bw.write(resultMax+"");
    	bw.flush();
        bw.close();
        br.close();
    }
    
    static void goShark(Shark shark, Fish[][] board) {
    	
    	PriorityQueue<Fish> q = new PriorityQueue<>(new Comparator<Fish>(){

			@Override
			public int compare(Fish o1, Fish o2) {
				return o1.num-o2.num;
			}
    		
    	});
    	
    	Fish[][] nextBoard = new Fish[4][4];
    	
    	for(int r = 0; r < 4; r++) {
    		for(int c = 0; c < 4; c++) {
    			if(board[r][c]!=null) {
    				Fish cur = board[r][c];
    				Fish newFish = new Fish(cur.r,cur.c,cur.num,cur.direction);
    				nextBoard[r][c] = newFish;
    			}
    		}
    	}
    	
    	// 이동한 위치에서 물고기 잡아먹기
    	shark.eatFish(nextBoard);

    	for(int r = 0; r < 4; r++) {
    		for(int c = 0; c < 4; c++) {
    			if(nextBoard[r][c]!=null) {
    				q.add(nextBoard[r][c]);
    			}
    		}
    	}
    	
    	while(q.size()>0) {
    		Fish curFish = q.poll();
    		curFish.move(shark,nextBoard);
    	}
    	
//    	for(Fish[] arr : nextBoard) {
//    		System.out.println(Arrays.toString(arr));
//    	}
    	
    	int moveCnt = 1;
    	
    	int snr = shark.r+dr[shark.direction]*moveCnt;
    	int snc = shark.c+dc[shark.direction]*moveCnt;
    	
    	
    	while(inRange(snr,snc)) {
    		
    		if(nextBoard[snr][snc]!=null) {
    			Shark nextShark = new Shark(snr,snc);
    			nextShark.sumofFish = shark.sumofFish;
    			goShark(nextShark, nextBoard);
    		}
    		moveCnt++;
    		snr = shark.r+dr[shark.direction]*moveCnt;
    		snc = shark.c+dc[shark.direction]*moveCnt;
    		
    	}
    	
    	resultMax = Math.max(resultMax, shark.sumofFish);
    	
    }
    
    static boolean inRange(int nr, int nc) {
    	if(nr>=0 && nr < 4 && nc >= 0 && nc < 4) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
}
