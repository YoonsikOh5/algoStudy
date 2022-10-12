import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int arr[];
	// dp[i][j][k] i번째 위치까지 고려하여, 총 j개의 구간을 선택 했고
	// i번째 원소가 마지막 구간에 속하지 않았다면 k=notInclude(0) 속했다면 k=include(1) 상태라 했을 때
	// 얻을 수 있는 최대 합
	static int dp[][][];
	static int MIN_S = -32768 * 101;
	static final int NOT_INCLUDE = 0;
	static final int INCLUDE = 1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		dp = new int[N + 1][M + 1][2];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j][NOT_INCLUDE] = MIN_S;
				dp[i][j][INCLUDE] = MIN_S;
			}
		}
		for (int i = 0; i <= N; i++) {
			dp[i][0][INCLUDE] = MIN_S;
		}

		// 1번째 구간의 마지막수가 1번이면 1번 수
		dp[1][1][INCLUDE] = arr[1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				
				// 1. i번째 숫자를 구간에 포함시킨 경우
				// 1-1 i번째가 새로운 구간의 시작이면
				// 이전 구간이랑 인접하지 않아야 하므로 i-1번째 상태가 not include여야 하며
				// 그때까지 j-1개의 구간을 선택했을 경우에 해당하는
				// dp[i-1][j-1][NOT_INCLUDE]에 a[i]를 더함
				
				// 1-2 i번째가 이전구간 j에 포함되면
				// i-1번째 상태가 INCLUDE여야 하며 그때까지 J개의 구간을 선택한 경우인
				// dp[i-1][j][INCLUDE]에 a[i]를 더합니다
				dp[i][j][INCLUDE] = Math.max(dp[i-1][j-1][NOT_INCLUDE]+arr[i],
											dp[i-1][j][INCLUDE]+arr[i]);
				
				// 2. i번째 숫자를 구간에 포함시키지 않은 경우
				// 이때는 i-1번째 원소를 j번째 구간에 포함시켰는지에 대한 여부가 중요하지 않음
				// dp[i-1][j][NOT_INCLUDE]와 dp[i-1][j][INCLUDE] 둘 중 더 큰 값을 넣으면 됨
				dp[i][j][NOT_INCLUDE] = Math.max(dp[i-1][j][NOT_INCLUDE], dp[i-1][j][INCLUDE]);

			}

		}
		
		bw.write(Math.max(dp[N][M][NOT_INCLUDE],dp[N][M][INCLUDE]) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
