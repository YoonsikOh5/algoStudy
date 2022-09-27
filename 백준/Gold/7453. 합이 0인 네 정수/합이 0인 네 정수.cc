#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	int n;
	cin >> n;
	long long a[4001];
	long long b[4001];
	long long c[4001];
	long long d[4001];

	for (int i = 0; i < n; i++) {
		cin >> a[i];
		cin >> b[i];
		cin >> c[i];
		cin >> d[i];

	}

	vector<long long> absum;
	vector<long long> cdsum;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int cur = a[i] + b[j];
			absum.push_back(cur);
			cur = c[i] + d[j];
			cdsum.push_back(cur);
		}
	}
	sort(cdsum.begin(), cdsum.end());
	long long result = 0;
	for (int i = 0; i < absum.size(); i++) {
		long long curnum = absum[i];

		long long count = (upper_bound(cdsum.begin(), cdsum.end(), -curnum)) - (lower_bound(cdsum.begin(), cdsum.end(), -curnum));
		
		if (count > 0) {
			result += count;
		}

	}
	cout << result;

}

