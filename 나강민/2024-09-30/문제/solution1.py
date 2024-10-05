import math

def kill_monsters(N, D, p, A):
    # 유효성 검사: N, D, p는 1 이상 100 이하, A[i]는 1 이상 100 이하
    if not (1 <= N <= 100) or not (1 <= D <= 100) or not (1 <= p <= 100):
        raise ValueError("N, D, and p must be between 1 and 100 inclusive.")
    if any(not (1 <= a <= 100) for a in A):
        raise ValueError("Each monster's health must be between 1 and 100 inclusive.")

    turns = 0  # 턴 수
    i = 0  # 현재 공격할 몬스터 인덱스
    
    while i < N:
        if A[i] > 0:
            # 첫 번째 몬스터에게 데미지 D를 줍니다.
            A[i] -= D
            turns += 1  # 턴 증가
            
            # 오버킬이 발생하면 다음 몬스터에게 데미지 전파
            if A[i] < 0:
                overkill = -A[i]  # 오버킬 양
                A[i] = 0  # 현재 몬스터는 죽음 처리
                
                # 다음 몬스터가 있으면 오버킬 데미지 전파
                if i + 1 < N:
                    # 오버킬 데미지의 p%를 계산하여 소수점 버림 처리
                    extra_damage = math.floor(overkill * p / 100)
                    A[i + 1] -= extra_damage
        
        # 체력이 0 이하인 몬스터는 넘어가고, 다음 몬스터로 이동
        if A[i] <= 0:
            i += 1
    
    return turns

# 입력 처리
def main():
    try:
        # 첫 줄 입력: 몬스터 수 N, 기본 대미지 D, 오버킬 비율 p
        N, D, p = map(int, input().split())
        
        # 각 몬스터들의 체력을 입력받는다
        A = list(map(int, input().split()))
        
        # 입력 값의 유효성 검사
        if len(A) != N:
            raise ValueError("The number of health values must match N.")
        
        # 모든 몬스터를 죽이기 위한 턴 수를 계산
        result = kill_monsters(N, D, p, A)
        
        # 결과 출력
        print(result)
    
    except ValueError as e:
        print("Invalid input:", e)

# 프로그램 실행
main()
