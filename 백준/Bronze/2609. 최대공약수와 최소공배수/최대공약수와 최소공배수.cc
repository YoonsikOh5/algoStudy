#include <bits/stdc++.h>

using namespace std;

int main() {
	int a, b;
	cin >> a >> b;

	// 최대 공약수
	int start = 0;
	if (a >= b) {
		start = b;
	}
	else {
		start = a;
	}
	while (true) {
		if (a % start == 0 && b % start == 0) {
			cout << start << "\n";
			break;
		}
		start--;
	}

	// 최소 공배수
	start = 0;
	if (a >= b) {
		start = a;
	}
	else {
		start = b;
	}
	while (true) {
		if (start % a == 0 && start % b == 0) {
			cout << start;
			break;
		}
		start++;
	}

	return 0;
}