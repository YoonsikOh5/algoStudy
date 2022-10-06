import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] edgeM;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		edgeM = new int[N+1][N+1];
		for(int[] arr : edgeM) {
			Arrays.fill(arr, Integer.MAX_VALUE);
		}
		for(int i = 0; i <= N; i++) {
			edgeM[i][i] = 0;
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			int node1 = Integer.parseInt(st.nextToken()); 
			int node2 = Integer.parseInt(st.nextToken()); 
			int dist = Integer.parseInt(st.nextToken());
			
			edgeM[node1][node2] = Math.min(edgeM[node1][node2],dist);
			
		}
		
		
		// 경유지
		for(int ch = 1; ch <= N; ch++) {
		// 출발지
			for(int sta = 1; sta <= N; sta++) {
		// 도착지
				for(int end = 1; end <= N; end++) {

					if(edgeM[sta][ch]!=Integer.MAX_VALUE && edgeM[ch][end]!=Integer.MAX_VALUE) {
						edgeM[sta][end] = Math.min(edgeM[sta][end], edgeM[sta][ch]+edgeM[ch][end]);						
					}
				}
			}
		}
		

		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++) {
				if(edgeM[r][c]==Integer.MAX_VALUE) {
					edgeM[r][c]=0;
				}
				bw.write(edgeM[r][c]+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}


}