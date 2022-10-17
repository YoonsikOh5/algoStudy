import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int[][] sudoku;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sudoku = new int[10][10];
		
		for(int r = 1; r<=9; r++) {
			String str = br.readLine();
			for(int c = 1; c<=9; c++) {
				sudoku[r][c] = str.charAt(c-1)-'0';
			}
		}

		solveSudoku(1,1);
	
		
	}
	
	static boolean solveSudoku(int sr, int sc) throws IOException {
		if(sr==10) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for(int pr = 1; pr <= 9; pr++) {
				for(int pc = 1; pc <= 9; pc++) {
					bw.write(sudoku[pr][pc]+"");
				}
				bw.write("\n");
			}
			bw.flush();

			return true;
		}
		int nextr = -1;
		int nextc = -1;
		
		if(sc==9) {
			nextr=sr+1;
			nextc=1;
		} else {
			nextr=sr;
			nextc=sc+1;
		}
		
		if(sudoku[sr][sc]>0) {
			return solveSudoku(nextr,nextc);
		} else {
			boolean isOk = false;
			for(int input = 1; input <= 9; input++) {
				// 가능한 수라면
				if(isInputable(sr,sc,input)) {
					// 넣고 뒤에 진행하고
					// 진행한거 트루이면 끝 아니면 다음꺼
					sudoku[sr][sc]=input;
					if(solveSudoku(nextr,nextc)) {
						isOk = true;
						break;
					} else {
						sudoku[sr][sc]=0;
					}
				}
			}
			return isOk;
		}
		
	}
	
	static boolean isInputable(int sr, int sc, int input) {
		
		for(int cr = 1; cr <= 9; cr++) {
			if(sudoku[cr][sc]==input) {
				return false;
			}
		}
		for(int cc = 1; cc <= 9; cc++) {
			if(sudoku[sr][cc]==input) {
				return false;
			}
		}
		
		int gridr = (sr-1)/3;
		int gridc = (sc-1)/3;
		int gridstartr = gridr*3+1;
		int gridstartc = gridc*3+1;
		
		for(int gr = gridstartr; gr <= gridstartr+2; gr++) {
			for(int gc = gridstartc; gc <= gridstartc+2; gc++) {
				if(sudoku[gr][gc]==input) {
					return false;
				}
			}
		}
		
		return true;
	}

}