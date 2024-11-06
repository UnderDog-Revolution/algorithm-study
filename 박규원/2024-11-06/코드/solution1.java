import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int size =sc.nextInt();
            int[] arr = new int[size];
            int max=0;
            long sum=0;
            
            for(int i=0;i<size;i++){
                arr[i]=sc.nextInt();
            }         
            
            for(int i=size-1;i>=0;i--){
            	if(max<arr[i]) {
                	max=arr[i];
                    continue;
                }
                
                if(max>arr[i]){
                    sum+=(max-arr[i]);
                }
            }
            
            System.out.println("#" + test_case + " " + sum);
            sum=0;
            max=0;

		}
	}
}