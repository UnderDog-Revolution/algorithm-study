#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

struct Problem {
    int deadline;
    int cup_ramen;
};

bool compare(const Problem &a, const Problem &b) {
    return a.deadline < b.deadline;
}

int main() {
    int n, result = 0;
    cin >> n;
    
    Problem *problem = new Problem[n];
    
    for (int i = 0; i < n; i++) {
        cin >> problem[i].deadline >> problem[i].cup_ramen;
    }

    sort(problem, problem + n, compare);
    
    priority_queue<int, vector<int>, greater<int>> pq;

    for (int i = 0; i < n; i++) {
        result += problem[i].cup_ramen;
        pq.push(problem[i].cup_ramen);
        
        if (pq.size() > problem[i].deadline) {
            result -= pq.top();
            pq.pop();
        }
    }

    cout << result << endl;
    return 0;
}
