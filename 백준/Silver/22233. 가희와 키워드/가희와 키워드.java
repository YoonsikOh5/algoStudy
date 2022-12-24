import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

// 백준 22233 가희와 키워드
public class Main {

	static int N, M;
	static HashMap<String, Integer> hm;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());

    	hm = new HashMap<>();
    	
    	for(int i = 0; i < N; i++) {
    		String str = br.readLine();
    		hm.put(str, 1);
    	}
    	
    	int result = N;
    	
    	for(int i = 0; i < M; i++) {
    		String str = br.readLine();
    		String[] strarr = str.split(",");
    		
    		for(int j = 0, size = strarr.length; j < size; j++) {
    			String cur = strarr[j];
    			if(hm.containsKey(cur) && hm.get(cur)==1) {
    				result--;
    				hm.replace(cur, 0);
    			}
    		}
    		
    		bw.write(result+"\n");
    	}
    	
    	bw.flush();
        bw.close();
        br.close();
    }
    	

}
