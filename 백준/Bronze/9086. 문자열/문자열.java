import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=T; i++) {
			String cur = br.readLine();
			
			char start = cur.charAt(0);
			char end = cur.charAt(cur.length()-1);
			
			bw.write(start+""+end+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}



}