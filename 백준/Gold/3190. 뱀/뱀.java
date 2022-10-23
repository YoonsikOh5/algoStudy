import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, K, L;

	static int map[][];

	static HashMap<Integer, Character> changehm;

	static Snake snake;

	static int result_second;

	// 상하좌우
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class RC {
		int r;
		int c;

		public RC(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static class Snake {

		// 현재 방향
		// 방향 상1 하2 좌3 우4
		int curdirection;

		// 뱀의 머리
		RC head;

		// 뱀의 꼬리
		List<RC> tail = new LinkedList<>();

		public Snake() {
			this.curdirection = 4;
			this.head = new RC(1, 1);
			this.tail = new LinkedList<>();
		}

		void changeDirection(char direction) {
			// 왼쪽
			if (direction == 'L') {
				if (curdirection == 4) {
					curdirection = 1;
				} else if (curdirection == 2) {
					curdirection = 4;
				} else if (curdirection == 3) {
					curdirection = 2;
				} else if (curdirection == 1) {
					curdirection = 3;
				}
				// 오른쪽
			} else if (direction == 'D') {
				if (curdirection == 4) {
					curdirection = 2;
				} else if (curdirection == 2) {
					curdirection = 3;
				} else if (curdirection == 3) {
					curdirection = 1;
				} else if (curdirection == 1) {
					curdirection = 4;
				}
			}
		}

		// 앞으로 이동
		boolean move() {

			// 헤드를 이동
			int nextheadr = this.head.r + dr[curdirection - 1];
			int nextheadc = this.head.c + dc[curdirection - 1];

			RC nextHead = new RC(nextheadr, nextheadc);

			// 벽 부딪히는 경우
			if (!inRange(nextHead.r,nextHead.c)) {
//				System.out.println("내 위치 "+nextHead.r+" "+nextHead.c);
//				System.out.println("벽에 부딪혔어");
				return false;
			}
			
			// 내 몸 부딪히는 경우
			for(int i = 0, size = this.tail.size(); i < size; i++) {
				RC curtail = tail.get(i);
				if((nextHead.r==curtail.r) && (nextHead.c==curtail.c)) {
//					System.out.println("내 위치 "+nextHead.r+" "+nextHead.c);
//					System.out.println("내 몸에 부딪혔어");
					return false;
				}
			}
			
			// 사과 있으면 먹기
			boolean eatApfel=false;
			if(map[nextHead.r][nextHead.c]==1) {
				eatApfel = true;
				map[nextHead.r][nextHead.c] = 0;
			}
			
			// 사과 먹었으면 tail한 칸 늘려주기
			if(eatApfel) {
				tail.add(0, new RC(this.head.r,this.head.c));
				this.head = nextHead;
			// 사과 안먹었으면 tail마지막 꺼 없애기
			} else {
				tail.add(0, new RC(this.head.r,this.head.c));
				tail.remove(tail.size()-1);
				this.head = nextHead;				
			}

			return true;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];

		for (int i = 1; i <= K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map[r][c] = 1;
		}

		L = Integer.parseInt(br.readLine());
		changehm = new HashMap<>();
		for (int i = 1; i <= L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int second = Integer.parseInt(st.nextToken());
			char direction = st.nextToken().charAt(0);
			changehm.put(second, direction);
		}

		snake = new Snake();

		result_second = 0;

		boolean run = true;
		// Dummy 게임 시작
		while (run) {
			// 시간 1초 지나가고
			result_second++;

			// 뱀 앞으로 이동(충돌이 있다면 run == false)
			run = snake.move();
			
			// 이번 초에 뱀의 방향 전환이 있는지 확인
			if (changehm.containsKey(result_second)) {
				// 방향 전환
				snake.changeDirection(changehm.get(result_second));
			}
		}

		bw.write(result_second + "");
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