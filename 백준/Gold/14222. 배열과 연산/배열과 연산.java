import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 14222 배열과 연산
public class Main {

	static int N,K;
	static Queue<Integer> q;
	static boolean fulfilled[];
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	q = new LinkedList<>();
    	fulfilled = new boolean[N+1];
    	
    	st = new StringTokenizer(br.readLine());
    	
    	boolean able = true;
    	
    	for(int i = 0; i < N; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		if(num > N) {
    			able = false;
    			break;
    		}
    		if(fulfilled[num]==false) {
    			fulfilled[num] = true;
    		} else {
    			q.add(num);
    		}
    	}

    	if(able) {
    		able = isable();
    	}

    	if(able) {
    		bw.write("1");
    	} else {
    		bw.write("0");
    	}
    	
    	bw.flush();
        bw.close();
        br.close();
    }
    	
    static boolean isable() {
    	
    	while(q.size()>0) {
    		int cur = q.poll();
    		
    		int next = cur+K;
    		if(next>N) {
    			return false;
    		}
    		
    		if(fulfilled[next]==false) {
    			fulfilled[next] = true;
    		} else{
    			q.offer(next);
    		}
    	}
    	
    	return true;
    	
    }
 

}
