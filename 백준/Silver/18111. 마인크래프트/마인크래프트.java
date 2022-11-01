import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,B;

	static int[][] ground;
	
	static int smin,smax;
	
	static class Result implements Comparable<Result>{
		int time;
		int height;
		
		public Result(int time, int height) {
			super();
			this.time = time;
			this.height = height;
		}

		@Override
		public int compareTo(Result o) {
			if(this.time==o.time) {
				return o.height-this.height;
			}
			return this.time-o.time;
		}
	
	}
	
	static PriorityQueue<Result> pq;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());		
		M = Integer.parseInt(st.nextToken());		
		B = Integer.parseInt(st.nextToken());		
		
		ground = new int[N][M];
		
		smin = Integer.MAX_VALUE;
		smax = Integer.MIN_VALUE;
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				ground[r][c] = Integer.parseInt(st.nextToken());
				smin = Math.min(smin, ground[r][c]);
				smax = Math.max(smax, ground[r][c]);
			}
		}
		
		pq = new PriorityQueue<>();
		
		// 기존 땅의 최저보다 낮거나 최고보다 높게 깔 일은 없으니까
		// 땅의높이가 i일때의 비용
        if(smax >= 256){
            smax = 256;
        }
		for(int i = smin; i <= smax; i++) {
			int under = 0;
			int over = 0;
			int time = Integer.MAX_VALUE;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					int dif = ground[r][c]-i;
					if(dif > 0) {
						over += dif;
					} else if(dif < 0) {
						under += dif;
					} 
				}
			}
			// 제거하여 인벤토리에 넣은것 over 와 기존 인벤토리가 메꿀땅 이상 있다면
			if(over+B>=(-under)) {
				time = (over)*2 - under;
			}
			pq.add(new Result(time, i));
		}
		Result rs = pq.poll();
		bw.write(rs.time+" "+rs.height);
		bw.flush();
		bw.close();
		br.close();
		
	}

}
