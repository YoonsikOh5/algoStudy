import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, x, y, K;
	static int[][] board;

	// 동1 서2 북3 남4
	static int[] dr = {0,0,0,-1,1};
	static int[] dc = {0,1,-1,0,0};
	
	static class Dice{
		
		int[] dicearr;
		
		int curr;
		int curc;
		
		int curtop = 1;
		// 동 서 북 남 1,2,3,4순으로 사이드 현황
		int curside[] = {0,3,4,2,5};
		int curbot = 6;

		public Dice(int curr, int curc) {
			this.dicearr = new int[7];
			this.curr = curr;
			this.curc = curc;
		}
		
		public void doroll(int cmd,int nr, int nc){
			// 공통적으로 하는 것
			if(board[nr][nc]==0) {
				board[nr][nc]=dicearr[curside[cmd]];
			} else {
				dicearr[curside[cmd]]=board[nr][nc];
				board[nr][nc]=0;
			}
			// 일단 저장시켜두고
			int beftop = curtop;
			int befside[] = new int[5];
			for(int i = 1; i <=4 ; i++) {
				befside[i] = curside[i];
			}
			int befbot = curbot;
			
			// 동쪽으로 굴릴 때
			if(cmd == 1) {
				// 이동한 주사위 상태 변화시켜주기
				curtop = befside[2];
				curbot = befside[1];
				curside[1] = beftop;
				curside[2] = befbot;
				curside[3] = befside[3];
				curside[4] = befside[4];
			} else if(cmd==2) {
				//서쪽으로 굴리기
				curtop = befside[1];
				curbot = befside[2];
				curside[1] = befbot;
				curside[2] = beftop;
				curside[3] = befside[3];
				curside[4] = befside[4];
			} else if(cmd==3) {
				//북쪽으로 굴리기
				curtop = befside[4];
				curbot = befside[3];
				curside[1] = befside[1];
				curside[2] = befside[2];
				curside[3] = beftop;
				curside[4] = befbot;
			} else if(cmd==4) {
				//남쪽으로 굴리기
				curtop = befside[3];
				curbot = befside[4];
				curside[1] = befside[1];
				curside[2] = befside[2];
				curside[3] = befbot;
				curside[4] = beftop;
			}
			this.curr=nr;
			this.curc=nc;
		}
		
	}
	
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		Dice dice = new Dice(x,y);
		for(int i = 1; i <= K; i++) {
			int cmd = Integer.parseInt(st.nextToken());
			
			int nr = dice.curr+dr[cmd];
			int nc = dice.curc+dc[cmd];
			
			if(!(nr>=0 && nr < N && nc >=0 && nc < M)) {
				continue;
			}
			
			dice.doroll(cmd,nr,nc);
			
			bw.write(dice.dicearr[dice.curtop]+"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}