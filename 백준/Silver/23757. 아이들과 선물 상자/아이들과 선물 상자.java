import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
    		
    	});
    	
    	st = new StringTokenizer(br.readLine());
    	
    	for(int i = 1; i <= N; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		pq.add(num);
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	boolean able = true;
    	for(int i = 1; i <= M; i++) {
    		int kid = Integer.parseInt(st.nextToken());
    		int curmax = pq.poll();
    		if(curmax<kid) {
    			able = false;
    			break;
    		} else {
    			int cur = curmax - kid;
    			pq.add(cur);
    		}
    	}
    	
    	if(able) {
    		bw.write(1+"");
    	} else {
    		bw.write(0+"");
    	}
        bw.flush();
        bw.close();
        br.close();
    }
}
