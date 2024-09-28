#include <iostream>
#include <vector>
#include <queue>
using namespace std;

void bfs(const vector<vector<int>>& graph, vector<bool>& visited, int start) {
    queue<int> q; // 연결 되어있는지 탐색할 도시 리스트
    q.push(start);  // 초기 방문 도시 세팅
    visited[start] = true;


    while (!q.empty()) { // 더이상 연결된 도시가 없을 때까지 진행
        int current = q.front(); // 앞에서부터 1개씩 꺼내서 조사
        q.pop();

        for (int i = 0; i < graph.size(); i++) {
            if (graph[current][i] == 1 && !visited[i]) {
                visited[i] = true; // 방문한 도시는 이미 방문했다고 표시
                q.push(i); // 방문한 도시와 연결되어있는 도시 탐색 도시 리스트에 추가
                //(이미 방문한 건 if문에서 걸려서 추가 안됨)
            }
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;
    vector<vector<int>> graph(n, vector<int>(n));
    vector<int> plan(m);


    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> graph[i][j];
        }
    }

    for (int i = 0; i < m; i++) {
        cin >> plan[i];
        plan[i]--;


        vector<bool> visited(n, false);
        bfs(graph, visited, plan[0]);


        bool possible = true;
        for (int i = 1; i < m; i++) {
            if (!visited[plan[i]]) {
                possible = false;
                break;
            }
        }

        cout << (possible ? "YES" : "NO") << endl;

        return 0;
    }


    /*
    visited 배열: [F, F, F, F, F] (F: False)
    큐: []
    단계별 진행

    시작 (도시 1)

    visited: [T, F, F, F, F]
    큐: [1]


    1번 도시 처리

    연결된 도시: 2, 4
    visited: [T, T, F, T, F]
    큐: [2, 4]


    2번 도시 처리

    연결된 도시: 3 (1은 이미 방문)
    visited: [T, T, T, T, F]
    큐: [4, 3]


    4번 도시 처리

    연결된 도시: 5 (1은 이미 방문)
    visited: [T, T, T, T, T]
    큐: [3, 5]


    3번 도시 처리

    연결된 도시: 5 (이미 방문)
    visited: [T, T, T, T, T]
    큐: [5]


    5번 도시 처리

    연결된 도시: 모두 방문됨
    visited: [T, T, T, T, T]
    큐: []



    최종 상태

    모든 도시가 방문됨
    visited: [T, T, T, T, T]
    큐: 비어있음

    여행 계획 확인
    여행 계획: 1 -> 3 -> 5 -> 2

    1: 방문됨
    3: 방문됨
    5: 방문됨
    2: 방문됨

    결과: 모든 도시가 방문 가능하므로 "YES" 출력
    */
