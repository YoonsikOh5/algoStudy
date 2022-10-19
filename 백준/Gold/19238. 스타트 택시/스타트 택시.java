import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int matrix[][];
	static HashMap<Integer, HashMap<Integer, Person>> hm;

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class RC {
		int r;
		int c;

		public RC(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static class Taxi {
		int curr;
		int curc;
		long fuel;

		public int getCurr() {
			return curr;
		}

		public void setCurr(int curr) {
			this.curr = curr;
		}

		public int getCurc() {
			return curc;
		}

		public void setCurc(int curc) {
			this.curc = curc;
		}

		public long getFuel() {
			return fuel;
		}

		public void setFuel(long fuel) {
			this.fuel = fuel;
		}

		// 승객 찾는 bfs();
		Person findPerson() {
			// 시작점 현재 택시의 위치
			RC startrc = new RC(this.curr, this.curc);
			boolean visited[][] = new boolean[N + 1][N + 1];
			// 큐
			Queue<RC> q = new LinkedList<>();
			q.add(startrc);
			visited[this.curr][this.curc] = true;
			if (matrix[this.curr][this.curc] > 1) {
				matrix[this.curr][this.curc] = 0;
				return hm.get(this.curr).get(curc);
			}
			int time = 1;
			RC timecounter = new RC(-1, -1);
			q.add(timecounter);

			PriorityQueue<Person> pq = new PriorityQueue<>();

			boolean findP = false;
			while (q.size() > 0) {
				RC cur = q.poll();

				int cr = cur.r;
				int cc = cur.c;

				// 타임 카운터 넣어주기
				if (cr == -1 && cc == -1) {
					if (findP == true) {
						break;
					}
					time++;
					if (q.size() > 0) {
						q.add(timecounter);
					}
					continue;
				}

				for (int d = 0; d < 4; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];

					if (inRange(nr, nc) && matrix[nr][nc] != 1 && visited[nr][nc] == false) {
						int curnum = matrix[nr][nc];

						// 0 인경우 그냥 q에 넣고 다음 탐색
						if (curnum == 0) {
							q.add(new RC(nr, nc));
							visited[nr][nc] = true;
						} else if (curnum >= 2) {
							// 2 이상이다 -> person 발견했다 pq에 넣는다
							// 이번 time 이후로 더 탐색할 필요가 없음(q에 넣을 필요 x)
							findP = true;
							pq.add(hm.get(nr).get(nc));
							visited[nr][nc] = true;
						}
					}
				}
			}

			if (this.fuel < time || pq.size() == 0) {
				return null;
			} else {
				// 가장 위에 있는 승객이 타겟 승객
				Person targetP = pq.poll();
				// 승객 있는 곳으로 가고
				this.curr = targetP.startr;
				this.curc = targetP.startc;
				// 연료 줄여주고
				this.fuel -= time;


				// 승객 태웠으니 지워주기
				matrix[targetP.startr][targetP.startc] = 0;

				return targetP;
			}

		}

		// 승객 목적지로 보내주는 bfs();
		boolean personToDest(Person curPerson) {
			// 시작점 현재 택시의 위치
			RC startrc = new RC(this.curr, this.curc);
			boolean visited[][] = new boolean[N + 1][N + 1];
			// 큐
			Queue<RC> q = new LinkedList<>();
			q.add(startrc);
			visited[this.curr][this.curc] = true;

			int curdestr = curPerson.destr;
			int curdestc = curPerson.destc;

			if (this.curr == curdestr && this.curc == curdestc) {
				return true;
			}

			int time = 1;
			RC timecounter = new RC(-1, -1);
			q.add(timecounter);

			while (q.size() > 0) {
				RC cur = q.poll();

				int cr = cur.r;
				int cc = cur.c;

				// 타임 카운터 넣어주기
				if (cr == -1 && cc == -1) {
					time++;
					if (q.size() > 0) {
						q.add(timecounter);
					}
					continue;
				}

				for (int d = 0; d < 4; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];

					if (inRange(nr, nc) && matrix[nr][nc] != 1 && visited[nr][nc] == false) {

						// 목적지 찾았으면
						if (nr == curdestr && nc == curdestc) {
							if (this.fuel < time) {
								return false;
							} else {
								// 목적지로 가고
								this.curr = curdestr;
								this.curc = curdestc;
								// 연료 어차피 사용한거의 두배를 늘려줄꺼니까
								// 퉁쳐서 한번 늘려주면 됨
								this.fuel += time;
								return true;
							}
						}

						q.add(new RC(nr, nc));
						visited[nr][nc] = true;

					}
				}

			}

			return false;

		}

	}

	static class Person implements Comparable<Person> {
		int startr;
		int startc;
		int destr;
		int destc;

		public Person(int startr, int startc, int destr, int destc) {
			super();
			this.startr = startr;
			this.startc = startc;
			this.destr = destr;
			this.destc = destc;
		}

		@Override
		public int compareTo(Person o) {
			if (this.startr == o.startr) {
				return this.startc - o.startc;
			}
			return this.startr - o.startr;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Taxi taxi = new Taxi();
		long startfuel = Long.parseLong(st.nextToken());
		taxi.setFuel(startfuel);

		matrix = new int[N + 1][N + 1];

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				matrix[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int taxir = Integer.parseInt(st.nextToken());
		int taxic = Integer.parseInt(st.nextToken());
		taxi.setCurr(taxir);
		taxi.setCurc(taxic);

		hm = new HashMap<>();

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int startr = Integer.parseInt(st.nextToken());
			int startc = Integer.parseInt(st.nextToken());
			int destr = Integer.parseInt(st.nextToken());
			int destc = Integer.parseInt(st.nextToken());

			matrix[startr][startc] = i + 1;

			Person ps = new Person(startr, startc, destr, destc);

			if (hm.containsKey(startr)) {
				hm.get(startr).put(startc, ps);
			} else {
				HashMap<Integer, Person> nhm = new HashMap<>();
				nhm.put(startc, ps);
				hm.put(startr, nhm);
			}
		}

		boolean fail = false;
		int finishedP = 0;
		while (finishedP < M) {

			// 택시 출발
			// 가장 가까이 있는 승객 (bfs)탐색 후 이동(거리만큼 연료 차감)
			// 승객의 목적지까지 이동 (bfs로 거리 탐색)
			Person targetP = taxi.findPerson();
			// targetP == null 인 경우 연료가 부족한 거니까 실패~
			if (targetP != null) {
				// 목적지에서 이동거리와 연료 확인해서 가능한 거였는지 확인하고
				// 가능한 거였다면 승객->목적지 이동거리의 두배를 연료에 추가
				// 승객을 모두 태워주면 성공 -> 마지막 두배로 추가하고 나서의 연료 출력
				if (!taxi.personToDest(targetP)) {
					fail = true;
					break;
				}
				// 도중에 연료가 부족하면 실패 -> -1 출력
			} else {
				fail = true;
				break;
			}

			finishedP++;
		}

		if (!fail) {
			bw.write(taxi.fuel + "");
		} else {
			bw.write("-1");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static boolean inRange(int nr, int nc) {
		if (nr >= 1 && nr <= N && nc >= 1 && nc <= N) {
			return true;
		} else {
			return false;
		}
	}

}