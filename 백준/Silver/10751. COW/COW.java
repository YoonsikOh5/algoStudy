import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

	
	
	
	public class Main {
	
		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			long result = 0;
			HashMap<Character, Integer> hm = new HashMap<>();
			for(int i = 0; i < n; i++) {
				char cur = arr[i];
				if(cur == 'C') {
					if(hm.containsKey('C')) {
						hm.put('C', hm.get('C')+1);
					}else {						
						hm.put('C', 1);
					}
				} else if(cur=='O') {
					if(hm.containsKey('C')) {
						if(hm.containsKey('O')) {
							hm.put('O', hm.get('O')+hm.get('C'));
						} else {
							hm.put('O', hm.get('C'));
						}
					}
				} else if(cur=='W') {
					if(hm.containsKey('O')) {
						result += hm.get('O');
					}
				}
			}
			
			bw.write(result+"");
			
			bw.flush();
			bw.close();
			br.close();
			
			
		}
	
	}
