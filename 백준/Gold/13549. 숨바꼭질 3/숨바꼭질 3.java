import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	int result = bfs();
    	
    	bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
    
    static int bfs() {
    	Queue<Integer> q = new LinkedList<>();
    	boolean visited[] = new boolean[200001];
    	if(N==K) {
    		return 0;
    	}
    	
    	q.add(N);
    	visited[N]=true;
    	
    	q.add(-1);
    	int counter = 0;
    	
    	while(q.size()>0) {
    		int cur = q.poll();
    		
    		if(cur==-1) {
    			counter++;
    			if(q.size()>0) {
    				q.add(-1);
    			}
    			continue;
    		}
    		
    		int mulcur = cur*2;
    		while(mulcur <= 200000) {
    			if(mulcur==K) {
    				return counter;
    			}
    			if(mulcur==0) {
    				break;
    			}
    			if(visited[mulcur]==false) {
    				visited[mulcur] = true;
    			}
    			mulcur *= 2;
    		}
    		
    		int curplusone = cur+1;
    		int curminusone = cur-1;
    		
    		if(inRange(curplusone)) {
    			if(curplusone==K) {
    				return counter+1;
    			}
    			if(visited[curplusone]==false) {
    				q.add(curplusone);
    				visited[curplusone] = true;
    			}
    		}
    		if(inRange(curminusone)) {
    			if(curminusone==K) {
    				return counter+1;
    			}
    			if(visited[curminusone]==false) {
    				q.add(curminusone);
    				visited[curminusone] = true;
    			}
    		}
    		
    		cur *= 2;
    		
    		while(cur <= 200000) {
    			if(cur==0) {
    				break;
    			}
    			
    			curplusone = cur+1;
        		curminusone = cur-1;
        		
        		if(inRange(curplusone)) {
        			if(curplusone==K) {
        				return counter+1;
        			}
        			if(visited[curplusone]==false) {
        				q.add(curplusone);
        				visited[curplusone] = true;
        			}
        		}
        		if(inRange(curminusone)) {
        			if(curminusone==K) {
        				return counter+1;
        			}
        			if(visited[curminusone]==false) {
        				q.add(curminusone);
        				visited[curminusone] = true;
        			}
        		}
    		
        		cur *= 2;
    		}
    	
    	}
    	
    	return 0;
    }
    
    static boolean inRange(int num) {
    	if(num>=0 && num <=200000) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    
}
