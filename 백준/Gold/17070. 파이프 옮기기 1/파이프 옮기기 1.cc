#include <iostream>


using namespace std;

int arr[17][17];


int n;
int cnt = 0;

// 0 가로 상태 1 대각 상태 2 세로 상태
void perm(int r, int c, int status) {
	if (r == n && c == n) {
		cnt++;
		return;
	}
	// 가로상태에서
	if (status == 0) {
		// 갈 수 있는 방향은 오른쪽(0,+1)이랑
		if (c + 1 <= n && arr[r][c + 1] == 0) {
			perm(r, c + 1, 0);
		}

		// 오른쪽 아래 (+1,+1)
		if (c + 1 <= n && r + 1 <= n && arr[r + 1][c + 1] == 0 && arr[r][c + 1] == 0 && arr[r + 1][c] == 0) {
			perm(r + 1, c + 1, 1);
		}

	}
	// 대각상태에서
	if (status == 1) {
		// 갈 수 있는 방향은 오른쪽(0,+1)이랑
		if (c + 1 <= n && arr[r][c + 1] == 0) {
			perm(r, c + 1, 0);
		}

		// 오른쪽 아래 (+1,+1)
		if (c + 1 <= n && r + 1 <= n && arr[r + 1][c + 1] == 0 && arr[r][c + 1] == 0 && arr[r + 1][c] == 0) {
			perm(r + 1, c + 1, 1);
		}

		// 아래(+1,1)
		if (r + 1 <= n && arr[r + 1][c] == 0) {
			perm(r + 1, c, 2);
		}

	}
	// 아래상태에서
	if (status == 2) {

		// 오른쪽 아래 (+1,+1)
		if (c + 1 <= n && r + 1 <= n && arr[r + 1][c + 1] == 0 && arr[r][c + 1] == 0 && arr[r + 1][c] == 0) {
			perm(r + 1, c + 1, 1);
		}

		// 아래(+1,1)
		if (r + 1 <= n && arr[r + 1][c] == 0) {
			perm(r + 1, c, 2);
		}

	}

}

int main()
{
	cin >> n;


	for (int r = 1; r <= n; r++) {
		for (int c = 1; c <= n; c++) {
			cin >> arr[r][c];
		}
	}


	perm(1, 2, 0);


	cout << cnt;


	return 0;
}

