#include<iostream>
#include<climits>
#include<algorithm>

using namespace std;

int N;
int arr[1001]{};
int dp[1001]{};
int max_result = INT_MIN;


int main()
{	
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	
	for(int i = 0; i < N; i++){
		int maxdp = 0;
		for (int j = 0; j < i; j++) {
			if (arr[j] < arr[i]) {
				maxdp = max(dp[j], maxdp);
			}
		}
		dp[i] = maxdp + 1;
	}
	for (int i = 0; i < N; i++) {
		max_result = max(max_result, dp[i]);
	}
	cout << max_result;

	return 0;
}