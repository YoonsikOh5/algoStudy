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

	static int N, E;

	static List<Edge>[] ls;

	static class Edge {
		int end;
		int len;

		public Edge(int end, int len) {
			super();
			this.end = end;
			this.len = len;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		ls = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			ls[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			ls[start].add(new Edge(end, len));
			ls[end].add(new Edge(start, len));
		}

		st = new StringTokenizer(br.readLine());
		int mid1 = Integer.parseInt(st.nextToken());
		int mid2 = Integer.parseInt(st.nextToken());
		
		boolean findresult = false;
		min_result_len = Integer.MAX_VALUE;
		result_len = 0;
		if(doDijk(1, mid1)) {
			if(doDijk(mid1, mid2)) {
				if(doDijk(mid2, N)) {
					findresult = true;
					min_result_len = Math.min(result_len, min_result_len);
				}
			}
		}
		
		result_len = 0;
		if(doDijk(1, mid2)) {
			if(doDijk(mid2, mid1)) {
				if(doDijk(mid1, N)) {
					findresult = true;
					min_result_len = Math.min(result_len, min_result_len);
				}
			}
		}
		
		if(findresult) {
			bw.write(min_result_len+"");			
		} else if(!findresult) {
			bw.write("-1");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static int mindist[];
	static boolean visited[];
	static int result_len;
	static int min_result_len;

	
	static boolean doDijk(int start, int end) {
		// mindist[i] start에서 i점까지 가는 최단 경로
		mindist = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(mindist, Integer.MAX_VALUE);
		mindist[start] = 0;

		while (true) {

			int min = Integer.MAX_VALUE;
			int minidx = -1;
			for (int i = 1; i < N + 1; i++) {
				if (min > mindist[i] && visited[i] == false) {
					min = mindist[i];
					minidx = i;
				}
			}
			
			if(minidx == end) {
				result_len += mindist[end];
				return true;
			}
			
			if (minidx != -1) {
				visited[minidx] = true;
				int size = ls[minidx].size();
				for (int j = 0; j < size; j++) {
					Edge cur = ls[minidx].get(j);
					mindist[cur.end] = Math.min(mindist[cur.end], min + cur.len);
				}
			} else if (minidx == -1) {
				return false;
			}

		}

	}

}