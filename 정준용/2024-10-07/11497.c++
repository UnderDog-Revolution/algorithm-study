#include <iostream>
using namespace std;

int PARTITION(int* arr, int p, int r) {
    int x = arr[r]; 
    int i = p - 1; 

    for (int j = p; j < r; j++) {
        if (arr[j] <= x) {
            i++; 
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[i + 1], arr[r]); 
    return i + 1; 
}


void Quicksort(int* arr, int p, int r) {
    if (p < r) {
        int q = PARTITION(arr, p, r);
        Quicksort(arr, p, q - 1);
        Quicksort(arr, q + 1, r);
    }
}


int main() {
    int repeat = 0;


    cin >> repeat;

    for (int i = 0; i < repeat; i++) {
        int size = 0;
        cin >> size;

        int result = 0;
        int *arr = new int[size]; 

        for (int j = 0; j < size; j++) {
            cin >> arr[j]; 
        }

        Quicksort(arr, 0, size - 1);

        for (int k = 2; k < size; k++) {
			int min = arr[k] - arr[k - 2];
			result = max(result, min);
		}
		cout << result << '\n';

    }

    return 0;
}