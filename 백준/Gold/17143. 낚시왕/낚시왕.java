import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int R, C, M;

	static Shark[][] map;

	static class Shark {
		int curr;
		int curc;
		int speed;
		int direction;
		int zsize;

		public Shark(int curr, int curc, int speed, int direction, int zsize) {
			super();
			this.curr = curr;
			this.curc = curc;
			this.speed = speed;
			this.direction = direction;
			this.zsize = zsize;
		}

		void sharkMove(Shark[][] nextmap) {

			// 위치 결정
			// 현재 방향이 위쪽이면
			if (this.direction == 1) {
				// 속력이 현재R보다 작으면 그냥 속력만큼 위로 올려주기만 하면 됨
				if (this.speed < this.curr) {
					this.curr -= this.speed;
				} else {
					// 그 보다 크면 나머지 연산을 해주면 됨
					// 벽까지 움직이고 남은 스피드
					int curspeed = this.speed - this.curr + 1;
					// 전체 C로 나눈 몫이랑 나머지를 구함
					int speedShare = (curspeed-1) / (R-1);
					int speedRemainder = ((curspeed-1) % (R-1))+1;

					this.curr = 1;
					// 이 나머지가 0이라는거는 방향이 바뀐다는거
					if (speedShare % 2 == 0) {
						this.direction = 2;
						this.curr += speedRemainder;
					} else if (speedShare % 2 == 1) {
						// 이거는 방향은 그대로
						// 대신 마지막 위치는 R에서 remainder를 빼줘야 됨
						this.curr = R - speedRemainder;
					}
				}
				// 현재 방향이 아래쪽이면
			} else if (this.direction == 2) {
				// 속력이 (전체R-현재R)보다 작거나 같으면 그냥 속력만큼 위로 올려주기만 하면 됨
				if (this.speed <= (R - this.curr)) {
					this.curr += this.speed;
				} else {
					// 그 보다 크면 나머지 연산을 해주면 됨
					// 벽까지 움직이고 남은 스피드
					int curspeed = this.speed - (R-this.curr);
					// 전체 C로 나눈 몫이랑 나머지를 구함
					int speedShare = (curspeed-1) / (R-1);
					int speedRemainder = ((curspeed-1) % (R-1))+1;

					this.curr = R;
					// 이 나머지가 0이라는거는 방향이 바뀐다는거
					if (speedShare % 2 == 0) {
						this.direction = 1;
						this.curr -= speedRemainder;
					} else if (speedShare % 2 == 1) {
						// 이거는 방향은 그대로
						this.curr = 1+speedRemainder;
					}
				} 
				// direction이 오른쪽이면
			} else if (this.direction == 3) {
				if (this.speed <= (C - this.curc)) {
					this.curc += this.speed;
				} else {
					// 그 보다 크면 나머지 연산을 해주면 됨
					// 벽까지 움직이고 남은 스피드
					int curspeed = this.speed - (C-this.curc);
					// 전체 C로 나눈 몫이랑 나머지를 구함
					int speedShare = (curspeed-1) / (C-1);
					int speedRemainder = ((curspeed-1) % (C-1))+1;

					this.curc = C;
					// 이 나머지가 0이라는거는 방향이 바뀐다는거
					if (speedShare % 2 == 0) {
						this.direction = 4;
						// 마지막 위치는 1에서 remainder를 더해줘야 됨
						this.curc -= speedRemainder;
					} else if (speedShare % 2 == 1) {
						// 이거는 방향은 그대로
						this.curc = 1+speedRemainder;
					}
				} 
				// direction이 왼쪽이면
			} else if (this.direction == 4) {
				// 속력이 현재보다 작으면 그냥 속력만큼 왼쪽으로 옮겨주기만 하면 됨
				if (this.speed < this.curc) {
					this.curc -= this.speed;
				} else {
					// 그 보다 크면 나머지 연산을 해주면 됨
					// 벽까지 움직이고 남은 스피드
					int curspeed = this.speed - this.curc + 1;
					// 전체 C로 나눈 몫이랑 나머지를 구함
					int speedShare = (curspeed-1) / (C-1);
					int speedRemainder = ((curspeed-1) % (C-1))+1;

					this.curc = 1;
					// 이 나머지가 0이라는거는 방향이 바뀐다는거
					if (speedShare % 2 == 0) {
						this.direction = 3;
						this.curc += speedRemainder;
					} else if (speedShare % 2 == 1) {
						// 이거는 방향은 그대로
						// 대신 마지막 위치는 R에서 remainder를 빼줘야 됨
						this.curc = C - speedRemainder;
					}
				}
			}

				// 그 위치가 지금 null 이면 그냥 넣고
				if(nextmap[this.curr][this.curc]==null) {
					nextmap[this.curr][this.curc] = this;
				} else {
					// null이 아니면 기존에 있던 상어와 비교해서 사이즈가 큰 상어만 남김
					if(nextmap[this.curr][this.curc].zsize<this.zsize) {
						nextmap[this.curr][this.curc] = this;
					}
				}

		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.zsize+"";
		}
		
		

	}
	

	static class Fisher {

		int curc;
		int caughtSharkSizeSum;

		public Fisher(int curc) {
			this.curc = curc;
			this.caughtSharkSizeSum = 0;
		}

		// 오른쪽 한칸가기
		void moveRight() {
			this.curc = this.curc + 1;
		}

		// 상어잡는 메소드
		void catchShark() {
			for (int r = 1; r <= R; r++) {
				if (map[r][this.curc] != null) {
					// 잡은거 사이즈 더해주고
					caughtSharkSizeSum += map[r][this.curc].zsize;
					// 잡은 상어 맵에서 삭제
					map[r][this.curc] = null;
					break;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new Shark[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			Shark shark = new Shark(r, c, s, d, z);

			map[r][c] = shark;

		}

		// 1 낚시꾼이 0에서부터 시작해서 오른쪽으로 한칸가고
		// 2 그 열에 있는 상어를 한마리 잡고(잡은 상어 사이즈 저장)
		// 3 상어가 움직이고
		// 4 낚시꾼이 R까지 이동하고 상어를 한마리 잡으면 끝

		Fisher fisher = new Fisher(0);

//		for(Shark[] arr : map) {
//			System.out.println(Arrays.toString(arr));
//		}
//		System.out.println();
		
		while (fisher.curc < C) {
			// 1 낚시꾼 오른쪽 한칸 이동
			fisher.moveRight();

			// 2 낚시꾼 상어 한마리 잡기
			fisher.catchShark();

			// 3 상어 움직이기
			Shark[][] nextmap = new Shark[R + 1][C + 1];
			for (int r = 1; r <= R; r++) {
				for (int c = 1; c <= C; c++) {
					if (map[r][c] != null) {
						map[r][c].sharkMove(nextmap);
					}
				}
			}
			map = nextmap;

//			for(Shark[] arr : map) {
//				System.out.println(Arrays.toString(arr));
//			}
//			System.out.println();
		}
		
		

		bw.write(fisher.caughtSharkSizeSum + "");
		bw.flush();
		bw.close();
		br.close();
	}

}