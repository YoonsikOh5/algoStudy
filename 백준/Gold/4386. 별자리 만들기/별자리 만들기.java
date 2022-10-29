import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;

	static Star[] stars;

	static double[][] edgeM;

	static class Star {
		double x;
		double y;

		public Star(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		stars = new Star[n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			stars[i] = new Star(x, y);
		}

		edgeM = new double[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					continue;
				}
				edgeM[i][j] = Math.sqrt(Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2));
			}
		}

		doPrim(1);
		
		double result = Math.round(min_result*100)/100.0;
		
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}

	static double min_result;

	static void doPrim(int start) {
		boolean visited[] = new boolean[n + 1];

//		visited[start] = true;

		double dist[] = new double[n + 1];
		Arrays.fill(dist, Double.MAX_VALUE);
		dist[1] = 0;

		int selected_star = 0;

		while (selected_star < n) {
			double curmin = Double.MAX_VALUE;
			int curstar = -1;
			for (int i = 1; i <= n; i++) {
				if (curmin > dist[i] && visited[i] == false) {
					curmin = dist[i];
					curstar = i;
				}
			}
			
			visited[curstar] = true;
			min_result += curmin;
			
			for(int i = 1; i <= n; i++) {
				if(curstar==i) {
					continue;
				}
				dist[i] = Math.min(dist[i], edgeM[curstar][i]);
			}
			
			selected_star++;
			
		}

	}

}