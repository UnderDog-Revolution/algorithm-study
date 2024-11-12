//한 사람 기준, 맨해튼 거리 1,2에 해당하는 사람이 있다면 거리두기 규칙 위반
//사람이 한 명도 없는 대기실은 거리두기 규칙 준수
//하지만 파티션이 있다면, 거리두기 준수
//맨해튼 거리 1에 위치하는 사람을 찾기 위해서 상하좌우 검사
//맨해튼 거리 2에 위치하는 사람은, 사람좌표(x,y)의 상하좌우에 빈 테이블이 존재하고, 그 빈 테이블의 상하좌우에 위치하여야 존재 성립.
//즉, 맨해튼 거리 2에 위치하는 사람은 무조건 맨해튼거리 1 위치에 빈 테이블이 존재해야하고 그 빈테이블의 맨해튼 거리 1 위치에 존재해야 함.

class Solution {
    int[] answer = new int[5];
    
    //상하좌우를 표현하기 위한 좌표값
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
    
    public int[] solution(String[][] places) {
        for (int i = 0; i < 5; i++) {
            //사람이 있나 없나 체크, 한명도 없다면 거리두기 준수
            if (checkP(places[i])) {
                answer[i] = 1;
                continue;
            }
            //사람 있나 없나 체크하는 bool값
            boolean isSafe = true;
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    //사람이 있는 좌표에서 시작
                    if (places[i][x].charAt(y) == 'P') {
                        //맨해튼 거리 1 혹은 2에 위치한 사람을 찾는 중.
                        if (checkD_one(places[i], x, y) || checkD_two(places[i], x, y)) {
                            isSafe = false;
                            break;
                        }
                    }
                }
                //맨해튼 거리 1,2에 위치한 사람이 존재. 해당하는 대기실은 맨해튼 거리 위반
                if (!isSafe) break;
            }
            answer[i] = isSafe ? 1 : 0;
        }
        return answer;
    }
    
    //대기실에 사람이 한명도 없는지 체크하는 함수
    public boolean checkP(String[] room) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (room[i].charAt(j) == 'P') {
                    return false;
                }
            }
        }
        return true;
    }
    
    //대기실에 맨해튼 거리 1에 해당하는 사람이 존재하는지 찾기
    //사람이 있는 좌표의 상하좌우를 검사
    public boolean checkD_one(String[] room, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                if (room[nx].charAt(ny) == 'P') return true;
            }
        }
        return false;
    }
    
    //checkD_two함수 내에서 동작하는 함수
    //빈칸좌표의 상하좌우를 검사하여 사람이 2명이상 존재한다면(사람좌표 (x,y) 포함) 맨해튼 거리 2에 해당하는 사람이 존재한다는 뜻 
    public boolean checkP_count(String[] room, int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && room[nx].charAt(ny) == 'P') {
                count++;
            }
        }
        return count >= 2;
    }
    
    //맨해튼 거리 2에 해당하는 사람이 있는지 검사
    //사람이 있는 좌표의 상하좌우를 검사하고 빈칸이 있는 좌표를 찾는다.
    //빈칸의 상하좌우를 검사한다.
    public boolean checkD_two(String[] room, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && room[nx].charAt(ny) == 'O') {
                if (checkP_count(room, nx, ny)) return true;
            }
        }
        return false;
    }
}
