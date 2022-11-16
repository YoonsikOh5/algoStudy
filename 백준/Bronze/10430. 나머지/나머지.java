import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int result1 = (A+B)%C;
		int result2 = ((A%C)+(B%C))%C;
		int result3 = (A*B)%C;
		int result4 = ((A%C)*(B%C))%C;
		
		bw.write(result1+"\n");
		bw.write(result2+"\n");
		bw.write(result3+"\n");
		bw.write(result4+"\n");
		bw.flush();
		bw.close();
		br.close();
	}


}
