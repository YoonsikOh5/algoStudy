import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] factoryarr = new long[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			factoryarr[i] = Long.parseLong(st.nextToken());
		}

		long result = 0;
		for (int i = 0; i < n - 2; i++) {
			// 가격 세는 것부터 다시 생각해보자
			// 1개는 3원 2개 같이사면 5원 3개 같이사면 7원이라 되어 있지만
			// 다시 생각해보면 기본적으로 처음 사는 라면은 전부 3원이고
			// 2개 3개 묶어서 살때마다 개당 가격은 2원이다
			if (factoryarr[i] >= 1) {
				long dif01 = factoryarr[i] - factoryarr[i + 1];
				long dif02 = factoryarr[i+1] - factoryarr[i + 2];
				if (factoryarr[i + 1] > factoryarr[i + 2]) {
					if(dif01>1) {
						result += dif02*5;
						factoryarr[i] -= dif02;
						factoryarr[i+1] -= dif02;
						i--;
						continue;
					} else {
						if(factoryarr[i]<dif02) {
							result+=factoryarr[i]*5;
							factoryarr[i+1] -= factoryarr[i];
							factoryarr[i] = 0;
						} else if(factoryarr[i]>=dif02) {
							result+=dif02*5;
							factoryarr[i+1] -= dif02;
							factoryarr[i] -= dif02;
							i--;
							continue;
						}
					}
				} else {
					if (dif01 >= 1) {
						result += factoryarr[i] * 3 + factoryarr[i + 1] * 4;
						factoryarr[i + 2] -= factoryarr[i + 1];
						factoryarr[i + 1] = 0;
						factoryarr[i] = 0;
					} else {
						result += factoryarr[i] * 7;
						factoryarr[i + 1] -= factoryarr[i];
						factoryarr[i + 2] -= factoryarr[i];
						factoryarr[i] = 0;
					}
				}
			}
		}
		long dif01 = factoryarr[n - 2] - factoryarr[n - 1];
		if (dif01 >= 1) {
			result += factoryarr[n - 2] * 3 + factoryarr[n - 1] * 2;
		} else {
			result += factoryarr[n - 2] * 2 + factoryarr[n - 1] * 3;
		}
		System.out.println(result);

	}

}
