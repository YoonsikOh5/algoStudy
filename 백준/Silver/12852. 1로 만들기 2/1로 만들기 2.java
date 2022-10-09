import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int X;
	static boolean visited[];
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		X = Integer.parseInt(br.readLine());
		visited = new boolean[X+1];
		bfs();
		
//		bw.write("");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class numlist{
		int num;
		List<Integer> ls;
	
		public numlist(int num, List<Integer> ls) {
			super();
			this.num = num;
			this.ls = ls;
		}
	
	}
	
	
	public static void bfs() throws IOException{
		
		Queue<numlist> q = new LinkedList<>();
		List<Integer> start = new ArrayList<>();
		start.add(X);
		q.add(new numlist(X, start));
		visited[X] = true;
		
		
		while(q.size()>0) {
			numlist cur = q.poll();
			int curnum = cur.num;
			List<Integer> curls = cur.ls;
			if(curnum==1) {
				bw.write((curls.size()-1)+"\n");
				for(int i = 0, size = curls.size(); i < size; i++) {
					bw.write(curls.get(i)+" ");
				}
				return;
			}
			
			
			int mnum = curnum-1;
			if(visited[mnum]==false) {
				List<Integer> ls = new ArrayList<>();
				for(int i = 0, size = curls.size(); i < size; i++) {
					ls.add(curls.get(i));
				}
				visited[mnum] = true;
				ls.add(mnum);
				q.add(new numlist(mnum,ls));
			}
			
			if(curnum%3==0) {
				int d3num = curnum/3;
				if(visited[d3num]==false) {
					List<Integer> ls = new ArrayList<>();
					for(int i = 0, size = curls.size(); i < size; i++) {
						ls.add(curls.get(i));
					}
					visited[d3num] = true;
					ls.add(d3num);
					q.add(new numlist(d3num,ls));
				}	
			}
			if(curnum%2==0) {
				int d2num = curnum/2;
				if(visited[d2num]==false) {
					List<Integer> ls = new ArrayList<>();
					for(int i = 0, size = curls.size(); i < size; i++) {
						ls.add(curls.get(i));
					}
					visited[d2num] = true;
					ls.add(d2num);
					q.add(new numlist(d2num,ls));
				}	
			}
			
			
		}
		
	}

}