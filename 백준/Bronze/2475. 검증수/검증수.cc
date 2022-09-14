#include <bits/stdc++.h>

using namespace std;

int main(){
    
    int arr[5];
    for(int i = 0; i < 5; i++){
        cin >> arr[i];
    }
    int sum = 0;
    for(int i = 0; i < 5; i++){
        sum += (arr[i]*arr[i]);
    }
    int result = sum % 10;
    cout << result;
    
    return 0;
}