import java.util.Scanner;

public class algo1788{
    private static final int MOD = 1_000_000_000;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt(); // n 입력 받기
        int P_N; // 양수인지 음수인지 판별하는 변수

        int result; // 결과값
        if(input > 0){
            result = P_fibonacci(input); // 양수일 경우 피보나치 수 계산
            P_N = 1; // 양수
        }
        else if(input == 0){
            result = 0; // 0일 경우 0
            P_N = 0; // 0
        }
        else{
            result = N_fibonacci(input); // 음수일 경우 피보나치 수 계산
            if(input % 2 == 0) P_N = -1; // 음의 피보나치의 경우 짝수일 때 음수가 나오고 홀수일 때 양수가 나오므로 짝수일 경우 -1, 홀수일 경우 1
              else P_N = 1;
        }
        System.out.println(P_N); // 양수인지 음수인지 출력
        System.out.println(result); // 피보나치 수 출력

        sc.close();
    }

    public static int P_fibonacci(int n){ // 양수일 경우 피보나치 수 계산
        if(n == 0) return 0;
        if(n == 1) return 1;
        int a = 0, b = 1;
        for(int i = 2; i <= n; i++){
            int temp = (a + b) % MOD; // temp에 합연산 결과(f(n)) 저장
            a = b; // a의 값에 f(n-1)의 값 저장
            b = temp; // b의 값에 f(n)의 값 저장
        }
        return b;
    }

    public static int N_fibonacci(int n){ // 음수일 경우 피보나치 수 계산
        n = -n;
        if(n == 0) return 0;
        if(n == 1) return 1;
        int a = 0, b = 1;
        for(int i = 2; i <= n; i++){
            int temp = (a - b) % MOD; // temp에 차연산 결과(f(n)) 저장
            a = b; // a의 값에 f(n-1)의 값 저장
            b = temp; // b의 값에 f(n)의 값 저장
        }
        return Math.abs(b); // 절댓값 반환
    }
}   

