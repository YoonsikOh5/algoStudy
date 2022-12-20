import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1516번 게임 개발
public class Main {
	
	static int N;
	static int[] ownBuildTimes;
	static int[] minBuildTimes;
	static List<Integer>[] frontList;
	static List<Integer>[] backList;
	static int[] backCnt;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	ownBuildTimes = new int [N+1];
    	minBuildTimes = new int [N+1];
    	
    	backList = new List[N+1];
    	frontList = new List[N+1];
    	backCnt = new int[N+1];
    	
    	for(int i = 1; i <= N; i++) {
    		frontList[i] = new ArrayList<>();
    		backList[i] = new ArrayList<>();
    	}
    	
    	for(int i = 1; i <= N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		int time = Integer.parseInt(st.nextToken());
    		ownBuildTimes[i] = time;
    		
    		int bef = Integer.parseInt(st.nextToken());
    		while(bef!=-1) {
    			backList[i].add(bef);
    			backCnt[i]++;
    			frontList[bef].add(i);
    			bef = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	
    	topologySort();
    	
    	for(int i = 1; i <= N; i++) {
    		bw.write(minBuildTimes[i]+"\n");
    	}
    	bw.flush();
        bw.close();
        br.close();
    }
    
    static void topologySort() {
    	
    	Queue<Integer> q = new LinkedList<>();
    	for(int i = 1; i <= N; i++) {
    		if(backCnt[i]==0) {
    			q.offer(i);
    		}
    	}
    	
    	
    	while(q.size()>0) {
    		int cur = q.poll();
    		
    		// befMax 이전에 짓는 건물들중 가장 오래걸리는 시간
    		int befMax = 0;
    		for(int i = 0, size = backList[cur].size(); i < size; i++) {
    			befMax = Math.max(befMax, minBuildTimes[backList[cur].get(i)]);
    		}
    		minBuildTimes[cur] = befMax + ownBuildTimes[cur];
    		
    		
    		for(int i = 0, size = frontList[cur].size(); i < size; i++) {
    			if(--backCnt[frontList[cur].get(i)]==0) {
    				q.offer(frontList[cur].get(i));
    			}
    		}
    	}
    	
    	
    }
    

}
