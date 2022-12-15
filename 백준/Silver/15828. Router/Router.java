import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	Queue<Integer> q = new LinkedList<>();
    	
    	int next = Integer.parseInt(br.readLine());
    	
    	while(next!=-1) {
    		if(next==0) {
    			q.poll();
    			next = Integer.parseInt(br.readLine());
    			continue;
    		}
    		if(q.size()<N){
    			q.add(next);
    		}    		
    		
    		next = Integer.parseInt(br.readLine());
    	}
    	
    	if(q.size()==0) {
    		bw.write("empty");
    	} else {
    		while(q.size()>0) {
    			bw.write(q.poll()+" ");
    		}
    	}
    	
        bw.flush();
        bw.close();
        br.close();
    }
}
