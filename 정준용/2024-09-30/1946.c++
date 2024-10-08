#include <iostream>
#define NUM 100000
using namespace std;

//algorigm 라이브러리를 활용하면 런타임초과 안뜸 알고리즘에서 배운 삽입정렬을 직접 구현하고싶었음 
 void sort(pair<int, int> arr[], int num) {
    for (int i = 1; i < num; i++) {
        pair<int, int> key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j].first > key.first) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key; 
    }
}

int main() {
    int score;
    cin >> score;
 
    for(int i = 0; i < score; i++) {
        int num;
        cin >> num;
 
        pair<int, int> person[NUM];
 
        for(int j = 0; j < num; j++) {
            cin >> person[j].first >> person[j].second;
        }
 
        sort(person, num);
 
        int count = 1;
        int a = person[0].first;
        int b = person[0].second;
 
        for(int k = 1; k < num; k++) {
            if(person[k].first > a && person[k].second < b) {
                count++;
                a = person[k].first;
                b = person[k].second;
            }
        }
 
        cout << count << endl;
        
    }
    
    return 0;
    
}