1. 이 문제를 선택한 이유를 알려주세요(간단하게 설명해도 좋아요)
   답) 오랜만에 알고리즘을 풀어서 간단한 DFS, BFS부터 시작하려고 선택하였습니다

2. 문제의 난이도는 어떻게 느껴지셨나요?
   답) 중간정도로 느껴졌습니다

3. 문제를 처음 봤을 때 어떻게 접근하셨나요?
   답) 문제 이름이 DFS, BFS라서 접근을 고민할 필요는 없었습니다

4. 알고리즘 설계하는 데 걸린 시간은 어느 정도였나요?
   답) 3~40분 걸린 것 같습니다..!

5. 문제 해결 시 어려운 점이 있었나요? 있었다면, 어떻게 해결했나요?
   답) node 에서 인풋 받는게 제일 어려웠던 것 같습니다

6. 코드의 주요 부분을 간단히 설명해주세요
   답) 1260.js 7번째 줄에서 정점 인접 리스트를 먼저 만들고, 13번째 줄에서 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문해야 한다는 조건이 있기 떄문에 리스트를 정렬습니다. 22번째줄 dfs에서 go 함수를 써서 이웃이 없으면 루프를 나가고 이웃이 있으면 go를 재귀로 사용하여 일단 방문하고 result배열에 방문한 것 푸쉬 및 visited를 true로 설정해서 다시 방문하지 않게 하였습니다. BFS에서는 재귀를 사용하지 않고 44번째 줄 while문을 사용하여 한 노드의 이웃을 다 방문하고 그 다음노드를 조사하게 했습니다.

7. 코드를 최적화 했다면 어떤 목적으로 최적화를 하셨나요?
   답)

8. 코드를 테스트 할 때 어떤 케이스를 고려했나요?
   답) 예전에 배운 기억을 더듬어서 풀었습니다 ,,
