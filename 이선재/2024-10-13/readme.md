1. 이 문제를 선택한 이유를 알려주세요(간단하게 설명해도 좋아요)
답) 저번주에 최소비용 구하기 문제를 풀어서 비슷한 문제를 풀어보고자 했습니다. 

2. 문제의 난이도는 어떻게 느껴지셨나요?
답) 저번주보단 수월하게 해결할 수 있었습니다. 

3. 문제를 처음 봤을 때 어떻게 접근하셨나요?
답) 기본적인 접근은 저번주와 같지만 거쳐간 도시의 수와 경로를 출력해야했기 때문에 최소비용을 갱신할 때마다 그 도시의 전 도시를 저장하는 리스트를 만들었습니다. 

4. 알고리즘 설계하는 데 걸린 시간은 어느 정도였나요?
답) 1시간 20분

5. 문제 해결 시 어려운 점이 있었나요? 있었다면, 어떻게 해결했나요?
답) 경로를 어떻게 저장할지 몰랐었는데, 열심히 생각하다가 이전 도시를 저장하면 되겠다는 생각이 들었습니다. 

6. 코드의 주요 부분을 간단히 설명해주세요
답) line 43 ~ 46 : 더 짧은 경로가 등장했을 때, 해당 도시로 이동하기 전에 거쳐간 도시를 저장
line 49 ~ 54 : 저장된 previous 도시를 기반으로 path 구하기

7. 코드를 최적화 했다면 어떤 목적으로 최적화를 하셨나요?
답) input = sys.stdin.readline()으로 입력 시간 줄이기

8. 코드를 테스트 할 때 어떤 케이스를 고려했나요?
답) 문제의 입력은 n, m의 범위가 정해져있고 경로가 있는 시작점과 도착점만 주어진다고 하였지만, 예외 처리와 유효성 검사를 연습하기 위해 저번 주 피드백을 바탕으로 n, m의 범위와 start, end의 범위를 고려. 경로가 존재하지 않을 경우 역시 고려. 