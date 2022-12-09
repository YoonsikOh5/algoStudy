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

	static int N;

	static int result;

	static int[] poparr;
	
	static int[][] edgeM;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		poparr = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			poparr[i] = Integer.parseInt(st.nextToken());
		}
		
		edgeM = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int edgeC = Integer.parseInt(st.nextToken());
			
			for(int j = 1; j <= edgeC; j++) {
				int next = Integer.parseInt(st.nextToken());
				edgeM[i][next] = 1;
			}
		}
		
		result = Integer.MAX_VALUE; 
		
		for(int i = 1; i < 1<<N; i++) {
			boolean[] team1 = new boolean[N+1];
			boolean[] team2 = new boolean[N+1];
			for(int j = 1; j <= N; j++) {
				if((i & (1<<(j-1)))>0) {
					team1[j] = true;
				} else {
					team2[j] = true;
				}
			}
			bfs(team1,team2);
		}
		if(result==Integer.MAX_VALUE) {
			bw.write("-1");
		} else {
			bw.write(result+"");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs(boolean[] team1, boolean[] team2) {
		
		Queue<Integer> q = new LinkedList<>();
		
		int team1pop = 0;
		int team2pop = 0;
		
		
		for(int i = 1; i <= N; i++) {
			if(team1[i]==true) {
				team1pop += poparr[i];
				team1[i]=false;
				q.add(i);
				break;
			}
		}
		
		while(q.size()>0) {
			int cur = q.poll();
			for(int c= 1; c<=N; c++) {
				if(edgeM[cur][c]==1 && team1[c]==true) {
					team1pop += poparr[c];
					q.add(c);
					team1[c]=false;
				}
			}
		}

		for(int i = 1; i <= N; i++) {
			if(team2[i]==true) {
				team2pop += poparr[i];
				team2[i]=false;
				q.add(i);
				break;
			}
		}
		
		while(q.size()>0) {
			int cur = q.poll();
			for(int c= 1; c<=N; c++) {
				if(edgeM[cur][c]==1 && team2[c]==true) {
					team2pop += poparr[c];
					q.add(c);
					team2[c]=false;
				}
			}
		}
		
		boolean connected = true;
		for(int i = 1; i <= N; i++) {
			if(team1[i]==true) {
				connected=false;
				break;
			}
			if(team2[i]==true) {
				connected=false;
				break;
			}
		}
		if(connected) {
			int dif = Math.abs(team1pop-team2pop);
			result = Math.min(result, dif);
		}
		
	}

}