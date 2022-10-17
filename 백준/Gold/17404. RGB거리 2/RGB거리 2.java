import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;

	static int rgb[][];
	static int dpSr[][];
	static int dpSg[][];
	static int dpSb[][];
	
	static int min_result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		rgb = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min_result = Integer.MAX_VALUE;

		// 처음에 빨강을 선택하는 경우
		dpSr = new int[N + 1][3];

		dpSr[1][0] = rgb[1][0];
		// 처음에 생각한거는 두번째 줄에서 전에 빨간색만 고르는걸 생각을 했는데
		// 사실 첫줄에 나머지 두개에 비용의 최댓값을 넣어버리면 알아서 안고르겠네
		// 그리고 두번째줄의 빨간거에도 최댓값을 넣어야 세번째줄에서 안고름
		dpSr[1][1] = 10001;// 1001만 넣어도 되겠지만 혹시 모르니까
		dpSr[1][2] = 10001;
		dpSr[2][0] = 10001;

		// 이렇게 넣고 쭉 dp돌리기
		// N-1 번째 줄까지만 돌리기 -> N번째 줄은 조금 다르게 할꺼임
		for (int i = 2; i <= N - 1; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 2 && j == 0) {
					// 이미 넣었으니까
					continue;
				}
				int min_temp = Integer.MAX_VALUE;
				for (int k = 0; k < 3; k++) {
					if (j == k) {
						continue;
					}
					min_temp = Math.min(min_temp, dpSr[i - 1][k] + rgb[i][j]);
				}
				dpSr[i][j] = min_temp;
			}
		}
		
		// N번째 줄은 빨간색 안고르는 쪽으로
		// 그냥 마지막줄에서 최솟값 갱신하기
		min_result = Math.min(min_result, dpSr[N-1][0]+rgb[N][1]);
		min_result = Math.min(min_result, dpSr[N-1][2]+rgb[N][1]);
		min_result = Math.min(min_result, dpSr[N-1][0]+rgb[N][2]);
		min_result = Math.min(min_result, dpSr[N-1][1]+rgb[N][2]);

		
		
		// 처음에 초록을 선택하는 경우
		dpSg = new int[N + 1][3];

		dpSg[1][1] = rgb[1][1];
		dpSg[1][0] = 10001;// 1001만 넣어도 되겠지만 혹시 모르니까
		dpSg[1][2] = 10001;
		dpSg[2][1] = 10001;

		// 이렇게 넣고 쭉 dp돌리기
		// N-1 번째 줄까지만 돌리기 -> N번째 줄은 조금 다르게 할꺼임
		for (int i = 2; i <= N - 1; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 2 && j == 1) {
					// 이미 넣었으니까
					continue;
				}
				int min_temp = Integer.MAX_VALUE;
				for (int k = 0; k < 3; k++) {
					if (j == k) {
						continue;
					}
					min_temp = Math.min(min_temp, dpSg[i - 1][k] + rgb[i][j]);
				}
				dpSg[i][j] = min_temp;
			}
		}
		
		// N번째 줄은 초록색 안고르는 쪽으로
		// 그냥 마지막줄에서 최솟값 갱신하기
		min_result = Math.min(min_result, dpSg[N-1][1]+rgb[N][0]);
		min_result = Math.min(min_result, dpSg[N-1][2]+rgb[N][0]);
		min_result = Math.min(min_result, dpSg[N-1][0]+rgb[N][2]);
		min_result = Math.min(min_result, dpSg[N-1][1]+rgb[N][2]);
	
		
		// 처음에 파랑을 선택하는 경우
		dpSb = new int[N + 1][3];
		
		dpSb[1][2] = rgb[1][2];
		dpSb[1][0] = 10001;// 1001만 넣어도 되겠지만 혹시 모르니까
		dpSb[1][1] = 10001;
		dpSb[2][2] = 10001;

		// 이렇게 넣고 쭉 dp돌리기
		// N-1 번째 줄까지만 돌리기 -> N번째 줄은 조금 다르게 할꺼임
		for (int i = 2; i <= N - 1; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 2 && j == 2) {
					// 이미 넣었으니까
					continue;
				}
				int min_temp = Integer.MAX_VALUE;
				for (int k = 0; k < 3; k++) {
					if (j == k) {
						continue;
					}
					min_temp = Math.min(min_temp, dpSb[i - 1][k] + rgb[i][j]);
				}
				dpSb[i][j] = min_temp;
			}
		}
		
		// N번째 줄은 초록색 안고르는 쪽으로
		// 그냥 마지막줄에서 최솟값 갱신하기
		min_result = Math.min(min_result, dpSb[N-1][1]+rgb[N][0]);
		min_result = Math.min(min_result, dpSb[N-1][2]+rgb[N][0]);
		min_result = Math.min(min_result, dpSb[N-1][0]+rgb[N][1]);
		min_result = Math.min(min_result, dpSb[N-1][2]+rgb[N][1]);
	
		
		bw.write(min_result+"");
		bw.flush();
		bw.close();
		br.close();
	}

}