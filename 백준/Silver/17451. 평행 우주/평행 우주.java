import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 17451 평행 우주
public class Main {

	static int n;
	static int[] arr;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   
    	n = Integer.parseInt(br.readLine());
    	arr = new int[n];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for(int i = 0; i < n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	long speedMin = 0;
    	
    	// 뒤에서부터 앞으로 가면서
    	// 현재 speedMin보다 행성의 필요속도가 높다면 speedMin을 그 행성의 필요속도로 맞춰줌
    	// 반대로 speedMin이 더 높다면 행성의 필요속도의 배수중 speedMin을 넘기는 가장 최소의 값으로 맞춰줌
    	for(int i = n-1; i >=0; i--) {
    		if(speedMin <= arr[i]) {
    			speedMin = arr[i];
    		} else if(speedMin > arr[i]) {
    			long div = (speedMin / arr[i]);
    			if(speedMin%arr[i]!=0) {
    				div++;
    			}
    			speedMin = arr[i] * div;
    		}
    	}
    	
    	bw.write(speedMin+"");
    	bw.flush();
        bw.close();
        br.close();
    }
    	
 

}
