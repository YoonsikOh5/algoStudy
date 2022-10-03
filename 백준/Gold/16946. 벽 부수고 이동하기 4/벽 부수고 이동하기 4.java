import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int map[][];
	static HashMap<Integer, Integer> hm;
	static int result[][];
	static int visited[][];


	public static class RC {
		int r;
		int c;

		public RC(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				int cur = str.charAt(c)-'0';
				map[r][c] = cur;
			}
		}
		
		
		
		// 키 : 같은 영역 , 벨류 : 그 영역의 크기
		hm = new HashMap<>();
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c]==0 && visited[r][c]==0) {
					bfs(r,c);
				}
			}
		}

		
		
		// 결과 담을 2차원 배열
		result = new int[N][M];

		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c]==1) {
					// 중복 제거용 셋
					HashSet<Integer> setrc = new HashSet<>();
					for(int d = 0; d < 4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						// 범위 안에 들어와 있고 && map이 0이었던 곳
						if(inRange(nr,nc) && map[nr][nc]==0) {
							// 팀이 최대 4개(중복없이) 들어감
							setrc.add(visited[nr][nc]);
						}
					}
					// 자기자리 1 +
					int rs = 1;
					Object[] objarr = setrc.toArray();
					for(int i = 0, size = objarr.length; i < size; i++) {
						rs += hm.get((Integer)objarr[i]);
					}
					result[r][c] = rs%10;
				}
			}
		}

		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				bw.write(result[r][c]+"");				
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	// 4방 탐색 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static int team = 1;

	public static void bfs(int sr, int sc) {
		
		Queue<RC> q = new LinkedList<>();
		q.add(new RC(sr, sc));
		// 방문 + 같은 영역 표시
		visited[sr][sc] = team;
		
		int areacounter = 0;
		while(q.size()>0) {
			areacounter++;
			RC cur = q.poll();
			
			int curr = cur.r;
			int curc = cur.c;
			
			for(int d = 0; d < 4; d++) {
				int nr = curr+dr[d];
				int nc = curc+dc[d];
				// 범위 안에 들어와 있고 && 갈수있는 곳이고 && 방문한적 없으면 큐에 넣기
				if(inRange(nr,nc) && map[nr][nc]==0 && visited[nr][nc]==0) {
					q.add(new RC(nr, nc));
					visited[nr][nc] = team;
				}
				
			}
		}
		
		// 같은 영역으로 다 끝내고
		// 그 같은 영역에 속해있는 크기를 저장
		hm.put(team, areacounter);
		// 다음 팀을 위해 팀 크기 한개 늘리기
		team++;
	}
	

	public static boolean inRange(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
			return true;
		} else {
			return false;
		}
	}


}