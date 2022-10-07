import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int cbsmatrix[][];
	static final int INT_MAX = Integer.MAX_VALUE;
	
	// {Clipboard, S}
	static class CbS{
		int clipboard;
		int s;
		
		public CbS(int clipboard, int s) {
			super();
			this.clipboard = clipboard;
			this.s = s;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		cbsmatrix = new int[1001][1001];
		for(int arr[] : cbsmatrix) {
			Arrays.fill(arr, INT_MAX);
		}
		bfs();
		
		int min_result = Integer.MAX_VALUE;
		
		for(int r = 1; r <= 1000; r++) {
			min_result = Math.min(min_result, cbsmatrix[r][n]);
		}
		
		
		bw.write(min_result+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs() {
		
		Queue<CbS> q = new LinkedList<>();
		// 처음에는 무조건 카피하고 1
		// (클립보드 1, 현재화면 1)
		q.add(new CbS(1,1));
		
		cbsmatrix[1][1] = 0;
		int cnt = 2;
		CbS tcounter = new CbS(-1,-1); 
		q.add(tcounter);
		while(q.size()>0) {
			CbS cur = q.poll();
			int curCb = cur.clipboard;
			int curS = cur.s;
			if(curCb==-1 && curS==-1) {
				cnt++;
				if(q.size()==0) {
					break;
				} else {
					q.add(tcounter);					
				}
				continue;
			}
			
			// 카피하는 경우
			if(cnt < cbsmatrix[curS][curS]) {
				cbsmatrix[curS][curS] = cnt;
				q.add(new CbS(curS, curS));
			}
			
			// 페이스트하는 경우
			if(curCb+curS < 1001 && cnt < cbsmatrix[curCb][curCb+curS]) {
				cbsmatrix[curCb][curCb+curS] = cnt;
				q.add(new CbS(curCb, curS+curCb));
			}
			
			// 마이너스 1 하는 경우
			if(curS-1>=0 && cnt < cbsmatrix[curCb][curS-1]) {
				cbsmatrix[curCb][curS-1] = cnt;
				q.add(new CbS(curCb, curS-1));
			}
			
		}
		
		
		
		
	}
	
	
}