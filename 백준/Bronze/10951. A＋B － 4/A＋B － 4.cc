#include <iostream>

using namespace std;

void print(int a, int b) {
    
    cout << a + b << endl;
}

int main() {
    

    while (true) {
    int a, b;
    cin >> a >> b;
    if (cin.eof()) {
        break;
    }
    print(a, b);
    }

}
