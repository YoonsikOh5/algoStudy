import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
	
	
	
	public class Main {
	
		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			
			HashMap<String,Integer> hm = new HashMap<>();
			
			for(int i = 0; i < n; i++) {
				char[] cur = br.readLine().toCharArray();
				Arrays.sort(cur);
				String str = String.copyValueOf(cur);
				str.trim();
				if(!hm.containsKey(str)) {
					hm.put(str, 1);
				}
			}
			
			
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write(hm.size()+"");
			bw.flush();
			bw.close();
			br.close();
			
			
		}
	
	}
