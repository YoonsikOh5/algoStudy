#include <iostream>

using namespace std;

int cnt = 0;
int n, s;
int arr[21];

// 비트마스킹 적용해보기
void subset() {

	// 0부터 2의 n제곱까지
	for (int i = 1; i < 1 << n; i++) {
		int sum = 0;
		for (int j = 0; j < n; j++) {
			if ((i & (1 << j)) > 0) {
				sum += arr[j];
			}
		}
		if (sum == s) {
			cnt++;
		}

	}

}


int main()
{

	cin >> n >> s;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	subset();

	cout << cnt;

	return 0;
}
