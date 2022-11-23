import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0, size = str.length(); i< size; i++) {
			char cur = str.charAt(i);
			int curi = cur-'0';
			if(curi>=49 && curi <= 74) {
				char next = (char) (cur-'a'+'A');
				sb.append(next);
			} else if(curi>=17 && curi <=42) {
				char next = (char) (cur-'A'+'a');
				sb.append(next);
			}					
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
