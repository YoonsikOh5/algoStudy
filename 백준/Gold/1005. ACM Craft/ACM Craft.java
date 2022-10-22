import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	static int T, N, K, W;
	static Building[] barr;

	static class Building {

		List<Integer> nextls = new LinkedList<>();

		int befnum = 0;

		// 이 건물 자체가 걸리는 시간
		int ownSecond;
		// 건물이 지어지려면 걸리는 총 시간
		int maxSecond;

		public Building(int ownSecond) {
			this.ownSecond = ownSecond;
			this.maxSecond = ownSecond;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			barr = new Building[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				barr[i] = new Building(Integer.parseInt(st.nextToken()));
			}

			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine());
				int stnum = Integer.parseInt(st.nextToken());
				int endnum = Integer.parseInt(st.nextToken());
				barr[stnum].nextls.add(endnum);
				barr[endnum].befnum++;
			}

			W = Integer.parseInt(br.readLine());

			int resultmin = topologicalsort();

			bw.write(resultmin + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static int topologicalsort() {

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (barr[i].befnum == 0) {
				q.add(i);
				if (i == W) {
					return barr[i].maxSecond;
				}
			}
		}

		while (q.size() > 0) {

			int cur = q.poll();

			for (int i = 0, size = barr[cur].nextls.size(); i < size; i++) {
				int nextnum = barr[cur].nextls.get(i);

				barr[nextnum].befnum -= 1;
				barr[nextnum].maxSecond = Math.max(barr[cur].maxSecond + barr[nextnum].ownSecond,
						barr[nextnum].maxSecond);

				if (barr[nextnum].befnum == 0) {
					if (nextnum == W) {
						return barr[nextnum].maxSecond;
					} else {
						q.add(nextnum);
					}
				}

			}

		}

		return 0;
	}

}