#include <iostream>
#include <climits>

using namespace std;

bool findroute = false;
int a;
int result = INT_MAX;
void btoa(int b, int depth) {
	if (result < depth || b < a) {
		return;
	}
	if (b == a) {
		findroute = true;
		if (result > depth) {
			result = depth;
		}
		return;
	}


	if (b % 2 == 0) {
		btoa(b / 2, depth+1);
	}
	if (b % 10 == 1) {
		btoa(b / 10, depth+1);
	}


}

int main(){

	int b;
	cin >> a >> b;

	btoa(b, 1);
	
	if (findroute) {
		cout << result;
	}
	else {
		cout << -1;
	}

	return 0;
}