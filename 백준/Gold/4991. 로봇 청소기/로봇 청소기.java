import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static char map[][];
	static int step[][];
	static List<RC> dirtList;
	static RC robot;
	static int edgem[][];
	static int size;
	static int result_min;

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
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		while(!(N==0 && M==0)) {
			dirtList = new ArrayList<>();
			map = new char[N][M];
			
			// . 깨끗한 칸 * 더러운 칸 x 가구 o 로봇 청소기 시작 위치
			for(int r = 0; r < N; r++) {
				char cur[] = br.readLine().toCharArray();
				for(int c = 0; c < M; c++) {
					char cr = cur[c];
					// 더러운 칸과 로봇 청소기 시작 칸 저장
					if(cr=='*') {
						dirtList.add(new RC(r,c));
					}
					if(cr=='o') {
						robot = new RC(r,c);
					}
					map[r][c] = cr;
				}
			}
			// 로봇을 마지막에 넣어주기
			dirtList.add(robot);
			size = dirtList.size();
			// 인접행렬
			edgem = new int[size][size];
			boolean iscleanable = true;
			for(int i = 0; i < size; i++) {
				RC cur = dirtList.get(i);
				if(!bfs(cur.r, cur.c, i)) {
					iscleanable = false;
					break;
				}
			}
			
//			for(int arr[] : edgem) {
//				System.out.println(Arrays.toString(arr));
//			}
			
			if(iscleanable) {
				result_min = Integer.MAX_VALUE;
				// 리스트의 마지막에는 로봇이 있음
				// 로봇이 출발점이 되어야 하니까
				// 로봇을 시작으로 순열 돌리기
				for(int i = 0; i < size-1; i++) {
					permvisited = new boolean[size-1];
					perm(i,edgem[size-1][i], 1);
				}
				bw.write(result_min+"\n");
			} else {
				bw.write("-1\n");
			}
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
		}
		

		bw.write("");
		
		bw.flush();
		bw.close();
		br.close();
	}

	// 4방 탐색 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static boolean bfs(int sr, int sc, int curidx) {
		step = new int[N][M];
		Queue<RC> q = new LinkedList<>();
		q.add(new RC(sr, sc));
		// 방문 + 같은 영역 표시
		step[sr][sc] = 1;
		
		while(q.size()>0) {
			RC cur = q.poll();
			
			int curr = cur.r;
			int curc = cur.c;
			
			for(int d = 0; d < 4; d++) {
				int nr = curr+dr[d];
				int nc = curc+dc[d];
				// 범위 안에 들어와 있고 && 방문한적 없으면
				if(inRange(nr,nc) && step[nr][nc]==0) {
					// 갈수있는 곳이면 큐에 넣기
					if(map[nr][nc]=='.'||map[nr][nc]=='o'||map[nr][nc]=='*') {
						q.add(new RC(nr, nc));
						step[nr][nc] = step[curr][curc]+1;
					}
				}
			}
		}
		
		// 다 끝나면 인접행렬 채워주기
		for(int i = 0; i < size; i++) {
			RC cur = dirtList.get(i);
			if(step[cur.r][cur.c]==0) {
				return false;
			} else {
				// step이 1부터 시작했으니까 1빼줘야 됨
				edgem[curidx][i] = step[cur.r][cur.c]-1;
			}
		}
		return true;
	}
	

	public static boolean inRange(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
			return true;
		} else {
			return false;
		}
	}
	
	static boolean permvisited[];
	
	public static void perm(int start, int len, int depth) {
		permvisited[start] = true;
		// 기저조건
		// 다 뽑으면
		if(depth==size-1) {
			result_min = Math.min(result_min, len);
			return;
		}
		
		
		// 유도파트
		for(int i = 0; i < size-1; i++) {

			if(permvisited[i]==false) {
				perm(i, len+edgem[start][i], depth+1);
				permvisited[i]= false;
			}
			
		}
		
	}


}