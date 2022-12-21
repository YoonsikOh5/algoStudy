import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 백준 16954번 움직이는 미로 탈출
public class Main {

	static int[][] board;
	
	// 가운데, 위부터 시계방향
	static int[] dr = {0,-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,0,1,1,1,0,-1,-1,-1};
	
	static class Wookjae {
		
		int r;
		int c;
		
		public Wookjae(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		boolean move(int direction) {
			this.r = this.r + dr[direction];
			this.c = this.c + dc[direction];
			
			if(this.r >= 0 && this.r < 8 && this.c >= 0 && this.c < 8) {
				return true;
			} else {
				return false;
			}
		}
		
	}

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    	board = new int[8][8];
    	
    	for(int r = 0; r < 8; r++) {
    		String str = br.readLine();
    		for(int c = 0; c < 8; c++) {
    			if(str.charAt(c)=='.') {
    				board[r][c] = 0;
    			} else if(str.charAt(c)=='#') {
    				board[r][c] = 1;
    			}
    		}
    	}
    	
    	// 욱제는 왼쪽 아래에서 시작
    	Wookjae wj = new Wookjae(7,0);
    	isPossible = false;
    	moveWall(wj,0);
    	if(isPossible) {
    		bw.write("1");
    	} else {
    		bw.write("0");
    	}
    	
    	bw.flush();
        bw.close();
        br.close();
    }
    
    static boolean isPossible;
    
    static void moveWall(Wookjae wj, int time) {
    	// 기저조건 벽이 욱제랑 만나면 return;
    	// time만큼 욱제의 r을 -1 시켜서 벽이 이동하는 것 처럼 만들 것
    	// wj.r-time이 0보다 작다는 것은 벽을 안만난 다는 뜻
    	if((wj.r-time)>=0 && board[wj.r-time][wj.c]==1) {
    		return;
    	}
    	
    	// 8초가 되었는데 벽이 욱제랑 만나지 않았다면 true로 바꾸고 return;
    	if(time == 8) {
    		isPossible = true;
    		return;
    	}
    	
    	// true인게 하나라도 나오면 전부 리턴
    	if(isPossible) {
    		return;
    	}
    	
    	
    	// 유도파트
    	for(int i = 0; i <= 8; i++) {
    		Wookjae nextWookjae = new Wookjae(wj.r,wj.c);
    		
    		// 넥스트 욱제가 inRange라면
    		if(nextWookjae.move(i)) {
    			// 벽으로 이동하려하면 continue
    			if((nextWookjae.r-time)>=0 && board[nextWookjae.r-time][nextWookjae.c]==1) {
    				continue;
    			}
    			moveWall(nextWookjae, time+1);
    		}
    	}
    	
    	
    }

}
