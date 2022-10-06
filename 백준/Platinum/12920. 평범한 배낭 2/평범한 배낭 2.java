import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static List<Item> itemls;
	static int[] backpack;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		itemls = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			for(int j = 1; k > 0; j = j<<1) {
				int dep = Math.min(j, k);
				itemls.add(new Item(w*dep,v*dep));				
				k-=dep;
			}
		}
		
		backpack = new int[m+1];
		
		for(int i = 0, size = itemls.size(); i < size; i++) {
			Item cur = itemls.get(i);
			for(int j = m; j >=0; j--) {
				if(j-cur.weight>=0) {
					backpack[j] = Math.max(backpack[j], backpack[j-cur.weight]+cur.value); 					
				}
			}
		}
		
		int max_val = 0;
		for(int i = 0; i <= m; i++) {
			max_val = Math.max(max_val, backpack[i]);
		}
		
		bw.write(max_val+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Item{
		
		int weight;
		int value;

		public Item() {
			super();
		}
		
		public Item(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}
		
	}
	
	
}