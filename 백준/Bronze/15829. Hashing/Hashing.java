import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int L = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		long sum = 0;
		for(int i = 0; i < L; i++) {
			int num = str.charAt(i)-'a';
			
			sum = (sum + (num+1)*(pow31(i)))%1234567891;
			
		}
		
		bw.write(sum%1234567891+"");
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static long pow31(int num) {
		if(num==0) {
			return 1;
		}
		
		return (pow31(num-1)*31)%1234567891;
	}
	


}