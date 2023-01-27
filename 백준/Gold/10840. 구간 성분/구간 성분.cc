#include <iostream>
#include <cstdio>
#include <cstring>
#include <vector>
#include <set>
#include <algorithm>
 
using namespace std;
 
set<vector<int>> hs;
 
int main()
{
    char a[1502];
    char b[1502];
    int result = 0;
    
    cin >> a;
    cin >> b;

    int alen = strlen(a);
    int blen = strlen(b);

    for(int i = 0; i < alen; i++){
        vector<int> ls(26);
           for(int k = i; k < alen; k++){
                 ls[a[k]-'a']++;
                 hs.insert(ls);
         }
     }

     
    for(int i = 0; i < blen; i++){
        vector<int> ls(26);
            for(int k = i; k < blen; k++){
                ls[b[k]-'a']++;
                if(k-i+1>result){
                    if(hs.count(ls)){
                    result = k-i+1;
                 }
            }
         }
    }

    cout << result;
 
    return 0;
}