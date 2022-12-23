import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 16398 행성 연결
public class Main {
	
	static int N;
	// 인접 배열
	static int[][] adjMatrix;
	static int[] dist;	
	static boolean[] visited;
	static long resultSum;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    	N = Integer.parseInt(br.readLine());
    	adjMatrix = new int[N][N];
    	dist = new int[N];
    	visited = new boolean[N];
    	
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	
    	for(int r = 0; r < N; r++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int c = 0; c < N; c++) {
    			adjMatrix[r][c] = Integer.parseInt(st.nextToken());
    		}
    	}
    	resultSum = 0;
    	prim();
    	
    	
    	bw.write(resultSum+"");
    	bw.flush();
        bw.close();
        br.close();
    }
    	
    static void prim() {
    	
    	dist[0] = 0;
    	int minidx = -1;
    	int mindist = Integer.MAX_VALUE;
    	for(int i = 1; i < N; i++) {
    		dist[i] = Math.min(dist[i],adjMatrix[0][i]);
    		if(mindist > dist[i]) {
    			mindist = dist[i];
    			minidx = i;
    		}
    	}
    	visited[0]=true;
    	
    	int visitedCnt = 1;
    	
    	while(visitedCnt < N) {
    		
    		visited[minidx]=true;
    		int nextidx = minidx;
    		mindist = Integer.MAX_VALUE;
    		for(int i = 0; i < N; i++) {
    			if(i==nextidx) {
    				continue;
    			}
    			if(visited[i]) {
    				continue;
    			}
    			dist[i] = Math.min(dist[i],adjMatrix[nextidx][i]);
    			if(mindist > dist[i]) {
    				mindist = dist[i];
    				minidx = i;
    			}
    		}
    		visitedCnt++;
    	}
    	
    	for(int i = 0; i < N; i++) {
    		resultSum += dist[i];
    	}
    	
    }
 

}
