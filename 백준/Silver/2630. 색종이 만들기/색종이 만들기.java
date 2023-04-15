import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] papermatrix = new int[n][n];
		
		for(int r = 0; r < n; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c < n; c++) {
				papermatrix[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		paperzip(papermatrix, n);
		
		System.out.println(resultwhite);
		System.out.println(resultblue);

	}
	
	static int resultwhite = 0;
	static int resultblue = 0;
	
	public static void paperzip(int[][] papermatrix, int n) {
		
		if(n==1) {
			if(papermatrix[0][0]==0) {
				resultwhite++;
			}else if(papermatrix[0][0]==1) {
				resultblue++;
			}
			return;
		}
		
		int ndiv2 = n/2;
		int[][] zippedpaper = new int[ndiv2][ndiv2];
	
		//왼쪽위 기준 네 곳 탐색
		int[] dr = {0, 0, 1, 1};
		int[] dc = {0, 1, 0, 1};
		
		for(int r = 0; r < n; r+=2) {
			for(int c = 0; c < n; c+=2) {
				int flagnum = 0;
				for(int d = 0; d < 4; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					flagnum += papermatrix[nr][nc]; 
				}
				int zr = r/2;
				int zc = c/2;
				// 모두 1이라면
				if(flagnum == 4) {
					zippedpaper[zr][zc] = 1;
				} else if(flagnum == 0){
				// 모두 0이라면
					zippedpaper[zr][zc] = 0; 
				} else {
				// 모두 1이나 모두 0이 아니라면 바로 색종이 카운트 올려버리기
					zippedpaper[zr][zc] = 10;
					for(int d = 0; d < 4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if(papermatrix[nr][nc]==0) {
							resultwhite++;
						}else if(papermatrix[nr][nc]==1) {
							resultblue++;
						}
					}
				}
			}			
		}
		
		// 재귀
		paperzip(zippedpaper, ndiv2);
		
		
	}

}