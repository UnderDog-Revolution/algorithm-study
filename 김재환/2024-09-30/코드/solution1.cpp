#include <iostream>
#include <vector>
#include <queue>
using namespace std;

void bfs(const vector<vector<int>>& graph, vector<bool>& visited, int start) {
    queue<int> q; // ���� �Ǿ��ִ��� Ž���� ���� ����Ʈ
    q.push(start);  // �ʱ� �湮 ���� ����
    visited[start] = true;


    while (!q.empty()) { // ���̻� ����� ���ð� ���� ������ ����
        int current = q.front(); // �տ������� 1���� ������ ����
        q.pop();

        for (int i = 0; i < graph.size(); i++) {
            if (graph[current][i] == 1 && !visited[i]) {
                visited[i] = true; // �湮�� ���ô� �̹� �湮�ߴٰ� ǥ��
                q.push(i); // �湮�� ���ÿ� ����Ǿ��ִ� ���� Ž�� ���� ����Ʈ�� �߰�
                //(�̹� �湮�� �� if������ �ɷ��� �߰� �ȵ�)
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
    visited �迭: [F, F, F, F, F] (F: False)
    ť: []
    �ܰ躰 ����

    ���� (���� 1)

    visited: [T, F, F, F, F]
    ť: [1]


    1�� ���� ó��

    ����� ����: 2, 4
    visited: [T, T, F, T, F]
    ť: [2, 4]


    2�� ���� ó��

    ����� ����: 3 (1�� �̹� �湮)
    visited: [T, T, T, T, F]
    ť: [4, 3]


    4�� ���� ó��

    ����� ����: 5 (1�� �̹� �湮)
    visited: [T, T, T, T, T]
    ť: [3, 5]


    3�� ���� ó��

    ����� ����: 5 (�̹� �湮)
    visited: [T, T, T, T, T]
    ť: [5]


    5�� ���� ó��

    ����� ����: ��� �湮��
    visited: [T, T, T, T, T]
    ť: []



    ���� ����

    ��� ���ð� �湮��
    visited: [T, T, T, T, T]
    ť: �������

    ���� ��ȹ Ȯ��
    ���� ��ȹ: 1 -> 3 -> 5 -> 2

    1: �湮��
    3: �湮��
    5: �湮��
    2: �湮��

    ���: ��� ���ð� �湮 �����ϹǷ� "YES" ���
    */