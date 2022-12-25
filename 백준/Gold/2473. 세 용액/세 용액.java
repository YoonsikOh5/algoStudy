import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 2473 세용액
public class Main {

	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long arr[] = new long[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		int j = n-1;
		long min_result = Long.MAX_VALUE;
		long minleft = 0;
		long minright = 0;
		long minthird = 0;
		boolean findzero = false;
		for(int m = 0; m < n; m++) {
			
		j = n-1;
			
		for(int i = 0; i < j;) {
			if(i==m) {
				i++;
				continue;
			} else if(j==m) {
				j--;
				continue;
			}
			
			long left = arr[i];
			long right = arr[j];
			long third = arr[m];
			
			
			long sum = left+right+third;
			if(min_result > Math.abs(sum)) {
				minleft = arr[i];
				minright = arr[j];
				minthird = arr[m];
				min_result = Math.abs(sum);
			}
			
			if(sum < 0) {
				i++;
			} else if(sum > 0){
				j--;
			} else if(sum == 0) {
				findzero = true;
				break;
			}
			
		}
		
		if(findzero) {
			break;
		}

		}
		
		if(minleft>=minthird) {
			bw.write(minthird+" "+minleft+" "+minright);
		} else if(minright<=minthird) {
			bw.write(minleft+" "+minright+" "+minthird);
		} else {
			bw.write(minleft+" "+minthird+" "+minright);			
		}
    	
    	bw.flush();
        bw.close();
        br.close();
    }
    	
 

}
