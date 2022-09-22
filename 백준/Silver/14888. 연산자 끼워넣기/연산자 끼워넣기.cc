#include<iostream>
#include<climits>

using namespace std;


int N;
int oparr[4]{};
int numarr[13]{};
int max_result=INT_MIN;
int min_result=INT_MAX;

int dooper(int val, int next, int cmd) {
	if (cmd == 0) {
		return val + next;
	}
	else if (cmd == 1) {
		return val - next;
	}
	else if (cmd == 2) {
		return val * next;
	}
	else if (cmd == 3) {
		return val / next;
	}
}
void perm(int val, int depth) {
	//기저조건
	if (depth == N) {
		if (max_result < val) {
			max_result = val;
		}
		if (min_result > val) {
			min_result = val;
		}
		return;
	}

	//유도파트
	for (int i = 0; i < 4; i++) {
		if (oparr[i] > 0) {
			oparr[i]--;
			perm(dooper(val, numarr[depth], i), depth + 1);
			oparr[i]++;
		}
	}

}


int main(int argc, char** argv)
{

		cin >> N;
		for (int i = 0; i < N; i++) {
			cin >> numarr[i];
		}
		for (int i = 0; i < 4; i++) {
			cin >> oparr[i];
		}
		// 연산자의 총 개수는 N-1개
		perm(numarr[0], 1);
		cout << max_result << endl;
		cout << min_result << endl;

	return 0;
}